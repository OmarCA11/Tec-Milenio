import java.util.Scanner;
import java.util.HashMap;
import java.util.Iterator;
import java.io.*;
/**
 *
 * @author omarc
 */
public class AddressBook {



    public static void main(String[] args) {



        HashMap<String, String> mapaCon = new HashMap<String, String>();
        Scanner leer = new Scanner(System.in);


        int opc, ban = 0;
        String telefono, nombre;
        System.out.println("**AGENDA TELEFONICA**\n");

        do
        {
            try{

                System.out.println("\nSeleccione la opción deseada:\n");
                System.out.println("CARGAR DATOS  -------------  [1]");
                System.out.println("GUARDAR DATOS -------------  [2]");
                System.out.println("MOSTRAR CONTACTOS ---------  [3]");
                System.out.println("NUEVO NUMERO  -------------  [4]");
                System.out.println("BORRAR CONTACTO -----------  [5]");
                System.out.println("SALIR  --------------------  [6]");

                opc = leer.nextInt();

                
                switch(opc)
                {
                    case 1:
                        load(mapaCon);
                        break;

                    case 2:
                        save(mapaCon);
                        break;

                    case 3:
                        list(mapaCon);
                        break;

                    case 4:

                        System.out.println("Inserte el nuevo telefono: ");
                        telefono = leer.next();
                        System.out.println("Inserte el nombre del contacto: ");
                        nombre = leer.next();
                        create(mapaCon,telefono,nombre);
                        break;
                    case 5:

                        System.out.println("Inserte el telefono a eliminar: ");
                        telefono = leer.next();

                        delete(mapaCon, telefono);
                        break;

                    case 6:
                        System.out.println("Saliendo\n");
                        ban = 1;
                        break;

                    default:
                        System.out.println("Opción incorrecta\n");
                        break;


                }
            }
            catch (Exception e)
            {
                System.out.println("ERROR !!\n");
                break;

            }
        }while(ban == 0);

    }


    public static void list(HashMap<String, String> mapaCon)
    {
        Iterator<String> iterator = mapaCon.keySet().iterator();

        System.out.println("Contactos:\n");
        System.out.println("  Telefono\t|\tNombre   ");
        System.out.println("------------------------");
        while(iterator.hasNext())
        {
            String llave = iterator.next();

            System.out.println("  "+llave+"\t|\t"+mapaCon.get(llave));
        }

    }


    public static void create(HashMap<String, String> mapaCon, String tel, String nom)
    {

        if(mapaCon.containsKey(tel))
        {
            System.out.println("\nError!\nNo se puede registrar dos veces el mismo telefono\n");
        }

        else
        {
            mapaCon.put(tel, nom);
            System.out.println("\nContacto agregado");
        }

    }


    public static void delete(HashMap<String, String> mapaCon, String tel)
    {
        if(mapaCon.containsKey(tel))
        {
            System.out.println("\nContacto eliminado: "+mapaCon.get(tel)+"\n");
            mapaCon.remove(tel);

        }
        else
            System.out.println("\nEl Telefono no existe\n");


    }


    public static void load(HashMap<String, String> m)
    {
        String inputFilename = "C:\\Users\\52222\\Documents\\NetBeansProjects\\AddressBook\\src\\main\\java\\islas\\addressbook\\input.csv";
        String a [];

        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(inputFilename));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                a = line.split(",");
                m.put(a[0],a[1]);
            }
        } catch(IOException e) {
            System.out.println("IOException catched while reading: " + e.getMessage());
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                    System.out.println("\nContactos cargados");
                }
            } catch (IOException e) {
                System.out.println("IOException catched while closing: " + e.getMessage());
            }
        }

    }


    public static void save(HashMap<String, String> m)
    {
        Iterator<String> iterator = m.keySet().iterator();
        String inputFilename = "C:\\Users\\52222\\Documents\\NetBeansProjects\\AddressBook\\src\\main\\java\\islas\\addressbook\\input.csv";

        BufferedWriter bufferedWriter = null;

        try {
            bufferedWriter = new BufferedWriter(new FileWriter(inputFilename));

            while(iterator.hasNext())
            {
                String llave = iterator.next();


                bufferedWriter.write(llave+","+m.get(llave)+"\n");
            }

        }
        catch(IOException e) {
            System.out.println("IOException catched while writing: " + e.getMessage());
        } finally {
            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                    System.out.println("\nCambios guardados");
                }
            } catch (IOException e) {
                System.out.println("IOException catched while closing: " + e.getMessage());
            }
        }
    }
}