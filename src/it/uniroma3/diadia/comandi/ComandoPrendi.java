package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando{
	
	private String nomeAttrezzo;
	private IO console;
	
	@Override
	public void esegui(Partita partita) {
		Attrezzo attrezzo;
		if(nomeAttrezzo==null) 
			console.mostraMessaggio("Quale attrezzo vuoi prendere?");
		else if(partita.getStanzaCorrente().hasAttrezzo(nomeAttrezzo)==true) {
			attrezzo=partita.getStanzaCorrente().getAttrezzo(nomeAttrezzo);
			if((partita.getGiocatore().getBorsa().getPesoMax()-partita.getGiocatore().getBorsa().getPeso())>=attrezzo.getPeso()&&partita.getGiocatore().getBorsa().getNumeroAttrezzi()<10) {
				partita.getGiocatore().addAttrezzo(attrezzo);
				console.mostraMessaggio("Hai aggiunto: "+partita.getStanzaCorrente().getAttrezzo(attrezzo.getNome())+" alla tua borsa!");
				partita.getStanzaCorrente().removeAttrezzo(attrezzo);
			}
			else
				console.mostraMessaggio("Troppi attrezzi nella borsa");
		}
		else {
			console.mostraMessaggio("L'attrezzo non è presente nella stanza");
		}
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;
	}
	
	@Override
	public String getNome() {
		return "prendi";
	}
	
	@Override
	public String getParametro() {
		return nomeAttrezzo;
	}
	
	@Override
	public void setIO(IO io) {
		this.console=io;
	}
	

}
