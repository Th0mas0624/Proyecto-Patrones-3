package view;

import javax.swing.*;

public class GameFrame extends JFrame {

    public GameFrame(GamePanel gamePanel) {
        setTitle("Mi Juego");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(gamePanel);
        pack(); // Ajusta el tamaño del JFrame según su contenido


        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        setResizable(false); // Hace que la ventana no sea redimensionable
        setVisible(true);
    }
}
