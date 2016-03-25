package WalmartTicketProjectTest;

import java.util.ArrayList;

import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ticketServiceData.Seat;
import ticketServiceImp.InitializeStadium;

public class InitializeStadiumTest {
	
	InitializeStadium is ;
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
	
	
	@BeforeTest
	public void setup(){
		is = new InitializeStadium();

	}

	@Test
	public void testInitializedSeats(){
		ArrayList<Seat[][]> seats = is.initializedSeats();
		int levelofStadium = 4;
		//test not null
		Assert.assertNotNull(is.initializedSeats());
		//test the stadium has 4 levels
		Assert.assertEquals(levelofStadium,seats.size());
		
	}
	
	
	
	@Test
	public void testSeats(){
		 ArrayList<Seat[][]>  seats = is.initializedSeats();
		 for(int i=0; i<seats.size();i++){
			 Seat[][] level = seats.get(i);
			 
			 if(i==0){  
				 Assert.assertEquals(level.length,rowOnOrchestra);//test for Orchestra level
			 for(int j=0; j<level.length;j++){
				  int seatNum = level[0].length;  //seat numbers for this level
				  for(int k =0; k<seatNum;k++){
					  Seat currentS = level[j][k];
					  Assert.assertEquals(currentS.getLevelName(), "Orchestra");
					  Assert.assertEquals(currentS.getPrice(), Double.valueOf(priceOrchestra));

				  }
				  Assert.assertEquals(seatNum,seatNumOrchestra);
			 }
			 
			 }
			 
			 if(i==1){  
				 Assert.assertEquals(level.length,rowOnMain);//test for Orchestra level
			 for(int j=0; j<level.length;j++){
				  int seatNum = level[0].length;  //seat numbers for this level
				  for(int k =0; k<seatNum;k++){
					  Seat currentS = level[j][k];
					  Assert.assertEquals(currentS.getLevelName(), "Main");
					  Assert.assertEquals(currentS.getPrice(), Double.valueOf(priceMain));

				  }
				  Assert.assertEquals(seatNum,seatNumMain);
			 }
			 
			 }
			 
			 
			 if(i==2){  
				 Assert.assertEquals(level.length,rowOnBalconyOne);//test for Orchestra level
			 for(int j=0; j<level.length;j++){
				  int seatNum = level[0].length;  //seat numbers for this level
				  for(int k =0; k<seatNum;k++){
					  Seat currentS = level[j][k];
					  Assert.assertEquals(currentS.getLevelName(), "BalconyOne");
					  Assert.assertEquals(currentS.getPrice(), Double.valueOf(priceBalconyOne));

				  }
				  Assert.assertEquals(seatNum,seatNumBalconyOne);
			 }
			 
			 }
			 
			 
			 if(i==3){  
				 Assert.assertEquals(level.length,rowOnBalconyTwo);//test for Orchestra level
			 for(int j=0; j<level.length;j++){
				  int seatNum = level[0].length;  //seat numbers for this level
				  for(int k =0; k<seatNum;k++){
					  Seat currentS = level[j][k];
					  Assert.assertEquals(currentS.getLevelName(), "BalconyTwo");
					  Assert.assertEquals(currentS.getPrice(), Double.valueOf(priceBalconyTwo));

				  }
				  Assert.assertEquals(seatNum,seatNumBalconyTwo);
			 }
			 
			 }
		 }
	}
	
	
}
