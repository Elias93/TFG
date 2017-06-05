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

import dao.IFlotaDAO;
import dao.JDBCFlotaDAOImpl;
import model.Flota;


@Path("/flotas")
public class FlotasResource {
	
	@Context
	ServletContext sc;
	@Context
	UriInfo uriInfo;
	
	/**
	 * @param request, flotaid
	 * @return Una flota concreta en función de su id
	 */
	@GET
	@Path("/{flotaid: [0-9]+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Flota getRolJSON(
			@PathParam("flotaid") long flotaid, 
			@Context HttpServletRequest request) {

		Connection conn = (Connection) sc.getAttribute("dbConn");
		IFlotaDAO flotaDAO = new JDBCFlotaDAOImpl();
		flotaDAO.setConnection(conn);
		Flota flota = flotaDAO.getFlota(flotaid);

		return flota;
	}

	
}
