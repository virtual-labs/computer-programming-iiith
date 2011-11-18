import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

import java.net.*;

public class logoperator_eval extends JApplet   
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
		String str[] = {"a || b && c","( a || b ) && c","a && b || c && d","a && ( b || c ) && d"  };
		String reason[][] = 
		{
			{
				"Here , '&&' operator has higher precedence than '||' operator . So , '&&' operator is operated first .",
				"Here , '||' is the only operator .",
				"Answer ."
			},
			{
				"Here , '()' bracket  operator has higher precedence than '&&' operator . So , the expression inside the bracket operator is evaluated first .",
				"Here , '&&' is the only operator .",
				"Answer ."
			},
			{
				"Here , '&&' operator has higher precedence than '||' operator . But we have TWO '&&' operator , so the Left To Right evaluation rule is applied among the two '&&' operators and thus Left most '&&' operator is  operated first .",
				"Here , '&&' operator has higher precedence than '||' operator . So , '&&' operator is operated first .",
				"Here , '||' is the only operator .",
				"Answer ."
			},
			{
				"Here , '()' bracket  operator has higher precedence than '&&' operator . So , the expression inside the  bracket operator is evaluated first .",
				"Here , both operatos are '&&' (i.e of same precedence ) . So , we apply the Left To Right evaluation rule and thus Left most '&&' operator is operated first .",
				"Here , '&&' is the only operator .",
				"Answer ."

			}
		};
		String val[] = {"0","1","0","1"};
		String str_data_type[] = {"Integer" };
		String str_exp_type[] = {"Logical", "Arithematic" ,  "Bitwise" };

		myExpPanel expPanel ;
		JPanel topPanel ;
			JPanel top_head;
			JPanel top_menu;
		JPanel leftPanel ;
			JPanel left_top ;
			JPanel left_bottom ;
		JPanel rightPanel ;
			myReasonPanel right_reason_panel ;
			JPanel right_head ;

		JLabel head ;
		JTextField exp_selected ;
		JLabel selected ;
		JLabel selected1 ;
		JLabel exp_label[] = new JLabel[10] ;
		JComboBox option ;

		JComboBox exp_type ;
		JComboBox data_type ;
		JLabel l_exp_type ;
		JLabel l_data_type ;
		JButton go ;

		JLabel l_a ;
		JLabel l_b ;
		JLabel l_c ;
		JLabel l_d ;
		JTextField a ;
		JTextField b ;
		JTextField c ;
		JTextField d ;
		JButton initialize ;
		
		JLabel current_a ;
		JLabel current_b ;
		JLabel current_c ;
		JLabel current_d ;

		JButton start ;
		JButton next ;

		boolean start_flag = false ; // idicates whether evalavuation is started or not 

	//	loginfix my = null ;
		loginfix tree = new loginfix(str[0] , val[0]+":"+val[1]+":"+val[2]+":"+val[3]);
		int count_steps = 0 ;

		public class myExpPanel extends JPanel 
		{
			Font f1;
			Font f2;
			Font f3;
			String str1 , str2 ,str3 ;
			int start , end ;
			String[] temp;

			public myExpPanel()
			{
				JPanel panel =  new JPanel();
				f1 = new Font("Arial",Font.BOLD,16);
				f2 = new Font("Arial",Font.PLAIN , 18);
				f3 = new Font("Arial",Font.ITALIC , 15);
			}
			public void paint( Graphics g )
			{
	//			System.out.println("I am in paint ");

				g.setFont(f1);
				g.setColor(Color.lightGray);
				g.fillRect(0 , 0 , 1000 , 50 );
				g.setColor(Color.black);
				g.drawString("EVALUATION FLOW OF EXPRESSION" , 50 , 30 );

				g.setColor(Color.red);
				g.drawString(tree.results[0] ,70 ,  80  );
				g.setColor(Color.blue);
				g.drawString("Exp :" , 10 ,80  );


				for (int  i = 0 ; i < count_steps ; i ++ )
				{
					System.out.println(tree.offsets[i]);

				//	System.out.println("start");
				//	System.out.println(start);
				//	System.out.println(end);

					temp = tree.offsets[i].split(":");

					if ( temp.length != 2  )
					{
						g.setColor(Color.red);
						g.setFont(f1);
						g.drawString( tree.results[i] ,70 ,80 +40*(i+1) );
						g.setColor(Color.blue);
						g.drawString("Ans :" ,10 ,80 +40*(i+1) );
					}
					else
					{
					start = Integer.parseInt(temp[0]);
					end = Integer.parseInt(temp[1]);
					str1 = tree.results[i].substring(0,start);
					str2 = tree.results[i].substring(start , end+ 1);
					str3 = tree.results[i].substring( end  , tree.results[i].length() - 1);

					g.setColor(Color.blue);
					g.setFont(f3);
					g.drawString("Step "+(i+1)+":" ,10 ,80 +40*(i+1) );

					g.setColor(Color.red);
					g.setFont(f1);
					g.drawString( str1 ,70 ,80 +40*(i+1) );
					g.setColor(Color.blue);
					g.setFont(f2);
					g.drawString( str2 ,70 + 8*str1.length() ,80+40*(i+1) );
					g.setColor(Color.red);
					g.setFont(f1);
					g.drawString( str3 ,70 + 8*(str1.length()+str2.length()) , 80 +40*(i+1) );
					}
				}
			}
		}
		public class myReasonPanel extends JPanel 
		{
			Font f1 , f2;
			JScrollPane scrollreasons,scrollops;
			JEditorPane reasoning;
			String reasons1;
			JLabel operation;
			JEditorPane recentOp;
			public myReasonPanel ()
			{
				JPanel panel =  new JPanel();
				setLayout(new BorderLayout());
				f1 = new Font("Arial",Font.PLAIN , 12);
				f2 = new Font("Arial",Font.BOLD , 15);

				reasoning = new JEditorPane();
				reasoning.setFont(f1);
				reasoning.setPreferredSize(new Dimension(360,300));
				reasoning.setEditable(false);
				reasoning.setContentType("text/plain");
				reasoning.getEditorKit().createDefaultDocument();
				reasoning.setBackground(panel.getBackground());
				reasoning.setForeground(Color.BLUE);
				reasoning.setText("\n\nHere variables are replaced by their values\n\n");

				scrollreasons = new JScrollPane(reasoning);
				scrollreasons.setPreferredSize(new Dimension(360,300));
				add(scrollreasons,BorderLayout.NORTH);
				
				JPanel recentOp_head = new JPanel();
					recentOp_head.setBackground(Color.lightGray);
					recentOp_head.setBorder(BorderFactory.createRaisedBevelBorder());
					recentOp_head.setPreferredSize(new Dimension(365,30));
					operation = new JLabel("<html><b><FONT size=4> CURRENT OPERATION </size></b></html>");
					recentOp_head.add(operation);
				add(recentOp_head,BorderLayout.CENTER);
					
				recentOp = new JEditorPane();
				recentOp.setFont(f2);
				recentOp.setContentType("text/html");
				recentOp.setPreferredSize(new Dimension(360,120));
				recentOp.setEditable(false);
				recentOp.setBackground(Color.lightGray.brighter());
				recentOp.setForeground(Color.MAGENTA);
			
				scrollops = new JScrollPane(recentOp);
				scrollops.setPreferredSize(new Dimension(360,120));
				add(scrollops,BorderLayout.SOUTH);


			}
		/*	public void paint(Graphics g )
			{

				g.setFont(f2);
				g.setColor(Color.blue);
				g.drawString("Here variables are replaced by their values." , 10 , 40);
				g.setFont(f1);
				for (int  i = 0 ; i < count_steps ; i ++ )
				{
					g.setColor(Color.red);
					g.drawString((i+1)+")" ,5 , 40*(i+2) );
					g.setColor(Color.blue);
					if ( tree.reasons[i].length()  != 0 )
					{
						g.drawString(tree.reasons[i] , 30 , 40 *( i + 2 ));
					}
					else
					{
						g.drawString("ANSWER" , 40 , 40 *( i + 2 ));
					}
				}
				
			}
		*/		
			public void write_reasons(){
				reasoning.setForeground(Color.BLUE);
				reasons1 = new String("\n\nHere variables are replaced by their values\n\n");
				for (int  i = 0 ; i < count_steps ; i++ )
				{
					reasons1 = reasons1.concat((i+1)+") " );
				//	if ( tree.reasons[i].length()  != 0 )
					if ( reason[option.getSelectedIndex()][i].length()  != 0 )
					{
						//reasons1 = reasons1.concat(tree.reasons[i]+ "\n\n");
						reasons1 = reasons1.concat(reason[option.getSelectedIndex()][i]+ "\n\n");
					}
					else
					{
						reasons1 = reasons1.concat("ANSWER\n");
					}
				}
				reasoning.setText(reasons1);
				if(tree.operations[count_steps-1].compareTo("") != 0)
					recentOp.setText("\n                      "+tree.operations[count_steps-1]);
			}

		}
		public MyPanel ()
		{
			setLayout(new BorderLayout());	
			
		//	this.setBorder(BorderFactory.createRaisedBevelBorder());
			this.setBorder(BorderFactory.createEtchedBorder(Color.black , Color.gray));

			topPanel = new JPanel();
			
				top_head = new JPanel();
					top_head.setBackground(Color.gray);
					top_head.setBorder(BorderFactory.createRaisedBevelBorder());

					head = new JLabel ("<html><FONT size=6><b>Experiment On Operators :-</b></size></html>");
					top_head.add(head);	

				top_menu = new JPanel();
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
					//top_menu.add(go);	

				topPanel.setLayout(new BorderLayout());
				topPanel.add(top_head , BorderLayout.NORTH);
				topPanel.add(top_menu , BorderLayout.SOUTH);


			rightPanel = new JPanel();
				rightPanel.setLayout( new BorderLayout());
				rightPanel.setBorder(BorderFactory.createLoweredBevelBorder());

				right_head = new JPanel();
					right_head.setBackground(Color.lightGray);
					right_head.setBorder(BorderFactory.createRaisedBevelBorder());
					right_head.setPreferredSize(new Dimension(365,30));
					selected1 = new JLabel("<html><font size=4>STEP BY STEP REASONING </font></html>");
					right_head.add(selected1);

				right_reason_panel = new myReasonPanel();

			/*	next = new JButton("NEXT");
				next.setEnabled(false);
				next.addActionListener(this);
			*/
				rightPanel.add(right_head , BorderLayout.NORTH );
				rightPanel.add(right_reason_panel , BorderLayout.CENTER );
			//	rightPanel.add(next , BorderLayout.SOUTH );


			expPanel = new myExpPanel();


			leftPanel = new JPanel();
				leftPanel.setLayout( new BorderLayout ());

				left_top = new JPanel();
					left_top.setBorder(BorderFactory.createRaisedBevelBorder());
					left_top.setLayout(new BorderLayout());

					JPanel left_top1 = new JPanel();
						JLabel left_top_head = new JLabel("<html><b>INITIALIZE THE VALUES </b</html>");
						left_top1.add(left_top_head);
						left_top1.setBackground(Color.gray);
					
					JPanel left_top2 = new JPanel();
						left_top2.setLayout(new GridLayout( 4 , 4 , 10 ,10));
						l_a = new JLabel(" a =");
						l_b = new JLabel(" b =");
						l_c = new JLabel(" c =");
						l_d = new JLabel(" d =");
				
						a = new JTextField(val[0], 2 );
						b = new JTextField(val[1] ,2 );
						c = new JTextField(val[2] ,2 );
						d = new JTextField(val[3],2);
						initialize = new JButton("Edit");

						a.setEditable(false);
						b.setEditable(false);
						c.setEditable(false);
						d.setEditable(false);

	
						initialize.setPreferredSize(new Dimension(70,30));
						initialize.addActionListener(this);
						
						left_top2.add(l_a);
						left_top2.add(a);
						left_top2.add(l_b);
						left_top2.add(b);
						left_top2.add(l_c);
						left_top2.add(c);
						left_top2.add(l_d);
						left_top2.add(d);
						left_top2.add(new JLabel(" "));
						left_top2.add(new JLabel(" "));
						//left_top2.add(initialize);
						left_top2.add(new JLabel(" "));
						left_top2.add(new JLabel(" "));
						left_top2.add(new JLabel(" "));
						left_top2.add(new JLabel(" "));
						

						JPanel left_top22 = new JPanel();
						left_top22.setLayout(new BorderLayout());
						left_top22.add(left_top2,BorderLayout.NORTH);
						left_top22.add(new JLabel("                 "),BorderLayout.EAST);
						left_top22.add(new JLabel("                 "),BorderLayout.WEST);
						left_top22.add(initialize,BorderLayout.CENTER);
						left_top22.add(new JLabel(" \t\t\t\t\t\t\t\t\t\t"),BorderLayout.SOUTH);


					left_top.add(left_top1 , BorderLayout.NORTH);
					left_top.add(new JLabel(" ") , BorderLayout.CENTER);
					left_top.add(left_top22 , BorderLayout.SOUTH);

				left_bottom = new JPanel();
					left_bottom.setBorder(BorderFactory.createRaisedBevelBorder());
					left_bottom.setLayout(new BoxLayout( left_bottom , BoxLayout.Y_AXIS));
					
					JPanel left_head_panel = new JPanel();
						left_head_panel.setLayout(new BoxLayout(left_head_panel, BoxLayout.Y_AXIS));
						left_head_panel.add(Box.createRigidArea(new Dimension (20 ,  10)));
						JLabel left_head = new JLabel("<html><center><b>SELECT THE EXPRESSION</b></center></html>");
						left_head_panel.setAlignmentX(Component.CENTER_ALIGNMENT);
						left_head_panel.add(left_head);
						left_head_panel.setBackground(Color.gray);

					exp_selected = new JTextField (str[0]);
			//		exp_selected.setAlignmentX(Component.CENTER_ALIGNMENT);
		//			exp_selected.setBorder(BorderFactory.createLoweredBevelBorder());
		
					option = new JComboBox(str);
					option.addActionListener(this);
					option.setSelectedIndex(0);
					option.setBorder(BorderFactory.createTitledBorder("Expressions"));
					
					JPanel optionmenu = new JPanel();
					optionmenu.setPreferredSize(new Dimension(200,5));
					optionmenu.add(option);

					JPanel stnext_buts = new JPanel();
					stnext_buts.setLayout(new BoxLayout( stnext_buts , BoxLayout.X_AXIS));
	
					start = new JButton("START");
					start.addActionListener(this);
					
					next = new JButton("NEXT");
					next.setEnabled(false);
					next.addActionListener(this);
					stnext_buts.add(start);
					stnext_buts.add(Box.createRigidArea(new Dimension (20 ,  10)));
					stnext_buts.add(next);
		

					JPanel left_bottom_current = new JPanel ();
			/*			left_bottom_current.setBackground(Color.lightGray);
						left_bottom_current.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLoweredBevelBorder(),"CURRENT VLAUES"));
						left_bottom_current.setLayout(new GridLayout( 5, 4 , 10 ,15));
						current_a = new JLabel(a.getText());
						current_b = new JLabel(b.getText());
						current_c = new JLabel(c.getText());
						current_d = new JLabel(d.getText());
						left_bottom_current.add(new JLabel(" "));
						left_bottom_current.add(new JLabel(" "));
						left_bottom_current.add(new JLabel(" "));
						left_bottom_current.add(new JLabel(" "));
						left_bottom_current.add(new JLabel(" a ="));
						left_bottom_current.add(current_a);
						left_bottom_current.add(new JLabel(" b ="));
						left_bottom_current.add(current_b);
						left_bottom_current.add(new JLabel(" "));
						left_bottom_current.add(new JLabel(" "));
						left_bottom_current.add(new JLabel(" "));
						left_bottom_current.add(new JLabel(" "));
						left_bottom_current.add(new JLabel(" c ="));
						left_bottom_current.add(current_c);
						left_bottom_current.add(new JLabel(" d ="));
						left_bottom_current.add(current_d);
						left_bottom_current.add(new JLabel(" "));
						left_bottom_current.add(new JLabel(" "));
						left_bottom_current.add(new JLabel(" "));
						left_bottom_current.add(new JLabel(" "));
				*/
	
					left_bottom.add(left_head_panel );
				//	left_bottom.add(Box.createRigidArea(new Dimension (1 , 10)));
				//	left_bottom.add(option);
//					left_bottom.add(Box.createRigidArea(new Dimension (1 ,  10)));
//					left_bottom.add(exp_selected );
					left_bottom.add(Box.createRigidArea(new Dimension (0 ,  10)));
					left_bottom.add(optionmenu);
					left_bottom.add(Box.createRigidArea(new Dimension (0 ,  10)));
					left_bottom.add(stnext_buts);
					left_bottom.add(Box.createRigidArea(new Dimension (0 , 30 )));
					left_bottom.add(left_bottom_current);

				leftPanel.add(left_top , BorderLayout.NORTH);
				leftPanel.add(left_bottom , BorderLayout.CENTER);

			
			add( topPanel , BorderLayout.NORTH);
			add( expPanel , BorderLayout.CENTER);
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
					if ( tree.results[count_steps ] != null) 
					{
					//	exp_label[next_no].setText(my.results[next_no++]);
						count_steps ++ ;
						repaint();
						right_reason_panel.write_reasons();
					}
					else
					{
						start_flag = false ;
						option.setEnabled(true);
						start.setText("START");
						next.setEnabled(false);
						initialize.setEnabled(true);
						JOptionPane.showMessageDialog(null, "Expression Evaluation Complete!");
					}
				}	
			}
			else if ( e.getSource() == initialize )
			{
				if( (initialize.getText()).compareTo("Save") == 0 ){
					a.setEditable(false);
					b.setEditable(false);
					c.setEditable(false);
					d.setEditable(false);
					initialize.setText("Edit");
					start.setEnabled(true);
				}
				else {
					initialize.setText("Save");
					a.setEditable(true);
					b.setEditable(true);
					c.setEditable(true);
					d.setEditable(true);
					start.setEnabled(false);
				}

			}
			else if ( e.getSource() == start )
			{
				if( start_flag == true ){
					next.setEnabled(false);
					start_flag = false;
					start.setText("START");
					initialize.setEnabled(true);
					option.setEnabled(true);
				}
				else{
					option.setEnabled(false);
					next.setEnabled(true);
					start.setText("STOP");
					initialize.setEnabled(false);
					String input_str = exp_selected.getText();
					tree = new loginfix(input_str, a.getText()+":"+ b.getText()+":"+ c.getText()+":"+ d.getText());
					if ( tree != null && tree.results != null ) // for wrong expression (Error Check )
					{
						start_flag = true ;
						count_steps = 0 ;
						repaint();
						right_reason_panel.repaint();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "You entered wrong expression :(");
					}
				}
				
			}
			else if ( e.getSource() ==  exp_type)
			{
				JComboBox cb = (JComboBox)e.getSource();
				if ( cb != null )
				{
					String s = (String)cb.getSelectedItem();
					if(s.compareTo("Arithematic")==0){
						URL base, url=null;
						try{
							base = getCodeBase();
							url = new URL(base ,"../arithmatic/operator.php");
							getAppletContext().showDocument(url , "_self");
						}
						catch(MalformedURLException f){
							System.out.println("Invalid URL "+url+": "+f.getMessage());
						}
					}
					if(s.compareTo("Bitwise")==0){
						URL base, url=null;
						try{
							base = getCodeBase();
							url = new URL(base ,"../bitwise/bitoperator.php");
							getAppletContext().showDocument(url , "_self");
						}
						catch(MalformedURLException f){
							System.out.println("Invalid URL "+url+": "+f.getMessage());
						}
					}
				}
			}
			else if ( e.getSource() ==  option)
			{
				JComboBox cb = (JComboBox)e.getSource();
				if ( cb != null )
				{
					exp_selected.setText((String)cb.getSelectedItem());
					String s = (String)cb.getSelectedItem();
				}
			}	
/*				JComboBox cb = (JComboBox)e.getSource();
				exp_selected.setText((String)cb.getSelectedItem());
				String s = (String)cb.getSelectedItem();
				loginfix my = new loginfix(s);
				next_no = 0 ;
*/			//	System.out.println(my.results[0]);
		//	}
		}
	}
}
