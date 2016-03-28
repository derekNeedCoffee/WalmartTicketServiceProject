package WalmartTicketProjectTest;


import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ticketServiceData.Seat;
import ticketServiceImp.InitializeStadium;
import ticketServiceImp.TicketServiceImp;
import ticketServiceInter.SeatHold;

public class ticketServiceImpTest {
	int numberOfLevels ;
	int rowOnOrchestra ;
	int seatNumOrchestra ;
	int rowOnMain ;
	int seatNumMain ;
	int rowOnBalconyOne;
	int seatNumBalconyOne;
	int rowOnBalconyTwo ;
	int seatNumBalconyTwo;
	double priceOrchestra ;
	double priceMain ;
	double priceBalconyOne ;
	double priceBalconyTwo;
	
	InitializeStadium newStad;
	TicketServiceImp ticketServiceI;
	String   testEmail ;
	@BeforeTest
	public void setup(){
		 newStad = new InitializeStadium();
		 ticketServiceI = new TicketServiceImp();
		 testEmail = "g@walmart.com";
		 newStad.initializedSeats();
			 numberOfLevels = InitializeStadium.numberOfLevels;
			rowOnOrchestra = InitializeStadium.rowOnOrchestra;
			seatNumOrchestra = InitializeStadium.seatNumOrchestra;
			rowOnMain = InitializeStadium.rowOnMain;
			seatNumMain = InitializeStadium.seatNumMain;
			 rowOnBalconyOne =InitializeStadium.rowOnBalconyOne;
			 seatNumBalconyOne = InitializeStadium.seatNumBalconyOne;
			 rowOnBalconyTwo =InitializeStadium.rowOnBalconyTwo;
			 seatNumBalconyTwo = InitializeStadium.seatNumBalconyTwo;
			 priceOrchestra = InitializeStadium.priceOrchestra;
			 priceMain = InitializeStadium.priceMain;
			 priceBalconyOne = InitializeStadium.priceBalconyOne;
			 priceBalconyTwo = InitializeStadium.priceBalconyTwo;
		
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
