import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Random;

public class Deck {

    public static void main(String[] args)
    {
        Card card = new Card();
        int PALOS = card.palo.length;
        int VALORES = card.valor.length;
        int opc = 0;
        int ban = 0;

        Scanner leer = new Scanner(System.in);


        ArrayList<String> deck = new ArrayList<String>();

        for (int i = 0; i < VALORES ; i++)
        {
            for (int j = 0; j < PALOS; j++)
            {

                if (card.palo[j].equals("Corazon")  || card.palo[j].equals("Diamante"))
                    deck.add(card.palo[j]+ card.color[0] + card.valor[i]);

                else if(card.palo[j].equals("Trebol")|| card.palo[j].equals("Pica"))
                    deck.add(card.palo[j]+ card.color[1] + card.valor[i]);
            }
        }


        Iterator<String> nombreIterator = deck.iterator();
        while(nombreIterator.hasNext()){
            String elemento = nombreIterator.next();
            System.out.print(elemento+" | ");
        }

        /*System.out.println("\n cartas : ");   pruebas para conocer los valores con los que trabajamos
        System.out.println(deck.size());
        System.out.println("palos: ");
        System.out.println(PALOS);
        System.out.println("Valores: ");
        System.out.println(VALORES);
        System.out.println("colores: ");
        System.out.println(COLORES);*/


        System.out.println("\n** Bienvenido al sistema de Pocker**\n");

        do
        {
            try{

                System.out.println("\nSeleccione la opción deseada:\n");
                System.out.println("MEZCLAR DECK  -------------  [1]");
                System.out.println("TOMAR LA PRIMERA CARTA ----  [2]");
                System.out.println("TOMAR UNA CARTA ALEATORIA -  [3]");
                System.out.println("TOMAR 5 CARTAS  -----------  [4]");
                System.out.println("SALIR ---------------------  [5]");

                opc = leer.nextInt();


                switch(opc)
                {
                    case 1:
                        shuffle(deck);
                        break;

                    case 2:
                        head(deck);
                        break;

                    case 3:
                        pick(deck);
                        break;

                    case 4:
                        if(deck.size()>= 5)
                            hand(deck);

                        else
                            System.out.println("No quedan cartas suficientes. Seleccione otra opcion\n");
                        break;

                    case 5:
                        System.out.println("Saliendo\n");
                        ban = 1;
                        break;

                    default:
                        System.out.println("Opción incorrecta\n");
                        break;


                }

                if(deck.size() == 0){
                    System.out.println("\n<<Se terminaron las cartas>>\n");
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



    public static void shuffle(ArrayList deck){
        ArrayList<String> values = deck;
        Collections.shuffle(values);
        System.out.println("\n Se mezcló el Deck.");
        Iterator<String> nombreIterator2 = deck.iterator();
        while(nombreIterator2.hasNext()){
            String elemento = nombreIterator2.next();
            System.out.print(elemento+" | ");
        }
    }


    public static void head(ArrayList deck){
        System.out.println(deck.get(0));
        deck.remove(0);
        System.out.println("Quedan " + deck.size() + " cartas \n");
    }


    public static void pick(ArrayList  deck){
        Random aleatorio = new Random();
        System.out.println(deck.get(aleatorio.nextInt(deck.size())));
        deck.remove(aleatorio.nextInt(deck.size()));
        System.out.println("Quedan " + deck.size() + " cartas \n");
    }


    public static void hand(ArrayList deck){
        for(int i=0; i<=4; i++){
            System.out.println(deck.get(i));
        }
        for(int i=0; i<=4; i++){
            deck.remove(i);
        }
        System.out.println("Quedan " + deck.size()+ " cartas");
    }
}