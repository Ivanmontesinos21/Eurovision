package Eurovision;

import java.util.HashMap;
import java.util.Map;

public class Pais {
    String nombre;
    String participante;
    String cancion;
    Map<String,Integer>votos;

    public Pais(String nombre, String participante, String cancion) {
        this.nombre = nombre;
        this.participante = participante;
        this.cancion = cancion;
        votos=new HashMap<>();
    }
    public void agregarVoto(String paisVotado,int puntos){
        votos.put(paisVotado,puntos);
    }
    public int getPuntuacionTotal(){
        return votos.values().stream().mapToInt(Integer::intValue).sum();
    }

    @Override
    public String toString() {
        return nombre +" - " + getPuntuacionTotal() + " puntos" +"\n";
    }
}
