package edu.coursera.assignment;

/**
 * This is first class for Strings Assignment-2
 * @author GUR57366
 *
 */
public class Part1 {

	/**
	 * This method finds the first occurrence of stop codon.
	 * @param dna
	 * @param startIndex
	 * @param stopCodon
	 * 
	 * @author GUR57366
	 * @return index of first occurrence of stop codon
	 */
	public int findStopCodon(String dna, int startIndex, String stopCodon) {
		int currIndex = dna.indexOf(stopCodon, startIndex+3);
		while (currIndex != -1) {
			if ((currIndex - startIndex) % 3 == 0) {
				return currIndex;
			} else {
				currIndex = dna.indexOf(stopCodon, currIndex+1);
			}
		}
		return dna.length();
	}
	
	/**
	 * This method finds Gene present in DNA strand
	 * @param dna
	 * @param startFrom
	 * 
	 * @author GUR57366
	 * @return gene
	 */
	public String findGene(String dna, int startFrom) {
		int startIndex = dna.indexOf("ATG", startFrom);
		if (startIndex == -1)
			return "";
		int taaIndex = findStopCodon(dna, startIndex, "TAA");
		int tagIndex = findStopCodon(dna, startIndex, "TAG");
		int tgaIndex = findStopCodon(dna, startIndex, "TGA");
		
		int minIndex = Math.min(taaIndex, Math.min(tagIndex, tgaIndex));
		if (minIndex != -1)
			return dna.substring(startIndex, minIndex+3);
		return "";
	}
	
	/**
	 * This method prints all Genes present in DNA strand
	 * @param dna
	 * 
	 * @author GUR57366
	 */
	public void printAllGenes(String dna) {
		int startIndex = 0;
		while (true) {
			String currentGene = findGene(dna, startIndex);
			if (currentGene.isEmpty())
				break;
			System.out.println("Gene : " + currentGene);
			startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
		}
	}
	
	/**
	 * This method tests findStopCodon() method.
	 * 
	 * @author GUR57366
	 */
	public void testFindStopCodon() {
		String dna = "CCATGCGTTCATAA";
		int startIndex = dna.indexOf("ATG");
		int index = findStopCodon(dna, startIndex, "TAA");
		if (index == dna.length()) {
			System.out.println("Stop Codon not found in dna strand");
		} else
			System.out.println("First occurrence of StopCodon is = " + index);
	}
	
	/**
	 * This method tests findGene() method
	 * 
	 * @author GUR57366
	 */
	public void testFindGene() {
		String[] dna = {"CCGTAAGT", "CCATGGGACTTTAACCGTC", "CCATGGGACTTTAGCCGTAGCCTGA", "CCAGTGGTACCGT"};
		
		for (int idx = 0; idx < dna.length; idx++) {
			System.out.println("DNA Strand is = " + dna[idx]);
			String gene = findGene(dna[idx], 0);
			System.out.println("Gene is = " + gene);
		}
	}
	
	/**
	 * This is main method for Part1 of 2nd Assignment
	 * @param args
	 * 
	 * @author GUR57366
	 */
	public static void main(String[] args) {
		Part1 part1 = new Part1();
		
		// Test testFindStopCodon
		part1.testFindStopCodon();
		
		// Test testFindGene
		part1.testFindGene();
		
		// Test printAllGenes
		String dna = "CCATGTTGCCATAAGCATGACGTAGCCGTAAC";
		part1.printAllGenes(dna);
	}
}
