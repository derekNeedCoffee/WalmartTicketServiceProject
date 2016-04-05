package ticketServiceImp;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.ejb.Singleton;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ticketServiceData.Seat;
import ticketServiceData.StadiumLevel;

@Singleton
public class InitializeStadium {

	public static Integer numberOfLevels;
	public static Integer rowOnOrchestra;
	public static Integer seatNumOrchestra;
	public static Integer rowOnMain;
	public static Integer seatNumMain;
	public static Integer rowOnBalconyOne;
	public static Integer seatNumBalconyOne;
	public static Integer rowOnBalconyTwo;
	public static Integer seatNumBalconyTwo;
	public static Double priceOrchestra;
	public static Double priceMain;
	public static Double priceBalconyOne;
	public static Double priceBalconyTwo;
	public static String orchestraName;
	public static String mainName;
	public static String balconyOneName;
	public static String balconyTwoName;
	public static ArrayList<Seat[][]>  newStadium;

	@SuppressWarnings("null")
	public ArrayList<Seat[][]> initializedSeats() {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader("seatsInformation.json"));

			JSONObject jsonObject = (JSONObject) obj;

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

			priceOrchestra = Double.valueOf((String) jsonObject.get("priceOrchestra"));

			priceMain = Double.valueOf((String) jsonObject.get("priceMain"));
			priceBalconyOne = Double.valueOf((String) jsonObject.get("priceBalconyOne"));
			priceBalconyTwo = Double.valueOf((String) jsonObject.get("priceBalconyTwo"));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(" Failed not found!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		ArrayList<StadiumLevel> levels = new ArrayList<StadiumLevel>();
		StadiumLevel orchestraLevel = new StadiumLevel(rowOnOrchestra, seatNumOrchestra, orchestraName, priceOrchestra);
		levels.add(orchestraLevel);
		StadiumLevel mainLevel = new StadiumLevel(rowOnMain, seatNumMain, mainName, priceMain);
		levels.add(mainLevel);
		StadiumLevel balconyOneLevel = new StadiumLevel(rowOnBalconyOne, seatNumBalconyOne, balconyOneName,
				priceBalconyOne);
		levels.add(balconyOneLevel);
		StadiumLevel balconyTwoLevel = new StadiumLevel(rowOnBalconyTwo, seatNumBalconyTwo, balconyTwoName,
				priceBalconyTwo);
		levels.add(balconyTwoLevel);

		ArrayList<Seat[][]> allSeats = new ArrayList<Seat[][]>();

		for (int p = 0; p < levels.size(); p++) {
			StadiumLevel level = levels.get(p);
			Seat[][] levelSeats = new Seat[level.getRowNum()][level.getSeatNum()];
			for (int j = 0; j < level.getRowNum(); j++) {
				for (int k = 0; k < level.getSeatNum(); k++) {
					levelSeats[j][k] = new Seat(0, j, k, level.getLevelPrice(), level.getLevelName());
				}
			}
			allSeats.add(levelSeats);
		}
		newStadium = allSeats;
		return allSeats;
	}

}
