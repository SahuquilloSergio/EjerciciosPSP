package pspejerciciosocket6666;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;

public class PSPEjercicioSocket6666 {

    public static void main(String[] args) throws IOException {
       
        System.out.println("Creando socket servidor");
        ServerSocket serverSocket = new ServerSocket();

        System.out.println("Realizando el bind");
        InetSocketAddress addr = new InetSocketAddress("localhost", 6666);
        serverSocket.bind(addr);

        System.out.println("Aceptando conexiones");
        Socket newSocket = serverSocket.accept();

        System.out.println("Conexion recibida");
        InputStream is = newSocket.getInputStream();
        OutputStream os = newSocket.getOutputStream();

        byte[] smensaje = new byte[25];
        int leer = is.read(smensaje);
        
        String cadenar = new String(smensaje);
        String [] cadena = cadenar.split(" ");
        int suma = 0;
        
        for (int i=0; i<cadena.length-1;i++){
            String nu = cadena[i];
            int num = Integer.valueOf(nu);
            suma = suma + num;
        }
        
        System.out.println("La suma es : "+String.valueOf(suma));
        
        
        OutputStream output=newSocket.getOutputStream();
        String mensaje="La suma es : "+suma;
        output.write(mensaje.getBytes());
        

        System.out.println("Cerrando el nuevo socket");

        newSocket.close();

        System.out.println("Cerrando el socket servidor");

        serverSocket.close();

        System.out.println("Terminado");

    }
}
