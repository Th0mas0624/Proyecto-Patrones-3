package model.Mediator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class GameMediator {
    private ServerSocket serverSocket;
    private Socket player1Socket;
    private Socket player2Socket;

    private ObjectOutputStream player1Out;
    private ObjectInputStream player1In;
    private ObjectOutputStream player2Out;
    private ObjectInputStream player2In;

    public GameMediator() {
        try {
            serverSocket = new ServerSocket(12345); // Puerto para la comunicación
            System.out.println("Esperando jugador 1...");
            player1Socket = serverSocket.accept();
            System.out.println("Jugador 1 conectado.");

            System.out.println("Esperando jugador 2...");
            player2Socket = serverSocket.accept();
            System.out.println("Jugador 2 conectado.");

            player1Out = new ObjectOutputStream(player1Socket.getOutputStream());
            player1In = new ObjectInputStream(player1Socket.getInputStream());
            player2Out = new ObjectOutputStream(player2Socket.getOutputStream());
            player2In = new ObjectInputStream(player2Socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startGame() {
        try {
            // Lógica para iniciar el juego
            // Por ejemplo, enviar información inicial a los jugadores

            while (true) {
                // Lógica para gestionar la comunicación continua entre los jugadores
                // Puedes implementar el intercambio de mensajes entre los jugadores aquí
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnections();
        }
    }

    private void closeConnections() {
        try {
            player1Out.close();
            player1In.close();
            player2Out.close();
            player2In.close();
            player1Socket.close();
            player2Socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

