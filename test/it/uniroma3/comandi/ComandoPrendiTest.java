package it.uniroma3.comandi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.attrezzi.Attrezzo;
import it.uniroma3.giocatore.Borsa;

public class ComandoPrendiTest {

	private static final String ATTREZZO_STANZA = "AttrezzoDaPrendere";
	private ComandoPrendi comandoPrendi;
	private Partita partita;

	@Before
	public void setUp() throws Exception {
		this.comandoPrendi = new ComandoPrendi();
		this.comandoPrendi.setIO(new IOConsole());
		this.partita = new Partita();
		Attrezzo attrezzoNuovo = new Attrezzo(ATTREZZO_STANZA, 1);
		this.partita.getStanzaCorrente().addAttrezzo(attrezzoNuovo);
	}

	@Test
	public void testEseguiAttrezzoPresente() {
		this.comandoPrendi.setParametro(ATTREZZO_STANZA);
		this.comandoPrendi.esegui(partita);
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_STANZA));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo(ATTREZZO_STANZA));
	}

	@Test
	public void testEseguiAttrezzoNonPresente() {
		String nonPresente = "attrezzoNonPresente";
		this.comandoPrendi.setParametro(nonPresente);
		this.comandoPrendi.esegui(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo(ATTREZZO_STANZA));
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo(nonPresente));
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_STANZA));
	}

	@Test
	public void testEseguiBorsaPiena() {
		Borsa borsa = partita.getGiocatore().getBorsa();
		borsa.addAttrezzo(new Attrezzo("attrezzoPesante", borsa.getPesoMax()));
		this.comandoPrendi.setParametro(ATTREZZO_STANZA);
		this.comandoPrendi.esegui(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo(ATTREZZO_STANZA));
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo(ATTREZZO_STANZA));
	}

}