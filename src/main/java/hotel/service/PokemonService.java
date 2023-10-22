package hotel.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import hotel.dto.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService {
    Logger log = LoggerFactory.getLogger(getClass());
    private static final String POKEAPI_BASE_URL = "https://pokeapi.co/api/v2/pokemon/";

    public Pokemon getPokemonById(String id) throws Exception {

        final String pokemonURL_ID = POKEAPI_BASE_URL + id;

        String jsonResponse = getRequestToURL(pokemonURL_ID);

        try {

            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonResponse);


            List<String> typeList = collectItemsToArray(jsonResponse, "types", "type", "name");

            List<String> abilityListEN = collectItemsToArray(jsonResponse, "abilities", "ability", "name");
            List<String> abilityListDE = collectAbilitiesInGerman(jsonResponse,"abilities", "ability");
            Pokemon pokemonById = new Pokemon().builder()
                    .id(jsonNode.get("id").asInt())
                    .name(getCapitalizedFirstCharacter(jsonNode.get("name").textValue()))
                    .imageUrl(extractImageUrl(jsonResponse))
                    .types(typeList)
                    .abilitiesInEN(abilityListEN)
                    .abilitiesInDE(abilityListDE).build();


            log.info(String.format("Pokemon: [id=%d],[name=%s],[image=%s],[types=%s],[abilitiesInEN=%s],[abilitiesInDE=%s]",
                    pokemonById.getId(),
                    pokemonById.getName(),
                    pokemonById.getImageUrl(),
                    pokemonById.getTypes(),
                    pokemonById.getAbilitiesInEN(),
                    pokemonById.getAbilitiesInDE()));

            return pokemonById;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String extractImageUrl(String json) {
        String imageUrl = null;

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(json);
            JsonNode sprites = rootNode.get("sprites");
            if (sprites != null) {
                JsonNode other = sprites.get("other");
                if (other != null) {
                    JsonNode dreamWorld = other.get("dream_world");
                    if (dreamWorld != null) {
                        imageUrl = dreamWorld.get("front_default").asText();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return imageUrl;
    }

    public static List<String> collectItemsToArray(String json, String root, String item, String name) {
        List<String> abilitiesList = new ArrayList<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(json);
            JsonNode abilitiesArray = rootNode.get(root);
            if (abilitiesArray.isArray()) {
                for (JsonNode abilityNode : abilitiesArray) {
                    JsonNode ability = abilityNode.get(item);
                    String abilityName = ability.get(name).asText();
                    abilitiesList.add(abilityName);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return abilitiesList;
    }


    public static String getRequestToURL(String urlToRead) throws Exception {
        StringBuilder result = new StringBuilder();
        URL url = new URL(urlToRead);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            for (String line; (line = reader.readLine()) != null; ) {
                result.append(line);
            }
        }
        return result.toString();
    }

    public static List<String> collectAbilitiesInGerman(String json, String root, String item) {

        List<String> abilitiesList = new ArrayList<>();

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(json);
            JsonNode abilitiesArray = rootNode.get(root);
            if (abilitiesArray.isArray()) {
                for (JsonNode abilityNode : abilitiesArray) {
                    JsonNode ability = abilityNode.get(item);
                    String abilityUrl = ability.get("url").asText();

                    String abilityInGerman = getAbilityinGerman(abilityUrl);

                    abilitiesList.add(abilityInGerman);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return abilitiesList;
    }

    public static String getAbilityinGerman(String abilityUrl) throws Exception {
        String abilityUrlMetaData = getRequestToURL(abilityUrl);
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode1 = objectMapper.readTree(abilityUrlMetaData);

        JsonNode names = rootNode1.get("names");

        if (names != null) {
            for (JsonNode name1 : names) {
                JsonNode language = name1.get("language");
                if (language != null && "de".equals(language.get("name").asText())) {
                    return name1.get("name").asText();

                }
            }
        }
        return null;
    }

    public static String getCapitalizedFirstCharacter(String inputString) {
        String firstChar = inputString.substring(0, 1).toUpperCase();
        String capitalizedString = firstChar + inputString.substring(1);

        return capitalizedString;
    }

}
