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
	
	@Test
	public void queUnCazadorUrbanoIntenteCazarUnProfugo() {
		AgenciaDeCazadores agencia = new AgenciaDeCazadores();
		Cazador urbano = new CazadorUrbano(20);
		agencia.agregarCazador(urbano);
		
		Zona zona = new Zona("Haedo");
		Profugo profu1 = new Profugo(false,10,5);//prófugo capturable
		Profugo profu2 = new Profugo(true,30,5);//prófugo intimidable
		zona.agregarProfugo(profu1);
		zona.agregarProfugo(profu2);
		
		urbano.trabajar(zona);	
		assertTrue(urbano.getProfugosCapturados().contains(profu1));
		assertFalse(urbano.getProfugosCapturados().contains(profu2));
	}

}
