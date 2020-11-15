#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
#include<windows.h>
void IWord(char *p,int len){
	int word = 0;
	char *h = p;
	p = p + len-1;
	while (p-h>=0){
		if (*p!=' '&&p!=h){
			word++;
		}
		else if(*p==' '){
			for (int i = 1; i <= word;++i){
				printf("%c",*(p+i));
			}
			printf(" ");
			word = 0;
		}
		else if (p==h){
			for (int i = 0; i <= word; ++i){
				printf("%c", *(p + i));
			}
			printf("\n");
		}
		p--;
	}
}
int main(){
	char arr[50000];
	gets(arr);
	int len = strlen(arr);
	IWord(arr,len);
	system("pause");
	return 0;
}