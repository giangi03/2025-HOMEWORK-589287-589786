package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

class ComandoVaiTest {
	
	Partita partita;
	IO console;
	Comando comandoVai;
	Comando comandoVai2;
	Comando comandoVai3;
	Stanza stanzaCorrente1;
	Stanza stanzaCorrente2;
	FabbricaDiComandiFisarmonica fabbrica;

	@BeforeEach
	void setUp()  {
		
		partita=new Partita();
		console=new IOConsole();
		fabbrica=new FabbricaDiComandiFisarmonica(console);
		stanzaCorrente1=new Stanza("salone");
		stanzaCorrente2=new Stanza("cucina");
		partita.setStanzaCorrente(stanzaCorrente1);
		partita.getStanzaCorrente().impostaStanzaAdiacente("nord", stanzaCorrente2);
		comandoVai=fabbrica.costruisciComando("vai");
		comandoVai.setParametro("nord");
		comandoVai.esegui(partita);
		comandoVai2=fabbrica.costruisciComando("vai");
		comandoVai2.setParametro("est");
		comandoVai2.esegui(partita);
		comandoVai3=fabbrica.costruisciComando("vai");
		comandoVai3.esegui(partita);
		
		
	}

	@Test
	public void testEseguiCorretto() {
		assertEquals("cucina", partita.getStanzaCorrente().getNome());
	}
	
	@Test 
	public void testEseguiDirezioneNonEsistente() {
		assertEquals("cucina", partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testEseguiSenzaDirezione() {
		assertEquals("cucina", partita.getStanzaCorrente().getNome());
	}

}
