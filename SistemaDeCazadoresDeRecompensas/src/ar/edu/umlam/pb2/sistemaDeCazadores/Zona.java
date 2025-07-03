package ar.edu.umlam.pb2.sistemaDeCazadores;

import java.util.ArrayList;
import java.util.List;

public class Zona {
	
	private String nombreDeLaZona;
	private List<Profugo> profugosEnZona;

	public Zona(String nombre) {
		this.nombreDeLaZona = nombre;
		this.profugosEnZona = new ArrayList<>();
	}

	public Boolean agregarProfugo(Profugo profu) {
		if(this.profugosEnZona.add(profu)) {
			return true;
		}
		return false;
	}

	public List<Profugo> getProfugosEnZona() {
		return profugosEnZona;
	}	

	

}
