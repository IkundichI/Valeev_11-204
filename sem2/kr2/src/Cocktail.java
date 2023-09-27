import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Cocktail {
    public String idDrink;
    public String strDrink;
    public String strGlass;
    public String strIngredient1;
    public String strIngredient2;
    public String strIngredient3;
    public String strIngredient4;
    public String strIngredient5;
    public String strIngredient6;

    public Cocktail() {
    }

    public Cocktail(String idDrink, String strDrink, String strGlass, String strIngredient1, String strIngredient2,
                    String strIngredient3, String strIngredient4, String strIngredient5, String strIngredient6) {
        this.idDrink = idDrink;
        this.strDrink = strDrink;
        this.strGlass = strGlass;
        this.strIngredient1 = strIngredient1;
        this.strIngredient2 = strIngredient2;
        this.strIngredient3 = strIngredient3;
        this.strIngredient4 = strIngredient4;
        this.strIngredient5 = strIngredient5;
        this.strIngredient6 = strIngredient6;
    }

    @Override
    public String toString() {
        return strDrink + " - " + strGlass;
    }
}