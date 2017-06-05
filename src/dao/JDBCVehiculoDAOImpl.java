package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Vehiculo;

public class JDBCVehiculoDAOImpl implements IVehiculoDAO{

	private Connection conn;
	
	@Override
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	

	@Override
	public Vehiculo getVehiculo(long idv) {
		if (conn == null) return null;
		
		Vehiculo vehiculo = null;		
		try {
			Statement stmt;
			ResultSet rs;
			synchronized (conn) {
				stmt = conn.createStatement();
				
				String consulta = "SELECT * FROM public.\"Vehiculo\" WHERE \"IDV\"="+idv;
				System.out.println(consulta);
				rs = stmt.executeQuery(consulta);			
			}
			
			if (!rs.next()) return null; 
			vehiculo = new Vehiculo();	 
			vehiculo.setIdv(rs.getLong("idv"));
			vehiculo.setIdf(rs.getLong("idf"));
			vehiculo.setIdl(rs.getLong("idl"));
			vehiculo.setIdr(rs.getLong("idr"));
			vehiculo.setKilometros(rs.getInt("kilometros"));
			vehiculo.setVelocidad(rs.getInt("velocidad"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vehiculo;
	}

}
