package ua.ksstroy.logic.zonegroup;

import ua.ksstroy.logic.zonegroup.exceptions.NameConflictException;

public interface ZoneManager {
	/*
	 * An objects that is used by the web tier to view and manage data from a
	 * data-base (e.g MySQL); with already affected in runtime business logic
	 * rules.
	 */
	ZoneHierarchyData getRootZoneHierarchy(String projectId) throws NameConflictException;

	void addRootGroupToProject(String groupName, Integer projectId) throws NameConflictException;

	void addGroupToGroup(String groupName, String parentGroupId) throws NameConflictException;

	void addZone(ZoneData zone, String parentGroupId) throws NameConflictException;

	void addSurplusToZone(ZoneData surplusZone, String parentZoneId) throws NameConflictException;

	void addAdditionalToZone(ZoneData additionalZone, String parentZoneId) throws NameConflictException;

	void updateZone(String zoneId, ZoneData newZone);

	void removeZone(String zoneId);

	void updateGroup(String groupId, String newGroup);

	void removeGroup(String groupId);

	Zone getZoneById(String zoneId);
}
