package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	
	private String direzioneBloccata;
	private String attrezzoCheSbloccaDirezione;
	
	public StanzaBloccata(String nome, String attrezzoCheSbloccaDirezione, String direzioneBloccata) {
		super(nome);
		this.attrezzoCheSbloccaDirezione=attrezzoCheSbloccaDirezione;
		this.direzioneBloccata=direzioneBloccata;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String dir) {
		if(dir.equals(direzioneBloccata))
			if(this.hasAttrezzo(attrezzoCheSbloccaDirezione))
				return super.getStanzaAdiacente(dir);
			else return this;
		return super.getStanzaAdiacente(dir);
	}
	
	@Override
	public String getDescrizione() {
		return this.toString();
	}
	
	@Override
	public String toString() {
		return super.toString()+"\n"+"La direzione "+this.direzioneBloccata+" è bloccata, serve l'attrezzo "+this.attrezzoCheSbloccaDirezione+" per sbloccarla!";
	}

}
