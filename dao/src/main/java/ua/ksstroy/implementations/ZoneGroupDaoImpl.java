package ua.ksstroy.implementations;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ua.ksstroy.converter.Converter;

import ua.ksstroy.converter.zonegroup.GroupsModelToGroupConverter;
import ua.ksstroy.converter.zonegroup.GroupsModelToZoneGroupHierarchyConverter;
import ua.ksstroy.converter.zonegroup.ZoneToZoneModelConverter;
import ua.ksstroy.converter.zonegroup.ZonesModelToZoneConverter;
import ua.ksstroy.logic.zonegroup.Zone;
import ua.ksstroy.logic.zonegroup.ZoneDao;
import ua.ksstroy.logic.zonegroup.ZoneGroup;
import ua.ksstroy.logic.zonegroup.ZoneGroupImpl;
import ua.ksstroy.models.project.ProjectModel;
import ua.ksstroy.models.zone.GroupsModel;
import ua.ksstroy.models.zone.ZonesModel;
import ua.ksstroy.persistence.DoInTransaction;
import ua.ksstroy.persistence.GetInTransaction;
import ua.ksstroy.persistence.SessionWrapper;
import ua.ksstroy.persistence.TransactionHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
@Service
@Component(value = "zoneDao")
public class ZoneGroupDaoImpl implements ZoneDao {

    private TransactionHelper helper = new TransactionHelper();


    @Override
    public void addRootGroup(final String groupName, final Integer projectId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                ProjectModel projectModel = session.get(ProjectModel.class, projectId);
                GroupsModel rootGroup = new GroupsModel(groupName);
                projectModel.setGroupsModel(rootGroup);

                session.save(rootGroup);
                session.saveOrUpdate(projectModel);
            }
        });
    }

    @Override
    public void removeZone(final String zoneId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                session.delete(session.get(ZonesModel.class, zoneId));
            }
        });
    }

    @Override
    public void removeGroup(final String groupId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                session.delete(session.get(GroupsModel.class, groupId));
            }
        });
    }

    @Override
    public Zone getZoneById(final String zoneId) {
        return helper.simpleAction(new GetInTransaction<Zone>() {
            public Zone process(SessionWrapper session) {
                session.get(ZonesModel.class, zoneId);

                return new ZonesModelToZoneConverter().convert(session.get(ZonesModel.class, zoneId));
            }
        });
    }

    @Override
    public ZoneGroup getAllHierarchy(final String projectId) {
        return helper.simpleAction(new GetInTransaction<ZoneGroup>() {
            public ZoneGroup process(SessionWrapper session) {
                ProjectModel project = session.get(ProjectModel.class, projectId);
                return new GroupsModelToZoneGroupHierarchyConverter().convert(project.getGroupsModel());
            }
        });
    }

    @Override
    public List<ZoneGroup> getGroupsByParentGroupId(final String groupId) {
        return helper.simpleAction(new GetInTransaction<List<ZoneGroup>>() {
            @Override
            public List<ZoneGroup> process(SessionWrapper session) {
                final List<ZoneGroup> groupsByParentGroupId = new ArrayList<>();
                GroupsModel parentGroup = session.get(GroupsModel.class, groupId);
                for (GroupsModel groupsModel : parentGroup.getSubGroups())
                    groupsByParentGroupId.add(new GroupsModelToGroupConverter().convert(groupsModel));
                return groupsByParentGroupId;
            }
        });

    }

    @Override
    public List<Zone> getZonesByParentGroupId(final String groupId) {
        return helper.simpleAction(new GetInTransaction<List<Zone>>() {
            @Override
            public List<Zone> process(SessionWrapper session) {
                return convertMany(session.get(GroupsModel.class, groupId).getZonesGroup(),
                        new ZonesModelToZoneConverter());
            }
        });
    }


    @Override
    public void storeZone(final Zone zone, final String parentGroupId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                ZonesModel zoneModelPreparedForSave = new ZoneToZoneModelConverter().convert(zone);
                GroupsModel parentGroup = session.get(GroupsModel.class, parentGroupId);
                parentGroup.getZonesGroup().add(zoneModelPreparedForSave);
                session.saveOrUpdate(parentGroup);

            }
        });
    }

    @Override
    public void storeAdditionalToZone(final Zone zone, final String parentZoneId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                ZonesModel zoneModelPreparedForSave = new ZoneToZoneModelConverter().convert(zone);
                ZonesModel parentZone = session.get(ZonesModel.class, parentZoneId);
                parentZone.getAdditionalZone().add(zoneModelPreparedForSave);

                session.saveOrUpdate(parentZone);
            }
        });

    }

    @Override
    public void storeSurplusToZone(final Zone zone, final String parentZoneId) {

        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                ZonesModel zoneModelPreparedForSave = new ZoneToZoneModelConverter().convert(zone);
                ZonesModel parentZone = session.get(ZonesModel.class, parentZoneId);
                parentZone.getSurplusZone().add(zoneModelPreparedForSave);

                session.saveOrUpdate(parentZone);

            }
        });

    }

    @Override
    public void addGroupToGroup(final String groupName, final String parentGroupId) {

        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                GroupsModel parentGroup = session.get(GroupsModel.class, parentGroupId);
                parentGroup.getSubGroups().add(new GroupsModel(groupName));
                session.saveOrUpdate(parentGroup);
            }
        });
    }

    @Override
    public void updateZone(final String zoneId, final Zone newZone) {

        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                ZonesModel zone = session.get(ZonesModel.class, zoneId);
                zone.setName(newZone.getName());
                zone.setHeight(newZone.getHeight());
                zone.setWidth(newZone.getWidth());
                zone.setMeasureName(newZone.getMeasure());

                session.saveOrUpdate(zone);

            }
        });
    }

    @Override
    public void updateGroup(final String groupId, final String newGroup) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                GroupsModel group = session.get(GroupsModel.class, groupId);
                group.setName(newGroup);
                session.saveOrUpdate(group);
            }
        });
    }

    private <S, T> List<T> convertMany(Collection<S> sourceCollection, Converter<S, T> converter) {
        final List<T> targetCollection = new ArrayList<>();
        for (S source : sourceCollection)
            targetCollection.add(converter.convert(source));
        return targetCollection;
    }

    private ZoneGroupImpl convertGroupsModelToZoneGroup(GroupsModel groupsModel) {
        ZoneGroupImpl zoneGroup = new ZoneGroupImpl();
        zoneGroup.setId(groupsModel.getId());
        zoneGroup.setName(groupsModel.getName());

        List<ZoneGroup> subGroups = new ArrayList<>();
        for (GroupsModel subgroup : groupsModel.getSubGroups()) {
            subGroups.add(convertGroupsModelToZoneGroup(subgroup));
        }
        zoneGroup.setGroups(subGroups);

        List<Zone> rootZones = new ArrayList<>();
        List<Zone> surplusZones = new ArrayList<>();
        List<Zone> additionalZones = new ArrayList<>();

        for (ZonesModel oneRootZone : groupsModel.getZonesGroup()) {
            for (ZonesModel oneAdditionalZone : oneRootZone.getAdditionalZone())
                additionalZones.add(new ZonesModelToZoneConverter().convert(oneAdditionalZone));

            for (ZonesModel oneSurplusZone : oneRootZone.getSurplusZone())
                surplusZones.add(new ZonesModelToZoneConverter().convert(oneSurplusZone));

            Zone allZonesAndSubZones = new ZonesModelToZoneConverter().convert(oneRootZone);
            allZonesAndSubZones.setAdditional(additionalZones);
            allZonesAndSubZones.setSurplus(surplusZones);

            rootZones.add(allZonesAndSubZones);

        }
        zoneGroup.setZones(rootZones);

        return zoneGroup;
    }
}