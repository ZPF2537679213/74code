����һ��int�͵����������������int���������ڴ��д洢ʱ1�ĸ�����

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