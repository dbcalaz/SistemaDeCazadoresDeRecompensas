package ar.edu.umlam.pb2.sistemaDeCazadores;

import java.util.ArrayList;
import java.util.List;

public abstract class Cazador {
	
	protected Integer experiencia;
	protected List<Profugo> profugosCapturados;
	
	public Cazador(Integer experiencia) {
		this.experiencia = experiencia;
		this.profugosCapturados = new ArrayList<>();
	}
	
	public List<Profugo> getProfugosCapturados() {
		return profugosCapturados;
	}

	protected abstract Boolean puedeCapturar(Profugo profugo);
	
	protected abstract void intimidar(Profugo profugo);
	
	private Boolean intentarCapturar(Profugo profugo, Zona zona, List<Profugo> profugosIntimidados, List<Profugo> profugosCapturados) {
		if(puedeCapturar(profugo)) {
			this.profugosCapturados.add(profugo);
			zona.removerProfugoCapturado(profugo);
			profugosCapturados.add(profugo);
			return true;
		}else {
			intimidar(profugo);
			profugosIntimidados.add(profugo);
		}
		return false;
	}
	
	public void trabajar(Zona zona) {
		/*Tuve que agregar los prófugos de la zona en un nuevo array 
		porque sino el remover un prófugo capturado al mismo tiempo que corría el for,
		éste se rompía y salteaba al prófugo que quedaba y no entraba en el método intentarCapturar()*/
		List<Profugo> profugosIntimidados = new ArrayList<>();
		List<Profugo> profugosCapturados = new ArrayList<>();
		List<Profugo> profugosEnZona = new ArrayList<>(zona.getProfugosEnZona());
	    for (Profugo p : profugosEnZona) {
	        intentarCapturar(p, zona, profugosIntimidados,profugosCapturados);
	    }
	    sumarExperiencia(profugosIntimidados, profugosCapturados);
	}
	
	private void sumarExperiencia(List<Profugo> profugosIntimidados, List<Profugo> profugosCapturados) {
		Integer menorHabilidad = Integer.MAX_VALUE;
		Integer cantidadProfugosCapturados = profugosCapturados.size();
		for(Profugo p : profugosIntimidados) {
			if(p.getNivelDeHabilidad() < menorHabilidad) {
				menorHabilidad = p.getNivelDeHabilidad();
			}
		}
		
		this.experiencia += menorHabilidad + (2 * cantidadProfugosCapturados);	
	}

	public Integer getExperiencia() {
		return experiencia;
	}
	
	
	
	
}
