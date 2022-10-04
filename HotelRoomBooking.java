package Assignments;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;
import java.sql.Statement;
import java.text.ParseException;

import Assignments.HotelProcessMethod.Room;

public class HotelRoomBooking {

	private static boolean MainMenu = true;
	private static boolean SubMenu = true;

	/**
	 * @param args the command line arguments
	 * @throws SQLException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws SQLException, ParseException {
		HotelRoomBooking object = new HotelRoomBooking();
		object.startmethod();
		Connection connect=DriverManager.getConnection("jdbc:mySql://localhost:3306/LalsHotel","root","sarakarp10@123");
		Statement state1=connect.createStatement();
		//String student="saranya";
		
		String query="insert into customer_details (Name,Customer_phone_number) values (\"saranya\",232323)";
		state1.executeUpdate(query);
		//ResultSet result=state1.executeQuery(query);
		//System.out.println("hai");
		//while(result.next()) {
			//System.out.println(result.getString(1)+"\t");
		//}
	}

	void startmethod() throws SQLException, ParseException {
		Connection connect=DriverManager.getConnection("jdbc:mySql://localhost:3306/LalsHotel","root","sarakarp10@123");
		//Statement state1=connect.createStatement();
		//String query="select * from customer_details";
		//ResultSet result=state1.executeQuery(query);
		//while(result.next()) {
			//System.out.println(result.getString(1)+"\t");
		//}
		Scanner input = new Scanner(System.in);
		HotelProcessMethod process = new HotelProcessMethod();

		Room[] myHotel = new Room[20];
		myHotel[0] = process.new Room();
		myHotel[1] = process.new Room();
		myHotel[2] = process.new Room();
		myHotel[3] = process.new Room();
		myHotel[4] = process.new Room();
		myHotel[5] = process.new Room();
		myHotel[6] = process.new Room();
		myHotel[7] = process.new Room();
		myHotel[8] = process.new Room();
		myHotel[9] = process.new Room();
		myHotel[10] = process.new Room();
		myHotel[11] = process.new Room();
		myHotel[12] = process.new Room();
		myHotel[13] = process.new Room();
		myHotel[14] = process.new Room();
		myHotel[15] = process.new Room();
		myHotel[16] = process.new Room();
		myHotel[17] = process.new Room();
		myHotel[18] = process.new Room();
		myHotel[19] = process.new Room();
		
		
		process.initialise(myHotel);
		while (MainMenu) {
			while (SubMenu) {

				System.out.println("Hello and Welcome to our Hotel Lals&sals!\n Enjoy and have a comfort zone!.");

				System.out.println("Please select one of the options.");
				System.out.println("1: Book A New Room.");
				System.out.println("2: Checkin date:");
				//System.out.println("2: Display Empty Rooms.");

				System.out.println("3: View all Rooms.");

				System.out.println("4: Find room from customer name.");
				//System.out.println("4: Find room from room number");

				System.out.println("5: Cancel a Room.");
				System.out.println("6: Vacate a Room.");
				
				//System.out.println("-------------------------------------------------------");
				int roomNum= 0;
				String Selection = input.next();
				Selection = Selection.toUpperCase();
				switch (Selection) {
				case "1":
					process.BookaRoom(myHotel, roomNum);
					break;
				case "2":
					process.DateCheckin();
					break;
				/*	break;
				case "2":
					process.CheckIfEmpty(myHotel);
					break;*/
				case "3":
					process.ViewAllRooms(myHotel);
					break;
				/*case "5":
					process.DeleteCustomerFromRoom(myHotel, roomNum);
					break;*/
				case "4":
				process.FindRoomFromCustomerName(myHotel);
					break;
				//case "4":
					//process.FindRoomNumber();
					//break;
				case "5":
					process.Cancel();
					break;
				case "6":
					process.Vacate();
					break;
				
					
    
				//case "V":
					//process.ViewRoomsAlphabeticallyByName(myHotel);
					//break;
				default:
					System.out.println("Invalid Selection");
					break;
				}

				System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
				System.out.println("Would you like to Select another Option\n press 1 for Yes\n press 2 for No");

				//System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
				if (input.nextInt() == 1) {
					SubMenu = true;
				} else {
					SubMenu = false;
				}
			}
			SubMenu = true;

			//System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			System.out.println("Would You Like To Continue With The Program\n press 1 for yes\n press 2 for No");

			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
			if (input.nextInt() == 1) {
				MainMenu = true;
			} else {
				System.out.println("");
				System.exit(0);
			}
		}

	}

	/*
	 * private static void StoreProgramDataInToFile(Room[] myHotel) throws
	 * IOException { try (PrintWriter out = new PrintWriter(new
	 * FileWriter("/home/unix/student12/w1387769/outputfile.txt"))) { int x; for (x
	 * = 0; x < myHotel.length; x++) { out.println("Name and Room number is: " +
	 * myHotel[x].getName() + "at: " + x); }
	 * 
	 * } System.out.println("All Room Names have been Saved."); }
	 */

}
