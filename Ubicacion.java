import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.Random;
import java.util.ArrayList;

public class Ubicacion implements Comparable<Ubicacion> {
  static ArrayList<Ubicacion> locations = new ArrayList<>();
  private String name;
  private float distAlex;
  private int quantZombies;
  
    public Ubicacion(String name, float distAlex, int quantZombies) {
      this.name=name;
      this.distAlex=distAlex;
      this.quantZombies=quantZombies;
    }
    
    public String getName() {
      return this.name;
    }
    
    public float getDist() {
      return this.distAlex;
    }
    
    public int getQuant() {
      return this.quantZombies;
    }
    
    public void setName(String nam) {
      this.name = nam;
    }
    
    public void setDist(float dist) {
      this.distAlex = dist;
    }
    
    public void setQuant(int quant) {
      this.quantZombies = quant;
    }

    public static ArrayList<Ubicacion> mostrarUbicaciones() {
      return locations;
    }
    
    public static void crearUbicacion(Ubicacion u) {
      locations.add(u);
    }
    
    public static void setUbicaciones(ArrayList<Ubicacion> locations_) {
      locations = locations_;
    }
    
    public static Ubicacion ubicacionSegura() {
      Ubicacion ubiSegura = null;
      int minQuant = Integer.MAX_VALUE;
      for(Ubicacion ubicacion : locations) {
        if(ubicacion.getQuant() < minQuant) {
          minQuant=ubicacion.getQuant();
          ubiSegura=ubicacion;
        }
      }
      return ubiSegura;
    }
    
    public int compareTo(Ubicacion u){
      if(u.getDist()>distAlex) {
        return -1;
      }
      else if(u.getDist()==distAlex) {
        return 0;
      }
      else {
        return 1;
      }
    }
    
    public String toString() {
      return "Nombre: " + name + "\n" +
             "Distancia a Alexandria: " + distAlex + "\n" + 
             "Cantidad de Zombies: " + quantZombies + "\n";
    }
    
  
    public static Ubicacion ubicacionPeligrosa() {
      Ubicacion ubiPeligrosa = null;
      int maxQuant = -1;
      for(Ubicacion ubicacion : locations) {
        if(ubicacion.getQuant() > maxQuant) {
          maxQuant=ubicacion.getQuant();
          ubiPeligrosa=ubicacion;
        }
      }
      return ubiPeligrosa;
    }
}