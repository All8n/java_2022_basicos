package view;

import java.util.Scanner;

import service.NotasService;

	
public class NotasMain {

	static NotasService notasService=new NotasService();
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int opcion;
		do {
			mostrarMenu();
			opcion=sc.nextInt();//le la opcion elegida
			switch(opcion) {//evaluamos la opcion
			
			case 1:
				pedirNota();
				break;
			case 2:
				mostrarMedia();
				break;
			case 3:
				mostrarAprobados();
				break;
			case 4:
				mostrasExtremas();
				break;
			case 5:
				mostrarTodas();
			case 6:
				eliminarSuspenso();
				
				
			}
			
			
		}while(opcion!=7);
	}
	static void mostrarMenu() {
		
		System.out.println("1.- Grabar nota ");
		System.out.println("2.- Calcular media ");
		System.out.println("3.- Aprobados ");
		System.out.println("4.- Notas extremas ");
		System.out.println("5.- Mostrar todas ");
		System.out.println("6.- Eliminar suspensos ");
		System.out.println("7.- Salir");
		
	}
	
	static void pedirNota() {
		Scanner sc=new Scanner(System.in);
		double nota;
		System.out.println("Introduce nota ");
		nota=sc.nextDouble();
		notasService.guardarNota(nota);
		
	}
	
	static void mostrarMedia() {
		System.out.println("La media es: "+notasService.media()	);
	}
	
	static void mostrarAprobados() {
		System.out.println("Aprobados: "+notasService.aprobados());
	}
	static void mostrasExtremas() {
		System.out.println("Nota minima: "+notasService.notaMin());
		System.out.println("Notas maxima: "+notasService.notaMax());
	}
	
	static void mostrarTodas() {
		double[] notas=notasService.notas();
		for(int i=0;i<notas.length;i++) {
			System.out.println(notas[i]);
	}
 }
	static void eliminarSuspenso() {
		notasService.eliminarSuspenso();
	}
}