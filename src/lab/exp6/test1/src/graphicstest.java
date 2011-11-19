import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.*;
import javax.swing.event.*;

public class graphicstest extends JPanel{
    public int state;
    public graphicstest(){
        state = 1;
    }


    @Override
    public void paint(Graphics g){
        g.drawRect(0,0,100,100);
        if(state == 0){
            g.drawString("DONE !",10, 10);
        }


    }
}