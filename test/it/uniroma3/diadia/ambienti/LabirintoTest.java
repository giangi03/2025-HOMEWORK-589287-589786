package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.Partita;

class LabirintoTest {
	
	Partita partitaCorretta;
	Partita partitaErrata;
	Stanza mensa;

	@BeforeEach
	void setUp() {
		
		/* scenario per getEntrata() e getUscita() */
		partitaCorretta=new Partita();
		partitaErrata=new Partita();
		mensa=new Stanza("mensa");
		partitaErrata.setStanzaCorrente(mensa);
	}
	
	@Test
	void testGetEntrataCorretta() {
		assertEquals(partitaCorretta.getStanzaCorrente(), partitaCorretta.getLabirinto().getEntrata());
	}
	
	@Test
	void testGetEntrataErrata() {
		assertNotEquals(partitaErrata.getStanzaCorrente(), partitaErrata.getLabirinto().getEntrata());
	}
	
	@Test 
	void testGetUscitaCorretta() {
		assertEquals(partitaCorretta.getStanzaVincente(), partitaCorretta.getLabirinto().getUscita());
	}

}
