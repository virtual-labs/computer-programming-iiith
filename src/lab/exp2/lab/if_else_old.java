import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;

public class if_else extends JApplet   
{
	public void init()
	{
		javax.swing.SwingUtilities.invokeLater( new Runnable (){
				public void run(){
				createAndShowGUI();
				}
				});
	}
	private void createAndShowGUI()
	{
		MyPanel myPane = new MyPanel();
		myPane.setOpaque(true);
		setContentPane(myPane);
	}
	//---------------------------------------------------------------

	public class MyPanel extends JPanel implements ActionListener
	{
		String str[] = {"Basic If-else Code" , "Basic If-ElseIf-Else Code" };
		String str_data_type[] = {"Integer" , "Double" };
		String str_experiment_type[] = {"Selecting a Day In a Week : CODE","Position Of a Point w.r.t Rectangle : CODE" };
		String str_code_1[] = { "boolean flag_1 , flag_2 , flag_3 , flag_4 ;",
					" ",
					"flag_1 = flag_2 = flag_3 = flag_4 = flase;",
					" ",
					"if ( X >= x1 )" ,
					"{",
					"	flag_1 = true;",
					"}",
					"if ( X <= x2 ) ",
					"{",
					"	flag_2 = true;",
					"}",
					"if ( Y >= y1 ) ",
					"{",
					"	flag_3 = true;",
					"}",
					"if ( Y <= y4 ) ",
					"{",
					"	flag_4 = true;",
					"}",
					"if ( flag_1 & flag_2 & flag_3 & flag_4 == true)",
					"{",
					"	printf(\"INSIDE\");",
					"}",
					"else",
					"{",
					"	printf(\"OUTSIDE\");",
					"}"
		};
		String str_code_2[] = { "boolean flag_inside ;",
					" ",
					"if ( X < x1 || X > x2 )" ,
					"{",
					"	flag_inside = false ;",
					"}",
					"else if ( Y < y1 || Y > y4 ) ",
					"{",
					"	flag_inside = false ;",
					"}",
					"else ",
					"{",
					"	flag_inside  = true;",
					"}",
					" ",
					"if ( flag_inside == true ) ",
					"{",
					"	printf(\"INSIDE\");",
					"}",
					"else",
					"{",
					"	printf(\"OUTSIDE\");",
					"}"
		};
		int code_1_space[] = {0,0,0 , 0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0};
		int code_2_space[] = {0,0,0,0 ,1, 0,0,0, 1,0,0,0, 1,0,0,0,0, 1,0,0,0, 1,0};

		boolean start_flag = false ; // idicates whether evalavuation is started or not 

		int count_next = 0 ;
		int code_highlight_index = -1 ;
		int code_2_highlight_part = -1 ; // (X > x1 || X < x2 ) In this kind of exp first part is hightlighted then second part of this OR cond
		int code_running = 1 ;
		
		myOutputPanel outputPanel ;
		JPanel topPanel ;
			JPanel top_head;
			JPanel top_menu;
		JPanel leftPanel ;
			JPanel left_top ;
			JPanel left_bottom ;
		JPanel rightPanel ;
				myCodePanel right_code_panel ;

		JLabel head ;
		JTextField exp_selected ;
		JLabel selected ;
		JLabel selected1 ;
		JLabel exp_label[] = new JLabel[10] ;
		JComboBox option ;

		JComboBox experiment_type ;
		JComboBox data_type ;
		JLabel l_exp_type ;
		JLabel l_data_type ;
		JButton go ;

		JTextField x1 , y1 ;
		JTextField x2 , y2 ;
		JTextField x3 , y3;
		JTextField x4 , y4;
		JTextField X , Y ;

		JButton initialize ;
		
		JLabel current_flag_1;
		JLabel current_flag_2;
		JLabel current_flag_3;
		JLabel current_flag_4;

		JLabel flag_1;
		JLabel flag_2;
		JLabel flag_3;
		JLabel flag_4;
		JLabel current_X ;
		JLabel current_Y ;

		JButton start ;
		JButton next ;



		public class myOutputPanel extends JPanel 
		{
			Font f1;
			Font f2;
			Font f3;
			String str1 , str2 ,str3 ;
			int start , end ;
			String[] temp;

			public myOutputPanel()
			{
				JPanel panel =  new JPanel();
				f1 = new Font("Arial",Font.BOLD,20);
				f2 = new Font("Arial",Font.ITALIC , 20);
				f3 = new Font("Arial",Font.ITALIC , 15);
			}
			public void paint( Graphics g )
			{
			
				// background
				g.setColor(new Color(255,245,245));
				g.fillRect(0,0,1000,1000);
				g.setColor(Color.lightGray);
				for ( int i = 0 ; i < 1000 ; i += 10 )
				{
					for ( int j = 0 ; j < 1000 ; j += 10 )
					{
						g.fillOval(i,j,1,1);
					}
				}

				//-------------------------------------
				g.setFont(f1);
				g.setColor(new java.awt.Color(221, 144, 123));
				g.fillRect(0 , 0 , 1000 , 45 );
				g.setColor(Color.black);
				g.drawString("OUTPUT OF THE RUNNING CODE:-" , 100 , 30 );

				g.setFont(f3);
				g.setColor(Color.black);
				g.drawString("(x1 , y1)",60,130);
				g.drawString("(x4 , y4)",60,480);
				g.drawString("(x3 , y3)",360,480);
				g.drawString("(x2 , y2)",360,130);
				
				g.setColor(Color.red);
				g.fillRect(100,150 , 300 ,300);
				g.setColor(Color.black);
				g.drawRect(100,150 , 300 ,300);
				if ( start_flag == true )
				{
					g.setColor(Color.blue);
					g.fillOval(Integer.parseInt(current_X.getText()) -4,Integer.parseInt(current_Y.getText()) +50 - 4, 8 ,8);
					g.drawString("(X , Y)",Integer.parseInt(current_X.getText())+20 ,Integer.parseInt(current_Y.getText()) + 50 );
				}
				g.setColor(Color.black);
				g.fillOval(100-4,150-4,8,8);
				g.fillOval(100-4,450-4,8,8);
				g.fillOval(400-4,450-4,8,8);
				g.fillOval(400-4,150-4,8,8);

				// showing out put 
				if ( code_running == 1)
				{
				if (code_highlight_index == 22)
				{
					g.setFont(f2);
					g.setColor(Color.black);
					g.drawString("Output :" ,100 , 90);
					g.setFont(f1);
					g.setColor(Color.red);
					g.drawString("INSIDE" ,200 , 90);
				}
				else if (code_highlight_index == 26)
				{
					g.setFont(f2);
					g.setColor(Color.black);
					g.drawString("Output :" ,100 , 90);
					g.setFont(f1);
					g.setColor(Color.blue);
					g.drawString("OUTSIDE" ,200 , 90);
				}
				}
				else if ( code_running == 2 )
				{
					if (code_highlight_index == 17)
				{
					g.setFont(f2);
					g.setColor(Color.black);
					g.drawString("Output :" ,100 , 90);
					g.setFont(f1);
					g.setColor(Color.red);
					g.drawString("INSIDE" ,200 , 90);
				}
				else if (code_highlight_index == 21)
				{
					g.setFont(f2);
					g.setColor(Color.black);
					g.drawString("Output :" ,100 , 90);
					g.setFont(f1);
					g.setColor(Color.blue);
					g.drawString("OUTSIDE" ,200 , 90);
				}		
				}
			}
		}
		public class myCodePanel extends JPanel
		{
			Font f1 ,f2;
			public myCodePanel()
			{
				f1 = new Font ( "Arial" , Font.BOLD , 12 );
				f2 = new Font ( "Arial" , Font.BOLD , 20 );
			}
			public void paint( Graphics g )
			{
// 				System.out.println("I am in paint ");
				int i ;

				g.setColor(new java.awt.Color(237, 214, 214));
				g.fillRect(0,0,1000,1000);

				g.setFont(f1);
				g.setColor(Color.blue);
				g.drawString("void main(){" , 10 , 40 );
					
				if ( code_running == 1 )
				{
					for (i = 0 ; i < str_code_1.length ; i++ )
					{
						g.setColor(Color.red);
						if ( i == code_highlight_index )
						{
							g.setColor(Color.green);
						}
						g.drawString(str_code_1[i] , 40+30*code_1_space[i] , 60 + i * 15);
					}
					g.setColor(Color.blue);
					g.drawString("}" , 10 , 60 + i * 15);
				}
				else if ( code_running == 2 )
				{

					for (i = 0 ; i < str_code_2.length ; i++ )
					{
						g.setColor(Color.red);
						if ( i == code_highlight_index )
						{
							g.setColor(Color.green);
							
						}

						if ( code_highlight_index == 2 && i == 2 )
						{
								g.setColor(Color.red);
								g.drawString(str_code_2[i].substring(0,4),40+30*code_2_space[i] , 60 + i * 15);
 								
								if ( code_2_highlight_part == 1 )
								{
									g.setColor(Color.green);
									g.drawString(str_code_2[i].substring(5,11), 40+30*code_2_space[i] + 25, 60 + i * 15);
									g.setColor(Color.red);
									g.drawString(str_code_2[i].substring(12,str_code_2[i].length()),+60+ 40+30*code_2_space[i] +10, 60 + i * 15);
								}
								else
								{
									g.setColor(Color.red);
									g.drawString(str_code_2[i].substring(5,15), 40+30*code_2_space[i] + 25, 60 + i * 15);
									g.setColor(Color.green);
									g.drawString(str_code_2[i].substring(15,str_code_2[i].length()),+75+ 40+30*code_2_space[i] +10, 60 + i * 15);
	
								}
						}
						else if ( code_highlight_index == 6 && i == 6 )
						{
								g.setColor(Color.red);
								g.drawString(str_code_2[i].substring(0,10),40+30*code_2_space[i] , 60 + i * 15);
 								
								if ( code_2_highlight_part == 1 )
								{
									g.setColor(Color.green);
									g.drawString(str_code_2[i].substring(10 , 16), 40+30*code_2_space[i] + 60, 60 + i * 15);
									g.setColor(Color.red);
									g.drawString(str_code_2[i].substring(16,str_code_2[i].length()),+90+ 40+30*code_2_space[i] +10, 60 + i * 15);
								}
								else
								{
									g.setColor(Color.red);
									g.drawString(str_code_2[i].substring(10,19), 40+30*code_2_space[i] + 65, 60 + i * 15);
									g.setColor(Color.green);
									g.drawString(str_code_2[i].substring(19,str_code_2[i].length()),+110+ 40+30*code_2_space[i] +10, 60 + i * 15);
	
								}
						}
						else
						{
							g.drawString(str_code_2[i] , 40+30*code_2_space[i] , 60 + i * 15);
						}
				
					}	
					g.setColor(Color.blue);
					g.drawString("}" , 10 , 60 + i * 15);
				}

			}
		}
		public MyPanel ()
		{
			setLayout(new BorderLayout());	
			
			setBorder(BorderFactory.createRaisedBevelBorder());
			topPanel = new JPanel();
			
				top_head = new JPanel();
					top_head.setBackground(new java.awt.Color(195, 119, 68));
					
					top_head.setBorder(BorderFactory.createRaisedBevelBorder());
					//top_head.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));
					head = new JLabel ("<html><FONT size=8><b>Experiment On Basic Control Flow :-</b></size></html>");
					experiment_type = new JComboBox(str_experiment_type);
					experiment_type.setSelectedIndex(1);
					experiment_type.addActionListener(this);
					top_head.add(head);
					top_head.add(experiment_type);		
					

			/*	top_menu = new JPanel();
					top_menu.setBackground(Color.lightGray);
					top_menu.setBorder(BorderFactory.createRaisedBevelBorder());

					exp_type = new JComboBox(str_exp_type);
					data_type = new JComboBox(str_data_type);
					l_exp_type = new JLabel("<html><b>SELECT OPERATORS TYPE :</b></html>");
					l_data_type = new JLabel("<html><b>SELECT DATA TYPE :</b></html>");
					go = new JButton("GO  ->"  );

					exp_type.setSelectedIndex(0);
					exp_type.addActionListener(this);
					data_type.setSelectedIndex(0);
					data_type.addActionListener(this);
					
					top_menu.add(l_exp_type);	
				//	top_menu.add(new JLabel("  "));	
					top_menu.add(exp_type);	
					top_menu.add(new JLabel("<html> &nbsp &nbsp &nbsp&nbsp &nbsp &nbsp&nbsp &nbsp &nbsp&nbsp &nbsp &nbsp </html>"));	
					top_menu.add(l_data_type);	
				//	top_menu.add(new JLabel("  "));	
					top_menu.add(data_type);	
					top_menu.add(new JLabel("<html> &nbsp &nbsp &nbsp&nbsp &nbsp &nbsp&nbsp &nbsp &nbsp&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp&nbsp &nbsp &nbsp</html>"));	
					top_menu.add(go);	
*/
				topPanel.setLayout(new BorderLayout());
				topPanel.add(top_head , BorderLayout.NORTH);
			//	topPanel.add(top_menu , BorderLayout.SOUTH);


			rightPanel = new JPanel();
				rightPanel.setLayout( new BorderLayout());
				rightPanel.setBorder(BorderFactory.createLoweredBevelBorder());

				JPanel right_head = new JPanel();
					right_head.setBackground(new java.awt.Color(221, 144, 123));
					right_head.setBorder(BorderFactory.createRaisedBevelBorder());
					selected1 = new JLabel("<html><font size=6>STEP BY STEP CODE FLOW </font></html>");
					right_head.add(selected1);
				right_code_panel = new myCodePanel();

				next = new JButton("NEXT");
				next.addActionListener(this);

				rightPanel.add(right_head , BorderLayout.NORTH );
				rightPanel.add(right_code_panel , BorderLayout.CENTER );
				rightPanel.add(next , BorderLayout.SOUTH );


			outputPanel = new myOutputPanel();

			leftPanel = new JPanel();
				leftPanel.setLayout( new BorderLayout ());

				left_top = new JPanel();
					left_top.setBorder(BorderFactory.createRaisedBevelBorder());
					left_top.setLayout(new BorderLayout());
					left_top.setBackground(new java.awt.Color(237, 214, 214));

					JPanel left_top1 = new JPanel();
						left_top1.setBorder(BorderFactory.createRaisedBevelBorder());
						JLabel left_top_head = new JLabel("<html><b><font size=5>INITIALIZE THE VALUES </font></b</html>");
						left_top1.add(left_top_head);
						left_top1.setBackground(new java.awt.Color(221, 144, 123));
					
					JPanel left_top2 = new JPanel();
						
						JPanel left_top2_1 = new JPanel();
						left_top2_1.setLayout(new FlowLayout(FlowLayout.CENTER ,5 , 15));
						JPanel left_top2_2 = new JPanel();
						left_top2_2.setLayout(new FlowLayout(FlowLayout.CENTER ,5 , 15));
						JPanel left_top2_3 = new JPanel();
						left_top2_3.setLayout(new FlowLayout(FlowLayout.CENTER ,5 , 15));
						left_top2_1.setBackground(new java.awt.Color(237, 214, 214));
						left_top2_2.setBackground(new java.awt.Color(237, 214, 214));
						left_top2_3.setBackground(new java.awt.Color(237, 214, 214));
						//	left_top2.setLayout(new GridLayout( 4 , 8 , 10 ,10));
						
						left_top2.setLayout(new BorderLayout());
						left_top2.add(left_top2_1 , BorderLayout.NORTH);
						left_top2.add(left_top2_2 , BorderLayout.CENTER);
						left_top2.add(left_top2_3 , BorderLayout.SOUTH);
				
						x1 = new JTextField("1", 3);
						x2 = new JTextField("0" ,3 );
						x3 = new JTextField("4" ,3 );
						x4 = new JTextField("3" ,3);
						y1 = new JTextField("1", 3 );
						y2 = new JTextField("0" ,3 );
						y3 = new JTextField("4" ,3 );
						y4 = new JTextField("3" ,3);

						X = new JTextField("210" ,4 );
						Y = new JTextField("210" ,4 );
						initialize = new JButton("Go");

						initialize.addActionListener(this);
						
						left_top2_1.add(new JLabel(" x1 ="));
						left_top2_1.add(new JLabel("100 ;"));
					//	left_top2_1.add(x1);
						left_top2_1.add(new JLabel("   y1 ="));
						left_top2_1.add(new JLabel("100 ;"));
					//	left_top2_1.add(y1);
						left_top2_1.add(new JLabel("   x2 ="));
						left_top2_1.add(new JLabel("400 ;"));
					//	left_top2_1.add(x2);
						left_top2_1.add(new JLabel("   y2 ="));
						left_top2_1.add(new JLabel("100 ;"));
					//	left_top2_1.add(y2);

						left_top2_2.add(new JLabel(" x3 ="));
						left_top2_2.add(new JLabel("400 ;"));
					//	left_top2_2.add(x3);
						left_top2_2.add(new JLabel("   y3 ="));
						left_top2_2.add(new JLabel("400 ;"));
					//	left_top2_2.add(y3);
						left_top2_2.add(new JLabel("   x4 ="));
						left_top2_2.add(new JLabel("100 ;"));
					//	left_top2_2.add(x4);
						left_top2_2.add(new JLabel("   y4 ="));
						left_top2_2.add(new JLabel("400 ;"));
					//	left_top2_2.add(y4);

						left_top2_3.add(new JLabel("X ="));
						left_top2_3.add(X);
						left_top2_3.add(new JLabel("Y ="));
						left_top2_3.add(Y);
						left_top2_3.add(new JLabel(" "));
						left_top2_3.add(new JLabel(" "));
						left_top2_3.add(new JLabel(" "));
						left_top2_3.add(initialize);



					left_top.add(left_top1 , BorderLayout.NORTH);
					left_top.add(new JLabel(" ") , BorderLayout.CENTER);
					left_top.add(left_top2 , BorderLayout.SOUTH);

				left_bottom = new JPanel();
					left_bottom.setBorder(BorderFactory.createRaisedBevelBorder());
					left_bottom.setLayout(new BoxLayout( left_bottom , BoxLayout.PAGE_AXIS));
					left_bottom.setBackground(new java.awt.Color(237, 214, 214));
					
					JPanel left_head_panel = new JPanel();
						JLabel left_head = new JLabel("<html><font size=5><b>SELECT THE CODE</b></font></html>");
						left_head.setAlignmentX(Component.CENTER_ALIGNMENT);
						left_head_panel.add(left_head);
						left_head_panel.setBackground(new java.awt.Color(221, 144, 123));

			//		exp_selected = new JTextField (str[0]);
			//		exp_selected.setAlignmentX(Component.CENTER_ALIGNMENT);
			//		exp_selected.setBorder(BorderFactory.createLoweredBevelBorder());
		
					option = new JComboBox(str);
					option.addActionListener(this);
					option.setSelectedIndex(0);
					option.setBorder(BorderFactory.createTitledBorder("Types Of Examples :-"));
	
					start = new JButton("START");
					start.addActionListener(this);

					JPanel left_bottom_current = new JPanel ();
						left_bottom_current.setBackground(new java.awt.Color(237, 214, 214));
					//	left_bottom_current.setBackground(Color.lightGray);
					//	left_bottom_current.setBorder(BorderFactory.);
						left_bottom_current.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder("LOCAL VARAIBLES :-"), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED)));

						left_bottom_current.setLayout(new GridLayout( 4, 4 , 10 ,15));

						current_flag_1 = new JLabel("FALSE");
						current_flag_2 = new JLabel("FALSE");
						current_flag_3 = new JLabel("FALSE");
						current_flag_4 = new JLabel("FALSE");
						flag_1 = new JLabel("flag_1 =");
						flag_2 = new JLabel("flag_2 =");
						flag_3 = new JLabel("flag_3 =");
						flag_4 = new JLabel("flag_4 =");
						current_X = new JLabel(X.getText());
						current_Y = new JLabel(Y.getText());

						current_flag_1.setVisible(false);
						current_flag_2.setVisible(false);
						current_flag_3.setVisible(false);
						current_flag_4.setVisible(false);

						flag_1.setVisible(false);
						flag_2.setVisible(false);
						flag_3.setVisible(false);
						flag_4.setVisible(false);


						left_bottom_current.add(new JLabel(" "));
						left_bottom_current.add(new JLabel(" "));
						left_bottom_current.add(new JLabel(" "));
						left_bottom_current.add(new JLabel(" "));
						left_bottom_current.add(flag_1);
						left_bottom_current.add(current_flag_1);
						left_bottom_current.add(flag_2);
						left_bottom_current.add(current_flag_2);
						left_bottom_current.add(flag_3);
						left_bottom_current.add(current_flag_3);
						left_bottom_current.add(flag_4);
						left_bottom_current.add(current_flag_4);

						left_bottom_current.add(new JLabel("X = "));
						left_bottom_current.add(current_X);
						left_bottom_current.add(new JLabel("Y = "));
						left_bottom_current.add(current_Y);

	
					left_bottom.add(left_head_panel );
					left_bottom.add(Box.createRigidArea(new Dimension (1 , 10)));
					left_bottom.add(option);
					left_bottom.add(Box.createRigidArea(new Dimension (1 ,  10)));
				//	left_bottom.add(exp_selected );
					left_bottom.add(Box.createRigidArea(new Dimension (0 ,  15)));
					left_bottom.add(start);
					left_bottom.add(Box.createRigidArea(new Dimension (0 , 20 )));
					left_bottom.add(left_bottom_current);

				leftPanel.add(left_top , BorderLayout.NORTH);
				leftPanel.add(left_bottom , BorderLayout.CENTER);

			
			add( topPanel , BorderLayout.NORTH);
			add( outputPanel , BorderLayout.CENTER);
			add( rightPanel , BorderLayout.EAST);
			add( leftPanel , BorderLayout.WEST);
		}
		public void actionPerformed ( ActionEvent e )
		{
			/*
			for ( int i = 0 ; i < 4 ; i++ )
			{
				if ( e.getSource() == exp_button[i])
				{
					changeSelected(i );
				}
			}*/

			if ( e.getSource() == next)
			{
				if ( start_flag == true )
				{
					int x1 = 100 ; int x2 = 400 ; int y1 = 100 ; int y2 = 100 ;
					int x3 = 400 ; int x4 = 100 ; int y3 = 400 ; int y4 = 400 ;
					int x = Integer.parseInt(current_X.getText()) ; 
					int y = Integer.parseInt(current_Y.getText()) + 50 ;
				if ( code_running == 1 )
				{
					if ( code_highlight_index <= 3 )
					{
						code_highlight_index += 1  ;
						right_code_panel.repaint();
						if ( code_highlight_index == 1 )
						{
							flag_1.setVisible(true);
							flag_2.setVisible(true);
							flag_3.setVisible(true);
							flag_4.setVisible(true);
						}
						else if ( code_highlight_index == 2 )
						{
							current_flag_1.setText("false");
							current_flag_2.setText("false");
							current_flag_3.setText("false");
							current_flag_4.setText("false");
							current_flag_1.setVisible(true);
							current_flag_2.setVisible(true);
							current_flag_3.setVisible(true);
							current_flag_4.setVisible(true);
						}
					}
					else if ( code_highlight_index == 4 )
					{
						if ( x >= x1 )
						{
							code_highlight_index = 6  ;
							right_code_panel.repaint();
							current_flag_1.setText("<html><font color=red>TRUE</font></html>");
						}
						else
						{
							code_highlight_index = 8 ;
							right_code_panel.repaint();
						
						}
					}
					else if ( code_highlight_index == 6 )
					{
						code_highlight_index = 8  ;
						right_code_panel.repaint();
					}	
					else if ( code_highlight_index == 8 )
					{
						if ( x <= x2 )
						{
							code_highlight_index = 10  ;
							right_code_panel.repaint();
							current_flag_2.setText("<html><font color=red>TRUE</font></html>");
						}
						else
						{
							code_highlight_index = 12 ;
							right_code_panel.repaint();
						}
					}
					else if ( code_highlight_index == 10 )
					{
						code_highlight_index = 12  ;
						right_code_panel.repaint();
					}
					else if ( code_highlight_index == 12 )
					{
						if ( y >= y1 )
						{
							code_highlight_index = 14  ;
							right_code_panel.repaint();
							current_flag_3.setText("<html><font color=red>TRUE</font></html>");
						}
						else
						{
							code_highlight_index = 16 ;
							right_code_panel.repaint();
						}
					}
					else if ( code_highlight_index == 14 )
					{
						code_highlight_index = 16  ;
						right_code_panel.repaint();
					}
					else if ( code_highlight_index == 16 )
					{
						if ( y <= y4 )
						{
							code_highlight_index = 18  ;
							right_code_panel.repaint();
							current_flag_4.setText("<html><font color=red>TRUE</font></html>");
						}
						else
						{
							code_highlight_index = 20 ;
							right_code_panel.repaint();
						}
					}
					else if ( code_highlight_index == 18 )
					{
						code_highlight_index = 20  ;
						right_code_panel.repaint();
					}
					else if ( code_highlight_index == 20 )
					{
						if ( x >= x1 && x <= x2 && y >= y1 && y <= y4 )
						{
							code_highlight_index = 22  ;
							right_code_panel.repaint();
							outputPanel.repaint();
						}
						else
						{
							code_highlight_index = 24  ;
							right_code_panel.repaint();
						}
					}
					else if ( code_highlight_index == 24 )
					{
						code_highlight_index = 26  ;
						right_code_panel.repaint();
						outputPanel.repaint();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Code is DOne :)");
						start_flag = false ;
					}
				}
				else if ( code_running == 2)
				{
					if ( code_highlight_index <= 1 )
					{
						code_highlight_index += 1  ;
						if ( code_highlight_index == 2 )
						{
							code_2_highlight_part = 1 ; // show only first part 
						}
						right_code_panel.repaint();
						flag_1.setText("flag_inside = ");
						flag_1.setVisible(true);

						current_flag_1.setText(" ");
						current_flag_1.setVisible(true);
						//	current_flag_3.setVisible(true);
						//	current_flag_4.setVisible(true);
						
					}
					else if ( code_highlight_index == 2 ) // this line have OR condition 
					{
						if ( x < x1 && code_2_highlight_part == 1 )
						{
							code_2_highlight_part = -1  ;
							code_highlight_index = 4  ;
							right_code_panel.repaint();
							current_flag_1.setText("<html><font color=red>FALSE</font></html>");
// 							code_2_highlight_part = 2  ;
// 							right_code_panel.repaint();
						}
						else if ( x >= x1 && code_2_highlight_part == 1 )
						{
							code_highlight_index = 2 ;
							code_2_highlight_part = 2 ;
							right_code_panel.repaint();
						
						}
						else if ( x > x2 && code_2_highlight_part == 2 )
						{
							code_2_highlight_part = -1  ;
							code_highlight_index = 4  ;
							right_code_panel.repaint();
							current_flag_1.setText("<html><font color=red>FALSE</font></html>");
						}
						else if ( x <= x2 && code_2_highlight_part == 2 )
						{
							code_highlight_index = 6 ;
							code_2_highlight_part = 1 ; // show only first part Setting for 6th line 
							right_code_panel.repaint();
						}
// 						if ( x < x1 || x > x2)
// 						{
// 							code_highlight_index = 4  ;
// 							right_code_panel.repaint();
// 							current_flag_1.setText("<html><font color=red>FALSE</font></html>");
// 						}
// 						else
// 						{
// 							code_highlight_index = 6 ;
// 							right_code_panel.repaint();
// 						
// 						}
					}
					else if ( code_highlight_index == 4 )
					{
						code_highlight_index = 15  ;
						right_code_panel.repaint();
					}	
					else if ( code_highlight_index == 6 )
					{
						
						if ( y < y1 && code_2_highlight_part == 1 )
						{
							code_2_highlight_part = -1  ;
							code_highlight_index = 8  ;
							right_code_panel.repaint();
							current_flag_1.setText("<html><font color=red>FALSE</font></html>");
// 							code_2_highlight_part = 2  ;
// 							right_code_panel.repaint();
						}
						else if ( y >= y1 && code_2_highlight_part == 1 )
						{
							code_highlight_index = 6 ;
							code_2_highlight_part = 2 ;
							right_code_panel.repaint();
						
						}
						else if ( y > y4 && code_2_highlight_part == 2 )
						{
							code_2_highlight_part = -1  ;
							code_highlight_index = 8  ;
							right_code_panel.repaint();
							current_flag_1.setText("<html><font color=red>FALSE</font></html>");
						}
						else if ( y <= y4 && code_2_highlight_part == 2 )
						{
							code_highlight_index = 10 ;
							code_2_highlight_part = -1 ;
							right_code_panel.repaint();
						}

/*						if ( y < y1 || y > y4  )
						{
							code_highlight_index = 8  ;
							right_code_panel.repaint();
							current_flag_1.setText("<html><font color=red>FALSE</font></html>");
						}
						else
						{
							code_highlight_index = 10 ;
							right_code_panel.repaint();
						}*/
					}
					else if ( code_highlight_index == 8 )
					{
						code_highlight_index = 15  ;
						right_code_panel.repaint();
					}
					else if ( code_highlight_index == 10 )
					{
							code_highlight_index = 12  ;
							right_code_panel.repaint();
							current_flag_1.setText("<html><font color=red>TRUE</font></html>");
					}
					else if ( code_highlight_index == 12 )
					{
						code_highlight_index = 15  ;
						right_code_panel.repaint();
					}
					else if ( code_highlight_index == 15 )
					{
						if ( x >= x1 && x <= x2 && y >= y1 && y <= y4 )
						{
							code_highlight_index = 17  ; // INSIDE
							right_code_panel.repaint();
							outputPanel.repaint();
						}
						else
						{
							code_highlight_index = 19  ;
							right_code_panel.repaint();
						}
					}
					else if ( code_highlight_index == 19 )
					{
						code_highlight_index = 21  ;      // OUTSIDE
						outputPanel.repaint();
						right_code_panel.repaint();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Code is DOne :)");
						start_flag = false ;
					}
				}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Please first press the start button :)");
				}
				
			}
			else if ( e.getSource() == initialize )
			{
				if ( start_flag == false )
				{
					current_X.setText(X.getText());
					current_Y.setText(Y.getText());
				}
			}
			else if ( e.getSource() == start )
			{
				start_flag = true ;
				code_highlight_index = -1  ;

				right_code_panel.repaint();
				outputPanel.repaint();

				current_flag_1.setVisible(false);
				current_flag_2.setVisible(false);
				current_flag_3.setVisible(false);
				current_flag_4.setVisible(false);

				current_flag_1.setText(" ");
				current_flag_2.setText(" ");
				current_flag_3.setText(" ");
				current_flag_4.setText(" ");

				flag_1.setVisible(false);
				flag_2.setVisible(false);
				flag_3.setVisible(false);
				flag_4.setVisible(false);
				
				if (code_running == 1 )
				{
					flag_1.setText("flag_1 =");
					flag_2.setText("flag_2 =");
					flag_3.setText("flag_3 =");
					flag_4.setText("flag_4 =");
				}
				else if ( code_running == 2 )
				{
					flag_1.setText("flag_inside = ");
				}

//				String input_str = exp_selected.getText();
			//	tree = new infix(input_str);
				
			/*	if ( tree != null && tree.results != null ) // for wrong expression (Error Check )
				{
					start_flag = true ;
					count_steps = 0 ;
					repaint();
				}
				else
				{
					JOptionPane.showMessageDialog(null, "You entered wrong expression :(");
				}
			*/
			}
			else if ( e.getSource() == experiment_type )
			{
				
					JComboBox cb = (JComboBox)e.getSource();
					if ( cb != null && cb.getSelectedIndex() == 0 )
					{
						System.out.println(cb.getSelectedIndex() + "HI shashank " );
						URL base = null ;
						try // geting base URL address of this applet 
						{
								base = getDocumentBase();
						}
						catch( Exception e1) {}

						try
						{
							//URL url = new URL("http://localhost/VirtualLab/VLSI_VLab/exp1_out.php?name=Shahsank");
							URL url = new URL(base ,"backup10	_basic_Vlab/build/NewJApplet.html");
							getAppletContext().showDocument(url ,"_self");
						}
						catch(Exception e2 )
						{}
 					}
					else
					{
							System.out.println(cb.getSelectedIndex() + "HI shashank " );
					}
				
			}
			else if ( e.getSource() == option )
			{
				if ( start_flag == false )
				{
					JComboBox cb = (JComboBox)e.getSource();
					if ( cb != null )
					{
// 						System.out.println("option");
					//	exp_selected.setText((String)cb.getSelectedItem());
					//	String s = (String)cb.getSelectedItem();
						code_highlight_index = -1  ;
						code_running = cb.getSelectedIndex() + 1;
						if ( code_running > 2 )
						{
							code_running = 2 ;
						}

						right_code_panel.repaint();
						outputPanel.repaint();
//   						System.out.println("cb.getSelectedIndex()");
//   						System.out.println(cb.getSelectedIndex());
					}
				}
			}
		}
	}
}
