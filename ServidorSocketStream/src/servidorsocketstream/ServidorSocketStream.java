package servidorsocketstream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.ServerSocket;

public class ServidorSocketStream {

    public static void main(String[] args) {
        try {
                //ABRIMOS EL SOCKET SERVIDOR
                System.out.println("Creando socket servidor");

                ServerSocket serverSocket = new ServerSocket();

                System.out.println("Realizando el bind");

                InetSocketAddress addr = new InetSocketAddress("localhost", 6666);
                serverSocket.bind(addr);

                System.out.println("Aceptando conexiones");

                Socket newSocket = serverSocket.accept();

                System.out.println("Conexi�n recibida");

                InputStream sis = newSocket.getInputStream();
                OutputStream sos = newSocket.getOutputStream();
                
                for (int i = 0; i <= 3; i++){

                byte[] mensajeRecibido = new byte[25];
                sis.read(mensajeRecibido);

                System.out.println("Mensaje recibido: " + new String(mensajeRecibido));
                
                    System.out.println("Enviando mensaje "+i);
                    String mensajeEnviado = "Mensaje desde el servidor";
                    sos.write(mensajeEnviado.getBytes());
                    System.out.println("Mensaje Enviado");
                }

                System.out.println("Cerrando el nuevo socket");

                newSocket.close();

                System.out.println("Cerrando el socket servidor");

                serverSocket.close();

                System.out.println("Terminado");
            
        } catch (IOException e) {
        }
    }
}
