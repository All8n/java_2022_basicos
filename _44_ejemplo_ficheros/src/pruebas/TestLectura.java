package pruebas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestLectura {

	public static void main(String[] args) {

		String ruta="c:\\Ficheros\\productos.txt";
		
		FileReader  fr=null;
		BufferedReader bf=null;
		
		try {
			
	    fr=new FileReader(ruta);
	    bf=new BufferedReader(fr);
	    
		/*System.out.println(bf.readLine());//lee la primera linea
		System.out.println(bf.readLine());//lee la segunda linea */
	    String s;
	    while((s=bf.readLine())!=null) {
	    	System.out.println(s);
	    }
	    
		}
		catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		finally {
			if(bf!=null) {
				try {
					bf.close();
				} catch (IOException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			}
			if(fr!=null) {
				try {
					fr.close();
				} catch (IOException ex) {
					// TODO Auto-generated catch block
					ex.printStackTrace();
				}
			}
		}
}
}