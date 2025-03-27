package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PartitaTest {
	
	Partita partitaNonVinta;
	Partita partitaVinta;
	Partita partitaNulla;
	Partita partitaFinita;
	Partita partitaNonFinitaCfu;
	
	@BeforeEach
	void setUp() {
		
		/* scenario per vinta() */
		partitaNonVinta=new Partita();
		partitaVinta=new Partita();
		partitaVinta.setStanzaCorrente(partitaVinta.getStanzaVincente());
		partitaNulla=new Partita();
		partitaNulla.setStanzaCorrente(null);
		
		/* scenario per isFinita() */
		partitaFinita=new Partita();
		partitaFinita.setFinita();
		partitaNonFinitaCfu=new Partita();
		partitaNonFinitaCfu.getGiocatore().setCfu(12);
		
	}

	@Test
	void testVintaNonVinta() {
		assertFalse(partitaNonVinta.vinta());
	}
	
	@Test
	void testVintaVinta() {
		assertTrue(partitaVinta.vinta());
	}
	
	@Test
	void testVintaNulla() {
		assertFalse(partitaNulla.vinta());
	}
	
	@Test 
	void testIsFinitaFinita() {
		assertTrue(partitaFinita.isFinita());
	}
	
	@Test
	void testIsFinitaNonVinta() {
		assertFalse(partitaNonVinta.isFinita());
	}
	
	@Test 
	void testIsFinitaNonFinitaPerCfu() {
		assertFalse(partitaNonFinitaCfu.isFinita());
	}
	

}
