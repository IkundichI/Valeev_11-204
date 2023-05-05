import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;

public class CatFactPerformerTest {

    public static CatFactPerformer catFactPerformer;
    public static ApiRequestExecutor apiRequestExecutor;

    @BeforeAll
    public static void init(){
        apiRequestExecutor = Mockito.mock(ApiRequestExecutor.class);
        catFactPerformer = new CatFactPerformer();
    }

    @Test
    public void testCatFactPerformer() throws Exception{
        List<CatFact> catFacts = new ArrayList<>();
        catFacts.add(new CatFact("fact1"));
        catFacts.add(new CatFact("fact2"));
        Mockito.when(apiRequestExecutor.getCatFactsFromApi(Mockito.anyString())).thenReturn(catFacts);
        CatFactGetter catFactGetter = Mockito.mock(CatFactGetter.class);
        Mockito.doNothing().when(catFactGetter).getCatFacts(catFacts);
        catFactPerformer.catToPrettyFormat("https://cat-fact.herokuapp.com/facts");
        Mockito.verify(catFactGetter, Mockito.times(1)).getCatFacts(catFacts);
    }
}
