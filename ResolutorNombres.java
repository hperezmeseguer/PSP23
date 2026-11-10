import java.net.*;
import java.util.Scanner;


public class ResolutorNombres {

    public static void main(String[] args){

        try{
            InetAddress miEquipo = InetAddress.getLocalHost();

            System.out.println("Nombre de mi equipo: " + miEquipo.getHostName());
            System.out.println("Dirección IP de mi equipo: " + miEquipo.getHostAddress());
        
        } catch (Exception e){

            System.out.println(e.getMessage());
        }

        Scanner teclado = new Scanner(System.in);

        while (true){

            System.out.println("Dime un dominio de página web o escribe `salir`: ");

            String web = teclado.nextLine();

            if (!web.equals("salir")){

                try{

                    for (InetAddress ip : InetAddress.getAllByName(web)){

                        if (ip instanceof Inet4Address){

                            System.out.println("IPv4 de la web: " + ip.getHostAddress());

                        } else if (ip instanceof Inet6Address){
                            
                             System.out.println("IPv6 de la web: " + ip.getHostAddress());
                        }
                    }

                } catch (UnknownHostException e){

                     System.out.println("Introduce un dominio válido (ejemplo: www.xunta.gal)");
                }
            
            } else {

                System.out.println("Saliendo...");
                break;
            }
        }

        teclado.close();
    }
}


