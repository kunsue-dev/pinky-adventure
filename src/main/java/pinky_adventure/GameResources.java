package pinky_adventure;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

public class GameResources {
    public static BufferedImage roadImg;
    public static BufferedImage backgroundImg;
    public static BufferedImage playerImg;

    public static void loadImages() {
        try {
            // The '/' at the beginning signifies the root of the classpath (your resources folder)
            backgroundImg = ImageIO.read(GameResources.class.getResource("/resources/sprites/scene1.png"));
            roadImg = ImageIO.read(GameResources.class.getResource("/resources/sprites/road.png"));
            playerImg = ImageIO.read(GameResources.class.getResource("/resources/sprites/pinky.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1); // Exit if critical resources can't be loaded
        }
    }
}