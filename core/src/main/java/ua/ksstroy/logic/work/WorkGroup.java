/**
 * 
 */
package ua.ksstroy.logic.work;

import ua.ksstroy.logic.worktype.WorkType;

import java.util.List;

public interface WorkGroup {
	
	public String getName();

	public void setName(String name);
	
	public String getId();

	public void setId(String id);

	public List<WorkGroup> getGroups();

	public void setGroups(List<WorkGroup> groups);

	public List<Work> getWork();

	public void setWork(List<Work> works);

	WorkType getWorkType();

	void setWorkType(WorkType workType);

}