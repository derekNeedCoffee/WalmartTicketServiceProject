package WalmartTicketProjectTest;


import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ticketServiceData.Seat;
import ticketServiceImp.InitializeStadium;
import ticketServiceImp.TicketServiceImp;
import ticketServiceInter.SeatHold;

public class ticketServiceImpTest {
	int numberOfLevels = InitializeStadium.numberOfLevels;
	int rowOnOrchestra = InitializeStadium.rowOnOrchestra;
	int seatNumOrchestra = InitializeStadium.seatNumOrchestra;
	int rowOnMain = InitializeStadium.rowOnMain;
	int seatNumMain = InitializeStadium.seatNumMain;
	int rowOnBalconyOne =InitializeStadium.rowOnBalconyOne;
	int seatNumBalconyOne = InitializeStadium.seatNumBalconyOne;
	int rowOnBalconyTwo =InitializeStadium.rowOnBalconyTwo;
	int seatNumBalconyTwo = InitializeStadium.seatNumBalconyTwo;
	double priceOrchestra = InitializeStadium.priceOrchestra;
	double priceMain = InitializeStadium.priceMain;
	double priceBalconyOne = InitializeStadium.priceBalconyOne;
	double priceBalconyTwo = InitializeStadium.priceBalconyTwo;
	
	InitializeStadium newStad;
	TicketServiceImp ticketServiceI;
	String   testEmail ;
	@BeforeTest
	public void setup(){
		 newStad = new InitializeStadium();
		 ticketServiceI = new TicketServiceImp();
		 testEmail = "g@walmart.com";
		
	}
	
	
	@Test(priority=1)
	public void testAvailabltNumberSeats(){
			  
			 int initialAvailableSeatsOrchestra = rowOnOrchestra*seatNumOrchestra;
			 int initialAvailableSeatsMain      = rowOnMain*seatNumMain;
			 int initialAvailableSeatsBalconyOne = rowOnBalconyOne*seatNumBalconyOne;
			 int initialAvailableSeatsBalconyTwo = rowOnBalconyTwo*seatNumBalconyTwo;
	
			 	Assert.assertEquals(initialAvailableSeatsOrchestra,ticketServiceI.numSeatsAvailable(0));
			 	Assert.assertEquals(initialAvailableSeatsMain, ticketServiceI.numSeatsAvailable(1));
			 	Assert.assertEquals(initialAvailableSeatsBalconyOne, ticketServiceI.numSeatsAvailable(2));
			 	Assert.assertEquals(initialAvailableSeatsBalconyTwo, ticketServiceI.numSeatsAvailable(3));

	
	}
	
	
	
	@Test(priority=2)
	public void testHoldSeats(){
		ticketServiceInter.SeatHold sh = null;
		 int initalAvailableSeats = rowOnOrchestra*seatNumOrchestra+
				 					rowOnMain*seatNumMain+
				 					rowOnBalconyOne*seatNumBalconyOne+
				 					rowOnBalconyTwo*seatNumBalconyTwo;
		 int randomHoldNum = (int) (Math.random()*initalAvailableSeats);
		 
		 
		sh  = ticketServiceI.findAndHoldSeats(randomHoldNum, 0, 3 ,testEmail);
		Assert.assertEquals(randomHoldNum, sh.getSeats().size());
		 for(int i=0; i<sh.getSeats().size();i++){
			 Seat s = sh.getSeats().get(i);
			 Assert.assertEquals(true, s.isTempHold());
		 }
		 	
	}
	
	
	@Test(priority=3)
	public void testReservedSeats(){
		 int initalAvailableSeats = rowOnOrchestra*seatNumOrchestra+
					rowOnMain*seatNumMain+
					rowOnBalconyOne*seatNumBalconyOne+
					rowOnBalconyTwo*seatNumBalconyTwo;
       int randomHoldNum = (int) (Math.random()*initalAvailableSeats);


    SeatHold  sh  = ticketServiceI.findAndHoldSeats(randomHoldNum, 0, 3 ,testEmail);
		ticketServiceI.reserveSeats(sh.getSeatHoldId(), sh.getCustomerEmail());
		for(int i=0;i<sh.getSeats().size();i++){
			Seat s = sh.getSeats().get(i);
			Assert.assertEquals(true, s.isFinalReserved()); 
		}
	
	}
 
	
}
