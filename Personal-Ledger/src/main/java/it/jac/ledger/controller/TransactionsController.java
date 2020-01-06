package it.jac.ledger.controller;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.jac.ledger.configuration.IAuthenticationFacade;
import it.jac.ledger.entities.TransactionBean;
import it.jac.ledger.services.TransactionService;

@Controller
public class TransactionsController implements IAuthenticationFacade {
 
	private static final String AJAX_HEADER_NAME = "X-Requested-With";
    private static final String AJAX_HEADER_VALUE = "XMLHttpRequest";
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
    	try {
    	List<TransactionBean> list = this.transactionService.selByUsername(getAuthentication().getName());
    	log.debug("trovate " + list.size() + " transazioni");
    	String bilancio = new DecimalFormat("##.##").format(this.transactionService.getBilancioByUsername(getAuthentication().getName()));
    	log.debug("trovato bilancio = " + bilancio);

    	model.addAttribute("list", list);
    	model.addAttribute("balance", bilancio);
    	}catch (Exception e) {
			// TODO: handle exception
		}
    	
    	model.addAttribute("username", getAuthentication().getName());
        return "transactions";
    }
	
    @PostMapping( path = "/transactions/save")
	public String saveTransaction(@RequestParam(name="saveItem") int index, @RequestParam(name="data") String data, @RequestParam(name="causale") String causale, @RequestParam(name="valore")String valore) {
   TransactionBean trans =new TransactionBean();
   trans.setCausale(causale);
   trans.setData(java.sql.Date.valueOf(data));
   trans.setId(index);
   trans.setUsername(getAuthentication().getName());
   trans.setValore(Float.parseFloat(valore));
		transactionService.save(trans);
        return "transactions";
	}
	
	@PostMapping( path = "/transactions/add")
	public String addTransaction( @RequestParam(name="data") String data, @RequestParam(name="causale") String causale, @RequestParam(name="valore")String valore) {
		   TransactionBean trans =new TransactionBean();
		   trans.setCausale(causale);
		   trans.setData(java.sql.Date.valueOf(data));
		   trans.setUsername(getAuthentication().getName());
		   trans.setValore(Float.parseFloat(valore));
		transactionService.insTransaction(trans);
		return "transactions";
	
	}
	
	@PostMapping(params = "removeItem", path = {"/transactions", "/transactions/{id}"})
	public String removeTransaction(@RequestParam(name="removeItem") int index, HttpServletRequest request) {
		transactionService.delTransaction(index);
		return "transactions";
	
	}


}
