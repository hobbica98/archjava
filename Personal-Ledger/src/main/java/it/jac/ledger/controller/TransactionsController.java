package it.jac.ledger.controller;

import java.sql.Date;
import java.text.DecimalFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import it.jac.ledger.configuration.IAuthenticationFacade;
import it.jac.ledger.entities.TransactionBean;
import it.jac.ledger.entities.UserBean;
import it.jac.ledger.services.TransactionService;

@Controller
public class TransactionsController implements IAuthenticationFacade {
 
    @Override
    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }
	private static Logger log = LoggerFactory.getLogger(TransactionsController.class);
	
	// serve per gestire la dipendenza tra gli oggetti
	// la classe deve però essere annotata con alcune tra quelle disponibili in Spring
	// (es. Component, Service, etc..)
	@Autowired
    public TransactionService transactionService;
	
	@GetMapping(value = "/transactions")
    public String findAllTransactions(Model model) {

    	log.info("Ricevuta richiesta di mostrare tutte le transazioni");
    ;
		System.out.println("****************************************************************************************************");
		System.out.println(getAuthentication().getName());
    	List<TransactionBean> list = this.transactionService.selByUsername(getAuthentication().getName());
    	log.debug("trovate " + list.size() + " transazioni");
    	String bilancio = new DecimalFormat("##.##").format(this.transactionService.getBilancioByUsername(getAuthentication().getName()));
    	log.debug("trovato bilancio = " + bilancio);
    	
    	model.addAttribute("username", getAuthentication().getName());
    	model.addAttribute("list", list);
    	model.addAttribute("balance", bilancio);
    	
        return "transactions";
    }
	
	

}
