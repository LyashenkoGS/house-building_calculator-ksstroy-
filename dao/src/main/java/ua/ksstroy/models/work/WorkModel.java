package ua.ksstroy.models.work;

import ua.ksstroy.models.worktype.WorkTypeModel;
import ua.ksstroy.models.zone.ZonesModel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "works", catalog = "ksstroy")
public class WorkModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "work_id", unique = true, nullable = false)
    private String id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_type_id")
    private WorkTypeModel type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zone_id")
    private ZonesModel zonesModel;

    /*@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "work_zone_rel", catalog = "ksstroy", joinColumns = {
            @JoinColumn(name = "work_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "zone_id",
                    nullable = false, updatable = false)})
    private List<ZonesModel> workZones;*/

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "work_id")
    @OrderBy
    private List<CoverModel> allCovers;

    @Column(name = "planed_cost")
    private Double planedCost;

    @Column(name = "perspective_cost")
    private Double perspectiveCost;

    @Column(name = "closed_cost")
    private Double closedCost;

    @Column(name = "deal_cost")
    private Double dealCost;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "work_id")
    @OrderBy
    private List<AdjustmentModel> adjustments;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_group_id")
    private WorkGroupModel workGroupModel;

    public WorkModel() {
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

    public WorkTypeModel getType() {
        return type;
    }

    public void setType(WorkTypeModel type) {
        this.type = type;
    }

    public ZonesModel getZonesModel() {
        return zonesModel;
    }

    public void setZonesModel(ZonesModel zonesModel) {
        this.zonesModel = zonesModel;
    }

    /*public List<ZonesModel> getWorkZones() {
        return workZones;
    }

    public void setWorkZones(List<ZonesModel> workZones) {
        this.workZones = workZones;
    }*/

    public List<CoverModel> getAllCovers() {
        return allCovers;
    }

    public void setAllCovers(List<CoverModel> allCovers) {
        this.allCovers = allCovers;
    }

    public Double getPlanedCost() {
        return planedCost;
    }

    public void setPlanedCost(Double planedCost) {
        this.planedCost = planedCost;
    }

    public Double getPerspectiveCost() {
        return perspectiveCost;
    }

    public void setPerspectiveCost(Double perspectiveCost) {
        this.perspectiveCost = perspectiveCost;
    }

    public Double getClosedCost() {
        return closedCost;
    }

    public void setClosedCost(Double closedCost) {
        this.closedCost = closedCost;
    }

    public Double getDealCost() {
        return dealCost;
    }

    public void setDealCost(Double dealCost) {
        this.dealCost = dealCost;
    }

    public List<AdjustmentModel> getAdjustments() {
        return adjustments;
    }

    public void setAdjustments(List<AdjustmentModel> adjustments) {
        this.adjustments = adjustments;
    }

    public WorkGroupModel getWorkGroupModel() {
        return workGroupModel;
    }

    public void setWorkGroupModel(WorkGroupModel workGroupModel) {
        this.workGroupModel = workGroupModel;
    }
}
