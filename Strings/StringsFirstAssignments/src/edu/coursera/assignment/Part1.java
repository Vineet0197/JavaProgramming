package edu.coursera.assignment;

public class Part1 {

	public String findSimpleGene(String dna) {
		// Search for starting index for substring "ATG"
		int startIndex = dna.indexOf("ATG");
		if (startIndex == -1)
				return "";
		
		// Search for index position of the first stop codon “TAA” appearing after the “ATG”
		int endIndex = dna.indexOf("TAA", startIndex+3);
		if (endIndex == -1)
			return "";
		
		// Check if difference of startIndex and endIndex is multiple of 3
		if ((endIndex - startIndex) % 3 != 0)
			return "";
		
		return dna.substring(startIndex, endIndex+3);
	}
	
	public void testSimpleGene() {
		String dna[] = {"CGATCCATAA", "CGATGCTATC", "CGATAGTTGA", "CGATGCAAGTTTAA", "CGATGCAGTGTAA"};
		
		for (int idx = 0; idx < dna.length; idx++) {
			String gene = findSimpleGene(dna[idx]);
			System.out.println("Gene is = " + gene);
		}
	}
	
	public static void main(String []args) {
		Part1 part1 = new Part1();
		part1.testSimpleGene();
	}
}
