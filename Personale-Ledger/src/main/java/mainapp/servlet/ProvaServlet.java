package mainapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.UserBean;
import services.UserService;

@WebServlet(urlPatterns="/prova/*", loadOnStartup=1)
public class ProvaServlet extends HttpServlet { /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
	 * 
	 */
	UserService userServ = new UserService();


	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	List<UserBean> u= userServ.SelTutti();
		response.setStatus(200);
		response.setContentType("text/HTML");
    	PrintWriter writer = response.getWriter();
        
        // build HTML code
        String htmlRespone = "<html>";
        htmlRespone += "<h2>Your username is: "+u.get(0).getUsername() + "<br/>";      
        htmlRespone += "Your password is: " + u.get(0).getPassword() + "</h2>";    
        htmlRespone += "</html>";
         
        // return response
        writer.println(htmlRespone);	
    	
    }
    

}
