package backend.saves;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import backend.modelos.Cliente;
import backend.modelos.Producto;
import backend.modelos.herenciaEmpleados.Empleado;
import backend.modelos.herenciaEmpleados.Limpieza;
import backend.modelos.herenciaEmpleados.Panadero;
import backend.modelos.herenciaEmpleados.Vendedor;
import backend.saves.archivosClases.GestorCliente;
import backend.saves.archivosClases.GestorLimpieza;
import backend.saves.archivosClases.GestorPanadero;
import backend.saves.archivosClases.GestorProducto;
import backend.saves.archivosClases.GestorTablaClientes;
import backend.saves.archivosClases.GestorTablaEmpleados;
import backend.saves.archivosClases.GestorTablaProductos;
import backend.saves.archivosClases.GestorTablaVentas;
import backend.saves.archivosClases.GestorVendedor;
import backend.servicios.Venta;

public class Datos {

    // listas y tablas de datos
    public static ArrayList<Producto> inventario = new ArrayList<>();
    public static ArrayList<Limpieza> empleadosLimpieza = new ArrayList<>();
    public static ArrayList<Panadero> empleadosPanaderos = new ArrayList<>();
    public static ArrayList<Vendedor> empleadosCajeros = new ArrayList<>();
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static HashMap<Integer, Empleado> tablaLookUpEmpleados = new HashMap<>();
    public static HashMap<Integer, Producto> tablaLookUpProductos = new HashMap<>();
    public static HashMap<Integer, Cliente> tablaLookUpClientes = new HashMap<>();
    public static HashMap<Integer, Venta> tablaLookUpVentas = new HashMap<>();

    // Identificador que se coloca al iniciar sesion
    // Sirve para adjudicar las ventas realizadas a dicho vendedor.
    public static int identificadorVendedorActual = -1;

    // métodos para guardar ArrayLists en archivos
    public static void guardarDatosArrayList() {
        try {
            File directorio = new File("src/main/resources/archivosSerializados");
            if (!directorio.exists()) {
                directorio.mkdirs();
            }

            String ruta = "src/main/resources/archivosSerializados/";

            GestorProducto gestorProducto = new GestorProducto();
            gestorProducto.guardarDatos(ruta + "productos.ser", inventario);
            System.out.println("Datos de inventario guardados.");

            GestorLimpieza gestorLimpieza = new GestorLimpieza();
            gestorLimpieza.guardarDatos(ruta + "empleadosLimpieza.ser", empleadosLimpieza);
            System.out.println("Datos de empleados de limpieza guardados.");

            GestorPanadero gestorPanadero = new GestorPanadero();
            gestorPanadero.guardarDatos(ruta + "empleadosPanaderos.ser", empleadosPanaderos);
            System.out.println("Datos de empleados panaderos guardados.");

            GestorVendedor gestorVendedor = new GestorVendedor();
            gestorVendedor.guardarDatos(ruta + "empleadosCajeros.ser", empleadosCajeros);
            System.out.println("Datos de empleados cajeros guardados.");

            GestorCliente gestorCliente = new GestorCliente();
            gestorCliente.guardarDatos(ruta + "clientes.ser", clientes);
            System.out.println("Datos de clientes guardados.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void guardarDatosHashMap() {
        try {
            File directorio = new File("src/main/resources/archivosSerializados");
            if (!directorio.exists()) {
                directorio.mkdirs();
            }

            String ruta = "src/main/resources/archivosSerializados/";

            GestorTablaProductos gestorTablaProductos = new GestorTablaProductos();
            gestorTablaProductos.guardarDatos(ruta + "productosHashMap.ser", tablaLookUpProductos);
            System.out.println("Datos de productos HashMap guardados.");

            GestorTablaEmpleados gestorTablaEmpleados = new GestorTablaEmpleados();
            gestorTablaEmpleados.guardarDatos(ruta + "empleadosHashMap.ser", tablaLookUpEmpleados);
            System.out.println("Datos de empleados HashMap guardados.");

            GestorTablaClientes gestorTablaClientes = new GestorTablaClientes();
            gestorTablaClientes.guardarDatos(ruta + "clientesHashMap.ser", tablaLookUpClientes);
            System.out.println("Datos de clientes HashMap guardados.");

            GestorTablaVentas gestorTablaVentas = new GestorTablaVentas();
            gestorTablaVentas.guardarDatos(ruta + "ventasHashMap.ser", tablaLookUpVentas);
            System.out.println("Datos de ventas HashMap guardados.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // métodos para cargar ArrayLists desde archivos
    public static void cargarDatosArrayList(ClassLoader classLoader) {
        String ruta = "src/main/resources/archivosSerializados/";
        try {
            GestorProducto gestorProducto = new GestorProducto();
            File archivoProductos = new File(ruta + "productos.ser");
            if (archivoProductos.exists()) {
                try (InputStream inputStream = new FileInputStream(archivoProductos)) {
                    ArrayList<Producto> productos = gestorProducto.cargarDatos(inputStream);
                    if (productos != null) {
                        setInventario(productos);
                        System.out.println("Datos de inventario cargados.");
                    }
                }
            }

            GestorLimpieza gestorLimpieza = new GestorLimpieza();
            File archivoLimpieza = new File(ruta + "empleadosLimpieza.ser");
            if (archivoLimpieza.exists()) {
                try (InputStream inputStream = new FileInputStream(archivoLimpieza)) {
                    ArrayList<Limpieza> empleadosLimpieza = gestorLimpieza.cargarDatos(inputStream);
                    if (empleadosLimpieza != null) {
                        setEmpleadosLimpieza(empleadosLimpieza);
                        System.out.println("Datos de empleados de limpieza cargados.");
                    }
                }
            }

            GestorPanadero gestorPanadero = new GestorPanadero();
            File archivoPanaderos = new File(ruta + "empleadosPanaderos.ser");
            if (archivoPanaderos.exists()) {
                try (InputStream inputStream = new FileInputStream(archivoPanaderos)) {
                    ArrayList<Panadero> empleadosPanaderos = gestorPanadero.cargarDatos(inputStream);
                    if (empleadosPanaderos != null) {
                        setEmpleadosPanaderos(empleadosPanaderos);
                        System.out.println("Datos de empleados panaderos cargados.");
                    }
                }
            }

            GestorVendedor gestorVendedor = new GestorVendedor();
            File archivoCajeros = new File(ruta + "empleadosCajeros.ser");
            if (archivoCajeros.exists()) {
                try (InputStream inputStream = new FileInputStream(archivoCajeros)) {
                    ArrayList<Vendedor> empleadosCajeros = gestorVendedor.cargarDatos(inputStream);
                    if (empleadosCajeros != null) {
                        setEmpleadosCajeros(empleadosCajeros);
                        System.out.println("Datos de empleados cajeros cargados.");
                    }
                }
            }

            GestorCliente gestorCliente = new GestorCliente();
            File archivoClientes = new File(ruta + "clientes.ser");
            if (archivoClientes.exists()) {
                try (InputStream inputStream = new FileInputStream(archivoClientes)) {
                    ArrayList<Cliente> clientes = gestorCliente.cargarDatos(inputStream);
                    if (clientes != null) {
                        setClientes(clientes);
                        System.out.println("Datos de clientes cargados.");
                    }
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void cargarDatosHashMap(ClassLoader classLoader) {
        String ruta = "src/main/resources/archivosSerializados/";
        try {
            GestorTablaProductos gestorTablaProductos = new GestorTablaProductos();
            File archivoProductosMap = new File(ruta + "productosHashMap.ser");
            if (archivoProductosMap.exists()) {
                try (InputStream inputStream = new FileInputStream(archivoProductosMap)) {
                    HashMap<Integer, Producto> productosHashMap = gestorTablaProductos.cargarDatos(inputStream);
                    if (productosHashMap != null) {
                        setTablaLookUpProductos(productosHashMap);
                        System.out.println("Datos de productos HashMap cargados.");
                    }
                }
            }

            GestorTablaEmpleados gestorTablaEmpleados = new GestorTablaEmpleados();
            File archivoEmpleadosMap = new File(ruta + "empleadosHashMap.ser");
            if (archivoEmpleadosMap.exists()) {
                try (InputStream inputStream = new FileInputStream(archivoEmpleadosMap)) {
                    HashMap<Integer, Empleado> empleadosHashMap = gestorTablaEmpleados.cargarDatos(inputStream);
                    if (empleadosHashMap != null) {
                        setTablaLookUpEmpleados(empleadosHashMap);
                        System.out.println("Datos de empleados HashMap cargados.");
                    }
                }
            }

            GestorTablaClientes gestorTablaClientes = new GestorTablaClientes();
            File archivoClientesMap = new File(ruta + "clientesHashMap.ser");
            if (archivoClientesMap.exists()) {
                try (InputStream inputStream = new FileInputStream(archivoClientesMap)) {
                    HashMap<Integer, Cliente> clientesHashMap = gestorTablaClientes.cargarDatos(inputStream);
                    if (clientesHashMap != null) {
                        setTablaLookUpClientes(clientesHashMap);
                        System.out.println("Datos de clientes HashMap cargados.");
                    }
                }
            }

            GestorTablaVentas gestorTablaVentas = new GestorTablaVentas();
            File archivoVentasMap = new File(ruta + "ventasHashMap.ser");
            if (archivoVentasMap.exists()) {
                try (InputStream inputStream = new FileInputStream(archivoVentasMap)) {
                    HashMap<Integer, Venta> ventasHashMap = gestorTablaVentas.cargarDatos(inputStream);
                    if (ventasHashMap != null) {
                        setTablaLookUpVentas(ventasHashMap);
                        System.out.println("Datos de ventas HashMap cargados.");
                    }
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // inicializar las listas
    public static void inicializarDatos() {
        inventario = new ArrayList<>();
        empleadosLimpieza = new ArrayList<>();
        empleadosPanaderos = new ArrayList<>();
        empleadosCajeros = new ArrayList<>();
        clientes = new ArrayList<>();
        tablaLookUpEmpleados = new HashMap<>();
        tablaLookUpProductos = new HashMap<>();
        tablaLookUpClientes = new HashMap<>();
        tablaLookUpVentas = new HashMap<>();
    }

    // getters y setters

    public static ArrayList<Producto> getInventario() {
        return inventario;
    }

    public static void setInventario(ArrayList<Producto> inventario) {
        Datos.inventario = inventario;
    }

    public static ArrayList<Limpieza> getEmpleadosLimpieza() {
        return empleadosLimpieza;
    }

    public static void setEmpleadosLimpieza(ArrayList<Limpieza> empleadosLimpieza) {
        Datos.empleadosLimpieza = empleadosLimpieza;
    }

    public static ArrayList<Panadero> getEmpleadosPanaderos() {
        return empleadosPanaderos;
    }

    public static void setEmpleadosPanaderos(ArrayList<Panadero> empleadosPanaderos) {
        Datos.empleadosPanaderos = empleadosPanaderos;
    }

    public static ArrayList<Vendedor> getEmpleadosCajeros() {
        return empleadosCajeros;
    }

    public static void setEmpleadosCajeros(ArrayList<Vendedor> empleadosCajeros) {
        Datos.empleadosCajeros = empleadosCajeros;
    }

    public static ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public static void setClientes(ArrayList<Cliente> clientes) {
        Datos.clientes = clientes;
    }

    public static HashMap<Integer, Empleado> getTablaLookUpEmpleados() {
        return tablaLookUpEmpleados;
    }

    public static void setTablaLookUpEmpleados(HashMap<Integer, Empleado> tablaLookUpEmpleados) {
        Datos.tablaLookUpEmpleados = tablaLookUpEmpleados;
    }

    public static HashMap<Integer, Producto> getTablaLookUpProductos() {
        return tablaLookUpProductos;
    }

    public static void setTablaLookUpProductos(HashMap<Integer, Producto> tablaLookUpProductos) {
        Datos.tablaLookUpProductos = tablaLookUpProductos;
    }

    public static HashMap<Integer, Cliente> getTablaLookUpClientes() {
        return tablaLookUpClientes;
    }

    public static void setTablaLookUpClientes(HashMap<Integer, Cliente> tablaLookUpClientes) {
        Datos.tablaLookUpClientes = tablaLookUpClientes;
    }

    public static HashMap<Integer, Venta> getTablaLookUpVentas() {
        return tablaLookUpVentas;
    }

    public static void setTablaLookUpVentas(HashMap<Integer, Venta> tablaLookUpVentas) {
        Datos.tablaLookUpVentas = tablaLookUpVentas;
    }

    public static int getIdentificadorVendedorActual() {
        return identificadorVendedorActual;
    }

    public static void setIdentificadorVendedorActual(int identificadorVendedorActual) {
        Datos.identificadorVendedorActual = identificadorVendedorActual;
    }
}
