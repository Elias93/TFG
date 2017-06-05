package dao;

import java.sql.Connection;

import model.Localizacion;

public interface ILocalizacionDAO {
	
	/**
	 * Asocia la conexi�n a la base de datos con este DAO.
	 * 
	 * @param conn: Conexi�n a la base de datos.
	 */
	public void setConnection(Connection conn);
	
	
	/**
	 * Obtiene una localizacion de la base de datos.
	 * 
	 * @param idr: Identificador de la localizacion.
	 * 
	 * @return localizacion recuperada de la base de datos.
	 */
	public Localizacion getLocalizacion(long idl);
	
}
