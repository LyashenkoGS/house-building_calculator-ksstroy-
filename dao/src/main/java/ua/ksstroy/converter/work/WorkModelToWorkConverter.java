package ua.ksstroy.converter.work;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.converter.worktype.WorkTypeModelToWorkTypeConvert;
import ua.ksstroy.converter.zonegroup.ZonesModelToZoneConverter;
import ua.ksstroy.logic.work.Adjustment;
import ua.ksstroy.logic.work.Cover;
import ua.ksstroy.logic.work.Work;
import ua.ksstroy.logic.work.WorkImpl;
import ua.ksstroy.logic.zonegroup.Zone;
import ua.ksstroy.models.work.AdjustmentModel;
import ua.ksstroy.models.work.CoverModel;
import ua.ksstroy.models.work.WorkModel;
import ua.ksstroy.models.zone.ZonesModel;

import java.util.ArrayList;
import java.util.List;

public class WorkModelToWorkConverter implements Converter<WorkModel, Work> {

    @Override
    public Work convert(WorkModel workModel) {
        Work work = new WorkImpl();
        work.setId(workModel.getId());
        work.setName(workModel.getName());
        work.setClosedCost(workModel.getClosedCost());
        work.setDealCost(workModel.getDealCost());
        work.setPerspectiveCost(workModel.getPerspectiveCost());
        work.setPlanedCost(workModel.getPlanedCost());
        work.setType(new WorkTypeModelToWorkTypeConvert().convert(workModel.getType()));
        work.setWorkZone(new ZonesModelToZoneConverter().convert(workModel.getZonesModel()));

        List<Cover> covers = new ArrayList<>();
        for (CoverModel coverModel : workModel.getAllCovers()) {
            covers.add(new CoverModelToCoverConverter().convert(coverModel));
        }
        work.setAllCovers(covers);

        List<Adjustment> adjustments = new ArrayList<>();
        for (AdjustmentModel adjustmentModel : workModel.getAdjustments()) {
            adjustments.add(new AdjustmentModelToAdjustmentConverter().convert(adjustmentModel));
        }
        work.setAdjustments(adjustments);

        return work;
    }

}