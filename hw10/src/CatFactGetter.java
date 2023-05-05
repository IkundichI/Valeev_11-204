import java.util.List;

public class CatFactGetter {

    public void getCatFacts(List<CatFact> catFacts) {
        int count = 1;
        for (CatFact catFact : catFacts) {
            System.out.println("Fact " + count + " " + catFact.getText());
            count++;
        }

    }
}