package clientesocketstream;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClienteSocketStream {

    public static void main(String[] args) {
        try {
                //ABRIMOS EL SOCKET CLIENTE
                System.out.println("Creando socket cliente");
                Socket clienteSocket = new Socket();
                System.out.println("Estableciendo la conexi�n");

                InetSocketAddress addr = new InetSocketAddress("localhost", 6666);
                clienteSocket.connect(addr);

                InputStream cis = clienteSocket.getInputStream();
                OutputStream cos = clienteSocket.getOutputStream();
                for(int i = 0; i <= 3; i++){
                System.out.println("Enviando mensaje " + i);
                String mensajeEnviado = "Mensaje desde el cliente";
                cos.write(mensajeEnviado.getBytes());
                System.out.println("Mensaje enviado");
                byte[] mensajeRecibido = new byte[25];
                cis.read(mensajeRecibido);
                System.out.println("Mensaje recibido: " + new String(mensajeRecibido));
            }

                System.out.println("Cerrando el socket cliente");

                clienteSocket.close();

                System.out.println("Terminado");

               
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
