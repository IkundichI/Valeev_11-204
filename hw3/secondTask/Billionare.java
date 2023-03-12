package hw1.secondTask;


public class Billionare {
    public int rank;
    public String personName;
    public int age;
    public int finalWorth;
    public String category;
    public String source;
    public String country;
    public String state;
    public String city;
    public String organization;
    public boolean selfMade;
    public String gender;
    public String birthDate;
    public String title;
    public int philanthropyScore;

    @Override
    public String toString() {
        return "Billionare{" +
                "rank=" + rank +
                ", personName='" + personName + '\'' +
                ", age=" + age +
                ", finalWorth=" + finalWorth +
                ", category='" + category + '\'' +
                ", source='" + source + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", organization='" + organization + '\'' +
                ", selfMade=" + selfMade +
                ", gender='" + gender + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", title='" + title + '\'' +
                ", philanthropyScore=" + philanthropyScore +
                '}';
    }

    public Billionare(int rank, String personName, int age, int finalWorth, String category,
                      String source, String country, String state, String city, String organization,
                      boolean selfMade, String gender, String birthDate, String title, int philanthropyScore) {
        this.rank = rank;
        this.personName = personName;
        this.age = age;
        this.finalWorth = finalWorth;
        this.category = category;
        this.source = source;
        this.country = country;
        this.state = state;
        this.city = city;
        this.organization = organization;
        this.selfMade = selfMade;
        this.gender = gender;
        this.birthDate = birthDate;
        this.title = title;
        this.philanthropyScore = philanthropyScore;
    }
}

