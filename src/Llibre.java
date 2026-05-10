public class Llibre {

    // ---------------------------------
    // ---------- ATRIBUTOS ------------
    // ---------------------------------

    private static int contadorId = 1;
    private int id;
    private String titol;
    private String autor;
    private String categoria;
    private int stock;

    // ---------------------------------
    // --------- CONSTRUCTOR -----------
    // ---------------------------------

    public Llibre(String titol, String autor, String categoria, int stock) {
        this.id = contadorId++;
        this.titol = titol;
        this.autor = autor;
        this.categoria = categoria;
        this.stock = stock;
    }

    // ---------------------------------
    // ----------- FUNCIONES -----------
    // ---------------------------------

    public boolean disponible() {
        return stock > 0;
    }

    public void prestar() {
        if (stock > 0) {
            stock--;
        }
    }

    public void retornar() {
        stock++;
    }

    @Override
    public String toString() {
        return "\n----- LLIBRE -----" +
                "\nID: " + id +
                "\nTítol: " + titol +
                "\nAutor: " + autor +
                "\nCategoria: " + categoria +
                "\nStock: " + stock;
    }

    // ---------------------------------
    // ------- GETTERS + SETTERS -------
    // ---------------------------------

    public int getId() {
        return id;
    }

    public String getTitol() {
        return titol;
    }

    public String getAutor() {
        return autor;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
