package view.main;

import view.CampoView;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private CampoView campoView;
    public GamePanel() {
        initializePanel();
        campoView = new CampoView();
        add(campoView);
    }
    private void initializePanel() {
        setPreferredSize(new Dimension(1200, 700));
        setBackground(Color.WHITE);
    }
}
