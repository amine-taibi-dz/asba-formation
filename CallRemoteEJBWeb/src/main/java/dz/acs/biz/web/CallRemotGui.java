package dz.acs.biz.web;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dz.acs.biz.calc.CalcRemote;

/**
 * Servlet implementation class CallRemotGui
 */
@WebServlet("/CallRemotGui")
public class CallRemotGui extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB(lookup = "java:global/CalcBiz/Calc!dz.acs.biz.calc.CalcRemote")
	private CalcRemote calRemote;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CallRemotGui() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("\n");
		response.getWriter().append("calRemote : add(100,200) : ")
				.append(calRemote.add(100L, 200L).toString());
		response.getWriter().append("\n");
		response.getWriter().append("calRemote : multi(100,200) : ")
				.append(calRemote.multi(3L, 200L).toString());
		response.getWriter().append("\n");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
