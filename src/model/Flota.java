package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Flota {
	
	private long idf;
	private String nombreFlota;
	
	
	public long getIdf() {
		return idf;
	}
	public void setIdf(long idf) {
		this.idf = idf;
	}
	public String getNombreFlota() {
		return nombreFlota;
	}
	public void setNombreFlota(String nombreFlota) {
		this.nombreFlota = nombreFlota;
	}



}
