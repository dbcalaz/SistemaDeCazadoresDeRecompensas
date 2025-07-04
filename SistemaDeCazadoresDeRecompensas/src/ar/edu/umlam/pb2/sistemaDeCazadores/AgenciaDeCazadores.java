package ar.edu.umlam.pb2.sistemaDeCazadores;

import java.util.ArrayList;
import java.util.List;

public class AgenciaDeCazadores {
	
	private List<Cazador> cazadores;
	
	public AgenciaDeCazadores() {
		this.cazadores = new ArrayList<>();
	}

	public Boolean agregarCazador(Cazador cazador) {
		if(this.cazadores.add(cazador)) {
			return true;
		}
		return false;
	}
	
	//Reportes
	public Integer getCapturados(){
		Integer totalCapturados = 0;
		List<Profugo> profugosCapturados = new ArrayList<>();
		for(Cazador c : this.cazadores) {
			for(Profugo p : c.getProfugosCapturados()) {
				profugosCapturados.add(p);
			}
		}
		totalCapturados = profugosCapturados.size();
		return totalCapturados;	
	}
	
	public Cazador getCazadorConMasCapturas() {
	    Cazador cazadorConMasCapturas = null;
	    Integer maxCapturas = 0;

	    for (Cazador c : this.cazadores) {
	        Integer cantidadCapturas = c.getProfugosCapturados().size();

	        if (cantidadCapturas > maxCapturas) {
	            maxCapturas = cantidadCapturas;
	            cazadorConMasCapturas = c;
	        }
	    }
	    return cazadorConMasCapturas;
	}	
	
	public Profugo getProfugoMasHabilCapturado() {
		Profugo profugoMasHabil = null;
		Integer maxHabilidad = 0;
		
		for(Cazador c : this.cazadores) {
			
			for(Profugo p : c.getProfugosCapturados()) {
				
				Integer habilidad = p.getNivelDeHabilidad();
					
				if(habilidad > maxHabilidad) {
					maxHabilidad = habilidad;
					profugoMasHabil = p;
				}
			}
		}
		return profugoMasHabil;
	}
	

}
