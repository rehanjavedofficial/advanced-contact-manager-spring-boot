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

}
