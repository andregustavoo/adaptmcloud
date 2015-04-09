package healthwatcher.testbed;

import healthwatcher.aspects.testbed.TestBed;

import java.io.IOException;
import java.net.MalformedURLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.aop.AspectXmlLoader;

/**
 * Servlet implementation class ServletTestBed
 */
public class ServletTestBed extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private TestBed testBed;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTestBed() {
        super();
        testBed=new TestBed();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			AspectXmlLoader.deployXML(request.getServletContext().getResource("/WEB-INF/jboss-aop.xml"));
		} catch (MalformedURLException e) {

			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		int opt=Integer.parseInt(request.getParameter("opt"));
		switch(opt){
		case 1:
			testBed.testBed01();
			break;
		case 2:
			testBed.testBed02();
			break;
		case 3:
			testBed.testBed03();
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
