package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.Pedidos;
import service.PedidosService;

public class PedidosMain {
	
	static PedidosService pedidosService=new PedidosService();

	public static void main(String[] args) throws ParseException   {
		
		Scanner sc=new Scanner(System.in);
		int opcion;
		do {
			mostrarMenu();
			
			opcion=sc.nextInt();
			
			switch(opcion){
			
			case 1:
				nuevoPedido();
				break;
			case 2:
				pedidoReciente();
				break;
			case 3:
				todosPedido();
			
		System.out.println("--Adios--");
					
		}
				
		}while(opcion!=4);
		
	}
	static void mostrarMenu() {
		System.out.println("1.- Nuevo pedido");
		System.out.println("2.- Pedido mas reciente");
		System.out.println("3.- Datos de todos los pedidos");
		System.out.println("4.- Salir");
	}


	static void nuevoPedido() throws ParseException {
		
		Scanner sc=new Scanner(System.in);
		SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");	

		String producto;
		Date fecha;
		double total;
		System.out.println("Introduce nombre del producto");
		producto=sc.nextLine();
		System.out.println("Introduce fecha (dia/mes/año)");
		fecha=format.parse(sc.nextLine());
		System.out.println("Introduce precio del pedido");
		total=Double.parseDouble(sc.nextLine());
		
		pedidosService.guardarPedidos(producto, fecha, total);
	}
	static void pedidoReciente() {
		Pedidos pedido=pedidosService.pedidoReciente();
		System.out.println("Producto: "+pedido.getProducto());
		System.out.println("Fecha: "+pedido.getFecha());
		System.out.println("Precio: "+pedido.getTotal());
	
	}
	static void todosPedido() {
		
		Pedidos[] todos =pedidosService.todos();
		for(Pedidos p:todos) {
			System.out.println("Producto: "+p.getProducto());
			System.out.println("Fecha: "+p.getFecha());
			System.out.println("Precio: "+p.getTotal());
			
		}
		
		
	}
}
	