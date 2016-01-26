package ua.ksstroy.converter.work;

import ua.ksstroy.converter.Converter;
import ua.ksstroy.converter.worktype.WorkTypeModelToWorkTypeConvert;
import ua.ksstroy.logic.work.Work;
import ua.ksstroy.logic.work.WorkGroup;
import ua.ksstroy.logic.work.WorkGroupImpl;
import ua.ksstroy.models.work.WorkGroupModel;
import ua.ksstroy.models.work.WorkModel;

import java.util.ArrayList;
import java.util.List;

public class WorkGroupModelToWorkGroupConvertor implements Converter<WorkGroupModel, WorkGroup> {
    @Override
    public WorkGroup convert(WorkGroupModel workGroupModel) {
        WorkGroup workGroup = new WorkGroupImpl();
        workGroup.setId(workGroupModel.getId());
        workGroup.setName(workGroupModel.getName());
        workGroup.setWorkType(new WorkTypeModelToWorkTypeConvert().convert(workGroupModel.getType()));

        List<WorkGroup> workGroups = new ArrayList<>();
        for (WorkGroupModel workGroupM : workGroupModel.getGroups() ) {
            workGroups.add(convert(workGroupM));
        }
        workGroup.setGroups(workGroups);

        List<Work> works = new ArrayList<>();
        for (WorkModel workModel : workGroupModel.getWorks()) {
            works.add(new WorkModelToWorkConverter().convert(workModel));
        }
        workGroup.setWork(works);

        return workGroup;
    }
}
