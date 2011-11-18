/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arrayprog;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.awt.geom.Dimension2D;
//import java.text.AttributedCharacterIterator;
//import java.util.Map;
//import java.util.Set;
import java.awt.geom.Line2D;
import javax.swing.JPanel;

/**
 *
 * @author abhiramj
 */
public class DrawPanel extends JPanel{
coderunner program;
coderunner2 program2D;
int progSel;



static Square [] sqArray ;
Square [][] matBoxA;
Square [][] matBoxB;
Square [][] matBoxC;
public DrawPanel(){}
DrawPanel(coderunner p1,coderunner2 p2){

    this.program= p1;


    this.program2D= p2;


}
  public void setProgSel(int progSel) {
        this.progSel = progSel;
    }

 public int getProgSel() {
        return progSel;
    }
coderunner getProgram()
{
    return this.program;
}
void setProgram(coderunner program){
    this.program=program;
}
//static Square [] sqArray ;
   
    @Override
    public void paintComponent (Graphics g){

super.paintComponent(g);
Dimension2D r = this.getSize();
switch(progSel){
    case 0:

int squareW = 30;
int squareH = 20;
        
        int rectInRow;
        
        //Square sq =new Square(0,0,0,0);
        if (program == null)
        {
        } else {
              Square.height=20;
            Square.width=30;
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
                
                sqArray[rectIterator]=new Square(posxstart,posystart,rectIterator,program.A[rectIterator]);
                System.out.println(program.A[rectIterator]);
                posxstart+=squareW+10;
                System.out.println("outputted"+ rectIterator );
                rectIterator++;               
                
            }

            posystart +=30;
            noRect = noRect -rectInRow;
            } while (noRect>0);
float alpha = 0.25f;
int type = AlphaComposite.SRC_OVER;
AlphaComposite composite =
  AlphaComposite.getInstance(type, alpha);
               if (program.keypos != -1){
                for(int k=0;k<program.size;k++)
                {
                    System.out.println("k is " + k);
                    if( k<program.keypos )
                    {
                        sqArray[k].paintSquare(g, Color.white);
                    }
//                    if ( k==program.j )
//                    {
//
//                        sqArray[k].paintSquare(g, Color.green);
//                    }
                    
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
                if ( program.currindex==8 && program.j>=0){
               g.drawRoundRect(sqArray[program.j].xPos-5, sqArray[program.j].yPos-5, Square.width*2+20, Square.height+10, 3, 3);
               g.setColor(new Color(0,1,0,alpha));
               g.fillRoundRect(sqArray[program.j].xPos-5, sqArray[program.j].yPos-5, Square.width*2+20, Square.height+10, 3, 3);
               g.setColor(Color.black);
               arrowDraw a1 = new arrowDraw();
                a1.setLine(sqArray[(program.j)].xPos+5,sqArray[(program.j)].yPos+10,sqArray[(program.j)+1].xPos+5,sqArray[(program.j)+1].yPos+10, g);
                //a1.drawArrowHead((Graphics2D) g);

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



g.drawRect(10,(int) r.getHeight()-110, 30, 20);
g.drawString(Integer.toString(program.key), 15,(int)r.getHeight()-95);
g.drawString("Key value",50,(int) r.getHeight()-95);
arrowDraw a2=new arrowDraw();
if (program.currindex==11){
a2.setLine(30,(int) r.getHeight()-115,sqArray[(program.j+1)].xPos,sqArray[(program.j+1)].yPos+20, g);
}
//g.setColor(Color.white);
//g.fillRect((int) r.getWidth()-130,(int) r.getHeight()-170, 30, 20);


}
        break;
    case 1:
        if (program2D == null)
        {
System.out.println("Null argument to paint");
        } else{
            System.out.println("Non Null argument to paint");
            Square.height=30;
            Square.width=30;
        matBoxA = new Square[program2D.i][program2D.j];
        matBoxB = new Square[program2D.j][program2D.k];
        matBoxC = new Square[program2D.i][program2D.k];
            if (program2D.currindex >1 )
            {
            int posxstart=30;
            int posystart=30;
            g.drawString("Matrix A", posxstart+10, posystart-10);
            for (int l=0;l<program2D.i;l++)
            {
            posxstart=10;
                for (int m=0;m<program2D.j;m++)
                {
                    matBoxA[l][m]=new Square(posxstart,posystart,0,program2D.matA[l][m]);
                    posxstart+=Square.width;
                }
                posystart+=Square.height;
            }

              for (int l=0;l<program2D.i;l++)
            {
            
                for (int m=0;m<program2D.j;m++)
                {
                    if (program2D.p==l && program2D.p>=0){
                        matBoxA[l][m].paintSquare(g, Color.green);
                    } else matBoxA[l][m].paintSquare(g, Color.white);
                }

            }

            // This is for priniting matrix B
            //
            posxstart= (int )r.getWidth()- program2D.j*Square.width-30;
            posystart=30;
            g.setColor(Color.black);
            g.drawString("Matrix B", posxstart+10, posystart-10);
            for (int l=0;l<program2D.j;l++)
            {
            posxstart= (int )r.getWidth()- program2D.j*Square.width-30;
                for (int m=0;m<program2D.k;m++)
                {
                    matBoxB[l][m]=new Square(posxstart,posystart,0,program2D.matB[l][m]);
                    posxstart+=Square.width;
                }
                posystart+=Square.height;
            }

              for (int l=0;l<program2D.j;l++)
            {

                for (int m=0;m<program2D.k;m++)
                {
                    if (program2D.r==m && program2D.r>=0){
                        matBoxB[l][m].paintSquare(g, Color.green);
                    } else matBoxB[l][m].paintSquare(g, Color.white);
                }

            }


            // This is for printing Matrix result


             posxstart= (((int )r.getWidth()- program2D.i*Square.width)/2);
            posystart=posystart+30;
            g.setColor(Color.black);
            g.drawString("Matrix Result", posxstart+10, posystart-10);
            for (int l=0;l<program2D.i;l++)
            {
            posxstart= (((int )r.getWidth()- program2D.i*Square.width)/2);
                for (int m=0;m<program2D.k;m++)
                {
                    matBoxC[l][m]=new Square(posxstart,posystart,0,program2D.matMult[l][m]);
                    posxstart+=Square.width;
                }
                posystart+=Square.height;
            }

              for (int l=0;l<program2D.i;l++)
            {

                for (int m=0;m<program2D.k;m++)
                {
                    try{
                         if ((program2D.p==l) && (program2D.r==m) && program2D.r>=0 && program2D.p>=0){
                        matBoxC[l][m].paintSquare(g, Color.green);
                        matBoxA[l][program2D.q].paintSquare(g, Color.blue);
                        matBoxB[program2D.q][m].paintSquare(g, Color.blue);
                         }

                         else matBoxC[l][m].paintSquare(g, Color.white);
                    } catch (Exception e) {
                        System.out.println (e);

                        //matBoxC[l][m].setVal(0);
                        matBoxC[l][m].paintSquare(g, Color.white);}
                }

            }
            }


        break;


        }
}

}

static class Square{

    private int index=0;
    private int val=0;
    private int xPos = 50;
    private int yPos = 50;
   static private int width = 30;
static private int height = 20;
        public void setHeight(int height) {
            Square.height = height;
        }

        public void setWidth(int width) {
            Square.width = width;
        }
    


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
        g.drawString(Integer.toString(this.getVal()), this.getX()+7, this.getY()+15);
    }
    }
}
  class arrowDraw{
                AffineTransform tx;
Line2D.Double line;

Polygon arrowHead;

// [...]
void setLine(double x1,double y1,double x2,double y2 ,Graphics g){
    tx = new AffineTransform();
    line = new Line2D.Double(x1,y1,x2,y2);
    arrowHead = new Polygon();
arrowHead.addPoint( 0,5);
arrowHead.addPoint( -5, -5);
arrowHead.addPoint( 5,-5);
g.drawLine((int)line.x1,(int) line.y1,(int) line.x2,(int) line.y2);
tx.setToIdentity();

    double angle = Math.atan2(line.y2-line.y1, line.x2-line.x1);
    tx.translate(line.x2, line.y2);
    tx.rotate((angle-Math.PI/2d));

    Graphics2D g2 = (Graphics2D) g.create();
    g2.setTransform(tx);
    
    g2.fill(arrowHead);
    g2.dispose();
}
  }
