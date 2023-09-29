/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageprocessing;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;

/**
 *
 * @author Dama Putra
 */
public class Artimetika {
    public static void main(String args[]) throws IOException {
        int width, height;
        BufferedImage imgA=null, imgB=null, imgC=null;
        try{
            File input = new File("C:\\Users\\Dama Putra\\Pictures\\ImageProcessing\\B1.jpg");
            imgA=ImageIO.read(input);
            input = new File("C:\\Users\\Dama Putra\\Pictures\\ImageProcessing\\B2.jpg");
            imgB=ImageIO.read(input);
        }
        catch(IOException e){
            System.out.println(e);
        }
        
        //Memperoleh pixel A
        width=imgA.getWidth();
        height=imgA.getHeight();
        int matA[][]=new int[(width)][(height)];
        for(int y=0; y<height; y++){
            for(int x=0; x<width; x++){
                Color c=new Color(imgA.getRGB(x, y));
                int r=c.getRed();
                int g=c.getGreen();
                int b=c.getBlue();
                int avg=(r+b+g)/3;
                matA[x][y]=avg;
                System.out.print(" "+avg);
            }
            System.out.println(" ");
        }
        //Memperoleh pixel B
        width=imgB.getWidth();
        height=imgB.getHeight();
        int matB[][]=new int[(width)][(height)];
        for(int y=0; y<height; y++){
            for(int x=0; x<width; x++){
                Color c=new Color(imgB.getRGB(x, y));
                int r=c.getRed();
                int g=c.getGreen();
                int b=c.getBlue();
                int avg=(r+g+b)/3;
                matB[x][y]=avg;
                System.out.print(" "+avg);
            }
            System.out.println(" ");
        }
        
           //operasi penjumlahan======================
//         for(int y=0; y<height; y++){
//            for(int x=0; x<width; x++){
//                int operasi=matA[x][y]+matB[x][y];
//                if(operasi>255){
//                    operasi=255;
//                }
//                    System.out.print(" "+operasi);
//                    Color avgBaru = new Color(operasi,operasi,operasi);
//                    imgA.setRGB(x, y, avgBaru.getRGB());
//                }
//                System.out.println();
//            }
//            File Output=new File("C:\\Users\\Dama Putra\\Pictures\\ImageProcessing\\penjumlahanB1B2.png");
//            ImageIO.write(imgA, "jpg", Output);
//        }
    
//        //operasi pengurangan==================
//        for(int y=0; y<height; y++){
//            for(int x=0; x<width; x++){
//                int operasi=matA[x][y]-matB[x][y];
//                if(operasi<0){
//                    operasi=0;
//                }
//                    System.out.print(" "+operasi);
//                    Color avgBaru = new Color(operasi,operasi,operasi);
//                    imgA.setRGB(x, y, avgBaru.getRGB());
//                }
//                System.out.println();
//            }
//            File Output=new File("C:\\Users\\Dama Putra\\Pictures\\ImageProcessing\\penguranganB1B2.png");
//            ImageIO.write(imgA, "jpg", Output);
//        }
           
//        //operasi perkalian=================
          for(int y=0; y<height; y++){
            for(int x=0; x<width; x++){
                int temp=0;
                int operasi=matA[x][y]*matB[x][y];
                if(operasi<0){
                    temp=0;
                } 
                else 
                    if(operasi>255){
                    temp=255;
                    }
                    else{
                        temp=operasi;
                } 
                    System.out.print(" "+temp);
                    Color avgBaru = new Color(temp,temp,temp);
                    imgB.setRGB(x, y, avgBaru.getRGB());
                }
                System.out.println();
            }
            File Output=new File("C:\\Users\\Dama Putra\\Pictures\\ImageProcessing\\perkalianB1B2.png");
            ImageIO.write(imgB, "jpg", Output);
        }
    }
