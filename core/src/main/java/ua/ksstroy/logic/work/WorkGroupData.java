package ua.ksstroy.logic.work;

import java.util.List;

public class WorkGroupData {

    private String id;

    private String name;

    private List<WorkGroupData> groups;

    private List<WorkData> works;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<WorkGroupData> getGroups() {
        return groups;
    }

    public void setGroups(List<WorkGroupData> groups) {
        this.groups = groups;
    }

    public List<WorkData> getWorks() {
        return works;
    }

    public void setWorks(List<WorkData> works) {
        this.works = works;
    }

}