package it.jac.ledger.mainapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.jac.ledger.entities.TransactionBean;
import it.jac.ledger.entities.UserBean;
import it.jac.ledger.services.TransactionService;
import it.jac.ledger.services.UserService;

@WebServlet(urlPatterns="/prova/*", loadOnStartup=1)
public class ProvaServlet extends HttpServlet { 
	private static final long serialVersionUID = 1L;

	UserService userServ = new UserService();
	TransactionService transServ = new TransactionService();


	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserBean u2 = userServ.selByUsername("Liviu");
		//transServ.SelTutti();
    	TransactionBean t= transServ.selById(1);
    	//t.getId();
		//UserBean u = new UserBean();
		//u.setUsername("paolo2");
		//u.setPassword("pass");
		//userServ.InsUser(u);
		response.setStatus(200);
		response.setContentType("text/HTML");
    	PrintWriter writer = response.getWriter();
        
        // build HTML code
        String htmlRespone = "<html>";
        htmlRespone += "<h2>Your username is: "+u2.getUsername() + "<br/>";      
        htmlRespone += "<h2>Your username from transaction is: "+ t.getUsername().getUsername() + "<br/>";     
        htmlRespone += "Your password is: "  + u2.getPassword() + "</h2>";    
        htmlRespone += "</html>";
         
        // return response
        writer.println(htmlRespone);	
    	
    }
    

}
