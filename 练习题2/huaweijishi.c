
//功能:输入一个正整数，按照从小到大的顺序输出它的所有质因子（重复的也要列举）（如180的质因子为2 2 3 3 5 ）
//质因数为所有能够整出被除数的质数
#include<stdio.h>
int main(){
	long num,i;
	scanf("%d",&num);
	for (i =2; i <=num;){
		if (num%i!=0){
			i++;
		}
		else{
			printf("%d ",i);
			num = num / i;
		}
	}
	printf("\n");
	return 0;
}
//写出一个程序，接受一个正浮点数值，输出该数值的近似整数值。如果小数点后数值大于等于5,向上取整；小于5，则向下取整。
#include<stdio.h>
int main(){
	float x;
	scanf("%f",&x);
	if ((int)(x+0.5)>x){
		printf("%d\n", (int)(x + 0.5));
	}
	else {
		printf("%d\n",(int)x);
	}
	return 0;
}
//输入一个int型整数，按照从右向左的阅读顺序，返回一个不含重复数字的新的整数。
#include<stdio.h>
int main(){
	int number;
	scanf("%d",&number);
	int num[10],i=0;
	while (number){
		num[i] = number % 10;
		number /= 10;
		i++;
	}
	for (int j = 0; j <i-1;++j){
		for (int k = j+1; k < i;++k){
			if (num[j]==num[k]){
				num[k] =10;
			}
		}
	}
	for (int k = 0; k < i; ++k){
		if (num[k]!=10){
			printf("%d", num[k]);
		}
	}
	printf("\n");
	return 0;
}