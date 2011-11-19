#include<string.h>
#include<stdio.h>
#include<stdlib.h>
int  main()
{
char str[15]="abcd";
char str3[34]={'a','b','c','d'};
printf("len %d %d %d %d\n",strlen(str3),str3[3],str3[4],str3[5]);
char str2[4]="dd";
char *xx=(char *)malloc(100);
xx=strcat(str,str2);
printf("%s",str);
return 0;
}
