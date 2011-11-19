#include<stdio.h>
typedef struct S{
                int x;
                int y;
                }S;

S func(S A, S B)
                {
                  B.x=A.x;
                  B.y=B.y+A.y;
                  return B;
                }
                main()
                {
                S a,b;
                a.x=10;
                a.y=20;
                b.x=30;
                b.y=40;
                b=func(a,b);
                printf("%d %d\n",b.x,b.y);
                }       

