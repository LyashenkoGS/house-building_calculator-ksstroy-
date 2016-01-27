package ua.ksstroy.logic.work;

import ua.ksstroy.logic.worktype.WorkType;
import ua.ksstroy.logic.zonegroup.Zone;

import java.util.List;

public interface Work {
	
	public WorkType getType();

	public void setType(WorkType type);

	public Zone getWorkZone();

	public void setWorkZone(Zone workZone);

	public List<Cover> getAllCovers();

	public void setAllCovers(List<Cover> allCovers);

	public String getId(); 

	public void setId(String id); 

	public String getName(); 
	
	public void setName(String name); 

	public Double getPlanedCost(); 

	public void setPlanedCost(Double planedCost);

	public Double getPerspectiveCost();

	public void setPerspectiveCost(Double perspectiveCost); 

	public Double getClosedCost(); 

	public void setClosedCost(Double closedCost); 

	public Double getDealCost(); 

	public void setDealCost(Double dealCost); 

	public List<Adjustment> getAdjustments();

	public void setAdjustments(List<Adjustment> adjustments);

}