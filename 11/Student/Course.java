package Student;

public class Course {
    String course;
    String description;

    public Course(String course, String description) {
        this.course = course;
        this.description = description;
    }

    @Override
    public String toString() {
        return course + " -> " + description;
    }
}
