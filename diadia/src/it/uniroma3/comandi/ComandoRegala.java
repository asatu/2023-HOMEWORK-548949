package it.uniroma3.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.personaggi.AbstractPersonaggio;

public class ComandoRegala extends AbstractComando{

	private static final String NOME = "regala";
	private static final String MESSAGGIO_CON_CHI = "A chi dovrei dare il regalo?...";
	private static final String MESSAGGIO_OK = "Regalo ricevuto";

	public ComandoRegala() {
		super.setNome(NOME);
	}

	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getStanzaCorrente().getPersonaggio();
		if (personaggio!=null) {
			personaggio.riceviRegalo(partita.getGiocatore().getBorsa().getAttrezzo(super.getParametro()), partita);
			super.getIO().mostraMessaggio(MESSAGGIO_OK);
		} else 
			super.getIO().mostraMessaggio(MESSAGGIO_CON_CHI);
	}

}