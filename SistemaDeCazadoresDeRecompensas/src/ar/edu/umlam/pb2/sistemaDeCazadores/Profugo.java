package ar.edu.umlam.pb2.sistemaDeCazadores;

public class Profugo {
	
	private Boolean esNervioso;
	private Integer nivelDeInocencia;
	private Integer nivelDeHabilidad;

	public Profugo(Boolean esNervioso, Integer nivelDeInocencia, Integer nivelDeHabilidad) {
		this.esNervioso = esNervioso;
		this.nivelDeInocencia = nivelDeInocencia;
		this.nivelDeHabilidad = nivelDeHabilidad;
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
	
	

}
