package it.uniroma3.ambienti;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.attrezzi.Attrezzo;

public class StanzaBuiaTest {

	private static final String ATTREZZO_LAMPADA = "Lampada";
	private StanzaBuia stanzaBuia;

	private static final String DESCRIZIONE_STANZA = "StanzaBuia\n" + 
			"Uscite: \n" + 
			"Attrezzi nella stanza: Lampada (1kg) ";

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
		Attrezzo attrezzo = new Attrezzo(ATTREZZO_LAMPADA, 1);
		this.stanzaBuia.addAttrezzo(attrezzo);
		assertEquals(DESCRIZIONE_STANZA, this.stanzaBuia.getDescrizione());
	}

	@Test
	public void testGetAttrezzoInesistente() {
		Attrezzo attrezzo = new Attrezzo("attrezzoTest", 1);
		this.stanzaBuia.addAttrezzo(attrezzo);
		assertNull(this.stanzaBuia.getAttrezzo("inesistente"));		
	}


}