package ticketServiceImp;

import java.util.ArrayList;

import javax.ejb.Singleton;

import ticketServiceData.Seat;
import ticketServiceData.StadiumLevel;

@Singleton
public class InitializeStadium {
	
	public final static  int numberOfLevels = 4;
	public final static  int rowOnOrchestra = 25;
	public final static  int seatNumOrchestra = 50;
	public final static  int rowOnMain = 20;
	public final static  int seatNumMain = 100;
	public final static  int rowOnBalconyOne =15;
	public final static int seatNumBalconyOne = 100;
	public final static  int rowOnBalconyTwo =15;
	public final static int seatNumBalconyTwo = 100;
	public final static double priceOrchestra = 100;
	public final static double priceMain = 75;
	public final static double priceBalconyOne = 50;
	public final static  double priceBalconyTwo = 40;
	public final static  String orchestraName = "Orchestra";
	public final static String mainName = "Main";
	public final static String balconyOneName = "BalconyOne";
	public final static String balconyTwoName = "BalconyTwo";
	
	
	
	@SuppressWarnings("null")
	public ArrayList<Seat[][]> initializedSeats(){
		
		ArrayList<StadiumLevel> levels = new ArrayList<StadiumLevel>();
		StadiumLevel orchestraLevel = new StadiumLevel(rowOnOrchestra,seatNumOrchestra, orchestraName,priceOrchestra );
		levels.add(orchestraLevel);
		StadiumLevel mainLevel = new StadiumLevel(rowOnMain,seatNumMain, mainName,priceMain );
		levels.add(mainLevel);
		StadiumLevel balconyOneLevel = new StadiumLevel(rowOnBalconyOne,seatNumBalconyOne, balconyOneName,priceBalconyOne );
		levels.add(balconyOneLevel);
		StadiumLevel balconyTwoLevel = new StadiumLevel(rowOnBalconyTwo,seatNumBalconyTwo, balconyTwoName,priceBalconyTwo );
		levels.add(balconyTwoLevel);
		
		
		
		ArrayList<Seat[][]>  allSeats = new ArrayList<Seat[][]>();
		
		
			for(int p=0;p<levels.size();p++){
				StadiumLevel level = levels.get(p);
				Seat[][] levelSeats = new Seat[level.getRowNum()][level.getSeatNum()] ;
				for(int j =0;j<level.getRowNum();j++){
					for(int k=0;k<level.getSeatNum();k++){
						levelSeats[j][k]  = new Seat(0,j,k,level.getLevelPrice(),level.getLevelName());
					}
				}
				allSeats.add(levelSeats);
			}
				/*Seat[][] Orchestar = new Seat[rowOnOrchestra][seatNumOrchestra] ;
				for(int j =0;j<=24;j++){
					for(int k=0;k<=49;k++){
						Orchestar[j][k]  = new Seat(0,j,k,priceOrchestra,"Orchestra");
					}
				}
				allSeats.add(Orchestar);
			
			
			
				Seat[][] Main = new Seat[rowOnMain][seatNumMain] ;
				for(int j =0;j<20;j++){
					for(int k=0;k<100;k++){
						Main[j][k]  = new Seat(1,j,k,priceMain,"Main");
					}
				}
			 allSeats.add(Main);
			
			
				Seat[][] BalconyOne = new Seat[rowOnBalconyOne][seatNumBalconyOne] ;
				for(int j =0;j<15;j++){
					for(int k=0;k<100;k++){
						BalconyOne[j][k]  = new Seat(2,j,k,priceBalconyOne,"BalconyOne");
					}
				}
			allSeats.add(BalconyOne);
			
			
				Seat[][] BalconyTwo = new Seat[rowOnBalconyTwo][seatNumBalconyTwo] ;
				for(int j =0;j<15;j++){
					for(int k=0;k<100;k++){
						BalconyTwo[j][k]  = new Seat(3,j,k,priceBalconyTwo,"BalconyTwo");
					}
				}
			allSeats.add(BalconyTwo);
		*/
		return allSeats;
	}
	

}
