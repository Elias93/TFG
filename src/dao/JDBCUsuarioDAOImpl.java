package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class JDBCUsuarioDAOImpl implements IUsuarioDAO {

	private Connection conn;
	
	@Override
	public void setConnection(Connection conn) {
		this.conn = conn;
	}
	
	
	@Override
	public Usuario getUsuario(long idu) {
		if (conn == null) return null;
		
		Usuario usuario = null;		
		try {
			Statement stmt;
			ResultSet rs;
			synchronized (conn) {
				stmt = conn.createStatement();
				
				String consulta = "SELECT * FROM public.\"Usuario\" WHERE \"IDU\"="+idu;
				System.out.println(consulta);
				rs = stmt.executeQuery(consulta);			
			}
			
			if (!rs.next()) return null; 
			usuario = new Usuario();	 
			usuario.setIdu(rs.getLong("idu"));
			usuario.setIdv(rs.getLong("idv"));
			usuario.setIdr(rs.getLong("idr"));
			usuario.setEmail(rs.getString("email"));
			usuario.setNombre(rs.getString("nombreUsuario"));
			usuario.setPassword(rs.getString("password"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
	

	@Override
	public List<Usuario> getAllUsuarios() {

		if (conn == null) return null;
		
		ArrayList<Usuario> Usuarios = new ArrayList<Usuario>();
		try {
			Statement stmt;
			ResultSet rs;
			synchronized (conn) {
				stmt = conn.createStatement();
				String consulta = "SELECT * FROM public.\"Usuario\"";
				
				System.out.println(consulta);
				rs = stmt.executeQuery(consulta);
			}
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdu(rs.getLong("idu"));
				usuario.setIdv(rs.getLong("idv"));
				usuario.setIdr(rs.getLong("idr"));
				usuario.setEmail(rs.getString("email"));
				usuario.setNombre(rs.getString("nombreUsuario"));
				usuario.setPassword(rs.getString("password"));
				Usuarios.add(usuario);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Usuarios;
	}
	
	@Override
	public long addUsuario(Usuario usuario) {
		long idu=-1;
		if (conn != null){

			Statement stmt;
			try {
				stmt = conn.createStatement();
				
				String consulta = "INSERT INTO public.\"Usuario\" (\"nombreUsuario\", \"password\", \"email\")"
					    +" VALUES('"
						+usuario.getNombre()+"','"
						+usuario.getPassword()+"','"
						+usuario.getEmail()+"')";
				
				System.out.println(consulta);
				stmt.executeUpdate(consulta,Statement.RETURN_GENERATED_KEYS);
				
				ResultSet genKeys = stmt.getGeneratedKeys();
				
				if (genKeys.next())
				    idu = genKeys.getInt(1);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return idu;
	}

	
	@Override
	public boolean saveUsuario(Usuario usuario) {
		boolean done = false;
		if (conn != null){
			
			Statement stmt;
			try {
				stmt = conn.createStatement();
				
				String consulta = "UPDATE public.\"Usuario\" "
						+"SET "
						+"\"IDV\"="+usuario.getIdv()+","
						+"\"IDR\"="+usuario.getIdr()+","
						+"\"nombreUsuario\"='"+usuario.getNombre()+"',"
						+"\"password\"='"+usuario.getPassword()+"',"
						+"\"email\"='"+usuario.getEmail()+"'"
						+" WHERE \"IDU\" = "+usuario.getIdu();
				
				System.out.println(consulta);
				stmt.executeUpdate(consulta);
				
				done= true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return done;

	}

	@Override
	public boolean deleteUsuario(long idu) {
		boolean done = false;
		if (conn != null){

			Statement stmt;
			try {
				stmt = conn.createStatement();
				String sentencia = "DELETE FROM public.\"Usuario\" WHERE \"IDU\" ="+idu;
				System.out.println(sentencia);
				stmt.executeUpdate(sentencia);
				done= true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return done;
	}

}
