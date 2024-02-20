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


        Pais.listarPaisesParticipantes(paises);
        System.out.println(paises);
      Pais.ordenarPaisesPorPuntuacionRecibida(paises);
        Pais.listarPaisesPorVotacionesOrdenadas(paises);
      Pais.mostrarPaisGanador(paises);

        Pais.top3CancionesMasVotadas(paises);
        Pais.cancionesOrdenadasPorNombre(paises);
        Pais.cantantesOrdenadosPorNombre(paises);


    }



}
