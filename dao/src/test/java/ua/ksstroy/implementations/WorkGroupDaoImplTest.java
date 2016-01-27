package ua.ksstroy.implementations;

import org.junit.Test;
import ua.ksstroy.logic.material.Material;
import ua.ksstroy.logic.material.MaterialImpl;
import ua.ksstroy.logic.work.WorkGroup;
import ua.ksstroy.logic.worktype.WorkType;
import ua.ksstroy.logic.worktype.WorkTypeImpl;
import ua.ksstroy.models.work.WorkGroupModel;

import java.util.List;

import static org.junit.Assert.*;

public class WorkGroupDaoImplTest {

    @Test
    public void testGetWorkGroup() throws Exception {
        WorkGroupDaoImpl workGroupDao = new WorkGroupDaoImpl();

        WorkGroup workGroup = workGroupDao.getWorkGroup("4");

        List<MaterialImpl> materials = workGroup.getWorkType().getMaterials();

        double costForAllMaterials = 0;

        for (MaterialImpl material : materials) {
            costForAllMaterials = costForAllMaterials + material.getPlanedCost();
        }
        System.out.println(costForAllMaterials);


    }

    @Test
    public void testAddWorkGroupToRootGroup() throws Exception {
        WorkGroupDaoImpl workGroupDao = new WorkGroupDaoImpl();
        WorkTypeDaoImpl workTypeDao = new WorkTypeDaoImpl();


        workGroupDao.addWorkGroupToRootGroup("test", workTypeDao.getWorkTypeById("3") );

    }
}