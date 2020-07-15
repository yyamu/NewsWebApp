package at.javatraining;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

@WebServlet("/")
@SuppressWarnings("serial")
public class NewsServlet extends HttpServlet {
@Autowired
private NewsRepository newsRepository;

	
	public void init(ServletConfig config) throws ServletException {
	super.init(config);
	SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
	HttpSession session = request.getSession(true);
	
	Integer accessCounter = (Integer) session.getAttribute("accesscounter");
	accessCounter = (accessCounter == null ? 1 : accessCounter + 1);
	session.setAttribute("accesscounter", accessCounter);

	// TEST GIT
	List<News> newslist = newsRepository.findAll();
	
	out.print("<h1>News</h1>");
			
	for ( News news : newslist) {
		out.print(
			"<h2>" + news.getTitle() + "</h2>" +
			"<p>" + news.getText() + "</p>"
		);
	}
		out.print(accessCounter + "x aufgerufen");
	}

}
