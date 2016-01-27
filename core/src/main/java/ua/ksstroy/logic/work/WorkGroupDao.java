package ua.ksstroy.logic.work;

import ua.ksstroy.logic.worktype.WorkType;

public interface WorkGroupDao {

    void addWorkGroup(String workGroupName, String parentGroupId, WorkType workType);

    void addWorkGroupToRootGroup(String groupName, WorkType workType);

    void removeWorkTypeGroup(String groupId);

    WorkGroup getWorkHierarchy();

    void updateWorkGroupName(String groupId, String newName);

    WorkGroup getWorkGroup(final String id);

}