package application;
import java.util.Map;

public class Calculation {
//henter fra feltene
	
	public Calculation() {
		
	}

	//MÅ HENTE HASHMAP SINE VALUES (fra userprofiles) OG LEGGE DISSE INN I STRING, "tallene"
	
	public double Calculate(String tallene) {
		int prosent = 0;
		double karakter = 0;
		String[] arr = tallene.split("");
		for (String test : arr) {
			if(test.contains("E")) {
				prosent += 52;
				karakter += 1;
			} else if(test.contains("D")) {
				prosent += 64;
				karakter += 2;
			} else if(test.contains("C")) {
				prosent += 76;
				karakter += 3;
			} else if(test.contains("B")) {
				prosent += 88;
				karakter += 4;
			}
			else if(test.contains("A")) {
				prosent += 100;
				karakter += 5;
			}
			else {
				prosent += 0;
				karakter += 0;
			}
			
		}
		return karakter/arr.length;
	}
	
	public static void main(String[] args) {
		Calculation calc = new Calculation();	
		String tallene = "AAAABADA";
		System.out.println(calc.Calculate(tallene));
	}
	
}
