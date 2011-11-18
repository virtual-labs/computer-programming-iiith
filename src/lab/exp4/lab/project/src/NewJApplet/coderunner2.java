/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package NewJApplet;

/**
 *
 * @author abhiramj
 */
import java.util.Arrays;

public class coderunner2 {
	int height;
	int i,j;
        int k,l;
        int[] loopStart;
	int[] loopEnd;
	int[] ifStmtStart;
	int[] ifStmtEnd;
	int[] returns;
	int select;
        // Star true returns a star to be printed
        //boolean star=false;

	boolean forinit1=false;
        boolean forinit2=false;
        boolean forinit3=false;
        boolean forinit4=false;
	int currindex=0;
	StringBuffer comments;
	coderunner2(int s)
	{
		this.comments = new StringBuffer("");
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
		loopStart[0]=3;
		loopEnd[0]=19;
                loopStart[1]=5;
                loopEnd[1]=8;
                loopStart[2]=9;
                loopEnd[2]=13;
                loopStart[3]=14;
                loopEnd[3]=17;
                returns[0]=20;
		Arrays.fill(loopStart,4,5,-1);
		Arrays.fill(loopEnd,4,5,-1);
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
                                forinit2=false;
                                forinit3=false;
                                forinit4=false;
				comments.replace(0, 100, "In for loop,counter decrement/increment is at end of loop");
				}

			if (index==loopEnd[1]){
				this.j++;
				comments.replace(0, 100, "In for loop,counter decrement/increment is at end of loop");
				}

			if (index==loopEnd[2]){
				this.k++;
				comments.replace(0, 100, "In for loop,counter decrement/increment is at end of loop");
				}

			if (index==loopEnd[3]){
				this.l++;
				comments.replace(0, 100, "In for loop,counter decrement/increment is at end of loop");
				}
		
			if (index == 3){
				if (forinit1==false){
					i=0;
					comments.replace(0, 100, "In for loop,counter initialization is at beginning of 1st iteration of loop");
				}
				forinit1=true;
				}

			if (index == 5){
				if (forinit2==false){
					j=0;
					comments.replace(0, 100, "In for loop,counter initialization is at beginning of 1st iteration of loop");
				}
				forinit2=true;
				}

			if (index == 9){
				if (forinit3==false){
					k=j;
					comments.replace(0, 100, "In for loop,counter initialization is at beginning of 1st iteration of loop");
				}
				forinit3=true;
				}

			if (index == 14){
				if (forinit4==false){
					l=k;
					comments.replace(0, 100, "In for loop,counter initialization is at beginning of 1st iteration of loop");
				}
				forinit4=true;
				}
                   //     if (index==11){
                        //this.star=true;
                     //   }
                       // else this.star=false;

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
			for (int m=0; m<returns.length;m++){
				if (returns[m]==index)
				{
					return -1;
				}

			}

                // loop condition checking, if false jump to end

			//for (int m=0; m<loopStart.length;m++){
                  //          System.out.println("\nM is ............. "+ m);
				if (loopStart[0]==index && i>=height)
				{
					comments.replace(0, 100, "Checking loop condition,returns false");
                                        System.out.println("This loop is 1");
					return (loopEnd[0]+1);
				}
//                                System.out.println("*******"+this.height);
//                                System.out.println(i);
//                                System.out.println(j);
//                                System.out.println("*******"+index);
                                else if (loopStart[1]==index && j>=((this.height)-this.i-1))
				{
					comments.replace(0, 100, "Checking loop condition,returns false");
                                        System.out.println("This loop is 2");
					return (loopEnd[1]+1);
                                }
                                else if (loopStart[2]==index && k>=(this.height))
				{
					comments.replace(0, 100, "Checking loop condition,returns false");
                                        System.out.println("This loop is 3");
					return (loopEnd[2]+1);
				}
                                else if (loopStart[3]==index && this.l>=((2*this.height)-1))
				{
					comments.replace(0, 100, "Checking loop condition,returns false");
                                        System.out.println("This loop is 4");
					return (loopEnd[3]+1);
				}

		//}
			// Jumping to start of loop while at end
			for (int m=0; m<loopEnd.length;m++){
				if (loopEnd[m]==index)
				{

					return (loopStart[m]);
				}
		}
			// If statement condition,if returns false jump to end of condition
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
	public void setVars(int p){
		// Initialize all the variables here
		this.height=p;

		//this.i=i;
	}

}
