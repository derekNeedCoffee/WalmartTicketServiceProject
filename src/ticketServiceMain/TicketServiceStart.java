package ticketServiceMain;


import java.util.Scanner;
import ticketServiceData.Seat;
import ticketServiceImp.TicketServiceImp;
import ticketServiceInter.SeatHold;


public class TicketServiceStart {
	static Scanner newScanner = new Scanner(System.in);
	static UtilityService utilityService = new UtilityService();
	static TicketServiceImp tService = new TicketServiceImp();
	public static void main(String[] args){
		//create a utilityService object
			System.out.println("What do you want to do next ?"+ "\n"+
		                        "Enter 1 look up available seats."+"\n"+
								"Enter 2 temparay hold seats."+"\n"+
		                        "Enter 3 reserve seats");
			//check if input are valid number
			
				while(!newScanner.hasNextInt()){
					System.out.println("Please enter an Integer between 1 and 3");
					newScanner.next();
				}
				
			int choice  =newScanner.nextInt();
			switch(choice){
			case 1:
				getAvailableNums();
				break;
			case 2:
				holdSeats();
				break;
			case 3:
				reservedSeats();
				break;
			default:
				System.out.println("Please enter a valid integer 1, 2 or 3");
				main(null);
				break;
				

			}
			
	}
	
	
	
	private synchronized static void  getAvailableNums(){
		Scanner newScanner = new Scanner(System.in);
		System.out.println("Please enter venue level throught 0 to 3:" + "\n"+
							" 0 is Orchestra level." +"\n"+
							" 1 is Main level." +"\n"+
							" 2 is Balcony One level."+ "\n"+
							" 3 is Balcony Two level."+"\n");
		
		//check if input are valid number
		
		while(!newScanner.hasNextInt()){
			System.out.println("Please enter an Integer between 0 and 3");
			newScanner.next();
		}
		Integer venueLevel = newScanner.nextInt();
		if(venueLevel<0 || venueLevel>3){
			System.out.println("Please enter an integer between 0 and 3");
		}
		
		if(tService == null)
		tService = new TicketServiceImp();
		
		System.out.println("Available seats number "+tService.numSeatsAvailable(venueLevel));
		main(null);
	}
	
	private synchronized static void holdSeats(){
		
		System.out.println("Please enter your email");
		String email = newScanner.next();
		//validate user's input email address
		if(!utilityService.isEmailValid(email)){
			System.out.println("Please enter a valid email");
			
			email = newScanner.next();
		}
		System.out.println("Enter how many seats you want:");
		//check if input are valid number
		
		while(!newScanner.hasNextInt()){
			System.out.println("Please enter a valid number");
			newScanner.next();
		}
		int seatsNum = newScanner.nextInt();
		System.out.println("Enter the min level for your seats");
		while(!newScanner.hasNextInt()){
			System.out.println("Please enter a valid number");
			newScanner.next();
		}
		int minLevel  = newScanner.nextInt();
		System.out.println("Enter the max level for your seats");
		while(!newScanner.hasNextInt()){
			System.out.println("Please enter a valid number");
			newScanner.next();
		}
		int maxLevel = newScanner.nextInt();
		
		SeatHold sh = tService.findAndHoldSeats(seatsNum, minLevel, maxLevel, email);
		if(sh.getSeats().size()==seatsNum){
			System.out.println("Tickets are hold successfully!");
			System.out.println("Your seat hold id is: "+ sh.getSeatHoldId());
		for(int t =0; t<sh.getSeats().size();t++){
			Seat s = sh.getSeats().get(t);
			System.out.println( " Seat Level is "+ s.getLevelName() + "  row is " +s.getRow() +" seat number " +s.getSeatNum());
		
		}
		
		
		}else if(sh.getSeats().size() < seatsNum){    // Not enough seats, set all hold to false, data to null
			System.out.println("There are not enough seats");
			clean(sh);
		}
		
		main(null);
	}

	/**
	 * Reserve seats
	 */
	private synchronized static void reservedSeats() {
		System.out.println("Please enter your seat hold Id");
		while(!newScanner.hasNextInt()){
			System.out.print("Please enter a valid seat hold. It's a number");
			newScanner.next();
		}
		  int seatHoldId = newScanner.nextInt();
		   System.out.println("Please enter your email");
		   String yEmail = newScanner.next();
		   while(!utilityService.isEmailValid(yEmail)){
			   System.out.println("Please enter a valid email ");
			   newScanner.next();
		   }
		 
			
			//Reserve  seats based on the seatHoldId 
			String confirmationCode = tService.reserveSeats(seatHoldId, yEmail);
			System.out.println("Seats are reserved. Your confirmation code is "+ confirmationCode);
			main(null);
		
		
		
	}


	
	/**
	 * Clean up the hold seat for current seatHold object
	 * @param sh  current seat hold object
	 */
	private static void clean(SeatHold sh) {
		for(int i=0; i<sh.getSeats().size();i++){
			Seat s = sh.getSeats().get(i);
			s.setHoldDate(null);
			s.setTempHold(false);
		}		
	}
}
