package ticketServiceData;

public class StadiumLevel {
	

	private int rowNum;
	private int seatNum;
	private String levelName;
	private double levelPrice;
	public StadiumLevel(int rowNum, int seatNum, String levelName, double levelPrice){
		this.rowNum = rowNum;
		this.seatNum = seatNum;
		this.levelName = levelName;
		this.levelPrice = levelPrice;
	}
	public int getRowNum() {
		return rowNum;
	}
	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
	public int getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}
	public String getLevelName() {
		return levelName;
	}
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}
	public double getLevelPrice() {
		return levelPrice;
	}
	public void setLevelPrice(double levelPrice) {
		this.levelPrice = levelPrice;
	}
}
