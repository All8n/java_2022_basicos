package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
	private String 	nombre;
	private double duracion;
	private int precio;
	private String tematica;
	
}
