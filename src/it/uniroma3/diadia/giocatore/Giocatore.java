package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Giocatore {
	
	static final private int CFU_INIZIALI = 20;
	private int cfu;
	private Borsa borsa;
	
	public Giocatore() {
		this.cfu=CFU_INIZIALI;
		this.borsa=new Borsa();
	}
	
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if(attrezzo.getPeso()>(borsa.getPesoMax()-borsa.getPeso()))
			return false;
		borsa.addAttrezzo(attrezzo);
		return true;
	}
	
	public int getCfu() {
		return this.cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;		
	}
	
	public Borsa getBorsa() {
		return this.borsa;
	}
}
