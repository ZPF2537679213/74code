1.利用上面实现的函数打印100到200之间的素数。（要用到math.h中的sqrt函数（开方））
（一个数的因数总有一个小于等于这个数的开方！例如：16=44=28=1*16）

#include<stdio.h>
#include<math.h>
void SuShu(){
	int i, j;
	for (i = 100; i <= 200;++i){
		for (j = 2; j <= sqrt(i)&&i%j!=0;++j){}
		if (j>sqrt(i)){
			printf("%d ",i);
		}
	}
	printf("\n");
}
int main(){
	SuShu();
	return 0;
}
2.实现函数判断year是不是润年。(闰年：能被400整出或者能被4整出不能被100整除)

#include<stdio.h>
void Year(int year){
	if (year%400==0||year%4==0&&year%100!=0){
		printf("%d是闰年\n",year);
	}
	else{
		printf("%d不是闰年\n", year);
	}
}
int main(){
	int year;
	scanf("%d",&year);
	Year(year);
	return 0;
}
3.实现一个函数来交换两个整数的内容.（要点：传值与传址的区别）

#include<stdio.h>
void Change(int*x,int*y){
	(*x) = (*x) ^ (*y);
	(*y) = (*x) ^ (*y);
	(*x) = (*x) ^ (*y);
}
int main(){
	int x, y;
	scanf("%d%d",&x,&y);
	Change(&x,&y);
	printf("x=%d,y=%d\n",x,y);
	return 0;
}
4.实现一个函数，打印乘法口诀表，口诀表的行数和列数自己指定

#include<stdio.h>
void MUL(int n){
	for (int i = 1; i <= n;++i){
		for (int j = i; j <= n;++j){
			printf("%dx%d=%d ",i,j,i*j);
		}
		printf("\n");
	}
}
int main(){
	int n;
	scanf("%d",&n);
	MUL(n);
	return 0;
}
5.递归方式实现打印一个整数的每一位（所谓递归就是函数自己调用自己，有递有归）

#include<stdio.h>
void Print(int n){
	if (n!=0){
		printf("%d ",n % 10);
		n /= 10;
		Print(n);
	}
}
int main(){
	int n;
	scanf("%d",&n);
	Print(n);
	return 0;
}
6.递归和非递归分别实现求n的阶乘（不考虑溢出的问题）

#include<stdio.h>
int Fac(int n){
	if (n == 1){
		return 1;
	}
	else {
		return n*Fac(n-1);
	}
}
int main(){
	int n;
	scanf("%d", &n);
	printf("%d\n",Fac(n));
	return 0;
}
7.递归和非递归分别实现strlen（仔细体会）
（非递归）

#include<stdio.h>
int Strlen(char *p){
	int len ;
	for (len = 0; *(p + len) != '\0';++len){}
	return len;
}
int main(){
	char n[5000];
	scanf("%s", n);
	printf("%d\n",Strlen(n));
	return 0;
}
（递归）

#include<stdio.h>
int NoStrlen(char *p){
	if ((*p) == '\0'){
		return 0;
	}
	else{
		return 1 + NoStrlen(p+1);
	}
}
int main(){
	char n[5000];
	scanf("%s", n);
	printf("%d\n", NoStrlen(n));
	return 0;
}
8.编写一个函数 reverse_string(char * string)（递归实现）

#include<stdio.h>
void reverse_string(char * string){
	if (*string!='\0'){
		reverse_string(string+1);
		printf("%c",*string);
	}
}
int main(){
	char n[5000];
	scanf("%s", n);
	reverse_string(n);
	return 0;
}
9.写一个递归函数DigitSum(n)，输入一个非负整数，返回组成它的数字之和
例如，调用DigitSum(1729)，则应该返回1 + 7 + 2 + 9，它的和是19。
输入：1729，输出：19

#include<stdio.h>
int DigitSum(int n){
	if (n == 0){
		return 0;
	}
	else{
		return (n % 10) + DigitSum(n/10);
	}
}
int main(){
	int n;
	scanf("%d", &n);
	printf("%d\n", DigitSum(n));
	return 0;
}
10.编写一个函数实现n的k次方，使用递归实现。(注意math.h里的pow函数是小写，而我重新定义的乘方函数是Pow，不一样，别看错了，飞哥就是看好取名字，哈哈哈)

#include<stdio.h>
long Pow(int n,int k){
	static int m = 0;
	if (m == k){
		return 1;
	}
	else{
		m++;
		return n*Pow(n,k);
	}
}
int main(){
	int n,k;
	scanf("%d%d", &n,&k);
	printf("%ld\n", Pow(n,k));
	return 0;
}
11.递归和非递归分别实现求第n个斐波那契数
(斐波那契数:第一项，第二项为1，其他项为前两项的和)
输入：5 输出：5
输入：10， 输出：55
输入：2， 输出：1
{非递归}
！！！！！！第n项等于第n-1项和第n-2项的和！！！！！！

#include<stdio.h>
int FB(int n){
	int i,num[1000];
	num[0] = num[1] = 1;
	for (i = 2; i < n;++i){
		num[i] = num[i - 1] + num[i-2];
	}
	return num[i - 1];
}
int main(){
	int n;
	scanf("%d", &n);
	printf("%d\n", FB(n));
	return 0;
}
（递归）
！！！！！！第n项等于第n-1项和第n-2项的和！！！！！！

#include<stdio.h>
int NFB(int n){
	if (n == 1 || n == 2){
		return 1;
	}
	else{
		return NFB(n - 1) + NFB(n-2);//第n项等于第n-1项和第n-2项的和
	}
}
int main(){
	int n;
	scanf("%d", &n);
	printf("%d\n", NFB(n));
	return 0;
}