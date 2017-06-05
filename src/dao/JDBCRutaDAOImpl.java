package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Ruta;

public class JDBCRutaDAOImpl implements IRutaDAO{

	private Connection conn;
	
	@Override
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	
	@Override
	public Ruta getRuta(long idr) {
		if (conn == null) return null;
		
		Ruta ruta = null;		
		try {
			Statement stmt;
			ResultSet rs;
			synchronized (conn) {
				stmt = conn.createStatement();
				
				String consulta = "SELECT * FROM public.\"Ruta\" WHERE \"IDR\"="+idr;
				System.out.println(consulta);
				rs = stmt.executeQuery(consulta);			
			}
			
			if (!rs.next()) return null; 
			ruta = new Ruta();	 
			ruta.setIdr(rs.getLong("idr"));
			ruta.setNombreRuta(rs.getString("nombreRuta"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ruta;
	}
	
}
