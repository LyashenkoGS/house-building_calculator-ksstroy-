package ua.ksstroy.logic.zonegroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ua.ksstroy.converter.zonegroup.ZoneDataToZoneConverter;
import ua.ksstroy.converter.zonegroup.ZoneGroupToZoneHierarchyDataHierarchyConverter;
import ua.ksstroy.logic.zonegroup.exceptions.NameConflictException;

@Component(value = "ZoneManagerImpl")
public class ZoneManagerImpl implements ZoneManager {

    @Autowired
    @Qualifier("zoneDao")
    ZoneDao zoneDaoImpl;

    public ZoneHierarchyData getRootZoneHierarchy(String projectId) {
        return new ZoneGroupToZoneHierarchyDataHierarchyConverter().convert(zoneDaoImpl.getAllHierarchy(projectId));
    }

    @Override
    public void addRootGroupToProject(String groupName, Integer projectId) {
        zoneDaoImpl.addRootGroup(groupName, projectId);
    }

    public void addGroupToGroup(String groupName, String parentGroupId) throws NameConflictException {
        zoneDaoImpl.addGroupToGroup(groupName, parentGroupId);
    }

    public void addZone(ZoneData zone, String parentGroupId) throws NameConflictException {
        zoneDaoImpl.storeZone(new ZoneDataToZoneConverter().convert(zone), parentGroupId);
    }

    @Override
    public void addSurplusToZone(ZoneData surplusZone, String parentZoneId) throws NameConflictException {
        zoneDaoImpl.storeSurplusToZone(new ZoneDataToZoneConverter().convert(surplusZone), parentZoneId);
    }

    @Override
    public void addAdditionalToZone(ZoneData additionalZone, String parentZoneId) throws NameConflictException {
        zoneDaoImpl.storeAdditionalToZone(new ZoneDataToZoneConverter().convert(additionalZone), parentZoneId);
    }

    @Override
    public void updateGroup(String groupId, String newGroup) {
        zoneDaoImpl.updateGroup(groupId, newGroup);
    }

    @Override
    public void updateZone(String zoneId, ZoneData newZone) {
        zoneDaoImpl.updateZone(zoneId, new ZoneDataToZoneConverter().convert(newZone));
    }

    @Override
    public void removeZone(String zoneId) {
        zoneDaoImpl.removeZone(zoneId);
    }

    @Override
    public void removeGroup(String groupId) {
        zoneDaoImpl.removeGroup(groupId);
    }

    @Override
    public Zone getZoneById(String zoneId) {
        return zoneDaoImpl.getZoneById(zoneId);
    }

}