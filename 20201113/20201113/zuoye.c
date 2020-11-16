#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>
#include<string.h>
#include<math.h>
//写一个函数打印arr数组的内容，不使用数组下标，使用指针。arr是一个整形一维数组。
/*void Print(int *p,int len){
	int i = 0;
	while (i != len){
		printf("%d ",*(p+i));
		i++;
	}
	printf("\n");
}
int main(){
	int num[] = {10,20,30,0,8,2,66,88,99};
	int len = sizeof(num) / sizeof(num[0]);
	Print(num,len);
	system("pause");
	return 0;
}*/
//写一个函数，可以逆序一个字符串的内容。
/*void IWord(char *str,int len){
	int start = 0, end = len - 1;
	while (start<end){
		char p = *(str + start);
		*(str + start) = *(str + end);
		*(str + end) = p;
		start++;
		end--;
	}
}
int main(){
	char arr[10000];
	scanf("%s",arr);
	int len = strlen(arr);
	IWord(arr,len);
	printf("%s\n",arr);
	system("pause");
	return 0;
}*/
//求Sn=a+aa+aaa+aaaa+aaaaa的前5项之和，其中a是一个数字，例如：2 + 22 + 222 + 2222 + 22222
/*int Sn(int *a){
	int sum = 0;
	for (int i = 0; i < 5;++i){
		sum += *(a + i);
	}
	return sum;
}
int main(){
	int a[] = {2,22,222,2222,22222};
	printf("%d\n",Sn(a));
	system("pause");
	return 0;
}*/
//求出0～100000之间的所有“水仙花数”并输出。“水仙花数”是指一个n位数，其各位数字的n次方之和确好等于该数本身
//如:153＝1 ^ 3＋5 ^ 3＋3 ^ 3，则153是一个“水仙花数”。
void Water(){
	for (int i = 0; i <= 100000;++i){
		int num = 0;
		int n = i;
		int sum = 0;
		while (n){
			n = n / 10;
			num++;
		}
		n = i;
		while (n){
			sum = sum + (int)pow(n % 10, num);
			n = n / 10;
		}
		if (sum==i){
			printf("%d ",i);
		}
	}
	printf("\n");
}
int main(){
	Water();
	system("pause");
	return 0;
}
//打印菱形 用C语言在屏幕上输出以下图案：
/*void PrintLX1(int n){//正三角
	for (int i = 1; i <=n;++i){
		for (int j = 1; j <= n-i;++j){
			printf(" ");
		}
		for (int j = 1; j <= i;++j){
			printf("* ");
		}
		printf("\n");
	}
}
void PrintLX2(int n){//倒三角
	for (int i = 1; i <= n; ++i){
		for (int j = 1; j <= i; ++j){
			printf(" ");
		}
		for (int j = 1; j <= n - i; ++j){
			printf("* ");
		}
		printf("\n");
	}
}
int main(){
	PrintLX1(7);
	PrintLX2(7);
	system("pause");
	return 0;
}*/
//喝汽水，1瓶汽水1元，2个空瓶可以换一瓶汽水，给20元，可以多少汽水（编程实现）。
/*int Drink(int Money){
	int num = 0;
	for (int i = Money; i >0;--i){
		if (num%2==0){
			i++;//每换一瓶,相当于多一块钱
		}
		num++;
	}
	return num;
}
int main(){
	printf("%d\n",Drink(20));
	system("pause");
	return 0;
}*/
/*int Mystrlen(char *p){
	if (*p=='\0'){
		return 0;
	}
	else{
		return 1 + Mystrlen(p+1);
	}
}
int main(){
	char str[50000];
	scanf("%s",str);
	printf("%d\n", Mystrlen(str));
	system("pause");
	return 0;
}*/
//模拟实现库函数strcpy
/*void Mystrcpy(char *str1,char *str2){
	for (int i = 0;;++i){
		*(str1 + i) = *(str2 + i);
		if (*(str2 + i) == '\0'){
			break;
		}
	}
}
int main(){
	char str1[50000];
	char str2[50000];
	scanf("%s", str2);
	Mystrcpy(str1,str2);
	printf("复制之后的str1为%s\n",str1);
	system("pause");
	return 0;
}*/
//调整数组使奇数全部都位于偶数前面。使得数组中所有的奇数位于数组的前半部分，所有偶数位于数组的后半部分。
/*void Ec(int *num,int len){
	int nu[10000] = {0};
	int i, j=0;
	for (i = 0; i < len;++i){
		if (*(num+i)%2!=0){
			nu[j] = *(num+i);
			j++;
		}
	}
	for (i = 0; i < len; ++i){
		if (*(num + i) % 2 == 0){
			nu[j] = *(num + i);
			j++;
		}
	}
	for (i = 0; i < len; ++i){
		num[i] = nu[i];
	}
}
int main(){
	int num[] = { 1, 20, 3, 80, 5, 6, 7, 9, 0 };
	int len = sizeof(num) / sizeof(int);
	Ec(num,len);
	for (int i = 0; i < len;++i){
		printf("%d ",num[i]);
	}
	printf("\n");
	system("pause");
	return 0;
}*/

