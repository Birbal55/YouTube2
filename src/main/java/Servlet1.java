import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet1 extends HttpServlet {
	protected void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		res.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = res.getWriter()){
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Servlet Servlet1</title>");
				out.println("</head>");
				out.println("<body>");
				
				String name = req.getParameter("name");
				out.println("<h1>Hello, " + name + "welcome to my website....</h1>");
				
				out.println("<h1><a href='servlet2'>Go to servlet 2</a></h1>");
				
				
				//create a cookie
				Cookie c = new Cookie("user_name",name);
				res.addCookie(c);
				
				out.println("</body>");
				out.println("</html>");
		}
	}
}
