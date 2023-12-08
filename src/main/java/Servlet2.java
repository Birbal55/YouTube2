import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet2 extends HttpServlet {
	protected void processRequest(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		res.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = res.getWriter()){
				out.println("<!DOCTYPE html>");
				out.println("<html>");
				out.println("<head>");
				out.println("<title>Servlet Servlet2</title>");
				out.println("</head>");
				out.println("<body>");
				
				//getting all the cookies..
				Cookie[] cookies = req.getCookies();
				
				boolean f = false;
				String name = "";
				
				if(cookies == null) {
					out.println("<h1>You are new user go to home page and submit your name</h1>");
					return;
				}else {
					for(Cookie c : cookies) {
						String tname = c.getName();
						if(tname.equals("user_name")) {
							f = true;
							name = c.getValue();
						}
					}
				}
				if(f) {
					//String name = req.getParameter("name");
					out.println("<h1>Hello, " + name + "welcome back to my website....</h1>");
					
					out.println("<h1>Thank you !</h1>");
				}else {
					out.println("<h1>You are new user go to home page and submit your name</h1>");
				}
				
				out.println("</body>");
				out.println("</html>");
		}
	}

}
