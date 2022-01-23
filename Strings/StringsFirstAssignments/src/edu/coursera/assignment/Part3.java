package edu.coursera.assignment;

public class Part3 {

	public boolean twoOccurrences(String stringa, String stringb) {
		int index = 0, count = 0;
		
		while (true) {
			index = stringb.indexOf(stringa, index);
			if (index != -1) {
				count ++;
				index += stringa.length();
			} else {
				break;
			}
		}
		
		if (count >= 2)
			return true;
		
		return false;
	}
	
	public String lastPart(String stringa, String stringb) {
		
		int index = stringb.indexOf(stringa);
		if (index != -1)
			return stringb.substring(stringa.length()+1);
		
		return stringb;
	}
	
	public void testTwoOccurrences() {
		String stringa = "atg";
		String stringb = "ctgtatgta";
		
		boolean result = twoOccurrences(stringa, stringb);
		System.out.println(result);
	}
	
	public void testLastPart() {
		String stringa = "zoo";
		String stringb = "forest";
		String result = lastPart(stringa, stringb);
		System.out.printf("The part of the string after %s in %s is %s.", stringa, stringb, result); 
	}
	
	public static void main(String []args) {
		Part3 part3 = new Part3();
		part3.testTwoOccurrences();
		
		part3.testLastPart();
	}
}
