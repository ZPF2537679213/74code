#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<windows.h>
//ʵ��ɾ���ַ����г��ִ������ٵ��ַ���������ַ����ִ���һ������ɾ�������ɾ����Щ���ʺ���ַ�����
//�ַ����������ַ�����ԭ����˳��ע��ÿ�������ļ��ж������룬������ַ����ûس�����
//�ַ���ֻ����СдӢ����ĸ, �����ǷǷ����룬������ַ�������С�ڵ���20���ֽڡ�
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