package src;
import java.util.ArrayList;

// Clase Producto que representa un producto en la lista enlazada

public class Producto {

    //Atributos

    private String nombre;
    private double precio;
    private String categoria;
    private String fechaVencimiento; // Puede ser null si no aplica
    private int cantidad;
    private int numeroSerie;
    private ArrayList<String> listaImagenes;
    private Producto siguiente;

    public Producto(
    String nombreObjeto, 
    double precioObjeto, 
    String categoriaObjeto,                    String fechaVencimientoObjeto,
    int cantidadObjeto,
    int numeroSerieObjeto){
        nombre = nombreObjeto;

        precio = precioObjeto;

        categoria = categoriaObjeto;

        fechaVencimiento = fechaVencimientoObjeto;

        cantidad = cantidadObjeto;

        numeroSerie = numeroSerieObjeto;

        listaImagenes = new ArrayList<>();
        siguiente = null;
    }

    //Getters

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getNumeroSerie() {
        return numeroSerie;
    }

    public ArrayList<String> getListaImagenes() {
        return listaImagenes;
    }


    //Setters

    public void setNombre(String nombreNV) {
        nombre = nombreNV;
    }

    public void setPrecio(double precioNV) {
        precio = precioNV;
    }

    public void setCategoria(String categoriaNV) {
        categoria = categoriaNV;
    }

    public void setFechaVencimiento(String fechaVencimientoNV) {
        fechaVencimiento = fechaVencimientoNV;
    }

    public void setCantidad(int cantidadNV) {
        cantidad = cantidadNV;
    }

    public void setNumeroSerie(int numeroSerieNV) {
        numeroSerie = numeroSerieNV;
    }

    public void setListaImagenes(ArrayList<String> listaImagenesNV) {
        listaImagenes = listaImagenesNV;
    }

    //stringgggg
    
    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", categoria='" + categoria + '\'' +
                ", fechaVencimiento='" + fechaVencimiento + '\'' +
                ", cantidad=" + cantidad +
                ", numeroSerie=" + numeroSerie +
                ", listaImagenes=" + listaImagenes +
                '}';
    }

    public Producto getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Producto siguienteNV) {
        siguiente = siguienteNV;
    }
}