package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import web.service.UtilService;

import java.util.List;

@Controller
public class AdminController {

    private final UserService userService;

    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/admin")
    public String listUsers(ModelMap modelMap) {
        List<User> users = userService.listUsers();
        modelMap.put("users", users);
        return "index";
    }

    @GetMapping(value = "/admin/addUser")
    public String getAddUser() {
        return "addUser";
    }

    @PostMapping(value = "/admin/addUser")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/admin";
    }

    @GetMapping(value = "/admin/deleteUser")
    public String deleteUser(@RequestParam(value = "id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping(value = "/admin/editUser")
    public String editUserGet(@RequestParam(value = "id") Long id, ModelMap modelMap) {
        User user = userService.getUserById(id);
        modelMap.put("user", user);
        return "editUser";
    }

    @RequestMapping(value = "/admin/editUser", method = RequestMethod.POST)
    public String editUserPost(@ModelAttribute User user, @RequestParam(value = "role") String[] rolesArr) {
        user.setRoles(UtilService.stringArrToSetRoles(rolesArr));
        userService.editUser(user);
        return "redirect:/admin";
    }
}
