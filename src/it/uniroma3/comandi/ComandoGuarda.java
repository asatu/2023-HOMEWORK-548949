package it.uniroma3.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

public class ComandoGuarda implements Comando {

	private IO io;
	private static final String NOME = "guarda";

	@Override
	public void esegui(Partita partita) {
		this.io.mostraMessaggio("Stanza corrente: " + partita.getStanzaCorrente().toString());
		this.io.mostraMessaggio("Stato della partita: " + partita.getGiocatore().toString());
	}

	@Override
	public void setParametro(String parametro) { }

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
		return null;
	}

}