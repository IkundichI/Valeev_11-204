import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ApiRequestExecutor {
    public List<CatFact> getCatFactsFromApi(String url) throws IOException {
        URLConnection urlConnection = new URL(url).openConnection();
        ObjectMapper objectMapper = new ObjectMapper();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
        InputStream inputStream = urlConnection.getInputStream();
        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        String json = new String(bytes);
        CatFact[] catArray = objectMapper.readValue(json, CatFact[].class);
        return Arrays.asList(catArray);

    }
}