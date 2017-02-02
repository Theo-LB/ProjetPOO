

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatriceTests {
	
	private ArrayList<Double> aL,aL2;
	private Calculatrice c,c2;
	
	// Initialisation
	@Before
	public void setUp() throws Exception {
		
		c = new Calculatrice();
		
		c.ajout("3.0");
		c.ajout("5.0");
	}
	
	//
	// Tests avec des nombres décimaux positifs
	//
	
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
		c.ajout("4.0");
		c.action("sqrt");
		assertEquals(2.0, c.sommet(),0.0001);
	}

	@Test 
	public void test_carre(){
		c.action("carré");
		assertEquals(25.0, c.sommet(),0.0001);
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
	
	@Test 
	public void test_gamma(){
		c.action("!");
		assertEquals(23.9999, c.sommet(),0.0001);
	}
	
	//
	// Tests avec une opérande nulle
	//
		
	@Test
	public void test_addition_zero(){
		c.ajout("0.0");
		c.action("+");
		assertEquals(5.0, c.sommet(),0.0001);
	}
	
	@Test
	public void test_soustraction_zero(){
		c.ajout("0.0");
		c.action("-");
		assertEquals(5.0, c.sommet(),0.0001);
	}

	@Test
	public void test_multiplication_zero(){
		c.ajout("0.0");
		c.action("*");
		assertEquals(0.0, c.sommet(),0.0001);
	}
	
	@Test
	public void test_division_zero(){
		c.ajout("0.0");
		c.action("/");
		assertEquals(0.0, c.sommet(),0.0001);
	}
	
	@Test
	public void test_racinecarre_zero(){
		c.ajout("0.0");
		c.action("sqrt");
		assertEquals(0.0, c.sommet(),0.0001);
	}
	
	@Test
	public void test_carre_zero(){
		c.ajout("0.0");
		c.action("carré");
		assertEquals(0.0, c.sommet(),0.0001);
	}
	
	@Test
	public void test_sin_zero(){
		c.ajout("0.0");
		c.action("sin");
		assertEquals(0.0, c.sommet(),0.0001);
	}
	
	@Test
	public void test_tan_zero(){
		c.ajout("0.0");
		c.action("tan");
		assertEquals(0.0, c.sommet(),0.0001);
	}
	
	@Test
	public void test_cos_zero(){
		c.ajout("0.0");
		c.action("cos");
		assertEquals(1.0, c.sommet(),0.0001);
	}
	
	@Test
	public void test_inverse_zero(){
		c.ajout("0.0");
		c.action("inv");
		assertEquals(0.0, c.sommet(),0.0001);
	}
	
	@Test
	public void test_oppose_zero(){
		c.ajout("0.0");
		c.action("opp");
		assertEquals(0.0, c.sommet(),0.0001);
	}
	
	@Test
	public void test_puissance_zero(){
		c.ajout("0.0");
		c.action("puiss");
		assertEquals(1.0, c.sommet(),0.0001);
	}
	
	@Test
	public void test_gamma_zero(){
		c.ajout("0.0");
		c.action("!");
		assertEquals(0.0, c.sommet(),0.0001);
	}
	
	//
	// Tests avec un nombre décimal négatif
	//
	
	@Test
	public void test_addition_negatif(){
		c.ajout("-2.0");
		c.action("+");
		assertEquals(3.0, c.sommet(),0.0001);
	}
	
	@Test
	public void test_soustraction_negatif(){
		c.ajout("-2.0");
		c.action("-");
		assertEquals(7.0, c.sommet(),0.0001);
	}
	
	@Test
	public void test_multiplication_negatif(){
		c.ajout("-2.0");
		c.action("*");
		assertEquals(-10.0, c.sommet(),0.0001);
	}
	
	@Test
	public void test_division_negatif(){
		c.ajout("-2.0");
		c.action("/");
		assertEquals(-2.5, c.sommet(),0.0001);
	}
	
	@Test
	public void test_racinecarre_negatif(){
		c.ajout("-2.0");
		c.action("sqrt");
		assertEquals(-2.0, c.sommet(),0.0001);
	}
	
	@Test
	public void test_carre_negatif(){
		c.ajout("-2.0");
		c.action("carré");
		assertEquals(4.0, c.sommet(),0.0001);
	}
	
	@Test
	public void test_sinus_negatif(){
		c.ajout("-2.0");
		c.action("sin");
		assertEquals(-0.9092, c.sommet(),0.0001);
	}
	
	@Test
	public void test_cosinus_negatif(){
		c.ajout("-2.0");
		c.action("cos");
		assertEquals(-0.4161, c.sommet(),0.0001);
	}
	
	@Test
	public void test_tangente_negatif(){
		c.ajout("-2.0");
		c.action("tan");
		assertEquals(2.1850, c.sommet(),0.0001);
	}
	
	@Test
	public void test_inverse_negatif(){
		c.ajout("-2.0");
		c.action("inv");
		assertEquals(-0.5, c.sommet(),0.0001);
	}
	
	@Test
	public void test_oppose_negatif(){
		c.ajout("-2.0");
		c.action("opp");
		assertEquals(2.0, c.sommet(),0.0001);
	}
	
	@Test
	public void test_puissance_negatif(){
		c.ajout("-2.0");
		c.action("puiss");
		assertEquals(0.04, c.sommet(),0.0001);
	}
	
	@Test
	public void test_gamma_negatif(){
		c.ajout("-2.0");
		c.action("!");
		assertEquals(-2.0, c.sommet(),0.0001);
	}
	
	//
	// Test de l'exemple donné dans l'énoncé
	
	@Test
	public void test_enonce(){
			
		c2 = new Calculatrice();
		c2.ajout("3.0");
		c2.ajout("4.0");
		c2.ajout("sqrt");

		c2.ajout("+");
		c2.ajout("10");
		c2.ajout("3");
		c2.ajout("-");
		c2.ajout("*");
		
		assertEquals(35.0, c2.sommet(),0.0001);
		
		// Ce test permet d'observer que l'énoncé comporte une coquille et que le résultat attendu
		// n'est pas 21 mais 35
		
		
	}

}
