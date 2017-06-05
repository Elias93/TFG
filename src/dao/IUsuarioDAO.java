package dao;

import java.sql.Connection;
import java.util.List;

import model.Usuario;

public interface IUsuarioDAO {
	
	/**
	 * Asocia la conexión a la base de datos con este DAO.
	 * 
	 * @param conn: Conexión a la base de datos.
	 */
	public void setConnection(Connection conn);
	
	
	/**
	 * Obtiene un usuario de la base de datos.
	 * 
	 * @param idu: Identificador del usuario.
	 * 
	 * @return Usuario recuperado de la base de datos.
	 */
	public Usuario getUsuario(long idu);
	
	
	/**
	 * Obtiene todos los usuarios de la base de datos.
	 * 
	 * @return Lista con todos los usuarios de la base de datos.
	 */
	public List<Usuario> getAllUsuarios();
	
	
	/**
	 * Introduce un usuario de la base de datos.
	 * 
	 * @param usuario: Objeto que contiene la información relativa al usuario que se pretende añadir.
	 *            
	 * @return Identificador de usuario introducido o -1 si ha fallado la operación.
	 */
	public long addUsuario(Usuario usuario);

	
	/**
	 * Introduce un usuario de la base de datos.
	 * 
	 * @param usuario:  Usuario que se pretende actualizar.
	 * 
	 * @return True si la operación ha tenido éxito. False en caso contrario.
	 */
	public boolean saveUsuario(Usuario usuario);


	/**
	 * Elimina un usuario de la base de datos.
	 * 
	 * @param idu: Identificador del usuario que se pretende eliminar.
	 * 
	 * @return True si la operación ha tenido éxito. False en caso contrario.
	 */
	public boolean deleteUsuario(long idu);
	

}
