
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
				int res = (int)(this.p.get(0) + this.p.get(1));
				this.p = new ArrayList<Double>();
				this.p.add((double)res);
			} else { System.out.println("Veuillez entrer au moins deux nombres.");}
			break;
		case "-":
			if(this.p.size() > 1){
				int res = (int)(this.p.get(0) - this.p.get(1));
				this.p = new ArrayList<Double>();
				this.p.add((double)res);
			} else { System.out.println("Veuillez entrer au moins deux nombres.");}
			break;
		case "*":
			if(this.p.size() > 1){
				int res = (int)(this.p.get(0) * this.p.get(1));
				this.p = new ArrayList<Double>();
				this.p.add((double)res);
			} else { System.out.println("Veuillez entrer au moins deux nombres.");}
			break;
		case "/":
			if(this.p.size() > 1){
				int res = (int)(this.p.get(0) / this.p.get(1));
				this.p = new ArrayList<Double>();
				this.p.add((double)res);
			} else { System.out.println("Veuillez entrer au moins deux nombres.");}
			break;
		case "sqrt":
			if(!this.p.isEmpty()){
				int res = (int)(Math.sqrt(this.p.get(this.p.size() -1)));
				this.p.set(this.p.size() -1, (double)res);
				this.p.add((double)res);
			} else { System.out.println("Veuillez entrer au moins un nombre.");}
			break;
		case "carré":
			if(!this.p.isEmpty()){
				int res = (int)(this.p.get(0)*this.p.get(0));
				this.p = new ArrayList<Double>();
				this.p.add((double)res);
			} else { System.out.println("Veuillez entrer au moins un nombre.");}
			break;
		case "sin":
			if(!this.p.isEmpty()){
				int res = (int)(Math.sin(this.p.get(0)));
				this.p = new ArrayList<Double>();
				this.p.add((double)res);
			} else { System.out.println("Veuillez entrer au moins un nombre.");}
			break;
		case "cos":
			if(!this.p.isEmpty()){
				int res = (int)(Math.cos(this.p.get(0)));
				this.p = new ArrayList<Double>();
				this.p.add((double)(res));
			} else { System.out.println("Veuillez entrer au moins un nombre.");}
			break;
		case "tan":
			if(!this.p.isEmpty()){
				int res = (int)(Math.tan(this.p.get(0)));
				this.p = new ArrayList<Double>();
				this.p.add((double)res);
			} else { System.out.println("Veuillez entrer au moins un nombre.");}
			break;
		case "inv":
			if(!this.p.isEmpty()){
				int res = (int)(1/(this.p.get(0)));
				this.p = new ArrayList<Double>();
				this.p.add((double)res);
			} else { System.out.println("Veuillez entrer au moins un nombre.");}
			break;
		case "opp":
			if(!this.p.isEmpty()){
				int res = (int)(-1*(this.p.get(0)));
				this.p = new ArrayList<Double>();
				this.p.add((double)res);
			} else { System.out.println("Veuillez entrer au moins un nombre.");}
			break;	
		case "puiss":
			if(this.p.size() > 1){
				int res = (int)(Math.pow(this.p.get(0),(this.p.get(1))));
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
		return this.p.get(this.p.size());
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
    }
}
