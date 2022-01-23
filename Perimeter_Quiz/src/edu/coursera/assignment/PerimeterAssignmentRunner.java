package edu.coursera.assignment;

import java.io.File;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import edu.duke.Point;
import edu.duke.Shape;

public class PerimeterAssignmentRunner {

	public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        // Put code here
    	int pointCount = 0;
    	for (Point points : s.getPoints()) {
    		pointCount += 1;
    	}
        return pointCount;
    }

    public double getAverageLength(Shape s) {
        // Put code here
    	// Variable to get sum of all sides length
    	double sumOfSides = getPerimeter(s);
    	
    	// Variable to get No of points in shape
    	double noOfPoints = (double) getNumPoints(s);
    	
    	// Calculate average length of all sides
    	double avgLength = sumOfSides / noOfPoints;
        return avgLength;
    }

    public double getLargestSide(Shape s) {
        // Put code here
    	Point prevPt = s.getLastPoint();
    	double prevDist = prevPt.distance(prevPt);
    	for (Point currPt : s.getPoints()) {
    		double nextDist = prevPt.distance(currPt);
    		if (nextDist > prevDist)
    			prevDist = nextDist;
    		prevPt = currPt;
    	}
        return prevDist;
    }

    public double getLargestX(Shape s) {
        // Put code here
    	Point prevPt = s.getLastPoint();
    	double largestX = prevPt.getX();
    	for (Point currPt : s.getPoints()) {
    		double x = currPt.getX();
    		if (x > largestX)
    			largestX = x;
    	}
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        // Put code here
    	double finalPerim = 0.0;
    	DirectoryResource directoryResource = new DirectoryResource();
    	for (File file : directoryResource.selectedFiles()) {
    		FileResource fileResource = new FileResource(file);
    		Shape shape = new Shape(fileResource);
    		
    		double perimeter = getPerimeter(shape);
    		if (perimeter > finalPerim) {
    			finalPerim = perimeter;
    		}
    	}
        return finalPerim;
    }

    public String getFileWithLargestPerimeter() {
        // Put code here
        File file = null;
        double finalPerimeter = 0.0;
        DirectoryResource directoryResource = new DirectoryResource();
        for (File f : directoryResource.selectedFiles()) {
        	FileResource fileResource = new FileResource(f);
        	Shape shape = new Shape(fileResource);
        	
        	double perimeter = getPerimeter(shape);
        	if (perimeter > finalPerimeter) {
        		finalPerimeter = perimeter;
        		file = f;
        	}
        }
        return file.getName();
    }

    public void testPerimeter () {
        FileResource fr = new FileResource("src/datatest4.txt");
        Shape s = new Shape(fr);
        // Get Perimeter of a shape
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        
        // Get No of points in a shape
        int noOfPoints = getNumPoints(s);
        System.out.println("No of points = " + noOfPoints);
        
        // Get Average length of all sides
        double avgLength = getAverageLength(s);
        System.out.println("The Average length of a side in your shape is = " + avgLength);
        
        // Get Largest Side of a shape
        double largestSide = getLargestSide(s);
        System.out.println("The Longest side length of a shape is = " + largestSide);
        
        // Get Largest X component of a point on shape
        double largestX = getLargestX(s);
        System.out.println("The LargestX of a point of shape is = " + largestX);
    }
    
    public void testPerimeterMultipleFiles() {
        // Put code here
    	double largestPerim = getLargestPerimeterMultipleFiles();
    	System.out.println("Largest Perimeter in Choosen Files is = " + largestPerim);
    }

    public void testFileWithLargestPerimeter() {
        // Put code here
    	String fileName = getFileWithLargestPerimeter();
    	System.out.println("File with Largest Perimeter is = " + fileName);
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
        
        // Test to get Largest Perimeter among Multiple files
        pr.testPerimeterMultipleFiles();
        
        // Test to get file name with largest perimeter
        pr.testFileWithLargestPerimeter();
    }
}
