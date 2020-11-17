#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<windows.h>
//模仿qsort的功能实现一个通用的冒泡排序
int MyCmp(const void *eleme1,const void *eleme2){
	return *((int*)eleme1) - *((int*)eleme2);
}
int MyCmp1(const void *eleme1, const void *eleme2){
	return *((short*)eleme1) - *((short*)eleme2);
}
int MyCmp2(const void *eleme1, const void *eleme2){
	return *((char*)eleme1) - *((char*)eleme2);
}
void MyQsort(void *num,int len,int size,int (*cmp)(void *eleme1,void *eleme2)){
	for (int i = 1; i < len;++i){
		for (int j = 0; j < len - i;++j){
			if (cmp((char*)num + j*size, (char*)num + (j+1)*size)>0){
				for (int k = 0; k < size;++k){
					char tmp = *((char*)num + j*size+k);
					*((char*)num + j*size+k) = *((char*)num + (j+1)*size+k);
					*((char*)num + (j+1)*size+k ) = tmp;
				}
			}
		}
	}
}
int main(){
	int num[] = {10,5,8,7,0,6,11,3,2,1};
	int len = sizeof(num) / sizeof(num[0]);
	MyQsort(num,len,4,MyCmp);
	for (int i = 0; i < len;++i){
		printf("%d ",num[i]);
	}
	printf("\n");
	system("pause");
	return 0;
}
int main(){
	int num[] = { 10, 5, 8, 7, 0, 6, 11, 3, 2, 1 };
	char C[] = {'z','c','b','a','n','h'};
	short num2[] = { 100, 5, 99, 7, 0, 13, 18, 3, 6, 1 };
	int len1 = sizeof(num) / sizeof(num[0]);
	int len2 = sizeof(num2) / sizeof(num2[0]);
	int len3 = sizeof(C) / sizeof(C[0]);
	qsort(num,len1,sizeof(int),MyCmp);
	qsort(num2, len2, sizeof(short), MyCmp1);
	qsort(C ,len3, sizeof(char), MyCmp2);
	for (int i = 0; i < len1; ++i){
		printf("%d ", num[i]);
	}
	printf("\n");
	for (int i = 0; i < len2; ++i){
		printf("%d ", num2[i]);
	}
	printf("\n");
	for (int i = 0; i < len3; ++i){
		printf("%c ", C[i]);
	}
	printf("\n");
	system("pause");
	return 0;
}