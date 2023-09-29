/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
/**
 *
 * @author Dama Putra
 */
public class Grayscale
{
  public static void main(String args[])throws IOException
  {
    BufferedImage image = null;
    File file = null;
    try
    {
      File f = new File("C:\\Users\\Dama Putra\\Pictures\\ImageProcessing\\zebra.jpg");
      image = ImageIO.read(f);
    }
    catch(IOException e)
    {
      System.out.println(e);
    }
    int width = image.getWidth();
    int height = image.getHeight();
    for (int y = 0; y < height; y++)
    {
      for (int x = 0; x < width; x++)
      {
        int p = image.getRGB(x,y);
        int a = (p>>24) & 0xff;
        int r = (p>>16) & 0xff;
        int g = (p>>8) & 0xff;
        int b = p & 0xff;
        int avg = (r+g+b)/3;
        p = (a<<24) | (avg<<16) | (avg<<8) | avg;
        image.setRGB(x, y, p);
      }
    }
    try
    {
      file = new File("C:\\Users\\Dama Putra\\Pictures\\ImageProcessing\\ZebraGray.png");
      ImageIO.write(image, "png", file);
      System.out.println("Successfully converted a colored image into a grayscale image");
    }
    catch(IOException e)
    {
      System.out.println(e);
    }
  }
}
