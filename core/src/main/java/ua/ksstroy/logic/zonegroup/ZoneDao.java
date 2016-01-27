package ua.ksstroy.logic.zonegroup;

import java.util.List;

public interface ZoneDao {

	ZoneGroup getAllHierarchy(String projectId);

	List<ZoneGroup> getGroupsByParentGroupId(String groupId);

	List<Zone> getZonesByParentGroupId(String groupId);

	void storeZone(Zone zone, String parentGroupId);

	void storeAdditionalToZone(Zone zone, String parentZoneId);

	void storeSurplusToZone(Zone zone, String parentZoneId);

	void updateZone(String zoneId, Zone newZone);

	void removeZone(String zoneId);

	void addRootGroup(String groupName, Integer projectId);

	void addGroupToGroup(String groupName, String parentGroupId);

	void updateGroup(String groupId, String newGroup);

	void removeGroup(String groupId);

	Zone getZoneById(String zoneId);

}