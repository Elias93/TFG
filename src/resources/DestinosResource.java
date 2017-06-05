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

import dao.IDestinoDAO;
import dao.JDBCDestinoDAOImpl;
import model.Destino;


@Path("/destinos")
public class DestinosResource {
	
	@Context
	ServletContext sc;
	@Context
	UriInfo uriInfo;
	
	/**
	 * @param request, destinoid
	 * @return Un destino concreto en función de su id
	 */
	@GET
	@Path("/{destinoid: [0-9]+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Destino getDestinoJSON(
			@PathParam("destinoid") long destinoid, 
			@Context HttpServletRequest request) {

		Connection conn = (Connection) sc.getAttribute("dbConn");
		IDestinoDAO destinoDAO = new JDBCDestinoDAOImpl();
		destinoDAO.setConnection(conn);
		Destino destino = destinoDAO.getDestino(destinoid);

		return destino;
	}

	
}
