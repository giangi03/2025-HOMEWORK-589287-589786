package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;


class ComandoPosaTest {
	
	Partita partita;
	Partita partita2;
	FabbricaDiComandiFisarmonica fabbrica;
	Comando comandoPosa;
	Stanza stanzaCorrente;
	Attrezzo lanterna;
	Attrezzo osso;
	Attrezzo spada;
	IO console;

	@BeforeEach
	void setUp() {
		
		console=new IOConsole();
		partita=new Partita();
		partita2=new Partita();
		osso=new Attrezzo("osso", 5);
		spada=new Attrezzo("spada", 11);
		stanzaCorrente=new Stanza("salone");
		lanterna=new Attrezzo("lanterna", 10);
		partita.getGiocatore().getBorsa().addAttrezzo(osso);
		partita.setStanzaCorrente(stanzaCorrente);
		fabbrica=new FabbricaDiComandiFisarmonica(console);
		comandoPosa=fabbrica.costruisciComando("posa");
		comandoPosa.setParametro("osso");
		comandoPosa.esegui(partita);
		partita2.getGiocatore().getBorsa().addAttrezzo(osso);
		for(int i=0;i<10;i++)
			partita2.getStanzaCorrente().addAttrezzo(lanterna);
		comandoPosa.esegui(partita2);
	}

	@Test
	void testEseguiAttrezzoPosato() {
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("osso"));
	}
	
	@Test 
	void testEseguiAttrezzoNonPiuNellaBorsa() {
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
	}
	
	@Test
	void testEseguiStanzaPiena() {
		assertTrue(partita2.getGiocatore().getBorsa().hasAttrezzo("osso"));
	}
	

}
