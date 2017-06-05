
package listener;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletContextListener implements javax.servlet.ServletContextListener {

	String driver = "org.postgresql.Driver";
	String servidor = "localhost"; // Direccion IP
	String puerto = "5432";
	String database = "BDTFG";
	String url = "jdbc:postgresql://" + servidor + ":" + puerto + "/"+ database;
	String user = "postgres";
	String password = "admin";
	
	public void contextInitialized(ServletContextEvent event) {

		Connection conn = null;		

	    //Register JDBC driver
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try {

			ServletContext sc = event.getServletContext();
			
		    //Open a connection
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Conexión realizada a la base de datos");

			sc.setAttribute("dbConn", conn);			

		} catch (SQLException e) {
			e.printStackTrace();
		}     
		
	}

	
    public void contextDestroyed(ServletContextEvent arg0)  { 
		
		try {
	   		ServletContext sc = arg0.getServletContext();
	   		Connection conn = (Connection) sc.getAttribute("dbConn");
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("SHUTDOWN");
			conn.close();
			Enumeration<Driver> drivers = DriverManager.getDrivers();
			while (drivers.hasMoreElements()) {
				Driver driver = drivers.nextElement();
				try {
					DriverManager.deregisterDriver(driver);
				} catch (SQLException e) {
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
   
	
	

}
