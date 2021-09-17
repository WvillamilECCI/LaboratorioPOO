package mx.com.gm.peliculas.datos;

import java.io.*;
import java.util.*;
import mx.com.gm.peliculas.domain.*;
import mx.com.gm.peliculas.excepciones.*;

public class AccesoDatosImp implements IAccesoDatos {

    @Override
    public boolean existe(String nombreArchivo) throws AccesoDatosEX {

        File archivo = new File(nombreArchivo);
        return archivo.exists();
    }

    @Override
    public List<Pelicula> listar(String nombre) throws LecturaDatosEX {

        File archivo = new File(nombre);
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            BufferedReader LeerArchivos = new BufferedReader(new FileReader(archivo));
            String Leer = null;
            Leer = LeerArchivos.readLine();

            while (Leer != null) {

                Pelicula pelicula = new Pelicula(Leer);
                peliculas.add(pelicula);
                Leer = LeerArchivos.readLine();
            }
            LeerArchivos.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEX("Exepción a listar peliculas " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEX("Exepción a listar peliculas " + ex.getMessage());
        }

        return peliculas;
    }

    @Override
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEX {

        File archivo = new File(nombreArchivo);
        try {
            PrintWriter Salida = new PrintWriter(new FileWriter(nombreArchivo, anexar));
            Salida.println(pelicula.toString());
            Salida.close();
            System.out.println("Se ha escrito información al archivo" + pelicula);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEX("Exepción al escribir peliculas " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new EscrituraDatosEX("Exepción al escribir peliculas " + ex.getMessage());
        }

    }

    @Override
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEX {

        File archivo = new File(nombreArchivo);
        String resultado = null;
        try {
            BufferedReader entrada = new BufferedReader(new FileReader(archivo));
            String linea = null;
            linea = entrada.readLine();
            int indice = 1;
            while (linea != null) {

                if (buscar != null && buscar.equalsIgnoreCase(linea)) {

                    resultado = "Pelicula: " + linea + " encontrada en el indice: " + indice;
                    break;

                }
                linea = entrada.readLine();
                indice++;

            }
            entrada.close();

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEX("Exepción al buscar pelicula " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new LecturaDatosEX("Exepción al buscar pelicula " + ex.getMessage());
        }

        return resultado;

    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEX {

        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("El archivo ha sido creado");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEX("Exepción al buscar pelicula " + ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
            throw new AccesoDatosEX("Exepción al buscar pelicula " + ex.getMessage());
        }

    }

    @Override
    public void borrar(String nombreArchivo) throws AccesoDatosEX {
        File archivo = new File(nombreArchivo);
        if (archivo.exists()) {
            archivo.delete();
            System.out.println("Se ha eliminado el archivo");
        }

    }

}
