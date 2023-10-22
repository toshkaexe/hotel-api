package hotel.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Pokemon {
    private int id;
    private String name;
    private String imageUrl;
    private List<String> types;
    private List <String> abilitiesInEN;
    private List <String> abilitiesInDE;


}
