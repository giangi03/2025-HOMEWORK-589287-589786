package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando{
	
	private IO console;
	
	public void esegui(Partita partita) {
		
		console.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		console.mostraMessaggio(partita.toString());
	}
	
	public void setParametro(String parametro) {
	}
	
	@Override
	public String getNome() {
		return "guarda";
	}
	
	@Override
	public String getParametro() {
		return "nessun parametro";
	}
	
	@Override
	public void setIO(IO io) {
		this.console=io;
	}
	

}
