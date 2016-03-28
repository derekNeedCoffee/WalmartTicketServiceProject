package ticketServiceImp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.ejb.Singleton;
import javax.json.JsonObject;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import ticketServiceData.Seat;
import ticketServiceData.StadiumLevel;

@Singleton
public class InitializeStadium {
	
	public static  Integer numberOfLevels  ;
	public  static  Integer rowOnOrchestra ;
	public  static  Integer seatNumOrchestra ;
	public  static  Integer rowOnMain ;
	public  static  Integer seatNumMain;
	public  static  Integer rowOnBalconyOne;
	public  static Integer seatNumBalconyOne;
	public  static  Integer rowOnBalconyTwo ;
	public  static Integer seatNumBalconyTwo ;
	public  static Double priceOrchestra ;
	public  static Double priceMain;
	public  static Double priceBalconyOne;
	public  static  Double priceBalconyTwo;
	public  static  String orchestraName;
	public  static String mainName;
	public  static String balconyOneName;
	public  static String balconyTwoName;
	
	
	
	@SuppressWarnings("null")
	public ArrayList<Seat[][]> initializedSeats(){
		 JSONParser parser = new JSONParser();
		 try {     
	            Object obj = parser.parse(new FileReader("seatsInformation.json"));

	            JSONObject jsonObject =  (JSONObject) obj;

	            orchestraName = (String) jsonObject.get("orchestraName");

	            mainName = (String) jsonObject.get("mainName");

	            balconyOneName = (String) jsonObject.get("balconyOneName");
	            
	            balconyTwoName = (String) jsonObject.get("balconyTwoName");
	            
	             numberOfLevels = Integer.valueOf((String) jsonObject.get("numberOfLevels"));
	            
	            rowOnOrchestra = Integer.valueOf((String) jsonObject.get("rowOnOrchestra"));

	            rowOnMain = Integer.valueOf((String) jsonObject.get("rowOnMain"));

	            rowOnBalconyOne = Integer.valueOf((String) jsonObject.get("rowOnBalconyOne"));

	            rowOnBalconyTwo = Integer.valueOf((String) jsonObject.get("rowOnBalconyTwo"));
	            
	            seatNumOrchestra = Integer.valueOf((String) jsonObject.get("seatNumOrchestra"));
	            
	            seatNumMain = Integer.valueOf((String) jsonObject.get("seatNumMain"));
	            
	            seatNumBalconyOne = Integer.valueOf((String) jsonObject.get("seatNumBalconyOne"));
	            
	            seatNumBalconyTwo = Integer.valueOf((String) jsonObject.get("seatNumBalconyTwo"));
	            
	            priceOrchestra = Double.valueOf( (String)jsonObject.get("priceOrchestra"));	 
	            
	            priceMain = Double.valueOf( (String)jsonObject.get("priceMain"));	 
	            priceBalconyOne = Double.valueOf( (String)jsonObject.get("priceBalconyOne"));
	            priceBalconyTwo = Double.valueOf( (String)jsonObject.get("priceBalconyTwo"));
           
	            
	            
	            
	            

	        
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	    
		 
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
