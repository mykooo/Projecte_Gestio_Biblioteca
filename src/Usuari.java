import java.util.ArrayList;
import java.util.List;

public class Usuari {

    // ---------------------------------
    // ---------- ATRIBUTOS ------------
    // ---------------------------------

    private static int contadorId = 1;
    private int id;
    private String nom;
    private List<Llibre> llibresPrestats;
    private List<Prestec> historialPrestecs;


    // ---------------------------------
    // --------- CONSTRUCTOR -----------
    // ---------------------------------

    public Usuari(String nom) {
        this.nom = nom;
        this.llibresPrestats = new ArrayList<>();
        this.historialPrestecs = new ArrayList<>();
        this.id = contadorId++;
    }

    // ---------------------------------
    // ---------- FUNCIONES ------------
    // ---------------------------------

    public void afegirLlibre(Llibre llibre) {
        llibresPrestats.add(llibre);
    }

    public void afegirPrestecHistorial(Prestec prestec) {
        historialPrestecs.add(prestec);
    }


    public void retornarLlibre(Llibre llibre) {
        llibresPrestats.remove(llibre);
    }

    public void mostrarHistorial() {
        if (historialPrestecs.isEmpty()) {
            System.out.println("Aquest usuari no té préstecs.");
        } else {
            for (Prestec prestec : historialPrestecs) {
                System.out.println(prestec);
            }
        }
    }

    public int quantitatPrestecs() {
        return historialPrestecs.size();
    }

    @Override
    public String toString() {

        return "\n----- USUARI -----" +
                "\nID: " + id +
                "\nNom: " + nom +
                "\nLlibres prestats: " +
                llibresPrestats.size();
    }

    // ---------------------------------
    // ------- GETTERS + SETTERS -------
    // ---------------------------------

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public List<Llibre> getLlibresPrestats() {
        return llibresPrestats;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Prestec> getHistorialPrestecs() {
        return historialPrestecs;
    }

}
