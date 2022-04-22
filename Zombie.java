import java.util.ArrayList;

public class Zombie {
  private String nombre;
  private double salud;
  private String nacimiento;
  private String tipoSangre;
  public static ArrayList<Zombie> bdZombies = new ArrayList();
  public static ArrayList<Zombie> sangreZombies = new ArrayList();
  public static ArrayList<Zombie> fechaZombies = new ArrayList();

    public Zombie(String nom, double sal, String naci, String tipSan) {
      this.nombre = nom;
      this.salud = sal;
      this.nacimiento = naci;
      this.tipoSangre = tipSan;
    }

    public String getNombre() {
      return this.nombre;
    }
    
    public double getSalud() {
      return this.salud;
    }

    public String getNacimiento() {
      return this.nacimiento;
    }

    public String getTipoSangre() {
      return this.tipoSangre;
    }

    public void setNombre(String nom) {
      this.nombre = nom;
    }

    public void setSalud(double sal) {
      this.salud = sal;
    }
    
    public void setNacimiento(String naci) {
      this.nacimiento = naci;
    }

    public void setTipoSangre(String tipSan) {
      this.tipoSangre = tipSan;
    }
    
    public static String getAllZombies(int i) { 
      return "Nombre: " + bdZombies.get(i).getNombre() + 
             "\nSalud : " + bdZombies.get(i).getSalud() + 
             "\nNacimiento : " + bdZombies.get(i).getNacimiento() + 
             "\nTipo de Sagre :" + bdZombies.get(i).getTipoSangre()+ "\n";
    }
    
    public static String getSangreZombies(int i) {
      return "Nombre: " + sangreZombies.get(i).getNombre() + 
             "\nSalud : " + sangreZombies.get(i).getSalud() + 
             "\nNacimiento : " + sangreZombies.get(i).getNacimiento() + 
             "\nTipo de Sagre :" + sangreZombies.get(i).getTipoSangre() + "\n";
    }
    
    public static String getZombiesJovenes(int i) {
      return "Nombre: " + fechaZombies.get(i).getNombre() + 
             "\nSalud : " + fechaZombies.get(i).getSalud() + 
             "\nNacimiento : " + fechaZombies.get(i).getNacimiento() + 
             "\nTipo de Sagre :" + fechaZombies.get(i).getTipoSangre() + "\n";
    }
    
    public static void guardarZombie(Zombie z) {
      bdZombies.add(z);
        if(z.getTipoSangre().equals("AB+") || z.getTipoSangre().equals("O+")) { 
          sangreZombies.add(z);
        }
       
        if(Integer.parseInt(z.getNacimiento().substring(6))> 2000) {
          fechaZombies.add(z);
        }
    }

    public static ArrayList<Zombie> mostrarZombies() {
      return bdZombies;
    }
    
    public static int cantidadZombies() {
      return bdZombies.size();
    }
    
    public static ArrayList<Zombie> mostrarSangre() {
      return sangreZombies;
    }
    
    public static void disminuirSalud() {
      for(int i = 0; i<bdZombies.size(); i++) {
        bdZombies.get(i).setSalud(bdZombies.get(i).getSalud() / 2);
      }
    }
    
    public static String mostrarFrase() {
      int numero = (int)(Math.random()*5+1);
        switch(numero) {
          case 1:
            return "Cuando los muertos echan a andar, ¿para qué obstinarse en matarlos? No hay forma de vencerlos";
          case 2:
            return "Cada ser humano que salvamos es un Zombie menos por combatir";
          case 3:
            return "Viven para la noche, viven para matar, y ... viven siempre";
          case 4:
            return "¡Odio los Zombies, nunca juegan limpio!";
          case 5:
            return "Cuando ya no quede sitio en el infierno, los muertos caminarán por la tierra";
        }
      return "Preguntarse: ¿Es mi casa un lugar seguro en caso de una invasión zombie?";
    }
}