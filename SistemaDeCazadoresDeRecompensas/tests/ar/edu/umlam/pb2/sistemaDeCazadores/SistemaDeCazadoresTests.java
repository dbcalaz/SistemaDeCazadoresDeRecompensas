package ar.edu.umlam.pb2.sistemaDeCazadores;

import static org.junit.Assert.*;

import org.junit.Test;

public class SistemaDeCazadoresTests {

	@Test
	public void queSePuedaCrearCorrectamenteUnaAgenciaDeCazadores() {
		AgenciaDeCazadores agencia = new AgenciaDeCazadores();
		assertNotNull(agencia);
	}

}
