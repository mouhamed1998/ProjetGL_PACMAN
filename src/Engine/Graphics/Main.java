package Engine.Graphics;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        MazeWindow mazeWindow = new MazeWindow();

        /*
        ResizeImg resizeImg = new ResizeImg();

        String inImg = "/Users/ousmanecisse/Desktop/COURS_MASTER1/GL/PROJET2/src/API/ressource/pacman_img/Image/Coin/coin-normal.png";
        String outImg = "/Users/ousmanecisse/Desktop/COURS_MASTER1/GL/PROJET2/src/API/ressource/pacman_img/Image/Coin/coin-normal.png";
        ResizeImg.changeSize(inImg, outImg, 30, 30);
        /*
        for(int ms=0;ms<5;ms++){
            try {
                String inImg = "src/API/ressource/pacman_img/Image/Coin/fruit-"+ms+".png";
                String outImg = "src/API/ressource/pacman_img/Image/Coin/fruit-"+ms+".png";

                try
                {
                    int width = 30;
                    int height = 30;
                    ResizeImg.changeSize(inImg, outImg, width, height);
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }
            }catch(Exception e){
                System.out.println("ms: " + ms);
                e.printStackTrace();
            }
        }

         */

    }
}
