/**
 * 
 */
package com.photon.interview;

import java.util.Scanner;

/**
 * @author Velmurugan Moorthy
 *
 */
interface Shape {
    float getArea();
    float getPerimeter();
    String toString();
}

/**
 * @author Velmurugan Moorthy
 *
 */
class Rectangle implements Shape {
    
    private float length; 
    private float width; 
    private static final int NO_OF_SIDES = 2; 
    
    public Rectangle() {
    	
    }
    
    public Rectangle(float pLength, float pWidth) {
      setLength(pLength);
      setWidth(pWidth);
    }

    public float getArea() {
        float area = (float) 0.0;
        System.out.println("Finding area of rectangle with length = " + this.length +" and width = " + this.width );
        area = this.length * this.width;
        return area; 
    }

	@Override
	public float getPerimeter() {
		float perimeter = (float) 0.0;
		System.out.println("Finding perimeter of rectangle with length = " + this.length +" and width = " + this.width );
		perimeter = NO_OF_SIDES * (this.length + this.width);
		return perimeter;
	}

	@Override
	public String toString() {
		StringBuilder rectangleSB = new StringBuilder(); 
		rectangleSB.append("Rectangle = [length:"+ this.length+", width: " + this.width +", area: " + this.getArea() + ", perimeter: " + this.getPerimeter() + "]");		
		return rectangleSB.toString();
	}
	
	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}
 }
   

/**
 * @author Velmurugan Moorthy
 *
 */
 class Circle implements Shape{

	 private static final float PI = (float) 3.14;
	 private float radius;

	 public Circle(float pRadius) {
		 setRadius(pRadius);
	 }
	 
	@Override
	public float getArea() {
		float area = (float) 0.0;
		System.out.println("Finding area of circle with radius = "+this.radius);
		area = PI * this.radius * this.radius;
		return area;
	}

	@Override
	public float getPerimeter() {
		float perimeter = (float) 0.0;
		System.out.println("Finding perimeter of circle with radius = "+this.radius);
		perimeter = 2 * PI * this.radius; 
		return perimeter;
	}
	 
	@Override
	public String toString() {
	   StringBuilder circleStringBuilder = new StringBuilder(); 
	   circleStringBuilder.append("Circle = [radius: " + getRadius() + ", area: " + this.getArea() + ", perimeter: " + this.getPerimeter() + "]");
		return circleStringBuilder.toString();
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}
	
 }
 
  class Square extends Rectangle {

	  private float side; 
	  private static int NO_OF_SIDES = 4; 

	  public Square(float side) {
		  this.setSide(side);
		  super.setLength(side);
		  super.setWidth(side);
	  }

	  @Override
	public float getArea() {
		  float area = (float) 0.0;
		  System.out.println("Finding area of square with side = " + this.getSide());
		area = this.getSide() * this.getSide(); 
		return area;
	}
	  
	  @Override
	public float getPerimeter() {
		float perimeter = (float) 0.0;
		System.out.println("Finding perimeter of square with side = "+this.getSide());
		perimeter = NO_OF_SIDES * this.getSide(); 
		return perimeter;
	}

	  @Override
	public String toString() {
		StringBuilder squareSb = new StringBuilder();
		squareSb.append("Square = [side: "+this.getSide() +", area: " + this.getArea() + ", perimeter: "+this.getPerimeter()+"]");
		return squareSb.toString();
	}

	public float getSide() {
		return side;
	}

	public void setSide(float side) {
		this.side = side;
	}
	  
  }

    public class Solution {   
        private static final Scanner INPUT_READER = new Scanner(System.in);

        public static void main(String[] args) {
            String[] lengthWidth = INPUT_READER.nextLine().split(" ");
            float length = Float.parseFloat(lengthWidth[0]);     
            float width = Float.parseFloat(lengthWidth[1]);

            float side = Float.parseFloat(INPUT_READER.nextLine());
            float radius = Float.parseFloat(INPUT_READER.nextLine());
            
            Shape rectangle = new Rectangle(length, width);
            Rectangle square = new Square(side);
            Shape circle = new Circle(radius);
            
            System.out.println("====================================");
            System.out.println("Finding area and perimeter of shapes");
            System.out.println("====================================");
            
            System.out.println("Area = " + rectangle.getArea() + " and Perimeter = " + rectangle.getPerimeter() + "\n");
            System.out.println("Area = " + square.getArea() + " and Perimeter = " + square.getPerimeter() + "\n");
            System.out.println("Area = " + circle.getArea() + " and Perimeter = " + circle.getPerimeter() + "\n");
           
            System.out.println("=========================");
            System.out.println("Printing shapes as string");
            System.out.println("=========================");
            System.out.println(rectangle.toString());
            System.out.println(square.toString());
            System.out.println(circle.toString());
        }
    }