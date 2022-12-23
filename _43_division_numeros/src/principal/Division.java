package principal;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Division {

	public static void main(String[] args) {
		//realize un programa que solicite la informacion de 2 numeros y muestre el resultado de dividir uno entre otro
			
		Scanner sc=new Scanner(System.in);
		try {

		int n1, n2 , div; 
		
		System.out.println("Introduce un numero ");
		n1=sc.nextInt();
		System.out.println("Introduce un numero ");
		n2=sc.nextInt();
		div=n1/n2;
		System.out.println("La division es: "+div);
		}
		/*catch(ArithmeticException ex) {
			System.out.println("No se permiten divisiones por 0");
		}
		catch(InputMismatchException ex) {
			System.out.println("Debes introducir solo caracteres numericos");
			*
		}*/
		
		catch(ArithmeticException|InputMismatchException ex) {//multicach no se puede introducir de la misma rama 
			System.out.println("Operaciones o dato incorrecto");
		}
		
		catch(Exception ex) {//engloba todas las exception padre de padres, no usar casi nunca 
			System.out.println("Error inesperado!");
		}
	}

}
