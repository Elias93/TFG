package resources;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import dao.JDBCUsuarioDAOImpl;
import dao.IUsuarioDAO;
import model.Usuario;
import resources.exception.CustomBadRequestException;

@Path("/usuarios")
public class UsuariosResource {

	@Context
	ServletContext sc;
	@Context
	UriInfo uriInfo;
	
	
	/**
	 * @param request, usuarioid
	 * @return Un usuario concreto en función de su id
	 */
	@GET
	@Path("/{usuarioid: [0-9]+}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario getUsuarioJSON(
			@PathParam("usuarioid") long usuarioid, 
			@Context HttpServletRequest request) {

		Connection conn = (Connection) sc.getAttribute("dbConn");
		IUsuarioDAO usuarioDAO = new JDBCUsuarioDAOImpl();
		usuarioDAO.setConnection(conn);
		Usuario user = usuarioDAO.getUsuario(usuarioid);

		return user;
	}

	
	/**
	 * @param request
	 * @return Obtener todos los usuarios
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> getAllUsuariosJSON(
			@Context HttpServletRequest request) {
		
		Connection conn = (Connection) sc.getAttribute("dbConn");
		IUsuarioDAO userDAO = new JDBCUsuarioDAOImpl();
		userDAO.setConnection(conn);
		ArrayList<Usuario> Usuarios = (ArrayList<Usuario>) userDAO.getAllUsuarios();

		return Usuarios;
	}
	
	
	/**
	 * @param request, usuario
	 * Añade un nuevo usuario a la base de datos
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postUsuarioJSON(
			Usuario usuario, 
			@Context HttpServletRequest request) throws Exception {

		Connection conn = (Connection) sc.getAttribute("dbConn");
		IUsuarioDAO usuarioDAO = new JDBCUsuarioDAOImpl();
		usuarioDAO.setConnection(conn);
		
		//Validar parámetros de entrada del nuevo usuario
		Map<String, String> mensajes = new HashMap<String, String>();
		if(!usuario.validar(mensajes)){
			  throw new CustomBadRequestException("Error en los parámetros: "+mensajes);
		}
		//Comprobar que el nombre de usuario y email no están registrados
			//...
		
		long idu = usuarioDAO.addUsuario(usuario);	
		
		Response response = Response //return 201
				.created(uriInfo.getAbsolutePathBuilder().path(Long.toString(idu)).build())
				.contentLocation(uriInfo.getAbsolutePathBuilder().path(Long.toString(idu)).build()).build();		
				
		return response;
	}

	
	/**
	 * @param request, usuarioid, usuario
	 * Salva los datos de un usuario en la base de datos
	 */
	@PUT
	@Path("/{usuarioid: [0-9]+}")
    @Consumes(MediaType.APPLICATION_JSON)
	public Response putUsuarioJSON(
			Usuario usuario, 
			@PathParam("usuarioid") long usuarioid, 
			@Context HttpServletRequest request) throws Exception{
		
		Response response = null;
		Connection conn = (Connection) sc.getAttribute("dbConn");
		IUsuarioDAO usuarioDAO = new JDBCUsuarioDAOImpl();
		usuarioDAO.setConnection(conn);

		//Comprobamos que el usuario que se quiere actualizar existe y es el que pertenece a la actual sesión.
			//...
		
		if(usuario != null){
			if(usuario.getIdu()!=usuarioid){
				throw new CustomBadRequestException("Error en los id");
			}
			
			usuarioDAO.saveUsuario(usuario);				
			
		}else{				
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}	
		
		return response;
	 }

	
	/**
	 * @param request, usuarioid
	 * Elimina un usuario por su id
	 */
	@DELETE
	@Path("/{usuarioid: [0-9]+}")	  
	public Response DeleteUsuarioJSON(
			@PathParam("usuarioid") long usuarioid, 
			@Context HttpServletRequest request) {
		  
			Connection conn = (Connection) sc.getAttribute("dbConn");
			IUsuarioDAO usuarioDAO = new JDBCUsuarioDAOImpl();
			usuarioDAO.setConnection(conn);		
			
			//Compruebo que el usuario que desea eliminar su cuenta sea el que esté en la sesión.
				//...
			
			usuarioDAO.deleteUsuario(usuarioid);
			
			return Response.noContent().build(); //204 no content 
			
	  }


}
