package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    // =====================================================
    // Menu principal de gestion de inventario veterinario
    // =====================================================
    public static void menu() {
        Scanner sc = new Scanner(System.in);
        ListaProductos lista = new ListaProductos();

        // Productos cargados por defecto
        cargarDatosDefault(lista);

        int opcion;
        int pos;

        do {
            System.out.println("\n===== MENU DE INVENTARIO - VETERINARIA =====");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Modificar producto");
            System.out.println("4. Eliminar producto");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1: {
                    // Submenu para decidir posicion
                    do {
                        System.out.println("Donde desea insertar el producto?");
                        System.out.println("1. Al inicio");
                        System.out.println("2. Al final");
                        System.out.print("Seleccione: ");
                        pos = sc.nextInt();
                        sc.nextLine();
                        if (pos != 1 && pos != 2) {
                            System.out.println("Opcion invalida, elija 1 o 2.");
                        }
                    } while (pos != 1 && pos != 2);

                    // Solicitar datos
                    System.out.print("Numero de serie (ID): ");
                    int numeroSerie = sc.nextInt();
                    sc.nextLine();

                    // Verificar duplicado
                    if (lista.buscarNodo(numeroSerie) != null) {
                        System.out.println("Error: Ya existe un producto con el numero de serie " + numeroSerie);
                        break;
                    }

                    System.out.print("Nombre del producto: ");
                    String nombre = sc.nextLine();

                    System.out.print("Precio: ");
                    double precio = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Categoria: ");
                    String categoria = sc.nextLine();

                    System.out.print("Fecha de vencimiento (o N/A): ");
                    String fecha = sc.nextLine();

                    System.out.print("Cantidad: ");
                    int cantidad = sc.nextInt();
                    sc.nextLine();

                    // Imagenes
                    ArrayList<String> imagenes = new ArrayList<>();
                    System.out.print("Desea agregar imagenes al producto? (s/n): ");
                    String resp = sc.nextLine();
                    if (resp.equalsIgnoreCase("s")) {
                        boolean seguir = true;
                        while (seguir) {
                            System.out.print("Ingrese la ruta o nombre de la imagen: ");
                            imagenes.add(sc.nextLine());
                            System.out.print("Agregar otra imagen? (s/n): ");
                            seguir = sc.nextLine().equalsIgnoreCase("s");
                        }
                    }

                    // Insercion
                    if (pos == 1) {
                        lista.insertarNodoInicio(nombre, precio, categoria, fecha, cantidad, numeroSerie);
                        lista.buscarNodo(numeroSerie).setListaImagenes(imagenes);
                        System.out.println("Producto agregado al inicio correctamente.");
                    } else {
                        lista.insertarNodoFinal(nombre, precio, categoria, fecha, cantidad, numeroSerie);
                        lista.buscarNodo(numeroSerie).setListaImagenes(imagenes);
                        System.out.println("Producto agregado al final correctamente.");
                    }
                    break;
                }

                case 2:
                    lista.mostrarCostosTotales();
                    break;

                case 3: {
                    System.out.print("Ingrese el numero de serie del producto a modificar: ");
                    int idBuscar = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = sc.nextLine();

                    System.out.print("Nuevo precio: ");
                    double nuevoPrecio = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Nueva categoria: ");
                    String nuevaCategoria = sc.nextLine();

                    System.out.print("Nueva cantidad: ");
                    int nuevaCantidad = sc.nextInt();
                    sc.nextLine();

                    // Nueva imagen
                    ArrayList<String> nuevasImagenes = new ArrayList<>();
                    System.out.print("Desea agregar o reemplazar imagenes? (s/n): ");
                    String resp = sc.nextLine();
                    if (resp.equalsIgnoreCase("s")) {
                        boolean seguir = true;
                        while (seguir) {
                            System.out.print("Ingrese nueva ruta o nombre de imagen: ");
                            nuevasImagenes.add(sc.nextLine());
                            System.out.print("Agregar otra imagen? (s/n): ");
                            seguir = sc.nextLine().equalsIgnoreCase("s");
                        }
                    }

                    lista.modificarLista(idBuscar, nuevoNombre, nuevoPrecio, nuevaCategoria, nuevaCantidad, nuevasImagenes);
                    break;
                }

                case 4: {
                    System.out.print("Ingrese el numero de serie del producto a eliminar: ");
                    int numeroSerie = sc.nextInt();
                    sc.nextLine();
                    lista.eliminarNodo(numeroSerie);
                    break;
                }

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opcion no valida, intente nuevamente.");
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }




  
    // =====================================================
    // Carga de productos por defecto (Veterinaria)
    // =====================================================
    private static void cargarDatosDefault(ListaProductos lista) {
        
       

    ArrayList<String> img1 = new ArrayList<>();
    img1.add("src/images/croquetas_perro_adulto_1.jpg");
    lista.insertarNodoFinal("Croquetas para perro adulto", 15000.0, "Alimento", "2026-03-01", 20, 101);
    lista.buscarNodo(101).setListaImagenes(img1);

    ArrayList<String> img2 = new ArrayList<>();
    img2.add("src/imagenes/areanaparagato10kg.png");
    lista.insertarNodoFinal("Arena para gato 10kg", 12000.0, "Higiene", "N/A", 15, 102);
    lista.buscarNodo(102).setListaImagenes(img2);


    ArrayList<String> img4 = new ArrayList<>();
    img4.add("src/images/shampoo_antipulgas_1.jpg");
    lista.insertarNodoFinal("Shampooantipulgas", 9500.0, "Cuidado", "2027-05-15", 25, 104);
    lista.buscarNodo(104).setListaImagenes(img4);

    ArrayList<String> img6 = new ArrayList<>();
    img6.add("src/images/vitaminas_perros_1.jpg");
    lista.insertarNodoFinal("Vitaminas para perros", 20000.0, "Medicamento", "2026-10-10", 10, 106);
    lista.buscarNodo(106).setListaImagenes(img6);

    System.out.println("Productos de veterinaria cargados por defecto en el inventario.");
}
}
