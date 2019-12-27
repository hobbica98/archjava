package it.jac.ledger.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.view.RedirectView;

import it.jac.ledger.entities.TransactionBean;
import it.jac.ledger.entities.UserBean;
import it.jac.ledger.services.TransactionService;

@Controller
public class TransactionsController {

	private static Logger log = LoggerFactory.getLogger(TransactionsController.class);
	
	// serve per gestire la dipendenza tra gli oggetti
	// la classe deve però essere annotata con alcune tra quelle disponibili in Spring
	// (es. Component, Service, etc..)
	@Autowired
    public TransactionService transactionService;
	
	@GetMapping(value = "/transactions")
    public String findAllTransactions(Model model) {
    	
    	log.info("Ricevuta richiesta di mostrare tutte le transazioni");
    	
    	UserBean u = (UserBean) model.getAttribute("User");
    	List<TransactionBean> list = this.transactionService.selTutti();
    	log.debug("trovate " + list.size() + " transazioni");
    	
    	model.addAttribute("list", list);
    	
        return "transactions";
    }
	
	//FINZIONANTE
	@PostMapping(path = "/loginServlet")
	public RedirectView findAttributeLogin(UserBean user, Model model)
	{
		System.out.println("****************************************************************************************************");
		System.out.println(user.getUsername());
		
		model.addAttribute("User", user);
		
		return new RedirectView("/transactions");
	}
	

}
