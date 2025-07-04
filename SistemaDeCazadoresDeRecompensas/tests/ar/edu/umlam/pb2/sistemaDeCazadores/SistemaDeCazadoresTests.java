package ar.edu.umlam.pb2.sistemaDeCazadores;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SistemaDeCazadoresTests {
	
	private AgenciaDeCazadores agencia;
	@Before
	public void setUp() {
		agencia = new AgenciaDeCazadores();
	}

	@Test
	public void queSePuedaCrearCorrectamenteUnaAgenciaDeCazadores() {
		assertNotNull(agencia);
	}
	
	@Test
	public void queSePuedaAgregarCorrectamenteUnCazadorUrbanoAlaAgencia() {
		Cazador urbano = new CazadorUrbano(20);
		
		assertTrue(agencia.agregarCazador(urbano));
	}
	
	@Test
	public void queSePuedaAgregarCorrectamenteUnCazadorRuralAlaAgencia() {
		Cazador rural = new CazadorRural(30);
		
		assertTrue(agencia.agregarCazador(rural));
	}
	
	@Test
	public void queSePuedaAgregarCorrectamenteUnCazadorSigilosoAlaAgencia() {
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
	
	@Test
	public void queUnCazadorRuralIntenteCazarUnProfugo() {
		Cazador rural = new CazadorRural(30);
		agencia.agregarCazador(rural);
		
		Zona zona = new Zona("Haedo");
		Profugo profu1 = new Profugo(true,10,5);//prófugo capturable
		Profugo profu2 = new Profugo(true,30,5);//prófugo intimidable
		zona.agregarProfugo(profu1);
		zona.agregarProfugo(profu2);
		
		rural.trabajar(zona);	
		assertTrue(rural.getProfugosCapturados().contains(profu1));
		assertFalse(rural.getProfugosCapturados().contains(profu2));
	}
	
	@Test
	public void queUnCazadorSigilosoIntenteCazarUnProfugo() {
		Cazador sigiloso = new CazadorSigiloso(25);
		agencia.agregarCazador(sigiloso);
		
		Zona zona = new Zona("Haedo");
		Profugo profu1 = new Profugo(true,10,5);//prófugo capturable
		Profugo profu2 = new Profugo(true,30,5);//prófugo intimidable
		zona.agregarProfugo(profu1);
		zona.agregarProfugo(profu2);
		
		sigiloso.trabajar(zona);	
		assertTrue(sigiloso.getProfugosCapturados().contains(profu1));
		assertFalse(sigiloso.getProfugosCapturados().contains(profu2));
	}
	
	@Test
	public void queSePuedaRemoverCorrectamenteUnProfugoDeLaZonaSiFueCapturado() {
		Cazador urbano = new CazadorUrbano(20);
		agencia.agregarCazador(urbano);
		
		Zona zona = new Zona("Haedo");
		Profugo profu1 = new Profugo(false,10,5);//prófugo capturable
		Profugo profu2 = new Profugo(true,30,5);//prófugo intimidable
		zona.agregarProfugo(profu1);
		zona.agregarProfugo(profu2);
		
		urbano.trabajar(zona);	
		
		assertFalse(zona.getProfugosEnZona().contains(profu1));
	}
	
	@Test
	public void queUnCazadorUrbanoPuedaIntimidarUnProfugo() {
		Cazador urbano = new CazadorUrbano(20);
		agencia.agregarCazador(urbano);
		
		Zona zona = new Zona("Haedo");
		Profugo profu1 = new Profugo(false,10,5);//prófugo capturable
		Profugo profu2 = new Profugo(true,30,5);//prófugo intimidable
		zona.agregarProfugo(profu1);
		zona.agregarProfugo(profu2);
		
		urbano.trabajar(zona);
		Integer nuevaInocencia = 28;
		Boolean nuevoEstado = false;
		Integer nuevaHabilidad = 5;
		assertEquals( nuevaInocencia,profu2.getNivelDeInocencia());
		assertEquals( nuevoEstado,profu2.getEsNervioso());
		assertEquals( nuevaHabilidad,profu2.getNivelDeHabilidad());
	}
	
	@Test
	public void queUnCazadorRuralPuedaIntimidarUnProfugo() {
		Cazador rural = new CazadorRural(30);
		agencia.agregarCazador(rural);
		
		Zona zona = new Zona("Haedo");
		Profugo profu1 = new Profugo(false,10,5);//prófugo capturable
		Profugo profu2 = new Profugo(false,40,5);//prófugo intimidable
		zona.agregarProfugo(profu1);
		zona.agregarProfugo(profu2);
		
		rural.trabajar(zona);
		Integer nuevaInocencia =38;
		Boolean nuevoEstado = true;
		Integer nuevaHabilidad = 5;
		assertEquals( nuevaInocencia,profu2.getNivelDeInocencia());
		assertEquals( nuevoEstado,profu2.getEsNervioso());
		assertEquals( nuevaHabilidad,profu2.getNivelDeHabilidad());
	}
	
	@Test
	public void queUnCazadorSigilosoPuedaIntimidarUnProfugo() {
		Cazador sigiloso = new CazadorSigiloso(25);
		agencia.agregarCazador(sigiloso);
		
		Zona zona = new Zona("Haedo");
		Profugo profu1 = new Profugo(false,10,5);//prófugo capturable
		Profugo profu2 = new Profugo(false,40,15);//prófugo intimidable
		zona.agregarProfugo(profu1);
		zona.agregarProfugo(profu2);
		
		sigiloso.trabajar(zona);
		Integer nuevaInocencia =38;
		Boolean nuevoEstado = false;
		Integer nuevaHabilidad = 10;
		assertEquals( nuevaInocencia,profu2.getNivelDeInocencia());
		assertEquals( nuevoEstado,profu2.getEsNervioso());
		assertEquals( nuevaHabilidad,profu2.getNivelDeHabilidad());
	}
	
	@Test
	public void queUnCazadorSigilosoPuedaSumarExperienciaCorrectamente() {
		Cazador sigiloso = new CazadorSigiloso(25);
		agencia.agregarCazador(sigiloso);
		
		Zona zona = new Zona("Haedo");
		Profugo profu1 = new Profugo(false,40,59);//54 prófugo intimidable - como el cazador es sigiloso la hábilidad del prófugo queda en 5 menos
		Profugo profu2 = new Profugo(false,30,60);//55 prófugo intimidable
		Profugo profu3 = new Profugo(false,35,70);//65 prófugo intimidable
		Profugo profu4 = new Profugo(false,10,5);//prófugo capturable
		zona.agregarProfugo(profu1);
		zona.agregarProfugo(profu2);
		zona.agregarProfugo(profu3);
		zona.agregarProfugo(profu4);
		
		sigiloso.trabajar(zona);
		Integer nuevaExperiencia = 81;
		
		assertEquals(nuevaExperiencia, sigiloso.getExperiencia());
	}
	
	@Test
	public void queUnCazadorRuralPuedaSumarExperienciaCorrectamente() {
		Cazador rural = new CazadorRural(30);
		agencia.agregarCazador(rural);
		
		Zona zona = new Zona("Haedo");
		Profugo profu1 = new Profugo(false,40,59);//prófugo intimidable - como el cazador es sigiloso la hábilidad del prófugo queda en 5 menos
		Profugo profu2 = new Profugo(false,30,60);//prófugo intimidable
		Profugo profu3 = new Profugo(false,35,70);//prófugo intimidable
		Profugo profu4 = new Profugo(true,10,5);//prófugo capturable
		zona.agregarProfugo(profu1);
		zona.agregarProfugo(profu2);
		zona.agregarProfugo(profu3);
		zona.agregarProfugo(profu4);
		
		rural.trabajar(zona);
		Integer nuevaExperiencia = 91;
		
		assertEquals(nuevaExperiencia, rural.getExperiencia());
	}
	
	@Test
	public void queUnCazadorUrbanoPuedaSumarExperienciaCorrectamente() {
		Cazador urbano = new CazadorUrbano(20);
		agencia.agregarCazador(urbano);
		
		Zona zona = new Zona("Haedo");
		Profugo profu1 = new Profugo(true,40,59);//prófugo intimidable - como el cazador es sigiloso la hábilidad del prófugo queda en 5 menos
		Profugo profu2 = new Profugo(true,30,60);//prófugo intimidable
		Profugo profu3 = new Profugo(true,35,70);//prófugo intimidable
		Profugo profu4 = new Profugo(false,10,5);//prófugo capturable
		zona.agregarProfugo(profu1);
		zona.agregarProfugo(profu2);
		zona.agregarProfugo(profu3);
		zona.agregarProfugo(profu4);
		
		urbano.trabajar(zona);
		Integer nuevaExperiencia = 81;
		
		assertEquals(nuevaExperiencia, urbano.getExperiencia());
	}
	
	@Test
	public void queLaAgenciaPuedaObtenerElReporteDelTotalDeProfugosCapturados() {
		Cazador urbano = new CazadorUrbano(20);
		Cazador rural = new CazadorRural(30);
		agencia.agregarCazador(urbano);	
		agencia.agregarCazador(rural);
		
		Zona zona = new Zona("Haedo");
		Zona zonaUno = new Zona("Ramos Mejía");
		Profugo profu1 = new Profugo(true,40,59);
		Profugo profu2 = new Profugo(false,10,5);
		Profugo profu3 = new Profugo(false,35,70);
		Profugo profu4 = new Profugo(true,10,5);
		zona.agregarProfugo(profu1);
		zona.agregarProfugo(profu2);
		zonaUno.agregarProfugo(profu3);
		zonaUno.agregarProfugo(profu4);
		
		urbano.trabajar(zona);
		rural.trabajar(zonaUno);
		Integer capturadosEsperado = 2;
		
		assertEquals(capturadosEsperado, agencia.getCapturados());
	}
	
	@Test
	public void queLaAgenciaPuedaObtenerElReporteDelCazadorConMasCapturas() {
		Cazador urbano = new CazadorUrbano(20);
		Cazador rural = new CazadorRural(30);
		agencia.agregarCazador(urbano);	
		agencia.agregarCazador(rural);
		
		Zona zona = new Zona("Haedo");
		Zona zonaUno = new Zona("Ramos Mejía");
		Profugo profu1 = new Profugo(true,40,59);
		Profugo profu2 = new Profugo(false,10,5);
		Profugo profu3 = new Profugo(false,35,70);
		Profugo profu4 = new Profugo(true,29,70);
		Profugo profu5 = new Profugo(true,10,5);
		zona.agregarProfugo(profu1);
		zona.agregarProfugo(profu2);
		zonaUno.agregarProfugo(profu3);
		zonaUno.agregarProfugo(profu4);
		zonaUno.agregarProfugo(profu5);
		
		urbano.trabajar(zona);
		rural.trabajar(zonaUno);
		
		assertEquals(rural, agencia.getCazadorConMasCapturas());
	}
	
	@Test
	public void queLaAgenciaPuedaObtenerElReporteDelProfugoMasHabilCapturado() {
		Cazador urbano = new CazadorUrbano(20);
		Cazador rural = new CazadorRural(30);
		agencia.agregarCazador(urbano);	
		agencia.agregarCazador(rural);
		
		Zona zona = new Zona("Haedo");
		Zona zonaUno = new Zona("Ramos Mejía");
		Profugo profu1 = new Profugo(true,40,59);
		Profugo profu2 = new Profugo(false,10,5);
		Profugo profu3 = new Profugo(false,35,70);
		Profugo profu4 = new Profugo(true,29,70);
		Profugo profu5 = new Profugo(true,10,5);
		zona.agregarProfugo(profu1);
		zona.agregarProfugo(profu2);
		zonaUno.agregarProfugo(profu3);
		zonaUno.agregarProfugo(profu4);
		zonaUno.agregarProfugo(profu5);
		
		urbano.trabajar(zona);
		rural.trabajar(zonaUno);
		
		assertEquals(profu4, agencia.getProfugoMasHabilCapturado());
	}
	
	@Test
	public void queUnProfugoSePuedaEntrenarConArtesMarcialesAvanzadas() {		
		Profugo profu = new Profugo(true,40,9);//nervioso - inocencia - habilidad
		ArteMarcialAvanzada arteMarcial = new ArteMarcialAvanzada();
		profu.entrenarseCon(arteMarcial);
		
		Integer habilidadEsperada = 18;
		assertEquals(habilidadEsperada, profu.getNivelDeHabilidad());
	}
	
	@Test
	public void queUnProfugoSePuedaEntrenarMasDeUnaVezConArtesMarcialesAvanzadas() {		
		Profugo profu = new Profugo(true,40,9);//nervioso - inocencia - habilidad
		ArteMarcialAvanzada arteMarcial = new ArteMarcialAvanzada();
		profu.entrenarseCon(arteMarcial);
		profu.entrenarseCon(new ArteMarcialAvanzada());
		
		Integer habilidadEsperada = 36;
		assertEquals(habilidadEsperada, profu.getNivelDeHabilidad());
	}
	
	@Test
	public void queUnProfugoSePuedaEntrenarConEntrenamientoDeElite() {		
		Profugo profu = new Profugo(true,40,9);//nervioso - inocencia - habilidad
		EntrenamientoDeElite elite = new EntrenamientoDeElite();
		profu.entrenarseCon(elite);
		
		Boolean estadoEsperado = false;
		assertEquals(estadoEsperado, profu.getEsNervioso());
	}
	
	@Test
	public void queUnProfugoConEntrenamientoDeEliteAlSerIntimidadoPorUnCazadorRuralNoCambieSuEstado() {		
	    Cazador rural = new CazadorRural(30);
	    agencia.agregarCazador(rural);
	    
	    Profugo profugo = new Profugo(true, 40, 9);
	    EntrenamientoDeElite elite = new EntrenamientoDeElite();
	    profugo.entrenarseCon(elite);

	    Zona zona = new Zona("Haedo");
	    zona.agregarProfugo(profugo);

	    rural.trabajar(zona);

	    assertFalse(profugo.getEsNervioso());
	}
	
	@Test
	public void queUnProfugoSePuedaEntrenarConProteccionLegal() {		
		Profugo profu = new Profugo(true,30,9);//nervioso - inocencia - habilidad
		ProteccionLegal pLegal = new ProteccionLegal();
		profu.entrenarseCon(pLegal);
		
		Integer inocenciaEsperada = 40;
		assertEquals(inocenciaEsperada, profu.getNivelDeInocencia());
	}
	
	@Test
	public void queUnProfugoConProteccionLegalAlSerIntimidadoPorUnCazadorSuInocenciaNoSeaMenorA40() {		
	    Cazador rural = new CazadorRural(30);
	    agencia.agregarCazador(rural);
	    
	    Profugo profugo = new Profugo(false, 41, 9);
	    ProteccionLegal pLegal = new ProteccionLegal();
	    profugo.entrenarseCon(pLegal);
		

	    Zona zona = new Zona("Haedo");
	    zona.agregarProfugo(profugo);

	    rural.trabajar(zona);
	    
	    Integer inocenciaEsperada = 40;
		assertEquals(inocenciaEsperada, profugo.getNivelDeInocencia());
	}
	
	@Test(expected = ZonaSinProfugosException.class)
	public void queNoSePuedaTrabajarEnUnaZonaSinProfugos() {
	    Zona zona = new Zona("Haedo");
	    Cazador cazador = new CazadorUrbano(30);

	    cazador.trabajar(zona); // lanza la excepción
	}	

}
