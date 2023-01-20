package view;

import java.util.Scanner;

import model.Ciudad;
import service.PaisesService;

public class PaisesMain {
	
	static PaisesService ciudadService=new PaisesService();
		
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int opcion;
		do {
			mostrarMenu();
			
			opcion=sc.nextInt();
			
			switch(opcion){
			
			case 1:
				añadirCiudad();
				break;
			case 2:
				ciudadMasPoblada();
				break;
			case 3:
				ciudadesPorPais();
				break;
			case 4:
			
		System.out.println("--Adios--");
					
				
			}
			
			
			
		}while(opcion!=4);
		
		
	}
	static void mostrarMenu(){
		
		System.out.println("1.- Añadir ciudad");
		System.out.println("2.- Ciudad mas poblada");
		System.out.println("3.- Ciudades por pais");
		System.out.println("4.- Salir");

	
	}
	static void añadirCiudad() {
		Scanner sc=new Scanner(System.in);
		String nombre;
		int habitantes;
		String pais;
		System.out.println("Introduce nombre de la ciudad");
		nombre=sc.nextLine();
		System.out.println("Introduce cuantos habitantes tiene");
		habitantes=Integer.parseInt(sc.nextLine());
		System.out.println("Introduce el pais");
		pais=sc.nextLine();
		
		ciudadService.guardarCiudad(nombre, habitantes,pais);
		
		
	}
	
	static void ciudadMasPoblada() {
		
		Ciudad ciudad = ciudadService.ciudadMasPoblada();
		System.out.println(ciudad.getNombre()+"-"+ciudad.getHabitantes()+"-"+ciudad.getPais());
		
	}
	static Ciudad[] ciudadesPorPais(String pais) {
		
		Ciudad[] paises=ciudadService.ciudadesPorPais(pais);
		
		for(Ciudad p:paises) {
			if(p.getPais().equals(paises)) {
			System.out.println(p.getPais());
		}
		}
		
	}
}
