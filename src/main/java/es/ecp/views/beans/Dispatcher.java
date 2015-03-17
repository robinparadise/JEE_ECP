package es.ecp.views.beans;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;

@WebServlet("/jsp/*")
public class Dispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String PATH_ROOT_VIEW = "/views/jsp/";

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String view = "index";

		LogManager.getLogger().debug("[view]: " + view);

		if (request.getPathInfo() != null) {
			String action = request.getPathInfo().substring(1);

			LogManager.getLogger().debug("[action]: " + action);

			request.setCharacterEncoding("UTF-8");
			switch (action) {
			case "temas":
				LogManager.getLogger().debug("@[:Temas]");
				TemaBean temaBean = new TemaBean();
				temaBean.update();
				request.setAttribute(action, temaBean);
				view = action;
				break;
			case "newtema":
				LogManager.getLogger().debug("@[:NEW]");
				view = action;
				break;
			default:
				LogManager.getLogger().debug("View NOT FOUND: " + view);
				break;
			}
		}

		LogManager.getLogger().debug(PATH_ROOT_VIEW + view + ".jsp");
		this.getServletContext()
				.getRequestDispatcher(PATH_ROOT_VIEW + view + ".jsp")
				.forward(request, response);

	}

}
