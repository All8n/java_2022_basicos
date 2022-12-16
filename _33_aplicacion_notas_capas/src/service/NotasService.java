package service;

import java.util.ArrayList;

public class NotasService {
	
	ArrayList<Double> notas=new ArrayList<>();
		
	public void guardarNota(double nota) {
		notas.add(nota);
		
		
	}

	public double media() {
		
		double media=0;
		
		for(int i=0;i<notas.size();i++) {
			media=media+notas.size();
		}
		media=media/notas.size();
		return media;
	}

	public int aprobados() {
		
		int aprobados=0;
		
		for(int i=0;i<notas.size();i++) {


			if(notas.get(i)>=5) {
				aprobados++;
			}

		}
		return aprobados;
		
	}
	
	public double notaMax() {
		
		double max=notas.get(0);
		for(int i=0;i<notas.size();i++) {
			
			max=Math.max(max, notas.get(i));


		}
		return max;
		
	}
	
	public double notaMin() {
		
		double min=notas.get(0);
		for(int i=0;i<notas.size();i++) {
			min=Math.min(min, notas.get(i));



		}
		return min;
		
		
	}
	
	public double[] notas() {
		double [] res=new double[notas.size()];
		for(int i=0;i<notas.size();i++) {
			res[i]=notas.get(i);
			
		}
			return res;
			
	}
	
	/*public ArrayList<Double>notas(){
		return notas;
	}
		
	public List<Double>notas(){
		return notas;
	}*/
	
	public void eliminarSuspenso() {
		
		double suspenso=notas.size();
		for(int i=0;i<notas.size();i++) {
		//si es suspenso la borramos
		if(notas.get(i)<5) {
			notas.remove(i);
			
		}
		
	}
		
}	
	public void subirNotas() {
		for(int i=0;i<notas.size();i++) {
			if(notas.get(i)<=9) {
				notas.set(i,notas.get(i)+1);
			}
		}
	}
}
