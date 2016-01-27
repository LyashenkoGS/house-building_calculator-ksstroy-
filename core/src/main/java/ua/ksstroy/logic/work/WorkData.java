package ua.ksstroy.logic.work;

import ua.ksstroy.logic.worktype.WorkTypeData;
import ua.ksstroy.logic.zonegroup.ZoneData;

import java.util.List;

public class WorkData {
	
	private String id;
	
	private String name;
	
	private WorkTypeData type;
	
	private ZoneData zoneData;
	
	private List<CoverData> allCovers;
	
	private Double planedCost;
	
	private Double perspectiveCost;
	
	private Double closedCost;

	private Double dealCost;
	
	private List<AdjustmentData> adjustments;

	public WorkTypeData getType() {
		return type;
	}

	public void setType(WorkTypeData type) {
		this.type = type;
	}

	public ZoneData getWorkZone() {
		return zoneData;
	}

	public void setWorkZones(ZoneData workZone) {
		this.zoneData = workZone;
	}

	public List<CoverData> getAllCovers() {
		return allCovers;
	}

	public void setAllCovers(List<CoverData> allCovers) {
		this.allCovers = allCovers;
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

	public List<AdjustmentData> getAdjustments() {
		return adjustments;
	}

	public void setAdjustments(List<AdjustmentData> adjustments) {
		this.adjustments = adjustments;
	}

}
