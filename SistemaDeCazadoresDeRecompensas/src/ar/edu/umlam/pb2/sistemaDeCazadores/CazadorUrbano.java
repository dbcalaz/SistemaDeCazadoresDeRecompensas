package ar.edu.umlam.pb2.sistemaDeCazadores;

public class CazadorUrbano extends Cazador {
	
	private String fraseDeIntimidacion = "Soy un cazador urbano";

	public CazadorUrbano(Integer experiencia) {
		super(experiencia);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Boolean puedeCapturar(Profugo profugo) {
		if(this.experiencia > profugo.getNivelDeInocencia() && profugo.getEsNervioso() == false) {
			return true;
			}
		return false;
	}

	@Override
	protected void intimidar(Profugo profugo) {
		profugo.serIntimidado(this.fraseDeIntimidacion);		
	}

	

}
