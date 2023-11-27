import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import controller.GameController;
import controller.PlayerController;
import model.Ball;
import model.Campo;
import model.FactoryMethod.Player;
import model.FactoryMethod.PlayerAFactory;
import model.FactoryMethod.PlayerBFactory;
import model.Observer.Marcador;
import model.Observer.Vida;
import view.BallView;
import view.CampoView;
import view.Game;
import view.PlayerView;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            // Crear instancias del juego, panel, controladores, etc.
            Campo game = new Campo();
            CampoView gamePanel = new CampoView();
            GameController gameController = new GameController(game, gamePanel);
            
            Player player1 = new PlayerAFactory().createPlayer(40, 40); // Ejemplo de posición inicial y vida
            //Player player2 = new PlayerBFactory().createPlayer(400, 400); // Otra posición inicial y vida
            
            

            PlayerView playerView1 = new PlayerView(player1, Color.RED);
            //PlayerView playerView2 = new PlayerView(player2, Color.BLUE);

            Ball ball = new Ball(100, 100); // Ejemplo de posición inicial de la pelota
            BallView ballView = new BallView(ball, Color.GREEN);

            PlayerController p = new PlayerController(player1, ball);

            // Agregar jugadores y la pelota al juego y a la vista
            game.addPlayer(player1);
            //game.addPlayer(player2);
            game.addBall(ball);

            gamePanel.addPlayerView(playerView1);
            //gamePanel.addPlayerView(playerView2);
            gamePanel.setBallView(ballView);

            // Agregar controladores a las vistas
            PlayerController playerController1 = new PlayerController(player1, ball);
            //PlayerController playerController2 = new PlayerController(player2, ball);

            gamePanel.addKeyListener(playerController1);
            //gamePanel.addKeyListener(playerController2);
            gamePanel.setFocusable(true);
            
            // Crear observadores para los jugadores y el juego
            Vida playerObserver1 = new Vida(player1);
            //Vida playerObserver2 = new Vida(player2);
            Marcador gameObserver = new Marcador(game);

             // Configurar la ventana principal
            JFrame frame = new JFrame("Dodgeball Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(gamePanel);
            frame.setSize(800, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            // Iniciar el juego
            gameController.startGame();

        });
    }
}
