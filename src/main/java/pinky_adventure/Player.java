package pinky_adventure;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Player {
    // Current position
    private int x, y;
    // Game/Screen boundaries
    private final int screenWidth, screenHeight;
    // Player movement state
    private boolean movingLeft, movingRight;
    private boolean isJumping;
    private double verticalVelocity;
    private final double JUMP_STRENGTH = 15;
    private final double GRAVITY = 1;
    private final int HORIZONTAL_SPEED = 5;
    private final int GROUND_Y; // Player's resting Y position

    public Player(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        // Assume player image is loaded and has a size
        int playerHeight = GameResources.playerImg.getHeight();
        // Calculate ground Y based on the bottom of the screen
        this.GROUND_Y = screenHeight - playerHeight - 50; // 50 is a buffer/road offset
        this.x = screenWidth / 4; // Starting position
        this.y = GROUND_Y;
    }

    public void setMovingLeft(boolean movingLeft) { this.movingLeft = movingLeft; }
    public void setMovingRight(boolean movingRight) { this.movingRight = movingRight; }

    public void jump() {
        if (!isJumping) {
            isJumping = true;
            verticalVelocity = -JUMP_STRENGTH; // Negative velocity moves up
        }
    }

    public void update() {
        // --- Horizontal Movement ---
        if (movingLeft) {
            x -= HORIZONTAL_SPEED;
        }
        if (movingRight) {
            x += HORIZONTAL_SPEED;
        }

        // Clamp player position to screen borders
        int playerWidth = GameResources.playerImg.getWidth();
        if (x < 0) x = 0;
        if (x > screenWidth - playerWidth) x = screenWidth - playerWidth;

        // --- Vertical (Jump) Movement ---
        if (isJumping) {
            y += verticalVelocity;
            verticalVelocity += GRAVITY; // Apply gravity

            // Check if player lands back on the ground
            if (y >= GROUND_Y) {
                y = GROUND_Y; // Reset position to ground
                isJumping = false;
                verticalVelocity = 0;
            }
        }
    }

    public void draw(Graphics2D g2d) {
        if (GameResources.playerImg != null) {
            g2d.drawImage(GameResources.playerImg, x, y, null);
        }
    }
}