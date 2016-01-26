package ua.ksstroy.logic.work;

import ua.ksstroy.logic.material.MaterialImpl;
import ua.ksstroy.logic.worktype.WorkType;
import ua.ksstroy.logic.zonegroup.Zone;

import java.util.List;

public class WorkImpl implements Work {

    private String id;

    private String name;

    private WorkType type;

    private List<Zone> workZones;

    private List<Cover> allCovers;

    private Double planedCost;

    private Double perspectiveCost;

    private Double closedCost;

    private Double dealCost;

    private List<Adjustment> adjustments;

    @Override
    public WorkType getType() {

        return type;
    }

    @Override
    public void setType(WorkType type) {

        this.type = type;
    }

    @Override
    public List<Zone> getWorkZones() {

        return workZones;
    }

    @Override
    public void setWorkZones(List<Zone> workZones) {
        this.workZones = workZones;

    }

    @Override
    public List<Cover> getAllCovers() {
        return allCovers;
    }

    @Override
    public void setAllCovers(List<Cover> allCovers) {
        this.allCovers = allCovers;

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
    public String getName() {
        // TODO Auto-generated method stub
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;

    }

    @Override
    public Double getPlanedCost() {
        double costForAllMaterials = 0;
        double valueForAllZones = 0;

        List<MaterialImpl> listMaterials = type.getMaterials();

        for (int i = 0; i < listMaterials.size(); i++) {
            costForAllMaterials = costForAllMaterials + listMaterials.get(i).getPlanedCost();
        }

        for (int i = 0; i < workZones.size(); i++) {
            valueForAllZones = valueForAllZones + workZones.get(i).getValue();
        }

        this.planedCost = type.getUnitPrice() + (costForAllMaterials * valueForAllZones );

        return this.planedCost;
    }

    @Override
    public void setPlanedCost(Double planedCost) {
        this.planedCost = planedCost;

    }

    @Override
    public Double getPerspectiveCost() {
        // TODO Auto-generated method stub
        return perspectiveCost;
    }

    @Override
    public void setPerspectiveCost(Double perspectiveCost) {
        this.perspectiveCost = perspectiveCost;

    }

    @Override
    public Double getClosedCost() {
        // TODO Auto-generated method stub
        return closedCost;
    }

    @Override
    public void setClosedCost(Double closedCost) {
        this.closedCost = closedCost;

    }

    @Override
    public Double getDealCost() {
        // TODO Auto-generated method stub
        return dealCost;
    }

    @Override
    public void setDealCost(Double dealCost) {
        this.dealCost = dealCost;

    }

    @Override
    public List<Adjustment> getAdjustments() {
        // TODO Auto-generated method stub
        return adjustments;
    }

    @Override
    public void setAdjustments(List<Adjustment> adjustments) {
        this.adjustments = adjustments;

    }

}