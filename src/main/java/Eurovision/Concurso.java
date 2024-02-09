package Eurovision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Concurso {
    public static void main(String[] args) {
        List<Pais> paises=Pais.crearListaPaises();
     Pais.simularVotaciones(paises);
        System.out.println(paises);
        System.out.println();
        Pais.ordenarPaisesPorPuntuacionRecibida(paises);

//        Pais.listarPaisesParticipantes(paises);
//        System.out.println(paises);
//      Pais.ordenarPaisesPorPuntuacionRecibida(paises);
//        System.out.println(paises);
//        Pais.cantantesOrdenadosPorNombre(paises);
//        System.out.println(paises);
//        Pais.cancionesOrdenadasPorNombre(paises);
//        encontrarGanador(paises);
//        System.out.println(paises);
//        System.out.println(encontrarGanador(paises));
//        Pais.top3CancionesMasVotadas(paises);
//        Pais.cancionesOrdenadasPorNombre(paises);
//        Pais.cantantesOrdenadosPorNombre(paises);


    }
    public static Pais encontrarGanador(List<Pais> paises) {
        Pais ganador = null;
        int puntosMaximo = 0;
        for (Pais pais : paises) {
            int puntosTotales = pais.getPuntuacionTotal();
            if (puntosTotales > puntosMaximo) {
                puntosMaximo = puntosTotales;
                ganador = pais;


            }

        }
        return ganador;
    }


}
