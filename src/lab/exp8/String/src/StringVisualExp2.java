import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.*;
import javax.swing.event.*;


public class StringVisualExp2 extends JPanel{

    public String str1;
    public String str2;

    public int l1; // length of srt1
    public int l2; // length of str2


    public int local_i ;
    public int local_j ;
    

    int mem1[];
    int mem2[];
    int found = -1 ;

    public StringVisualExp2(){
        mem1 = new int[20];
        mem2 = new int[20];

        init();
    }
    public void init(){
        // initialize
        l1 = 0 ;
        l2 = 0 ;
        local_i = -1 ;
        local_j = -1 ;
    
        found = -1 ;


        for ( int i = 0 ; i < 10 ; i ++ )
        {
            mem1[i] =  mem2[i] =  -1 ;
        }
        repaint();
    }
    @Override
    public void paint(Graphics g){

        int i , j ;
        g.setColor(this.getBackground());
        g.fillRect(0,0,600,600);

        
// Mem1 ================================================
        g.setColor(new Color(16,82,45));
        g.drawRect(10 , 60 , 500 , 40);
        
        for ( i = 0 ; i < 20 ; i ++)
        {
            g.drawRect(10 + i * 50 , 60 , 500 , 40);
        }

// Mem2 ================================================
        g.setColor(new Color(160,82,45));
        g.drawRect(10 , 200 , 500 , 40);
        for ( i = 0 ; i < 20 ; i ++)
        {
            g.drawRect(10 + i * 50 , 200 , 500 , 40);
        }
// Naming ================================================
        g.setFont(new Font("Arial",Font.BOLD,20));
        g.setColor(new Color(16,82,45));
        g.drawString("Memory Map of str1 :", 40 , 40);

        g.setColor(new Color(160,82,45));
        g.drawString("Memory Map of str2 :", 40 , 170);

        
// Mem Value ===============================================

        g.setColor(new Color(16,82,45));
        System.out.print(l1);
        
        for ( i = 0 ; i < l1 ; i ++)
        {
            //if ( found == true && i < local_k && i >= local_i)
            //{
              //  g.setColor(new Color(160,82,45));
              //  g.drawString( String.valueOf(str1.charAt(i)), 25 + i*50 , 90);
            //}
            //else
            //{
                g.setColor(new Color(16,82,45));
                g.drawString( String.valueOf(str1.charAt(i)), 25 + i*50 , 90);
            //}
        }
        g.drawString( "\\0", 25 + i*50 , 90);
        
        g.setColor(new Color(160,82,45));
        for ( i = 0 ; i < l2 ; i ++)
        {
            g.drawString(String.valueOf(str2.charAt(i)), 25 + i*50 , 230);
        }
        g.drawString( "\\0", 25 + i*50 , 230);
//Result =================================================================
        g.setColor(new Color(0,0,0));
        g.setFont(new Font("Arial",Font.BOLD,15));
        if ( found == 0 )
        {
                g.drawString( "OUTPUT :     Strings str2 and str1 are same .", 20 , 300);
        }
        else if (found == 1 )
        {
                g.drawString( "OUTPUT :     Strings str1 is greater than str2 .", 20 , 300);
                
        }
        else if (found == 2 )
        {
                g.drawString( "OUTPUT :     Strings str2 is greater than str1 .", 20 , 300);
        }
        else
        {
                g.drawString( "OUTPUT : ", 20 , 300);
        }

// Mem Pointers ========================================================
        g.setColor(new Color(0,0,0));
        
        g.drawString( "i", 30 + local_i * 50 , 120);//g.drawLine(20, 120, 20, 100);
        g.drawString( "j", 30 + local_j * 50 , 260);//g.drawLine(30, 260, 30, 240);

        g.setFont(new Font("Arial",Font.BOLD,20));
        g.setColor( Color.black);
        g.drawLine(0, 320, 600, 320);
        g.drawLine(0, 325, 600, 325);
        g.drawString(" Local Variables : " , 20,350 );
        if ( local_i != -1 )
        {
            g.drawString(" i = ".concat(String.valueOf(local_i)), 40 ,400 );
            g.drawString(" j = ".concat(String.valueOf(local_j)), 140,400 );
        }

    }
}