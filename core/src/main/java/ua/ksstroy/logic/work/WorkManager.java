package ua.ksstroy.logic.work;

import ua.ksstroy.logic.worktype.WorkTypeData;

public interface WorkManager {

    void addWork(WorkData workData, String parentGroupId);

    void addCoverToWork(CoverData coverData, String workId);

    void addAdjustmentToWork(AdjustmentData adjustmentData, String workId);

    void updateWork(String workId, WorkData work);

    void remoteWork(String workId);

    void addWorkGroup(String workGroupName, String parentGroupId, WorkTypeData workTypeData);

    void addWorkGroup(String groupName, WorkTypeData workTypeData);

    void removeWorkTypeGroup(String groupId);

    WorkGroupData getWorkHierarchy();

    void updateWorkGroupName(String groupId, String newName);

}