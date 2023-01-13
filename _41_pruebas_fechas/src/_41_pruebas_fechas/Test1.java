	package _41_pruebas_fechas;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {

	public static void main(String[] args)  {
		
		Date d1=new Date();
		Date d2=new Date(3022223495L);
		//comprobacion de fechas
		if(d1.before(d2)) {
			
			System.out.println("Fecha mas antigua: "+d1);
			System.out.println("Fecha mas moderna: "+d2);
		
		}else {
			
			System.out.println("Fecha mas antigua: "+d1);
			System.out.println("Fecha mas moderna: "+d2);
			
			
		}
		//formateado de fechas
		SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(format.format(d1));  
		System.out.println(format.format(d2));  
		
		//parseado de fechas , transformar fecha de texto a fecha numerico
		SimpleDateFormat format2=new SimpleDateFormat("dd-MM-yyyy");
		String f="11-08-2011";
		try {
			
		Date mifecha=format2.parse(f);	
		System.out.println(format.format(mifecha));
		
		}
		catch(ParseException ex) {
			
			System.out.println("El formato de fecha no es correcto ");
			
		}
		
		

	}

}
