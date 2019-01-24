package clientesocketstreamsuma;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * @author serxa
 */
public class ClienteSocketStreamSuma {

    public static void main(String[] args) throws IOException {

        boolean recibido = false;
        
        //Se crea el cocket del cliente:
        System.out.println("Creando socket cliente");
        Socket clienteSocket = new Socket();

        //Se establece la direccion del socket cliente
        System.out.println("Estableciendo la conexión");
        InetSocketAddress addr = new InetSocketAddress("localhost", 6666);
        clienteSocket.connect(addr);

        OutputStream output = clienteSocket.getOutputStream();
        String mensaje = "1 1 1 1 ";
        output.write(mensaje.getBytes());

        recibido = true;
        while (recibido == true) {
            InputStream input = clienteSocket.getInputStream();
            System.out.println("Conexión recibida");

            byte[] mensajeRe = new byte[30];
            int leer = input.read(mensajeRe);
            System.out.println(new String(mensajeRe));

            if (leer == -1) {
                recibido = false;
            }
        }

        //Cerramos el socket
        System.out.println("Cerrando el socket cliente");
        clienteSocket.close();

        System.out.println("Terminado");
    }
    }
    

