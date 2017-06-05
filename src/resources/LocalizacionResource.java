package resources;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import dao.JDBCLocalizacionDAOImpl;
import dao.ILocalizacionDAO;
import model.Localizacion;


@Path("/localizaciones")
public class LocalizacionResource {

	@Context
	ServletContext sc;
	@Context
	UriInfo uriInfo;
	
	/**
	 * @param request, localizacionid
	 * @return Una localizacion concreta en función de su id
	 */
	@GET
	@Path("/{localizacionid: [0-9]+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Localizacion getLocalizacionJSON(
			@PathParam("localizacionid") long localizacionid, 
			@Context HttpServletRequest request) {

		Connection conn = (Connection) sc.getAttribute("dbConn");
		ILocalizacionDAO localizacionDAO = new JDBCLocalizacionDAOImpl();
		localizacionDAO.setConnection(conn);
		Localizacion localizacion = localizacionDAO.getLocalizacion(localizacionid);

		return localizacion;
	}

}
