package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class Reservation {
	private int roomNumber;
	private LocalDate checkIn;
	private LocalDate checkOut;
	
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	public Reservation(int roomNumber, LocalDate checkIn, LocalDate checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public long duration() {
	    return ChronoUnit.DAYS.between(checkIn, checkOut);
	}
	
	public String updateDates(LocalDate checkIn, LocalDate checkOut) {
		if(checkIn.isBefore(LocalDate.now()) || checkOut.isBefore(LocalDate.now())) {
			return "Reservation dates for update must be future dates";
		} 
		if(!checkOut.isAfter(checkIn)) {
			return "Check-out date must be after check-in date.";
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		//se retorna nulo, é porque não deu erro
		return null;
	}
	
	@Override
	public String toString() {
		return "Room " 
				+ roomNumber
				+ ", check-in: "
				+ checkIn.format(fmt)
				+ ", check-out: "
				+ checkOut.format(fmt)
				+ ", "
				+ duration()
				+ " nights";
	}
	
	
	
	
}
