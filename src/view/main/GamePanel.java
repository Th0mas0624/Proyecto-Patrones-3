// GamePanel.java
package view.main;

import view.CampoView;

import util.*;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private CampoView campoView;

    public GamePanel() {
        initializePanel();
        initializeCampoView();
    }

    private void initializePanel() {
        setPreferredSize(new Dimension(Constants.FIELD_WIDTH, Constants.FIELD_HEIGHT));
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
    }

    private void initializeCampoView() {
        campoView = new CampoView();
        add(campoView, BorderLayout.CENTER);
    }
}
