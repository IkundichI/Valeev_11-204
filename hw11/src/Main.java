public class Main {
    public static void main(String[] args) throws Exception {
        User example = new User("777", "Azat");
        boolean isValid = CheckValueAnnotationValidator.isValid(example);
        System.out.println("Is valid: " + isValid);
    }
}
