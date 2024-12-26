package model;

import java.util.Objects;

public class Human {
    private String firstName;
    private String lastName;
    private String middleName;
    private Sex gender;

    public Human(String firstName, String lastName, String middleName, Sex gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.gender = gender;
    }

    public String getFullName() {
        return firstName + " " + lastName + " " + middleName;
    }

    public Sex getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human)) return false;
        Human human = (Human) o;
        return Objects.equals(getFullName(), human.getFullName()) &&
                gender == human.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFullName(), gender);
    }
}

