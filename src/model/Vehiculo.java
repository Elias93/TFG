package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Vehiculo {
	
	private long idv;
	private long idr; 
	private long idf;
	private long idl;
	private Integer kilometros;
	private Integer velocidad;
	
	
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
	public long getIdf() {
		return idf;
	}
	public void setIdf(long idf) {
		this.idf = idf;
	}
	public long getIdl() {
		return idl;
	}
	public void setIdl(long idl) {
		this.idl = idl;
	}
	public Integer getKilometros() {
		return kilometros;
	}
	public void setKilometros(Integer kilometros) {
		this.kilometros = kilometros;
	}
	public Integer getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(Integer velocidad) {
		this.velocidad = velocidad;
	}

	

}
