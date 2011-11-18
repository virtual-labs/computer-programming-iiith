import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.*;
import javax.swing.event.*;


public class StringVisual extends JPanel{


    public int a;
    public int b;


    public int local_i ;
    private double local_sum ;
    

    int mem1[];
    int mem2[];
    boolean found = false;

    public StringVisual(){
        mem1 = new int[20];
        mem2 = new int[20];

        init();
    }
    public void init(){
        // initialize
        a = 0 ;
        b = 0 ;
        local_i = -1 ;
        local_sum = -1 ;
        found = false ;


        for ( int i = 0 ; i < 10 ; i ++ )
        {
            mem1[i] =  mem2[i] =  -1 ;
        }
        repaint();
    }
    @Override
    public void paint(Graphics g1){

        int i , j ;
        Graphics2D g = (Graphics2D)g1;

        g.setColor(this.getBackground());
        g.fillRect(0,0,600,600);

        
// Axis ================================================
        g.setColor( Color.black);
        g.setStroke(new BasicStroke(3));
        g.drawLine(10 , 10 , 10 , 350);
        g.drawLine(10 , 170 , 500 , 170);
        g.setStroke(new BasicStroke(1));
        
        for ( i = 0 ; i < 21 ; i ++)
        {
            for ( j = 0 ; j < 17 ; j ++)
            {
                g.drawRect(10 + i * 20 , 10 + j* 20 , 20 , 20);
            }
        }
        for ( i = 0 ; i < 10 ; i++)
        {
            g.drawString(String.valueOf(i* 5) , i * (50) +1 , 185);
            g.setStroke(new BasicStroke(2));
            g.drawLine( 10+ i*50 , 165 ,10+ i * 50 , 175);
            g.setStroke(new BasicStroke(1));
        }
        for ( i = 1 ; i < 3 ; i++)
        {
            g.drawString(String.valueOf(i) , 0 , i * 80 + 170 + 15);
            g.drawString(String.valueOf(i) , 0 , 170 - i * 80 +15 );
            g.setStroke(new BasicStroke(2));
            g.drawLine(  5  , i * 80 + 170 ,15 , i * 80 + 170);
            g.drawLine(  5  , -i * 80 + 170 ,15 , -i * 80 + 170);
            g.setStroke(new BasicStroke(1));
        }

// Naming ================================================
        g.setFont(new Font("Arial",Font.BOLD,20));
        g.setColor(new Color(16,82,45));
        

        g.setColor(new Color(160,82,45));
        //g.drawString("Memory Map of str2 :", 40 , 170);

        
// graph ===============================================
        int y1,y2 ;
        double x ;
        int count_bin = local_i;
        int start_count = a;
        local_sum = 0 ;
        for ( x = 0 ; x < 50 ; x +=.5)
        {
            if ( count_bin <= 0)
            {
                break;  // According to code
            }
            if ( start_count > 0)
            {
                start_count--;
                count_bin--;
                continue;
            }
            count_bin--;

            i = (int)(x*20);
            y1 = (int)(java.lang.Math.cos(x)*80);

            local_sum = local_sum + java.lang.Math.cos(2*java.lang.Math.PI*2*x/13) * 1;
            g.setColor( Color.blue);
            if ( y1 > 0)
            {
                g.fillRect(10 + i , 170 -y1 ,10 , y1 );
            }
            else
            {
                   g.fillRect(10 + i , 170  ,10 ,-1*y1  );
            }
        }


        // BINS
        g.setStroke(new BasicStroke(3));
        for ( x = 0 ; x < 50 ; x +=.1)
        {
               i = (int)(x*20);
               g.setColor( Color.red);
               y1 = (int)(java.lang.Math.cos(x)*80);
               y2 = (int)(java.lang.Math.cos(x+.1)*80);

               g.drawLine(10 + i , 170 -y1 ,10+i+1 , 170 - y2 );
        }

        
        g.setStroke(new BasicStroke(1));

//Result =================================================================
        int out = (int)(local_sum * 100) ;
        double local2sum = (double)out / 100;
        g.setColor( Color.red);
        g.setFont(new Font("Arial",Font.BOLD,15));
        if ( found == true )
        {
                g.drawString( "OUTPUT :     Integration value = ".concat(String.valueOf(local2sum)), 10 , 450);
        }
        else
        {
                g.drawString( "OUTPUT : ", 10 , 450);
        }

// Mem Pointers ========================================================
        
        g.setFont(new Font("Arial",Font.BOLD,15));
        g.setColor( Color.blue);
        g.drawLine(0, 380, 600, 380);
        g.drawLine(0, 385, 600, 385);
        g.drawString("LOCAL VARIABLES : " , 10,410 );
        if ( local_i != -1 )
        {
            g.drawString(" i = ".concat(String.valueOf(local_i)), 200 ,410 );
            g.drawString(" sum = ".concat(String.valueOf(local2sum)), 260,410 );
        
        }

    }
}