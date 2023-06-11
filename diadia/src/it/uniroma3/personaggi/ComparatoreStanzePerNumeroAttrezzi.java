package it.uniroma3.personaggi;

import java.util.Comparator;

import it.uniroma3.ambienti.Stanza;

public class ComparatoreStanzePerNumeroAttrezzi implements Comparator<Stanza>{

	@Override
	public int compare(Stanza o1, Stanza o2) {
		return o2.getAttrezzi().size() - o1.getAttrezzi().size();
	}

}