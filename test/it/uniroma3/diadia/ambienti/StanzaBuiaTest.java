package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	
	Stanza stanzaBuia;
	Stanza stanzaLuminosa;
	Stanza stanzaNoAttrezzi;
	Attrezzo lanterna;
	Attrezzo spada;

	@BeforeEach
	void setUp() {
		
		stanzaBuia=new StanzaBuia("salone", "lanterna");
		lanterna=new Attrezzo("lanterna", 10);
		spada=new Attrezzo("spada", 5);
		stanzaBuia.addAttrezzo(spada);
		stanzaLuminosa=new StanzaBuia("cucina", "lanterna");
		stanzaLuminosa.addAttrezzo(lanterna);
		stanzaNoAttrezzi=new StanzaBuia("garage", "lanterna");
	}

	@Test
	void testStanzaBuia() {
		assertEquals("qui c'è buio pesto", stanzaBuia.getDescrizione());
	}
	
	@Test
	void testStanzaLuminosa() {
		assertEquals(stanzaLuminosa.toString(), stanzaLuminosa.getDescrizione());
	}
	
	@Test
	void testStanzaSenzaAttrezzi() {
		assertEquals("qui c'è buio pesto", stanzaNoAttrezzi.getDescrizione());
	}

}
