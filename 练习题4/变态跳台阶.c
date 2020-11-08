话说有一只青蛙，它可跳任意阶台阶，问有n阶台阶，有多少种跳法
#include<stdio.h>
int TaiJie(int T){
	if (T==1){
		return 1;
	}
	else{
		return 2 * TaiJie(T-1);
	}
}
int main(){
	printf("%d\n",TaiJie(3));//三阶台阶
	return 0;
}