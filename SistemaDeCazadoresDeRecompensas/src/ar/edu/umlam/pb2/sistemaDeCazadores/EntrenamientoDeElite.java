package ar.edu.umlam.pb2.sistemaDeCazadores;

public class EntrenamientoDeElite implements Entrenable{

	@Override
	public void aplicarA(Profugo p) {
		if(p.getEsNervioso() == true) {
			p.setEsNervioso(false);
		}
		
	}

}
