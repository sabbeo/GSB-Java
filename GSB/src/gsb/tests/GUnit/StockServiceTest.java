package gsb.tests.GUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import gsb.service.StockService;
import junit.framework.TestCase;

public class StockServiceTest extends TestCase {

	@Before
	protected void setUp() throws Exception {
		super.setUp();
	}

	@After
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	@Test
	public void testCheckcodevisiteurBlanc() {
		
		assertNull("Resultat insertion : ",StockService.checkcodevisiteur(""));
	}
	@Test
	public void testCheckcodevisiteurOk() {
		assertNotNull("Resultat insertion : ",StockService.checkcodevisiteur("a131"));
		
	}
	
	@Test
	public void testAjoutStockBlanc() {
		assertEquals("Resultat insertion : ", 0,StockService.ajoutStock("","",0));
	}
	@Test
	public void testAjoutStockOK() {
		assertEquals("Resultat insertion : ", 1,StockService.ajoutStock("a131", "3MYC7", 10));
	}
}
