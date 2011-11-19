import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.*;
import javax.swing.event.*;


public class outputvis extends JPanel{
    
    public int disk_count ;  // No of disk ( always <=5 )
    public int[] tower1;
    public int[] tower2;
    public int[] tower3;
    public int local_n ;
    int source ;
    int destination ;

    public outputvis(){
        tower1 = new int[10];
        tower2 = new int[10];
        tower3 = new int[10];
        init();
    }
    public void init(){
        // initialize
        disk_count = 0 ;
        local_n = -1 ;
        source = -1;
        destination = -1;

        for ( int i = 0 ; i < 10 ; i ++ )
        {
            tower1[i] =  tower2[i] = tower3[i]  = -1 ;
        }
        repaint();
    }
    private void drawDisk(Graphics g , int tower_no , int position , int disk_no )  // largest disk
    {
        // tower_no = 1 , 2 ,3 ;
        // postion =  position of the disk from the bottom in the given tower ;( 1 , 2, 3 , 4, 5 )
        // disk_no = which disk : 1 - lagest disk , 5 - smallest disk
        if ( disk_no == 1)
        {
            g.setColor(Color.red);
            g.fillOval(40 + (tower_no -1 )*150  , 270 - (position - 1)*30, 140 , 30+2 );
        }
        else if ( disk_no == 2 )
        {
            g.setColor(Color.blue);
            g.fillOval(50 + (tower_no -1 )*150  , 270 - (position - 1)*30, 120 , 30+2 );

        }
        else if ( disk_no == 3 )
        {
            g.setColor(Color.green);
            g.fillOval(60 + (tower_no -1 )*150  , 270 - (position - 1)*30, 100 , 30+2 );
        }
        else if ( disk_no == 4 )
        {
            g.setColor(Color.yellow);
            g.fillOval(70 + (tower_no -1 )*150  , 270 - (position - 1)*30, 80 , 30+2 );
        }
        else if ( disk_no == 5 )
        {
            g.setColor(Color.lightGray);
            g.fillOval(80 + (tower_no -1 )*150  , 270 - (position - 1)*30, 60 , 30+2 );
        }
    }
    @Override
    public void paint(Graphics g){

        g.setColor(this.getBackground());
        g.fillRect(0,0,600,600);
        
        g.setColor(new Color(160,82,45));
// Rods ================================================
        g.fillRect(100 , 100 , 20 , 200);
        g.fillOval(100, 90 , 20, 20);
        
        g.fillRect(250 , 100 , 20 , 200);
        g.fillOval(250, 90 , 20, 20);

        g.fillRect(400 , 100 , 20 , 200);
        g.fillOval(400, 90 , 20, 20);
// Base ================================================
        g.fillRect(20 , 300 , 480 , 40);
// discs ===============================================
        int i ,j ;
        for ( i = 0 ; i < disk_count ; i ++)
        {
            j = 0 ;
            while ( tower1[j] != -1)
            {
                drawDisk( g ,1 , j + 1, tower1[j] );
                j++;
            }

            j = 0 ;
            while ( tower2[j] != -1)
            {
                drawDisk( g ,2 , j + 1, tower2[j] );
                j++;
            }
            
            j = 0 ;
            while ( tower3[j] != -1)
            {
                drawDisk( g ,3 , j + 1, tower3[j] );
                j++;
            }
        }
        g.setFont(new Font("Arial",Font.BOLD,20));
        g.setColor(new Color(0,0,0));
        g.drawString(" Towers Of Hanoi ", 160,30 );
        g.setColor( Color.red);
        if ( source != 1 && destination != 1 )
        {
            g.drawString(" Move top disk from Tower ".concat(String.valueOf(source)).concat(" --> ").concat(String.valueOf(destination)), 60,400 );
        }
        g.setColor( Color.blue);
        g.drawLine(0, 420, 600, 420);
        g.drawLine(0, 425, 600, 425);
        if ( local_n != 1 )
        {
            g.drawString(" Local Variable : n = ".concat(String.valueOf(local_n)), 140,450 );
        }

    }
}