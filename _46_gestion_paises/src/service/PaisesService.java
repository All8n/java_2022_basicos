package service;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.util.ArrayList;

import model.Ciudad;

public class PaisesService {
		
	String ruta="c:\\Ficheros\\paises.txt";

	public void guardarCiudad(String nombre, int habitantes, String pais) {

		String datos=nombre+"|"+habitantes+"|"+pais;
		
		try(FileOutputStream fos=new FileOutputStream(ruta, true);
				PrintStream out=new PrintStream(fos);){
					out.println(datos);
				}
				catch(IOException ex) {
					ex.printStackTrace();
				}
		
	}
	
	public Ciudad ciudadMasPoblada() {
		
		Ciudad ciudad=null;
		int habitantesMax=0;
		
		try(FileReader fr=new FileReader(ruta);
				BufferedReader bf=new BufferedReader(fr)){
				String fila;
				
				while((fila=bf.readLine())!=null) {
					
					String[] linea=fila.split("[|]");
					Ciudad c=new Ciudad(linea[0],Integer.parseInt(linea[1]),linea[2]);
					
					if(c.getHabitantes()>habitantesMax) {
						habitantesMax=c.getHabitantes();
						ciudad=c;
					}
				}			
			}
			catch(IOException ex) {
				ex.printStackTrace();
			}
			
			return ciudad; //devuelvo pedido encontrado
	}
	
	
	
	public ArrayList<Ciudad> ciudadesPorPais(String pais) {
		
		ArrayList<Ciudad> resultado=new ArrayList<>();
		
		
		try(FileReader fr=new FileReader(ruta);
				
			BufferedReader bf=new BufferedReader(fr)){
			String fila;
			
			while((fila=bf.readLine())!=null) {
				
				String[] linea=fila.split("[|]");

				Ciudad c=new Ciudad(linea[0],Integer.parseInt(linea[1]),(linea[2]));
				
				if(c.getPais().equals(pais)) {
				
				
				resultado.add(c);
				}
			}			
		}
		catch(IOException ex) {
			ex.printStackTrace();
		}
		
		return resultado;
	}	
		
		

}
