package it.uniroma3.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.ambienti.*;
import it.uniroma3.diadia.*;

public class ComandoVaiTest {

	private static final String NOME_STANZA_PARTENZA = "Partenza";
	private static final String NORD = "nord";
	private static final Direzione DIREZIONE_NORD = Direzione.NORD;
	private Partita partita;
	private AbstractComando comandoVai;
	private Stanza partenza;

	@Before
	public void setUp() throws Exception {
		this.comandoVai = new ComandoVai();
		this.comandoVai.setIO(new IOConsole());
		Labirinto labirinto = Labirinto.newBuilder()
				.addStanzaIniziale(NOME_STANZA_PARTENZA)
				.getLabirinto();
		this.partita = new Partita(labirinto);
		this.partenza = this.partita.getStanzaCorrente();
	}

	@Test
	public void testVaiStanzaNonPresente() {
		this.comandoVai.setParametro(NORD);
		this.comandoVai.esegui(this.partita);
		assertEquals(NOME_STANZA_PARTENZA, this.partita.getStanzaCorrente().getNome());
	}

	@Test
	public void testVaiStanzaPresente() {
		Stanza destinazione = new Stanza("Destinazione");
		this.partenza.impostaStanzaAdiacente(DIREZIONE_NORD, destinazione);
		this.comandoVai.setParametro(NORD);
		this.comandoVai.esegui(partita);
		assertEquals("Destinazione", this.partita.getStanzaCorrente().getNome());
	}

	@Test
	public void testVaiStanzaPresenteInDirezioneSbagliata() {
		Stanza destinazione = new Stanza("Destinazione");
		this.partenza.impostaStanzaAdiacente(Direzione.SUD, destinazione);
		this.comandoVai.setParametro(NORD);
		this.comandoVai.esegui(partita);
		assertEquals(NOME_STANZA_PARTENZA, this.partita.getStanzaCorrente().getNome());
	}

	public void assertContains(String expected, String interaRiga) {
		assertTrue(interaRiga.contains(expected));
	}

}
