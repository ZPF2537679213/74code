输入一个int型的正整数，计算出该int型数据在内存中存储时1的个数。

#include<stdio.h>
int Num(int n){
	if (n==0){
		return 0;
	}
	else {
		return n % 2==1? (1 + Num(n / 2)) : Num(n / 2);
	}
}
int main(){
	int n;
	scanf("%d",&n);
	printf("%d\n",Num(n));
	return 0;
}