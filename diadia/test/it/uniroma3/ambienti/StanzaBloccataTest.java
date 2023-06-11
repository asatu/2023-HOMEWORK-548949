package it.uniroma3.ambienti;

import static org.junit.Assert.*;

import it.uniroma3.attrezzi.Attrezzo;
import org.junit.Before;
import org.junit.Test;

public class StanzaBloccataTest {

	private static final String STANZA_ADIACENTE_LIBERA = "stanzaAdLibera";
	private static final String STANZA_ADIACENTE_BLOCCATA = "stanzaAdBloccata";
	private static final Direzione DIREZIONE_BLOCCATA = Direzione.NORD;
	private static final Direzione DIREZIONE_LIBERA = Direzione.SUD;
	private static final String CHIAVE_TEST = "chiaveTest";
	private static final String STANZA_BLOCCATA = "StanzaBloccata";

	private StanzaBloccata stanzaBloccata;

	@Before
	public void setUp() {
		StanzaBloccata stanzaBloccata = new StanzaBloccata(STANZA_BLOCCATA, CHIAVE_TEST, DIREZIONE_BLOCCATA);
		this.stanzaBloccata = stanzaBloccata;
	}

	@Test
	public void testGetStanzaAdiacenteBloccata() {
		Stanza stanzaAdiacenteLibera = new Stanza(STANZA_ADIACENTE_LIBERA);
		Stanza stanzaAdiacenteBloccata = new Stanza(STANZA_ADIACENTE_BLOCCATA);
		this.stanzaBloccata.impostaStanzaAdiacente(DIREZIONE_BLOCCATA, stanzaAdiacenteBloccata);
		this.stanzaBloccata.impostaStanzaAdiacente(DIREZIONE_LIBERA, stanzaAdiacenteLibera);
		
		assertEquals(this.stanzaBloccata, this.stanzaBloccata.getStanzaAdiacente(DIREZIONE_BLOCCATA));
	}

	@Test
	public void testGetStanzaAdiacenteSbloccata() {
		Stanza stanzaAdiacenteLibera = new Stanza(STANZA_ADIACENTE_LIBERA);
		Stanza stanzaAdiacenteBloccata = new Stanza(STANZA_ADIACENTE_BLOCCATA);
		this.stanzaBloccata.impostaStanzaAdiacente(DIREZIONE_BLOCCATA, stanzaAdiacenteBloccata);
		this.stanzaBloccata.impostaStanzaAdiacente(DIREZIONE_LIBERA, stanzaAdiacenteLibera);
		Attrezzo attrezzo = new Attrezzo(CHIAVE_TEST, 1);
		this.stanzaBloccata.addAttrezzo(attrezzo);
		
		assertEquals(STANZA_ADIACENTE_BLOCCATA, this.stanzaBloccata.getStanzaAdiacente(DIREZIONE_BLOCCATA).getNome());
	}

	@Test
	public void testGetStanzaAdiacenteLibera() {
		Stanza stanzaAdiacenteLibera = new Stanza(STANZA_ADIACENTE_LIBERA);
		Stanza stanzaAdiacenteBloccata = new Stanza(STANZA_ADIACENTE_BLOCCATA);
		this.stanzaBloccata.impostaStanzaAdiacente(DIREZIONE_BLOCCATA, stanzaAdiacenteBloccata);
		this.stanzaBloccata.impostaStanzaAdiacente(DIREZIONE_LIBERA, stanzaAdiacenteLibera);
		
		assertEquals(STANZA_ADIACENTE_LIBERA, this.stanzaBloccata.getStanzaAdiacente(DIREZIONE_LIBERA).getNome());
	}

	@Test
	public void testGetAttrezzoInesistente() {
		Attrezzo attrezzo = new Attrezzo("attrezzoDiTest", 1);
		this.stanzaBloccata.addAttrezzo(attrezzo);
		assertNull(this.stanzaBloccata.getAttrezzo("inesistente"));		
	}

}