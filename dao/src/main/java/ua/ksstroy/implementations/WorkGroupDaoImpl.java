package ua.ksstroy.implementations;

import org.springframework.stereotype.Component;
import ua.ksstroy.converter.work.WorkGroupModelToWorkGroupConvertor;
import ua.ksstroy.converter.worktype.WorkTypeToWorkTypeModelConvert;
import ua.ksstroy.logic.work.WorkGroup;
import ua.ksstroy.logic.work.WorkGroupDao;
import ua.ksstroy.logic.worktype.WorkType;
import ua.ksstroy.models.work.WorkGroupModel;
import ua.ksstroy.persistence.DoInTransaction;
import ua.ksstroy.persistence.GetInTransaction;
import ua.ksstroy.persistence.SessionWrapper;
import ua.ksstroy.persistence.TransactionHelper;

@Component
public class WorkGroupDaoImpl implements WorkGroupDao {
    private static final String ROOT_GROUP_ID = "1";
    TransactionHelper helper = new TransactionHelper();

    @Override
    public void addWorkGroup(final String workGroupName, final String parentGroupId, final WorkType workType) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                WorkGroupModel model = new WorkGroupModel();
                model.setName(workGroupName);
                model.setType(new WorkTypeToWorkTypeModelConvert().convert(workType));
                model.setWorkGroupModel(session.get(WorkGroupModel.class, parentGroupId));

                session.save(model);
            }
        });
    }

    @Override
    public void addWorkGroup(final String groupName, final WorkType workType) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                WorkGroupModel workGroupModel = new WorkGroupModel();
                workGroupModel.setName(groupName);
                workGroupModel.setType(new WorkTypeToWorkTypeModelConvert().convert(workType));

                session.save(workGroupModel);
            }
        });
    }

    @Override
    public void removeWorkTypeGroup(final String groupId) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                session.delete(session.get(WorkGroupModel.class, groupId));
            }
        });
    }

    @Override
    public WorkGroup getWorkHierarchy() {
        return helper.simpleAction(new GetInTransaction<WorkGroup>() {
            public WorkGroup process(SessionWrapper session) {
                WorkGroup workHierarchy = new WorkGroupModelToWorkGroupConvertor().convert(session.get(WorkGroupModel.class, ROOT_GROUP_ID));
                return workHierarchy;
            }
        });
    }

    @Override
    public void updateWorkGroupName(final String groupId, final String newName) {
        helper.doWithCommit(new DoInTransaction() {
            @Override
            public void process(SessionWrapper session) {
                WorkGroupModel workGroupModel = session.get(WorkGroupModel.class, groupId);
                workGroupModel.setId(groupId);
                workGroupModel.setName(newName);
                session.saveOrUpdate(workGroupModel);
            }
        });
    }

    @Override
    public WorkGroup getWorkGroup(final String id) {
        return helper.simpleAction(new GetInTransaction<WorkGroup>() {
            public WorkGroup process(SessionWrapper session) {
                WorkGroup workHierarchy = new WorkGroupModelToWorkGroupConvertor().convert(session.get(WorkGroupModel.class, id));
                return workHierarchy;
            }
        });
    }
}
