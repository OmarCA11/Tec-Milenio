package xd;


import java.util.Scanner;

/**
 *
 * @author omarc
 */
public class Promedio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        String nombre, cal;             
        int i;                          
        float a;                        
        float calif[] = new float [5];  
        System.out.println("*** Bienvenido *** \n");
        System.out.println("Introduce el nombre del alumno: ");        
        Scanner in = new Scanner(System.in);
        
        
        nombre = in.nextLine();
        
        
        for(i = 0; i<5; i++)
        {
            System.out.println("Ingresa la calificacion de la materia "+(i+1));
            calif[i] = in.nextFloat();
        }
        
        
        a = prom(calif);        
        cal = Calf(a);                  
        MostrarR(nombre,calif,a,cal);
        
    }
    
    static float prom(float lista[])   
    {
        
        float pro;
        int i;
        float sum = 0;
            
        for(i=0;i<5;i++)
        {
            sum = sum + lista[i];
        }
        
        pro = sum/5;
        return pro;
    }
    
    
    static String Calf(float promedio)
    {
        
        String cal = null;
        
        if (promedio <= 5)
                cal = "F";
        else if (promedio <= 6 && promedio > 5)
                cal = "E";
        else if (promedio <= 7 && promedio > 6)
                cal = "D";
        else if (promedio <= 8 && promedio > 7)
                cal = "C";
        else if (promedio <= 9 && promedio > 8)
                cal = "B";
        else if (promedio <= 10 && promedio > 9)
                cal = "A";
        
        return cal;
    }   
    
  
    static void MostrarR(String nombre,float grades[],float promedio,String Cfinal) 
    {                                                                               
        int i;
        
        System.out.println("\n ****Resultados****\n");
        System.out.println("Nombre: "+nombre);
        System.out.println("------------------------------");
        System.out.println("\nCalificaciones individuales");
        
        for(i=0;i<5;i++)
        {
            System.out.println("\nMateria "+(i+1)+" : "+grades[i]);
        }
        System.out.println("------------------------------");
        System.out.println("\nPromedio: "+promedio);
        System.out.println("------------------------------");
        System.out.println("\nCalificacion: "+Cfinal);
    }
}