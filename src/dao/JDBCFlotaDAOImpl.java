package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Flota;

public class JDBCFlotaDAOImpl implements IFlotaDAO{
	
	private Connection conn;
	
	@Override
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	

	@Override
	public Flota getFlota(long idf) {
		if (conn == null) return null;
		
		Flota flota = null;		
		try {
			Statement stmt;
			ResultSet rs;
			synchronized (conn) {
				stmt = conn.createStatement();
				
				String consulta = "SELECT * FROM public.\"Flota\" WHERE \"IDF\"="+idf;
				System.out.println(consulta);
				rs = stmt.executeQuery(consulta);			
			}
			
			if (!rs.next()) return null; 
			flota = new Flota();	 
			flota.setIdf(rs.getLong("idf"));
			flota.setNombreFlota(rs.getString("nombreFlota"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flota;
	}

}
