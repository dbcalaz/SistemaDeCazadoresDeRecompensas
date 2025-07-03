package ar.edu.umlam.pb2.sistemaDeCazadores;

public class CazadorSigiloso extends Cazador {
	
	private String fraseDeIntimidacion = "Soy un cazador sigiloso";

	public CazadorSigiloso(Integer experiencia) {
		super(experiencia);
	}

	@Override
	protected Boolean puedeCapturar(Profugo profugo) {
		if(this.experiencia > profugo.getNivelDeInocencia() && profugo.getNivelDeHabilidad() < 50	) {
			return true;
			}
		return false;
	}

	@Override
	protected void intimidar(Profugo profugo) {
		profugo.serIntimidado(this.fraseDeIntimidacion);		
	}

	

}
