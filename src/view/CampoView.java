package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import java.awt.*;

public class CampoView extends JPanel{
     private List<PlayerView> playerViews;
    private BallView ballView;
    private List<PowerUpView> powerUpViews;

    public CampoView() {
        playerViews = new ArrayList<>();
        powerUpViews = new ArrayList<>();
        // Inicializar otros componentes y configuraciones del panel según sea necesario
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Lógica para renderizar la interfaz gráfica
        renderPlayers(g);
        renderBall(g);
        renderPowerUps(g);
    }

    public void addPlayerView(PlayerView playerView) {
        playerViews.add(playerView);
    }

    public void setBallView(BallView ballView) {
        this.ballView = ballView;
    }

    public void addPowerUpView(PowerUpView powerUpView) {
        powerUpViews.add(powerUpView);
    }

    private void renderPlayers(Graphics g) {
        for (PlayerView playerView : playerViews) {
            playerView.render(g);
        }
    }

    private void renderBall(Graphics g) {
        if (ballView != null) {
            ballView.render(g);
        }
    }

    private void renderPowerUps(Graphics g) {
        for (PowerUpView powerUpView : powerUpViews) {
            powerUpView.render(g);
        }
    }
}
