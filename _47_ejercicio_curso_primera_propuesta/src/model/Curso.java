package model;

public class Curso {
	private String 	nombre;
	private double duracion;
	private int precio;
	private String tematica;
	public Curso(String nombre, double duracion, int precio, String tematica) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
		this.precio = precio;
		this.tematica = tematica;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getDuracion() {
		return duracion;
	}
	public void setDuracion(double duracion) {
		this.duracion = duracion;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public String getTematica() {
		return tematica;
	}
	public void setTematica(String tematica) {
		this.tematica = tematica;
	}
	

}
