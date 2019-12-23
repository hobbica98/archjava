package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import services.TransactionServiceImpl;
import services.UserServiceImpl;

@Controller
@RequestMapping("/")
public class Controller {
	
    @Autowired
    public TransactionServiceImpl transactionService;
    public UserServiceImpl userService;

    public Controller(TransactionServiceImpl transactionService, UserServiceImpl userService) {
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
    	model.addAttribute("username", userService.SelByUsername("Liviu"));
        return model;
    }
}