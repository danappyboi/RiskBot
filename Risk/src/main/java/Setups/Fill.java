package Setups;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Fill {
    static int i = 0;
    public static void main(String [] args) throws IOException {
        BufferedImage image = ImageIO.read(new File("C:/Users/helio/Desktop/RiskImages/CleanUSMap.jpg"));
        Color datColor = new Color(250, 0,0);
        floodFill(image, 100,400, datColor);
        writeImage(image);
        System.out.println(i);
        BufferedImage image1 = ImageIO.read(new File("C:/Users/helio/Desktop/coloredUSMap" + (i-1) + ".jpg"));
        Color datColor1 = new Color(0, 250,0);
        floodFill(image1, 775, 480, datColor1);
        writeImage(image1);
        System.out.println(i);
        BufferedImage image2 = ImageIO.read(new File("C:/Users/helio/Desktop/coloredUSMap" + (i-1) + ".jpg"));
        Color datColor2 = new Color(0, 250,250);
        floodFill(image2, 900,560, datColor2);
        writeImage(image2);
        System.out.println(i);
    }


    // A recursive function to replace previous color 'prevC' at '(x, y)'
// and all surrounding pixels of (x, y) with new color 'newC' and
    static void floodFillUtil(BufferedImage img, int x, int y, Color prevC, Color newC) {
        int w = img.getWidth();
        int h = img.getHeight();

        // Base cases
        if (x < 0 || x >= w || y < 0 || y >= h)
            return;
        int color = img.getRGB(x, y);
        int blue = color & 0xff;
        int green = (color & 0xff00) >> 8;
        int red = (color & 0xff0000) >> 16;
        Color thingy = new Color(red, green, blue);

        if (!thingy.equals(prevC))
            return;

        // Replace the color at (x, y)
        int newCInt = newC.getRGB();
        img.setRGB(x, y, newCInt);

        // Recur for north, east, south and west
        floodFillUtil(img, x+1, y, prevC, newC);
        floodFillUtil(img, x-1, y, prevC, newC);
        floodFillUtil(img, x, y+1, prevC, newC);
        floodFillUtil(img, x, y-1, prevC, newC);
    }

    // It mainly finds the previous color on (x, y) and
// calls floodFillUtil()
    static void floodFill(BufferedImage img, int x, int y, Color newC)
    {
        int prevCInt = img.getRGB(x, y);
        int blue = prevCInt & 0xff;
        int green = (prevCInt & 0xff00) >> 8;
        int red = (prevCInt & 0xff0000) >> 16;
        Color prevC = new Color(red, green, blue);
        if(prevC.equals(newC)) return;
        floodFillUtil(img, x, y, prevC, newC);
    }

    public static void writeImage(BufferedImage image) {
        String path = "C:/Users/helio/Desktop/coloredUSMap" + i + ".jpg";
        File ImageFile = new File(path);
        try {
            ImageIO.write(image, "jpg", ImageFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        i++;

    }
}
