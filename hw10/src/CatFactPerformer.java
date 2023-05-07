import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CatFactPerformer {
    CatFactGetter catFactGetter = new CatFactGetter();
    ApiRequestExecutor apiRequestExecutor = new ApiRequestExecutor();

    public String catToPrettyFormat() throws IOException {
        String json = apiRequestExecutor.getCatFactsFromApi("https://cat-fact.herokuapp.com/facts");
        ObjectMapper objectMapper = new ObjectMapper();
        CatFact[] catArray = objectMapper.readValue(json, CatFact[].class);
        return catFactGetter.getCatFacts(Arrays.asList(catArray));
    }

    public CatFactGetter getCatFactGetter() {
        return catFactGetter;
    }

    public void setCatFactGetter(CatFactGetter catFactGetter) {
        this.catFactGetter = catFactGetter;
    }

    public ApiRequestExecutor getApiRequestExecutor() {
        return apiRequestExecutor;
    }

    public void setApiRequestExecutor(ApiRequestExecutor apiRequestExecutor) {
        this.apiRequestExecutor = apiRequestExecutor;
    }
}