package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.User;
import web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listUsers(ModelMap modelMap) {
        List<User> users = userService.listUsers();
        modelMap.put("users", users);
        return "index";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUserGet() {
        return "addUser";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public void addUserPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = new User(login, password);
        userService.addUser(user);
        response.sendRedirect("/");
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        userService.deleteUser(id);
        response.sendRedirect("/");
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.GET)
    public String editUserGet(HttpServletRequest request, ModelMap modelMap) {
        Long id = Long.parseLong(request.getParameter("id"));
        User user = userService.getUser(id);
        modelMap.put("user", user);
        return "editUser";
    }

    @RequestMapping(value = "/editUser", method = RequestMethod.POST)
    public void editUserPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = new User(login, password);
        user.setId(id);
        userService.editUser(user);
        response.sendRedirect("/");
    }
}
