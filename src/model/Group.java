package model;

import java.util.ArrayList;
import java.util.List;

public class Group extends Department {
    private List<Student> students = new ArrayList<>();

    public Group(String name, Human head) {
        super(name, head);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }
}
