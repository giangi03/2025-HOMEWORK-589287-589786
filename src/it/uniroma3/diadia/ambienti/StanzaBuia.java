package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza{
	
	private String attrezzoLucente;
	
	public StanzaBuia(String nome, String lanterna) {
		super(nome);
		this.attrezzoLucente=lanterna;
	}
	
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(attrezzoLucente))
			return super.getDescrizione();
		return "qui c'è buio pesto";
	}

}
