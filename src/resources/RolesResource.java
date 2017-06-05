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

import dao.JDBCRolDAOImpl;
import dao.IRolDAO;
import model.Rol;


@Path("/roles")
public class RolesResource {
	
	@Context
	ServletContext sc;
	@Context
	UriInfo uriInfo;
	
	/**
	 * @param request, rolid
	 * @return Un rol concreto en función de su id
	 */
	@GET
	@Path("/{rolid: [0-9]+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Rol getRolJSON(
			@PathParam("rolid") long rolid, 
			@Context HttpServletRequest request) {

		Connection conn = (Connection) sc.getAttribute("dbConn");
		IRolDAO rolDAO = new JDBCRolDAOImpl();
		rolDAO.setConnection(conn);
		Rol rol = rolDAO.getRol(rolid);

		return rol;
	}

	
}
