package model;

import java.util.ArrayList;
import java.util.List;

public class Faculty extends Department {
    private List<Group> groups = new ArrayList<>();

    public Faculty(String name, Human head) {
        super(name, head);
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public List<Group> getGroups() {
        return groups;
    }
}
