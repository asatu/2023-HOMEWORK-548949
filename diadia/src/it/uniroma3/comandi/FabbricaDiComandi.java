package it.uniroma3.comandi;

import it.uniroma3.diadia.IO;

public interface FabbricaDiComandi {

	/**
	 * Costruisce il comando con una stringa istruzione in input, che contiene il comando ed un eventuale parametro.
	 * @param istruzione
	 * @return
	 */
	public Comando costruisciComando(String istruzione, IO io);
}
