import java.util.ArrayList;
import java.util.Scanner;

public class Calculatrice 
{
   
	private ArrayList<Double> p;
	private Scanner s;
	private boolean interactif,trace;
	
	// Constructeur d'une calcultrice sans paramètres	
	public Calculatrice(){
		p = new ArrayList<Double>();
		interactif = false;
		trace = false;
	} 

	// Méthode d'ajout d'une opérande ou d'un opérateur
	public void ajout(String a){
		if(this.estNombre(a)){
			this.p.add(Double.parseDouble(a));
		}
		else {
			this.action(a);
		}
	}
	
	
	// Mode interactif de la calculatrice
	public void entree(){
		
		this.interactif = true;
		System.out.println("Mode interactif");
		
		s = new Scanner(System.in);
		
		while(interactif){
			String str = s.next();
			if(this.estNombre(str)){
				this.p.add( Double.parseDouble(str));
			}else {
				action(str);
			}
			if(trace){
				System.out.print(this.p);
			}
		}
	}
	
	// Méthode d'évaluation d'une string donnée en paramètre
	public void evaluer(String c){
		
		String calc = "";
		
		for(int i = 0 ; i < c.length() ; i++){
			
			if(c.charAt(i) != ' '){
				calc += c.charAt(i);
			}
			
			if(c.charAt(i) == ' ' || i+1 == c.length()){
				
				if(this.estNombre(calc+"")){
					this.p.add( Double.parseDouble(calc));
				}else {
					action(calc);
				}
				
			} 
			
		}
		
		System.out.print(this.p);
	}
	
	// Methode de test pour savoir si une string est un nombre
	public boolean estNombre(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
	
	// Ensemble des actions possibles dans la calculatrice
	public void action(String action){
		switch(action){
		case "+":
			if(this.p.size() > 1){
				double res = (this.p.get(this.p.size() -2) + this.p.get(this.p.size() -1));
				this.p.remove(this.p.size()-1);
				this.p.set(this.p.size() -1, (double)res);
			} else { System.out.println("[Addition] Veuillez entrer au moins deux nombres.");}
			break;
		case "-":
			if(this.p.size() > 1){
				double res = (this.p.get(this.p.size() -2) - this.p.get(this.p.size() -1));
				this.p.remove(this.p.size()-1);
				this.p.set(this.p.size() -1, (double)res);
			} else { System.out.println("[Soustraction] Veuillez entrer au moins deux nombres.");}
			break;
		case "*":
			if(this.p.size() > 1){
				double res = (this.p.get(this.p.size() -2) * this.p.get(this.p.size() -1));
				this.p.remove(this.p.size()-1);
				this.p.set(this.p.size() -1, (double)res);
			} else { System.out.println("[Multiplication] Veuillez entrer au moins deux nombres.");}
			break;
		case "/":
			if(this.p.size() > 1 && this.p.get(this.p.size() -1) != 0.0){
				double res = (this.p.get(this.p.size() -2) / this.p.get(this.p.size() -1));
				this.p.remove(this.p.size()-1);
				this.p.set(this.p.size() -1, (double)res);
			} else if(this.p.get(this.p.size() -1) == 0.0) {System.out.println("[Division] Il est impossible de diviser par 0."); }
			else {System.out.println("[Division] Veuillez entrer au moins deux nombres.");}
			break;
		case "sqrt":
			if(!this.p.isEmpty() && this.p.get(this.p.size() -1) >= 0.0){
				double res = (Math.sqrt(this.p.get(this.p.size() -1)));
				this.p.set(this.p.size() -1, (double)res);
			} else if(this.p.get(this.p.size() -1) < 0.0) {System.out.println("[Racine carré] Il est impossible de calculer la racine carré d'un nombre négatif."); }
			else {System.out.println("[Racine carré] Veuillez entrer au moins deux nombres.");}
			break;
		case "carré":
			if(!this.p.isEmpty()){
				double res = (this.p.get(this.p.size() -1)*this.p.get(this.p.size() -1));
				this.p.set(this.p.size() -1, (double)res);
			} else { System.out.println("[Carré] Veuillez entrer au moins un nombre.");}
			break;
		case "sin":
			if(!this.p.isEmpty()){
				double res = (Math.sin(this.p.get(this.p.size() -1)));
				this.p.set(this.p.size() -1, (double)res);
			} else { System.out.println("[Sinus] Veuillez entrer au moins un nombre.");}
			break;
		case "cos":
			if(!this.p.isEmpty()){
				double res = (Math.cos(this.p.get(this.p.size() -1)));
				this.p.set(this.p.size() -1, (double)res);
			} else { System.out.println("[Cosinus] Veuillez entrer au moins un nombre.");}
			break;
		case "tan":
			if(!this.p.isEmpty()){
				double res = (Math.tan(this.p.get(this.p.size() -1)));
				this.p.set(this.p.size() -1, (double)res);
			} else { System.out.println("[Tangente] Veuillez entrer au moins un nombre.");}
			break;
		case "inv":
			if(!this.p.isEmpty() && this.p.get(this.p.size() -1) != 0.0){
				double res = (1/(this.p.get(this.p.size() -1)));
				this.p.set(this.p.size() -1, (double)res);
			} else if(this.p.get(this.p.size() -1) == 0.0) {System.out.println("[Inverse] 0 n'a pas d'inverse."); }
			else {System.out.println("[Inverse] Veuillez entrer au moins deux nombres.");}
			break;
		case "opp":
			if(!this.p.isEmpty()){
				double res = (-1*(this.p.get(this.p.size() -1)));
				this.p.set(this.p.size() -1, (double)res);
			} else { System.out.println("[Oppose] Veuillez entrer au moins un nombre.");}
			break;	
		case "puiss":
			if(this.p.size() > 1){
				double res = (Math.pow( this.p.get(this.p.size() -2),( this.p.get(this.p.size() -1))));
				this.p.remove(this.p.size()-1);
				this.p.set(this.p.size() -1, (double)res);
			} else { System.out.println("[Puissance] Veuillez entrer au moins un nombre.");}
			break;
		case "!":
			if(!this.p.isEmpty() && this.p.get(this.p.size() -1) > 0.0){
				double res = (gamma(this.p.get(this.p.size() -1)));
				this.p.set(this.p.size() -1, res);

			} else if(this.p.get(this.p.size() -1) <= 0.0) {System.out.println("[Gamma] Le gamma d'un nombre inférieur ou égal à 0 est impossible."); }
			else {System.out.println("[Gamma] Veuillez entrer au moins deux nombres.");}
			break;
		case "pile":
			System.out.print(this.p);
			break;
		case "sommet":
			if(!this.p.isEmpty()){
				System.out.print(this.sommet());
			} else { System.out.println("[Sommet] Veuillez entrer au moins un nombre/opérande.");}
			break;
		case "stop":
			this.interactif = false;
			break;
		case "trace":
			this.trace = true;
			break;
		case "notrace":
			this.trace = false;
			break;
		default:
			System.out.println("Erreur dans votre saisie.");
			break;
		}
		
	}
	
	// Fonction Gamma d'Euler en java
	public static double gamma(double x) {
	      double tmp = (x - 0.5) * Math.log(x + 4.5) - (x + 4.5);
	      double ser = 1.0 + 76.18009173    / (x + 0)   - 86.50532033    / (x + 1)
	                       + 24.01409822    / (x + 2)   -  1.231739516   / (x + 3)
	                       +  0.00120858003 / (x + 4)   -  0.00000536382 / (x + 5);
	      return Math.exp(tmp + Math.log(ser * Math.sqrt(2 * Math.PI)));
	   }
	
	// Methode pour connaitre le sommet de la pile
	public double sommet(){
		return this.p.get(this.p.size()-1);
	}
	
	// Méthode d'affichage de la pile
	public String toString(){
		return this.toString();
	}
	
	
	public static void main( String[] args )
    {
		Calculatrice c = new Calculatrice();
		if(args.length == 0)
	    {
			c.entree();
	    }
		else {
			c.evaluer(args[0]);
		}
    }
}
