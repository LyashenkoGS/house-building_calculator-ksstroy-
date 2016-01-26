package ua.ksstroy.logic.work;

import ua.ksstroy.logic.worktype.WorkType;

import java.util.List;

public class WorkGroupImpl implements WorkGroup {

    private String id;

    private String name;

    private WorkType type;

    private List<WorkGroup> groups;

    private List<Work> works;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public List<WorkGroup> getGroups() {
        return groups;
    }

    @Override
    public void setGroups(List<WorkGroup> groups) {
        this.groups = groups;
    }

    @Override
    public List<Work> getWork() {
        return works;
    }

    @Override
    public void setWork(List<Work> works) {
        this.works = works;
    }

    @Override
    public WorkType getWorkType() {
        return this.type;
    }

    @Override
    public void setWorkType(WorkType workType) {
        this.type = workType;
    }

}