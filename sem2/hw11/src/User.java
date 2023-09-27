public class User {
    @CheckValue(regex = "\\d{3}") //Любые 4 цифры
    private String id;

    @CheckValue(regex = "[A-Z][a-z]*") //Любые буквы
    private String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
