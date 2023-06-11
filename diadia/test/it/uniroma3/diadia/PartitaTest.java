package it.uniroma3.diadia;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.ambienti.Labirinto;
import it.uniroma3.ambienti.Stanza;

public class PartitaTest {

	private Partita partita;
	private Labirinto labirinto;

	@Before
	public void setUp() {
		this.labirinto = Labirinto.newBuilder()
				.addStanzaIniziale("iniziale")
				.addStanzaVincente("vincente")
				.getLabirinto();
		this.partita = new Partita(this.labirinto);
	}

	@Test
	public void testGetStanzaVincenteNotNull() {
		assertNotNull(this.partita.getStanzaVincente());
	}

	@Test
	public void testPartitaNonVintaInizioPartita() {
		assertFalse(this.partita.vinta());
	}

	@Test
	public void testPartitaVintaSeStanzaCorrenteVincente() {
		this.partita.setStanzaCorrente(this.partita.getStanzaVincente());
		assertTrue(this.partita.vinta());
	}

	@Test
	public void testPartitaNonVintaSeStanzaCorrenteNonVincente() {
		this.partita.setStanzaCorrente(new Stanza("NonVincente"));
		assertFalse(this.partita.vinta());
	}

	@Test
	public void testFinitaSeVinta() {
		this.partita.setStanzaCorrente(this.partita.getStanzaVincente());
		assertTrue(this.partita.isFinita());
	}

	@Test
	public void testSetFinita() {
		this.partita.setFinita();
		assertTrue(this.partita.isFinita());
	}

	@Test
	public void testInizioPartitaNonFinita() {
		assertFalse(this.partita.isFinita());
	}

	@Test
	public void testFinitaSeCFUFiniti() {
		this.partita.setCfu(0);
		assertTrue(this.partita.isFinita());
	}

}
