package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Destino {
	
	private long idd;
	private long idl;
	private String nombreDestino;
	
	
	public long getIdd() {
		return idd;
	}
	public void setIdd(long idd) {
		this.idd = idd;
	}
	public long getIdl() {
		return idl;
	}
	public void setIdl(long idl) {
		this.idl = idl;
	}
	public String getNombreDestino() {
		return nombreDestino;
	}
	public void setNombreDestino(String nombreDestino) {
		this.nombreDestino = nombreDestino;
	}




}
