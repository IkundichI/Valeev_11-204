import java.io.IOException;

public class CatFactPerformer {
    public void catToPrettyFormat(String url) throws IOException {
        CatFactGetter catFactGetter = new CatFactGetter();
        ApiRequestExecutor apiRequestExecutor = new ApiRequestExecutor();
        catFactGetter.getCatFacts(apiRequestExecutor.getCatFactsFromApi(url));
    }

}