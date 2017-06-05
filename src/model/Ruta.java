package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ruta {
	
	private long idr;
	private String nombreRuta;
	
	
	public long getIdr() {
		return idr;
	}
	public void setIdr(long idr) {
		this.idr = idr;
	}
	public String getNombreRuta() {
		return nombreRuta;
	}
	public void setNombreRuta(String nombreRuta) {
		this.nombreRuta = nombreRuta;
	}


}
