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

    // ---------------------------------
    // ------- GETTERS + SETTERS -------
    // ---------------------------------

    public List<Prestec> getPrestecs() {
        return prestecs;
    }
}
