package test;

import controller.JsonManager;
import model.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonManagerTest {

    @Test
    public void testJsonSerializationAndDeserialization() throws IOException {
        // Створення тестового університету
        University oldUniversity = createTestUniversity();

        // Збереження університету в JSON
        String filePath = "test_university.json";
        JsonManager.writeToJsonFile(filePath, oldUniversity);

        // Зчитування університету з JSON
        University newUniversity = JsonManager.readFromJsonFile(filePath);

        // Перевірка, чи університети еквівалентні
        assertEquals(oldUniversity, newUniversity);
    }

    private University createTestUniversity() {
        // Створення тестового університету з факультетами, групами та студентами
        Human rector = new Human("John", "Doe", "Michael", Sex.MALE);
        University university = new University("Test University", rector);

        Human dean1 = new Human("Alice", "Smith", "Anne", Sex.FEMALE);
        Human dean2 = new Human("Bob", "Brown", "James", Sex.MALE);

        Faculty faculty1 = new Faculty("Engineering", dean1);
        Faculty faculty2 = new Faculty("Science", dean2);

        Group group1 = new Group("ENG-101", new Human("Tom", "White", "Andrew", Sex.MALE));
        Group group2 = new Group("ENG-102", new Human("Emma", "Green", "Marie", Sex.FEMALE));
        Group group3 = new Group("SCI-201", new Human("Jack", "Grey", "Paul", Sex.MALE));
        Group group4 = new Group("SCI-202", new Human("Rose", "Blue", "Alice", Sex.FEMALE));

        group1.addStudent(new Student("Peter", "Black", "Alexander", Sex.MALE));
        group1.addStudent(new Student("Lucy", "Red", "Elizabeth", Sex.FEMALE));

        group2.addStudent(new Student("James", "Silver", "David", Sex.MALE));
        group2.addStudent(new Student("Anna", "Orange", "Sophia", Sex.FEMALE));

        group3.addStudent(new Student("Michael", "Brown", "George", Sex.MALE));
        group3.addStudent(new Student("Olivia", "Yellow", "Emily", Sex.FEMALE));

        group4.addStudent(new Student("Ethan", "Violet", "Henry", Sex.MALE));
        group4.addStudent(new Student("Charlotte", "Pink", "Lily", Sex.FEMALE));

        faculty1.setGroups(Arrays.asList(group1, group2));
        faculty2.setGroups(Arrays.asList(group3, group4));

        university.setFaculties(Arrays.asList(faculty1, faculty2));

        return university;
    }
}
