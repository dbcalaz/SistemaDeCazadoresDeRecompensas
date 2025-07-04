package ar.edu.umlam.pb2.sistemaDeCazadores;

import java.util.ArrayList;
import java.util.List;

public class Profugo {
	
	private Boolean esNervioso;
	private Integer nivelDeInocencia;
	private Integer nivelDeHabilidad;
	private List<Entrenable> entrenamientos;

	public Profugo(Boolean esNervioso, Integer nivelDeInocencia, Integer nivelDeHabilidad) {
		this.esNervioso = esNervioso;
		this.nivelDeInocencia = nivelDeInocencia;
		this.nivelDeHabilidad = nivelDeHabilidad;
		this.entrenamientos = new ArrayList<>();
	}

	public Boolean getEsNervioso() {
		return esNervioso;
	}

	public void setEsNervioso(Boolean esNervioso) {
		this.esNervioso = esNervioso;
	}

	public Integer getNivelDeInocencia() {
		return nivelDeInocencia;
	}

	public void setNivelDeInocencia(Integer nivelDeInocencia) {
		this.nivelDeInocencia = nivelDeInocencia;
	}

	public Integer getNivelDeHabilidad() {
		return nivelDeHabilidad;
	}

	public void setNivelDeHabilidad(Integer nivelDeHabilidad) {
		this.nivelDeHabilidad = nivelDeHabilidad;
	}

	public void serIntimidado(String fraseDeIntimidacion) {
		
		if(getNivelDeInocencia() <= 1) {
			setNivelDeInocencia(0); 
		}else {
			setNivelDeInocencia(getNivelDeInocencia()-2);
		}
		
		if(fraseDeIntimidacion.equals("Soy un cazador urbano")) {
			this.esNervioso = false;
		}else if(fraseDeIntimidacion.equals("Soy un cazador rural")){
			this.esNervioso = true;
			//Verificar en caso de que el prófugo haga entrenamientoElitte.
		}else if(fraseDeIntimidacion.equals("Soy un cazador sigiloso")) {
			setNivelDeHabilidad(getNivelDeHabilidad() - 5);
		}
		
	}
	
	public void entrenarseCon(Entrenable entrenamiento) {
		entrenamiento.aplicarA(this);
		this.entrenamientos.add(entrenamiento);	
	}
	
	

}
