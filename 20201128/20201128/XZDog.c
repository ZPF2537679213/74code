#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<assert.h>
#include<stdlib.h>
#include<math.h>
#include<windows.h>
//有这样一群人，其他人都成双成对，唯独有一个单身狗，我们需要找到她。
int SerDog1(int *N,int len){
	assert(N!=NULL);
	if (len == 0)return 0;
	else return (*(N + len-1)) ^ SerDog1(N,len-1);
}
//有这样一群人，其他都成双成对，唯独她两没有对象，我们需要找到她两。
void SerDog2(int *N,int len){
	int m = 0;
	int x = 0, y = 0;
	for (int i = 0; i < len;++i){
		m = m^N[i];
	}
	m = m&(-m);
	for (int i = 0; i < len;++i){
		if ((m&N[i])==m){
			x = x^N[i];
		}
		else{
			y = y^N[i];
		}
	}
	printf("单身狗分别为：%d和%d\n",x,y);
}
//有这样一群人，三个为一组，但是有个人亮在那了，我们要找到他。
int SerP(int *N,int len){
	char *p = (char *)calloc(32,sizeof(char));
	int i, j,n;
	for (i = 0; i < len;++i){
		      n = N[i];
		for (j = 0; j < 32;++j){
			if (n & 1)p[j]++;
			n = n >> 1;
		}
	}
	for (i = 0,n=0; i < 32; ++i){
		int l = 0;
		if (p[i] % 3 != 0){
			l = 1;
		}
		n = n + l*(int)pow(2,i);
	}
	free(p);
	p = NULL;
	return n;
}
int main(){
	int num1[] = {1,1,3,4,3,4,8,7,8,7,10,11,10};
	int num2[] = { 1, 1, 3, 4, 3, 4, 8, 7, 8, 7, 10, 11, 10,13 };
	int num3[] = { 1, 1, 1,3,3, 4,3,4,4, 8,8,8, 7, 10, 10, 10 };
	printf("%d\n", SerDog1(num1,13));
	SerDog2(num2, 14);
	printf("%d\n", SerP(num3, 16));
	system("pause");
	return 0;
}