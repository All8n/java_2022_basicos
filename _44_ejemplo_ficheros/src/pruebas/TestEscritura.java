package pruebas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class TestEscritura {

	public static void main(String[] args) {
		PrintStream x=null;
		String dir="c:\\Ficheros\\dias.txt";
		/*try {
			
		x=new PrintStream(dir);
		x.println("jueves ");
		x.print(" viernes ");
		x.print("sabado ");
		return;
		}
	
		catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
		finally {
			if(x!=null) {	
			x.close(); //cierra el canal
			*/
	
		try(PrintStream x=new PrintStream(dir);){
			x.println("jueves");
			x.println("viernes");
			x.println("sábado");
			return;
		}
		catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}

	}

}	
