#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include<windows.h>
//���ʵ�֣�����int��32λ������m��n�Ķ����Ʊ���У��ж��ٸ�λ(bit)��ͬ�� 
//��������:
//1999 2299
//������� : 7
/*int Once(int x,int y){
	int n = x^y;
	int count = 0;
	while (n!=0){
		count++;
		n = n&(n - 1);
	}
	return count;
}
int main(){
	int x = 1999, y = 2299;
	printf("��%d��bitλ��ͬ\n",Once(x,y));
	system("pause");
	return 0;
}*/
//��ȡһ���������������������е�ż��λ������λ���ֱ��ӡ������������
/*void PrintTwo(int n){
	int num1[16] = { 0 };
	int num2[16] = { 0 };
	int i,j,k;
	for (i = 0,j=0,k=0; i < 32;++i){
		if (i%2!=0){
			num1[j] = n & 1;
			++j;
		}
		else{
			num2[k] = n & 1;
			++k;
		}
		n = n >> 1;
	}
	printf("����λΪ:"); 
	for (i = j-1; i >=0;--i){
		printf("%d ",num1[i]);
	}
	printf("\n");
	printf("ż��λΪ:");
	for (i =k-1; i >=0; --i){
		printf("%d ", num2[i]);
	}
	printf("\n");
}
int main(){
	int n;
	scanf("%d",&n);
	PrintTwo(n);
	system("pause");
	return 0;
}*/
//ͳ�ƶ�������1�ĸ���
int One(int n){
	int count = 0;
	while (n != 0){
		count++;
		n = n&(n - 1);
	}
	return count;
}
int main(){
	int n;
	scanf("%d", &n);
	printf("%d\n",One(n));
	system("pause");
	return 0;
}