package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaTest {
	
	Stanza stanzaCorrente;
	Stanza stanzaAdiacente;
	Stanza stanzaIsolata;
	Stanza stanzaDirezioneSbagliata;
	Stanza stanzaPiena;
	Stanza stanzaRemove;
	Attrezzo lampada;
	Attrezzo imbuto;
	Attrezzo martello;
	Attrezzo libro;

	@BeforeEach
	void setUp() {
		
		/* scenario per getStanzaAdiacente(direzione) */
		stanzaCorrente=new Stanza("corrente");
		stanzaAdiacente=new Stanza("salone");
		stanzaIsolata=new Stanza("mensa");
		stanzaCorrente.impostaStanzaAdiacente("est", stanzaAdiacente);
		stanzaDirezioneSbagliata=new Stanza("loggia");
		stanzaDirezioneSbagliata.impostaStanzaAdiacente("ovest", stanzaAdiacente);
		
		/* scenario per addAttrezzo(attrezzo) */
		lampada=new Attrezzo("lampada", 3);
		stanzaPiena=new Stanza("cucina");
		imbuto=new Attrezzo("imbuto", 2);
		for(int i=0;i<stanzaPiena.getAttrezzi().length;i++) {
			stanzaPiena.addAttrezzo(imbuto);
		}
		
		/* scenario per hasAttrezzo(attrezzo) */
		stanzaCorrente.addAttrezzo(lampada);
		
		/* scenario per removeAttrezzo(attrezzo) */
		martello=new Attrezzo("martello", 8);
		libro=new Attrezzo("libro", 4);
		stanzaRemove=new Stanza("remove");
		stanzaRemove.addAttrezzo(imbuto);
		stanzaRemove.addAttrezzo(lampada);
		stanzaRemove.addAttrezzo(martello);
		stanzaRemove.addAttrezzo(libro);
		stanzaRemove.removeAttrezzo(libro);
	}

	@Test
	void testGetStanzaAdiacenteIsolata() {
		assertNull(stanzaIsolata.getStanzaAdiacente("nord"));
	}
	
	@Test
	void testGetStanzaAdiacenteCorretta() {
		assertEquals(stanzaAdiacente, stanzaCorrente.getStanzaAdiacente("est"));
	}
	
	@Test
	void testGetStanzaAdiacenteDirezioneSbagliata() {
		assertNotEquals(stanzaAdiacente, stanzaDirezioneSbagliata.getStanzaAdiacente("nord"));
	}
	
	@Test
	void testAddAttrezzoCorretto() {
		assertTrue(stanzaCorrente.addAttrezzo(lampada));
	}
	
	@Test 
	void testAddAttrezzoStanzaPiena() {
		assertFalse(stanzaPiena.addAttrezzo(lampada));
	}
	
	@Test 
	void testHasAttrezzoGiusto() {
		assertTrue(stanzaCorrente.hasAttrezzo("lampada"));
	}
	
	@Test
	void testHasAttrezzoSbagliato() {
		assertFalse(stanzaCorrente.hasAttrezzo("coltello"));
	}
	
	@Test
	void testHasAttrezzoNullo() {
		assertFalse(stanzaCorrente.hasAttrezzo(null));
	}
	
	@Test 
	void testRemoveAttrezzoAllInizio() {
		assertTrue(stanzaRemove.removeAttrezzo(imbuto));
	}
	
	void testRemoveAttrezzoInMezzo() {
		assertTrue(stanzaRemove.removeAttrezzo(martello));
	}
	
	void testRemoveAttrezzoNonEsistente() {
		assertFalse(stanzaRemove.removeAttrezzo(libro));
	}
	
	@Test 
	void testGetNumeroAttrezzi() {
		assertEquals(3, stanzaRemove.getNumeroAttrezzi());
	}

}
