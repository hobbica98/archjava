package mainapp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import services.UserServiceImpl;

@WebServlet(urlPatterns="/prova/*", loadOnStartup=1)
public class ProvaServlet extends HttpServlet { /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
/**
	 * 
	 *//*
	@Autowired
	UserServiceImpl userServ;
	public ProvaServlet(UserServiceImpl userServ) {
	this.userServ = userServ;
    }
	*/
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*
    	List<User> u= userServ.SelTutti();
    	System.out.println(u.get(0).getPassword());*/
		response.setStatus(200);
		response.setContentType("text/HTML");
    	PrintWriter writer = response.getWriter();
        
        // build HTML code
        String htmlRespone = "<html>";
        htmlRespone += "<h2>Your username is: "+ "<br/>";      
        htmlRespone += "Your password is: " + "</h2>";    
        htmlRespone += "</html>";
         
        // return response
        writer.println(htmlRespone);	
    	
    }
    

}
