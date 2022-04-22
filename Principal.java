import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Collections;

public class Principal {
  public static void main(String[] args) {
    Principal.mostrarMenú();
  }
    
  public static void mostrarMenú() {
    Scanner teclado = new Scanner(System.in);
    int x;
        
    System.out.println("\f");
    System.out.println("***** Menú Principal *****\n");
    System.out.println("Elija una de las siguientes opciones");
    System.out.println("Ingrese 0 para detener la ejecución del programa");
    System.out.println("Ingrese 1 para añadir un nuevo Zombie a la base de datos");
    System.out.println("Ingrese 2 para ver la información de todos los zombies almacenados");
    System.out.println("Ingrese 3 para ver la cantidad de zombies almacenados");
    System.out.println("Ingrese 4 para ver la información de todos los zombies con tipo de sangre “O+” o “AB+");
    System.out.println("Ingrese 5 para ver la información de todos los zombies que nacieron después del 2000");
    System.out.println("Ingrese 6 para disminuir a la mitad la salud de todos los zombies");
    System.out.println("Ingrese 7 para añadir una nueva ubicación de Alexandria");
    System.out.println("Ingrese 8 para ver la información de todas las ubicaciones de Alexandria");
    System.out.println("Ingrese 9 para ver la ubicación más segura de Alexandria");
    System.out.println("Ingrese 10 para ver la información de todas las ubicaciones de Alexandria ordenadas desde la más cercana hasta la más lejana");
    System.out.println("Ingrese 11 para ver una frase aleatoria sobre zombies");
    System.out.println("Ingrese 12 para ver la ubicación más peligrosa");
      
    do {
      x = teclado.nextInt();
        if(x==0) {
          System.out.println("Programa finalizado");
          break;
        }
        
        else if(x==1) {
          System.out.println("Por favor ingrese el nombre del zombie:");
          String nom = teclado.next();
          System.out.println("Por favor ingrese el nivel de sangre del zombie:");
          double san = teclado.nextInt();
          System.out.println("Por favor ingrese la fecha de nacimiento (DD/MM/AAAA) del zombie:");
          String naci = teclado.next();
          System.out.println("Por favor ingrese el tipo de sangre del zombie:");
          String tipSan = teclado.next().toUpperCase();
        
          Zombie z1 = new Zombie (nom, san, naci, tipSan);
          Zombie.guardarZombie(z1);
        
          System.out.println("Zombie creado correctamente\n");
        }
        
        else if(x==2) {
          System.out.println("Imprimiendo información de todos los zombies:");   
          for (int i = 0; i < Zombie.bdZombies.size(); i++) {
            System.out.println("**** Zombie ****");
            System.out.println(Zombie.getAllZombies(i));       
          }
        }
        
        else if(x==3) {       
          System.out.println("La cantidad de zombies ingresados es: " + Zombie.cantidadZombies());       
        }
        
        else if(x==4) {
          if (Zombie.sangreZombies.size() == 0) {
            System.out.println("No existen zombies con tipo de sange O+ o AB+");   
          }
          else {
            System.out.println("Imprimiendo información de los zombies con tipo de sange O+ o AB+ :");
            for (int i = 0; i < Zombie.sangreZombies.size(); i++) {
              System.out.println("**** Zombie ****");
              System.out.println(Zombie.getSangreZombies(i));
            }
          }
        }
        
        else if(x==5) {
          System.out.println("Imprimiendo información de los zombies jovenes:");
          for (int i = 0; i < Zombie.fechaZombies.size(); i++) {
            System.out.println("**** Zombie ****");
            System.out.println(Zombie.getZombiesJovenes(i));       
          }
        }
        
        else if (x==6) {
          Zombie.disminuirSalud();
          System.out.println("Lanzamiento de misil exitoso... ¡Sufran malditos!\n");
        }
        
        else if (x==7) {
          System.out.println("Ingrese el nombre de la ubicación");
          String name = teclado.next();
          System.out.println("Ingrese la distancia a Alexandria");
          float dist = teclado.nextFloat();
          System.out.println("Ingrese la cantidad de Zombies que merodean alrededor");
          int quantZombies = teclado.nextInt();
          Ubicacion u = new Ubicacion(name, dist, quantZombies);
          Ubicacion.crearUbicacion(u);
        }
        
        else if (x==8) {
          for(Ubicacion object: Ubicacion.mostrarUbicaciones()) {
            System.out.println("**** Ubicación ****");
            System.out.println("Nombre: " + object.getName());
            System.out.println("Distancia de Alexandria:" + object.getDist());
            System.out.println("Cantidad de zombies merodeando: " + object.getQuant());
            System.out.println("");
          }
        }
        
        else if(x==9) {
          System.out.println("La ubicación más segura es: ");
          System.out.println(Ubicacion.ubicacionSegura());
        }
            
        else if(x==10) {
          Collections.sort(Ubicacion.mostrarUbicaciones());
          for(Ubicacion object: Ubicacion.mostrarUbicaciones()) {
            System.out.println("**** Ubicación ****");
            System.out.println("Nombre: " + object.getName());
            System.out.println("Distancia de Alexandria:" + object.getDist());
            System.out.println("Cantidad de zombies merodeando: " + object.getQuant());
            System.out.println("");
          }
        }
           
        else if (x==11){
          System.out.println(Zombie.mostrarFrase());
        }
            
        else if(x==12) {
          System.out.println("La ubicación más peligrosa es: ");
          System.out.println(Ubicacion.ubicacionPeligrosa());
        }

      System.out.println("Ingrese cualquier caracter para continuar...");
      teclado.next();
      System.out.println("\f");
      Principal.mostrarMenú();
    } while (x!=0 );
  }
}