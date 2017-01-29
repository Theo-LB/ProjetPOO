

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatriceTests {
	
	private ArrayList<Double> aL;
	private Calculatrice c;
	

	@Before
	public void setUp() throws Exception {
		
		aL = new ArrayList<Double>();
		aL.add(3.0);
		aL.add(5.0);
		
		c = new Calculatrice(aL);
	}
	
	@Test 
	public void test_addition(){
		c.action("+");
		assertEquals(8.0, c.sommet(),0.0001);
	}
	
	@Test 
	public void test_soustraction(){
		c.action("-");
		assertEquals(-2.0, c.sommet(),0.0001);
	}



}
