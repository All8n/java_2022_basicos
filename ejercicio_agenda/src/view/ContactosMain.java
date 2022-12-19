package view;

import java.util.Scanner;

import service.ContactosService;

public class ContactosMain {
	
	static ContactosService contactosService=new ContactosService();

	public static void main(String[] args) {
		
		
		Scanner sc=new Scanner(System.in);
		int opcion;
		do {
			mostraMenu();
			opcion=sc.nextInt();//le la opcion elegida
			switch(opcion) {//evaluamos la opcion
			
			case 1:
				buscarContacto();
				break;
			case 2:
				buscarContacto();
				break;
			case 3:
				eliminarContacto();
				break;
			
			case 4 :
				mostrarNombres();
				
				
				System.out.println("--Adios--");
				
			}
			
			
		}while(opcion!=5);

	}
	static void mostraMenu() {
		
		System.out.println("1.- Nuevo Contacto");
		System.out.println("2.- Buscar Contacto");
		System.out.println("3.- Borrar Contacto");
		System.out.println("4.- Mostrar Nombres");
		System.out.println("5.- Salir");

		
	}
	static void pedirContacto() {
		Scanner sc=new Scanner(System.in);
		int numero;
		String nombre;
		
		System.out.println("Introduce numero de telefono ");
		numero=Integer.parseInt(sc.nextLine());
		System.out.println("Introduce nombre");
		nombre=sc.nextLine();	
		
		contactosService.guardarContacto(numero, nombre);
		
}
	static void buscarContacto() {
		
		Scanner sc=new Scanner(System.in);
		int numero;
		String nombre;
		System.out.println("Introduce número de teléfono");
		numero=sc.nextInt();
		
		nombre=contactosService.buscarContacto(numero);
		System.out.println(nombre);

	
	}
	
	static void eliminarContacto() {
		
		Scanner sc=new Scanner(System.in);
		int numero;
		System.out.println("Introduce número de teléfono");
		numero=sc.nextInt();
		
		contactosService.eliminarContacto(numero);
		
	}
	
	static void mostrarNombres() {
		
		String[] nombres=contactosService.nombres();
		//for(int i=0;i<nombres.length;i++);
		
		for(String n:nombres) {
				System.out.println(n);
		}
	
		
		
		
	}
	
	
}