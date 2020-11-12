#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include<windows.h>
//编程实现：两个int（32位）整数m和n的二进制表达中，有多少个位(bit)不同？ 
//输入例子:
//1999 2299
//输出例子 : 7
/*int Once(int x,int y){
	int n = x^y;
	int count = 0;
	while (n!=0){
		count++;
		n = n&(n - 1);
	}
	return count;
}
int main(){
	int x = 1999, y = 2299;
	printf("有%d个bit位不同\n",Once(x,y));
	system("pause");
	return 0;
}*/
//获取一个整数二进制序列中所有的偶数位和奇数位，分别打印出二进制序列
/*void PrintTwo(int n){
	int num1[16] = { 0 };
	int num2[16] = { 0 };
	int i,j,k;
	for (i = 0,j=0,k=0; i < 32;++i){
		if (i%2!=0){
			num1[j] = n & 1;
			++j;
		}
		else{
			num2[k] = n & 1;
			++k;
		}
		n = n >> 1;
	}
	printf("奇数位为:"); 
	for (i = j-1; i >=0;--i){
		printf("%d ",num1[i]);
	}
	printf("\n");
	printf("偶数位为:");
	for (i =k-1; i >=0; --i){
		printf("%d ", num2[i]);
	}
	printf("\n");
}
int main(){
	int n;
	scanf("%d",&n);
	PrintTwo(n);
	system("pause");
	return 0;
}*/
//统计二进制中1的个数
int One(int n){
	int count = 0;
	while (n != 0){
		count++;
		n = n&(n - 1);
	}
	return count;
}
int main(){
	int n;
	scanf("%d", &n);
	printf("%d\n",One(n));
	system("pause");
	return 0;
}