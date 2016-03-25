package ticketServiceImp;



import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

import ticketServiceData.Seat;
import ticketServiceInter.SeatHold;
import ticketServiceInter.TicketService;


public class TicketServiceImp implements  TicketService {

	
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	InitializeStadium  newSta;
	ArrayList<Seat[][]> allSeats;
	Hashtable<Integer, SeatHold> seatHolds ; 
	Hashtable<String, SeatHold>  reservedSeats;
	int confirmationCodeCounter =0;

	@Override
	public synchronized SeatHold findAndHoldSeats(int numSeats, Integer minLevel,
			Integer maxLevel, String customerEmail) {
		if(newSta == null){
			newSta = new InitializeStadium();
			allSeats = newSta.initializedSeats();
			}
		int initialNeedSeats = numSeats;
		if(seatHolds == null){
		seatHolds = new Hashtable<Integer, SeatHold>();
		}
		SeatHold sh = new SeatHold();
		sh.setSeats(new ArrayList<Seat>());
		sh.setCustomerEmail(customerEmail);
		for(int i=minLevel; i<=maxLevel;i++){
		Seat[][] levelSeats = allSeats.get(i);
		
		sh = holdSeatsAtLevel(levelSeats, numSeats,sh);
		if(sh.getSeats().size() == initialNeedSeats){
			seatHolds.put(sh.getSeatHoldId(), sh);
			return sh;
		}
		 numSeats = initialNeedSeats-sh.getSeats().size();  //update date the remaining needed seats
		}
		seatHolds.put(sh.getSeatHoldId(), sh);
		return sh;
	}
	
	/**
	 * Check this particular level has enough seats
	 * @param levelSeats  All seats in this level
	 * @param sh 
	 * @return  SeatHodl object with seats hold
	 */
	private SeatHold holdSeatsAtLevel(Seat[][] levelSeats, int needSeatNum, SeatHold sh) {
	
		int k =0;
		Date now  = Calendar.getInstance().getTime();
		for(int row =0; row<levelSeats.length;row++){
			int rowSeatsNum = levelSeats[0].length;
			for(int seatNum =0; seatNum<rowSeatsNum;seatNum++){
				Seat currentSeat = levelSeats[row][seatNum];
				if(currentSeat.isTempHold() || currentSeat.isFinalReserved() ){
					continue;
				}else{
					if(sh.getSeats() == null){
						sh.setSeats(new ArrayList<Seat>());
					}
					sh.getSeats().add(currentSeat);
					currentSeat.setTempHold(true);
					currentSeat.setHoldDate(now);
					k++;
					if(k>=needSeatNum){
						sh.setFeedBackMessage( needSeatNum+" tickets are hold.");
						return sh;
						}
				}
			}
		}
		
		
	
		return sh;
	}

	
	@Override
	public int numSeatsAvailable(Integer venueLevel) {
		if(newSta == null){
		newSta = new InitializeStadium();
		allSeats =  newSta.initializedSeats();
		}
		
		Seat[][] levelSeats = allSeats.get(venueLevel);
			int availableSeatsNum = 0;
	
			for(int row=0; row<levelSeats.length;row++){
				int rowSeatsNum = levelSeats[0].length;
				for(int seatNum =0; seatNum<rowSeatsNum;seatNum++){
					Seat currentSeat = levelSeats[row][seatNum];
					Date now = Calendar.getInstance().getTime();
					
					if(currentSeat.getHoldDate() != null){
					long timeNow = now.getTime();
					long timeHold = currentSeat.getHoldDate().getTime();
					int timeDiff = (int) ((timeNow-timeHold)/1000);
					if(timeDiff <30)     //set the hold time to 30 seconds
						currentSeat.setTempHold(true);
					else{
						currentSeat.setTempHold(false);
						currentSeat.setHoldDate(null);
						}
					}
					
					if(currentSeat.isTempHold() || currentSeat.isFinalReserved()){
						continue;
					}else
						availableSeatsNum++;
				}
				
			}
		
		return availableSeatsNum;
	}
	
	@Override
	public String reserveSeats(int seatHoldId, String customerEmail) {
		SeatHold ySH = seatHolds.get(seatHoldId);
		double totalCost = 0;
		String sb;
		for(Seat s: ySH.getSeats()){
			s.setFinalReserved(true);
			totalCost = totalCost+s.getPrice();
		}
		
		if(reservedSeats == null){
			reservedSeats = new Hashtable<String, SeatHold>();
		}
		String confCode = generateConfirmationcode();
		reservedSeats.put(confCode, ySH);
		sb = "Your confirmation is "+ confCode+ "\n"+" Your fee is : "+totalCost; 
		return sb;
	}
	
	
	private  String generateConfirmationcode(){
		 SecureRandom rnd = new SecureRandom();
		 confirmationCodeCounter++;
		StringBuilder sb = new StringBuilder( 7 );
		   for( int i = 0; i < 7; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		   return sb.toString()+confirmationCodeCounter;
	}

}
