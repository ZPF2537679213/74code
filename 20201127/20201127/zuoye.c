#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include<stdlib.h>
#include<math.h>
#include<assert.h>
#include<windows.h>
//实现atoi函数——数字字符串转整形数
/*int MyAtoi(char *p){
	int sum = 0;
	char *n = p;
	while (*p!='\0'&&(*p>='0'&&*p<='9')){
		p++;
	}
	if (n == p){ 
		return 0; 
	}
	for (int i = p-n-1; i >=0;--i){
		sum = sum + (*(n+i)-48)*(int)pow(10,p-n-1-i);
	}
	return sum;
}
int main(){
	char *s = "779999";
	printf("%d\n",MyAtoi(s));
	system("pause");
	return 0;
}*/
//模拟实现strncat
/*void MyStrncat(char *p,char *str,int size){
	assert(p!=NULL);
	while (*p!='\0'){
		p++;
	}
	while (size&&*str!='\0'){
		*p = *str;
		p++;
		str++;
		size--;
	}
}
int main(){
	char s[] = "779999";
	char str[20] = "gdrgdgfdff";
	MyStrncat(str, s, 6);
	printf("%s\n", str);
	system("pause");
	return 0;
}*/
//模拟实现strncpy
/*void MyStrncpy(char *p, char *str, int size){
	assert(p != NULL);
	while (size&&*str != '\0'){
		*p = *str;
		p++;
		str++;
		size--;
	}
}
int main(){
	char s[] = "779999";
	char str[20] = "gdrgdgfdff";
	MyStrncpy(str, s, 6);
	printf("%s\n", str);
	system("pause");
	return 0;
}*/
//一个数组中只有两个数字是出现一次，其他所有数字都出现了两次。
//编写一个函数找出这两个只出现一次的数字。
void SerOnDog(int *num,int len){
	int n = 0;
	int x=0,y=0;
	for (int i = 0; i < len;++i){
		n = n^num[i];
	}
	int p = n&(-n);//拿到为1的位置，例如n的二进制为0000 0110，则-n在内存中为1000 0010，相与之后为0010这就得到1的位置了
	for (int i = 0; i < len;++i){
		if ((p&(num[i]))==p){
			x = x^num[i];
		}
		else{
			y = y^num[i];
		}
	}
	printf("第一个单身狗是%d，第二个单身狗为%d\n",x,y);
}
int main(){
	int *num = (int *)calloc(10,sizeof(int));
	printf("请输入数组数字：");
	for (int i = 0; i < 10;++i){
		scanf("%d",num+i);
	}
	SerOnDog(num,10);
	system("pause");
	return 0;
}