package cpjlaboratoriofinal;

import java.util.Scanner;
import mx.com.gm.peliculas.negocio.*;

public class CPJLaboratorioFinal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion = -1;
        String nombreArchivo;
        ICatalogoPeliculas catalogopeliculas = new CatalogoPeliculasImp();

        System.out.println("Elige la opción: \n"
                + "1.Iniciar catalogo peliculas\n"
                + "2.Agregar peliculas\n"
                + "3.Listar peliculas\n"
                + "4.Buscar peliculas\n"
                + "0.Salir");
        opcion = Integer.parseInt(scanner.nextLine());

        while (opcion != 0) {

            switch (opcion) {
                case 1:
                    catalogopeliculas.iniciarArchivo();
                    break;
                case 2:
                    System.out.println("Introduce el nombre de la pelcula a agregar");
                    String nombrePelicula = scanner.nextLine();
                    catalogopeliculas.agregarPelicula(nombrePelicula);
                    break;
                case 3:
                    catalogopeliculas.listarPelicula();
                    break;
                case 4:
                    System.out.println("Indtroduce una peli a buscar");
                    String buscar = scanner.nextLine();
                    catalogopeliculas.buscarPelicula(buscar);
                case 0:
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("Opción no reconocida");
                    break;

            }

        }

    }

}
