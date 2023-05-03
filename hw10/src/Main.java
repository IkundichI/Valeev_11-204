import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws Exception {
        String utrInStringFormat = "https://cat-fact.herokuapp.com/facts";
        CatFactPerformer.catToPrettyFormat(utrInStringFormat);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CatFact {
        private String text;

        public String getText() {
            return text;
        }
    }

    public static class CatFactGetter {

        public static void getCatFacts(List<CatFact> catFacts) {
            int count = 1;
            for (CatFact catFact : catFacts) {
                System.out.println("Fact " + count + " -> " + catFact.getText());
                count++;
            }

        }
    }

    public static class ApiRequestExecutor {
        public static List<CatFact> getCatFactsFromApi(String url) throws IOException {
            URLConnection urlConnection = new URL(url).openConnection();
            ObjectMapper objectMapper = new ObjectMapper();
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
            InputStream inputStream = urlConnection.getInputStream();
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);
            String json = new String(bytes);
            CatFact[] catArray = objectMapper.readValue(json, CatFact[].class);
            return Arrays.stream(catArray).toList();

        }
    }

    public static class CatFactPerformer {
        public static void catToPrettyFormat(String url) throws IOException {
            CatFactGetter.getCatFacts(ApiRequestExecutor.getCatFactsFromApi(url));
        }

    }

}
