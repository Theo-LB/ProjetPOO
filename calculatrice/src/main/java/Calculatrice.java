
import java.util.ArrayList;
import java.util.Scanner;

public class Calculatrice 
{
   
	private ArrayList<Double> p;
	private Scanner s;
	private boolean interactif,trace;
	
	public Calculatrice(){
		p = new ArrayList<Double>();
		interactif = false;
		trace = false;
	}
	
	public Calculatrice(ArrayList<Double> al){
		this();
		this.p = al;
	}
	
	public void ajout(Double d){
		this.p.add(d);
	}
	
	public void entree(){
		
		this.interactif = true;
		System.out.println("Mode interactif");
		
		s = new Scanner(System.in);
		
		while(interactif){
			String str = s.next();
			if(this.isDouble(str)){
				this.p.add( Double.parseDouble(str));
			}else {
				action(str);
			}
			if(trace){
				System.out.print(this.p);
			}
		}
	}
	
	public void evaluer(String c){
		
		String calc = "";
		
		for(int i = 0 ; i < c.length() ; i++){
			
			if(c.charAt(i) != ' '){
				calc += c.charAt(i);
			}
			
			if(c.charAt(i) == ' ' || i+1 == c.length()){
				
				if(this.isDouble(calc+"")){
					this.p.add( Double.parseDouble(calc));
				}else {
					action(calc);
				}
				
			} 
			
		}
		
		System.out.print(this.p);
	}
	
	public boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
	
	public void action(String action){
		switch(action){
		case "+":
			if(this.p.size() > 1){
				double res = (this.p.get(0) + this.p.get(1));
				this.p = new ArrayList<Double>();
				this.p.add((double)res);
			} else { System.out.println("Veuillez entrer au moins deux nombres.");}
			break;
		case "-":
			if(this.p.size() > 1){
				double res = (this.p.get(0) - this.p.get(1));
				this.p = new ArrayList<Double>();
				this.p.add((double)res);
			} else { System.out.println("Veuillez entrer au moins deux nombres.");}
			break;
		case "*":
			if(this.p.size() > 1){
				double res = (this.p.get(0) * this.p.get(1));
				this.p = new ArrayList<Double>();
				this.p.add((double)res);
			} else { System.out.println("Veuillez entrer au moins deux nombres.");}
			break;
		case "/":
			if(this.p.size() > 1){
				double res = (this.p.get(0) / this.p.get(1));
				this.p = new ArrayList<Double>();
				this.p.add((double)res);
			} else { System.out.println("Veuillez entrer au moins deux nombres.");}
			break;
		case "sqrt":
			if(!this.p.isEmpty()){
				double res = (Math.sqrt(this.p.get(this.p.size() -1)));
				this.p.set(this.p.size() -1, (double)res);
				this.p.add((double)res);
			} else { System.out.println("Veuillez entrer au moins un nombre.");}
			break;
		case "carré":
			if(!this.p.isEmpty()){
				double res = (this.p.get(0)*this.p.get(this.p.size() -1));
				this.p = new ArrayList<Double>();
				this.p.add((double)res);
			} else { System.out.println("Veuillez entrer au moins un nombre.");}
			break;
		case "sin":
			if(!this.p.isEmpty()){
				double res = (Math.sin(this.p.get(this.p.size() -1)));
				this.p = new ArrayList<Double>();
				this.p.add((double)res);
			} else { System.out.println("Veuillez entrer au moins un nombre.");}
			break;
		case "cos":
			if(!this.p.isEmpty()){
				double res = (Math.cos(this.p.get(this.p.size() -1)));
				this.p = new ArrayList<Double>();
				this.p.add((double)(res));
			} else { System.out.println("Veuillez entrer au moins un nombre.");}
			break;
		case "tan":
			if(!this.p.isEmpty()){
				double res = (Math.tan(this.p.get(this.p.size() -1)));
				this.p = new ArrayList<Double>();
				this.p.add((double)res);
			} else { System.out.println("Veuillez entrer au moins un nombre.");}
			break;
		case "inv":
			if(!this.p.isEmpty()){
				double res = (1/(this.p.get(this.p.size() -1)));
				this.p = new ArrayList<Double>();
				this.p.add((double)res);
			} else { System.out.println("Veuillez entrer au moins un nombre.");}
			break;
		case "opp":
			if(!this.p.isEmpty()){
				double res = (-1*(this.p.get(this.p.size() -1)));
				this.p = new ArrayList<Double>();
				this.p.add((double)res);
			} else { System.out.println("Veuillez entrer au moins un nombre.");}
			break;	
		case "puiss":
			if(this.p.size() > 1){
				double res = (Math.pow(this.p.get(0),(this.p.get(1))));
				this.p = new ArrayList<Double>();
				this.p.add((double)res);
			} else { System.out.println("Veuillez entrer au moins un nombre.");}
			break;
		case "pile":
			System.out.print(this.p);
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
	
	public double sommet(){
		return this.p.get(this.p.size()-1);
	}
	
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
