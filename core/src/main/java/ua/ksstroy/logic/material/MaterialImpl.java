package ua.ksstroy.logic.material;

public class MaterialImpl implements Material {
    //TODO:finish after obtain more specific information about the entity

    private MaterialType materialType;

    private Double unitsPerWorkZoneMeasure;

    private Double planedCost;

    private Double dealCost;

    private Double closedCost;

    public MaterialImpl() {
    }

    public MaterialImpl(MaterialType materialType, Double unitsPerWorkZoneMeasure, Double planedCost, Double dealCost, Double closedCost) {
        this.materialType = materialType;
        this.unitsPerWorkZoneMeasure = unitsPerWorkZoneMeasure;
        this.planedCost = planedCost;
        this.dealCost = dealCost;
        this.closedCost = closedCost;
    }

    @Override
    public MaterialType getMaterialType() {
        return materialType;
    }

    @Override
    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }

    @Override
    public Double getUnitsPerWorkZoneMeasure() {
        return unitsPerWorkZoneMeasure;
    }

    @Override
    public void setUnitsPerWorkZoneMeasure(Double unitsPerWorkZoneMeasure) {
        this.unitsPerWorkZoneMeasure = unitsPerWorkZoneMeasure;
    }

    @Override
    public Double getPlanedCost() {
        return planedCost;
    }

    @Override
    public void setPlanedCost(Double planedCost) {
        this.planedCost = planedCost;
    }

    @Override
    public Double getDealCost() {
        return dealCost;
    }

    @Override
    public void setDealCost(Double dealCost) {
        this.dealCost = dealCost;
    }

    @Override
    public Double getClosedCost() {
        return closedCost;
    }

    @Override
    public void setClosedCost(Double closedCost) {
        this.closedCost = closedCost;
    }

}