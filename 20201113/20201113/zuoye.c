#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>
#include<string.h>
#include<math.h>
//дһ��������ӡarr��������ݣ���ʹ�������±꣬ʹ��ָ�롣arr��һ������һά���顣
/*void Print(int *p,int len){
	int i = 0;
	while (i != len){
		printf("%d ",*(p+i));
		i++;
	}
	printf("\n");
}
int main(){
	int num[] = {10,20,30,0,8,2,66,88,99};
	int len = sizeof(num) / sizeof(num[0]);
	Print(num,len);
	system("pause");
	return 0;
}*/
//дһ����������������һ���ַ��������ݡ�
/*void IWord(char *str,int len){
	int start = 0, end = len - 1;
	while (start<end){
		char p = *(str + start);
		*(str + start) = *(str + end);
		*(str + end) = p;
		start++;
		end--;
	}
}
int main(){
	char arr[10000];
	scanf("%s",arr);
	int len = strlen(arr);
	IWord(arr,len);
	printf("%s\n",arr);
	system("pause");
	return 0;
}*/
//��Sn=a+aa+aaa+aaaa+aaaaa��ǰ5��֮�ͣ�����a��һ�����֣����磺2 + 22 + 222 + 2222 + 22222
/*int Sn(int *a){
	int sum = 0;
	for (int i = 0; i < 5;++i){
		sum += *(a + i);
	}
	return sum;
}
int main(){
	int a[] = {2,22,222,2222,22222};
	printf("%d\n",Sn(a));
	system("pause");
	return 0;
}*/
//���0��100000֮������С�ˮ�ɻ��������������ˮ�ɻ�������ָһ��nλ�������λ���ֵ�n�η�֮��ȷ�õ��ڸ�������
//��:153��1 ^ 3��5 ^ 3��3 ^ 3����153��һ����ˮ�ɻ�������
void Water(){
	for (int i = 0; i <= 100000;++i){
		int num = 0;
		int n = i;
		int sum = 0;
		while (n){
			n = n / 10;
			num++;
		}
		n = i;
		while (n){
			sum = sum + (int)pow(n % 10, num);
			n = n / 10;
		}
		if (sum==i){
			printf("%d ",i);
		}
	}
	printf("\n");
}
int main(){
	Water();
	system("pause");
	return 0;
}
//��ӡ���� ��C��������Ļ���������ͼ����
/*void PrintLX1(int n){//������
	for (int i = 1; i <=n;++i){
		for (int j = 1; j <= n-i;++j){
			printf(" ");
		}
		for (int j = 1; j <= i;++j){
			printf("* ");
		}
		printf("\n");
	}
}
void PrintLX2(int n){//������
	for (int i = 1; i <= n; ++i){
		for (int j = 1; j <= i; ++j){
			printf(" ");
		}
		for (int j = 1; j <= n - i; ++j){
			printf("* ");
		}
		printf("\n");
	}
}
int main(){
	PrintLX1(7);
	PrintLX2(7);
	system("pause");
	return 0;
}*/
//����ˮ��1ƿ��ˮ1Ԫ��2����ƿ���Ի�һƿ��ˮ����20Ԫ�����Զ�����ˮ�����ʵ�֣���
/*int Drink(int Money){
	int num = 0;
	for (int i = Money; i >0;--i){
		if (num%2==0){
			i++;//ÿ��һƿ,�൱�ڶ�һ��Ǯ
		}
		num++;
	}
	return num;
}
int main(){
	printf("%d\n",Drink(20));
	system("pause");
	return 0;
}*/
/*int Mystrlen(char *p){
	if (*p=='\0'){
		return 0;
	}
	else{
		return 1 + Mystrlen(p+1);
	}
}
int main(){
	char str[50000];
	scanf("%s",str);
	printf("%d\n", Mystrlen(str));
	system("pause");
	return 0;
}*/
//ģ��ʵ�ֿ⺯��strcpy
/*void Mystrcpy(char *str1,char *str2){
	for (int i = 0;;++i){
		*(str1 + i) = *(str2 + i);
		if (*(str2 + i) == '\0'){
			break;
		}
	}
}
int main(){
	char str1[50000];
	char str2[50000];
	scanf("%s", str2);
	Mystrcpy(str1,str2);
	printf("����֮���str1Ϊ%s\n",str1);
	system("pause");
	return 0;
}*/
//��������ʹ����ȫ����λ��ż��ǰ�档ʹ�����������е�����λ�������ǰ�벿�֣�����ż��λ������ĺ�벿�֡�
/*void Ec(int *num,int len){
	int nu[10000] = {0};
	int i, j=0;
	for (i = 0; i < len;++i){
		if (*(num+i)%2!=0){
			nu[j] = *(num+i);
			j++;
		}
	}
	for (i = 0; i < len; ++i){
		if (*(num + i) % 2 == 0){
			nu[j] = *(num + i);
			j++;
		}
	}
	for (i = 0; i < len; ++i){
		num[i] = nu[i];
	}
}
int main(){
	int num[] = { 1, 20, 3, 80, 5, 6, 7, 9, 0 };
	int len = sizeof(num) / sizeof(int);
	Ec(num,len);
	for (int i = 0; i < len;++i){
		printf("%d ",num[i]);
	}
	printf("\n");
	system("pause");
	return 0;
}*/

