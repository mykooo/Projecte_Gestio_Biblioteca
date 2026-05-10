import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class GestorBiblioteca {

    // ---------------------------------
    // ---------- ATRIBUTOS ------------
    // ---------------------------------

    private List<Prestec> prestecs;

    // ---------------------------------
    // --------- CONSTRUCTOR -----------
    // ---------------------------------

    public GestorBiblioteca() {
        this.prestecs = new ArrayList<>();
    }

    // ---------------------------------
    // ---------- FUNCIONES ------------
    // ---------------------------------

    public void prestarLlibre(Usuari usuari, Llibre llibre) {
        if (usuari.getLlibresPrestats().size() >= Prestec.MAX_LLIBRES) {
            System.out.println("L'usuari ha arribat al límit de llibres.");
            return;
        } else {
            if (!llibre.disponible()) {
                System.out.println("Aquest llibre no està disponible.");
                return;
            } else {
                llibre.prestar();

                Prestec prestec = new Prestec(usuari, llibre, LocalDate.now());

                prestecs.add(prestec);

                usuari.afegirLlibre(llibre);

                usuari.afegirPrestecHistorial(prestec);
                System.out.println(usuari.getNom() + " ha agafat el llibre: " + llibre.getTitol());
            }
        }
    }

    public void retornarLlibre(Usuari usuari, Llibre llibre) {
        if (!usuari.getLlibresPrestats().contains(llibre)) {
            System.out.println("Aquest usuari no té aquest llibre prestat.");
        } else {
            usuari.retornarLlibre(llibre);
            llibre.retornar();

            Prestec prestecRetornat = null;

            for (Prestec prestec : prestecs) {
                if (prestec.getUsuari() == usuari && prestec.getLlibre() == llibre) {
                    prestecRetornat = prestec;
                }
            }

            if (prestecRetornat != null) {
                prestecs.remove(prestecRetornat);
            }

            System.out.println("Llibre retornat correctament.");
        }
    }

    public void mostrarPrestecs() {
        if (prestecs.isEmpty()) {
            System.out.println("No hi ha préstecs.");
        } else {
            for (Prestec prestec : prestecs) {
                System.out.println(prestec);
            }
        }
    }

    public void mostrarPrestecsUsuari(Usuari usuari) {
        usuari.mostrarHistorial();
    }

    public void mostrarPrestecsRetardats() {
        boolean trobat = false;

        for (Prestec prestec : prestecs) {
            if (prestec.estaRetardat()) {
                System.out.println(prestec);
                trobat = true;
            }
        }

        if (!trobat) {
            System.out.println("No hi ha préstecs retardats.");
        }
    }


    // ---------------------------------
    // ------- GETTERS + SETTERS -------
    // ---------------------------------

    public List<Prestec> getPrestecs() {
        return prestecs;
    }
}
