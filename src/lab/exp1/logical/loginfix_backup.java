
class node {
	int val;
	String op;
	int in;
	node left;
	node right;
	node(int n, String p){
		val = n;
		op = new String(p);
		in = -1;
	}
}


public  class loginfix {
	node root;
	int a,b,c,d;
	public String[] results;
	public String[] offsets;
	public String[] reasons;
	char[] temp;
	int tempc;
	int res;
	int state;
	public loginfix(String input, String vars){
		root = null;
		results = new String[50];
		offsets = new String[50];
		reasons = new String[50];
		res = 0;
		String[] temp = vars.split(":");
		String[] input_final = input.split(" ");
		int inf = 0;
		a = Integer.parseInt(temp[0]);
		b = Integer.parseInt(temp[1]);
		c = Integer.parseInt(temp[2]);
		d = Integer.parseInt(temp[3]);
		System.out.println(a+" " + b+" "+c+" " +d);
		for( int i=0 ; i<input_final.length ; i++ ){
			char cur = input_final[i].charAt(0);
			if(Character.isLetter(cur)){
				switch(cur){
					case 'a': input_final[i] = new String(Integer.toString(a));
						  break;
					case 'b': input_final[i] = new String(Integer.toString(b));
						  break;
					case 'c': input_final[i] = new String(Integer.toString(c));
						  break;
					case 'd': input_final[i] = new String(Integer.toString(d));
						  break;
					default: break;
				}
			}
			System.out.println(input_final[i]);
		}
				
		passinfix(input_final,input_final.length);
	}
	public node insertleft(node current){
		if(current == null){
			current = new node(0,"(");
			current.left = null;
			current.right = null;
			return current;
		}
		current.left=insertleft(current.left);
		return current;
	}
	public node insertright(node current){
		if(current == null){
			current = new node(0,")");
			current.left = null;
			current.right = null;
			return current;
		}
		current.right=insertright(current.right);
		return current;
	}
		
	public void print(node current, int d){
		if(current ==  null)
			return;
		print(current.left,d+1);
		for(int i=0 ; i < d; i++)
			System.out.print("\t");
		System.out.println(current.op +"(" + current.val + ")");
		print(current.right,d+1);
	}
	public void print_infix(node current){
		if(current ==  null)
			return;
		 String oper = new String(current.op);
		print_infix(current.left);
		if( current.op.compareTo("g")!=0 ) {
//			System.out.print(oper );
			results[res] = results[res].concat(oper);
			results[res] = results[res].concat(" ");
			if(current.in == 0){
				reasons[res] = "'" + oper  + "' operator has preference over others...";
			}
			else if(current.in == 5){
				reasons[res] = "the bracket has the highest precedence";
			}
		
		}
		else{ 
//			System.out.print(current.val );
			if(results[res] == null){
				results[res] = new String("[");
			}
			if(current.in == 2){
				if(offsets[res] == null)
					offsets[res] = new String();
				offsets[res] = offsets[res].concat(Integer.toString(results[res].length())+":");
			}
			results[res] = results[res].concat(Integer.toString(current.val));
			if(current.in == 1){
				 offsets[res] = offsets[res].concat(Integer.toString(results[res].length()) );
			}
			results[res] = results[res].concat(" ");
	
		}
		print_infix(current.right);
		
	}
	public void passinfix(String[] exparr,int inf){
		int i;
		String[] stack = new String[50];
		String[] fexp  = new String[100];
		int f=0,s=0;
		for( i=0 ; i<inf; i++ ){
			char cur = exparr[i].charAt(0);
			if(Character.isDigit(cur) || cur=='-'){
				fexp[f++] = new String(exparr[i]);
			}
			else if (exparr[i].compareTo("||")==0){
				if(s==0)
					stack[s++] = new String(exparr[i]);
				else if( stack[s-1].compareTo("&&")==0 || stack[s-1].compareTo("||")==0 )
					fexp[f++] = new String(stack[s-1]);
					stack[s-1] = new String(exparr[i]);
				}
				else 
					stack[s++] = new String(exparr[i]);

			}
			else if (cur == ')'){
				while(s-1 > 0 && stack[s-1].compareTo("(")!=0 ){
					fexp[f++] = new String(stack[s-1]);
					s--;
				}
				s--;
			}
			else{
				if( s-1>=0 && ( stack[s-1].compareTo("&&")==0 ) && (cur != '(') ){
					fexp[f++] = new String(stack[s-1]);
					stack[s-1] = new String(exparr[i]);
				}
				else{
					stack[s++] = new String(exparr[i]);
				}
			}
		}
		while(s>0){
			fexp[f++] = new String(stack[s-1]);
			s--;
		}
		

		posttotree(fexp,f);
		while(f>2){	
			for(i = 0 ; i < f ; i++){
				if( !Character.isDigit(fexp[i].charAt(0)) && (fexp[i].charAt(0)!='-') ){
					int tmp=0;
					boolean btmp=false;
					int num1 = Integer.parseInt(fexp[i-1]);
					int num2 = Integer.parseInt(fexp[i-2]);
					char[] strin = new char[50];

				  	/*for logical operators */
					boolean b1=false, b2=false;
					if(num1==0)
						b1=false;
					else
						b1=true;
					if(num2==0)
						b2=false;
					else
						b2=true;	
					if( fexp[i].compareTo("&&") == 0 ){
						btmp = b2 && b1;
					}
					else if( fexp[i].compareTo("||") == 0 ){
						btmp = b2 || b1;
					}
					if(btmp == true)
						tmp=1;
					else
						tmp=0;
					/*------------X-----------*/
					
					/*for bitwise operators */
					if( fexp[i].compareTo("&")==0 ){
						tmp = num2 & num1;
					}
					else if( fexp[i].compareTo("|")==0 ){
						tmp = num2 | num1;
					}
					else if( fexp[i].compareTo("^")==0 ){
						tmp = num2 ^ num1;
					}
					else if( fexp[i].compareTo("<<")==0 ){
						tmp = num2 << num1;
					}
					else if( fexp[i].compareTo(">>")==0 ){
						tmp = num2 >> num1;
					}
					/*-----------X-----------*/

					fexp[i-2] = new String(Integer.toString(tmp));
					f-=2;
					i-=1;
					while(i<f){
						fexp[i] = new String(fexp[i+2]);
						i++;
					}
					
			/*		for(i = 0; i < f ; i++ ){
						System.out.print(fexp[i]);
					}
					System.out.println();
			*/
					posttotree(fexp,f);
					break;
				}
			}
		}

		for( i = 0 ; i < res ; i++ ){
			String[] tempstr = new String[5];
			tempstr =  offsets[i].split(":");
			System.out.print(results[i]);
			if(offsets[i].length()>1)
				System.out.println( tempstr[0]+","+tempstr[1]);
			System.out.println(reasons[i]);

		}

	}
	public node posttotree(String[] fexpr,int f){
		int i;
		char cur;
		node[] stack = new node[30];
		temp = new char[100];
		node temp1;
		int index = 0;
		int s = 0;
		int num = 0;
		int state = 0;
		boolean btmp=false;
		for( i = 0 ;  i < f ; i++ ){
			cur = fexpr[i].charAt(0);
			if( Character.isDigit(cur) ||  cur=='-' ){
				stack[s++] = new node(Integer.parseInt(fexpr[i]),"g");
			}
			else if(s-2 >= 0){
				int num1=stack[s-1].val;
				int num2=stack[s-2].val;
				/*for logical operators */
				boolean b1=false, b2=false;
				if(stack[s-1].val==0)
					b1=false;
				else
					b1=true;
				if(stack[s-2].val==0)
					b2=false;
				else
					b2=true;	

				if( fexpr[i].compareTo("&&") == 0 ){
					btmp = b2 && b1;
				}
				else if( fexpr[i].compareTo("||") == 0 ){
					btmp = b2 || b1;
				}
				if(btmp == true)
					num=1;
				else
					num=0;
				/*-----------X-----------*/

				/*for bitwise operators */
				if( fexp[i].compareTo("&")==0 ){
					num = num2 & num1;
				}
				else if( fexp[i].compareTo("|")==0 ){
					num = num2 | num1;
				}
				else if( fexp[i].compareTo("^")==0 ){
					num = num2 ^ num1;
				}
				else if( fexp[i].compareTo("<<")==0 ){
					num = num2 << num1;
				}
				else if( fexp[i].compareTo(">>")==0 ){
					num = num2 >> num1;
				}
				/*-----------X-----------*/

				temp1 = new node(num,fexpr[i]);
				if(fexpr[i].compareTo("&&")==0){
					if(stack[s-2].op.compareTo("||") == 0){
						stack[s-2] = insertleft(stack[s-2]);
						stack[s-2] = insertright(stack[s-2]);
						stack[s-2].in=5;
						if ( state == 0 )
							state = 5;
						
					}
					if(stack[s-1].op.compareTo("g")!=0){
						stack[s-1] = insertleft(stack[s-1]);
						stack[s-1] = insertright(stack[s-1]);
						stack[s-1].in=5;
						if ( state == 0 )
							state = 5;
						
					}
				}
				if(fexpr[i].compareTo("||")==0){
					if( stack[s-1].op.compareTo("||")==0 ){
						stack[s-1] = insertleft(stack[s-1]);
						stack[s-1] = insertright(stack[s-1]);
						if ( state == 0 )
							state = 5;
						
					}
				}
						
				if(state == 0 || state==5){
					stack[s-2].in=2;
					stack[s-1].in=1;
					if(state !=5)
						temp1.in = 0;
					else
						temp1.in = 5;
					state=1;
				}
					
				temp1.left = stack[s-2];
				temp1.right = stack[s-1];
				stack[s-2] = temp1;
				s--;
			}
		}
//		print(stack[0],0);
		results[res] = new String("[ ");
		offsets[res] = new String("");
		reasons[res] = new String();
		print_infix(stack[0]);
		results[res] = results[res].concat("]\n");
		res++;
		return stack[0];
	}

	public  static void main(String[] args){
		loginfix tree = new loginfix("a && b || c && d","1:3:4:6");
	}

}

