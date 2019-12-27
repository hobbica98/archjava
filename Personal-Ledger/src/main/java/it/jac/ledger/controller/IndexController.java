package it.jac.ledger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.jac.ledger.services.TransactionService;
import it.jac.ledger.services.UserService;
//@Controller
//@RequestMapping("/")
public class IndexController {
	
    @Autowired
    public TransactionService transactionService;
    public UserService userService;

    public IndexController(TransactionService transactionService, UserService userService) {
		super();
		this.transactionService = transactionService;
		this.userService = userService;
	}
    
    
	@GetMapping
    public String getWelcome(Model model) {
        this.setModel(model);
        return "index";
    }

    @GetMapping(value = "index")
    public String getWelcomeIndex(Model model) {
        return getWelcome(model);
    }

    private Model setModel(Model model) {
    	model.addAttribute("username", userService.selByUsername("Liviu"));
        return model;
    }
}