
//����:����һ�������������մ�С�����˳������������������ӣ��ظ���ҲҪ�о٣�����180��������Ϊ2 2 3 3 5 ��
//������Ϊ�����ܹ�����������������
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
//д��һ�����򣬽���һ����������ֵ���������ֵ�Ľ�������ֵ�����С�������ֵ���ڵ���5,����ȡ����С��5��������ȡ����
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
//����һ��int�����������մ���������Ķ�˳�򣬷���һ�������ظ����ֵ��µ�������
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