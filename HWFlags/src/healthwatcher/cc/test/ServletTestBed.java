package healthwatcher.cc.test;

import healthwatcher.ConfigurationHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletTestBed
 */
@WebServlet("/ServletTestBed")
public class ServletTestBed extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTestBed() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				int opt=Integer.parseInt(request.getParameter("opt"));
				switch(opt){
				case 1:
					ConfigurationHandler.getInstance().addFeature(ConfigurationHandler.Features.STORAGE, ConfigurationHandler.AWSSTORAGE);
					break;
				case 2:
					ConfigurationHandler.getInstance().addFeature(ConfigurationHandler.Features.STORAGE, ConfigurationHandler.DROPBOXSTORAGE);
					break;
				case 3:
					ConfigurationHandler.getInstance().addFeature(ConfigurationHandler.Features.STORAGE, ConfigurationHandler.RACKSPACESTORAGE);
					break;
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
