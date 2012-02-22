/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * towers.java
 *
 * Created on 26 Sep, 2010, 10:09:46 PM
 */

/**
 *
 * @author rvk
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class towers extends javax.swing.JApplet {

    String[] mainCode = {
        "void main(){",
        "int N ;",
        "scanf(\"%d\", & N );",
        "hanoi (1 , 2 , 3 , N );",
        "}"
    };
    String[] hanoiCode = {
        "void hanoi(int S,int D,int T,int n ){",
        "if( n == 1 ){",
        "&nbsp;&nbsp;&nbsp;&nbsp;printf(\"Move from Tower %d --> %d\",S,D);",
        "&nbsp;&nbsp;&nbsp;&nbsp;return; }",
        "hanoi( S , T , D , n-1 );",
        "printf(\"Move from Tower %d --> %d\",S,D);",
        "hanoi( T , D , S , n-1);",
        "return ;",
        "}"
    };
    int n; // No of Disks
    int state;
    int count_steps1;  // Main code line no upto which code should be highlighted

    int[] count_steps2; // Hanoi code lines to be highlighted
    String[] code2;

    int[] sourceTower ;
    int[] destinationTower ;
    int[] hanoiLine ;

    int[] localN ;
    int[] localS;
    int[] localD;
    int[] localT;

    int count_line ;
    int next_count;

    JPanel[] depth;
    GroupLayout[] depthLayouts;
    JLabel[] nlab;
    JLabel[] nval;
    JLabel[] temp;
    JLabel[] tempres;
//============================================

    /** Initializes the applet towers */
    public void init() {
        state = 0;  
        count_steps1 = 0;
        count_line = 0;
        count_steps2 = new int[50];
        code2 = new String[50];
        next_count = 0 ;

        sourceTower = new int[400];
        destinationTower = new int[400];
        localN = new int[400];
        localS = new int[400];
        localD = new int[400];
        localT = new int[400];
        hanoiLine = new int[400];
    //==========================================
        depth = new JPanel[25];
        depthLayouts = new GroupLayout[25];
        nlab = new JLabel[25];
        nval = new JLabel[25];
        temp = new JLabel[25];
        tempres = new JLabel[25];


// Initializing the variables used to highlight HANOI CODE ( recurion )
        for( int i = 0 ; i < 50 ; i++ ){
            count_steps2[i] = 0;

            sourceTower[i]      = -1 ;
            destinationTower[i] = -1 ;
            hanoiLine[i]        = -1  ;
            localN[i]           = -1 ;
            localS[i]           = -1 ;
            localD[i]           = -1 ;
            localT[i]           = -1 ;
            code2[i] = new String("");
        }

        try {
            java.awt.EventQueue.invokeAndWait(new Runnable() {
                public void run() {
                    initComponents();
                }
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void my_hanoi (int t1 , int t2 , int t3 , int n ){               // line : 0
        //System.out.println(count_line);
        
        sourceTower[count_line] = -1;
        destinationTower[count_line] = -1 ;
        hanoiLine[count_line] = 0 ;
        localN[count_line] = n ;
        localS[count_line] = t1 ;
        localD[count_line] = t2 ;
        localT[count_line] = t3 ;
        count_line += 1 ;
        
        sourceTower[count_line] = -1;
        destinationTower[count_line] = -1 ;
        hanoiLine[count_line] = 1 ;
        localN[count_line] = n ;
        localS[count_line] = t1 ;
        localD[count_line] = t2 ;
        localT[count_line] = t3 ;
        count_line += 1 ;
        if( n == 1 ){                                                       // line : 1
        
            //    printf(\"Move from Tower %c ---> %c\",t1,t2);    // line : 2
            sourceTower[count_line] = t1;
            destinationTower[count_line] = t2 ;
            hanoiLine[count_line] = 2 ;
            localN[count_line] = n ;
            localS[count_line] = t1 ;
            localD[count_line] = t2 ;
            localT[count_line] = t3 ;
            count_line += 1 ;

            
            sourceTower[count_line] = -1;
            destinationTower[count_line] = -1 ;
            hanoiLine[count_line] = 3 ;
            localN[count_line] = n ;
            localS[count_line] = t1 ;
            localD[count_line] = t2 ;
            localT[count_line] = t3 ;
            count_line += 1 ;
            return; }                                                       // line : 3


        
        sourceTower[count_line] = -1;
        destinationTower[count_line] = -1 ;
        hanoiLine[count_line] = 4 ;
        localN[count_line] = n ;
        localS[count_line] = t1 ;
        localD[count_line] = t2 ;
        localT[count_line] = t3 ;
        count_line += 1 ;
        my_hanoi (t1 , t3 , t2 , n-1);                                      // line : 4

        
        sourceTower[count_line] = t1;
        destinationTower[count_line] = t2 ;
        hanoiLine[count_line] = 5 ;
        localN[count_line] = n ;
        localS[count_line] = t1 ;
        localD[count_line] = t2 ;
        localT[count_line] = t3 ;
        count_line += 1 ;
        // printf(\"Move from Tower %c ---> %c\",t1,t2);            // line : 5

        
        sourceTower[count_line] = -1;
        destinationTower[count_line] = -1 ;
        hanoiLine[count_line] = 6 ;
        localN[count_line] = n ;
        localS[count_line] = t1 ;
        localD[count_line] = t2 ;
        localT[count_line] = t3 ;
        count_line += 1 ;
        my_hanoi (t3 , t2 , t1 , n-1);                                      // line : 6

        
        sourceTower[count_line] = -1;
        destinationTower[count_line] = -1 ;
        hanoiLine[count_line] = 7 ;
        localN[count_line] = n ;
        localS[count_line] = t1 ;
        localD[count_line] = t2 ;
        localT[count_line] = t3 ;
        count_line += 1 ;
        return ;                                                               // line : 7

    }

    /** This method is called from within the init() method to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topPanel = new javax.swing.JPanel();
        header = new java.awt.Label();
        startButton = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nValue = new javax.swing.JTextField();
        strtButton = new javax.swing.JToggleButton();
        nextButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        codePane = new javax.swing.JEditorPane();
        outputscrollpane = new javax.swing.JScrollPane();
        outputvis1 = new outputvis();

        topPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        header.setAlignment(java.awt.Label.CENTER);
        header.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        header.setText("RECURSION : TOWERS OF HANOI ");

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addGap(213, 213, 213)
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(292, Short.MAX_VALUE))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        startButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("N  =  ");

        nValue.setEditable(false);
        nValue.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

        strtButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        strtButton.setText("START");
        strtButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        strtButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                strtButtonActionPerformed(evt);
            }
        });

        nextButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        nextButton.setText("NEXT");
        nextButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nextButton.setEnabled(false);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        okButton.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        okButton.setText("OK");
        okButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        okButton.setEnabled(false);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout startButtonLayout = new javax.swing.GroupLayout(startButton);
        startButton.setLayout(startButtonLayout);
        startButtonLayout.setHorizontalGroup(
            startButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, startButtonLayout.createSequentialGroup()
                .addContainerGap(38, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nValue, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(strtButton, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        startButtonLayout.setVerticalGroup(
            startButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(startButtonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(startButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nValue, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(strtButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        codePane.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        javax.swing.text.html.parser.ParserDelegator workaround = new javax.swing.text.html.parser.ParserDelegator();
        codePane.setContentType("text/html");
        codePane.setEditable(false);
        codePane.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
        codePane.setText("<html>\n  <head>\n\n  </head>\n  <body>\n\n    <p style=\"margin-top: 0; \">\n      <pre style='font-size:24;'><b>\nvoid main(){\n  int N ;\n  scanf(\"%d\", & N );\n  hanoi (1 , 2 , 3 , N );\n  }\n\nvoid hanoi(int S,int D,int T,int n){\n  if( n == 1 ){\n     printf(\"Move from Tower %d --> %d\",S,D);\n     return ; }\n  hanoi( S , T , D , n-1 );\n  printf(\"Move from Tower %d --> %d\",S,D);\n  hanoi( T, D, S , n-1);\n  return ;\n  }\n      </b></pre>\n    </p>\n  </body>\n</html>\n");
        codePane.setAutoscrolls(true);
        jScrollPane1.setViewportView(codePane);

        javax.swing.GroupLayout outputvis1Layout = new javax.swing.GroupLayout(outputvis1);
        outputvis1.setLayout(outputvis1Layout);
        outputvis1Layout.setHorizontalGroup(
            outputvis1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 547, Short.MAX_VALUE)
        );
        outputvis1Layout.setVerticalGroup(
            outputvis1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 551, Short.MAX_VALUE)
        );

        outputscrollpane.setViewportView(outputvis1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                    .addComponent(startButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(outputscrollpane, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE))
                    .addComponent(outputscrollpane, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        // TODO add your handling code here:
        int k ;
        next_count++;
        if ( next_count <= 4 )  // when main is called
        {
        
                String code = new String("<html>  <head>  </head>  <body>  <p style='margin-top: 0; '> <pre style='font-size:24;'><b>");

                if( next_count < mainCode.length )
                {
                    count_steps1++;
                }

           // Finding the highlighted lines of the MAIN code
            for( int i = 0 ; i < mainCode.length ; i++ )
            {
                    if(i < count_steps1)
                    {
                            code = code.concat("<span style='color:red;'>" + mainCode[i] + "</span>\n&nbsp;&nbsp;");
                    }
                    else
                    {
                            code = code.concat(mainCode[i]+"\n&nbsp;&nbsp;");
                    }
            }
            code = code.concat("\n");
           // Finding the highlighted lines of the HANOI code
       
            for (int i = 0 ; i < hanoiCode.length; i++) {
                        code = code.concat(hanoiCode[i] + "\n&nbsp;&nbsp;");             
            }
            code = code.concat("</b></pre>    </p>  </body></html>");

            codePane.setText(code);
            if ( next_count == 4 )  // when hanoi is called
            {
                my_hanoi ( 1 , 2 , 3 ,  n );

                outputvis1.disk_count = n;
                for ( int i = 0 ; i < n ; i ++ )
                {
                    outputvis1.tower1[i] = i+1;
                }
            }
        }
        else if ( next_count == count_line + 5) // Code is completed
        {
                count_steps1 = 5 ;
                strtButton.setText("START");
                nextButton.setEnabled(false);
                nValue.setEditable(false);
                okButton.setEnabled(false);


                String code = new String("<html>  <head>  </head>  <body>  <p style='margin-top: 0; '> <pre style='font-size:24;'><b>");

           // Finding the highlighted lines of the MAIN code
                int i = 0 ;
                for(i = 0 ; i < mainCode.length -1; i++ )
                {
                            code = code.concat("<span style='color:red;'>" + mainCode[i] + "</span>\n&nbsp;&nbsp;");
                }
                code = code.concat("<span style='color:red; text-decoration:underline; '>" + mainCode[i] + "</span>\n&nbsp;&nbsp;");

                code = code.concat("\n");
           // Finding the highlighted lines of the HANOI code

                for (i = 0 ; i < hanoiCode.length; i++)
                {
                           code = code.concat(hanoiCode[i] + "\n&nbsp;&nbsp;");
                }


                code = code.concat("</b></pre>    </p>  </body></html>");

                codePane.setText(code);
// Upto here Here Highlighting is Done =========================================================
        //=======================================================================================
             //   outputvis1.init();
             //   init();

        }
        else
        {
             k = next_count - 5  ;
            

                String code = new String("<html>  <head>  </head>  <body>  <p style='margin-top: 0; '> <pre style='font-size:24;'><b>");

           // Finding the highlighted lines of the MAIN code
            for( int i = 0 ; i < mainCode.length ; i++ )
            {
                    if(i < count_steps1)
                    {
                            code = code.concat("<span style='color:red;'>" + mainCode[i] + "</span>\n&nbsp;&nbsp;");
                    }
                    else
                    {
                            code = code.concat(mainCode[i]+"\n&nbsp;&nbsp;");
                    }
            }
            code = code.concat("\n");
           // Finding the highlighted lines of the HANOI code
       
            for (int i = 0 ; i < hanoiCode.length; i++) {

                if ( i < hanoiLine[k] ) {
                        if ( (i == 2 || i == 3 ) && hanoiLine[k] > 2){ // If (n== 1) is not Satisfied ..
                            code = code.concat(hanoiCode[i] + "\n&nbsp;&nbsp;");
                        }
                        else {
                            code = code.concat("<span style='color:blue; '>" + hanoiCode[i] + "</span>\n&nbsp;&nbsp;");
                        }
                }
                else if ( i == hanoiLine[k] ) {
                       code = code.concat("<span style='color:blue; text-decoration:underline; '>" + hanoiCode[i] + "</span>\n&nbsp;&nbsp;");
                }
                else {
                        code = code.concat(hanoiCode[i] + "\n&nbsp;&nbsp;");
                }
            }
            code = code.concat("</b></pre>    </p>  </body></html>");

            codePane.setText(code);
// Upto here Here Highlighting is Done =========================================================
        //=======================================================================================

       
                System.out.print(k);
                System.out.print(sourceTower[k]);
                System.out.print(destinationTower[k]);
                System.out.println(hanoiLine[k]);

                outputvis1.local_n = localN[k] ;
                outputvis1.local_s = localS[k] ;
                outputvis1.local_d = localD[k] ;
                outputvis1.local_t = localT[k] ;
                outputvis1.source =  sourceTower[k] ;
                outputvis1.destination = destinationTower[k] ;
                
            if ( sourceTower[k] != -1 && destinationTower[k] != -1)
            {

                int top1 = 0 ;
                int top2 = 0 ;
                int top3 = 0 ;
                while ( outputvis1.tower1[top1] != -1){
                    top1++;
                }
                while ( outputvis1.tower2[top2] != -1){
                    top2++;
                }
                while ( outputvis1.tower3[top3] != -1){
                    top3++;
                }
                System.out.print("top ");
                System.out.print(top1);
                System.out.print(top2);
                System.out.println(top3);

                //=================================================
                // Updating the index of the paint class
                if ( destinationTower[k] == 1){
                    switch( sourceTower[k] ){
                            case 2 :
                                outputvis1.tower1[top1] =   outputvis1.tower2[top2-1];
                                break;
                            case 3 :
                                outputvis1.tower1[top1] =   outputvis1.tower3[top3-1];
                                break;
                    }
                }
                else if ( destinationTower[k] == 2){
                    switch( sourceTower[k] ){
                            case 1 :
                                outputvis1.tower2[top2] =   outputvis1.tower1[top1-1];
                                break;
                            case 3 :
                                outputvis1.tower2[top2] =   outputvis1.tower3[top3-1];
                                break;
                    }
                }
                else if ( destinationTower[k] == 3){
                    switch( sourceTower[k] ){
                            case 2 :
                                outputvis1.tower3[top3] =   outputvis1.tower2[top2-1];
                                break;
                            case 1 :
                                outputvis1.tower3[top3] =   outputvis1.tower1[top1-1];
                                break;
                    }
                }

                //==============================================
                if ( sourceTower[k] == 1){
                    outputvis1.tower1[top1-1] = -1 ;
                }
                else if ( sourceTower[k] == 2){
                    outputvis1.tower2[top2-1] = -1 ;
                }
                else if ( sourceTower[k] == 3){
                    outputvis1.tower3[top3-1] = -1 ;
                }
            }
        
            outputvis1.repaint();
         
            }
        
    }//GEN-LAST:event_nextButtonActionPerformed

    private void strtButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_strtButtonActionPerformed
        // TODO add your handling code here:
        if(strtButton.getText().compareTo("START") == 0){
          
          strtButton.setText("STOP");
          //nextButton.setEnabled(true);
          nValue.setEditable(true);
          okButton.setEnabled(true);
 //init(); =================================================
            state = 0;
            count_steps1 = 0;
            count_line = 0;
            next_count = 0 ;

        // Initializing the variables used to highlight HANOI CODE ( recurion )
            for( int i = 0 ; i < 50 ; i++ ){
                count_steps2[i] = 0;

                sourceTower[i]      = -1 ;
                destinationTower[i] = -1 ;
                hanoiLine[i]        = -1 ;
                localN[i]           = -1 ;
                code2[i]            = new String("");
            }
 //----------------------------------------------------
          outputvis1.init();
          outputvis1.repaint();
          String code = new String("<html>  <head>  </head>  <body>  <p style='margin-top: 0; '> <pre style='font-size:24;'><b>");

           // Adding MAIN code
            for( int i = 0 ; i < mainCode.length ; i++ )
            {
                  code = code.concat(mainCode[i]+"\n&nbsp;&nbsp;");
            }
            code = code.concat("\n");
           // Adding HANOI code
            for (int i = 0 ; i < hanoiCode.length; i++)
            {
                code = code.concat(hanoiCode[i] + "\n&nbsp;&nbsp;");

            }
            code = code.concat("</b></pre>    </p>  </body></html>");
            codePane.setText(code);
          
        }
        else{
          strtButton.setText("START");
          nextButton.setEnabled(false);
          nValue.setEditable(false);
          okButton.setEnabled(false);

          

        }
 }
    {
    }//GEN-LAST:event_strtButtonActionPerformed

 private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
     // TODO add your handling code here:
     
     n = Integer.parseInt(nValue.getText());
    // my_hanoi ( 1 , 2 , 3 ,  n );

     if ( n<=5 && n >= 1)
     {
        nextButton.setEnabled(true);
        okButton.setEnabled(false);
        nValue.setEditable(false);
     }
     else
     {
         JOptionPane.showMessageDialog(null, "Only integral value  ( Greater than equal to  1 and  Less than equal to 5 ) is accepted ");
     }
     

 }//GEN-LAST:event_okButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JEditorPane codePane;
    private java.awt.Label header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nValue;
    private javax.swing.JButton nextButton;
    private javax.swing.JButton okButton;
    private javax.swing.JScrollPane outputscrollpane;
    private outputvis outputvis1;
    private javax.swing.JPanel startButton;
    private javax.swing.JToggleButton strtButton;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables

}
