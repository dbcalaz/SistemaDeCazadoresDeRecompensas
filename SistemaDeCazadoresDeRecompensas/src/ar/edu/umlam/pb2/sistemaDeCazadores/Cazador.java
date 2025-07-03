package ar.edu.umlam.pb2.sistemaDeCazadores;

import java.util.List;

public abstract class Cazador {
	
	protected Integer experiencia;
	protected List<Profugo> profugosCapturados;
	
	public Cazador(Integer experiencia) {
		this.experiencia = experiencia;
	}

}
