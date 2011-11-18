/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arrayprog;

/**
 *
 * @author abhiramj
 */


import java.util.Arrays;

public class coderunner {

	int i,j;
	int size,key;
        int A[];
	int[] loopStart;
	int[] loopEnd;
	int[] ifStmtStart;
	int[] ifStmtEnd;
	int[] returns;
	int select;
        int keypos=-1;
	boolean forinit=false;
	int currindex=0;
	StringBuffer comments;
	coderunner(int s ,int B[], int size)
	{
		this.comments = new StringBuffer();
		this.select = s;
	    this.loopStart = new int[5];
		this.loopEnd = new int[5];
		this.ifStmtStart = new int[5];
		this.ifStmtEnd = new int[5];
		this.returns = new int[5];
                this.size=size;
                A  = new int[this.size];

                for(int m=0;m<size;m++){

               
                A[m]=B[m];

                }
		// Initialize all loop Start,end Indexes and conditionals start and end
		//Also return statements, if does not exist return 1
	switch (this.select){
	case 0:
		loopStart[0]=2;
		loopEnd[0]=12;
                loopStart[1]=6;
                loopEnd[1]=10;
		returns[0]=13;
		Arrays.fill(loopStart,2,5,-1);
		Arrays.fill(loopEnd,2,5,-1);
		Arrays.fill(ifStmtStart,0,5,-1);
		Arrays.fill(ifStmtStart,0,5,-1);
		Arrays.fill(returns,1,5,-1);
        	break;
//	case 1:
//		loopStart[0]=8;
//		loopEnd[0]=12;
//		ifStmtStart[0]=4;
//		ifStmtEnd[0]=7;
//		returns[0]=6;
//		returns[1]=13;
//		Arrays.fill(loopStart,1,5,-1);
//		Arrays.fill(loopEnd,1,5,-1);
//		Arrays.fill(ifStmtStart,1,5,-1);
//		Arrays.fill(ifStmtStart,1,5,-1);
//		Arrays.fill(returns,2,5,-1);
//		break;
//	case 2:
//		loopStart[0]=8;
//		loopEnd[0]=12;
//		ifStmtStart[0]=4;
//		ifStmtEnd[0]=7;
//		returns[0]=6;
//		returns[1]=13;
//		Arrays.fill(loopStart,1,5,-1);
//		Arrays.fill(loopEnd,1,5,-1);
//		Arrays.fill(ifStmtStart,1,5,-1);
//		Arrays.fill(ifStmtStart,1,5,-1);
//		Arrays.fill(returns,2,5,-1);
//		break;
 	}
	}
	public void detVars(int index, int select){
		// This determines all the values at any particular point
		//At critical points comments are posted
		switch(select){
		case 0:
			if (index==loopEnd[0]){
				this.i++;
				comments.replace(0, 100, "In for loop,counter decrement/increment is at end of loop");
				}
			if (index ==4){
				key=A[i];
                                keypos=i;
			}
                        if (index ==5){
				j=i-1;
			}
			if (index == 2){
				if (forinit==false){
					i=1;
					comments.replace(0, 100, "In for loop,counter initialization is at beginning of 1st iteration of loop");
                                        forinit=true;
				}
				
				}

			if (index == 8){
				A[j+1]=A[j];
			}
                        if (index == 9){
				j--;
			}
                        if (index==11)
                        {A[j+1]=key;
                        }
			break;
//		case 1:
//			if (index==loopEnd[0]-1){
//				this.i--;
//				}
//			if (index ==3){
//				fact=1;
//			}
//			if (index == 2){
//				i=p;
//			}
//			if (index == 10){
//				fact=fact*i;
//			}
//			break;
//		case 2:
//			if (index==loopEnd[0]-1){
//				this.i--;
//				}
//			if (index ==3){
//				fact=1;
//			}
//			if (index == 2){
//				i=p;
//			}
//			if (index == 10){
//				fact=fact*i;
//			}
//			break;
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
                                    keypos=keypos+1;
					return -1;
				}

			}
			// loop condition checking, if false jump to end

			
				if (loopStart[0]==index && i>=size)
				{
					comments.replace(0, 100, "Checking loop condition,returns false");
					return (loopEnd[0]+1);
				}

                                if (j<0 && loopStart[1]==index){
                                    return (loopEnd[1]+1);
                                }
                                if (loopStart[1]==index && A[j]<=key)
				{
					comments.replace(0, 100, "Checking loop condition,returns false");
					return (loopEnd[1]+1);
				}
                                
                                
		
			// Jumping to start of loop while at end

			for (int l=0; l<loopEnd.length;l++){
				if (loopEnd[l]==index)
				{
                                        System.out.println("\n In loop at index"+ index + "with loopStart" + loopStart[l]);
					return (loopStart[l]);
				}
		}
			// If statement condition,if returns false jump to end of loop
//			for (int l=0; l<ifStmtStart.length;l++){
//				if (ifStmtStart[l]==index && this.p!=0)
//				{
//					comments.replace(0, 100, "Checking if condition,returns false");
//					return (ifStmtEnd[l]);
//				}
//		}
			// No instruction jump, so go to next instruction
			return ++index;

	}
	public void setVars(int size){
		// Initialize all the variables here
		this.size = size;

		//this.i=i;
	}

}
