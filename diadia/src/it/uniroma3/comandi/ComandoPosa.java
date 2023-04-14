package it.uniroma3.comandi;

import it.uniroma3.attrezzi.Attrezzo;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.giocatore.Borsa;

public class ComandoPosa implements Comando {

	private String parametro;
	private IO io;
	private final static String NOME = "posa";

	/**
	 * esecuzione del comando
	 */
	@Override
	public void esegui(Partita partita) {
		Borsa borsa = partita.getGiocatore().getBorsa();
		Attrezzo attrezzoDaPosare = borsa.getAttrezzo(this.parametro);
		if (attrezzoDaPosare == null) {
			this.io.mostraMessaggio("Attrezzo " + attrezzoDaPosare + " non presente nella borsa");
			return;
		}

		boolean attrezzoPosato = partita.getStanzaCorrente().addAttrezzo(attrezzoDaPosare);
		if (!attrezzoPosato) {
			this.io.mostraMessaggio("Non c'è più spazio per nuovi attrezzi nella stanza");
			return;
		}

		borsa.removeAttrezzo(this.parametro);
		this.io.mostraMessaggio("Attrezzo " + this.parametro + " posato!");
	}
	
	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	@Override
	public void setIO(IO io) {
		this.io = io;
	}

	@Override
	public String getNome() {
		return NOME;
	}

	@Override
	public String getParametro() {
		return this.parametro;
	}

}
