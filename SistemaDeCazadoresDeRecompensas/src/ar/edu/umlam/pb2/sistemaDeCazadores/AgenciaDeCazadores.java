package ar.edu.umlam.pb2.sistemaDeCazadores;

import java.util.ArrayList;
import java.util.List;

public class AgenciaDeCazadores {
	
	private List<Cazador> cazadores;
	
	public AgenciaDeCazadores() {
		this.cazadores = new ArrayList<>();
	}

	public Boolean agregarCazador(Cazador cazador) {
		Boolean seAgrego = false;
		if(this.cazadores.add(cazador)) {
			seAgrego = true;
		}
		return seAgrego	;
	}
	
	

}
