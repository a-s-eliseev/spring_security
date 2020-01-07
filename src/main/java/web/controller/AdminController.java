package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import web.model.Role;
import web.model.User;
import web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class AdminController {

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String listUsers(ModelMap modelMap) {
        List<User> users = userService.listUsers();
        modelMap.put("users", users);
        return "index";
    }

    @RequestMapping(value = "/admin/addUser", method = RequestMethod.GET)
    public String getAddUser() {
        return "addUser";
    }

    @RequestMapping(value = "/admin/addUser", method = RequestMethod.POST)
    public void addUserPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.addUser(user);
        response.sendRedirect("/admin");
    }

    @RequestMapping(value = "/admin/deleteUser", method = RequestMethod.GET)
    public void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        userService.deleteUser(id);
        response.sendRedirect("/admin");
    }

    @RequestMapping(value = "/admin/editUser", method = RequestMethod.GET)
    public String editUserGet(HttpServletRequest request, ModelMap modelMap) {
        Long id = Long.parseLong(request.getParameter("id"));
        User user = userService.getUserById(id);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Set<Role> roles = user.getRoles();
        for (Role role : roles) {
            if (role.getName().equals("ROLE_USER")) {
                modelMap.put("role_user", role);
            }
            if (role.getName().equals("ROLE_ADMIN")) {
                modelMap.put("role_admin", role);
            }
        }
        modelMap.put("user", user);
        return "editUser";
    }

    @RequestMapping(value = "/admin/editUser", method = RequestMethod.POST)
    public void editUserPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] rolesArr = request.getParameterValues("role");
        User user = new User();
        Set<Role> roles = new HashSet<>();
        for (String role : rolesArr) {
            if (role.equals("ROLE_ADMIN")) {
                Role roleAdmin = new Role(2L, "ROLE_ADMIN");
                roles.add(roleAdmin);
            }
            if (role.equals("ROLE_USER")) {
                Role roleUser = new Role(1L, "ROLE_USER");
                roles.add(roleUser);
            }
        }
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        user.setRoles(roles);
        userService.editUser(user);
        response.sendRedirect("/admin");
    }

}
