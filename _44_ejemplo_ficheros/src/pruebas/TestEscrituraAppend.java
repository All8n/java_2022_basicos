package pruebas;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class TestEscrituraAppend {

	public static void main(String[] args) {

		String ruta="c:\\Ficheros\\productos.txt";
		PrintStream out=null;
		FileOutputStream fos=null;

		try {
			fos=new FileOutputStream(ruta, true);
			out=new PrintStream(fos);

			out.println("cerveza");
			out.println("pan");
			out.println("comida");

		}
		catch(FileNotFoundException ex) {
			ex.printStackTrace();
		}
		finally {
			if(out!=null) {
				out.close();

			}
			if(fos!=null) {
				try {
					fos.close();
				}
				catch(IOException ex) {
					ex.printStackTrace();

				}
			}
		}



	}

}
