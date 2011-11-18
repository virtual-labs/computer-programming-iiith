import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.*;
import javax.swing.event.*;


public class outputvis extends JPanel{
    public int[][] rectx;
    public int[][] recty;
    int cell_width;
    int cell_height;
    int count;

    public outputvis(){
        rectx = new int[20][4];
        recty = new int[20][4];
        cell_width = 70;
        cell_height = 20;
        for(int i = 0 ; i < 20 ; i++){
            for(int j = 0 ; j < 4 ; j++){
                rectx[i][j] = 80 + j*cell_width;
                recty[i][j] = 50 + i*cell_height;
            }
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setFont(new Font("Arial",Font.BOLD,20));
        g.setColor(new Color(0,0,0));
        g.drawString("Memory Map", 150,20 );
        
        g.setFont(new Font("Arial",Font.BOLD,14));
        g.setColor(new Color(0,128,0));
        g.drawString("Address",10, recty[0][0] -5 );
        g.drawString("Variable",80+4*cell_width + 5, recty[0][0] -5);
        g.drawString("BYTE 1",80+0*cell_width + 5, recty[0][0]-5);
        g.drawString("BYTE 2",80+1*cell_width + 5, recty[0][0]-5);
        g.drawString("BYTE 3",80+2*cell_width + 5, recty[0][0]-5);
        g.drawString("BYTE 4",80+3*cell_width + 5, recty[0][0]-5);
        g.setFont(new Font("Arial",Font.PLAIN,12));
        g.setColor(new Color(0,0,0));
        for(int i = 0; i < 16 ; i++){
            g.drawString(""+(15-i)*4+"", 40 , recty[i+1][0] - 5);
            for(int j = 0 ; j < 4 ; j++){
                g.drawRect(rectx[i][j], recty[i][j], cell_width, cell_height);
                g.setColor(new Color(255,255,255));
                g.fillRect(rectx[i][j]+1, recty[i][j]+1, cell_width-1, cell_height-1);
                g.setColor(new Color(0,0,0));

            }
            if(i == 15){
                g.setColor(new Color(0,255,255));
                g.fillRect(rectx[i][0] + 1, recty[i][0] + 1, 4*cell_width - 1 , cell_height - 1);
                g.setColor(new Color(0,0,0));
                g.drawString("Reserved by OS", rectx[i][0] + cell_width , recty[i][0] + cell_height -5);
            }
            if(i == 14 || i == 13){
                g.setColor(new Color(255,255,0));
                g.fillRect(rectx[i][0] + 1, recty[i][0] + 1, 4*cell_width - 1 , cell_height - 1);
                g.setColor(new Color(0,0,0));
                g.drawString("Program Memory", rectx[i][0] + cell_width , recty[i][0] + cell_height-5);
            }
        }
        for(int i = 1; i <= count; i++){
            paint_call(g,i);
        }


        
    }

    public void paint_call(Graphics g, int x){
        switch(x){
             case 2:
                g.setColor(new Color(255,0,255));
                g.fillRect(rectx[0][0] + 1, recty[0][0] + 1, cell_width - 1 , cell_height - 1);
                g.setColor(new Color(0,0,0));
                g.drawString("0", rectx[0][0]+2, recty[0][0]+ cell_height-2);
                g.setColor(new Color(255,0,255));
                g.fillRect(rectx[0][1] + 1, recty[0][1]+ 1, cell_width - 1 , cell_height - 1);
                g.setColor(new Color(0,0,0));
                g.drawString("0", rectx[0][1]+2, recty[0][1]+ cell_height-2);
                g.setColor(new Color(255,0,255));
                g.fillRect(rectx[0][2] + 1, recty[0][2] + 1, cell_width - 1 , cell_height - 1);
                g.setColor(new Color(0,0,0));
                g.drawString("0", rectx[0][2]+2, recty[0][2]+ cell_height-2);
                g.setColor(new Color(255,0,255));
                g.fillRect(rectx[0][3] + 1, recty[0][3] + 1, cell_width - 1 , cell_height - 1);
                g.setColor(new Color(0,0,0));
                if(count >= 5 && count<9){
                    g.drawString("9", rectx[0][3]+2, recty[0][3]+ cell_height-2);
                }
                else
                    g.drawString("5", rectx[0][3]+2, recty[0][3]+ cell_height-2);
                g.drawString("A",rectx[0][3] + cell_width +10,recty[0][3]+ cell_height -1);

                g.setColor(new Color(255,0,255));
                g.fillRect(rectx[0][0] + 1, recty[1][0] + 1, cell_width - 1 , cell_height - 1);
                g.setColor(new Color(0,0,0));
                g.drawString("0", rectx[0][0]+2, recty[1][0]+ cell_height-2);
                g.setColor(new Color(255,0,255));
                g.fillRect(rectx[0][1] + 1, recty[1][1]+ 1, cell_width - 1 , cell_height - 1);
                g.setColor(new Color(0,0,0));
                g.drawString("0", rectx[0][1]+2, recty[1][1]+ cell_height-2);
                g.setColor(new Color(255,0,255));
                g.fillRect(rectx[0][2] + 1, recty[1][2] + 1, cell_width - 1 , cell_height - 1);
                g.setColor(new Color(0,0,0));
                g.drawString("0", rectx[0][2]+2, recty[1][2]+ cell_height-2);
                g.setColor(new Color(255,0,255));
                g.fillRect(rectx[0][3] + 1, recty[1][3] + 1, cell_width - 1 , cell_height - 1);
                g.setColor(new Color(0,0,0));
                if(count >= 5 && count<9){
                    g.drawString("5", rectx[0][3]+2, recty[1][3]+ cell_height-2);
                }
                else
                    g.drawString("9", rectx[0][3]+2, recty[1][3]+ cell_height-2);
                g.drawString("B",rectx[0][3] + cell_width +10,recty[1][3]+ cell_height -1);
                break;
            case 10:
                g.setColor(new Color(255,0,255));
                g.fillRect(rectx[0][0] + 1, recty[5][0] + 1, cell_width - 1 , cell_height - 1);
                g.setColor(new Color(0,0,0));
                g.drawString("0", rectx[0][0]+2, recty[5][0]+ cell_height-2);
                g.setColor(new Color(255,0,255));
                g.fillRect(rectx[0][1] + 1, recty[5][1]+ 1, cell_width - 1 , cell_height - 1);
                g.setColor(new Color(0,0,0));
                g.drawString("0", rectx[0][1]+2, recty[5][1]+ cell_height-2);
                g.setColor(new Color(255,0,255));
                g.fillRect(rectx[0][2] + 1, recty[5][2] + 1, cell_width - 1 , cell_height - 1);
                g.setColor(new Color(0,0,0));
                g.drawString("0", rectx[0][2]+2, recty[5][2]+ cell_height-2);
                g.setColor(new Color(255,0,255));
                g.fillRect(rectx[0][3] + 1, recty[5][3] + 1, cell_width - 1 , cell_height - 1);
                g.setColor(new Color(0,0,0));
                g.drawString("60", rectx[0][3]+2, recty[5][3]+ cell_height-2);
                g.drawString("Pa",rectx[0][3] + cell_width +10,recty[5][3]+ cell_height -1);

                g.setColor(new Color(255,0,255));
                g.fillRect(rectx[0][0] + 1, recty[6][0] + 1, cell_width - 1 , cell_height - 1);
                g.setColor(new Color(0,0,0));
                g.drawString("0", rectx[0][0]+2, recty[6][0]+ cell_height-2);
                g.setColor(new Color(255,0,255));
                g.fillRect(rectx[0][1] + 1, recty[6][1]+ 1, cell_width - 1 , cell_height - 1);
                g.setColor(new Color(0,0,0));
                g.drawString("0", rectx[0][1]+2, recty[6][1]+ cell_height-2);
                g.setColor(new Color(255,0,255));
                g.fillRect(rectx[0][2] + 1, recty[6][2] + 1, cell_width - 1 , cell_height - 1);
                g.setColor(new Color(0,0,0));
                g.drawString("0", rectx[0][2]+2, recty[6][2]+ cell_height-2);
                g.setColor(new Color(255,0,255));
                g.fillRect(rectx[0][3] + 1, recty[6][3] + 1, cell_width - 1 , cell_height - 1);
                g.setColor(new Color(0,0,0));
                g.drawString("56", rectx[0][3]+2, recty[6][3]+ cell_height-2);
                g.drawString("Pb",rectx[0][3] + cell_width +10,recty[6][3]+ cell_height -1);
                break;
            case 11:
                g.setColor(new Color(255,0,255));
                g.fillRect(rectx[0][0] + 1, recty[7][0] + 1, cell_width - 1 , cell_height - 1);
                g.setColor(new Color(0,0,0));
                g.drawString("0", rectx[0][0]+2, recty[7][0]+ cell_height-2);
                g.setColor(new Color(255,0,255));
                g.fillRect(rectx[0][1] + 1, recty[7][1]+ 1, cell_width - 1 , cell_height - 1);
                g.setColor(new Color(0,0,0));
                g.drawString("0", rectx[0][1]+2, recty[7][1]+ cell_height-2);
                g.setColor(new Color(255,0,255));
                g.fillRect(rectx[0][2] + 1, recty[7][2] + 1, cell_width - 1 , cell_height - 1);
                g.setColor(new Color(0,0,0));
                g.drawString("0", rectx[0][2]+2, recty[7][2]+ cell_height-2);
                g.setColor(new Color(255,0,255));
                g.fillRect(rectx[0][3] + 1, recty[7][3] + 1, cell_width - 1 , cell_height - 1);
                g.setColor(new Color(0,0,0));
                g.drawString("5", rectx[0][3]+2, recty[7][3]+ cell_height-2);
                g.drawString("temp",rectx[0][3] + cell_width +10,recty[7][3]+ cell_height -1);
                break;
            case 12:
                g.setColor(new Color(255,0,255));
                g.fillRect(rectx[0][3] + 1, recty[0][3] + 1, cell_width - 1 , cell_height - 1);
                g.setColor(new Color(0,0,0));
                g.drawString("9", rectx[0][3]+2, recty[0][3]+ cell_height-2);
                break;
            case 13:
                g.setColor(new Color(255,0,255));
                g.fillRect(rectx[0][3] + 1, recty[1][3] + 1, cell_width - 1 , cell_height - 1);
                g.setColor(new Color(0,0,0));
                g.drawString("5", rectx[0][3]+2, recty[1][3]+ cell_height-2);
                break;


          
            default:
                break;
        }
    }
}