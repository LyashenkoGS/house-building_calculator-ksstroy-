package ua.ksstroy.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import ua.ksstroy.logic.project.ProjectData;
import ua.ksstroy.logic.user.UserData;
import ua.ksstroy.logic.user.UserImpl;
import ua.ksstroy.logic.user.UserManager;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserManager userManager;

    @RequestMapping(value = "/users_projects", method = RequestMethod.GET)
    public ModelAndView usersAndProjects() {
        List<UserData> allUsers = userManager.getAllUsers();
        return new ModelAndView("users_projects", "usersList", allUsers);
    }

    @RequestMapping(value = "/users_projects/addUser", method = RequestMethod.POST)
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("password") String password,
                          @RequestParam("role") String role) {
        UserData userData = new UserData();
        userData.setName(name);
        userData.setPassword(password);
        userData.setRole(role);
        userManager.addUser(userData);
        return "redirect:" + "/users_projects";
    }

    @RequestMapping(value = "/users_projects/updateUser", method = RequestMethod.POST)
    public String updateUser(
            @RequestParam("userId") String userId,
            @RequestParam("name") String name,
            @RequestParam("password") String password,
            @RequestParam("role") String role) {
        UserData userData = new UserData();
        userData.setId(userId);
        userData.setName(name);
        userData.setPassword(password);
        userData.setRole(role);
        userManager.updateUser(userData);
        return "redirect:" + "/users_projects";
    }

    @RequestMapping(value = "/users_projects/deleteUser", method = RequestMethod.POST)
    public String deleteUser(@RequestParam("userId") String userId) {
        userManager.deleteUser(userId);
        return "redirect:" + "/users_projects";
    }


    @RequestMapping(value = "/users_projects/addProject", method = RequestMethod.POST)
    public String addProject(
            @RequestParam("userId") String userId,
            @RequestParam("name") String name,
            @RequestParam("description") String description) {
        ProjectData projectData = new ProjectData();
        projectData.setDescription(description);
        projectData.setProjectName(name);
        userManager.addProject(userId, projectData);
        return "redirect:" + "/users_projects";
    }

    @RequestMapping(value = "/users_projects/updateProject", method = RequestMethod.POST)
    public String updateProject(
            @RequestParam("projectId") String projectId,
            @RequestParam("name") String name,
            @RequestParam("description") String description) {
        ProjectData projectData = new ProjectData();
        projectData.setId(projectId);
        projectData.setDescription(description);
        projectData.setProjectName(name);
        userManager.updateProject(projectData);
        return "redirect:" + "/users_projects";
    }

    @RequestMapping(value = "/users_projects/deleteProject", method = RequestMethod.POST)
    public String deleteProject(@RequestParam("projectId") String projectId) {
        userManager.deleteProject(projectId);
        return "redirect:" + "/users_projects";
    }
}
