package ar.edu.umlam.pb2.sistemaDeCazadores;

public class ArteMarcialAvanzada implements Entrenable{

	@Override
	public void aplicarA(Profugo p) {
		p.setNivelDeHabilidad(p.getNivelDeHabilidad()*2);
		if(p.getNivelDeHabilidad() > 100) {
			p.setNivelDeHabilidad(100);
		}
	}

}
