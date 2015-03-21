package es.ecp.views.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;

import es.ecp.models.utils.NivelEstudios;

@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String PATH_ROOT_VIEW = "/views/jsp/";

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String view = "index";

		if (request.getPathInfo() != null) {
			String action = request.getPathInfo().substring(1);

			request.setCharacterEncoding("UTF-8");
			switch (action) {
			case "temas":
				ListTemasBean listTemasBean = new ListTemasBean();
				listTemasBean.update();
				request.setAttribute(action, listTemasBean);
				view = action;
				break;
			case "newtema":
				view = action;
				break;
			case "votar":
				AddVotoBean addVotoBean = new AddVotoBean();
				String id = request.getParameter("temaid");
				System.out.println("[id] -> " + id.toString());
				addVotoBean.setTemaId(Integer.valueOf(id));
				request.setAttribute(action, addVotoBean);
				view = action;
				break;
			default:
				break;
			}
		}

		LogManager.getLogger().debug(PATH_ROOT_VIEW + view + ".jsp");
		this.getServletContext()
				.getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
				.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String view = "index";

		if (request.getPathInfo() != null) {
			String action = request.getPathInfo().substring(1);

			request.setCharacterEncoding("UTF-8");
			switch (action) {
			case "newtema":
				AddTemaView addTemaView = new AddTemaView(
						request.getParameter("name"),
						request.getParameter("question"));
				addTemaView.update();
				ListTemasBean listTemasBean = new ListTemasBean();
				listTemasBean.update();
				request.setAttribute("temas", listTemasBean);
				view = "temas";
				break;
			case "votar":
				AddVotoBean addVotoBean = new AddVotoBean();
	        	String id = request.getParameter("temaid");
	        	String val = request.getParameter("valoracion");
	        	String nivelEstudios = request.getParameter("nivel_estudios");
	        	addVotoBean.setTemaId(Integer.valueOf(id));
	        	addVotoBean.setNivelEstudios(NivelEstudios.valueOf(nivelEstudios));
	        	addVotoBean.setValoracion(Integer.valueOf(val));
	        	addVotoBean.setUserIp(request.getRemoteAddr());
	        	addVotoBean.update();
	        	addVotoBean.process();
	        	view = "temas";
	        	break;
			default:
				break;
			}
		}

		this.getServletContext()
				.getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
				.forward(request, response);
	}

}
