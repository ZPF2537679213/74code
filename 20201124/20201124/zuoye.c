#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
#include<assert.h>
#include<windows.h>
/*
дһ���������ж�һ���ַ����Ƿ�Ϊ����һ���ַ�����ת֮����ַ�����
���磺����s1 =AABCD��s2 = BCDAA������1
����s1=abcd��s2=ACBD������0.
AABCD����һ���ַ��õ�ABCDA
AABCD���������ַ��õ�BCDAA
AABCD����һ���ַ��õ�DAABC
*/
//��һ
/*int String(char *str1,char *str2,int len){
	int l = len;
	while (len){
		int i;
		char p = *str1;
		for (i = 0; i < l - 1; ++i){
			*(str1 + i) = *(str1 + i + 1);
		}
		*(str1 + i) = p;
		if (strcmp(str1, str2) == 0){
			return 1;
		}
		len--;
	}
	return 0;
}
//����
int findRound(const char * src, char * find)
{
	char tmp[256] = { 0 }; //��һ�������ռ佫ԭ�ַ�����������ԭ�ַ���
	strcpy(tmp, src); //�ȿ���һ��
	strcat(tmp, src); //������һ��
	return strstr(tmp, find) != NULL; //�����Ҳ��ҵõ�
}
int main(){
	char str1[100];
	char str2[100];
	scanf("%s",str1);
	scanf("%s", str2);
	printf("%d\n", String(str1,str2, strlen(str1)));
	system("pause");
	return 0;
}*/
/*
ʵ��һ�����������������ַ����е�k���ַ���
���磺
ABCD����һ���ַ��õ�BCDA
ABCD���������ַ��õ�CDAB
*/
/*void String(char *str1, int len, int k){
	while (k){
		int i;
		char p = *str1;
		for (i = 0; i < len - 1; ++i){
			*(str1 + i) = *(str1 + i+1);
		}
		*(str1 + i) = p;
		k--;
	}
}
int main(){
	char str1[100];
	int k;
	scanf("%s", str1);
	scanf("%d",&k);
	String(str1, strlen(str1), k);
	printf("%s\n",str1);
	system("pause");
	return 0;
}*/
/*
��һ�����־��󣬾����ÿ�д������ǵ����ģ�������ϵ����ǵ����ģ����д�����������ľ����в���ĳ�������Ƿ���ڡ�
Ҫ��ʱ�临�Ӷ�С��O(N);
*/
/*int MySer(int num[][5],int n){
	int x = 0;
	int y = 4;
	while (x>=0&&y>=0){
		if (num[x][y]>n){
			y--;
		}
		else if (num[x][y]<n){
			x++;
		}
		else{
			return 1;
		}
	}
	return 0;
}
int main(){
	int num[5][5] = { {1,2,3,4,5}, {2,3,4,5,6}, {3,4,5,6,7}, {4,5,6,7,8}, {5,6,7,8,9} };
	int n;
	scanf("%d",&n);
	if (MySer(num,n)>0){
		printf("�ҵ���\n");
	}
	else{
		printf("û�ҵ�\n");
	}
	system("pause");
	return 0;
}*/
//ģ��ʵ��memmove
/*void Mymemmove(void *str1,void *str2,int size){
	size--;
	if (str1>str2){
		while (size){
			*((char*)str1+size) = *((char*)str2+size);
			size--;
		}
	}
	else{
		while (size){
			*((char*)str1) = *((char*)str2 );
			((char*)str1)++;
			((char*)str2)++;
			size--;
		}
	}
}
int main(){
	int num[] = {1,5,8,9,10,11,22,33,77,55};
	Mymemmove(num,num+2, 16);
	for (int i = 0; i < sizeof(num) / sizeof(num[0]);++i){
		printf("%d ",num[i]);
	}
	printf("\n");
	system("pause");
	return 0;
}*/
//ģ��ʵ��memcpy
/*void MyMemcpy(void *str2, void *str1, int size){
	while (size){
		*((char*)str2) = *((char*)str1);
		((char*)str1)++;
		((char*)str2)++;
		size--;
	}
}
	int main(){
		int num[] = { 1, 5, 8, 9, 10, 11, 22, 33, 77, 55 };
		int n[10] = {0};
		MyMemcpy(n, num, 32);
		for (int i = 0; i <10; ++i){
			printf("%d ", n[i]);
		}
		printf("\n");
		system("pause");
		return 0;
	}*/
//ģ��ʵ��strstr
/*char *MyStrstr(char *str1,char *str){
	char*start=str1;
	char *s;
	while (*start){
		s = str;
		str1 = start;
		while (*s==*str1&&*s!='\0'){
			s++;
			str1++;
		}
		if (*s=='\0'){
			return start;
		}
		start++;
	}
	return NULL;
}
int main(){
	char str[100];
	char s[100];
	scanf("%s",str);
	scanf("%s",s);
	if (MyStrstr(str,s)){
		printf("%s\n", MyStrstr(str, s));
	}
	else{
		printf("û�ҵ�\n");
	}
	system("pause");
	return 0;
}*/
//ģ��ʵ��strcat
/*char *MyStrcat(char *str1,char *str2){
	assert(str1!=NULL);
	char *p = str1;
	while (*p++){}
	p--;
	while (*p++ = *str2++){}
	return str1;
}
int main(){ 
	char str[100];
	char s[100];
	scanf("%s", str);
	scanf("%s", s);
	printf("%s\n",MyStrcat(str,s));
	system("pause");
	return 0;
}*/
//ģ��ʵ��strcmp
/*int MyStrcmp(char *str1,char *str2){
	assert(str1!=NULL&&str2!=NULL);
	while (*str1&&*str2){
		if (*str1>*str2){
			return 1;
		}
		else if (*str1<*str2){
			return -1;
		}
		else if(*str1==*str2){
			str1++;
			str2++;
		}
	}
	if (*str1==*str2){
		return 0;
	}
	else if (*str1=='\0'&&*str2!='\0'){
		return -1;
	}
	else{
		return 1;
	}
}
int main(){
	char str[100];
	char s[100];
	scanf("%s", str);
	scanf("%s", s);
	printf("%d\n", MyStrcmp(str, s));
	system("pause");
	return 0;
}*/
//ģ��ʵ��strcpy
/*char *MyStrcpy(char *str1,const char *str2){
	assert(str1!=NULL);
	char *p = str1;
	while (*p++=*str2++);
	return str1;
}
int main(){
	char str[100];
	char s[100];
	scanf("%s", str);
	scanf("%s", s);
    MyStrcpy(str, s);
	printf("%s\n",str);
	system("pause");
	return 0;
}*/
//ģ��ʵ��strlen
unsigned int MyStrlen(char *str){
	char*p = str;
	while (*str++);
	str--;
	return str - p;
}
int main(){
	char str[100];
	scanf("%s", str);
	printf("%d\n", MyStrlen(str));
	system("pause");
	return 0;
}