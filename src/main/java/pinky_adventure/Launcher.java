package pinky_adventure;

import javax.swing.*;
import java.awt.Dimension;

public class Launcher {
    public static void main(String[] args) {
        // Run on the Event Dispatch Thread (EDT) for Swing safety
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Simple Java Game");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            GamePanel gamePanel = new GamePanel();
            frame.add(gamePanel);

            frame.pack(); // Sizes the frame to the preferred size of its contents
            frame.setResizable(false);
            frame.setLocationRelativeTo(null); // Center on screen
            frame.setVisible(true);
        });
    }
}