#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include<stdlib.h>
#include<math.h>
#include<assert.h>
#include<windows.h>
//ʵ��atoi�������������ַ���ת������
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
//ģ��ʵ��strncat
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
//ģ��ʵ��strncpy
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
//һ��������ֻ�����������ǳ���һ�Σ������������ֶ����������Ρ�
//��дһ�������ҳ�������ֻ����һ�ε����֡�
void SerOnDog(int *num,int len){
	int n = 0;
	int x=0,y=0;
	for (int i = 0; i < len;++i){
		n = n^num[i];
	}
	int p = n&(-n);//�õ�Ϊ1��λ�ã�����n�Ķ�����Ϊ0000 0110����-n���ڴ���Ϊ1000 0010������֮��Ϊ0010��͵õ�1��λ����
	for (int i = 0; i < len;++i){
		if ((p&(num[i]))==p){
			x = x^num[i];
		}
		else{
			y = y^num[i];
		}
	}
	printf("��һ��������%d���ڶ�������Ϊ%d\n",x,y);
}
int main(){
	int *num = (int *)calloc(10,sizeof(int));
	printf("�������������֣�");
	for (int i = 0; i < 10;++i){
		scanf("%d",num+i);
	}
	SerOnDog(num,10);
	system("pause");
	return 0;
}