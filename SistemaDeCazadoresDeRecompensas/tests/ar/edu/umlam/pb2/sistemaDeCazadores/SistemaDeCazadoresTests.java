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
		Cazador urbano = new CazadorUrbano(20);
		
		assertTrue(agencia.agregarCazador(urbano));
	}
	
	@Test
	public void queSePuedaAgregarCorrectamenteUnCazadorRuralAlaAgencia() {
		AgenciaDeCazadores agencia = new AgenciaDeCazadores();
		Cazador rural = new CazadorRural(30);
		
		assertTrue(agencia.agregarCazador(rural));
	}
	
	@Test
	public void queSePuedaAgregarCorrectamenteUnCazadorSigilosoAlaAgencia() {
		AgenciaDeCazadores agencia = new AgenciaDeCazadores();
		Cazador sigiloso = new CazadorSigiloso(25);
		
		assertTrue(agencia.agregarCazador(sigiloso));
	}
	
	@Test
	public void queSePuedaCrearUnaZonaCorrectamente() {
		Zona zona = new Zona("Haedo");
		
		assertNotNull(zona);
	}
	
	@Test
	public void queSePuedaAgregarCorrectamenteUnProfugoAUnaZona() {
		Zona zona = new Zona("Haedo");
		Profugo profu = new Profugo(true,10,5);
		
		assertTrue(zona.agregarProfugo(profu));
	}
	
	

}
