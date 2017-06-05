package dao;

import java.sql.Connection;

import model.Rol;

public interface IRolDAO {
	
	/**
	 * Asocia la conexión a la base de datos con este DAO.
	 * 
	 * @param conn: Conexión a la base de datos.
	 */
	public void setConnection(Connection conn);
	
	
	/**
	 * Obtiene un rol de la base de datos.
	 * 
	 * @param idr: Identificador del rol.
	 * 
	 * @return Rol recuperado de la base de datos.
	 */
	public Rol getRol(long idr);
	

}
