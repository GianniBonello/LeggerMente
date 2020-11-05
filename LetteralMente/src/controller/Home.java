package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="home",urlPatterns= {"/home"})
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Home() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getServletContext().getNamedDispatcher("controllologinsessione").include(request, response);
		request.getServletContext().getRequestDispatcher("/header.jsp").include(request, response);
		request.getServletContext().getNamedDispatcher("view").include(request, response);
		request.getServletContext().getNamedDispatcher("controllologin").include(request, response);
		request.getServletContext().getNamedDispatcher("controlloregistrazione").include(request, response);
		request.getServletContext().getNamedDispatcher("controllolistalibri").include(request, response);
		request.getServletContext().getRequestDispatcher("/footer.jsp").include(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
