package com.rcm.controllers;

import com.rcm.entities.User;
import com.rcm.entities.forms.UserForm;
import com.rcm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET, path = "/home")
    public String homePage(Model model){
        model.addAttribute("name", "Rehan");
        model.addAttribute("website", "https://mymexicanfood.com");
        model.addAttribute("username", "rehanjaved62");
        return "home";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/about")
    public String aboutUs() {
        return "about";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/contact")
    public String contact() {
        return "contact";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/service")
    public String service() {
        return "service";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/signup")
    public String signup(Model model) {
        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);
        return "signup";
    }

    @RequestMapping(method = RequestMethod.POST, path = "/do-register")
    public String doRegister(UserForm userForm) {
        System.out.println("Register: " + userForm.toString());

        User user = User.builder().name(userForm.getFullName())
                .email(userForm.getEmail()).password(userForm.getPassword())
                .about(userForm.getAbout()).phoneNumber(userForm.getPhone()).build();
        userService.save(user);
        return "redirect:/signup";
    }

}
