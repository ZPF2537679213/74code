1.��������ʵ�ֵĺ�����ӡ100��200֮�����������Ҫ�õ�math.h�е�sqrt��������������
��һ��������������һ��С�ڵ���������Ŀ��������磺16=44=28=1*16��

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
2.ʵ�ֺ����ж�year�ǲ������ꡣ(���꣺�ܱ�400���������ܱ�4�������ܱ�100����)

#include<stdio.h>
void Year(int year){
	if (year%400==0||year%4==0&&year%100!=0){
		printf("%d������\n",year);
	}
	else{
		printf("%d��������\n", year);
	}
}
int main(){
	int year;
	scanf("%d",&year);
	Year(year);
	return 0;
}
3.ʵ��һ��������������������������.��Ҫ�㣺��ֵ�봫ַ������

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
4.ʵ��һ����������ӡ�˷��ھ����ھ���������������Լ�ָ��

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
5.�ݹ鷽ʽʵ�ִ�ӡһ��������ÿһλ����ν�ݹ���Ǻ����Լ������Լ����е��й飩

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
6.�ݹ�ͷǵݹ�ֱ�ʵ����n�Ľ׳ˣ���������������⣩

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
7.�ݹ�ͷǵݹ�ֱ�ʵ��strlen����ϸ��ᣩ
���ǵݹ飩

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
���ݹ飩

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
8.��дһ������ reverse_string(char * string)���ݹ�ʵ�֣�

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
9.дһ���ݹ麯��DigitSum(n)������һ���Ǹ����������������������֮��
���磬����DigitSum(1729)����Ӧ�÷���1 + 7 + 2 + 9�����ĺ���19��
���룺1729�������19

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
10.��дһ������ʵ��n��k�η���ʹ�õݹ�ʵ�֡�(ע��math.h���pow������Сд���������¶���ĳ˷�������Pow����һ�����𿴴��ˣ��ɸ���ǿ���ȡ���֣�������)

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
11.�ݹ�ͷǵݹ�ֱ�ʵ�����n��쳲�������
(쳲�������:��һ��ڶ���Ϊ1��������Ϊǰ����ĺ�)
���룺5 �����5
���룺10�� �����55
���룺2�� �����1
{�ǵݹ�}
��������������n����ڵ�n-1��͵�n-2��ĺͣ�����������

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
���ݹ飩
��������������n����ڵ�n-1��͵�n-2��ĺͣ�����������

#include<stdio.h>
int NFB(int n){
	if (n == 1 || n == 2){
		return 1;
	}
	else{
		return NFB(n - 1) + NFB(n-2);//��n����ڵ�n-1��͵�n-2��ĺ�
	}
}
int main(){
	int n;
	scanf("%d", &n);
	printf("%d\n", NFB(n));
	return 0;
}