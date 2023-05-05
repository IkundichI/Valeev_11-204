


public class Main {
    public static void main(String[] args) throws Exception {
        String utrInStringFormat = "https://cat-fact.herokuapp.com/facts";
        CatFactPerformer catFactPerformer = new CatFactPerformer();
        catFactPerformer.catToPrettyFormat(utrInStringFormat);
    }

}
