package edu.coursera.assignment;

/**
 * This is second class for Strings Assignment-2
 * @author Vineet
 * 
 */
public class Part2 {

	/**
	 * This finds no of occurrences of one string into another string
	 * @param stringa
	 * @param stringb
	 * @return count
	 * 
	 * @author Vineet
	 */
	public int howMany(String stringa, String stringb) {
		int index = 0, count = 0;
		while (true) {
			index = stringb.indexOf(stringa, index);
			if (index == -1) {
				break;
			}
			count ++;
			index = index + stringa.length();
		}
		return count;
	}
	
	/**
	 * This method tests howMany() method
	 * 
	 * @author Vineet
	 */
	public void testHowMany() {
		String []stringa = {"GAA", "AA", "ATT"};
		String []stringb = {"ATGAACGAATTGAATC", "ATAAAA", "GTTACCGT"};
		
		for (int idx = 0; idx < stringb.length; idx++) {
			int noOfOccurrences = howMany(stringa[idx], stringb[idx]);
			System.out.printf("No of times %s appears in %s is = %d \n", stringa[idx], stringb[idx], noOfOccurrences);
		}
	}
	
	/**
	 * This is main method of Part-2 class
	 * @param args
	 * 
	 * @author Vineet
	 */
	public static void main(String[] args) {
		Part2 part2 = new Part2();
		part2.testHowMany();
	}
}
