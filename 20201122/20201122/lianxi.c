#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
#include<windows.h>
void IWord(char *start, char *end){
	while (start < end){
		char q = *start;
		*start = *end;
		*end = q;
		start++;
		end--;
	}
}
int main(){
	char str[100];
	gets(str);
	IWord(str, str+strlen(str)-1);
	char *start=str;
	int i=0;
	while (1){
		if (*(str+i)!='\0'&&*(str+i)!=' '){
			i++;
		}
		else{
			IWord(start,start+i-2);
			start = start + i;
			if (*(str+i)=='\0'){
				break;
			}
			i++;
		}
	}
	printf("%s\n",str);
	system("pause");
	return 0;
}