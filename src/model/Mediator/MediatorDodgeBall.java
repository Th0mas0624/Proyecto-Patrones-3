package model.Mediator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import model.FactoryMethod.Player;
import model.FactoryMethod.PlayerA;
import model.FactoryMethod.PlayerB;

public class MediatorDodgeBall implements Mediator{
    private ServerSocket serverSocket;
    private Socket jugador1Socket;
    private Socket jugador2Socket;
    private ObjectOutputStream jugador1Out;
    private ObjectOutputStream jugador2Out;
    private ObjectInputStream jugador1In;
    private ObjectInputStream jugador2In;

    public MediatorDodgeBall() {
        try {
            serverSocket = new ServerSocket(12345); // Puerto de comunicación
            jugador1Socket = serverSocket.accept();
            jugador2Socket = serverSocket.accept();

            jugador1Out = new ObjectOutputStream(jugador1Socket.getOutputStream());
            jugador2Out = new ObjectOutputStream(jugador2Socket.getOutputStream());
            jugador1In = new ObjectInputStream(jugador1Socket.getInputStream());
            jugador2In = new ObjectInputStream(jugador2Socket.getInputStream());

            // Iniciar hilos para escuchar mensajes de cada jugador
            new Thread(() -> escucharMensajes(jugador1In, jugador2Out)).start();
            new Thread(() -> escucharMensajes(jugador2In, jugador1Out)).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void escucharMensajes(ObjectInputStream entrada, ObjectOutputStream salida) {
        try {
            while (true) {
                String mensaje = (String) entrada.readObject();
                // Manejar el mensaje recibido
                // Puedes agregar lógica adicional según sea necesario
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void enviarMensaje(String mensaje, Player jugador) {
        try {
            if (jugador instanceof PlayerA) {
                jugador2Out.writeObject(mensaje);
            } else if (jugador instanceof PlayerB) {
                jugador1Out.writeObject(mensaje);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
