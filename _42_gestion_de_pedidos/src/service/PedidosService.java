package service;

import java.util.ArrayList;
import java.util.Date;

import model.Pedidos;

public class PedidosService {
	
	ArrayList<Pedidos> pedidos=new ArrayList<>();
	
	public void guardarPedidos(String producto, Date fecha,double total) {
		pedidos.add(new Pedidos(producto,fecha,total));
		
	}
	
	public Pedidos pedidoReciente() {
		
		Date fechaRec=new Date(0);
		Pedidos pedidos1=null;
		
		for(Pedidos p:pedidos) {
			
			if(p.getFecha().after(fechaRec)) {//si encontramos una fecha mas reciente se actualiza el pedido.
				fechaRec=p.getFecha();
				pedidos1=p;
			
			}
				
		}
		return pedidos1;

}
	public Pedidos[] todos() {
		Pedidos[] resultado=new Pedidos[pedidos.size()];
		for(int i=0;i<pedidos.size();i++) {
			resultado[i]=pedidos.get(i);
			
		}
		return resultado;
	}
}

