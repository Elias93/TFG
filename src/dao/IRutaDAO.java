package dao;

import java.sql.Connection;

import model.Ruta;

public interface IRutaDAO {
	
	/**
	 * Asocia la conexi�n a la base de datos con este DAO.
	 * 
	 * @param conn: Conexi�n a la base de datos.
	 */
	public void setConnection(Connection conn);
	
	
	/**
	 * Obtiene una ruta de la base de datos.
	 * 
	 * @param idr: Identificador de la ruta.
	 * 
	 * @return Ruta recuperada de la base de datos.
	 */
	public Ruta getRuta(long idr);
	

}
