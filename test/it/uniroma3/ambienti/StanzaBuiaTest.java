package it.uniroma3.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.attrezzi.Attrezzo;

public class StanzaBuiaTest {

	private static final String ATTREZZO_LAMPADA = "Lampada";
	private StanzaBuia stanzaBuia;

	@Before
	public void setUp() {
		this.stanzaBuia = new StanzaBuia("StanzaBuia", ATTREZZO_LAMPADA);
	}

	@Test
	public void testGetDescrizioneLuceNonPresente() {
		assertEquals(StanzaBuia.DESCRIZIONE_STANZA_BUIA, this.stanzaBuia.getDescrizione());
	}

	@Test
	public void testGetDescrizioneConLuce() {
		this.stanzaBuia.addAttrezzo(new Attrezzo(ATTREZZO_LAMPADA, 1));
		assertNotEquals(StanzaBuia.DESCRIZIONE_STANZA_BUIA, this.stanzaBuia.getDescrizione());
	}

	@Test
	public void testGetAttrezzoInesistente() {
		this.stanzaBuia.addAttrezzo(new Attrezzo("attrezzoTest", 1));
		assertNull(this.stanzaBuia.getAttrezzo("inesistente"));		
	}


}