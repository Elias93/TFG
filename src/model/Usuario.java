package model;


import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Usuario {
	
	private long idu;
	private long idv;
	private long idr;
	private String email;
	private String nombre;
	private String password;
	
	public boolean validar(Map<String, String> mensajes) {
				
		//VALIDAR nombre
		if(nombre.trim().isEmpty() || nombre == null){
			mensajes.put("errorUsuario", "name vacío");
		} else {
			if(!nombre.trim().matches("[A-Za-záéíóúñÁÉÍÓÚ]{2,}([\\s][A-Za-záéíóúñÁÉÍÓÚ]{2,})*")) {
				mensajes.put("errorUsuario", "nombre inválido: " + nombre.trim());
			}
		}
				
		//VALIDAR email
		if(email.trim().isEmpty() || email == null){
			mensajes.put("erroremail", "email vacío");
		} else{
			if(!email.trim().matches("^[_a-zA-Z0-9-]+(.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(.[a-zA-Z0-9-]+)*(.[a-zA-Z]{2,4})$")){
				mensajes.put("erroremail", "No es un email: " + email.trim());
			}
		}
			
		//VALIDAR password - Entre 8 y 16 letras y solo números y letras
		if(password.trim().isEmpty() || password == null){
			mensajes.put("errorpassword", "password vacía");
		} else{
			if(!password.trim().matches("^([a-zA-Z0-9]{8,16})$")){
				mensajes.put("errorpassword", "No es valida: " + password.trim());
			}
		}						
		
		if(mensajes.isEmpty()) return true;
		else return false;
	}
	
	
	public long getIdu() {
		return idu;
	}
	public void setIdu(long idu) {
		this.idu = idu;
	}
	public long getIdv() {
		return idv;
	}
	public void setIdv(long idv) {
		this.idv = idv;
	}
	public long getIdr() {
		return idr;
	}
	public void setIdr(long idr) {
		this.idr = idr;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}