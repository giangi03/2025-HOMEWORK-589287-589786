package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	
	Stanza stanzaBloccata;
	Stanza stanzaAdiacente1;
	Stanza stanzaNonBloccata;
	Stanza stanzaAdiacente2;
	Stanza stanzaBloccata2;
	Attrezzo chiave;

	@BeforeEach
	void setUp() {
		
		chiave=new Attrezzo("chiave", 2);
		stanzaBloccata=new StanzaBloccata("salone", "chiave", "nord");
		stanzaAdiacente1=new Stanza("camera da letto");
		stanzaNonBloccata=new StanzaBloccata("cucina", "chiave", "est");
		stanzaAdiacente2=new Stanza("bagno");
		stanzaBloccata.impostaStanzaAdiacente("nord", stanzaAdiacente1);
		stanzaNonBloccata.impostaStanzaAdiacente("ovest", stanzaAdiacente2);
		stanzaBloccata2=new StanzaBloccata("studio", "chiave", "nord");
		stanzaBloccata2.impostaStanzaAdiacente("nord", stanzaAdiacente1);
		stanzaBloccata2.addAttrezzo(chiave);
		
	}

	@Test
	void testStanzaBloccata() {
		assertEquals(stanzaBloccata, stanzaBloccata.getStanzaAdiacente("nord"));
	}
	
	@Test 
	void testStanzaDirezioneNonBloccata() {
		assertEquals(stanzaAdiacente2, stanzaNonBloccata.getStanzaAdiacente("ovest"));
	}
	
	@Test
	void testStanzaConChiave() {
		assertEquals(stanzaAdiacente1, stanzaBloccata2.getStanzaAdiacente("nord"));
	}
	
	@Test
	void testDescrizioneStanzaBloccata() {
		assertNotEquals(stanzaAdiacente1.getDescrizione(), stanzaNonBloccata.getDescrizione());
	}

}
