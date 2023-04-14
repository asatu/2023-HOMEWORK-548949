package it.uniroma3.giocatore;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GiocatoreTest {

	private Giocatore giocatore;

	@Before
	public void setUp() {
		this.giocatore = new Giocatore();
	}

	@Test
	public void testCfuNotNull() {
		assertNotNull(this.giocatore.getCfu());
	}

	@Test
	public void testCfuIniziali() {
		assertEquals(Giocatore.CFU_INIZIALI,this.giocatore.getCfu());
	}

}
