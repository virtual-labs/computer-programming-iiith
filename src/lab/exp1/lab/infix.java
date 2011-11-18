

class node {
	float val;
	char op;
	int in;
	node left;
	node right;
	node(float n, char p){
		val = n;
		op = p;
		in = -1;
	}
}


public  class infix {
	node root;
	int a,b,c,d;
	float a1,b1,c1,d1;
	public String[] results;
	public String[] offsets;
	public String[] reasons;
	public String[] operations;
	char[] temp;
	int tempc;
	int res;
	int state;
	int dtype;
	public infix(String input, String vars,int dtyp){
		root = null;
		results = new String[50];
		offsets = new String[50];
		reasons = new String[50];
		operations = new String[50];
		dtype = dtyp;
		res = 0;
		String[] temp = vars.split(":");
		String[] input_final = new String[100];
		int inf = 0;
		a1 = Float.valueOf(temp[0]);
		b1 = Float.valueOf(temp[1]);
		c1 = Float.valueOf(temp[2]);
		d1 = Float.valueOf(temp[3]);
		a = (int)a1;
		b = (int)b1;
		c = (int)c1;
		d = (int)d1;
		//System.out.println(a+" " + b+" "+c+" " +d);
		for( int i=0 ; i<input.length() ; i++ ){
			char cur = input.charAt(i);
			if(Character.isLetter(cur)){
				if(dtype == 1){
					switch(cur){
						case 'a': input_final[inf++] = String.valueOf(a);
							  break;
						case 'b': input_final[inf++] = String.valueOf(b);
							  break;
						case 'c': input_final[inf++] = new String(Integer.toString(c));
							  break;
						case 'd': input_final[inf++] = new String(Integer.toString(d));
							  break;
						default: break;
					}
				}
				else{
					switch(cur){
						case 'a': input_final[inf++] = String.valueOf(a1);
							  break;
						case 'b': input_final[inf++] = new String(Float.toString(b1));
							  break;
						case 'c': input_final[inf++] = new String(Float.toString(c1));
							  break;
						case 'd': input_final[inf++] = new String(Float.toString(d1));
							  break;
						default: break;
					}
				}
			}
			else if( cur != ' '){
				input_final[inf++] = new String(Character.toString(cur));
			}
		}
				
		passinfix(input_final,inf);
	}
	public node insertleft(node current){
		if(current == null){
			current = new node(0,'(');
			current.left = null;
			current.right = null;
			return current;
		}
		current.left=insertleft(current.left);
		return current;
	}
	public node insertright(node current){
		if(current == null){
			current = new node(0,')');
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
		System.out.println(current.op +"(" + current.val + ", in=" + current.in + ")" );
		print(current.right,d+1);
	}
	public void print_infix(node current){
		if(current ==  null)
			return;
		char oper = current.op;
		print_infix(current.left);
		if(current.op != 'g'){
//			System.out.print(oper );
			if(current.in == 2){
				if(offsets[res] == null)
					offsets[res] = new String();
				offsets[res] = offsets[res].concat(Integer.toString(results[res].length())+":");
			}
			results[res] = results[res].concat(Character.toString(oper));
			results[res] = results[res].concat(" ");
			if(current.in == 0){
				reasons[res] = "'" + oper  + "' operator has higher preference according to the precedence order of operators and then following left  to right rule.";
			}
			else if(current.in == 5){
				reasons[res] = "The bracket here is preferred over other operators. Hence the '"+oper+"' operator inside the brackets is evaluated first.";
			}
			else if(current.in == 10){
				if(reasons[res].length() != 0){
					char ch = reasons[res].charAt(1);
					if(ch != 'h'){
						if(res > 0 && (reasons[res-1].charAt(0) == 'C' || reasons[res-1].charAt(0) == 'S'))
							reasons[res] = "Similar reasoning can be given for this step too.\n  Hence, '"+ch+"' operation is evaluated here.";
						else
							reasons[res] = "Compiler evaluates the expression in Left-Right \n  manner. In that case, if the operation on left doesn't \n  affect the bracket, it is evaluated first. So, here '"+ch+"' \n  operation is evaluated instead of the bracket.";
					
					}
				}
			}
			
			
			if(current.in == 1){
				 offsets[res] = offsets[res].concat(Integer.toString(results[res].length()) );
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
			if(dtype == 1){
				results[res] = results[res].concat(String.valueOf((int)current.val));
			}
			else
				results[res] = results[res].concat(String.valueOf(current.val));
			if(current.in == 1){
				 offsets[res] = offsets[res].concat(Integer.toString(results[res].length()) );
			}
			results[res] = results[res].concat(" ");
	
		}
		print_infix(current.right);
		
	}
	public void passinfix(String[] exparr,int inf){
		int i;
		char[] stack = new char[50];
		String[] fexp  = new String[100];
		int f=0,s=0;
		for( i=0 ; i<inf; i++ ){
			char cur = exparr[i].charAt(0);
			if(Character.isDigit(cur) || exparr[i].length()>1){
				fexp[f++] = new String(exparr[i]);
			}
			else if (cur == '+' || cur == '-'){
				if(s==0)
					stack[s++] = cur;
				else if( stack[s-1] == '*' || stack[s-1] == '/' || stack[s-1]=='%' || stack[s-1] == '+' || stack[s-1] == '-'){
					fexp[f++] = new String(Character.toString(stack[s-1]));
					stack[s-1] = cur;
				}
				else 
					stack[s++] = cur;

			}
			else if (cur == ')'){
				while(s-1 > 0 && stack[s-1] != '('){
					fexp[f++] = new String(Character.toString(stack[s-1]));
					s--;
				}
				s--;
			}
			else{
				if( s-1>=0 && (stack[s-1] == '*' || stack[s-1] == '/' || stack[s-1] == '%') && (cur != '(') ){
					fexp[f++] = new String(Character.toString(stack[s-1]));
					stack[s-1] = cur;
				}
				else{
					stack[s++] = cur;
				}
			}
		}
		while(s>0){
			fexp[f++] = new String(Character.toString(stack[s-1]));
			s--;
		}
		

		posttotree(fexp,f);
		while(f>2){	
			for(i = 0 ; i < f ; i++){
				float tmp,num1,num2;
				if(!Character.isDigit(fexp[i].charAt(0)) && (fexp[i].length()==1)){
					if(dtype == 1){
						tmp=0;
						num1 = Integer.parseInt(fexp[i-1]);
						num2 = Integer.parseInt(fexp[i-2]);
					}
					else{
						tmp=0;
						num1 = Float.parseFloat(fexp[i-1]);
						num2 = Float.parseFloat(fexp[i-2]);
					}
					char[] strin = new char[50];
					switch(fexp[i].charAt(0)){
						case '+': tmp = num2 + num1;
							  break;
						case '-': tmp = num2 - num1;
							  break;
						case '*': tmp = num2 * num1;
							  break;
						case '/': if(num1 == 0){
								this.results = null;
								return;	
							  }
							  tmp = num2 / num1;
							  break;
						case '%': tmp = num2 % num1;
							  break;
						default : break;
					}
					if(dtype == 1)
						fexp[i-2] = new String(String.valueOf((int)tmp));
					else
						fexp[i-2] = new String(String.valueOf(tmp));
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
		node temp1,first;
		int index = 0;
		int s = 0;
		float num = 0;
		state = 0;
		operations[res] = new String("");
		for( i = 0 ;  i < f ; i++ ){
			cur = fexpr[i].charAt(0);
			if( Character.isDigit(cur) || fexpr[i].length()>1 ){
				if(dtype == 1)
					stack[s++] = new node((int)Float.parseFloat(fexpr[i]),'g');
				else
					stack[s++] = new node(Float.parseFloat(fexpr[i]),'g');
			}
			else if(s-2 >= 0){
				switch(cur){
					case '+': num = stack[s-2].val + stack[s-1].val;
						  break;
					case '-': num = stack[s-2].val - stack[s-1].val;
						  break;
					case '*': num = stack[s-2].val * stack[s-1].val;
						  break;
					case '/': num = stack[s-2].val / stack[s-1].val;
						  break;
					case '%': num = stack[s-2].val % stack[s-1].val;
						  break;
					default : break;
				}
			 	if(dtype == 1)		
					temp1 = new node((int)num,cur);
				else
					temp1 = new node(num,cur);
				if(cur == '*' || cur == '/' || cur == '%'){
					if(stack[s-2].op == '+' || stack[s-2].op == '-'){
						stack[s-2] = insertleft(stack[s-2]);
						stack[s-2] = insertright(stack[s-2]);
						if ( state == 2 ){
							stack[s-2].in=5;
							state = 4;
						}
						else if( state == 3 ){
							stack[s-2].in=10;
							state = 5;
						}
						
					}
					if(stack[s-1].op!='g'){
						stack[s-1] = insertleft(stack[s-1]);
						stack[s-1] = insertright(stack[s-1]);
						if ( state == 2  ){
							stack[s-1].in=5;
							state = 4;
						}
						else if( state == 5 )
							stack[s-2].in = 5;
						else if( state == 3 ){
							stack[s-1].in=10;
							state = 5;
						}
						
					}
				}
				if(cur == '+' || cur == '-'){
					if(stack[s-1].op == '+' || stack[s-1].op == '-'){
						stack[s-1] = insertleft(stack[s-1]);
						stack[s-1] = insertright(stack[s-1]);
						if ( state == 2 ){
							stack[s-1].in=5;
							state = 4;
						}
						else if( state == 3 ){
							stack[s-1].in=10;
							state = 5;
						}
					}
				}
						
				if(state == 0 ){
					stack[s-2].in=2;
					stack[s-1].in=1;
					if(dtype == 1)
						operations[res] = operations[res].concat((int)stack[s-2].val + " " + cur + " " +(int)stack[s-1].val + " = " + (int)num + "\n" );	
					else
						operations[res] = operations[res].concat(stack[s-2].val + " " + cur + " " +stack[s-1].val + " = " + num + "\n" );	
					temp1.in = 0;
					state = 2;
				}
				else if(state == 2)
					state = 3;
					
				temp1.left = stack[s-2];
				temp1.right = stack[s-1];
				stack[s-2] = temp1;
				s--;
			}
		}
		//print(stack[0],0);
		results[res] = new String("[ ");
		offsets[res] = new String("");
		reasons[res] = new String();
		print_infix(stack[0]);
		results[res] = results[res].concat("]\n");
		res++;
		return stack[0];
	}

	public  static void main(String[] args){
		infix tree = new infix("a / b * d - c + a * ( d - a / c)","2:5:10:11",1);
	}

}

