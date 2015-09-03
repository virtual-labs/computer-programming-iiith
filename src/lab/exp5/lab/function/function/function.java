/*      */ package function;
/*      */ 
/*      */ import javax.swing.JPanel;
/*      */ 
/*      */ public class function extends javax.swing.JApplet
/*      */ {
/*      */   private javax.swing.JButton jButton1;
/*      */   private javax.swing.JButton jButton2;
/*      */   private javax.swing.JButton jButton3;
/*      */   private javax.swing.JButton jButton4;
/*      */   private javax.swing.JButton jButton5;
/*      */   private javax.swing.JLabel jLabel1;
/*      */   private javax.swing.JLabel jLabel10;
/*      */   private javax.swing.JLabel jLabel2;
/*      */   private javax.swing.JLabel jLabel3;
/*      */   private javax.swing.JLabel jLabel4;
/*      */   private javax.swing.JLabel jLabel5;
/*      */   private javax.swing.JLabel jLabel6;
/*      */   private javax.swing.JLabel jLabel7;
/*      */   private javax.swing.JLabel jLabel8;
/*      */   private javax.swing.JLabel jLabel9;
/*      */   private JPanel jPanel1;
/*      */   private JPanel jPanel2;
/*      */   private JPanel jPanel3;
/*      */   private JPanel jPanel4;
/*      */   private JPanel jPanel5;
/*      */   private JPanel jPanel6;
/*      */   private javax.swing.JScrollPane jScrollPane1;
/*      */   private javax.swing.JScrollPane jScrollPane2;
/*      */   private javax.swing.JScrollPane jScrollPane3;
/*      */   private javax.swing.JScrollPane jScrollPane4;
/*      */   private javax.swing.JScrollPane jScrollPane5;
/*      */   private javax.swing.JTextArea jTextArea1;
/*      */   private javax.swing.JTextArea jTextArea2;
/*      */   private javax.swing.JTextArea jTextArea3;
/*      */   private javax.swing.JTextArea jTextArea4;
/*      */   private javax.swing.JTextField jTextField1;
/*      */   private javax.swing.JTextField jTextField2;
/*      */   
/*      */   public void init()
/*      */   {
/*      */     try {
/*   43 */       java.awt.EventQueue.invokeAndWait(new function.1(this));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     }
/*      */     catch (Exception ex)
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*   64 */       ex.printStackTrace();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void initComponents()
/*      */   {
/*   77 */     this.jPanel1 = new JPanel();
/*   78 */     this.jPanel2 = new JPanel();
/*   79 */     this.jLabel1 = new javax.swing.JLabel();
/*   80 */     this.jPanel4 = new JPanel();
/*   81 */     this.jPanel6 = new JPanel();
/*   82 */     this.jButton3 = new javax.swing.JButton(this.triangle);
/*   83 */     this.jButton1 = new javax.swing.JButton(this.square);
/*   84 */     this.jButton2 = new javax.swing.JButton(this.rectangle);
/*   85 */     this.jButton4 = new javax.swing.JButton(this.circle);
/*   86 */     this.jPanel5 = new JPanel();
/*   87 */     this.jLabel4 = new javax.swing.JLabel();
/*   88 */     this.jScrollPane1 = new javax.swing.JScrollPane();
/*   89 */     this.jTextArea4 = new javax.swing.JTextArea();
/*   90 */     this.jPanel3 = new JPanel();
/*   91 */     this.jLabel2 = new javax.swing.JLabel();
/*   92 */     this.jScrollPane2 = new javax.swing.JScrollPane();
/*   93 */     this.jTextArea1 = new javax.swing.JTextArea();
/*   94 */     this.jScrollPane3 = new javax.swing.JScrollPane();
/*   95 */     this.jTextArea2 = new javax.swing.JTextArea();
/*   96 */     this.jTextField1 = new javax.swing.JTextField();
/*   97 */     this.jTextField2 = new javax.swing.JTextField();
/*   98 */     this.jTextField3 = new javax.swing.JTextField();
/*   99 */     this.jTextField4 = new javax.swing.JTextField();
/*  100 */     this.jLabel3 = new javax.swing.JLabel();
/*  101 */     this.jLabel5 = new javax.swing.JLabel();
/*  102 */     this.jLabel6 = new javax.swing.JLabel();
/*  103 */     this.jScrollPane4 = new javax.swing.JScrollPane();
/*  104 */     this.jTextArea3 = new javax.swing.JTextArea();
/*  105 */     this.jButton5 = new javax.swing.JButton();
/*  106 */     this.jLabel7 = new javax.swing.JLabel();
/*  107 */     this.jTextField5 = new javax.swing.JTextField();
/*  108 */     this.jTextField6 = new javax.swing.JTextField();
/*  109 */     this.jTextField7 = new javax.swing.JTextField();
/*  110 */     this.jLabel8 = new javax.swing.JLabel();
/*  111 */     this.jLabel9 = new javax.swing.JLabel();
/*  112 */     this.jLabel10 = new javax.swing.JLabel();
/*  113 */     this.jScrollPane5 = new javax.swing.JScrollPane();
/*  114 */     this.jTextPane1 = new javax.swing.JTextPane();
/*      */     
/*  116 */     this.jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.shadow"));
/*      */     
/*  118 */     this.jLabel1.setFont(new java.awt.Font("DejaVu Sans", 1, 18));
/*  119 */     this.jLabel1.setHorizontalAlignment(0);
/*  120 */     this.jLabel1.setText("Functions");
/*      */     
/*  122 */     javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(this.jPanel2);
/*  123 */     this.jPanel2.setLayout(jPanel2Layout);
/*  124 */     jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel2Layout.createSequentialGroup().addGap(540, 540, 540).addComponent(this.jLabel1, -2, 201, -2).addContainerGap(470, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  131 */     jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jLabel1));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  136 */     this.jPanel4.setEnabled(false);
/*      */     
/*  138 */     javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(this.jPanel6);
/*  139 */     this.jPanel6.setLayout(jPanel6Layout);
/*  140 */     jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 0, 32767));
/*      */     
/*      */ 
/*      */ 
/*  144 */     jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 550, 32767));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*  149 */     this.jButton3.setEnabled(false);
/*  150 */     this.jButton3.addActionListener(new function.2(this));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  156 */     this.jButton1.setFocusCycleRoot(true);
/*  157 */     this.jButton1.setPreferredSize(new java.awt.Dimension(250, 250));
/*  158 */     this.jButton1.addActionListener(new function.3(this));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  164 */     this.jButton2.setEnabled(false);
/*  165 */     this.jButton2.addActionListener(new function.4(this));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  171 */     this.jButton4.setEnabled(false);
/*  172 */     this.jButton4.setMargin(new java.awt.Insets(4, 12, 4, 12));
/*  173 */     this.jButton4.setMaximumSize(new java.awt.Dimension(250, 250));
/*  174 */     this.jButton4.setMinimumSize(new java.awt.Dimension(250, 250));
/*  175 */     this.jButton4.setPreferredSize(new java.awt.Dimension(250, 250));
/*  176 */     this.jButton4.addActionListener(new function.5(this));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  182 */     javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(this.jPanel4);
/*  183 */     this.jPanel4.setLayout(jPanel4Layout);
/*  184 */     jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addContainerGap().addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jButton3, -2, 250, -2).addComponent(this.jButton1, -2, 250, -2)).addGap(31, 31, 31).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addComponent(this.jButton4, -2, 250, -2).addGap(241, 241, 241).addComponent(this.jPanel6, -1, -1, 32767)).addComponent(this.jButton2, -2, 250, -2)).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  200 */     jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(35, 35, 35).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(this.jButton1, -2, 250, -2).addComponent(this.jButton2, -2, 250, -2)).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel4Layout.createSequentialGroup().addGap(41, 41, 41).addComponent(this.jPanel6, -2, -1, -2)).addGroup(jPanel4Layout.createSequentialGroup().addGap(30, 30, 30).addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jButton4, -2, 250, -2).addComponent(this.jButton3, -2, 250, -2)))).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  219 */     this.jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18));
/*  220 */     this.jLabel4.setHorizontalAlignment(0);
/*  221 */     this.jLabel4.setText("Functions");
/*      */     
/*  223 */     this.jTextArea4.setColumns(10);
/*  224 */     this.jTextArea4.setEditable(false);
/*  225 */     this.jTextArea4.setLineWrap(true);
/*  226 */     this.jTextArea4.setRows(5);
/*  227 */     this.jTextArea4.setTabSize(4);
/*  228 */     this.jTextArea4.setText("//function for square\n\n\n\n\n\n//function for triangle\n\n\n\n\n\n//function for rectangle\n\n\n\n\n\n//function for circle\n\n");
/*  229 */     this.jScrollPane1.setViewportView(this.jTextArea4);
/*      */     
/*  231 */     javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(this.jPanel5);
/*  232 */     this.jPanel5.setLayout(jPanel5Layout);
/*  233 */     jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jScrollPane1, -1, 199, 32767).addComponent(this.jLabel4)).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  242 */     jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel5Layout.createSequentialGroup().addGap(13, 13, 13).addComponent(this.jLabel4, -2, 16, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jScrollPane1, -2, 484, -2).addContainerGap(70, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  252 */     this.jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18));
/*  253 */     this.jLabel2.setText("Main Program");
/*      */     
/*  255 */     this.jScrollPane2.setHorizontalScrollBarPolicy(31);
/*  256 */     this.jScrollPane2.setVerticalScrollBarPolicy(21);
/*      */     
/*  258 */     this.jTextArea1.setColumns(10);
/*  259 */     this.jTextArea1.setEditable(false);
/*  260 */     this.jTextArea1.setRows(2);
/*  261 */     this.jTextArea1.setTabSize(4);
/*  262 */     this.jTextArea1.setText("int main(){\n  float totalArea;");
/*  263 */     this.jTextArea1.setMaximumSize(new java.awt.Dimension(100, 40));
/*  264 */     this.jScrollPane2.setViewportView(this.jTextArea1);
/*      */     
/*  266 */     this.jScrollPane3.setHorizontalScrollBarPolicy(31);
/*  267 */     this.jScrollPane3.setVerticalScrollBarPolicy(21);
/*      */     
/*  269 */     this.jTextArea2.setColumns(6);
/*  270 */     this.jTextArea2.setEditable(false);
/*  271 */     this.jTextArea2.setRows(5);
/*  272 */     this.jTextArea2.setText("  totalArea  =");
/*  273 */     this.jScrollPane3.setViewportView(this.jTextArea2);
/*      */     
/*  275 */     this.jTextField1.setEnabled(false);
/*      */     
/*  277 */     this.jTextField2.setEnabled(false);
/*      */     
/*  279 */     this.jTextField3.setEnabled(false);
/*      */     
/*  281 */     this.jTextField4.setEnabled(false);
/*      */     
/*  283 */     this.jLabel3.setText("+");
/*      */     
/*  285 */     this.jLabel5.setText("+");
/*      */     
/*  287 */     this.jLabel6.setText(";");
/*      */     
/*  289 */     this.jTextArea3.setColumns(10);
/*  290 */     this.jTextArea3.setEditable(false);
/*  291 */     this.jTextArea3.setRows(2);
/*  292 */     this.jTextArea3.setTabSize(4);
/*  293 */     this.jTextArea3.setText("\tprintf(\"Total Area: %f\\n\", totalArea);\n\treturn 0;\n}");
/*  294 */     this.jScrollPane4.setViewportView(this.jTextArea3);
/*      */     
/*  296 */     this.jButton5.setFont(new java.awt.Font("Tahoma", 1, 14));
/*  297 */     this.jButton5.setText("Execute");
/*  298 */     this.jButton5.addActionListener(new function.6(this));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  304 */     this.jLabel7.setText("+");
/*      */     
/*  306 */     this.jTextField5.setEnabled(false);
/*      */     
/*  308 */     this.jTextField6.setEnabled(false);
/*      */     
/*  310 */     this.jTextField7.setEnabled(false);
/*      */     
/*  312 */     this.jLabel8.setText("+");
/*      */     
/*  314 */     this.jLabel9.setText("+");
/*      */     
/*  316 */     this.jLabel10.setText("+");
/*      */     
/*  318 */     javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(this.jPanel3);
/*  319 */     this.jPanel3.setLayout(jPanel3Layout);
/*  320 */     jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel2)).addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap(50, 32767).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addComponent(this.jLabel10).addComponent(this.jLabel9).addComponent(this.jLabel8).addComponent(this.jLabel7).addComponent(this.jLabel5).addComponent(this.jLabel3, -2, 14, -2)).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(this.jTextField1).addComponent(this.jTextField2).addComponent(this.jTextField3).addComponent(this.jTextField4).addComponent(this.jTextField5).addComponent(this.jTextField6, -1, 199, 32767).addComponent(this.jTextField7, javax.swing.GroupLayout.Alignment.TRAILING)).addGap(2, 2, 2).addComponent(this.jLabel6, -2, 15, -2).addGap(79, 79, 79)).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane3, -2, 105, -2))).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane2, -2, 322, -2)).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jButton5, -2, 151, -2)).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jScrollPane4, -2, 315, -2))).addContainerGap()));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  363 */     jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel3Layout.createSequentialGroup().addContainerGap().addComponent(this.jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane2, -2, 39, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane3, -2, 19, -2).addGap(18, 18, 18).addComponent(this.jTextField1, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jTextField2, -2, -1, -2).addComponent(this.jLabel3)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jTextField3, -2, 20, -2).addComponent(this.jLabel5)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jTextField4, -2, 20, -2).addComponent(this.jLabel7)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jTextField5, -2, 20, -2).addComponent(this.jLabel8)).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jTextField6, -2, 20, -2).addComponent(this.jLabel9)).addGap(18, 18, 18).addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(this.jTextField7, -2, 20, -2).addComponent(this.jLabel6, -2, 17, -2).addComponent(this.jLabel10)).addGap(18, 18, 18).addComponent(this.jScrollPane4, -2, 63, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jButton5, -2, 30, -2).addGap(130, 130, 130)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  406 */     this.jTextPane1.setEditable(false);
/*  407 */     this.jScrollPane5.setViewportView(this.jTextPane1);
/*      */     
/*  409 */     javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(this.jPanel1);
/*  410 */     this.jPanel1.setLayout(jPanel1Layout);
/*  411 */     jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(jPanel1Layout.createSequentialGroup().addContainerGap().addComponent(this.jPanel4, -2, 575, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel5, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.jPanel3, -2, -1, -2)).addGroup(jPanel1Layout.createSequentialGroup().addGap(12, 12, 12).addComponent(this.jScrollPane5)).addComponent(this.jPanel2, -1, -1, 32767)).addContainerGap(30, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  428 */     jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(jPanel1Layout.createSequentialGroup().addComponent(this.jPanel2, -2, -1, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(this.jScrollPane5, -2, 113, -2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(this.jPanel3, -1, 595, 32767).addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addComponent(this.jPanel4, 0, 595, 32767).addComponent(this.jPanel5, -1, -1, 32767))).addContainerGap(-1, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  443 */     javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
/*  444 */     getContentPane().setLayout(layout);
/*  445 */     layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(-1, 32767)));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  451 */     layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addComponent(this.jPanel1, -2, -1, -2).addContainerGap(60, 32767)));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt)
/*      */   {
/*  470 */     initPanels();
/*  471 */     javax.swing.JLabel varLabel = new javax.swing.JLabel("Enter number of arguments", null, 0);
/*  472 */     javax.swing.ButtonGroup varMenu = new javax.swing.ButtonGroup();
/*  473 */     this.var1 = new javax.swing.JRadioButton("1");
/*  474 */     this.var1.setSelected(true);
/*  475 */     this.var2 = new javax.swing.JRadioButton("2");
/*  476 */     this.var3 = new javax.swing.JRadioButton("3");
/*  477 */     this.varPanel.setLayout(new javax.swing.BoxLayout(this.varPanel, 3));
/*  478 */     varMenu.add(this.var1);
/*  479 */     varMenu.add(this.var2);
/*  480 */     varMenu.add(this.var3);
/*  481 */     this.varPanel.add(varLabel);
/*  482 */     this.varPanel.add(this.var1);
/*  483 */     this.varPanel.add(this.var2);
/*  484 */     this.varPanel.add(this.var3);
/*  485 */     javax.swing.JButton varButton = new javax.swing.JButton("OK");
/*  486 */     this.varPanel.add(varButton);
/*      */     
/*      */ 
/*  489 */     javax.swing.JLabel datLabel = new javax.swing.JLabel("Enter datatype of arguments", null, 0);
/*  490 */     this.datPanel.setLayout(new javax.swing.BoxLayout(this.datPanel, 3));
/*  491 */     javax.swing.ButtonGroup datMenu = new javax.swing.ButtonGroup();
/*  492 */     this.dat1 = new javax.swing.JRadioButton("int");
/*  493 */     this.dat1.setSelected(true);
/*  494 */     this.dat2 = new javax.swing.JRadioButton("float");
/*      */     
/*  496 */     datMenu.add(this.dat1);
/*  497 */     datMenu.add(this.dat2);
/*      */     
/*  499 */     javax.swing.JButton datButton = new javax.swing.JButton("OK");
/*  500 */     this.datPanel.add(datLabel);
/*  501 */     this.datPanel.add(this.dat1);
/*  502 */     this.datPanel.add(this.dat2);
/*  503 */     this.datPanel.add(datButton);
/*      */     
/*      */ 
/*  506 */     javax.swing.JLabel retLabel = new javax.swing.JLabel("Enter return datatype of the function", null, 0);
/*  507 */     this.retPanel.setLayout(new javax.swing.BoxLayout(this.retPanel, 3));
/*  508 */     javax.swing.ButtonGroup retMenu = new javax.swing.ButtonGroup();
/*  509 */     this.ret1 = new javax.swing.JRadioButton("int");
/*  510 */     this.ret1.setSelected(true);
/*  511 */     this.ret2 = new javax.swing.JRadioButton("float");
/*      */     
/*  513 */     retMenu.add(this.ret1);
/*  514 */     retMenu.add(this.ret2);
/*      */     
/*  516 */     javax.swing.JButton retButton = new javax.swing.JButton("OK");
/*  517 */     this.retPanel.add(retLabel);
/*  518 */     this.retPanel.add(this.ret1);
/*  519 */     this.retPanel.add(this.ret2);
/*  520 */     this.retPanel.add(retButton);
/*      */     
/*      */ 
/*      */ 
/*  524 */     javax.swing.JLabel fLabel = new javax.swing.JLabel("Choose formula for area of square", null, 0);
/*  525 */     this.fPanel.setLayout(new javax.swing.BoxLayout(this.fPanel, 3));
/*  526 */     javax.swing.ButtonGroup fMenu = new javax.swing.ButtonGroup();
/*  527 */     this.f1 = new javax.swing.JRadioButton("a*a");
/*  528 */     this.f1.setSelected(true);
/*  529 */     this.f2 = new javax.swing.JRadioButton("PI*a*a");
/*  530 */     this.f3 = new javax.swing.JRadioButton("2*PI*a");
/*  531 */     fMenu.add(this.f1);
/*  532 */     fMenu.add(this.f2);
/*  533 */     fMenu.add(this.f3);
/*  534 */     javax.swing.JButton fButton = new javax.swing.JButton("OK");
/*  535 */     this.fPanel.add(fLabel);
/*  536 */     this.fPanel.add(this.f1);
/*  537 */     this.fPanel.add(this.f2);
/*  538 */     this.fPanel.add(this.f3);
/*  539 */     this.fPanel.add(fButton);
/*      */     
/*      */ 
/*      */ 
/*  543 */     varButton.addActionListener(new function.7(this));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  552 */     datButton.addActionListener(new function.8(this));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  561 */     retButton.addActionListener(new function.9(this));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  569 */     fButton.addActionListener(new function.10(this));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void jButton2ActionPerformed(java.awt.event.ActionEvent evt)
/*      */   {
/*  587 */     initPanels();
/*  588 */     javax.swing.JLabel varLabel = new javax.swing.JLabel("Enter number of arguments", null, 0);
/*  589 */     javax.swing.ButtonGroup varMenu = new javax.swing.ButtonGroup();
/*  590 */     this.var1 = new javax.swing.JRadioButton("1");
/*  591 */     this.var1.setSelected(true);
/*  592 */     this.var2 = new javax.swing.JRadioButton("2");
/*  593 */     this.var3 = new javax.swing.JRadioButton("3");
/*  594 */     this.varPanel.setLayout(new javax.swing.BoxLayout(this.varPanel, 3));
/*  595 */     varMenu.add(this.var1);
/*  596 */     varMenu.add(this.var2);
/*  597 */     varMenu.add(this.var3);
/*  598 */     this.varPanel.add(varLabel);
/*  599 */     this.varPanel.add(this.var1);
/*  600 */     this.varPanel.add(this.var2);
/*  601 */     this.varPanel.add(this.var3);
/*  602 */     javax.swing.JButton varButton = new javax.swing.JButton("OK");
/*  603 */     this.varPanel.add(varButton);
/*      */     
/*      */ 
/*  606 */     javax.swing.JLabel datLabel = new javax.swing.JLabel("Enter datatype of arguments", null, 0);
/*  607 */     this.datPanel.setLayout(new javax.swing.BoxLayout(this.datPanel, 3));
/*  608 */     javax.swing.ButtonGroup datMenu = new javax.swing.ButtonGroup();
/*  609 */     this.dat1 = new javax.swing.JRadioButton("int");
/*  610 */     this.dat1.setSelected(true);
/*  611 */     this.dat2 = new javax.swing.JRadioButton("float");
/*      */     
/*  613 */     datMenu.add(this.dat1);
/*  614 */     datMenu.add(this.dat2);
/*      */     
/*  616 */     javax.swing.JButton datButton = new javax.swing.JButton("OK");
/*  617 */     this.datPanel.add(datLabel);
/*  618 */     this.datPanel.add(this.dat1);
/*  619 */     this.datPanel.add(this.dat2);
/*  620 */     this.datPanel.add(datButton);
/*      */     
/*      */ 
/*  623 */     javax.swing.JLabel retLabel = new javax.swing.JLabel("Enter return datatype of the function", null, 0);
/*  624 */     this.retPanel.setLayout(new javax.swing.BoxLayout(this.retPanel, 3));
/*  625 */     javax.swing.ButtonGroup retMenu = new javax.swing.ButtonGroup();
/*  626 */     this.ret1 = new javax.swing.JRadioButton("int");
/*  627 */     this.ret1.setSelected(true);
/*  628 */     this.ret2 = new javax.swing.JRadioButton("float");
/*      */     
/*  630 */     retMenu.add(this.ret1);
/*  631 */     retMenu.add(this.ret2);
/*      */     
/*  633 */     javax.swing.JButton retButton = new javax.swing.JButton("OK");
/*  634 */     this.retPanel.add(retLabel);
/*  635 */     this.retPanel.add(this.ret1);
/*  636 */     this.retPanel.add(this.ret2);
/*  637 */     this.retPanel.add(retButton);
/*      */     
/*      */ 
/*      */ 
/*  641 */     javax.swing.JLabel fLabel = new javax.swing.JLabel("Choose formula for area of a rectangle", null, 0);
/*  642 */     this.fPanel.setLayout(new javax.swing.BoxLayout(this.fPanel, 3));
/*  643 */     javax.swing.ButtonGroup fMenu = new javax.swing.ButtonGroup();
/*  644 */     this.f1 = new javax.swing.JRadioButton("a*a");
/*  645 */     this.f1.setSelected(true);
/*  646 */     this.f2 = new javax.swing.JRadioButton("a*b");
/*  647 */     this.f3 = new javax.swing.JRadioButton("2*3.14*a");
/*  648 */     fMenu.add(this.f1);
/*  649 */     fMenu.add(this.f2);
/*  650 */     fMenu.add(this.f3);
/*  651 */     javax.swing.JButton fButton = new javax.swing.JButton("OK");
/*  652 */     this.fPanel.add(fLabel);
/*  653 */     this.fPanel.add(this.f1);
/*  654 */     this.fPanel.add(this.f2);
/*  655 */     this.fPanel.add(this.f3);
/*  656 */     this.fPanel.add(fButton);
/*      */     
/*      */ 
/*      */ 
/*  660 */     varButton.addActionListener(new function.11(this));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  669 */     datButton.addActionListener(new function.12(this));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  678 */     retButton.addActionListener(new function.13(this));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  686 */     fButton.addActionListener(new function.14(this));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)
/*      */   {
/*  702 */     initPanels();
/*  703 */     javax.swing.JLabel varLabel = new javax.swing.JLabel("Enter number of arguments", null, 0);
/*  704 */     javax.swing.ButtonGroup varMenu = new javax.swing.ButtonGroup();
/*  705 */     this.var1 = new javax.swing.JRadioButton("1");
/*  706 */     this.var1.setSelected(true);
/*  707 */     this.var2 = new javax.swing.JRadioButton("2");
/*  708 */     this.var3 = new javax.swing.JRadioButton("3");
/*  709 */     this.varPanel.setLayout(new javax.swing.BoxLayout(this.varPanel, 3));
/*  710 */     varMenu.add(this.var1);
/*  711 */     varMenu.add(this.var2);
/*  712 */     varMenu.add(this.var3);
/*  713 */     this.varPanel.add(varLabel);
/*  714 */     this.varPanel.add(this.var1);
/*  715 */     this.varPanel.add(this.var2);
/*  716 */     this.varPanel.add(this.var3);
/*  717 */     javax.swing.JButton varButton = new javax.swing.JButton("OK");
/*  718 */     this.varPanel.add(varButton);
/*      */     
/*      */ 
/*  721 */     javax.swing.JLabel datLabel = new javax.swing.JLabel("Enter datatype of arguments", null, 0);
/*  722 */     this.datPanel.setLayout(new javax.swing.BoxLayout(this.datPanel, 3));
/*  723 */     javax.swing.ButtonGroup datMenu = new javax.swing.ButtonGroup();
/*  724 */     this.dat1 = new javax.swing.JRadioButton("int");
/*  725 */     this.dat1.setSelected(true);
/*  726 */     this.dat2 = new javax.swing.JRadioButton("float");
/*      */     
/*  728 */     datMenu.add(this.dat1);
/*  729 */     datMenu.add(this.dat2);
/*      */     
/*  731 */     javax.swing.JButton datButton = new javax.swing.JButton("OK");
/*  732 */     this.datPanel.add(datLabel);
/*  733 */     this.datPanel.add(this.dat1);
/*  734 */     this.datPanel.add(this.dat2);
/*  735 */     this.datPanel.add(datButton);
/*      */     
/*      */ 
/*  738 */     javax.swing.JLabel retLabel = new javax.swing.JLabel("Enter return datatype of the function", null, 0);
/*  739 */     this.retPanel.setLayout(new javax.swing.BoxLayout(this.retPanel, 3));
/*  740 */     javax.swing.ButtonGroup retMenu = new javax.swing.ButtonGroup();
/*  741 */     this.ret1 = new javax.swing.JRadioButton("int");
/*  742 */     this.ret1.setSelected(true);
/*  743 */     this.ret2 = new javax.swing.JRadioButton("float");
/*      */     
/*  745 */     retMenu.add(this.ret1);
/*  746 */     retMenu.add(this.ret2);
/*      */     
/*  748 */     javax.swing.JButton retButton = new javax.swing.JButton("OK");
/*  749 */     this.retPanel.add(retLabel);
/*  750 */     this.retPanel.add(this.ret1);
/*  751 */     this.retPanel.add(this.ret2);
/*  752 */     this.retPanel.add(retButton);
/*      */     
/*      */ 
/*      */ 
/*  756 */     javax.swing.JLabel fLabel = new javax.swing.JLabel("Choose formula for area of square", null, 0);
/*  757 */     this.fPanel.setLayout(new javax.swing.BoxLayout(this.fPanel, 3));
/*  758 */     javax.swing.ButtonGroup fMenu = new javax.swing.ButtonGroup();
/*  759 */     this.f1 = new javax.swing.JRadioButton("a*a");
/*  760 */     this.f1.setSelected(true);
/*  761 */     this.f2 = new javax.swing.JRadioButton("PI*a*a");
/*  762 */     this.f3 = new javax.swing.JRadioButton("(√3/4.0)*a*a");
/*  763 */     fMenu.add(this.f1);
/*  764 */     fMenu.add(this.f2);
/*  765 */     fMenu.add(this.f3);
/*  766 */     javax.swing.JButton fButton = new javax.swing.JButton("OK");
/*  767 */     this.fPanel.add(fLabel);
/*  768 */     this.fPanel.add(this.f1);
/*  769 */     this.fPanel.add(this.f2);
/*  770 */     this.fPanel.add(this.f3);
/*  771 */     this.fPanel.add(fButton);
/*      */     
/*      */ 
/*      */ 
/*  775 */     varButton.addActionListener(new function.15(this));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  784 */     datButton.addActionListener(new function.16(this));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  793 */     retButton.addActionListener(new function.17(this));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  801 */     fButton.addActionListener(new function.18(this));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void jButton4ActionPerformed(java.awt.event.ActionEvent evt)
/*      */   {
/*  816 */     initPanels();
/*  817 */     javax.swing.JLabel varLabel = new javax.swing.JLabel("Enter number of arguments", null, 0);
/*  818 */     javax.swing.ButtonGroup varMenu = new javax.swing.ButtonGroup();
/*  819 */     this.var1 = new javax.swing.JRadioButton("1");
/*  820 */     this.var1.setSelected(true);
/*  821 */     this.var2 = new javax.swing.JRadioButton("2");
/*  822 */     this.var3 = new javax.swing.JRadioButton("3");
/*  823 */     this.varPanel.setLayout(new javax.swing.BoxLayout(this.varPanel, 3));
/*  824 */     varMenu.add(this.var1);
/*  825 */     varMenu.add(this.var2);
/*  826 */     varMenu.add(this.var3);
/*  827 */     this.varPanel.add(varLabel);
/*  828 */     this.varPanel.add(this.var1);
/*  829 */     this.varPanel.add(this.var2);
/*  830 */     this.varPanel.add(this.var3);
/*  831 */     javax.swing.JButton varButton = new javax.swing.JButton("OK");
/*  832 */     this.varPanel.add(varButton);
/*      */     
/*  834 */     javax.swing.JLabel datLabel = new javax.swing.JLabel("Enter datatype of input variables(arguments)", null, 0);
/*  835 */     this.datPanel.setLayout(new javax.swing.BoxLayout(this.datPanel, 3));
/*  836 */     javax.swing.ButtonGroup datMenu = new javax.swing.ButtonGroup();
/*  837 */     this.dat1 = new javax.swing.JRadioButton("int");
/*  838 */     this.dat1.setSelected(true);
/*  839 */     this.dat2 = new javax.swing.JRadioButton("float");
/*      */     
/*  841 */     datMenu.add(this.dat1);
/*  842 */     datMenu.add(this.dat2);
/*      */     
/*  844 */     javax.swing.JButton datButton = new javax.swing.JButton("OK");
/*  845 */     this.datPanel.add(datLabel);
/*  846 */     this.datPanel.add(this.dat1);
/*  847 */     this.datPanel.add(this.dat2);
/*  848 */     this.datPanel.add(datButton);
/*      */     
/*      */ 
/*      */ 
/*  852 */     javax.swing.JLabel retLabel = new javax.swing.JLabel("Enter datatype of the return variable)", null, 0);
/*  853 */     this.retPanel.setLayout(new javax.swing.BoxLayout(this.retPanel, 3));
/*  854 */     javax.swing.ButtonGroup retMenu = new javax.swing.ButtonGroup();
/*  855 */     this.ret1 = new javax.swing.JRadioButton("int");
/*  856 */     this.ret1.setSelected(true);
/*  857 */     this.ret2 = new javax.swing.JRadioButton("float");
/*      */     
/*  859 */     retMenu.add(this.ret1);
/*  860 */     retMenu.add(this.ret2);
/*      */     
/*  862 */     javax.swing.JButton retButton = new javax.swing.JButton("OK");
/*  863 */     this.retPanel.add(retLabel);
/*  864 */     this.retPanel.add(this.ret1);
/*  865 */     this.retPanel.add(this.ret2);
/*  866 */     this.retPanel.add(retButton);
/*      */     
/*  868 */     javax.swing.JLabel fLabel = new javax.swing.JLabel("Choose formula for area of circle", null, 0);
/*  869 */     this.fPanel.setLayout(new javax.swing.BoxLayout(this.fPanel, 3));
/*  870 */     javax.swing.ButtonGroup fMenu = new javax.swing.ButtonGroup();
/*  871 */     this.f1 = new javax.swing.JRadioButton("a*a");
/*  872 */     this.f1.setSelected(true);
/*  873 */     this.f2 = new javax.swing.JRadioButton("PI*a*a");
/*  874 */     this.f3 = new javax.swing.JRadioButton("(√3/4.0)*a*a");
/*  875 */     fMenu.add(this.f1);
/*  876 */     fMenu.add(this.f2);
/*  877 */     fMenu.add(this.f3);
/*  878 */     javax.swing.JButton fButton = new javax.swing.JButton("OK");
/*  879 */     this.fPanel.add(fLabel);
/*  880 */     this.fPanel.add(this.f1);
/*  881 */     this.fPanel.add(this.f2);
/*  882 */     this.fPanel.add(this.f3);
/*  883 */     this.fPanel.add(fButton);
/*      */     
/*      */ 
/*  886 */     varButton.addActionListener(new function.19(this));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  895 */     datButton.addActionListener(new function.20(this));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  904 */     retButton.addActionListener(new function.21(this));
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*  916 */     fButton.addActionListener(new function.22(this));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   private void jButton5ActionPerformed(java.awt.event.ActionEvent evt)
/*      */   {
/*  933 */     float totalarea = 0.0F;
/*  934 */     boolean allcorrect = true;
/*      */     
/*  936 */     java.util.StringTokenizer str = new java.util.StringTokenizer(this.jTextField1.getText().trim(), "*(),", true);
/*  937 */     System.out.println("IS Function: " + str);
/*  938 */     for (int i = 1; i <= 7; i++)
/*      */     {
/*  940 */       if (i == 1) {
/*  941 */         str = new java.util.StringTokenizer(this.jTextField1.getText().trim(), "*(),", true);
/*      */       }
/*  943 */       else if (i == 2) {
/*  944 */         str = new java.util.StringTokenizer(this.jTextField2.getText().trim(), "*(),", true);
/*  945 */       } else if (i == 3) {
/*  946 */         str = new java.util.StringTokenizer(this.jTextField3.getText().trim(), "*(),", true);
/*  947 */       } else if (i == 4) {
/*  948 */         str = new java.util.StringTokenizer(this.jTextField4.getText().trim(), "*(),", true);
/*  949 */       } else if (i == 5) {
/*  950 */         str = new java.util.StringTokenizer(this.jTextField5.getText().trim(), "*(),", true);
/*  951 */       } else if (i == 6) {
/*  952 */         str = new java.util.StringTokenizer(this.jTextField6.getText().trim(), "*(),", true);
/*  953 */       } else if (i == 7) {
/*  954 */         str = new java.util.StringTokenizer(this.jTextField7.getText().trim(), "*(),", true);
/*      */       }
/*      */       
/*      */ 
/*  958 */       boolean isFunc1 = false;
/*  959 */       boolean hasOp1 = false;
/*  960 */       boolean isValidArgs = false;
/*  961 */       String f1arg1 = "";
/*      */       
/*  963 */       String f1arg2 = "";
/*      */       
/*      */ 
/*      */ 
/*  967 */       int numargs1 = 0;
/*  968 */       double mfactor1 = 1.0D;
/*      */       
/*  970 */       int func_type1 = 0;
/*      */       
/*      */ 
/*  973 */       while (str.hasMoreTokens()) {
/*  974 */         String func1 = str.nextToken();
/*  975 */         System.out.println("token is : " + func1);
/*      */         try {
/*  977 */           mfactor1 = Double.parseDouble(func1);
/*  978 */           System.out.println("got here");
/*  979 */           if (!str.nextToken().equals("*")) {
/*  980 */             System.out.println("token isz : " + func1);
/*  981 */             isFunc1 = false;
/*      */           }
/*      */           else
/*      */           {
/*      */             continue;
/*      */           }
/*      */         }
/*      */         catch (Exception e) {}
/*      */         
/*      */ 
/*  991 */         if (func1.equals("area_sq")) {
/*  992 */           isFunc1 = true;
/*  993 */           func_type1 = 1;
/*  994 */         } else if (func1.equals("area_rect")) {
/*  995 */           isFunc1 = true;
/*  996 */           func_type1 = 2;
/*  997 */         } else if (func1.equals("area_triangle")) {
/*  998 */           isFunc1 = true;
/*  999 */           func_type1 = 3;
/* 1000 */         } else if (func1.equals("area_circle")) {
/* 1001 */           isFunc1 = true;
/* 1002 */           func_type1 = 4;
/* 1003 */         } else if (func1.equals("(")) {
/* 1004 */           if (isFunc1) {
/* 1005 */             f1arg1 = str.nextToken();
/*      */             
/* 1007 */             float f1argnum = Float.parseFloat(f1arg1);
/* 1008 */             f1arg2 = str.nextToken();
/* 1009 */             if (f1arg2.equals(",")) {
/* 1010 */               f1arg2 = str.nextToken();
/* 1011 */               float f2argnum = Float.parseFloat(f1arg2);
/* 1012 */               isValidArgs = true;
/* 1013 */               numargs1 = 2;
/* 1014 */             } else if (f1arg2.equals(")")) {
/* 1015 */               numargs1 = 1;
/* 1016 */               isValidArgs = true;
/*      */             } else {
/* 1018 */               isValidArgs = false;
/*      */             }
/*      */           }
/*      */           else {
/* 1022 */             isFunc1 = false;
/*      */           }
/*      */           
/* 1025 */           if ((numargs1 != 1) && 
/* 1026 */             (str.hasMoreTokens()) && 
/* 1027 */             (!str.nextToken().equals(")"))) {
/* 1028 */             isFunc1 = false;
/*      */           }
/*      */         }
/*      */       }
/*      */       
/*      */ 
/*      */ 
/* 1035 */       System.out.println("IS Function: " + isFunc1);
/* 1036 */       System.out.println("Args valid: " + isValidArgs);
/* 1037 */       System.out.println("Function num: " + func_type1);
/* 1038 */       System.out.println("Total no. of args:" + numargs1);
/* 1039 */       System.out.println("Arg1: " + f1arg1);
/* 1040 */       System.out.println("Arg2: " + f1arg2);
/* 1041 */       System.out.println("mfactor: " + mfactor1 + "\n\n\n\n\n\n");
/*      */       
/*      */ 
/* 1044 */       if ((!isFunc1) || (!isValidArgs)) {
/* 1045 */         allcorrect = false;
/* 1046 */         javax.swing.JOptionPane.showMessageDialog(this.rootPane, "Invalid function call, check arguments in function call " + i, "Error", 0);
/*      */       }
/*      */       else
/*      */       {
/* 1050 */         double area = 0.0D;
/* 1051 */         if (func_type1 == 1)
/*      */         {
/* 1053 */           area = mfactor1 * Double.parseDouble(f1arg1) * Double.parseDouble(f1arg1);
/*      */           
/* 1055 */           totalarea = (float)(totalarea + area);
/*      */         }
/* 1057 */         if (func_type1 == 2)
/*      */         {
/* 1059 */           area = mfactor1 * Double.parseDouble(f1arg1) * Double.parseDouble(f1arg2);
/* 1060 */           totalarea = (float)(totalarea + area);
/*      */         }
/*      */         
/* 1063 */         if (func_type1 == 3)
/*      */         {
/* 1065 */           area = mfactor1 * 1.732D / 4.0D * Double.parseDouble(f1arg1) * Double.parseDouble(f1arg1);
/* 1066 */           totalarea = (float)(totalarea + area);
/*      */         }
/*      */         
/* 1069 */         if (func_type1 == 4)
/*      */         {
/* 1071 */           area = mfactor1 * 3.14D * Double.parseDouble(f1arg1) * Double.parseDouble(f1arg1);
/* 1072 */           totalarea = (float)(totalarea + area);
/*      */         }
/* 1074 */         javax.swing.JOptionPane.showMessageDialog(this.rootPane, "Area from function call : " + i + ": " + area, "Return value of a function", -1);
/*      */       }
/*      */     }
/*      */     
/* 1078 */     if (allcorrect == true)
/*      */     {
/* 1080 */       javax.swing.JOptionPane.showMessageDialog(this.rootPane, "Total area is :" + totalarea + "   Correct value is : 132.01728", "Result", -1);
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/* 1085 */       javax.swing.JOptionPane.showMessageDialog(this.rootPane, "Some function calls were incorrect. Please try again!", "Error", 0);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private javax.swing.JTextField jTextField3;
/*      */   
/*      */ 
/*      */   private javax.swing.JTextField jTextField4;
/*      */   
/*      */ 
/*      */   private javax.swing.JTextField jTextField5;
/*      */   
/*      */ 
/*      */   private javax.swing.JTextField jTextField6;
/*      */   
/*      */ 
/*      */   private javax.swing.JTextField jTextField7;
/*      */   
/*      */   private javax.swing.JTextPane jTextPane1;
/*      */   
/*      */   javax.swing.Icon square;
/*      */   
/*      */   javax.swing.Icon triangle;
/*      */   
/*      */   javax.swing.Icon rectangle;
/*      */   
/*      */   javax.swing.Icon circle;
/*      */   
/*      */   javax.swing.Icon finalfig;
/*      */   
/*      */   javax.swing.JRadioButton var1;
/*      */   
/*      */   javax.swing.JRadioButton var2;
/*      */   
/*      */   javax.swing.JRadioButton var3;
/*      */   
/*      */   javax.swing.JRadioButton dat1;
/*      */   
/*      */   javax.swing.JRadioButton dat2;
/*      */   
/*      */   javax.swing.JRadioButton ret1;
/*      */   
/*      */   javax.swing.JRadioButton ret2;
/*      */   
/*      */   javax.swing.JRadioButton f1;
/*      */   
/*      */   javax.swing.JRadioButton f2;
/*      */   
/*      */   javax.swing.JRadioButton f3;
/*      */   
/*      */   int varSelection;
/*      */   
/*      */   javax.swing.JTabbedPane tabbedPane;
/*      */   
/*      */   javax.swing.JDialog dialog;
/*      */   
/*      */   JPanel jPanel7;
/*      */   
/*      */   javax.swing.JLabel label;
/*      */   
/*      */   JPanel varPanel;
/*      */   
/*      */   JPanel datPanel;
/*      */   
/*      */   JPanel fPanel;
/*      */   
/*      */   JPanel retPanel;
/*      */   
/*      */   javax.swing.JLabel codeLabel;
/*      */   
/*      */   JPanel codeDis;
/*      */   
/*      */   private void fButton1ActionPerformed(java.awt.event.ActionEvent evt)
/*      */   {
/* 1161 */     if (!this.f1.isSelected()) {
/* 1162 */       this.label.setText("Incorrect Formula for calculating the area of a square.Try again");
/*      */     }
/*      */     else
/*      */     {
/* 1166 */       this.jButton2.setEnabled(true);
/*      */       
/* 1168 */       this.jButton1.setEnabled(false);
/* 1169 */       javax.swing.JOptionPane.showMessageDialog(this.rootPane, "//function for square\nfloat area_sq(float a){\n\tfloat area=a*a;\n\treturn area;\n}", "Functions defined", -1);
/* 1170 */       this.jTextArea4.setText("//function for square\nfloat area_sq(float a){\n\tfloat area=a*a;\n\treturn area;\n}\n\n");
/*      */       
/* 1172 */       this.dialog.dispose();
/* 1173 */       this.jTextPane1.setText(this.jTextPane1.getText() + "\nStep2:Define the function to calculate the area of rectangle: area_rect");
/*      */     }
/*      */   }
/*      */   
/*      */   private void varButton1ActionPerformed(java.awt.event.ActionEvent evt) {
/* 1178 */     if (!this.var1.isSelected()) {
/* 1179 */       this.label.setText("Incorrect value of number of input variables(arguments). Calculating the area of a square only requires the length of the side of the square. Try again ");
/*      */ 
/*      */ 
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/* 1189 */       this.label.setText("");
/* 1190 */       this.tabbedPane.setEnabledAt(0, false);
/* 1191 */       this.tabbedPane.setSelectedIndex(1);
/* 1192 */       this.tabbedPane.setEnabledAt(1, true);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private void datButton1ActionPerformed(java.awt.event.ActionEvent evt)
/*      */   {
/* 1199 */     if (this.dat1.isSelected() == true) {
/* 1200 */       this.label.setText("Incorrect datatype of input variables(arguments): The value of the side of a square need not be an integer. Try again");
/*      */ 
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/*      */ 
/*      */ 
/* 1208 */       this.label.setText("");
/* 1209 */       this.tabbedPane.setEnabledAt(1, false);
/* 1210 */       this.tabbedPane.setEnabledAt(2, true);
/* 1211 */       this.tabbedPane.setSelectedIndex(2);
/*      */     }
/*      */   }
/*      */   
/*      */   private void retButton1ActionPerformed(java.awt.event.ActionEvent evt)
/*      */   {
/* 1217 */     if (this.ret1.isSelected() == true) {
/* 1218 */       this.label.setText("Incorrect datatype for return type: The value of the area of a square need not be an integer. Try again");
/*      */     }
/*      */     else
/*      */     {
/* 1222 */       this.label.setText("");
/* 1223 */       this.tabbedPane.setEnabledAt(2, false);
/* 1224 */       this.tabbedPane.setEnabledAt(3, true);
/* 1225 */       this.tabbedPane.setSelectedIndex(3);
/*      */     }
/*      */   }
/*      */   
/*      */   private void fButton2ActionPerformed(java.awt.event.ActionEvent evt)
/*      */   {
/* 1231 */     if (!this.f2.isSelected()) {
/* 1232 */       this.label.setText("Incorrect Formula for calculating the area of a rectangle.Try again");
/*      */     }
/*      */     else
/*      */     {
/* 1236 */       this.jButton3.setEnabled(true);
/* 1237 */       this.jButton2.setEnabled(false);
/* 1238 */       javax.swing.JOptionPane.showMessageDialog(this.rootPane, "//function for square\nfloat area_sq(float a){\n\tfloat area=a*a;\n\treturn area;\n}\n\n//function for rectangle\nfloat area_rect(float a,float b){\n\tfloat area=a*b;\n\treturn area;\n}\n\n\n", "Functions defined", -1);
/*      */       
/*      */ 
/* 1241 */       this.dialog.dispose();
/* 1242 */       this.jTextArea4.setText("//function for square\nfloat area_sq(float a){\n\tfloat area=a*a;\n\treturn area;\n}\n\n//function for rectangle\nfloat area_rect(float a,float b){\n\tfloat area=a*b;\n\treturn area;\n}");
/* 1243 */       this.jTextPane1.setText(this.jTextPane1.getText() + "\nStep3:Define the function to calculate the area of an equilateral triangle: area_trainagle");
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private void retButton2ActionPerformed(java.awt.event.ActionEvent evt)
/*      */   {
/* 1250 */     if (this.ret1.isSelected() == true) {
/* 1251 */       this.label.setText("Incorrect datatype for return type: The value of the area of a square need not be an integer. Try again");
/*      */     }
/*      */     else
/*      */     {
/* 1255 */       this.label.setText("");
/* 1256 */       this.tabbedPane.setEnabledAt(2, false);
/* 1257 */       this.tabbedPane.setEnabledAt(3, true);
/* 1258 */       this.tabbedPane.setSelectedIndex(3);
/*      */     }
/*      */   }
/*      */   
/*      */   private void datButton2ActionPerformed(java.awt.event.ActionEvent evt)
/*      */   {
/* 1264 */     if (this.dat1.isSelected() == true) {
/* 1265 */       this.label.setText("Incorrect datatype of input variables(arguments): The value of the side of a square need not be an integer. Try again");
/*      */ 
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/*      */ 
/*      */ 
/* 1273 */       this.label.setText("");
/* 1274 */       this.tabbedPane.setEnabledAt(1, false);
/* 1275 */       this.tabbedPane.setEnabledAt(2, true);
/* 1276 */       this.tabbedPane.setSelectedIndex(2);
/*      */     }
/*      */   }
/*      */   
/*      */   private void varButton2ActionPerformed(java.awt.event.ActionEvent evt)
/*      */   {
/* 1282 */     if (!this.var2.isSelected()) {
/* 1283 */       this.label.setText("Incorrect value of number of input variables(arguments). Calculating the area of a rectangle requires the length of the two different parallel sides of the rectangle. Try again ");
/*      */ 
/*      */ 
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/* 1293 */       this.label.setText("");
/* 1294 */       this.tabbedPane.setEnabledAt(0, false);
/* 1295 */       this.tabbedPane.setSelectedIndex(1);
/* 1296 */       this.tabbedPane.setEnabledAt(1, true);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private void varButton3ActionPerformed(java.awt.event.ActionEvent evt)
/*      */   {
/* 1303 */     if (!this.var1.isSelected()) {
/* 1304 */       this.label.setText("Incorrect value of number of input variables(arguments). Calculating the area of an equilateral triangle only requires the length of one of the sides the triangle. Try again ");
/*      */ 
/*      */ 
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/* 1314 */       this.label.setText("");
/* 1315 */       this.tabbedPane.setEnabledAt(0, false);
/* 1316 */       this.tabbedPane.setSelectedIndex(1);
/* 1317 */       this.tabbedPane.setEnabledAt(1, true);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private void retButton3ActionPerformed(java.awt.event.ActionEvent evt)
/*      */   {
/* 1324 */     if (this.ret1.isSelected() == true) {
/* 1325 */       this.label.setText("Incorrect datatype for return type: The value of the area of an equilateral triangle need not be an integer. Try again");
/*      */     }
/*      */     else
/*      */     {
/* 1329 */       this.label.setText("");
/* 1330 */       this.tabbedPane.setEnabledAt(2, false);
/* 1331 */       this.tabbedPane.setEnabledAt(3, true);
/* 1332 */       this.tabbedPane.setSelectedIndex(3);
/*      */     }
/*      */   }
/*      */   
/*      */   private void fButton3ActionPerformed(java.awt.event.ActionEvent evt) {
/* 1337 */     if (!this.f3.isSelected()) {
/* 1338 */       this.label.setText("Incorrect Formula for calculating the area of an equilateral triangle square.Try again");
/*      */     }
/*      */     else
/*      */     {
/* 1342 */       this.jButton4.setEnabled(true);
/* 1343 */       this.jButton3.setEnabled(false);
/* 1344 */       this.jTextArea4.setText("//function for square\nfloat area_sq(float a){\n\tfloat area=a*a;\n\treturn area;\n}\n\n//function for rectangle\nfloat area_rect(float a,float b){\n\tfloat area=a*b;\n\treturn area;\n}\n\n\n//function for triangle\nfloat area_triangle(float a){\n\tfloat area=(sqrt(3)/4.0)*a*a;\n\treturn area;\n}\n\n\n");
/* 1345 */       this.dialog.dispose();
/* 1346 */       javax.swing.JOptionPane.showMessageDialog(this.rootPane, "//function for square\nfloat area_sq(float a){\n\tfloat area=a*a;\n\treturn area;\n}\n\n//function for rectangle\nfloat area_rect(float a,float b){\n\tfloat area=a*b;\n\treturn area;\n}\n\n\n//function for triangle\nfloat area_triangle(float a){\n\tfloat area=(sqrt(3)/4.0)*a*a;\n\treturn area;\n}\n\n\n", "Functions Defined", -1);
/* 1347 */       this.jTextPane1.setText(this.jTextPane1.getText() + "\nStep4:Define the function to calculate the area of a circle: area_circle");
/*      */     }
/*      */   }
/*      */   
/*      */   private void datButton3ActionPerformed(java.awt.event.ActionEvent evt)
/*      */   {
/* 1353 */     if (this.dat1.isSelected() == true) {
/* 1354 */       this.label.setText("Incorrect datatype of input variables(arguments): The value of the side of the rquilateral triangle need not be an integer. Try again");
/*      */ 
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/*      */ 
/*      */ 
/* 1362 */       this.label.setText("");
/* 1363 */       this.tabbedPane.setEnabledAt(1, false);
/* 1364 */       this.tabbedPane.setEnabledAt(2, true);
/* 1365 */       this.tabbedPane.setSelectedIndex(2);
/*      */     }
/*      */   }
/*      */   
/*      */   private void varButton4ActionPerformed(java.awt.event.ActionEvent evt) {
/* 1370 */     if (!this.var1.isSelected()) {
/* 1371 */       this.label.setText("Incorrect value of number of input variables(arguments). Calculating the area of circle only requires the radius. Try again ");
/*      */ 
/*      */ 
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/* 1381 */       this.label.setText("");
/* 1382 */       this.tabbedPane.setEnabledAt(0, false);
/* 1383 */       this.tabbedPane.setSelectedIndex(1);
/* 1384 */       this.tabbedPane.setEnabledAt(1, true);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   private void retButton4ActionPerformed(java.awt.event.ActionEvent evt)
/*      */   {
/* 1391 */     if (this.ret1.isSelected() == true) {
/* 1392 */       this.label.setText("Incorrect datatype for return type: The value of the area of an circle need not be an integer. Try again");
/*      */     }
/*      */     else
/*      */     {
/* 1396 */       this.label.setText("");
/* 1397 */       this.tabbedPane.setEnabledAt(2, false);
/* 1398 */       this.tabbedPane.setEnabledAt(3, true);
/* 1399 */       this.tabbedPane.setSelectedIndex(3);
/*      */     }
/*      */   }
/*      */   
/* 1403 */   private void fButton4ActionPerformed(java.awt.event.ActionEvent evt) { if (!this.f2.isSelected()) {
/* 1404 */       this.label.setText("Incorrect formula for calculating the area of a circle. Try again.");
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/*      */ 
/* 1410 */       this.dialog.dispose();
/*      */       
/* 1412 */       javax.swing.JOptionPane.showMessageDialog(this.rootPane, "//function for square\nfloat area_sq(float a){\n\tfloat area=a*a;\n\treturn area;\n}\n\n//function for rectangle\nfloat area_rect(float a,float b){\n\tfloat area=a*b;\n\treturn area;\n}\n\n\n//function for triangle\nfloat area_triangle(float a){\n\tfloat area=(sqrt(3)/4.0)*a*a;\n\treturn area;\n}\n\n\n//function for circle\nfloat area_circle(float a){\n\tfloat area=3.14*a*a;\n\treturn area;\n}", "//Functions defined :", -1);
/* 1413 */       this.jTextArea4.setText("//function for square\nfloat area_sq(float a){\n\tfloat area=a*a;\n\treturn area;\n}\n\n//function for rectangle\nfloat area_rect(float a,float b){\n\tfloat area=a*b;\n\treturn area;\n}\n\n\n//function for triangle\nfloat area_triangle(float a){\n\tfloat area=(sqrt(3)/4.0)*a*a;\n\treturn area;\n}\n\n\n//function for circle\nfloat area_circle(float a){\n\tfloat area=3.14*a*a;\n\treturn area;\n}");
/* 1414 */       this.jTextPane1.setText("Now calculate the area of given figure by making appropriate function calls  in the main function.");
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1422 */       this.jPanel4.removeAll();
/*      */       
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1428 */       this.jPanel4.validate();
/*      */       
/* 1430 */       this.jPanel7 = new JPanel();
/* 1431 */       javax.swing.JLabel figure = new javax.swing.JLabel(this.finalfig);
/*      */       
/* 1433 */       this.jPanel4.setLayout(new java.awt.BorderLayout());
/* 1434 */       this.jPanel4.add(this.jPanel7, "Center");
/* 1435 */       this.jPanel7.add(figure, "Center");
/* 1436 */       this.jPanel4.setVisible(true);
/* 1437 */       this.jPanel4.revalidate();
/* 1438 */       this.jPanel4.repaint();
/* 1439 */       this.jTextField1.setEnabled(true);
/* 1440 */       this.jTextField2.setEnabled(true);
/* 1441 */       this.jTextField3.setEnabled(true);
/* 1442 */       this.jTextField4.setEnabled(true);
/* 1443 */       this.jTextField5.setEnabled(true);
/* 1444 */       this.jTextField6.setEnabled(true);
/* 1445 */       this.jTextField7.setEnabled(true);
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   private void datButton4ActionPerformed(java.awt.event.ActionEvent evt)
/*      */   {
/* 1453 */     if (this.dat1.isSelected() == true) {
/* 1454 */       this.label.setText("Incorrect datatype of input variables(arguments): The value of the radius of the circle need not be an integer. Try again");
/*      */ 
/*      */ 
/*      */     }
/*      */     else
/*      */     {
/*      */ 
/*      */ 
/* 1462 */       this.label.setText("");
/* 1463 */       this.tabbedPane.setEnabledAt(1, false);
/* 1464 */       this.tabbedPane.setEnabledAt(2, true);
/* 1465 */       this.tabbedPane.setSelectedIndex(2);
/*      */     }
/*      */   }
/*      */   
/* 1469 */   private void initPanels() { this.dialog = new javax.swing.JDialog((java.awt.Frame)javax.swing.SwingUtilities.getAncestorOfClass(function.class, this));
/* 1470 */     this.dialog.setMinimumSize(new java.awt.Dimension(800, 600));
/* 1471 */     this.varPanel = new JPanel();
/* 1472 */     this.datPanel = new JPanel();
/* 1473 */     this.fPanel = new JPanel();
/* 1474 */     this.retPanel = new JPanel();
/*      */     
/* 1476 */     this.label = new javax.swing.JLabel("", 0);
/* 1477 */     this.codeLabel = new javax.swing.JLabel("<html><b>Function Definition prototype:<b> <br> <i>return_datatype</i> function_name(<i>input variables</i>){ <br> //code <br>return statement <br> }</html>");
/*      */     
/*      */ 
/*      */ 
/*      */ 
/* 1482 */     this.codeDis = new JPanel();
/* 1483 */     this.codeDis.setMinimumSize(new java.awt.Dimension(200, 200));
/* 1484 */     this.codeDis.add(this.codeLabel);
/*      */     
/* 1486 */     javax.swing.border.Border padding = javax.swing.BorderFactory.createEmptyBorder(20, 20, 5, 20);
/* 1487 */     this.codeDis.setBorder(padding);
/* 1488 */     this.varPanel.setBorder(padding);
/* 1489 */     this.datPanel.setBorder(padding);
/* 1490 */     this.retPanel.setBorder(padding);
/* 1491 */     this.fPanel.setBorder(padding);
/*      */     
/* 1493 */     this.tabbedPane = new javax.swing.JTabbedPane();
/* 1494 */     this.tabbedPane.addTab("Select number of input variables variables", null, this.varPanel, "1");
/*      */     
/*      */ 
/* 1497 */     this.tabbedPane.addTab("Datatype of input variables", null, this.datPanel, "2");
/*      */     
/*      */ 
/*      */ 
/* 1501 */     this.tabbedPane.addTab("Return type of the function", null, this.retPanel, "3");
/*      */     
/*      */ 
/* 1504 */     this.tabbedPane.addTab("Formula for calculating Area", null, this.fPanel, "4");
/*      */     
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/* 1512 */     this.dialog.add(this.tabbedPane, "Center");
/* 1513 */     this.dialog.add(this.label, "Last");
/* 1514 */     this.dialog.add(this.codeDis, "After");
/*      */     
/* 1516 */     this.dialog.setVisible(true);
/*      */     
/* 1518 */     this.tabbedPane.setEnabledAt(1, false);
/* 1519 */     this.tabbedPane.setEnabledAt(2, false);
/* 1520 */     this.tabbedPane.setEnabledAt(3, false);
/*      */     
/* 1522 */     this.label.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
/*      */   }
/*      */ }


/* Location:              /media/ajeet/ae48a349-76aa-44ab-b02b-ac75e34a2282/virtual-labs/labs/cse02/exp5/lab/classes/!/function/function/function.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       0.7.1
 */