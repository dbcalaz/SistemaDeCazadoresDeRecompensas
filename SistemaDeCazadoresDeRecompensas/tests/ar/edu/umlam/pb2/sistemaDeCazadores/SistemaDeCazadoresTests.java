package ar.edu.umlam.pb2.sistemaDeCazadores;

import static org.junit.Assert.*;

import org.junit.Test;

public class SistemaDeCazadoresTests {

	@Test
	public void queSePuedaCrearCorrectamenteUnaAgenciaDeCazadores() {
		AgenciaDeCazadores agencia = new AgenciaDeCazadores();
		assertNotNull(agencia);
	}
	
	@Test
	public void queSePuedaAgregarCorrectamenteUnCazadorUrbanoAlaAgencia() {
		AgenciaDeCazadores agencia = new AgenciaDeCazadores();
		Cazador urbano = new CazadorUrbano();
		
		assertTrue(agencia.agregarCazador(urbano));
	}
	
	@Test
	public void queSePuedaAgregarCorrectamenteUnCazadorRuralAlaAgencia() {
		AgenciaDeCazadores agencia = new AgenciaDeCazadores();
		Cazador rural = new CazadorRural();
		
		assertTrue(agencia.agregarCazador(rural));
	}
	
	@Test
	public void queSePuedaAgregarCorrectamenteUnCazadorSigilosoAlaAgencia() {
		AgenciaDeCazadores agencia = new AgenciaDeCazadores();
		Cazador sigiloso = new CazadorSigiloso();
		
		assertTrue(agencia.agregarCazador(sigiloso));
	}

}
