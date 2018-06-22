import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageReaderAndWriter {

    public int[][] read(String filePath) throws IOException {
        BufferedImage image = ImageIO.read(getClass().getClassLoader().getResource(filePath));
        int row = image.getHeight();
        int column = image.getWidth();
        int[][] pixels = new int[row][column];
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < column; y++) {
                pixels[x][y] = image.getRGB(x, y);
            }
        }
        return pixels;
    }

    public void write(int[][] pixelsRGB, String outputFile) throws IOException {
        int width = pixelsRGB[0].length;
        int height = pixelsRGB.length;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int pixelRGB = pixelsRGB[i][j];
                image.setRGB(i, j, pixelRGB);
            }
        }
        ImageIO.write(image, "png", new File(outputFile));
    }
}
