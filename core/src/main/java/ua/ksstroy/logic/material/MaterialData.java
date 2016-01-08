package ua.ksstroy.logic.material;

public class MaterialData {
    //TODO:finish after obtain more specific information about the entity

    private MaterialTypeData materialType;

    private Double unitsPerWorkZoneMeasure;

    private Double planedCost;

    private Double dealCost;

    private Double closedCost;

    public MaterialData() {
    }

    public MaterialData(MaterialTypeData materialType, Double unitsPerWorkZoneMeasure, Double planedCost, Double dealCost, Double closedCost) {
        this.materialType = materialType;
        this.unitsPerWorkZoneMeasure = unitsPerWorkZoneMeasure;
        this.planedCost = planedCost;
        this.dealCost = dealCost;
        this.closedCost = closedCost;
    }


    public Double getUnitsPerWorkZoneMeasure() {
        return unitsPerWorkZoneMeasure;
    }

    public void setUnitsPerWorkZoneMeasure(Double unitsPerWorkZoneMeasure) {
        this.unitsPerWorkZoneMeasure = unitsPerWorkZoneMeasure;
    }

    public Double getPlanedCost() {
        return planedCost;
    }

    public void setPlanedCost(Double planedCost) {
        this.planedCost = planedCost;
    }

    public Double getDealCost() {
        return dealCost;
    }

    public void setDealCost(Double dealCost) {
        this.dealCost = dealCost;
    }

    public Double getClosedCost() {
        return closedCost;
    }

    public void setClosedCost(Double closedCost) {
        this.closedCost = closedCost;
    }

}