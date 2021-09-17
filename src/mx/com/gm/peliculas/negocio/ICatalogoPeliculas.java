package mx.com.gm.peliculas.negocio;

public interface ICatalogoPeliculas  {
    
    String NOMBRE_RECURSO="Peliculas.txt";
    
    public abstract void agregarPelicula(String nombrePelicula);
    public abstract void listarPelicula();
    public abstract void buscarPelicula(String buscar);
    public abstract void iniciarArchivo();
    
    
}
