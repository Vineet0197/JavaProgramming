package edu.coursera.assignment;

/**
 * This is Part-3 of Strings Assignment
 * @author Vineet
 *
 */
public class Part3 {

	Part1 part1 = new Part1();
	/**
	 * This method finds Gene present in DNA strand
	 * @param dna
	 * @param startFrom
	 * 
	 * @author Vineet
	 * @return gene
	 */
	public String findGene(String dna, int startFrom) {
		int startIndex = dna.indexOf("ATG", startFrom);
		if (startIndex == -1)
			return "";
		int taaIndex = part1.findStopCodon(dna, startIndex, "TAA");
		int tagIndex = part1.findStopCodon(dna, startIndex, "TAG");
		int tgaIndex = part1.findStopCodon(dna, startIndex, "TGA");
		
		int minIndex = Math.min(taaIndex, Math.min(tagIndex, tgaIndex));
		if (minIndex != -1)
			return dna.substring(startIndex, minIndex+3);
		return "";
	}
	
	/**
	 * This method prints all Genes present in DNA strand
	 * @param dna
	 * 
	 * @author Vineet
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
	 * This method calculates no of Genes present in DNA strand
	 * @param dna
	 * @return count of Genes in one DNA strand
	 * 
	 * @author Vineet
	 */
	public int countGenes(String dna) {
		int startIndex = 0, count = 0;
		while (true) {
			String currentGene = findGene(dna, startIndex);
			if (currentGene.isEmpty())
				break;
			count++;
			startIndex = dna.indexOf(currentGene, startIndex) + currentGene.length();
		}
		return count;
	}
	
	/**
	 * This method tests countGenes() method
	 * 
	 * @author Vineet
	 */
	public void testCountGenes() {
		String []dna = {"ATGTAAGATGCCCTAGT", "ATGAACTGAATCATGTAGCCATGCGGTAA"};
		
		for (int idx = 0; idx < dna.length; idx++) {
			int count = countGenes(dna[idx]);
			System.out.println("Count of Genes is = " + count);
		}
	}
	
	/**
	 * This is main method for Part-3
	 * 
	 * @param args
	 * @author Vineet
	 */
	public static void main(String[] args) {
		Part3 part3 = new Part3();
		part3.testCountGenes();
	}
}
