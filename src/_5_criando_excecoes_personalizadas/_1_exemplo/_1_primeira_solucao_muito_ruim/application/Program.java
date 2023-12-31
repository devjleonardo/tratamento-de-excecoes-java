package _5_criando_excecoes_personalizadas._1_exemplo._1_primeira_solucao_muito_ruim.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import _5_criando_excecoes_personalizadas._1_exemplo._1_primeira_solucao_muito_ruim.model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date now = new Date();
		
		System.out.print("Room number: ");
		int roomNumber = scanner.nextInt();
		
		System.out.print("Check-in date (dd/MM/yyyy): ");
		Date checkIn = simpleDateFormat.parse(scanner.next());
		
		System.out.print("Check-out date (dd/MM/yyyy): ");
		Date checkOut = simpleDateFormat.parse(scanner.next());
		
		if (checkIn.before(now) || checkOut.before(now)) {
			System.out.println("Error in reservation: Reservation dates for update must be future dates");
		} else if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			
			System.out.println("Enter data to update the reservation:");
			
			System.out.print("Check-in date (dd/MM/yyyy): ");
			checkIn = simpleDateFormat.parse(scanner.next());
			
			System.out.print("Check-out date (dd/MM/yyyy): ");
			checkOut = simpleDateFormat.parse(scanner.next());
			
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			} else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}
		}
		
		scanner.close();
	}
	
}
