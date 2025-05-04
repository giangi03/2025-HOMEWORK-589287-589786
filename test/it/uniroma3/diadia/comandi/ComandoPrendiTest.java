package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


class ComandoPrendiTest {
	
	Partita partita;
	IO console;
	FabbricaDiComandiFisarmonica fabbrica;
	Comando comandoPrendi;
	Comando comandoPrendi2;
	Comando comandoPrendi3;
	Stanza stanzaCorrente;
	Attrezzo lanterna;
	Attrezzo osso;
	Attrezzo spada;
	

	@BeforeEach
	void setUp() {
		partita=new Partita();
		console=new IOConsole();
		osso=new Attrezzo("osso", 5);
		spada=new Attrezzo("spada", 11);
		stanzaCorrente=new Stanza("salone");
		lanterna=new Attrezzo("lanterna", 10);
		stanzaCorrente.addAttrezzo(lanterna);
		stanzaCorrente.addAttrezzo(spada);
		partita.setStanzaCorrente(stanzaCorrente);
		fabbrica=new FabbricaDiComandiFisarmonica(console);
		comandoPrendi=fabbrica.costruisciComando("prendi");
		comandoPrendi.setParametro("lanterna");
		comandoPrendi.esegui(partita);
		comandoPrendi2=fabbrica.costruisciComando("prendi");
		comandoPrendi2.setParametro("osso");
		comandoPrendi2.esegui(partita);
		comandoPrendi3=fabbrica.costruisciComando("prendi");
		comandoPrendi3.setParametro("spada");
		comandoPrendi3.esegui(partita);
		
	}

	@Test
	void testEseguiAttrezzoPreso() {
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("lanterna"));
	}
	
	@Test 
	void testEseguiAttrezzoNonEsistente() {
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
	}
	
	@Test
	void testEseguiAttrezzoTroppoPesante() {
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("spada"));
	}

}
