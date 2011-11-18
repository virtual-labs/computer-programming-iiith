package NewJApplet;

import java.util.Arrays;

public class coderunner {
	int p=0;
	int i=1;
	int fact=1;
	int[] loopStart;
	int[] loopEnd;
	int[] ifStmtStart;
	int[] ifStmtEnd;
	int[] returns;
	int select;
	boolean forinit=false;
	int currindex=0;
	StringBuffer comments;
	coderunner(int s)
	{
		this.comments = new StringBuffer();
		this.select = s;
	    this.loopStart = new int[5];
		this.loopEnd = new int[5];
		this.ifStmtStart = new int[5];
		this.ifStmtEnd = new int[5];
		this.returns = new int[5];
	
		// Initialize all loop Start,end Indexes and conditionals start and end
		//Also return statements, if does not exist return 1
	switch (this.select){
	case 0:
		loopStart[0]=7;
		loopEnd[0]=10;
		ifStmtStart[0]=3;
		ifStmtEnd[0]=6;
		returns[0]=5;
		returns[1]=11;
		Arrays.fill(loopStart,1,5,-1);
		Arrays.fill(loopEnd,1,5,-1);
		Arrays.fill(ifStmtStart,1,5,-1);
		Arrays.fill(ifStmtStart,1,5,-1);
		Arrays.fill(returns,2,5,-1);
		break;
	case 1:
		loopStart[0]=8;
		loopEnd[0]=12;
		ifStmtStart[0]=4;
		ifStmtEnd[0]=7;
		returns[0]=6;
		returns[1]=13;
		Arrays.fill(loopStart,1,5,-1);
		Arrays.fill(loopEnd,1,5,-1);
		Arrays.fill(ifStmtStart,1,5,-1);
		Arrays.fill(ifStmtStart,1,5,-1);
		Arrays.fill(returns,2,5,-1);
		break;
	case 2:
		loopStart[0]=8;
		loopEnd[0]=12;
		ifStmtStart[0]=4;
		ifStmtEnd[0]=7;
		returns[0]=6;
		returns[1]=13;
		Arrays.fill(loopStart,1,5,-1);
		Arrays.fill(loopEnd,1,5,-1);
		Arrays.fill(ifStmtStart,1,5,-1);
		Arrays.fill(ifStmtStart,1,5,-1);
		Arrays.fill(returns,2,5,-1);
		break;
	}
	}
	public void detVars(int index, int select){
		// This determines all the values at any particular point
		//At critical points comments are posted
		switch(select){
		case 0:
			if (index==loopEnd[0]){
				this.i--;
				comments.replace(0, 100, "In for loop,counter decrement/increment is at end of loop");
				}
			if (index ==2){
				fact=1;
			}
			if (index == 7){
				if (forinit==false){
					i=p;
					comments.replace(0, 100, "In for loop,counter initialization is at beginning of 1st iteration of loop");
				}
				forinit=true;
				}
			
			if (index == 9){
				fact=fact*i;
			}
			break;
		case 1:
			if (index==loopEnd[0]-1){
				this.i--;
				}
			if (index ==3){
				fact=1;
			}
			if (index == 2){
				i=p;
			}
			if (index == 10){
				fact=fact*i;
			}
			break;
		case 2:
			if (index==loopEnd[0]-1){
				this.i--;
				}
			if (index ==3){
				fact=1;
			}
			if (index == 2){
				i=p;
			}
			if (index == 10){
				fact=fact*i;
			}
			break;
		}
		
	}
	public int detnxtStmt(int index, int select) {
		// TODO Auto-generated method stub
		this.detVars(index,select);
		this.currindex=index;

		// return program finish on return
			for (int l=0; l<returns.length;l++){
				if (returns[l]==index)
				{
					return -1;
				}
				
			}
			// loop condition checking, if false jump to end
			
			for (int l=0; l<loopStart.length;l++){
				if (loopStart[l]==index && i<1)
				{
					comments.replace(0, 100, "Checking loop condition,returns false");
					return (loopEnd[l]+1);
				}
				
		}
			// Jumping to start of loop while at end
			for (int l=0; l<loopEnd.length;l++){
				if (loopEnd[l]==index)
				{
					
					return (loopStart[l]);
				}
		}
			// If statement condition,if returns false jump to end of loop
			for (int l=0; l<ifStmtStart.length;l++){
				if (ifStmtStart[l]==index && this.p!=0)
				{
					comments.replace(0, 100, "Checking if condition,returns false");
					return (ifStmtEnd[l]);
				}
		}
			// No instruction jump, so go to next instruction
			return ++index;
		
	}
	public void setVars(int p){
		// Initialize all the variables here
		this.p=p;
		
		//this.i=i;
	}
	
}
