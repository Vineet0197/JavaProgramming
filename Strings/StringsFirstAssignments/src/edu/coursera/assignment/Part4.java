package edu.coursera.assignment;

import edu.duke.URLResource;

public class Part4 {

	public String findWebLink() {
		String result = "";
		String search = "youtube.com";
		URLResource urlResource = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
		
		for (String word : urlResource.words()) {
			String wordLower = word.toLowerCase();
			int index = wordLower.indexOf(search);
			if (index != -1) {
				int quotesStartIdx = word.lastIndexOf("\"", index);
				int quoteLastIdx = word.indexOf("\"", index+1);
				result = word.substring(quotesStartIdx+1, quoteLastIdx);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Part4 part4 = new Part4();
		String result = part4.findWebLink();
		System.out.println("URL Resource is = " + result);
	}
}
