#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>
//01±³°ü
#define N 5
#define V 20
int Max(int x,int y){
	return x > y ? x : y;
}
int Bag(int Ti[],int Value[]){
	int n = 4;
	int v = 10;
	int map[N][V] = {0};
	for (int i = 1; i <=n;++i){
		for (int j = 1; j <=v; ++j){
			if (j < Ti[i])map[i][j] = map[i-1][j];
			else map[i][j] = Max(map[i-1][j],(map[i-1][j-Ti[i]]+Value[i]));
		}
	}
	return map[n][v];
}
int main(){
	int Ti[] = {0,2,3,4,7};
	int Value[] = {0,1,3,5,9};
	printf("%d\n",Bag(Ti,Value));
	system("pause");
	return 0;
}