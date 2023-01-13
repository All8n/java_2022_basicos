package service;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import model.Curso;

public class CursoServiceFichero {
	
	String ruta="c:\\temp\\cursos.txt";
	
	public boolean agregarCurso(Curso curso) {
		try(FileReader fr=new FileReader(ruta);
				BufferedReader bf=new BufferedReader (fr);){
					String s;
					while((s=bf.readLine())!=null) {
						//	si encontramos curso con dicho nombre, salimos 
						
						if(s.split("[|]")[0].equals(curso.getNombre())){
							return false;
						}
					}
				}catch (IOException ex) {
					ex.printStackTrace();
				}
		try(FileOutputStream fos=new FileOutputStream(ruta);
				PrintStream out=new PrintStream(fos);){
				out.print(curso.getNombre()+"|"+curso.getPrecio()+"|"+curso.getDuracion()+"|"+curso.getTematica());
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		return true;
		}
	
		
	public Curso buscarCurso(String nombre) {
	
	}
	
	public double mediaDuracion() {
		
		
	}
	
	public  List<Curso> cursosPorTematica(String tematica){
		
		
	}
	
	public void eliminarPorPrecio(double precio) {
		

}
}
