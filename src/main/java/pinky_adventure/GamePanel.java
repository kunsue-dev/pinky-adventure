package pinky_adventure;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final int WIDTH = 800;
    private final int HEIGHT = 600;
    private Player player;

    public GamePanel() {
        // Load images once when the game starts
        GameResources.loadImages();
        player = new Player(WIDTH, HEIGHT); // Pass dimensions for boundary checking
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));

        // Add Key Listener
        this.addKeyListener(new GameKeyListener(player));

        // Start the game loop (using a Swing Timer for thread-safety and updates)
        new Timer(15, e -> {
            player.update();
            repaint();
        }).start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // 1. Draw Background
        if (GameResources.backgroundImg != null) {
            g2d.drawImage(GameResources.backgroundImg, 0, 0, WIDTH, HEIGHT, this);
        } else {
            g2d.setColor(Color.CYAN); // Fallback color
            g2d.fillRect(0, 0, WIDTH, HEIGHT);
        }

        // 2. Draw Road (Non-moving, fixed position)
        if (GameResources.roadImg != null) {
            // Position the road at the bottom of the screen (adjust Y as needed)
            int roadY = HEIGHT - GameResources.roadImg.getHeight();
            g2d.drawImage(GameResources.roadImg, 0, roadY, WIDTH, GameResources.roadImg.getHeight(), this);
        }

        // 3. Draw Player
        player.draw(g2d);

        Toolkit.getDefaultToolkit().sync(); // Ensures smooth animation on some systems
    }

    // ... main method in a separate Launcher class
}