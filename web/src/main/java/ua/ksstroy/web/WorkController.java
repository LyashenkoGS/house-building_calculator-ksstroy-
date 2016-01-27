package ua.ksstroy.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.ksstroy.converter.zonegroup.ZoneToZoneDataConverter;
import ua.ksstroy.logic.work.AdjustmentData;
import ua.ksstroy.logic.work.CoverData;
import ua.ksstroy.logic.work.WorkData;
import ua.ksstroy.logic.work.WorkManager;
import ua.ksstroy.logic.worktype.WorkTypeData;
import ua.ksstroy.logic.worktype.WorkTypeManagerImpl;
import ua.ksstroy.logic.zonegroup.ZoneManagerImpl;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WorkController {

    //asdasdasda
    @Resource(name = "WorkManagerImpl")
    WorkManager workManager;

    @Resource(name = "WorkTypeManagerImpl")
    WorkTypeManagerImpl workTypeManager;

    @Resource(name = "ZoneManagerImpl")
    ZoneManagerImpl zoneManager;

    ModelAndView workModelView;
    WorkData workData;
    CoverData coverData;
    AdjustmentData adjustmentData;

    @RequestMapping(value = "/projects/{projectId}/work", method = RequestMethod.GET)
    public ModelAndView showZHD(@PathVariable("projectId") String projectId) {
        workModelView = new ModelAndView("works");
        workModelView.addObject("projectId", projectId);
        workModelView.addObject("workObject", workManager.getWorkHierarchy());
        workModelView.addObject("workType", workTypeManager.getWorkTypeHierarchy());
        workModelView.addObject("zone", zoneManager.getRootZoneHierarchy(projectId));

        return workModelView;
    }

    @RequestMapping(value = "/projects/addOuterWorkGroup", method = RequestMethod.POST)
    public String addOuterWorkGroup(@RequestParam("name") String outerWorkTypeGroupName,
                                    @RequestParam("projectId") String projectId,
                                    @RequestParam("workTypeId") String workTypeId) {


        workManager.addWorkGroupToRootGroup(outerWorkTypeGroupName, workTypeManager.getWorkTypeById(workTypeId));

        return "redirect:" + projectId + "/work";
    }

    @RequestMapping(value = "/projects/addInnerWorkGroup", method = RequestMethod.POST)
    public String addInnerWorkGroup(@RequestParam("name") String innerWorkTypeGroupName,
                                    @RequestParam("parentId") String parentWorkTypeGroupId,
                                    @RequestParam("projectId") String projectId,
                                    @RequestParam("workTypeId") String workTypeId) {

        workManager.addWorkGroup(innerWorkTypeGroupName, parentWorkTypeGroupId, workTypeManager.getWorkTypeById(workTypeId));

        return "redirect:" + projectId + "/work";
    }

    @RequestMapping(value = "/projects/removeWorkGroup", method = RequestMethod.POST)
    public String removeWorkGroup(@RequestParam("id") String id,
                                  @RequestParam("projectId") String projectId) {

        workManager.removeWorkTypeGroup(id);

        return "redirect:" + projectId + "/work";
    }

    @RequestMapping(value = "/projects/updateWorkGroupName", method = RequestMethod.POST)
    public String updateWorkGroupName(@RequestParam("groupId") String groupId,
                                      @RequestParam("newGroupName") String newGroupName,
                                      @RequestParam("projectId") String projectId) {

        workManager.updateWorkGroupName(groupId, newGroupName);

        return "redirect:" + projectId + "/work";
    }


    @RequestMapping(value = "/projects/addWork", method = RequestMethod.POST)
    public String addWork(@RequestParam("name") String name,
                          @RequestParam("perspectiveCost") String perspectiveCost,
                          @RequestParam("closedCost") String closedCost,
                          @RequestParam("dealCost") String dealCost,
                          @RequestParam("parentId") String parentWorkGroupId,
                          @RequestParam("projectId") String projectId,
                          @RequestParam("zoneId") String zoneId) {

        workData = new WorkData();
        workData.setName(name);
        workData.setWorkZones(new ZoneToZoneDataConverter().convert(zoneManager.getZoneById(zoneId)));
        WorkTypeData workTypeData = workManager.getWorkGroup(parentWorkGroupId).getWorkTypeData();
        workData.setType(workTypeData);
        workData.setPlanedCost(workData.getPlanedCost());

        CoverData coverData = new CoverData();

        coverData.setDate("data_1");
        coverData.setValue(12.0);
        coverData.setDescription("description_1");

        List<CoverData> coverDataList = new ArrayList<>();
        coverDataList.add(coverData);

        AdjustmentData adjustmentData = new AdjustmentData();

        adjustmentData.setAbsolute(true);
        adjustmentData.setValue(123.0);

        List<AdjustmentData> adjustmentDataList = new ArrayList<>();
        adjustmentDataList.add(adjustmentData);

        workData.setAllCovers(coverDataList);
        workData.setAdjustments(adjustmentDataList);

        try {
            workData.setPlanedCost(1.0);
            workData.setPerspectiveCost(new Double(perspectiveCost).doubleValue());
            workData.setClosedCost(new Double(closedCost).doubleValue());
            workData.setDealCost(new Double(dealCost).doubleValue());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        workManager.addWork(workData, parentWorkGroupId);
        System.out.println("add work");
        return "redirect:" + projectId + "/work";
    }


    @RequestMapping(value = "/projects/removeWork", method = RequestMethod.POST)
    public String removeWork(@RequestParam("id") String id,
                             @RequestParam("projectId") String projectId) {

        workManager.remoteWork(id);

        return "redirect:" + projectId + "/work";
    }

    @RequestMapping(value = "/projects/updateWork", method = RequestMethod.POST)
    public String updateWork(@RequestParam("id") String id,
                             @RequestParam("name") String name,
                             @RequestParam("planedCost") String planedCoast,
                             @RequestParam("perspectiveCost") String perspectiveCost,
                             @RequestParam("closedCost") String closedCost,
                             @RequestParam("dealCost") String dealCost,
                             @RequestParam("projectId") String projectId) {

        workData = new WorkData();
        workData.setName(name);
        try {
            workData.setPlanedCost(new Double(planedCoast).doubleValue());
            workData.setPerspectiveCost(new Double(perspectiveCost).doubleValue());
            workData.setClosedCost(new Double(closedCost).doubleValue());
            workData.setDealCost(new Double(dealCost).doubleValue());

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        workManager.updateWork(id, workData);

        return "redirect:" + projectId + "/work";
    }

    @RequestMapping(value = "/projects/addCoverToWork", method = RequestMethod.POST)
    public String addCoverToWork(@RequestParam("projectId") String projectId,
                                 @RequestParam("workId") String workId,
                                 @RequestParam("value") String value,
                                 @RequestParam("date") String date,
                                 @RequestParam("description") String description) {

        coverData = new CoverData();
        coverData.setDescription(description);
        coverData.setDate(date);

        try {
            coverData.setValue(new Double(value).doubleValue());

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        workManager.addCoverToWork(coverData, workId);

        return "redirect:" + projectId + "/work";
    }

    @RequestMapping(value = "/projects/addAdjustmentToWork", method = RequestMethod.POST)
    public String addAdjustmentToWork(@RequestParam("projectId") String projectId,
                                      @RequestParam("workId") String workId,
                                      @RequestParam("value") String value,
                                      @RequestParam("isAbsolute") String isAbsolute) {

        adjustmentData = new AdjustmentData();
        try {
            System.out.println("VALUE IS STARTING ASSIGNED");
            adjustmentData.setValue(new Double(value).doubleValue());
            System.out.println("VALUE ASSIGNED!!");
            adjustmentData.setAbsolute(new Boolean(isAbsolute).booleanValue());

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        workManager.addAdjustmentToWork(adjustmentData, workId);

        return "redirect:" + projectId + "/work";
    }

}
