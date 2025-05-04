package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoNonValido implements Comando {
	
	private IO console;
	
	@Override
	public void esegui(Partita partita) {
		console.mostraMessaggio("Comando non valido!");
	}
	
	@Override
	public void setParametro(String parametro) {
	}
	
	@Override
	public String getNome() {
		return "comando non valido";
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
