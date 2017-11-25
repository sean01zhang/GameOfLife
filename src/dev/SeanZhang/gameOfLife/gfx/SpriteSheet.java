package dev.SeanZhang.gameOfLife.gfx;

//import statements
import java.awt.image.BufferedImage;

/**
 * This class is used to crop images. This was reused from one of my older projects. 
 * This class will be useful in the Assets class.
 * @author Sean Zhang and only Sean Zhang
 */
public class SpriteSheet {
    //creates an image varaible called sheet
    private BufferedImage sheet;
    
    /**
     * Constructor takes in the image from the parameter and sets it to be the sheet variable in this class
     * @param sheet This is the image taken in to be manipulated later
     */
    public SpriteSheet(BufferedImage sheet) {
        //assings the sheet variable inside the class to the parameter, sheet, taken in.
        this.sheet=sheet;
    } //end of constructor
    

    /**
     * This method will be helpful in separating textures from each other and getting the desired texture on the spreadsheet.
     * This will be used later in the Assets class.
     * @param x This is the x coordinate of where you want to start cropping
     * @param y This is the y coordinate of where you want to start cropping
     * @param width This is the width, or how far from the x coordinate you want to crop
     * @param height This is the height, or how far from the y coordinate you want to crop.
     * @return Returns the cropped image as a bufferedImage
     */
    public BufferedImage crop(int x,int y,int width,int height) {
        //returns the cropped image as a BufferedImage
        return sheet.getSubimage(x, y, width, height);
    } //end of crop method.
        
}
