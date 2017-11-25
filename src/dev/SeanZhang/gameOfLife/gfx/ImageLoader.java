package dev.SeanZhang.gameOfLife.gfx;

//import statements
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * ImageLoader class loads images (Self-explanatory)
 * @author Sean Zhang and only Sean Zhang
 */
public class ImageLoader {
    //takes in string parameter of the image path
    public static BufferedImage loadImage(String path) {
        try {
            //gets the resource from the path and returns it
            return ImageIO.read(ImageLoader.class.getResource(path));
        } catch (IOException e) {
            //prevents program from running if there is an error
            System.exit(1);
        }
        //otherwise, return null if there is an exception
        return null;
    }
}
