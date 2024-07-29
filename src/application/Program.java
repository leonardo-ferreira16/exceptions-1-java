package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
	
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		String checkInString = sc.nextLine();
		LocalDate checkIn = LocalDate.parse(checkInString, fmt);
		
		System.out.print("Check-out date (dd/MM/yyyy): ");
		String checkOutString = sc.nextLine();
		LocalDate checkOut = LocalDate.parse(checkOutString, fmt);
		
		if(!checkOut.isAfter(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date.");
		} else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkInString = sc.nextLine();
			checkIn = LocalDate.parse(checkInString, fmt);
			
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOutString = sc.nextLine();
			checkOut = LocalDate.parse(checkOutString, fmt);
			
			if(checkIn.isBefore(LocalDate.now()) || checkOut.isBefore(LocalDate.now())) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			} else if(!checkOut.isAfter(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date.");

			} else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);

			}
			
		}
	
		
		sc.close();
	}

}
