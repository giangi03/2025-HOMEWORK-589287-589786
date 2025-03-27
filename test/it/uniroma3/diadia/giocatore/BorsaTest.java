package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.attrezzi.Attrezzo;


class BorsaTest {
	
	DiaDia diaDia;
	Borsa borsa;
	Borsa borsaVuota;
	Attrezzo spada;
	Attrezzo scudo;
	Attrezzo sciabola;

	@BeforeEach
	void setUp() {
		
		/*scenario per removeAttrezzo(nomeAtrrezzo) e isEmpty() */
		borsa=new Borsa();
		borsaVuota=new Borsa();
		spada=new Attrezzo("spada", 4);
		scudo=new Attrezzo("scudo", 5);
		sciabola=new Attrezzo("sciabola", 1);
		borsa.addAttrezzo(spada);
		borsa.addAttrezzo(scudo);
		borsa.addAttrezzo(sciabola);
		
	}

	@Test
	void testRemoveAttrezzoNonEsistente() {
		assertNull(borsa.removeAttrezzo("forcone"));
	}
	
	@Test
	void testRemoveAttrezzoEsistenteInMezzo() {
		assertEquals(sciabola, borsa.removeAttrezzo("sciabola"));
	}
	
	@Test
	void testRemoveAttrezzoEsistenteAllInizio() {
		assertEquals(spada, borsa.removeAttrezzo("spada"));
	}
	
	@Test
	void testGetNumeroAttrezziCorretto() {
		assertEquals(3, borsa.getNumeroAttrezzi());
	}
	
	@Test
	void testIsEmptyVuota() {
		assertTrue(borsaVuota.isEmpty());
	}
	
	@Test
	void testIsEmptyPiena() {
		assertFalse(borsa.isEmpty());
	}

}
