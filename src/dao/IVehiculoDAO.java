package dao;

import java.sql.Connection;

import model.Vehiculo;

public interface IVehiculoDAO {

	
	/**
	 * Asocia la conexi�n a la base de datos con este DAO.
	 * 
	 * @param conn: Conexi�n a la base de datos.
	 */
	public void setConnection(Connection conn);
	
	
	/**
	 * Obtiene un vehiculo de la base de datos.
	 * 
	 * @param idr: Identificador del vehiculo.
	 * 
	 * @return Vehiculo recuperado de la base de datos.
	 */
	public Vehiculo getVehiculo(long idv);
	

}
