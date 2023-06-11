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
		testaComandoGenerale("aiuto", "aiuto", null);
	}

	@Test
	public void testVai() {
		testaComandoGenerale("vai","vai", "nord");
	}

	@Test
	public void testFine() {
		testaComandoGenerale("fine","fine",  null);
	}

	@Test
	public void testPrendi() {
		testaComandoGenerale("prendi","prendi", "osso");
	}

	@Test
	public void testPosa() {
		testaComandoGenerale("posa","posa",  "osso");
	}

	@Test
	public void testComandoVuoto() {
		testaComandoGenerale("","non_valido", null);
	}	

	@Test
	public void testComandoNonValido() {
		testaComandoGenerale("tgregregrt","non_valido", null);
	}	

	private void testaComandoGenerale(String nomeComando, String comandoAtteso, String parametroDaFornire) {
		AbstractComando comando = this.fabbricaDiComandi.costruisciComando(nomeComando, new IOConsole());
		if (parametroDaFornire != null) 
			comando.setParametro(parametroDaFornire);
		assertEquals(comandoAtteso, comando.getNome());
		assertEquals(parametroDaFornire, comando.getParametro());
	}

}