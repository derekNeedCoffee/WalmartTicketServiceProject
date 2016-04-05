package WalmartTicketProjectTest;

import java.util.ArrayList;

import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ticketServiceData.Seat;
import ticketServiceImp.InitializeStadium;

public class InitializeStadiumTest {

	InitializeStadium is;
	int numberOfLevels;
	int rowOnOrchestra;
	int seatNumOrchestra;
	int rowOnMain;
	int seatNumMain;
	int rowOnBalconyOne;
	int seatNumBalconyOne;
	int rowOnBalconyTwo;
	int seatNumBalconyTwo;
	double priceOrchestra;
	double priceMain;
	double priceBalconyOne;
	double priceBalconyTwo;

	@BeforeTest
	public void setup() {
		is = new InitializeStadium();
		is.initializedSeats();
		numberOfLevels = InitializeStadium.numberOfLevels;
		rowOnOrchestra = InitializeStadium.rowOnOrchestra;
		seatNumOrchestra = InitializeStadium.seatNumOrchestra;
		rowOnMain = InitializeStadium.rowOnMain;
		seatNumMain = InitializeStadium.seatNumMain;
		rowOnBalconyOne = InitializeStadium.rowOnBalconyOne;
		seatNumBalconyOne = InitializeStadium.seatNumBalconyOne;
		rowOnBalconyTwo = InitializeStadium.rowOnBalconyTwo;
		seatNumBalconyTwo = InitializeStadium.seatNumBalconyTwo;
		priceOrchestra = InitializeStadium.priceOrchestra;
		priceMain = InitializeStadium.priceMain;
		priceBalconyOne = InitializeStadium.priceBalconyOne;
		priceBalconyTwo = InitializeStadium.priceBalconyTwo;

	}

	@Test
	public void testInitializedSeats() {
		ArrayList<Seat[][]> seats = is.initializedSeats();
		int levelofStadium = 4;
		// test not null
		Assert.assertNotNull(is.initializedSeats());
		// test the stadium has 4 levels
		Assert.assertEquals(levelofStadium, seats.size());

	}

	@Test
	public void testSeats() {
		ArrayList<Seat[][]> seats = is.initializedSeats();
		for (int i = 0; i < seats.size(); i++) {
			Seat[][] level = seats.get(i);

			if (i == 0) {
				Assert.assertEquals(level.length, rowOnOrchestra);// test for
																	// Orchestra
																	// level
				for (int j = 0; j < level.length; j++) {
					int seatNum = level[0].length; // seat numbers for this
													// level
					for (int k = 0; k < seatNum; k++) {
						Seat currentS = level[j][k];
						Assert.assertEquals(currentS.getLevelName(), "Orchestra");
						Assert.assertEquals(currentS.getPrice(), Double.valueOf(priceOrchestra));

					}
					Assert.assertEquals(seatNum, seatNumOrchestra);
				}

			}

			if (i == 1) {
				Assert.assertEquals(level.length, rowOnMain);// test for
																// Orchestra
																// level
				for (int j = 0; j < level.length; j++) {
					int seatNum = level[0].length; // seat numbers for this
													// level
					for (int k = 0; k < seatNum; k++) {
						Seat currentS = level[j][k];
						Assert.assertEquals(currentS.getLevelName(), "Main");
						Assert.assertEquals(currentS.getPrice(), Double.valueOf(priceMain));

					}
					Assert.assertEquals(seatNum, seatNumMain);
				}

			}

			if (i == 2) {
				Assert.assertEquals(level.length, rowOnBalconyOne);// test for
																	// Orchestra
																	// level
				for (int j = 0; j < level.length; j++) {
					int seatNum = level[0].length; // seat numbers for this
													// level
					for (int k = 0; k < seatNum; k++) {
						Seat currentS = level[j][k];
						Assert.assertEquals(currentS.getLevelName(), "BalconyOne");
						Assert.assertEquals(currentS.getPrice(), Double.valueOf(priceBalconyOne));

					}
					Assert.assertEquals(seatNum, seatNumBalconyOne);
				}

			}

			if (i == 3) {
				Assert.assertEquals(level.length, rowOnBalconyTwo);// test for
																	// Orchestra
																	// level
				for (int j = 0; j < level.length; j++) {
					int seatNum = level[0].length; // seat numbers for this
													// level
					for (int k = 0; k < seatNum; k++) {
						Seat currentS = level[j][k];
						Assert.assertEquals(currentS.getLevelName(), "BalconyTwo");
						Assert.assertEquals(currentS.getPrice(), Double.valueOf(priceBalconyTwo));

					}
					Assert.assertEquals(seatNum, seatNumBalconyTwo);
				}

			}
		}
	}

}
