/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arrayprog;
import java.util.Arrays;
/**
 *
 * @author abhiramj
 */
public class coderunner2 {
	int i,j,k;
	int p,q,r;
	int matA[][];
	int matB[][];
	int matMult[][];
	int[] loopStart;
	int[] loopEnd;
	int[] ifStmtStart;
	int[] ifStmtEnd;
	int[] returns;
	int select;
	boolean forinit1=false;
	boolean forinit2=false;
	boolean forinit3=false;
	int currindex=0;
   String comments;
	coderunner2 (int A[][],int B[][],int s1, int s2,int s3,int s)
	{
            System.out.println("entered");
		this.select = s;
	    this.loopStart = new int[5];
		this.loopEnd = new int[5];
		this.ifStmtStart = new int[5];
		this.ifStmtEnd = new int[5];
		this.returns = new int[5];

                this.i=s1;
		this.j=s2;
		this.k=s3;
		
                matA = new int [this.i][this.j];
                matB = new int [this.j][this.k];
		this.matMult = new int [this.i][this.k];
		for (int a=0;a<i;a++){
		for(int b=0;b<j;b++)
		{

			this.matA[a][b]=A[a][b];
                        System.out.println("matA inside is"+ this.matA[a][b]);
		}
		}
		for (int a=0;a<j;a++){
			for(int b=0;b<k;b++)
			{

				matB[a][b]=B[a][b];
			}
			}
		for (int a=0;a<i;a++){
			for(int b=0;b<k;b++)
			{

				matMult[a][b]=-1;
			}
			}
this.p=-1;
                this.q=-1;
                this.r=-1;

		//this.i=i;


	switch (this.select){
	case 0:
		loopStart[1]=8;
		loopStart[2]=11;
		loopStart[0]=6;
		loopEnd[0]=16;
		loopEnd[1]=15;
		loopEnd[2]=14;
		//ifStmtStart[0]=5;
		//ifStmtEnd[0]=8;
		returns[0]=17;
		Arrays.fill(loopStart,3,5,-1);
		Arrays.fill(loopEnd,3,5,-1);
		Arrays.fill(ifStmtStart,0,5,-1);
		Arrays.fill(ifStmtStart,0,5,-1);
		Arrays.fill(returns,1,5,-1);
		break;

	}
	}
	public void detVars(int index, int select){


		switch(select){
		case 0:
                    if (index==loopEnd[0]){
				this.p++;
                                forinit2=false;
				}
                    if (index==loopEnd[1]){
				this.r++;
                                forinit3=false;
				}
                       if (index==loopEnd[2]){
				this.q++;
				}
			if (index==10){
				matMult[p][r]=0;
				}
			if (index ==13){
				matMult[p][r]+=matA[p][q]*matB[q][r];
			}
			if (index == 6){
				if (forinit1==false){
					p=0;
				}
				forinit1=true;
				}
			if (index == 8){
				if (forinit2==false){
					r=0;
				}
				forinit2=true;
				}
			if (index == 11){
				if (forinit3==false){
					q=0;
				}
				forinit3=true;
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
		//System.out.println("I is"+i);
		//System.out.println("Fact is"+fact);
	}
	public int detnxtStmt(int index, int select) {
		// TODO Auto-generated method stub
		this.detVars(index,select);
		this.currindex=index;


			
				if (returns[0]==index)
				{
                                    //System.out.println(returns[l]);
					//System.out.println(l);
					//System.out.println(returns[l]);
					//System.out.println(index);
					return -1;
				}

			
			

					if (loopStart[0]==index  && p>=i)
					{

						return (loopEnd[0]+1);
					}
					else if (loopStart[1]==index  && r>=k)
					{

						return (loopEnd[1]+1);
					}

					else if (loopStart[2]==index  && q>=j)
					{

						return (loopEnd[2]+1);
					}


		
		
				if (loopEnd[0]==index)
				{

					return (loopStart[0]);
				}
                                if (loopEnd[1]==index)
				{

					return (loopStart[1]);
				}
                                if (loopEnd[2]==index)
				{

					return (loopStart[2]);
				}


		
//			for (int f=0; f<ifStmtStart.length;f++){
//				if (ifStmtStart[l]==index && j==k)
//				{
//					return (ifStmtEnd[l]);
//				}
//		}

			return ++index;

	}
	

}


