package ticketServiceData;

import java.util.Date;



/**
 * 
 * @author TT
 *
 */

// multithread
public class Seat {
	
	

	private Integer row;
	private Integer seatNum;
	private Integer seatLevel;
	private Double price;
	private boolean tempHold;
	private boolean finalReserved;
	private Date    holdDate;
	private String  levelName;
	
	
	public String getLevelName() {
		return levelName;
	}


	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}


	public Seat(Integer seatLevel,Integer row, Integer seatNum, double price,String levelName){
		this.seatLevel = seatLevel;
		this.row = row;
		this.seatNum = seatNum;
		this.price = price;
		this.levelName = levelName;
	}
	
	
	/**
	 * Return seat level.
	 * @return  seat level
	 */
	public Integer getSeatLevel() {
		return seatLevel;
	}
	
	/**
	 * Set seat level
	 * @param seatLevel  pass String as seat Level
	 */
	public void setSeatLevel(Integer seatLevel) {
		this.seatLevel = seatLevel;
	}
	
	/**
	 * return the price this seat.
	 * 
	 * @return An integer as price for the seat
	 */
	public Double getPrice() {
		return price;
	}
	
	
	/**
	 * Set price for the seat
	 * @param price  Pass integer for pirce
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	
	/**
	 * Return if this seat hold or not.
	 * @return  a boolean value for holding status.
	 */
	public boolean isTempHold() {
		return tempHold;
	}
	
	
	/**
	 * Set hold status for the seat.
	 * @param tempHold pass a boolean value for hold status
	 */
	public void setTempHold(boolean tempHold) {
		this.tempHold = tempHold;
	}
	
	
	/**
	 * Return  if seat final reserved or not.
	 * @return   A boolean value for final reserverd status.
	 */
	public boolean isFinalReserved() {
		return finalReserved;
	}
	
	
	/**
	 * Set the final reserved status 
	 * @param finalReserved
	 */
	public void setFinalReserved(boolean finalReserved) {
		this.finalReserved = finalReserved;
	}

	public Date getHoldDate() {
		return holdDate;
	}

	public void setHoldDate(Date holdDate) {
		this.holdDate = holdDate;
	}

	public Integer getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(Integer seatNum) {
		this.seatNum = seatNum;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}
	
}
