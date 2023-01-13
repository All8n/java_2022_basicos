package service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import model.Curso;

public class CursoService {
	
	HashSet<Curso> cursos=new HashSet<>();
	
	public boolean agregarCurso(Curso curso) {
		boolean agregado=false;
		for(Curso c:cursos) {
			//si encontramos un curso con el mismo nombre salimos y devolvemos false
			if(c.getNombre().equals(curso.getNombre())) {
				return false;
			}
		}
		//si llegamos aqui, es porque no hay un curso con el mismo nombre
		cursos.add(curso);
		return true;	
		
		
	}
		
	public Curso buscarCurso(String nombre) {
		Curso c=null;
		for(Curso cr:cursos) {
			if(cr.getNombre().equals(nombre)) {//encontrado
				c=cr;
				break;
			}
		}
		return c;
	}
	
	public double mediaDuracion() {
		double media=0;
		for(Curso c:cursos) {
			media=media+c.getDuracion();
			
		}
		return media/cursos.size();
		
	}
	
	public  List<Curso> cursosPorTematica(String tematica){
		List<Curso> auxiliar=new ArrayList<>();
		for (Curso c:cursos) {
			//si la tematica del curso que recorremos es igual a la tematica recibida
			//lo añadimos a la lista auxiliar 
			if(c.getTematica().equals(tematica)) {
				auxiliar.add(c);
			}
		}
		return auxiliar;
	}
	
	public void eliminarPorPrecio(double precio) {
		/*for(Curso c:cursos) {
			if(c.getPrecio()>precio) {
				cursos.remove(c);
			}
		}*/
		cursos.removeIf(t->t.getPrecio()>precio);
		
	}

}
