import java.util.ArrayList;
import java.util.List;
import java.text.Normalizer;

public class Biblioteca {

    // ---------------------------------
    // ---------- ATRIBUTOS ------------
    // ---------------------------------

    private List<Llibre> llibres;
    private List<Usuari> usuaris;

    // ---------------------------------
    // --------- CONSTRUCTOR -----------
    // ---------------------------------

    public Biblioteca() {
        this.llibres = new ArrayList<>();
        usuaris = new ArrayList<>();
    }

    // ---------------------------------
    // ---------- FUNCIONES ------------
    // ---------------------------------

    public void afegirLlibre(Llibre llibre) {
        llibres.add(llibre);
        System.out.println("Llibre afegit correctament.");
    }

    public void eliminarLlibre(int id) {
        Llibre llibreEliminar = null;

        for (Llibre llibre : llibres) {
            if (llibre.getId() == id) {
                llibreEliminar = llibre;
            }
        }

        if (llibreEliminar != null) {
            llibres.remove(llibreEliminar);
            System.out.println("Llibre eliminat correctament.");
        } else {
            System.out.println("No s'ha trobat el llibre.");
        }
    }

    private String normalitzarText(String text) {

        return Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    public Llibre buscarLlibre(String titol) {
        String titolNormalitzat = normalitzarText(titol);
        String llibreNormalitzat;
        for (Llibre llibre : llibres) {
            llibreNormalitzat = normalitzarText(llibre.getTitol());

            if (llibreNormalitzat.equalsIgnoreCase(titolNormalitzat)) {
                return llibre;
            }

        }
        return null;
    }

    public void llistarLlibres() {
        if (llibres.isEmpty()) {
            System.out.println("No hi ha llibres.");
        } else {
            for (Llibre llibre : llibres) {
                System.out.println(llibre);
            }
        }
    }


    public void afegirUsuari(Usuari usuari) {
        usuaris.add(usuari);
    }

    public void llistarUsuaris() {
        if (usuaris.isEmpty()) {
            System.out.println("No hi ha usuaris.");
        } else {
            for (Usuari usuari : usuaris) {
                System.out.println(usuari);
            }
        }
    }

    public Usuari buscarUsuari(String nom) {
        String nomNormalitzat = normalitzarText(nom);
        String usuariNormalitzat;

        for (Usuari usuari : usuaris) {
            usuariNormalitzat = normalitzarText(usuari.getNom());

            if (usuariNormalitzat.equalsIgnoreCase(nomNormalitzat)) {
                return usuari;
            }
        }
        return null;
    }

    public void eliminarUsuari(int id) {
        Usuari usuariEliminar = null;

        for (Usuari usuari : usuaris) {
            if (usuari.getId() == id) {
                usuariEliminar = usuari;
            }
        }

        if (usuariEliminar != null) {
            usuaris.remove(usuariEliminar);
            System.out.println("Usuari eliminat correctament.");
        } else {
            System.out.println("No s'ha trobat l'usuari.");
        }
    }


    public void llistarPerCategoria(String categoria) {
        boolean trobat = false;
        String categoriaNormalitzat = normalitzarText(categoria);
        String llibreNormalitzat;

        for (Llibre llibre : llibres) {
            llibreNormalitzat = normalitzarText(llibre.getCategoria());

            if (llibreNormalitzat.equalsIgnoreCase(categoriaNormalitzat)) {
                System.out.println(llibre);
                trobat = true;
            }
        }

        if (!trobat) {
            System.out.println("No hi ha llibres d'aquesta categoria.");
        }
    }

    public Llibre llibreMesPrestat() {
        if (llibres.isEmpty()) {
            return null;
        }

        Llibre mesPrestat = llibres.get(0);

        for (Llibre llibre : llibres) {
            if (llibre.getVegadesPrestat() > mesPrestat.getVegadesPrestat()) {
                mesPrestat = llibre;
            }
        }

        return mesPrestat;
    }

    public int totalPrestecsCategoria(String categoria) {
        int total = 0;
        String categoriaNormalitzat = normalitzarText(categoria);
        String llibreNormalitzat;

        for (Llibre llibre : llibres) {
            llibreNormalitzat = normalitzarText(llibre.getCategoria());
            if (llibreNormalitzat.equalsIgnoreCase(categoriaNormalitzat)) {
                total += llibre.getVegadesPrestat();
            }
        }

        return total;
    }

    // ---------------------------------
    // ------- GETTERS + SETTERS -------
    // ---------------------------------

    public List<Llibre> getLlibres() {
        return llibres;
    }

    public List<Usuari> getUsuaris() {
        return usuaris;
    }

}
