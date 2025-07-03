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
	
	private Boolean intentarCapturar(Profugo profugo) {
		if(puedeCapturar(profugo)) {
			this.profugosCapturados.add(profugo);
			return true;
		}else {
			intimidar(profugo);
		}
		return false;
	}
	
	public void trabajar(Zona zona) {
		for(Profugo p : zona.getProfugosEnZona()) {
			intentarCapturar(p);
		}
	}
	
	
}
