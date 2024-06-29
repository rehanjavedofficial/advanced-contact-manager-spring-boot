package com.rcm.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

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
    public String signup() {
        return "signup";
    }

}
