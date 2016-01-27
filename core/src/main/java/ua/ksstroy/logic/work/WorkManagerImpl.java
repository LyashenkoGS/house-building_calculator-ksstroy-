package ua.ksstroy.logic.work;

import org.springframework.stereotype.Component;
import ua.ksstroy.converter.worktype.WorkTypeDataToWorkTypeConverter;
import ua.ksstroy.converter.worktype.WorkTypeToWorkTypeDataConverter;
import ua.ksstroy.converter.zonegroup.ZoneDataToZoneConverter;
import ua.ksstroy.converter.zonegroup.ZoneToZoneDataConverter;
import ua.ksstroy.logic.worktype.WorkTypeData;
import ua.ksstroy.logic.zonegroup.Zone;
import ua.ksstroy.logic.zonegroup.ZoneData;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component(value = "WorkManagerImpl")
public class WorkManagerImpl implements WorkManager {

    @Resource
    WorkDao workDao;
    @Resource
    WorkGroupDao workGroupDao;

    @Override
    public void addWork(WorkData workData, String parentGroupId) {
        workDao.addWork(convertWorkDataToWork(workData), parentGroupId);
    }

    @Override
    public void addCoverToWork(CoverData coverData, String workId) {
        workDao.addCoverToWork(convertCoverDataToCover(coverData), workId);
    }

    @Override
    public void addAdjustmentToWork(AdjustmentData adjustmentData, String workId) {
        workDao.addAdjustmentToWork(convertAdjustmentDataToAdjustment(adjustmentData), workId);
    }

    @Override
    public void updateWork(String workId, WorkData workData) {
        workDao.updateWork(workId, convertWorkDataToWork(workData));
    }

    @Override
    public void remoteWork(String workId) {
        workDao.remoteWork(workId);
    }

    @Override
    public void addWorkGroup(String workGroupName, String parentGroupId, WorkTypeData workTypeData) {
        workGroupDao.addWorkGroup(workGroupName, parentGroupId, new WorkTypeDataToWorkTypeConverter().convert(workTypeData));
    }

    @Override
    public void addWorkGroupToRootGroup(String groupName, WorkTypeData workTypeData) {
        workGroupDao.addWorkGroupToRootGroup(groupName, new WorkTypeDataToWorkTypeConverter().convert(workTypeData));
    }

    @Override
    public void removeWorkTypeGroup(String groupId) {
        workGroupDao.removeWorkTypeGroup(groupId);
    }

    @Override
    public WorkGroupData getWorkHierarchy() {
        WorkGroupData workGroup = convertWorkGroupToWorkGroupData(workGroupDao.getWorkHierarchy());
        return workGroup;
    }

    @Override
    public void updateWorkGroupName(String groupId, String newName) {
        workGroupDao.updateWorkGroupName(groupId, newName);
    }

    @Override
    public WorkGroupData getWorkGroup(String id) {
        return convertWorkGroupToWorkGroupData(workGroupDao.getWorkGroup(id));
    }

    public Work convertWorkDataToWork(WorkData workData) {
        Work work = new WorkImpl();

        work.setId(workData.getId());
        work.setName(workData.getName());
        work.setType(new WorkTypeDataToWorkTypeConverter().convert(workData.getType()));
        work.setPerspectiveCost(workData.getPerspectiveCost());
        work.setDealCost(workData.getDealCost());
        work.setClosedCost(workData.getClosedCost());
        work.setPlanedCost(workData.getPlanedCost());
        work.setWorkZone(new ZoneDataToZoneConverter().convert(workData.getWorkZone()));

        List<Cover> coverList = new ArrayList<>();
        for (CoverData coverData : workData.getAllCovers()) {
            coverList.add(convertCoverDataToCover(coverData));
        }
        work.setAllCovers(coverList);

        List<Adjustment> adjustments = new ArrayList<>();
        for (AdjustmentData adjustmentData : workData.getAdjustments()) {
            adjustments.add(convertAdjustmentDataToAdjustment(adjustmentData));
        }
        work.setAdjustments(adjustments);

        return work;
    }

    public Cover convertCoverDataToCover(CoverData coverData) {
        Cover cover = new CoverImpl();

        cover.setId(coverData.getId());
        cover.setValue(coverData.getValue());
        cover.setDate(coverData.getDate());
        cover.setDescription(coverData.getDescription());

        return cover;
    }

    public Adjustment convertAdjustmentDataToAdjustment(AdjustmentData adjustmentData) {
        Adjustment adjustment = new AdjustmentImpl();

        adjustment.setId(adjustmentData.getId());
        adjustment.setAbsolute(adjustmentData.isAbsolute());
        adjustment.setValue(adjustmentData.getValue());

        return adjustment;
    }

    public WorkGroupData convertWorkGroupToWorkGroupData(WorkGroup workGroup) {
        WorkGroupData workGroupData = new WorkGroupData();

        workGroupData.setId(workGroup.getId());
        workGroupData.setName(workGroup.getName());
        workGroupData.setWorkTypeData(new WorkTypeToWorkTypeDataConverter().convert(workGroup.getWorkType()));

        List<WorkGroupData> workGroupDatas = new ArrayList<>();
        for (WorkGroup workGr : workGroup.getGroups()) {
            workGroupDatas.add(convertWorkGroupToWorkGroupData(workGr));
        }
        workGroupData.setGroups(workGroupDatas);

        List<WorkData> workDatas = new ArrayList<>();
        for (Work work : workGroup.getWork()) {
            workDatas.add(convertWorkToWorkData(work));
        }
        workGroupData.setWorks(workDatas);

        return workGroupData;
    }

    public WorkData convertWorkToWorkData(Work work) {
        WorkData workData = new WorkData();

        workData.setId(work.getId());
        workData.setName(work.getName());
        workData.setClosedCost(work.getClosedCost());
        workData.setDealCost(work.getDealCost());
        workData.setPerspectiveCost(work.getPerspectiveCost());
        workData.setPlanedCost(work.getPlanedCost());
        workData.setType(new WorkTypeToWorkTypeDataConverter().convert(work.getType()));
        workData.setWorkZones(new ZoneToZoneDataConverter().convert(work.getWorkZone()));

        List<CoverData> coverDatas = new ArrayList<>();
        for (Cover cover : work.getAllCovers()) {
            coverDatas.add(convertCoverToCoverData(cover));
        }
        workData.setAllCovers(coverDatas);

        List<AdjustmentData> adjustmentsData = new ArrayList<>();
        for (Adjustment adjustment : work.getAdjustments()) {
            adjustmentsData.add(convertAdjustmentToAdjustmentData(adjustment));
        }
        workData.setAdjustments(adjustmentsData);

        return workData;
    }

    public CoverData convertCoverToCoverData(Cover cover) {
        CoverData coverData = new CoverData();

        coverData.setId(cover.getId());
        coverData.setDate(cover.getDate());
        coverData.setDescription(cover.getDescription());
        coverData.setValue(cover.getValue());

        return coverData;
    }

    public AdjustmentData convertAdjustmentToAdjustmentData(Adjustment adjustment) {
        AdjustmentData adjustmentData = new AdjustmentData();

        adjustmentData.setId(adjustment.getId());
        adjustmentData.setValue(adjustment.getValue());
        adjustmentData.setAbsolute(adjustment.isAbsolute());

        return adjustmentData;
    }

}