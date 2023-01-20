package view;

import model.Curso;
import service.CursoServiceFichero;

public class Test {

	public static void main(String[] args) {
		CursoServiceFichero service=new CursoServiceFichero();
		service.agregarCurso(new Curso("Java",200,100,"programación"));
		service.agregarCurso(new Curso("JavaScript",80,50,"programación"));
		service.agregarCurso(new Curso("Python",150,80,"programación"));
		service.eliminarPorPrecio(100);
		System.out.println(service.cursosPorTematica("programación").size());
		
	}
		
	}


