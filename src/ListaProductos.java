
package src;
import java.util.ArrayList;

//ListaProductos 

public class ListaProductos {

    private Producto primero;

    //Constructor

    public ListaProductos() {
        primero = null;
    }
    //Getters 
    public Producto getPrimero() {
        return primero;
    }
    //Setters
    public void setPrimero(Producto FirtsProducto) {
        primero = FirtsProducto;
    }

    //insertar nodo 
    public void insertarNodoInicio(String nombre, double precio, String categoria, String fechaVencimiento,int cantidad, int numeroSerie) 
    
    {
     if (buscarNodo(numeroSerie) != null) {
        System.out.println("Error: Ya existe un producto con el número de serie " + numeroSerie + ". No se puede insertar el nodo.");
        return;
     }

     Producto nuevoProducto = new Producto(nombre, precio, categoria, fechaVencimiento, cantidad, numeroSerie);
     nuevoProducto.setSiguiente(primero);
     setPrimero(nuevoProducto);
    }

        
    //aqui termina insertar nodo

    //eliminar nodo
    public void eliminarNodo(int numeroSerie) {
        if (primero == null) {
            System.out.println("La lista vacía. No se puede eliminar ningún nodo.");
            return;
        }


        if (primero.getNumeroSerie() == numeroSerie) {
            setPrimero(primero.getSiguiente());
            System.out.println("Nodo con número de serie " + numeroSerie + " eliminado.");
            return;
        }

       Producto nodoActual = primero;
       Producto anteriorActual = null;

    while (nodoActual != null && nodoActual.getNumeroSerie() != numeroSerie) {
    {
        anteriorActual = nodoActual;
        nodoActual = nodoActual.getSiguiente();
    }


        if (nodoActual == null) {
            System.out.println("Nodo con número de serie " + numeroSerie + " no encontrado.");
            return;
        }

        anteriorActual.setSiguiente(nodoActual.getSiguiente());
        System.out.println("Nodo con número de serie " + numeroSerie + " eliminado.");
    }
}
    //aqui termina eliminar nodo

    //insertar nodo al final
    public void insertarNodoFinal(String nombre, double precio, String categoria, String fechaVencimiento, int cantidad, int numeroSerie)

     {
         if (buscarNodo(numeroSerie) != null) {
        System.out.println("Error: Ya existe un producto con el número de serie " + numeroSerie + ". No se puede insertar el nodo.");
        return;
     }
        
        Producto productoNV = new Producto(nombre, precio, categoria, fechaVencimiento, cantidad, numeroSerie);
        
        Producto nuevoNodo = productoNV;

        if (primero == null){
            setPrimero(nuevoNodo);
        }
        else{ Producto nodoAhorita = primero;
        while (nodoAhorita.getSiguiente() != null){
            nodoAhorita = nodoAhorita.getSiguiente();}
        nodoAhorita.setSiguiente(nuevoNodo);}

        
    }

    //aqui termina insertar nodo al final

    //buscar nodo
    public Producto buscarNodo(int numeroSerie){
        Producto actual = primero;
        if(primero == null){
            System.out.println("Inventario vacio");
            return null;
        }

        while (actual != null){
            if (actual.getNumeroSerie() == numeroSerie){
                return actual;
            }
            actual = actual.getSiguiente();
        }
        
        return null;
    }
    //aqui termina buscar nodo
    
    //imprimir lista de productos
   public void mostrarCostosTotales() {
    if (primero == null) {
        System.out.println("Inventario vacío.");
        return;
    }

    Producto actualAhorita = primero;
    double totalAcumulado = 0;
    while (actualAhorita != null) {
        Producto prod = actualAhorita;

        double costoProducto = prod.getPrecio() * prod.getCantidad();
        System.out.println("Producto: " + prod.getNombre());
        System.out.println("Categoría: " + prod.getCategoria());
        System.out.println("Cantidad: " + prod.getCantidad());
        System.out.println("Precio unitario: " + prod.getPrecio());
        System.out.println("Costo total: " + costoProducto);
        System.out.println("--------------------------------------");

        totalAcumulado += costoProducto;

        actualAhorita = actualAhorita.getSiguiente();
    }

    System.out.println("TOTAL ACUMULADO DE INVENTARIO: " + totalAcumulado + "\n");
    }
    //aqui termina lista productos

    //modificar lista
    public boolean modificarLista(int numeroSerieBuscar, String nuevoNombre, double nuevoPrecio, String nuevaCategoria, int nuevaCantidad, ArrayList<String> nuevasImagenes) {

        if (primero == null) {
            System.out.println("La lista se encuentra vacía.\n");
            return false;
        }

        Producto nodoActual = primero;

        while (nodoActual != null && nodoActual.getNumeroSerie() != numeroSerieBuscar) {
            nodoActual = nodoActual.getSiguiente();
        }

        if (nodoActual != null) {
            nodoActual.setNombre(nuevoNombre);
            nodoActual.setPrecio(nuevoPrecio);
            nodoActual.setCategoria(nuevaCategoria);
            nodoActual.setCantidad(nuevaCantidad);

            // Reemplazar o actualizar imágenes
            if (nuevasImagenes != null && !nuevasImagenes.isEmpty()) {
                nodoActual.setListaImagenes(nuevasImagenes);
            }

            System.out.println("Producto con número de serie " + numeroSerieBuscar + " modificado correctamente.\n");
            return true;
        } else {
            System.out.println("No se encontró un producto con el número de serie especificado.\n");
            return false;
        }
    }
    //aqui termina modificar lista

}




