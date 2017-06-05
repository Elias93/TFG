package dao;

import java.sql.Connection;

import model.Destino;


public interface IDestinoDAO {
	
	/**
	 * Asocia la conexión a la base de datos con este DAO.
	 * 
	 * @param conn: Conexión a la base de datos.
	 */
	public void setConnection(Connection conn);
	
	
	/**
	 * Obtiene un destino de la base de datos.
	 * 
	 * @param idd: Identificador del destino.
	 * 
	 * @return Destino recuperado de la base de datos.
	 */
	public Destino getDestino(long idd);
	

}
