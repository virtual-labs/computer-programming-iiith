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
		String str[] = {"a || b && c","a || ( b && c )","a && b || c && d","a && ( b || c ) && d"  };
		String val[] = {"2","5","10","11"};
		String str_data_type[] = {"Integer" };
		String str_exp_type[] = {"Logical","Arithematic" ,  "Bitwise" };

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

	//	infix my = null ;
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
				f1 = new Font("Arial",Font.BOLD,20);
				f2 = new Font("Arial",Font.ITALIC , 20);
				f3 = new Font("Arial",Font.ITALIC , 15);
			}
			public void paint( Graphics g )
			{
				System.out.println("I am in paint ");

				g.setFont(f1);
				g.setColor(Color.lightGray);
				g.fillRect(0 , 0 , 1000 , 50 );
				g.setColor(Color.black);
				g.drawString("EVALUATION FLOW OF EXPRESSION:-" , 120 , 30 );

				g.setColor(Color.red);
				g.drawString(tree.results[0] ,100 ,  80  );
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
						g.drawString( tree.results[i] ,100 ,80 +40*(i+1) );
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
					g.drawString( str1 ,100 ,80 +40*(i+1) );
					g.setColor(Color.blue);
					g.setFont(f2);
					g.drawString( str2 ,100 + 10*str1.length() ,80+40*(i+1) );
					g.setColor(Color.red);
					g.setFont(f1);
					g.drawString( str3 ,100 + 10*(str1.length()+str2.length()) , 80 +40*(i+1) );
					}
				}
			}
		}
		public class myReasonPanel extends JPanel 
		{
			Font f1 , f2;
			public myReasonPanel ()
			{
				JPanel panel =  new JPanel();
				f1 = new Font("Arial",Font.ITALIC , 15);
				f2 = new Font("Arial",Font.BOLD , 15);
			}
			public void paint(Graphics g )
			{

				g.setFont(f2);
				g.setColor(Color.blue);
				g.drawString("Here variables are replaced by their values ." , 10 , 40);
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

					head = new JLabel ("<html><FONT size=8><b>Experiment On Operators :-</b></size></html>");
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
					top_menu.add(go);	

				topPanel.setLayout(new BorderLayout());
				topPanel.add(top_head , BorderLayout.NORTH);
				topPanel.add(top_menu , BorderLayout.SOUTH);


			rightPanel = new JPanel();
				rightPanel.setLayout( new BorderLayout());
				rightPanel.setBorder(BorderFactory.createLoweredBevelBorder());

				right_head = new JPanel();
					right_head.setBackground(Color.lightGray);
					right_head.setBorder(BorderFactory.createRaisedBevelBorder());
					selected1 = new JLabel("<html><font size=6>STEP BY STEP REASONING </font></html>");
					right_head.add(selected1);

				right_reason_panel = new myReasonPanel();

				next = new JButton("NEXT");
				next.addActionListener(this);

				rightPanel.add(right_head , BorderLayout.NORTH );
				rightPanel.add(right_reason_panel , BorderLayout.CENTER );
				rightPanel.add(next , BorderLayout.SOUTH );


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
						initialize = new JButton("Go");

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
						left_top2.add(new JLabel(" "));
						left_top2.add(initialize);
						left_top2.add(new JLabel(" "));
						left_top2.add(new JLabel(" "));
						left_top2.add(new JLabel(" "));
						left_top2.add(new JLabel(" "));


					left_top.add(left_top1 , BorderLayout.NORTH);
					left_top.add(new JLabel(" ") , BorderLayout.CENTER);
					left_top.add(left_top2 , BorderLayout.SOUTH);

				left_bottom = new JPanel();
					left_bottom.setBorder(BorderFactory.createRaisedBevelBorder());
					left_bottom.setLayout(new BoxLayout( left_bottom , BoxLayout.PAGE_AXIS));
					
					JPanel left_head_panel = new JPanel();
						JLabel left_head = new JLabel("<html><b>SELECT THE EXPRESSION</b></html>");
						left_head.setAlignmentX(Component.CENTER_ALIGNMENT);
						left_head_panel.add(left_head);
						left_head_panel.setBackground(Color.gray);

					exp_selected = new JTextField (str[0]);
					exp_selected.setAlignmentX(Component.CENTER_ALIGNMENT);
					exp_selected.setBorder(BorderFactory.createLoweredBevelBorder());
		
					option = new JComboBox(str);
					option.addActionListener(this);
					option.setSelectedIndex(0);
					option.setBorder(BorderFactory.createTitledBorder("Expressions"));
	
					start = new JButton("START");
					start.addActionListener(this);

					JPanel left_bottom_current = new JPanel ();
						left_bottom_current.setBackground(Color.lightGray);
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

	
					left_bottom.add(left_head_panel );
					left_bottom.add(Box.createRigidArea(new Dimension (1 , 10)));
					left_bottom.add(option);
					//left_bottom.add(Box.createRigidArea(new Dimension (1 ,  10)));
					//left_bottom.add(exp_selected );
					left_bottom.add(Box.createRigidArea(new Dimension (0 ,  15)));
					left_bottom.add(start);
					left_bottom.add(Box.createRigidArea(new Dimension (0 , 20 )));
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
						right_reason_panel.repaint();
					}
					else
					{
						start_flag = false ;
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Expression id Done :)");
				}	
			}
			else if ( e.getSource() == initialize )
			{
				if ( start_flag == false )
				{
					current_a.setText(a.getText());
					current_b.setText(b.getText());
					current_c.setText(c.getText());
					current_d.setText(d.getText());
				}
			}
			else if ( e.getSource() == start )
			{
				String input_str = exp_selected.getText();
				tree = new loginfix(input_str, current_a.getText()+":"+ current_b.getText()+":"+ current_c.getText()+":"+ current_d.getText());
				System.out.println("option");
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
			else if ( e.getSource() ==  exp_type)
			{
				JComboBox cb = (JComboBox)e.getSource();
				if ( cb != null )
				{
					exp_selected.setText((String)cb.getSelectedItem());
					String s = (String)cb.getSelectedItem();
					System.out.println(s+"!!!!!!");
					if(s.compareTo("Logical")==0){
						URL base, url=null;
						try{
							System.out.println("sjfsalk");
							base = getCodeBase();
							url = new URL(base ,"operator.php");
							getAppletContext().showDocument(url , "_self");
						}
						catch(MalformedURLException f){
							System.out.println("Invalid URL "+url+": "+f.getMessage());
						}
					}
				}
			}
/*				JComboBox cb = (JComboBox)e.getSource();
				exp_selected.setText((String)cb.getSelectedItem());
				String s = (String)cb.getSelectedItem();
				infix my = new infix(s);
				next_no = 0 ;
*/			//	System.out.println(my.results[0]);
		//	}
		}
	}
}
