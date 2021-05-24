package com.skilldistillery.app;

public class FoodTruck {

	private static int nextId = 101;
	private int id;
	private String name;
	private String foodType;
	private int rating;
	
	
	// FoodTruck Constructor
	public FoodTruck (String name, String foodType, int rating) {
		this.name = name;
		this.foodType = foodType;
		this.rating = rating;
		this.id = nextId;
		nextId++ ;
	}
	
	// Replacement of toString method
	public String toString () {
		String result = "Truck ID: " + getId();
		result += " | Name: " + getName();
		result += " | Food Type: " + getType();
		result += " | Rating: " + getRating();
		return result;
	}
	
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return foodType;
	}
	
	public int getRating() {
		return rating;
	}
	
	
} // end of class
