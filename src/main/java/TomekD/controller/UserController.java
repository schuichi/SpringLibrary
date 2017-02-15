package TomekD.controller;

import TomekD.dao.UserDao;
import TomekD.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

//    @Autowired
//    public UserController(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsersPage(Model model) {

        List<User> users = userDao.findAll();

        model.addAttribute("usersList", users);

        return "users";
    }

    @RequestMapping(value = "/create-user", method = RequestMethod.GET)
    public String getUserForm() {
        return "user-create";
    }

    @RequestMapping(value = "/create-user", method = RequestMethod.POST)
    public String saveUser(@RequestParam(required = false) Long id,
                           @RequestParam(name = "firstName", required = true) String firstName,
                           @RequestParam String lastName,
                           @RequestParam String email,
                           @RequestParam String password) {

        User user = new User(firstName, lastName, email, password);
        user.setId(id);

        userDao.save(user);

        return "redirect:/users";
    }

//    @RequestMapping(value = "/create-user", method = RequestMethod.POST)
//    public String saveUser(@ModelAttribute User user) {
//
////        User user = new User(firstName, lastName, email, password);
//
//        userDao.save(user);
//
//        return "redirect:/users";
//    }

    @RequestMapping(value = "/users/delete/{id}", method = RequestMethod.POST)
    public String deleteUser(@PathVariable Long id) {

        userDao.delete(id);

        return "redirect:/users";
    }


    @RequestMapping(value = "/users/edit/{id}", method = RequestMethod.GET)
    public String getUserEditPage(@PathVariable Long id, Model model) {

        User user = userDao.findOne(id);

        model.addAttribute("user", user);

        return "user-create";
    }




}
