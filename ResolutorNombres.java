import java.net.*;
import java.util.Scanner;

// Clase que permite resolver nombres de dominio y mostrar sus IPS
public class ResolutorNombres {

    // Método Main
    public static void main(String[] args){

        // Se obtiene el nombre y la IP de nuestro equipo
        try{

            // Se guarda la informacion de mi equipo en este objeto de tipo InetAddress
            InetAddress miEquipo = InetAddress.getLocalHost();

            // Se muestra el nombre y la IP de mi equipo por pantalla
            System.out.println("Nombre de mi equipo: " + miEquipo.getHostName());
            System.out.println("Dirección IP de mi equipo: " + miEquipo.getHostAddress());
        
        } catch (Exception e){

            // Se printea un posible error
            System.out.println(e.getMessage());
        }

        // Se crea un Scanner para leer lo que escriba el usuario
        Scanner teclado = new Scanner(System.in);

        // Bucle que pide al usuario un dominio hasta que escriba "salir"
        while (true){

            System.out.println("Dime un dominio de página web o escribe `salir`: ");

            // Se guarda lo escrito en un objeto Scanner
            String web = teclado.nextLine();

            // Se comprueba si el usuario escribio salir
            if (!web.equals("salir")){

                try{

                    // Bucle que recorre todas las direcciones obtenidas
                    for (InetAddress ip : InetAddress.getAllByName(web)){

                        // Se comprueba si la direccion es de tipo IPv4
                        if (ip instanceof Inet4Address){

                            // Se muestran por pantalla las direcciones IPv4
                            System.out.println("IPv4 de la web: " + ip.getHostAddress());

                        // Se comprueba si la direccion es de tipo IPv6
                        } else if (ip instanceof Inet6Address){
                            // Se muestran por pantalla las direcciones IPv6
                            System.out.println("IPv6 de la web: " + ip.getHostAddress());
                        }
                    }

                } catch (UnknownHostException e){
                    
                    // Se printea un mensaje si no se introduce un dominio válido o salir
                    System.out.println("Introduce un dominio válido (ejemplo: www.xunta.gal)");
                }
            
            } else {

                // Si el usuario escribe "salir", se muestra este mensaje
                // Se termina el bucle
                System.out.println("Saliendo...");
                break;
            }
        }

        // Se cierra Scanner al terminar
        teclado.close();
    }
}


