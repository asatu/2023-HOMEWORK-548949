package it.uniroma3.comandi;

import it.uniroma3.diadia.IO;
import java.util.Scanner;

public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi{

	static final private String[] elencoComandi = {"vai", "aiuto", "fine", "prendi", "posa", "guarda", "interagisci", "saluta", "regala"};
	
	@Override
	public AbstractComando costruisciComando(String istruzione, IO io) {
		try (Scanner scannerDiParole = new Scanner(istruzione)){
			String nomeComando = null;
			String parametro = null;
			AbstractComando comando = null;
			if (scannerDiParole.hasNext())
				nomeComando = scannerDiParole.next(); // prima parola: nome del comando
			if (scannerDiParole.hasNext())
				parametro = scannerDiParole.next(); // seconda parola: eventuale parametro
			if (nomeComando == null)
				comando = new ComandoNonValido();
			else if (nomeComando.equals("vai"))
				comando = new ComandoVai();
			else if (nomeComando.equals("prendi"))
				comando = new ComandoPrendi();
			else if (nomeComando.equals("posa"))
				comando = new ComandoPosa();
			else if (nomeComando.equals("interagisci"))
				comando = new ComandoInteragisci();
			else if (nomeComando.equals("saluta"))
				comando = new ComandoSaluta();
			else if (nomeComando.equals("regala"))
				comando = new ComandoRegala();
			else if (nomeComando.equals("aiuto"))
				comando = new ComandoAiuto(elencoComandi);
			else if (nomeComando.equals("fine"))
				comando = new ComandoFine();
			else if (nomeComando.equals("guarda"))
				comando = new ComandoGuarda();
			else
				comando = new ComandoNonValido();
			comando.setParametro(parametro);
			comando.setIO(io);
			return comando;
		}
	}
}