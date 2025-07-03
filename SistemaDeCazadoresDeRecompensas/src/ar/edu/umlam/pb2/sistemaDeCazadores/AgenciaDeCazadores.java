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
	
	

}
