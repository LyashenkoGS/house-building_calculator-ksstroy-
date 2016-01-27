package ua.ksstroy.models.zone;

import ua.ksstroy.logic.zonegroup.Measure;
import ua.ksstroy.models.work.WorkModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@SuppressWarnings("serial")
@Entity
@Table(name = "zones", catalog = "ksstroy")
public class ZonesModel implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "width")
    private Double width;

    @Column(name = "height")
    private Double height;

    @Column(name = "mesure_name")
    private String measureName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_group_id")
    private GroupsModel groupIdForZone;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "addit_for_zones_id")
    private Set<ZonesModel> additionalZone = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "addit_for_zones_id")
    private ZonesModel additZoneToRootZone;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "surplus_for_zones_id")
    private Set<ZonesModel> surplusZone = new LinkedHashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "surplus_for_zones_id")
    private ZonesModel surplusZoneToRootZone;

    /*@ManyToMany(fetch = FetchType.LAZY, mappedBy = "workZones")
    private List<WorkModel> works;*/

    public ZonesModel() {

    }

    public ZonesModel(String name, Double width, Double height, Measure measureName) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.measureName = measureName.toString();
    }


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

    public Double getWidth() {
        return width;
    }

    public void setWidth(Double width) {
        this.width = width;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public String getMeasureName() {
        return measureName;
    }

    public void setMeasureName(Measure measureName) {
        this.measureName = measureName.toString();
    }

    public Set<ZonesModel> getAdditionalZone() {
        return additionalZone;
    }

    public void setAdditionalZone(Set<ZonesModel> additionalZone) {
        this.additionalZone = additionalZone;
    }

    public Set<ZonesModel> getSurplusZone() {
        return surplusZone;
    }

    public void setSurplusZone(Set<ZonesModel> surplusZone) {
        this.surplusZone = surplusZone;
    }

    /*public List<WorkModel> getWorks() {
        return works;
    }

    public void setWorks(List<WorkModel> works) {
        this.works = works;
    }*/

    public GroupsModel getGroupIdForZone() {
        return groupIdForZone;
    }

    public void setGroupIdForZone(GroupsModel groupIdForZone) {
        this.groupIdForZone = groupIdForZone;
    }
}