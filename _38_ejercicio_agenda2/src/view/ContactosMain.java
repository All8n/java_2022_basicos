	package view;

import java.util.Scanner;

import model.Contacto;
import service.ContactosService;

public class ContactosMain {
	
	static ContactosService agendaService=new ContactosService();

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
		String email;
		int edad;
		System.out.println("Introduce número de teléfono");
		numero=Integer.parseInt(sc.nextLine());
		System.out.println("Introduce nombre");
		nombre=sc.nextLine();
		System.out.println("Introduce email");
		email=sc.nextLine();
		System.out.println("Introduce edad");
		edad=Integer.parseInt(sc.nextLine());
		
		agendaService.guardarContacto(numero, nombre,email,edad);
		
}
	static void buscarContacto() {
		
		Scanner sc=new Scanner(System.in);
		int numero;
		Contacto contacto;
		System.out.println("Introduce número de teléfono");
		numero=sc.nextInt();
		contacto=agendaService.buscarContacto(numero);
		System.out.println(contacto.getNombre()+"-"+contacto.getEmail()+"-"+contacto.getEdad());
	}
	
	static void eliminarContacto() {
		
		Scanner sc=new Scanner(System.in);
		int numero;
		System.out.println("Introduce número de teléfono");
		numero=sc.nextInt();
		
		agendaService.eliminarContacto(numero);
		
	}
	
	static void mostrarNombres() {
		
		String[] nombres=agendaService.nombres();
		//for(int i=0;i<nombres.length;i++);
		
		for(String n:nombres) {
				System.out.println(n);
		}
	
		
		
		
	}
	
	
}