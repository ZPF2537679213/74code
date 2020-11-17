#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<windows.h>
//实现删除字符串中出现次数最少的字符，若多个字符出现次数一样，则都删除。输出删除这些单词后的字符串，
//字符串中其它字符保持原来的顺序。注意每个输入文件有多组输入，即多个字符串用回车隔开
//字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
void Deleted(char *str,int len){
	int num[26] = {0};
	int min = 0;
	for (int i = 0; i < len;++i){
			num[*(str + i) - 97]++;
			min = num[*(str + i) - 97];
	}

	for (int i = 0; i < 26; ++i){
		if (num[i]>0&&min>num[i]){
			min = num[i];
		}
	}
	for (int i = 0; i < 26; ++i){
		if (min==num[i]){
				for (int j = 0; j < len;++j){
					if ((char)(i+97)==*(str+j)){
						*(str + j) = '0';
				}
			}
		}
	}
	for (int i = 0; i < len;++i){
		if (*(str+i)!='0'){
			printf("%c",*(str+i));
		}
	}
}
int main(){
	char str[20];
scanf("%s", str);
		int len = strlen(str);
		Deleted(str, len);
		printf("\n");
	system("pause");
	return 0;
}