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

import dao.JDBCVehiculoDAOImpl;
import dao.IVehiculoDAO;
import model.Vehiculo;


@Path("/vehiculos")
public class VehiculosResource {
	
	@Context
	ServletContext sc;
	@Context
	UriInfo uriInfo;
	
	
	/**
	 * @param request, vehiculoid
	 * @return Un vehiculo concreto en función de su id
	 */
	@GET
	@Path("/{vehiculoid: [0-9]+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Vehiculo getVehiculoJSON(
			@PathParam("vehiculoid") long vehiculoid, 
			@Context HttpServletRequest request) {

		Connection conn = (Connection) sc.getAttribute("dbConn");
		IVehiculoDAO vehiculoDAO = new JDBCVehiculoDAOImpl();
		vehiculoDAO.setConnection(conn);
		Vehiculo vehiculo = vehiculoDAO.getVehiculo(vehiculoid);

		return vehiculo;
	}

	
}
