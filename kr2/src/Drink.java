import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data

@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Drink {
    public Cocktail[] drinks;

    public Drink() {
    }

    public Drink(Cocktail[] drinks) {
        this.drinks = drinks;
    }
}