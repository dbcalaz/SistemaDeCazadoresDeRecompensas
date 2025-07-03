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
	
	private Boolean intentarCapturar(Profugo profugo, Zona zona) {
		if(puedeCapturar(profugo)) {
			this.profugosCapturados.add(profugo);
			zona.removerProfugoCapturado(profugo);
			return true;
		}else {
			intimidar(profugo);
		}
		return false;
	}
	
	public void trabajar(Zona zona) {
		/*Tuve que agregar los prófugos de la zona en un nuevo array 
		porque sino el remover un prófugo capturado al mismo tiempo que corría el for,
		éste se rompía y salteaba al prófugo que quedaba y no entraba en el método intentarCapturar()*/
		List<Profugo> profugosEnZona = new ArrayList<>(zona.getProfugosEnZona());
	    for (Profugo p : profugosEnZona) {
	        intentarCapturar(p, zona);
	    }
	}
	
	
}
