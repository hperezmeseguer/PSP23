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
    }
}


