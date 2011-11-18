/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arrayprog;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Dimension2D;
//import java.text.AttributedCharacterIterator;
//import java.util.Map;
//import java.util.Set;
import javax.swing.JPanel;

/**
 *
 * @author abhiramj
 */
public class DrawPanel extends JPanel{
coderunner program;
static Square [] sqArray ;
public DrawPanel(){}
DrawPanel(coderunner program){
this.program=program;

}
coderunner getProgram(){return this.program;}
void setProgram(coderunner program){this.program=program;}
//static Square [] sqArray ;
   
    @Override
    public void paintComponent (Graphics g){

int squareW = 30;
int squareH = 20;
super.paintComponent(g);
  g.drawString("Insertion sort sorts an array of n elements \n" +
                "by assuming n-1 elements are sorted and inserting nth element " +
                "in the correct position ",10,20);
        Dimension2D r = this.getSize();
        int rectInRow;
        
        //Square sq =new Square(0,0,0,0);
        if (program == null)
        {
        } else {
        sqArray = new Square[program.size];
            int noRect = program.size;
            int rectIterator = 0;
            if (program.currindex >1 )
        {
            System.out.println("In paint");
            rectInRow = (int) ((r.getWidth() - 20)/(squareW+10));
            
                int posystart=squareH+10;
            do {
               
            int posxstart =10;
            if (rectInRow > noRect){
                rectInRow = noRect;
            }

            for (int i=0;i<rectInRow;i++){
                
                
//                sq.setX(posxstart);
//                sq.setY(posystart);
//                sq.setIndex(rectIterator);
//                sq.setVal(program.A[rectIterator]);
               // sq.paintSquare(g,Color.white);
                sqArray[rectIterator]=new Square(posxstart,posystart,rectIterator,program.A[rectIterator]);
                System.out.println(program.A[rectIterator]);
                posxstart+=squareW+10;
                System.out.println("outputted"+ rectIterator );
                rectIterator++;               
                
            }

            posystart +=30;
            noRect = noRect -rectInRow;
            } while (noRect>0);
 
               if (program.keypos != -1){
                for(int k=0;k<program.size;k++)
                {
                    System.out.println("k is " + k);
                    if( k<program.keypos )
                    {
                        sqArray[k].paintSquare(g, Color.white);
                    }
                    if ( k==program.j )
                    {

                        sqArray[k].paintSquare(g, Color.green);
                    }
                    
                    if(k == program.keypos )
                    {
                        sqArray[k].paintSquare(g, Color.blue);
                    }
                    if(k > program.keypos && k < program.size)
                    {
                        System.out.println("K is" + k);
                        sqArray[k].paintSquare(g, Color.cyan);
                    }
                   }
                
               }

                }

                
           // else if ()
            g.setColor(Color.black);
g.drawRect((int) r.getWidth()-140,(int) r.getHeight()-180, 139, 110);
g.drawRect((int) r.getWidth()-130,(int) r.getHeight()-170, 30, 20);

g.drawString("Sorted Array",(int) r.getWidth()-90,(int) r.getHeight()-155);
g.setColor(Color.white);
g.fillRect((int) r.getWidth()-130,(int) r.getHeight()-170, 30, 20);
g.setColor(Color.black);
g.drawRect((int) r.getWidth()-130,(int) r.getHeight()-140, 30, 20);
g.drawString("Key position",(int) r.getWidth()-90,(int) r.getHeight()-125);
g.setColor(Color.blue);

g.fillRect((int) r.getWidth()-130,(int) r.getHeight()-140, 30, 20);
g.setColor(Color.black);
g.drawRect((int) r.getWidth()-130,(int) r.getHeight()-110, 30, 20);

g.drawString("Unsorted Array",(int) r.getWidth()-90,(int) r.getHeight()-95);
g.setColor(Color.cyan);
g.fillRect((int) r.getWidth()-130,(int) r.getHeight()-110, 30, 20);
g.setColor(Color.black);



g.drawRect(10,(int) r.getHeight()-170, 30, 20);
g.drawString(Integer.toString(program.key), 15,(int)r.getHeight()-155);
g.drawString("Key value",50,(int) r.getHeight()-155);
//g.setColor(Color.white);
//g.fillRect((int) r.getWidth()-130,(int) r.getHeight()-170, 30, 20);


}
        }

}
class Square{

    private int index=0;
    private int val=0;
    private int xPos = 50;
    private int yPos = 50;
    private int width = 30;
    private int height = 20;


    Square (int xpos,int ypos, int index,int val){
    this.xPos=xpos;
    this.yPos=ypos;
    this.index=index;
    this.val=val;
    }
    public void setX(int xPos){
        this.xPos = xPos;
    }

    public int getX(){
        return xPos;
    }

    public void setY(int yPos){
        this.yPos = yPos;
    }

    public int getY(){
        return yPos;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public void setIndex (int countRect) {
    index = countRect;
    }
    public int getIndex () {
    return index;
    }

    public void setVal (int val) {
    this.val = val;
    }
    public int getVal () {
    return this.val;
    }

    public void paintSquare(Graphics g, Color r){
        g.setColor(r);
        g.fillRect(xPos,yPos,width,height);
        g.setColor(Color.black);
        g.drawRect(xPos,yPos,width,height);
        g.setColor(Color.red);
        g.drawString(Integer.toString(this.getVal()), this.getX()+2, this.getY()+15);
    }
}
