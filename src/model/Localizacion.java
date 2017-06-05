package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Localizacion {
	
	private long idl;
	private float latitud;
	private float longitud;
	private String coordenadas;
	
	
	public long getIdl() {
		return idl;
	}
	public void setIdl(long idl) {
		this.idl = idl;
	}
	public float getLatitud() {
		return latitud;
	}
	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}
	public float getLongitud() {
		return longitud;
	}
	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
	public String getCoordenadas() {
		return coordenadas;
	}
	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}


}
