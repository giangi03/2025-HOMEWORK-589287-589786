package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GiocatoreTest {
	
	Giocatore giocatore;
	Giocatore giocatore1;

	@BeforeEach
	void setUp() {
		
		/* scenario per getCfu() */
		giocatore=new Giocatore();
		giocatore1=new Giocatore();
		giocatore1.setCfu(3);
	}

	@Test
	void testGetCfuCorretti() {
		assertEquals(20, giocatore.getCfu());
	}
	
	@Test
	void testGetCfuDopoSet() {
		assertEquals(3, giocatore1.getCfu());
	}

}
