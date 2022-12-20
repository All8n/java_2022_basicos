package principal;

import java.util.Arrays;

public class Loteria {

	//generar convinacion de loteria primitiva( 6 numeros aleatorios no repetidos entre 1 y 49)
	public static void main(String[] args) {

		int [] combinacion=new int [6];
		int contador=0;//lleva la cuenta de los numeros validos generados
		int numeroGenerado;

		while(contador<6) {

			numeroGenerado=(int)(Math.random()*49+1);

			if(!repetido(numeroGenerado,combinacion,contador)) {
				combinacion[contador]=numeroGenerado;//añadimos el numero en la posicion que le corresponde en el array	
				contador++;

			}


		}		//al finalizar while,tenemos todos los numeros en el array

		ordenar(combinacion);
		imprimir(combinacion);

	}

	static boolean repetido(int numero, int[] array, int cont) {

		boolean res=false;
		for(int i=0;i<cont;i++) {//recorremos el array  hasta la ultima posicion ocupada
			
			if(array[i]==numero) {
				res=true;
				break;//si encontramos el numero dentro del array, abandonamos el for
				
			}
		}
		return res;
		
	}
		
	static void ordenar(int[] array) {
		//metodo de la burbuja
		
		int aux;
		
		for(int i=0;i<array.length;i++) {//recorre cada numero
			for(int k=i+1;k<array.length;k++) {//recorre los siguientes a cada numero para la comparacion
				if(array[k]<array[i]) {//intercambia las posiciones	
					aux=array[k];
					array[k]=array[i];
					array[i]=aux;
					
				}
			}
		}
		//opcion 2, con metodo sort
		Arrays.sort(array);
	}
	static void imprimir(int[] array) {
		for(int num:array) {
			System.out.println(num);
		}
	}
}
