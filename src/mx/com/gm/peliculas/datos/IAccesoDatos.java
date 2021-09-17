package mx.com.gm.peliculas.datos;

import java.util.*;
import mx.com.gm.peliculas.domain.*;
import mx.com.gm.peliculas.excepciones.*;

public interface IAccesoDatos {
    
    public abstract boolean existe (String nombreArchivo) throws AccesoDatosEX;
    public abstract List<Pelicula> listar (String nombreArchivo) throws LecturaDatosEX;
    public abstract void escribir (Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEX;
    public abstract String buscar (String nombreArchivo, String buscar) throws LecturaDatosEX;
    public abstract void crear (String nombreArchivo) throws AccesoDatosEX;
    public abstract void borrar (String nombreArchivo) throws AccesoDatosEX;
    
    
}
