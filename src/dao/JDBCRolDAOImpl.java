package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Rol;

public class JDBCRolDAOImpl implements IRolDAO{

	private Connection conn;
	
	@Override
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	

	@Override
	public Rol getRol(long idr) {
		if (conn == null) return null;
		
		Rol rol = null;		
		try {
			Statement stmt;
			ResultSet rs;
			synchronized (conn) {
				stmt = conn.createStatement();
				
				String consulta = "SELECT * FROM public.\"Rol\" WHERE \"IDR\"="+idr;
				System.out.println(consulta);
				rs = stmt.executeQuery(consulta);			
			}
			
			if (!rs.next()) return null; 
			rol = new Rol();	 
			rol.setIdr(rs.getLong("idr"));
			rol.setNombreRol(rs.getString("nombreRol"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rol;
	}

}
