package dao;

import java.sql.Connection;

import model.Flota;

public interface IFlotaDAO {
	
	/**
	 * Asocia la conexi�n a la base de datos con este DAO.
	 * 
	 * @param conn: Conexi�n a la base de datos.
	 */
	public void setConnection(Connection conn);
	
	
	/**
	 * Obtiene una flota de la base de datos.
	 * 
	 * @param idf: Identificador de la flota.
	 * 
	 * @return Flotad recuperado de la base de datos.
	 */
	public Flota getFlota(long idf);


}
