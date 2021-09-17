package mx.com.gm.peliculas.negocio;

import java.util.*;
import mx.com.gm.peliculas.datos.*;
import mx.com.gm.peliculas.domain.*;
import mx.com.gm.peliculas.excepciones.*;

public class CatalogoPeliculasImp implements ICatalogoPeliculas{
    
    private final IAccesoDatos datos;
    
    public CatalogoPeliculasImp(){
        
        this.datos = new AccesoDatosImp();
    
    }

    @Override
    public void agregarPelicula(String nombrePelicula){
        
        Pelicula pelicula = new Pelicula(nombrePelicula);
        boolean anexar = false;
        try {
            anexar = datos.existe(NOMBRE_RECURSO);
            datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
        } catch (AccesoDatosEX ex) {
            
            System.out.println("Error acceso datos");
            ex.printStackTrace(System.out);
        }
    }

    @Override
    public void listarPelicula() {
        
        try {
            List peliculas = this.datos.listar(NOMBRE_RECURSO);
            for(Object pelicula: peliculas){
                System.out.println("pelicula = " + pelicula);
                            
            }
        } catch (AccesoDatosEX ex) {
            System.out.println("Error de acceso de datos");
            ex.printStackTrace(System.out);
        }
        
    }

    @Override
    public void buscarPelicula(String buscar) {
        
        String resultado = null;
        try {
            resultado = this.datos.buscar(NOMBRE_RECURSO, buscar);
        } catch (AccesoDatosEX ex) {
            System.out.println("Error de acceso datos");
            ex.printStackTrace(System.out);
        }
        
        System.out.println("resultado = " + resultado);
        
    }

    @Override
    public void iniciarArchivo() {
        
        try {
            if (this.datos.existe(NOMBRE_RECURSO)) {
                
                datos.borrar(NOMBRE_RECURSO);
                datos.crear(NOMBRE_RECURSO);
            }else{
                
                datos.crear(NOMBRE_RECURSO);
                
            }
        } catch (AccesoDatosEX ex) {
            System.out.println("Error al iniciar catalogo de peliculas");
        }
        
    }

   
    
        
    
    
}
