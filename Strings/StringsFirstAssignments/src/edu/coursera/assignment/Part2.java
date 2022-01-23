package edu.coursera.assignment;

public class Part2 {

	public String findSimpleGene(String dna, String startCodon, String stopCodon) {
		int startIndex = 0;
		int endIndex = 0;
		// Search for starting index for substring "ATG"
		char[] charDNA = dna.toCharArray();
		boolean isLower = true;
		for (int idx = 0; idx < charDNA.length; idx++) {
			if (!Character.isLowerCase(charDNA[idx])) {
				isLower = false;
			}
		}
		if (isLower) {
			startIndex = dna.indexOf(startCodon.toLowerCase());
			if (startIndex == -1)
					return "";
			
			// Search for index position of the first stop codon “TAA” appearing after the “ATG”
			endIndex = dna.indexOf(stopCodon.toLowerCase(), startIndex+3);
			if (endIndex == -1)
				return "";
			
			return dna.substring(startIndex, endIndex+3).toLowerCase();
		}
		
		startIndex = dna.indexOf(startCodon);
		if (startIndex == -1)
				return "";
		
		// Search for index position of the first stop codon “TAA” appearing after the “ATG”
		endIndex = dna.indexOf(stopCodon, startIndex+3);
		if (endIndex == -1)
			return "";
		
		// Check if difference of startIndex and endIndex is multiple of 3
		if ((endIndex - startIndex) % 3 != 0)
			return "";
		
		return dna.substring(startIndex, endIndex+3);
	}
	
	public void testSimpleGene() {
		// Variable for Start Codon
		String startCodon = "ATG";
		
		// Variable for End Codon
		String stopCodon = "TAA";
		
		// Test case
		String dna[] = {"CGATCCATAA", "CGATGCTATC", "CGATAGTTGA", "CGATGCAAGTTTAA", "CGATGCAGTGTAA"};
		String dna1[] = {"ATGGGTTAAGTC", "gatgctataat"};
		
		for (int idx = 0; idx < dna1.length; idx++) {
			String gene = findSimpleGene(dna1[idx], startCodon, stopCodon);
			System.out.println("Gene is = " + gene);
		}
	}
	
	public static void main(String[] args) {
		Part2 part2 = new Part2();
		part2.testSimpleGene();
	}
}
