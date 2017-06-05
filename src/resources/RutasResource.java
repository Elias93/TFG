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

import dao.JDBCRutaDAOImpl;
import dao.IRutaDAO;
import model.Ruta;


@Path("/rutas")
public class RutasResource {
	
	@Context
	ServletContext sc;
	@Context
	UriInfo uriInfo;
	
	/**
	 * @param request, rutaid
	 * @return Una ruta concreta en función de su id
	 */
	@GET
	@Path("/{rutaid: [0-9]+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Ruta getRutaJSON(
			@PathParam("rutaid") long rutaid, 
			@Context HttpServletRequest request) {

		Connection conn = (Connection) sc.getAttribute("dbConn");
		IRutaDAO rutaDAO = new JDBCRutaDAOImpl();
		rutaDAO.setConnection(conn);
		Ruta ruta = rutaDAO.getRuta(rutaid);

		return ruta;
	}

	
}
