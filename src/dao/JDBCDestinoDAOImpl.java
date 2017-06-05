package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Destino;

public class JDBCDestinoDAOImpl implements IDestinoDAO{

	private Connection conn;
	
	@Override
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	
	@Override
	public Destino getDestino(long idd) {
		if (conn == null) return null;
		
		Destino destino = null;		
		try {
			Statement stmt;
			ResultSet rs;
			synchronized (conn) {
				stmt = conn.createStatement();
				
				String consulta = "SELECT * FROM public.\"Destino\" WHERE \"IDD\"="+idd;
				System.out.println(consulta);
				rs = stmt.executeQuery(consulta);			
			}
			
			if (!rs.next()) return null; 
			destino = new Destino();	 
			destino.setIdd(rs.getLong("idd"));
			destino.setNombreDestino(rs.getString("nombreDestino"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return destino;
	}
	
}
