package it.jac.ledger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import it.jac.ledger.configuration.IAuthenticationFacade;
import it.jac.ledger.services.UserService;

@Controller
public class IndexController implements IAuthenticationFacade {
 
    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
	
    @Autowired
    public UserService userService;

    @GetMapping(path = "/")
    public String getWelcomeIndex(Model model) {
    	model.addAttribute("username", getAuthentication().getName());
        return "index";
    }
}