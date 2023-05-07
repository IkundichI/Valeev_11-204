import java.util.List;

public class CatFactGetter {

    public String getCatFacts(List<CatFact> catFacts) {
        int count = 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (CatFact catFact : catFacts) {
            stringBuilder.append("Fact " + count + " " + catFact.getText() + "\n");
            count++;
        }
        return stringBuilder.toString();

    }
}