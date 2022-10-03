package Assignments;

import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

//import Assignments.HotelRoomBooking.Room;

public class HotelProcessMethod {
	int roomNumber = 0;
	HashMap<String,Double> map=new LinkedHashMap<String,Double>();
	int choice1;
	  void initialise(Room[] myHotel) {
        for (int x = 0; x < myHotel.length; x++) {
            myHotel[x].setName("No-one");
        }
    }

    void CheckIfEmpty(Room[] myHotel) {
        for (int x = 0; x < myHotel.length; x++) {
            if (myHotel[x].getName().equals("Not-Available")) {
                System.out.println("Room " + (x + 1) + " is empty");
            }
        }
    }

     void BookaRoom(Room[] myHotel, int roomNum) throws SQLException {
        String roomName;int roomSelection; int key;
        Scanner input = new Scanner(System.in);
       
        System.out.println("Room Facilities :All Rooms are Air-Conditioned ");
        System.out.println("1.Single-Bed Room -------------- Price:1500");
        System.out.println("2.Double-Bed Room ---------------- Price:3500");
        roomSelection=input.nextInt();
        if(roomSelection==1) {
        	System.out.println("Single Bed Room: only 2 persons allowed! Plus one cot Allowed ");
        }
        else {
        	System.out.println("Double-Bed Room: 4 Persons are allowed ! Plus 2 cots ");
        }
        map.put("Single-Bed Room", (double) 1500);
        map.put("Double-Room", (double) 3500);
        System.out.println("");
        System.out.println("Enter room number (1-20):");
        roomNumber = input.nextInt() - 1;
        
        if(roomNumber>20) {
        	System.out.println("Choose correct number from the list:!");
        	BookaRoom(myHotel,roomNum);
        }
        
        System.out.println("Enter name for room " + (roomNumber + 1) + " :");
        roomName = input.next();
        int phone_number;
        
        System.out.println("Enter your phone number ");
        
        phone_number=input.nextInt();
        int id;
        System.out.println("Your Customer id is: ");
        id=input.nextInt();
        String address;
        System.out.println("Enter your Address ");
        address=input.nextLine();
        address=input.nextLine();
        Connection connect1=DriverManager.getConnection("jdbc:mySql://localhost:3306/LalsHotel","root","sarakarp10@123");
		Statement state1=connect1.createStatement();
		//String query="select * from customer_details";
		String query="insert into customer_details (Name,Customer_phone_number,Address,id) values (\""+ roomName+"\", \""+phone_number+"\",\""+address+"\","+id+")";
		state1.executeUpdate(query);
		
        myHotel[roomNumber].setName(roomName);
        
        System.out.println("Are you sure wants to book a room");
        System.out.println("Press 1 for yes! ");
        choice1=input.nextInt();
        
        if(choice1==1) {
        	System.out.println("Room Booked");
        	
        }
        else {
        	System.out.println("Move to main menu");
        }
        
        //MainMenu();
        
        //System.out.println("Room Booked!");
    }
    

      void ViewAllRooms(Room[] myHotel) {
        for (int x = 0; x < myHotel.length; x++) {
            System.out.println("Room " + (x+1) + " occupied by " + myHotel[x].getName());
        }
    }

    void DeleteCustomerFromRoom(Room[] myHotel, int roomNum) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter room number to delete(1-20):");
        roomNum = input.nextInt() - 1;
        myHotel[roomNum].setName("nobody");
        System.out.println("Entry Deleted :)");
    }
    void FindRoomNumber(){
    	Scanner sc=new Scanner(System.in);
    	int idno;
    	
    	 System.out.println("Enter the room number to Search for:");
    	 idno=sc.nextInt();
    	 if((idno-1)==roomNumber) {
    		 System.out.println("Room number that matches with : "+roomName);
    	 }
    	
    }
    String roomName;

    void FindRoomFromCustomerName(Room[] myHotel) throws SQLException {
        Scanner input = new Scanner(System.in);
        String roomName;
        System.out.println("Enter name to Search for:");
        roomName = input.next();
        int x;
        boolean Checker = false;
        for (x = 0; x < myHotel.length; x++) {
            if (roomName.equals(myHotel[x].getName())) {
                System.out.println("The name that Matches with room number : " + (x=x+1));
                Checker = true;
            }
        }
        if (Checker == false) {
            System.out.println("There are no Rooms Booked with that name\n(make sure you've used the correct CAP's)");
        }
        Connection connect2=DriverManager.getConnection("jdbc:mySql://localhost:3306/LalsHotel","root","sarakarp10@123");
        Statement state1=connect2.createStatement();
        String Query="select booking_status.room_number from booking_status inner join customer_details on customer_details.id=booking_status.customer_id";
        		ResultSet result1=state1.executeQuery(Query);
        
    }
void FindRoomFromRoomNumber(Room[] myHotel) {
	Scanner sc=new Scanner(System.in);
	
}
   /* private static void StoreProgramDataInToFile(Room[] myHotel) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileWriter("/home/unix/student12/w1387769/outputfile.txt"))) {
            int x;
            for (x = 0; x < myHotel.length; x++) {
                out.println("Name and Room number is: " + myHotel[x].getName() + "at: " + x);
            }

        }
        System.out.println("All Room Names have been Saved.");
    }
*/
   

     void ViewRoomsAlphabeticallyByName(Room[] myHotel) {
        String[] myStrArray = new String[myHotel.length];
        for (int i = 0; i < myHotel.length; i++) {
            myStrArray[i] = myHotel[1].getName();
        }

        Arrays.sort(myStrArray);
        for (int a = 0; a < myStrArray.length; a++) {
            System.out.println(myStrArray[a]);
        }

    }
    void Cancel() {
    	int key;
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Do you want to cancel the booked room :Press one");
    	key=sc.nextInt();
    	System.out.println("Room Cancelled Successfully");
    	
    	//System.out.println("Enter the correct number");
    	if(key!=roomNumber) {
    	System.out.println();
    	//Cancel();
    }
    }
    void DateCheckin() throws ParseException {
    	Scanner sc=new Scanner(System.in);
    	java.util.Date in;
    	Date out;
    	System.out.println("Ente the Checkin date (dd-mm-yyyy)");
    	String datein=sc.next();
    	SimpleDateFormat format=new SimpleDateFormat("dd-mm-yyyy");
    	in=format.parse(datein);
    	try {
    		in=format.parse(datein);
    	}
    	catch(ParseException e) {
    		System.out.println("Enter the correct format(dd-mm-yyyy");
    		e.printStackTrace();
    		
    		
    	}
    	System.out.println("Ente the Checkout date (dd-mm-yyyy)");
    	String dateout=sc.next();
    	SimpleDateFormat format1=new SimpleDateFormat("dd-mm-yyyy");
    	in=format.parse(datein);
    	try {
    		in=format1.parse(datein);
    	}
    	catch(ParseException e) {
    		System.out.println("Enter the correct format(dd-mm-yyyy");
    		e.printStackTrace();
    		
    		
    	}
    	
    }
    void Vacate() {
    	int key2;
    	Scanner sc=new Scanner(System.in);
    	System.out.println("Vacate the room: please provide your Room no ");
    	key2=sc.nextInt();
    	//System.out.println("key."+key2);
    	//System.out.println("room"+roomNumber);
    	if((key2-1)== roomNumber ) {
    		System.out.println("The room vacated Successfully");
    		
    	}
    	else {
    		System.out.println("Enter the valid Room no: ");
    	//System.out.println(" ");
    	Vacate();
    	}
    }

    public  class Room {

        //protected String mainName;
        private String mainName;
        int guestsInRoom;

        public Room() {
            mainName = "k";

        }

        public void setName(String aName) {
            //  System.out.println("add name class method ");
            mainName = aName;
        }

        public String getName() {
            return mainName;
        }
    }

	

//	public void initialise(Object myHotel) {
//		// TODO Auto-generated method stub
//		
//	}

}
