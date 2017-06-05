package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Rol {
	
	private long idr;
	private String nombreRol;
	
	
	public long getIdr() {
		return idr;
	}
	public void setIdr(long idr) {
		this.idr = idr;
	}
	public String getNombreRol() {
		return nombreRol;
	}
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}


}
