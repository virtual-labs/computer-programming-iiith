
class node {
	int val;
	char op;
	int in;
	node left;
	node right;
	node(int n, char p){
		val = n;
		op = p;
		in = -1;
	}
}


public  class infix {
	node root;
	int a,b,c,d;
	public String[] results;
	public String[] offsets;
	public String[] reasons;
	char[] temp;
	int tempc;
	int res;
	int state;
	public infix(String input, String vars){
		root = null;
		results = new String[50];
		offsets = new String[50];
		reasons = new String[50];
		res = 0;
		String[] temp = vars.split(":");
		String[] input_final = new String[100];
		int inf = 0;
		a = Integer.parseInt(temp[0]);
		b = Integer.parseInt(temp[1]);
		c = Integer.parseInt(temp[2]);
		d = Integer.parseInt(temp[3]);
		System.out.println(a+" " + b+" "+c+" " +d);
		for( int i=0 ; i<input.length() ; i++ ){
			char cur = input.charAt(i);
			if(Character.isLetter(cur)){
				switch(cur){
					case 'a': input_final[inf++] = new String(Integer.toString(a));
						  break;
					case 'b': input_final[inf++] = new String(Integer.toString(b));
						  break;
					case 'c': input_final[inf++] = new String(Integer.toString(c));
						  break;
					case 'd': input_final[inf++] = new String(Integer.toString(d));
						  break;
					default: break;
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
		System.out.println(current.op +"(" + current.val + ")");
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
				reasons[res] = "'" + oper  + "' operator has preference over others...";
			}
			else if(current.in == 5){
				reasons[res] = "the bracket here has the highest precedence";
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
				if(!Character.isDigit(fexp[i].charAt(0)) && (fexp[i].length()==1)){
					int tmp=0;
					int num1 = Integer.parseInt(fexp[i-1]);
					int num2 = Integer.parseInt(fexp[i-2]);
					char[] strin = new char[50];
					switch(fexp[i].charAt(0)){
						case '+': tmp = num2 + num1;
							  break;
						case '-': tmp = num2 - num1;
							  break;
						case '*': tmp = num2 * num1;
							  break;
						case '/': tmp = num2 / num1;
							  break;
						case '%': tmp = num2 % num1;
							  break;
						default : break;
					}
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
		for( i = 0 ;  i < f ; i++ ){
			cur = fexpr[i].charAt(0);
			if( Character.isDigit(cur) || fexpr[i].length()>1 ){
				stack[s++] = new node(Integer.parseInt(fexpr[i]),'g');
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
					
				temp1 = new node(num,cur);
				if(cur == '*' || cur == '/' || cur == '%'){
					if(stack[s-2].op == '+' || stack[s-2].op == '-'){
						stack[s-2] = insertleft(stack[s-2]);
						stack[s-2] = insertright(stack[s-2]);
						stack[s-2].in=5;
						if ( state == 0 )
							state = 5;
						
					}
					if(stack[s-1].op!='g'){
						stack[s-1] = insertleft(stack[s-1]);
						stack[s-1] = insertright(stack[s-1]);
						stack[s-1].in=5;
						if ( state == 0 )
							state = 5;
						
					}
				}
				if(cur == '+' || cur == '-'){
					if(stack[s-1].op == '+' || stack[s-1].op == '-'){
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
		infix tree = new infix("a * c +(a-d)* b/c *d","1:3:4:6");
	}

}

