package it.jac.ledger.controller;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import it.jac.ledger.entities.UserBean;
import it.jac.ledger.services.UserService;
@Controller
public class RegisterController {
	@Autowired
    public UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegisterPage(ModelMap model) {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String handleRegisterRequest(ModelMap model, 
                                        @RequestParam String username,
                                        @RequestParam String password) {
    	UserBean user =new UserBean();
    	user.setUsername(username.toLowerCase());
    	user.setPassword(password);
    	try {
		userService.insUser(user);
	    return "redirect:/login";
	    }catch (PersistenceException e) {
			model.addAttribute("isUsed", true);
			return "register";
		}

	}
	
}
