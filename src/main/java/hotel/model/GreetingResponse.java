package hotel.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GreetingResponse {
	String greeting;
}
