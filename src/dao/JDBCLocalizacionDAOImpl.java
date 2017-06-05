package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Localizacion;

public class JDBCLocalizacionDAOImpl implements ILocalizacionDAO {
	
	private Connection conn;
	
	@Override
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	

	@Override
	public Localizacion getLocalizacion(long idl) {
		if (conn == null) return null;
		
		Localizacion localizacion = null;
		
		try {
			Statement stmt;
			ResultSet rs;
			synchronized (conn) {
				stmt = conn.createStatement();
				
				String consulta = "SELECT * FROM public.\"Localizacion\" WHERE \"IDL\"="+idl;
				System.out.println(consulta);
				rs = stmt.executeQuery(consulta);			
			}
			
			if (!rs.next()) return null; 
			localizacion = new Localizacion();	 
			localizacion.setIdl(rs.getLong("idl"));
			localizacion.setLatitud(rs.getFloat("latitud"));
			localizacion.setLongitud(rs.getFloat("longitud"));
			localizacion.setCoordenadas(rs.getString("coordenadas"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return localizacion;
	}

}
