package it.uniroma3.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;

public class FabbricaDiComandiFisarmonicaTest {
	
	private FabbricaDiComandiFisarmonica fabbricaDiComandi;

	@Before
	public void setUp() throws Exception {
		this.fabbricaDiComandi = new FabbricaDiComandiFisarmonica();
	}

	@Test
	public void testAiuto() {
		Comando comando = this.fabbricaDiComandi.costruisciComando("aiuto", new IOConsole());
		assertEquals("aiuto", comando.getNome());
	}
	
	@Test
	public void testVai() {
		Comando comando = this.fabbricaDiComandi.costruisciComando("vai", new IOConsole());
		assertEquals("vai", comando.getNome());
		comando.setParametro("sud");
		assertEquals("sud", comando.getParametro());
	}
	
	@Test
	public void testFine() {
		Comando comando = this.fabbricaDiComandi.costruisciComando("fine", new IOConsole());
		assertEquals("fine", comando.getNome());
	}
	
	@Test
	public void testPrendi() {
		Comando comando = this.fabbricaDiComandi.costruisciComando("prendi", new IOConsole());
		assertEquals("prendi", comando.getNome());
		comando.setParametro("lanterna");
		assertEquals("lanterna", comando.getParametro());
	}
	
	@Test
	public void testPosa() {
		Comando comando = this.fabbricaDiComandi.costruisciComando("posa", new IOConsole());
		assertEquals("posa", comando.getNome());
		comando.setParametro("lanterna");
		assertEquals("lanterna", comando.getParametro());
	}	

	@Test
	public void testComandoVuoto() {
		Comando comando = this.fabbricaDiComandi.costruisciComando("", new IOConsole());
		assertEquals("non_valido", comando.getNome());
	}	
	
	@Test
	public void testComandoNonValido() {
		Comando comando = this.fabbricaDiComandi.costruisciComando("vola", new IOConsole());
		assertEquals("non_valido", comando.getNome());
	}

}