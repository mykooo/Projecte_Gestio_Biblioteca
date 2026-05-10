import java.time.LocalDate;
public class Prestec {

    // ---------------------------------
    // ---------- ATRIBUTOS ------------
    // ---------------------------------

    public static final int MAX_LLIBRES = 3;
    private Usuari usuari;
    private Llibre llibre;
    private LocalDate dataPrestec;
    private LocalDate dataRetorn;

    // ---------------------------------
    // --------- CONSTRUCTOR -----------
    // ---------------------------------

    public Prestec(Usuari usuari, Llibre llibre, LocalDate dataPrestec) {
        this.usuari = usuari;
        this.llibre = llibre;
        this.dataPrestec = dataPrestec;
        this.dataRetorn = dataPrestec.plusWeeks(2);
    }

    // ---------------------------------
    // ---------- FUNCIONES ------------
    // ---------------------------------

    public boolean estaRetardat() {
        return LocalDate.now().isAfter(dataRetorn);
    }

    @Override
    public String toString() {
        return "\n----- PRÉSTEC -----" +
                "\nUsuari: " + usuari.getNom() +
                "\nLlibre: " + llibre.getTitol() +
                "\nData préstec: " + dataPrestec +
                "\nData retorn: " + dataRetorn +
                "\nRetard: " +
                (estaRetardat() ? "Sí" : "No");
    }

    // ---------------------------------
    // ------- GETTERS + SETTERS -------
    // ---------------------------------

    public Usuari getUsuari() {
        return usuari;
    }

    public Llibre getLlibre() {
        return llibre;
    }

    public LocalDate getDataPrestec() {
        return dataPrestec;
    }

    public LocalDate getDataRetorn() {
        return dataRetorn;
    }

}
