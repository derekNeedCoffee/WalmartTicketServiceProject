package ticketServiceImp;

import java.util.Calendar;
import java.util.Date;

import javax.mail.internet.NewsAddress;

import ticketServiceData.Seat;

public class CheckExpireTime implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while (true) {
				checkExpiredSeats();
				Thread.sleep(1000); // sleep 1 second before next check
			}
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	/**
	 * Change the temporary hold status
	 */
	private void checkExpiredSeats() {
		// TODO Auto-generated method stub
		if (InitializeStadium.newStadium == null) {
			return;
		} else {
			for (int i = 0; i < InitializeStadium.newStadium.size(); i++) {

				Seat[][] levelSeats = InitializeStadium.newStadium.get(i);

				for (int row = 0; row < levelSeats.length; row++) {
					int rowSeatsNum = levelSeats[0].length;
					for (int seatNum = 0; seatNum < rowSeatsNum; seatNum++) {
						Seat currentSeat = levelSeats[row][seatNum];
						Date now = Calendar.getInstance().getTime();

						if (currentSeat.getHoldDate() != null) {
							long timeNow = now.getTime();
							long timeHold = currentSeat.getHoldDate().getTime();
							int timeDiff = (int) ((timeNow - timeHold) / 1000);
							if (timeDiff > 30) // set the hold time to 30
												// seconds
								currentSeat.setTempHold(false);
							currentSeat.setHoldDate(null);

						}
					}

				}
			}
		}

	}

}
