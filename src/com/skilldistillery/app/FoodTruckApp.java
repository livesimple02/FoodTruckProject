package com.skilldistillery.app;

import java.util.Scanner;

public class FoodTruckApp {

	private Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {

		boolean keepGoing = true;
		FoodTruckApp app = new FoodTruckApp();
		
		app.printWelcomeMessage();
		FoodTruck[] trucks = app.getTruckEntriesFromUser();
		
		while (keepGoing) {
			app.printMenu();
			String userResponse = app.getAndCheckUserResponse();
			 if (userResponse.equals("1")) {
				 app.printAllTruckData(trucks);
			 }
			 else if (userResponse.equals("2")) {
				 app.printAverageRatings(trucks);
			 }
			 else if (userResponse.equals("3")) {
				 app.printHighestRated(trucks);
			 }
			 else {
				 System.out.println("Goodbye");
				 keepGoing = false;
			 }
		}
		
	}

	
	private void printWelcomeMessage() {
		System.out.println("         Welcome to the Food Truck Rating App");
		System.out.println("--------------------------------------------------------");
		System.out.println(" You will be allowed to track up to 5 trucks at a time.");
		System.out.println("  Enter the information for each truck when requested.");
		System.out.println();
		System.out.println("  If you have less than 5 trucks to enter, type \"Quit\"");
		System.out.println("    when prompted for a truck name to view the menu.");
		System.out.println();
	}
	
	private FoodTruck[] getTruckEntriesFromUser() {
		String[] truckNames = new String[5];
		String[] foodTypes = new String[5];
		int[] ratings = new int[5];
		int numOfTrucks = 0;
		
		for (int truckNum = 1;numOfTrucks < 5; numOfTrucks++, truckNum++) {
			truckNames[numOfTrucks] = getTruckNameFromUser(truckNum);
			if (truckNames[numOfTrucks].equalsIgnoreCase("quit")) {
				truckNames[numOfTrucks] = null;
				break;
			}
		    foodTypes[numOfTrucks] = getFoodTypeFromUser();
			ratings[numOfTrucks] = getRatingFromUser();
			input.nextLine();
		}
		
		FoodTruck[] trucks = new FoodTruck[numOfTrucks];
		
		for (int i = 0; i < trucks.length; i++) {
			trucks[i] = new FoodTruck(truckNames[i], foodTypes[i], ratings[i]);		
		}
		
		return trucks;
	}
	
	
	private void printMenu() {
		System.out.println();
		System.out.println("         Choose one of the following         ");
		System.out.println("---------------------------------------------");
		System.out.println("| 1: List all existing food trucks.         |");
		System.out.println("| 2: See the average rating of food trucks  |");
		System.out.println("| 3: Display the highest rated food truck   |");
		System.out.println("| 4: Quit the program.                      |");
		System.out.println("---------------------------------------------");
	}
	
	private String getAndCheckUserResponse() {
		boolean validResponse = false;
		String userResponse = "";
		while (validResponse == false) {
			userResponse = input.nextLine();
			if (userResponse.equalsIgnoreCase("1")) {
				validResponse = true;
			}
			else if (userResponse.equalsIgnoreCase("2") ) {
				validResponse = true;
			}
			else if (userResponse.equalsIgnoreCase("3")) {
				validResponse = true;
			}
			else if (userResponse.equalsIgnoreCase("4")) {
				validResponse = true;
			}
			else {
				System.err.println("Invalid Entry. Please try again.");
			}
		}
		return userResponse;
	}
	
	
	private void printAllTruckData(FoodTruck[] trucks) {
		System.out.println();
		for (int i = 0 ; i < trucks.length; i++) {
			System.out.println(trucks[i].toString());
		}
	}
	
	private void printAverageRatings(FoodTruck[] trucks) {
		int ratingsTotal = 0;
		System.out.println();
		for (int i = 0; i < trucks.length; i++) {
			ratingsTotal += trucks[i].getRating();
		}
		float average = (float)ratingsTotal / (float)trucks.length;
		System.out.printf("For all food trucks, the average rating is: %.2f", average);
		System.out.println();
	}
	
	
	private void printHighestRated(FoodTruck[] trucks) {
		int highestRatingValue = 0;
		int highestRatingIndex = 0;
		for (int i = 0; i < trucks.length; i++) {
			if (trucks[i].getRating() > highestRatingValue) {
				highestRatingValue = trucks[i].getRating();
				highestRatingIndex = i;
			}
		}
		System.out.println();
		System.out.println("The highest rated food truck is: " + trucks[highestRatingIndex].toString());
	}
	
	
	
	private String getTruckNameFromUser(int num) {
		System.out.println();
		System.out.print("Enter the food truck name for truck # " + num + ": ");
		return input.nextLine();
	}
	
	private String getFoodTypeFromUser() {
		System.out.print("Enter the type of food the truck serves: ");
		return input.nextLine();
	}
	
	private int getRatingFromUser() {
		System.out.print("Enter the rating of the truck from 1-5: ");
		return input.nextInt();
	}
	
	
	
	
	
	
	
	
}
