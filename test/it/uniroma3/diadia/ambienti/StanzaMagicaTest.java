package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaMagicaTest {
	
	Stanza stanza1;
	StanzaMagica stanzaMagica;
	Attrezzo spada;
	Attrezzo scudo;

	@BeforeEach
	void setUp() {
		stanza1=new Stanza("stanza1");
		stanzaMagica=new StanzaMagica("stanzaMagica", 1);
		spada=new Attrezzo("spada", 10);
		scudo=new Attrezzo("scudo", 5);
		stanzaMagica.addAttrezzo(spada);
		stanzaMagica.addAttrezzo(scudo);
	}
	
	@Test
	void testAddAttrezzoCorretto() {
		assertTrue(stanzaMagica.addAttrezzo(scudo));
	}

	@Test
	void testModificaAttrezzoInvertito() {
		assertTrue(stanzaMagica.hasAttrezzo("oducs"));
	}
	
	@Test 
	void testModificaAttrezzoNonInvertito() {
		assertFalse(stanzaMagica.hasAttrezzo("adaps"));
	}
	
	@Test
	void testModificaAttrezzoNonDoppione() {
		assertFalse(stanzaMagica.hasAttrezzo("scudo"));
	}
	
	@Test
	void testModificaAttrezzoPesoRaddoppiato() {
		assertEquals(10, stanzaMagica.getAttrezzo("oducs").getPeso());
	}
	
	void testModificaAttrezzoNonRaddoppiato() {
		assertEquals(10, stanzaMagica.getAttrezzo("spada").getPeso());
	}

}
