import java.util.ArrayList;
import java.util.List;

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

    public Llibre buscarLlibre(String titol) {
        for (Llibre llibre : llibres) {
            if (llibre.getTitol().equalsIgnoreCase(titol)) {
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
        for (Usuari usuari : usuaris) {
            if (usuari.getNom().equalsIgnoreCase(nom)) {
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
