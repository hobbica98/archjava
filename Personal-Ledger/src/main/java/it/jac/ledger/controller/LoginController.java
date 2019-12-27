package it.jac.ledger.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	private static Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(path = "/login")
    public String login() {
		
		log.info("forward to login page");
		
        return "login";  
    }  

    @RequestMapping("/login-error")  
    public String loginError(Model model) { 
        model.addAttribute("loginError", true);  
        return "login";  
    }  
}
