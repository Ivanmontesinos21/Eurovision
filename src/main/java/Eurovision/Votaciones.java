package Eurovision;

import java.util.*;

public class Votaciones {
    public static void main(String[] args) {
        List<Pais>paises=anyadirPaises();

      simularVotos(paises);
//       listarPaisesParticipantes(paises);
   //    listarPaisesPorOrdenAlfabeticoConLosVotosRecibidos(paises);
//   cancionesOrdenadasPorNombre(paises);
//        top3CancionesMasVotadas(paises);
        cantantesOrdenadosPorNombre(paises);






    }

    List<Pais> paises;

    public Votaciones() {
        paises = new ArrayList<>();
    }

    public static List<Pais>  anyadirPaises() {
        List<Pais> paises = new ArrayList<>();
        paises.add(new Pais("Francia", "Slimane", "Mon Amour"));
        paises.add(new Pais("Eslovenia", "Raiven", "Veronika"));
        paises.add(new Pais("España", "Nebulossa", "Chikilicuatre"));
        paises.add(new Pais("Suecia", "Suecos", "Himno de suecia"));
        paises.add(new Pais("Israel", "Israelis", "Himno de Israel"));
        paises.add(new Pais("Italia", "Italianos", "Himno de Italia"));
        paises.add(new Pais("Estonia", "Estonio", "Himno de Estonia"));
        paises.add(new Pais("Australia", "Australianos", "Himno de Australia"));
        paises.add(new Pais("Belgica", "Belgas", "Himno de Belgica"));
        paises.add(new Pais("Austria", "Austriacos", "Himno de Austria"));
        paises.add(new Pais("Republica Checa", "Checos", "Himno de la republica Checa"));
        paises.add(new Pais("Finlandia", "Finlandeses", "Himno de Finlandia"));
        paises.add(new Pais("Lituania", "Lituanos", "Himno de Lituania"));
        paises.add(new Pais("Armenia", "Armenios", "Himno de Armenia"));
        paises.add(new Pais("Chipre", "Chipriotas", "Himno de Chipre"));
        paises.add(new Pais("Suiza", "Suizos", "Himno de Suiza"));
        paises.add(new Pais("Ucrania", "Ucranianos", "Himno de Ucrania"));
        paises.add(new Pais("Noruega", "Noruegos", "Himno de Noruega"));
        paises.add(new Pais("Portugal", "Portugueses", "Himno de Portugal"));
        paises.add(new Pais("Moldavia", "Moldaveses", "Himno de Moldavia"));
        paises.add(new Pais("Albania", "Albaneses", "Himno Albania"));
        paises.add(new Pais("Serbia", "Serbios", "Himno de Serbia"));
        paises.add(new Pais("Polonia", "Polacos", "Himno de Polonia"));
        paises.add(new Pais("Croacia", "Croatas", "Himno de Croacia"));
        paises.add(new Pais("Alemania", "Alemanos", "Himno de Alemania"));




        return paises;
    }

    //Simular Votos
    public static void simularVotos(List<Pais>paises) {
        for (Pais pais : paises) {
            List<Pais> paisesVotados = new ArrayList<>(paises);
            paisesVotados.remove(pais);
            Collections.shuffle(paisesVotados);
        int numVotos= Math.min(paisesVotados.size(), 10);
            for (int i = 0; i < numVotos; i++) {
                Pais paisVotado = paisesVotados.get(i);
                int puntos = 12 - i;
                pais.agregarVoto(paisVotado.nombre, puntos);


            }

        }


    }

    public static void listarPaisesParticipantes(List<Pais> paises) {
        for (Pais pais : paises) {
            System.out.println(pais.nombre);
        }
        System.out.println();

    }

    public static void listarPaisesPorOrdenAlfabeticoConLosVotosRecibidos(List<Pais> paises) {
        paises.sort(Comparator.comparing(p -> p.nombre));
        for (Pais pais : paises) {
            System.out.println(pais.nombre + ":" + pais.votos);
        }
        System.out.println();

    }
    public static void cancionesOrdenadasPorNombre(List<Pais> paises) {
        List<String> canciones = new ArrayList<>();
        for (Pais pais : paises) {
            canciones.add(pais.cancion);
        }
        Collections.sort(canciones);
        for (String cancion : canciones) {
            System.out.println(cancion);
        }
        System.out.println();
    }
    public static void top3CancionesMasVotadas(List<Pais> paises){
        List<Pais>copiarPaises=new ArrayList<>(paises);
        copiarPaises.sort(Comparator.comparingInt(Pais::getPuntuacionTotal).reversed());
        int count=0;
        Iterator<Pais>iterator= copiarPaises.iterator();
        while (iterator.hasNext()&& count<3) {
            Pais pais = iterator.next();
            System.out.println(pais.cancion+":" + pais.getPuntuacionTotal() + " puntos ");
            count++;
        }

        }
        public static void cantantesOrdenadosPorNombre(List<Pais>paises){
        List<String>participantes=new ArrayList<>();
        for (Pais pais:paises) {
            participantes.add(pais.participante);
        }
            Collections.sort(participantes);
            for (String participante:participantes){
                System.out.println(participante);
            }
            System.out.println();
        }
        }


