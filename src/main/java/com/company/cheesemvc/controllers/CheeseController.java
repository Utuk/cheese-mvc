package com.company.cheesemvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;    //(imported for HttpServletRequest method of importing data)

@Controller
@RequestMapping("cheese")
public class CheeseController {

    static ArrayList<String> cheeses = new ArrayList<>();
    //private AttributedString model;

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model){

        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    //request path: cheese/add (get)
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    //request path: cheese/add (post)
    @RequestMapping(value = "add", method = RequestMethod.POST)
    //**not typical spring method for extracting data - lower api method
    // must match variable name in template ex: cheeseName in .add**

    //public String processAddCheeseForm(HttpServletRequest request) {
        //String cheeseName = request.getParameter("cheeseName");

    public String processAddCheeseForm(@RequestParam String cheeseName){
        cheeses.add(cheeseName);

        //redirect to /cheese
        return "redirect:";

    }
}
