package it.jac.ledger.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.jac.ledger.configuration.IAuthenticationFacade;

@Controller
public class LoginController implements IAuthenticationFacade {
 
    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

	private static Logger log = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(path = "/login")
    public String login(Model model) {
		
		log.info("forward to login page");
		
        return "login";  
    }  

    @RequestMapping("/login-error")  
    public String loginError(Model model) { 
        model.addAttribute("loginError", true);  
        return "login";  
    }  
}
