package dev.SeanZhang.gameOfLife.gfx;

//import statements
import java.awt.image.BufferedImage;
import java.util.Stack;

/**
 * Assets class. We will be accessing this class's variables in multiple classes.
 * This class's variables can be easily changed to accomodate a different set of tile images.
 * @author Sean Zhang and only Sean Zhang
 */
public class Assets {
    //public static varaibles so that they can be accessed by other classes
    private static int imgWidth;
    public static BufferedImage[][] imageTiles;
    public static BufferedImage black,white;

    /**
     * The initializes the assets inside the Assets class. This is static, since these values are specific to its class,
     * not the object (and they should not change)
     * @param w this is the width dimension of the 2D array (in terms of tiles)
     * @param imgW this is the dimension of the image when cropped so that it can fit in one tile.
     */
    public static void init(int w,int imgW) {
        //sets the image width to the parameter, imageWidth
        Assets.imgWidth=imgW;
        //initializes a new 2D buffered image array to store all the parts of the image
        imageTiles = new BufferedImage[w][w];
        //creates new spritesheet object from the image path specified below.
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/res/textures/gradient.png"));
        SpriteSheet bg = new SpriteSheet(ImageLoader.loadImage("/res/textures/black.png"));
        
        //loops through the imageTiles array and assings the corresponding fragment of the overall image to the specific index
        //In this case, this specific index is the index of the corresponding tile inside the gameEngine and gameBoard class.
        for(int i=0;i<imageTiles.length;i++) {
            for(int j=0;j<imageTiles[0].length;j++) {
                imageTiles[i][j] = sheet.crop(j*imgWidth,i*imgWidth,imgWidth,imgWidth);
            }
        }
        
        black = sheet.crop(0, 0, imgWidth, imgWidth);
    }
}
