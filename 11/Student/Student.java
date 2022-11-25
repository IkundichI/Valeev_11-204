package Student;

import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Student {
    public String name;
    public int age;
    public int weigt;
    public String groupNum;
    public int course;
    public List<Course> courses;

    public Student(String name, int age, int weigt, String groupNum, int course, List<Course> courses) {
        this.name = name;
        this.age = age;
        this.weigt = weigt;
        this.groupNum = groupNum;
        this.course = course;
        this.courses = courses;
    }
    @Override
    public String toString() {
        return name + " " + age + " " + weigt + " " + groupNum + " " + course + " " + courses;
    }
}
