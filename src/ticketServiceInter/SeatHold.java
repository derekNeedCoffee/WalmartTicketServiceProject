package ticketServiceInter;

import java.util.Date;
import java.util.List;

import ticketServiceData.Seat;

public class SeatHold {
	private Integer seatHoldId;
	private List<Seat> seats;
	private Integer costs;
	private String feedBackMessage;
	private Date holdDate;
	private String customerEmail;
	private String status;

	public SeatHold() {
		this.seatHoldId = getNextId();
	}

	static Integer index = 0;

	public static Integer getNextId() {
		return index++;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public Date getHoldDate() {
		return holdDate;
	}

	public void setHoldDate(Date holdDate) {
		this.holdDate = holdDate;
	}

	public List<Seat> getSeats() {
		return seats;
	}

	public void setSeats(List<Seat> seats) {
		this.seats = seats;
	}

	public Integer getCosts() {
		return costs;
	}

	public void setCosts(Integer costs) {
		this.costs = costs;
	}

	public String getFeedBackMessage() {
		return feedBackMessage;
	}

	public void setFeedBackMessage(String feedBackMessage) {
		this.feedBackMessage = feedBackMessage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getSeatHoldId() {
		return seatHoldId;
	}

	public void setSeatHoldId(int seatHoldId) {
		this.seatHoldId = seatHoldId;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null || obj.getClass() != this.getClass())
			return false;
		SeatHold sh = (SeatHold) obj;
		return seatHoldId == sh.getSeatHoldId();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((seatHoldId == null) ? 0 : seatHoldId.hashCode());
		result = prime * result + seatHoldId;
		return result;

	}
}
