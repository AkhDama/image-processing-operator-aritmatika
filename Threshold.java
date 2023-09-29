/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Dama Putra
 */
public class Threshold {
  public static void main(String args[])throws IOException
  {
    BufferedImage image = null;
    File file = null;
    try
    {
      File f = new File("C:\\Users\\Dama Putra\\Pictures\\ImageProcessing\\contractor.jpg");
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
        if(avg<128){
            avg=0;
        }
        else{
            avg=255;
        }
        image.setRGB(x, y, avg);
        p = (a<<24) | (avg<<16) | (avg<<8) | avg;
        image.setRGB(x, y, p);
      }
    }
    
    try
    {
      file = new File("C:\\Users\\Dama Putra\\Pictures\\ImageProcessing\\ContractorThres.jpg");
      ImageIO.write(image, "jpg", file);
      System.out.println("Successfully converted a colored image into a Threshold image");
    }
    catch(IOException e)
    {
      System.out.println(e);
    }
  }
}    
