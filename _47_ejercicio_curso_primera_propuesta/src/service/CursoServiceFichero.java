package service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import model.Curso;

public class CursoServiceFichero {
	String ruta="c:\\temp\\cursos.txt";
	//en el constructor comprobamos si existe el fichero
	//y si no existe lo creamos
	public CursoServiceFichero() {
		File file=new File(ruta);
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
	public boolean agregarCurso(Curso curso) {
		try(FileReader fr=new FileReader(ruta);
			BufferedReader bf=new BufferedReader(fr);){
			String s;
			while((s=bf.readLine())!=null) {
				//si encontramos curso con dicho nombre, salimos
				if(s.split("[|]")[0].equals(curso.getNombre())) {
					return false;
				}
			}
		}catch(IOException ex) {
			
			ex.printStackTrace();
		}
		//aqui llega si no encuentra curso, y entonces lo tiene
		//que grabar en el fichero
		try(FileOutputStream fos=new FileOutputStream(ruta,true);
			PrintStream out=new PrintStream(fos);){
			out.println(curso.getNombre()+"|"+curso.getPrecio()+"|"+curso.getDuracion()+"|"+curso.getTematica());
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		return true;
		
	}
	
	public Curso buscarCurso(String nombre) {
		Curso curso=null;
		try(FileReader fr=new FileReader(ruta);
				BufferedReader bf=new BufferedReader(fr);){
			String s;
			while((s=bf.readLine())!=null) {
				//si encontramos curso con dicho nombre, salimos
				String[] datos=s.split("[|]");
				if(datos[0].equals(nombre)) {
					//crear objeto curso con todos los datos del mismo
					curso=new Curso(datos[0], 
							Double.parseDouble(datos[1]),
							Integer.parseInt(datos[2]), 
							datos[3]);
				}
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		return curso;
	}
	
	public double mediaDuracion() {
		double media=0;
		int total=0;
		try(FileReader fr=new FileReader(ruta);
				BufferedReader bf=new BufferedReader(fr);){
			String s;
			while((s=bf.readLine())!=null) {
				total++;
				String[] datos=s.split("[|]");
				media=media+Integer.parseInt(datos[2]);
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		return media/total;
	}
	
	public List<Curso> cursosPorTematica(String tematica){
		List<Curso> aux=new ArrayList<>();
		try(FileReader fr=new FileReader(ruta);
				BufferedReader bf=new BufferedReader(fr);){
			String s;
			while((s=bf.readLine())!=null) {
				//si encontramos curso con dicho nombre, salimos
				String[] datos=s.split("[|]");
				if(datos[3].equals(tematica)) {
					//crear objeto curso con todos los datos del mismo
					Curso curso=new Curso(datos[0], 
							Double.parseDouble(datos[1]),
							Integer.parseInt(datos[2]), 
							datos[3]);
					//agregamos el nuevo curso al auxiliar que
					//devolveremos como resultado
					aux.add(curso);
				}
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		return aux;
	}
	
	public void eliminarPorPrecio(double precio) {
		//volcamos todos los cursos del fichero en una lista
		List<Curso> aux=new ArrayList<>();
		try(FileReader fr=new FileReader(ruta);
				BufferedReader bf=new BufferedReader(fr);){
			String s;
			while((s=bf.readLine())!=null) {
				//si encontramos curso con dicho nombre, salimos
				String[] datos=s.split("[|]");
				//crear objeto curso con todos los datos del mismo
				Curso curso=new Curso(datos[0], 
						Double.parseDouble(datos[1]),
						Integer.parseInt(datos[2]), 
						datos[3]);
				//agregamos el nuevo curso al auxiliar que
				//devolveremos como resultado
				aux.add(curso);
				
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}	
		//elimina de la lista los que cumplan la condición
		aux.removeIf(x->x.getPrecio()>precio);
		//volcar la lista en el fichero
		//recorremos la lista y vamos escribiendo cada curso en una línea del fichero
		//en modo sobrescritura, para que el contenido anterior desaparezca
		try(FileOutputStream fos=new FileOutputStream(ruta,false);
				PrintStream out=new PrintStream(fos);){
			for(Curso curso:aux) {
				out.println(curso.getNombre()+"|"+curso.getPrecio()+"|"+curso.getDuracion()+"|"+curso.getTematica());
			}
				
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}
}


