package _41_pruebas_fechas;

import java.time.LocalDate;

public class Test2 {

	public static void main(String[] args) {

		LocalDate f1=LocalDate.of(2020, 10, 30 );
		LocalDate f2=LocalDate.of(2016, 05, 15);
		//comparacion de fechas 
		if (f1.isBefore(f2)) {
			
		System.out.println("La fecha mas antigua es: "+ f1);
		System.out.println("La fecha mas reciente es: "+ f2);

		}else {
			System.out.println("La fecha mas antigua es: "+ f2);
			System.out.println("La fecha mas reciente es: "+ f1);

		}
		
		System.out.println(f1.plusMonths(8));
	}

}
