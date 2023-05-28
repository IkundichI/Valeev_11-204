import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws Exception{

        InputStream inputStream = new FileInputStream("drinks.txt");
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        String json = new String(bytes);
        Drink drink = new ObjectMapper().readValue(json, new TypeReference<>(){});


        List<Cocktail> cocktailList = Arrays.asList(drink.drinks);
        List<Cocktail> cocktailList1 = cocktailList.stream().filter(cocktail -> isCocktail(cocktail)).collect(Collectors.toList());
        String filename = "cock.txt";
        BufferedWriter writerInsert = new BufferedWriter(new FileWriter(filename));
        for (int i = 0; i < cocktailList1.size(); i++) {
            writerInsert.write(i + 1 + " - " + cocktailList1.get(i) + "\n");
        }
        writerInsert.close();




    }
    public static boolean isCocktail(Cocktail cocktail){
        if (cocktail.strIngredient1 != null && cocktail.strIngredient1.equals("Salt")) {
            return false;
        }
        if (cocktail.strIngredient2 != null && cocktail.strIngredient2.equals("Salt")) {
            return false;
        }
        if (cocktail.strIngredient3 != null && cocktail.strIngredient3.equals("Salt")) {
            return false;
        }
        if (cocktail.strIngredient4 != null && cocktail.strIngredient4.equals("Salt")) {
            return false;
        }
        if (cocktail.strIngredient5 != null && cocktail.strIngredient5.equals("Salt")) {
            return false;
        }
        if (cocktail.strIngredient6 != null && cocktail.strIngredient6.equals("Salt")) {
            return false;
        }
        return true;
    }


}