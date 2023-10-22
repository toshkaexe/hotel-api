package hotel.controller;

import hotel.dto.Pokemon;
import hotel.model.Room;
import hotel.model.StaffMember;
import hotel.service.PokemonService;
import hotel.service.RoomService;
import hotel.service.StaffService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import hotel.model.GreetingResponse;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class HotelApiController {
    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private PokemonService pokemonService;

    @Autowired
    private RoomService roomService;

    @Autowired
    private StaffService staffService;


    @RequestMapping("/")
    public GreetingResponse greeting() {
        return GreetingResponse.builder().greeting("To have a list with 10 polekoms please use" +
                " http://localhost:8080/pokemonlist10").build();
    }

    /*
     * This function returns a list of the first 10 number of pokémon.
     * GET http://localhost:8080/pokemonlist10
     *
     */
    @RequestMapping("/pokemonlist10")
    public ResponseEntity<List<Pokemon>> listFirst10Pokemons() {
        List<Pokemon> pokemonList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            try {
                pokemonList.add(pokemonService.getPokemonById(String.valueOf(i)));
            } catch (Exception e) {
                log.error("Error while fetching Pokémon list of 10 Pokemons.", e);
            }
        }
        return ResponseEntity
                .status(HttpStatus.OK).body(pokemonList);
    }

    /*
     * This function returns a list of the first totalNumber number of pokémon.
     * Example: GET http://localhost:8080/pokemonlist/10
     */
    @RequestMapping(value = "pokemonlist/{totalNumber}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Pokemon>> listFirstNPokemons(@PathVariable int totalNumber) {
        List<Pokemon> pokemonList = new ArrayList<>();
        if (totalNumber > 0) {
            for (int i = 1; i <= totalNumber; i++) {
                try {
                    pokemonList.add(pokemonService.getPokemonById(String.valueOf(i)));
                } catch (Exception e) {
                    log.error("Error while fetching Pokémon list.", e);
                }
            }
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(pokemonList);
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new ArrayList<>());
    }

    /*
     * This function returns data about a single pokémon based on its ID
     * Example: GET http://localhost:8080/pokemon/5
     */
    @RequestMapping(value = "pokemon/{id}", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<Pokemon> getPokemonDetails(@PathVariable String id) {
        try {
            return
                    ResponseEntity
                            .status(HttpStatus.OK)
                            .body(
                                    pokemonService.getPokemonById(id));
        } catch (Exception e) {
            log.error("Error while fetching Pokémon details for ID: " + id, e);
            return null;
        }
    }
    @RequestMapping(value = "/rooms")
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }


    @RequestMapping(value = "/staff")
    public List<StaffMember> getAllStaff() {
        return staffService.getAllStaff();
    }
    /*
     * This function for all other endpoints
     */
    @RequestMapping("/**")
    public ResponseEntity<String> handleBadRequests() {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Bad Request: Invalid endpoint");
    }
}
