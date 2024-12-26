package main;

import controller.*;
import model.*;

public class Run {
    public static void main(String[] args) {
        createTypicalUniversity();
    }

    public static void createTypicalUniversity() {
        // Створення ректора університету
        Human rector = new Human("John", "Doe", "Michael", Sex.MALE) {};

        // Створення університету
        University university = UniversityCreator.createUniversity("National Technical University", rector);

        // Створення факультету
        Human facultyHead = new Human("Jane", "Smith", "Anne", Sex.FEMALE) {};
        Faculty faculty = FacultyCreator.createFaculty("Faculty of Computer Science", facultyHead);

        // Створення групи
        Human groupHead = new Human("Alice", "Brown", "Marie", Sex.FEMALE) {};
        Group group = GroupCreator.createGroup("CS-101", groupHead);

        // Додавання студентів
        group.addStudent(StudentCreator.createStudent("Peter", "White", "Alexander", Sex.MALE));
        group.addStudent(StudentCreator.createStudent("Lucy", "Green", "Elizabeth", Sex.FEMALE));

        // Додавання групи до факультету
        faculty.addGroup(group);

        // Додавання факультету до університету
        university.addFaculty(faculty);

        // Виведення структури університету
        System.out.println("University: " + university.getName());
        for (Faculty fac : university.getFaculties()) {
            System.out.println("  Faculty: " + fac.getName());
            for (Group grp : fac.getGroups()) {
                System.out.println("    Group: " + grp.getName());
                for (Student stu : grp.getStudents()) {
                    System.out.println("      Student: " + stu);
                }
            }
        }
    }
}
