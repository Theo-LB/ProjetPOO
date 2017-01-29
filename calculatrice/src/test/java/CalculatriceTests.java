

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
	
	@Test 
	public void test_multiplication(){
		c.action("*");
		assertEquals(15.0, c.sommet(),0.0001);
	}
	
	@Test 
	public void test_division(){
		c.action("/");
		assertEquals(0.6, c.sommet(),0.0001);
	}
	
	@Test 
	public void test_racinecarre(){
		c.ajout(4.0);
		c.action("sqrt");
		assertEquals(2.0, c.sommet(),0.0001);
	}

	@Test 
	public void test_carre(){
		c.action("carré");
		assertEquals(15.0, c.sommet(),0.0001);
	}
	
	@Test 
	public void test_sinus(){
		c.action("sin");
		assertEquals(-0.9589, c.sommet(),0.0001);
	}
	
	@Test 
	public void test_cosinus(){
		c.action("cos");
		assertEquals(0.2836, c.sommet(),0.0001);
	}
	
	@Test 
	public void test_tangente(){
		c.action("tan");
		assertEquals(-3.3805, c.sommet(),0.0001);
	}
	
	@Test 
	public void test_inverse(){
		c.action("inv");
		assertEquals(0.2, c.sommet(),0.0001);
	}
	
	@Test 
	public void test_oppose(){
		c.action("opp");
		assertEquals(-5.0, c.sommet(),0.0001);
	}
	
	@Test 
	public void test_puissance(){
		c.action("puiss");
		assertEquals(243.0, c.sommet(),0.0001);
	}



}
