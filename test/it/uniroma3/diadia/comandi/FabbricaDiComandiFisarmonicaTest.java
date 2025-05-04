package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;



class FabbricaDiComandiFisarmonicaTest {
	
	FabbricaDiComandiFisarmonica fabbrica;
	Comando comandoVai;
	Comando comandoPosa;
	Comando comandoPrendi;
	Comando comandoAiuto;
	Comando comandoFine;
	Comando comandoGuarda;
	Comando comandoNonValido;
	IO console;

	@BeforeEach
	void setUp() {
		
		console=new IOConsole();
		fabbrica=new FabbricaDiComandiFisarmonica(console);
		comandoVai=fabbrica.costruisciComando("vai");
		comandoVai.setParametro("nord");
		comandoPosa=fabbrica.costruisciComando("posa");
		comandoPosa.setParametro("lanterna");
		comandoPrendi=fabbrica.costruisciComando("prendi");
		comandoPrendi.setParametro("osso");
		comandoAiuto=fabbrica.costruisciComando("aiuto");
		comandoFine=fabbrica.costruisciComando("fine");
		comandoGuarda=fabbrica.costruisciComando("guarda");
		comandoNonValido=fabbrica.costruisciComando("pefforza");
	}

	@Test
	void testComandoVai() {
		assertEquals("vai nord", comandoVai.getNome()+" "+comandoVai.getParametro());
	}
	
	@Test
	void testComandoPosa() {
		assertEquals("posa lanterna", comandoPosa.getNome()+" "+comandoPosa.getParametro());
	}
	
	@Test
	void testComandoPrendi() {
		assertEquals("prendi osso", comandoPrendi.getNome()+" "+comandoPrendi.getParametro());
	}
	
	@Test
	void testComandoAiuto() {
		assertEquals("aiuto nessun parametro", comandoAiuto.getNome()+" "+comandoAiuto.getParametro());
	}
	
	@Test
	void testComandoFine() {
		assertEquals("fine nessun parametro", comandoFine.getNome()+" "+comandoFine.getParametro());
	}
	
	@Test
	void testComandoGuarda() {
		assertEquals("guarda nessun parametro", comandoGuarda.getNome()+" "+comandoGuarda.getParametro());
	}
	
	@Test
	void testComandoNonValido() {
		assertEquals("comando non valido nessun parametro", comandoNonValido.getNome()+" "+comandoNonValido.getParametro());
	}

}
