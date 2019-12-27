package it.jac.ledger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.jac.ledger.services.UserService;

@Controller
public class IndexController {
	
    @Autowired
    public UserService userService;

    @GetMapping(path = "index")
    public String getWelcomeIndex(Model model) {
        this.setModel(model);
        return "redirect:/transactions";
    }

    private Model setModel(Model model) {
    	model.addAttribute("username", userService.selByUsername("Liviu"));
        return model;
    }
}