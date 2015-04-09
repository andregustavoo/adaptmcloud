package healthwatcher.frascati.storage;

import healthwatcher.FrascatiManager;
import healthwatcher.storage.IStorage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletComponent
 */
@WebServlet("/ServletComponent")
public class ServletComponent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletComponent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String file=request.getParameter("file");
		IStorage storage=FrascatiManager.getService("store", IStorage.class);
		String result=storage.load(file);
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<title>Example</title>");
		out.println("<body><h1>"+result+"</h1></body>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
