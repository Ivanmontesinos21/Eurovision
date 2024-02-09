package Eurovision;

import java.util.*;

public class Pais {
    String nombre;
    String participante;
    String cancion;
    Map<Pais, Integer> votos;

    public Pais(String nombre, String participante, String cancion) {
        this.nombre = nombre;
        this.participante = participante;
        this.cancion = cancion;
        votos = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getParticipante() {
        return participante;
    }

    public String getCancion() {
        return cancion;
    }

    public Map<Pais, Integer> getVotos() {
        return votos;
    }

    public void agregarVoto(Pais paisVotado, int puntos) {
        votos.put(paisVotado, puntos);
    }

    public int getPuntuacionTotal() {
        int puntosTotales = 0;
        for (int puntaje : votos.values()) {
            puntosTotales += puntaje;
        }
        return puntosTotales;
    }


    @Override
    public String toString() {
        return  nombre + " ha recibido la cantidad de  " + getPuntuacionTotal() + " puntos" + "\n";
    }


    public static List<Pais> crearListaPaises() {
        List<Pais> paises = new ArrayList<>();
        agregarPais(paises, new Pais("Suecia", "ArtistaSuecia", "CancionSuecia"));
        agregarPais(paises, new Pais("Israel", "ArtistaIsrael", "CancionIsrael"));
        agregarPais(paises, new Pais("Italia", "ArtistaItalia", "CancionItalia"));
        agregarPais(paises, new Pais("Finlandia", "ArtistaFinlandia", "CancionFinlandia"));
        agregarPais(paises, new Pais("Estonia", "ArtistaEstonia", "CancionEstonia"));
        agregarPais(paises, new Pais("Australia", "ArtistaAustralia", "CancionAustralia"));
        agregarPais(paises, new Pais("Bélgica", "ArtistaBélgica", "CancionBélgica"));
        agregarPais(paises, new Pais("Austria", "ArtistaAustria", "CancionAustria"));
        agregarPais(paises, new Pais("España", "ArtistaEspaña", "CancionEspaña"));
        agregarPais(paises, new Pais("Republica Checa", "ArtistaRepCheca", "CancionRepCheca"));
        agregarPais(paises, new Pais("Lituania", "ArtistaLituania", "CancionLituania"));
        agregarPais(paises, new Pais("Armenia", "ArtistaArmenia", "CancionArmenia"));
        agregarPais(paises, new Pais("Chipre", "ArtistaChipre", "CancionChipre"));
        agregarPais(paises, new Pais("Suiza", "ArtistaSuiza", "CancionSuiza"));
        agregarPais(paises, new Pais("Ucrania", "ArtistaUcrania", "CancionUcrania"));
        agregarPais(paises, new Pais("Francia", "ArtistaFrancia", "CancionFrancia"));
        agregarPais(paises, new Pais("Noruega", "ArtistaNoruega", "CancionNoruega"));
        agregarPais(paises, new Pais("Portugal", "ArtistaPortugal", "CancionPortugal"));
        agregarPais(paises, new Pais("Eslovenia", "ArtistaEslovenia", "CancionEslovenia"));
        agregarPais(paises, new Pais("Moldavia", "ArtistaMoldavia", "CancionMoldavia"));
        agregarPais(paises, new Pais("Albania", "ArtistaAlbania", "CancionAlbania"));
        agregarPais(paises, new Pais("Reino Unido", "ArtistaReinoUnido", "CancionReinoUnido"));
        agregarPais(paises, new Pais("Serbia", "ArtistaSerbia", "CancionSerbia"));
        agregarPais(paises, new Pais("Polonia", "ArtistaPolonia", "CancionPolonia"));
        agregarPais(paises, new Pais("Croacia", "ArtistaCroacia", "CancionCroacia"));
        agregarPais(paises, new Pais("Alemania", "ArtistaAlemania", "CancionAlemania"));
        return paises;
    }

    public static void agregarPais(List<Pais> paises, Pais pais) {
        if (!paises.contains(pais)) {
            paises.add(pais);
        }
    }
    public static void simularVotaciones(List<Pais> paises) {
        for (Pais pais : paises) {
            List<Pais> paisesVotados = new ArrayList<>(paises);
            paisesVotados.remove(pais);
            Collections.shuffle(paisesVotados);

            List<Integer> puntajes = generarPuntos();
            int index = 0;
            for (int i = 0; i < 8; i++) {
                Pais paisVotado = paisesVotados.get(i);
                int puntos = puntajes.get(index);
                pais.agregarVoto(paisVotado, puntos);
                index = (index + 1) / puntajes.size();
            }

            pais.agregarVoto(paisesVotados.get(8), 10);
            pais.agregarVoto(paisesVotados.get(9), 12);
        }
    }

    public static List<Integer> generarPuntos() {
        List<Integer> puntajes = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            puntajes.add(i);
        }
        Collections.shuffle(puntajes);
        return puntajes;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (!(obj instanceof Pais))
            return false;
        Pais pais = (Pais) obj;
        return nombre.equals(pais.nombre);
    }

    @Override
    public int hashCode() {
        return nombre.hashCode();
    }

    public static void listarPaisesParticipantes(List<Pais> paises) {
        System.out.println("Listado de Paises Participantes:");
        for (Pais pais : paises) {
            System.out.println(pais.nombre);
        }
        System.out.println();

    }

    public static void cantantesOrdenadosPorNombre(List<Pais> paises) {
        List<String> participantes = new ArrayList<>();
        for (Pais pais : paises) {
            participantes.add(pais.participante);
        }
        Collections.sort(participantes);
        System.out.println("Listado de cantantes ordenados por nombre:");
        for (String participante : participantes) {

            System.out.println(participante);
        }
        System.out.println();
    }

    public static void top3CancionesMasVotadas(List<Pais> paises) {
        List<Pais> copiarPaises = new ArrayList<>(paises);
        copiarPaises.sort(Comparator.comparingInt(Pais::getPuntuacionTotal).reversed());
        int count = 0;
        Iterator<Pais> iterator = copiarPaises.iterator();
        System.out.println("Listado de las 3 canciones más votadas:");
        while (iterator.hasNext() && count < 3) {
            Pais pais = iterator.next();

            System.out.println(pais.cancion + ":" + pais.getPuntuacionTotal() + " puntos ");
            count++;
        }


    }
    public static void  ordenarPaisesPorPuntuacionRecibida(List<Pais> paises) {
        List<Pais> paisesOrdenados = new ArrayList<>(paises);
        Collections.sort(paisesOrdenados, (p1, p2) -> Integer.compare(p2.getPuntuacionTotal(), p1.getPuntuacionTotal()));
        System.out.println("Listado de los países ordenados por puntuaciones recibidas:");
        for (Pais pais : paisesOrdenados) {
            System.out.println("- " + pais.nombre + ": " + pais.getPuntuacionTotal() + " puntos");
        }
    }


    public static void cancionesOrdenadasPorNombre(List<Pais> paises) {
        List<String> canciones = new ArrayList<>();
        for (Pais pais : paises) {
            canciones.add(pais.cancion);
        }
        Collections.sort(canciones);
        System.out.println("Listado de Canciones ordenadas por nombre: ");
        for (String cancion : canciones) {

            System.out.println(cancion);
        }
        System.out.println();
    }




}

