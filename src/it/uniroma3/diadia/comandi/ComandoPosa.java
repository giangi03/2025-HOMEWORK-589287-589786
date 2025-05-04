package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando {
	
	private String nomeAttrezzo;
	private IO console;
	
	@Override
	public void esegui(Partita partita) {
		Attrezzo attrezzo;
		if(nomeAttrezzo==null)
			console.mostraMessaggio("Inserisci il nome dell'attrezzo da posare");
		else if(partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)==true) {
			attrezzo=partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
			if(partita.getStanzaCorrente().getNumeroAttrezzi()<10) {
				partita.getStanzaCorrente().addAttrezzo(attrezzo);
				console.mostraMessaggio("Hai posato "+partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo)+" nella stanza: "+partita.getStanzaCorrente().getNome());
				partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
			}
			else
				console.mostraMessaggio("Troppi attrezzi nella stanza");
		}
		else
			console.mostraMessaggio("L'attrezzo non è presente nella borsa");
	}
	
	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo=parametro;
	}
	
	@Override
	public String getNome() {
		return "posa";
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
