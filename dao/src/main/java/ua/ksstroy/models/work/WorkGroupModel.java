package ua.ksstroy.models.work;

import ua.ksstroy.models.worktype.WorkTypeModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "work_groups", catalog = "ksstroy")
public class WorkGroupModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_type_id")
    private WorkTypeModel type;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_group_id")
    @OrderBy
    private List<WorkModel> works;

    @OneToMany(cascade = { CascadeType.ALL })
    @JoinColumn(name = "parent_id")
    @OrderBy
    private List<WorkGroupModel> groups;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private WorkGroupModel workGroupModel;

    public WorkGroupModel() {}

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

    public WorkTypeModel getType() {
        return type;
    }

    public void setType(WorkTypeModel type) {
        this.type = type;
    }

    public List<WorkGroupModel> getGroups() {
        return groups;
    }

    public void setGroups(List<WorkGroupModel> groups) {
        this.groups = groups;
    }

    public List<WorkModel> getWorks() {
        return works;
    }

    public void setWorks(List<WorkModel> works) {
        this.works = works;
    }

    public WorkGroupModel getWorkGroupModel() {
        return workGroupModel;
    }

    public void setWorkGroupModel(WorkGroupModel workGroupModel) {
        this.workGroupModel = workGroupModel;
    }
}
