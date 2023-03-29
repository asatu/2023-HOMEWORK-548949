package it.uniroma3.giocatore;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.attrezzi.Attrezzo;

public class BorsaTest {

	private static final String ATTREZZO = "attrezzoSemplice";
	private Borsa borsa;
	private static final int PESO_MAX_BORSA = 20;

	@Before
	public void setUp() {
		this.borsa = new Borsa(PESO_MAX_BORSA);
	}

	@Test
	public void testAddAttrezzoSingolo() {
		Attrezzo attrezzo = new Attrezzo(ATTREZZO, 1);
		this.borsa.addAttrezzo(attrezzo);
		assertEquals(attrezzo, this.borsa.getAttrezzo(ATTREZZO));
	}

	@Test
	public void testAddAttrezzoOltrePesoMax() {
		Attrezzo attrezzoPesante = new Attrezzo("attrezzoPesante", PESO_MAX_BORSA+1);
		this.borsa.addAttrezzo(attrezzoPesante);
	}	

	@Test
	public void testGetAttrezzoBorsaVuota() {
		assertNull(this.borsa.getAttrezzo(ATTREZZO));
	}

	@Test
	public void testGetAttrezzoInesistente() {
		this.borsa.addAttrezzo(new Attrezzo(ATTREZZO, 1));
		assertNull(this.borsa.getAttrezzo("inesistente"));
	}

	@Test
	public void testGetPesoMax() {
		assertEquals(PESO_MAX_BORSA, this.borsa.getPesoMax());
	}

	@Test
	public void testGetPesoIniziale() {
		assertEquals(0, this.borsa.getPeso());
	}

	@Test
	public void testGetPesoDopoAddAttrezzo() {
		this.borsa.addAttrezzo(new Attrezzo(ATTREZZO, 1));
		assertEquals(1, this.borsa.getPeso());
	}

	@Test
	public void testIsEmptyIniziale() {
		assertTrue(this.borsa.isEmpty());
	}

	@Test
	public void testIsEmptyDopoAdd() {
		this.borsa.addAttrezzo(new Attrezzo(ATTREZZO, 1));
		assertFalse(this.borsa.isEmpty());
	}

	@Test
	public void testHasAttrezzoEsistente() {
		this.borsa.addAttrezzo(new Attrezzo(ATTREZZO, 1));
		assertTrue(this.borsa.hasAttrezzo(ATTREZZO));
	}

	@Test
	public void testHasAttrezzoInesistente() {
		this.borsa.addAttrezzo(new Attrezzo(ATTREZZO, 1));
		assertFalse(this.borsa.hasAttrezzo("inesistente"));
	}

	@Test
	public void testHasAttrezzoBorsaVuota() {
		assertFalse(this.borsa.hasAttrezzo(ATTREZZO));
	}

	@Test
	public void testRemoveAttrezzo() {
		this.borsa.addAttrezzo(new Attrezzo(ATTREZZO, 1));
		this.borsa.removeAttrezzo(ATTREZZO);
		assertFalse(this.borsa.hasAttrezzo(ATTREZZO));
	}

	@Test
	public void testRemoveAttrezzoPesoZero() {
		this.borsa.addAttrezzo(new Attrezzo(ATTREZZO, 1));
		this.borsa.removeAttrezzo(ATTREZZO);
		assertEquals(0, this.borsa.getPeso());
	}

}