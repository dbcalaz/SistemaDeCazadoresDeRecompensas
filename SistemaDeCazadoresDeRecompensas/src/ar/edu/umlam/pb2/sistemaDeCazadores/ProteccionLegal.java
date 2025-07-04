package ar.edu.umlam.pb2.sistemaDeCazadores;

public class ProteccionLegal implements Entrenable{

	@Override
	public void aplicarA(Profugo p) {
		if(p.getNivelDeInocencia() < 40) {
			p.setNivelDeInocencia(40);
		}			
	}

}
