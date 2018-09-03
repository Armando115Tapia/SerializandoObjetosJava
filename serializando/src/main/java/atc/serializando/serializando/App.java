package atc.serializando.serializando;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
         ArrayList< Empleado>empleados = new ArrayList<Empleado>();
         Empleado emp1 = new Empleado("Armando", 1400);
         empleados.add(emp1);
         
         Empleado emp2 = new Empleado("Juan", 400);
         empleados.add(emp2);
         
         Empleado emp3 = new Empleado("Pedrito", 400);
         empleados.add(emp3);
         
         
         /**
          * Para serializar necesitamos 
          * ObjectOutputStream 
          * */
         ObjectOutputStream escribiendo_fichero = null;
         ObjectInputStream recuperando_Fichero=null;
         try {
        	 
        	 //Con este codigo sale el flujo de datos
        	 escribiendo_fichero = new ObjectOutputStream(new FileOutputStream("C:\\Users\\atc\\Documents\\Libres\\JavaDocumentos\\bytes.txt"));
        	 escribiendo_fichero.writeObject(empleados);
        	 escribiendo_fichero.close();
        	 
        	 //con este codigo entra el flujo de datos
        	 recuperando_Fichero= new ObjectInputStream(new FileInputStream("C:\\Users\\atc\\Documents\\Libres\\JavaDocumentos\\bytes.txt"));
        	 ArrayList<Empleado> personal_recuperado = (ArrayList<Empleado>)recuperando_Fichero.readObject();
        	 recuperando_Fichero.close();
        	 
        	 for(int i=0;i<personal_recuperado.size();i++) {
        		 System.out.println("Personal recuperado " + i +" es: " +personal_recuperado.get(i).getNombre());
        		 
        	 }
        	 
         }catch(Exception e) {
        	 
        	 
         }finally {
            escribiendo_fichero.close();
        	recuperando_Fichero.close();
         }
         
         
         
    
    }
    
}




class Empleado implements Serializable{
	
	private String nombre;
	private double sueldo;
	public Empleado(String nombre, double sueldo) {
		super();
		this.nombre = nombre;
		this.sueldo = sueldo;
	
	}

    public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getSueldo() {
		return sueldo;
	}
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
}
