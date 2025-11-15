package pinky_adventure;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameKeyListener extends KeyAdapter {
    private Player player;

    public GameKeyListener(Player player) {
        this.player = player;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            player.setMovingLeft(true);
        } else if (key == KeyEvent.VK_RIGHT) {
            player.setMovingRight(true);
        } else if (key == KeyEvent.VK_SPACE) {
            player.jump();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            player.setMovingLeft(false);
        } else if (key == KeyEvent.VK_RIGHT) {
            player.setMovingRight(false);
        }
        // Note: Space/Jump is typically not handled on keyReleased.
    }
}