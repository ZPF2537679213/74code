#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>
#define MAX_SIZE 2+3//��
struct _Record_Struct
{
	unsigned char Env_Alarm_ID : 4;
	unsigned char Para1 : 2;//Env_Alarm_ID ��Para1����һ���ֽ�
	unsigned char state;//һ���ֽ�
	unsigned char avail : 1;//��ռһ���ֽ�
};
int main(){
	struct _Record_Struct *pointer = (struct _Record_Struct*)malloc(sizeof(struct _Record_Struct) * MAX_SIZE);//ע�⣡ʵ������3*A+B
	printf("%d\n", sizeof(struct _Record_Struct) * MAX_SIZE);
	system("pause");
	return 0;
}
//ö��
enum ENUM_A
{
	X1,//Ĭ�ϴ�0��ʼ
	Y1,//+1
	Z1 = 255,
	A1,//+1
	B1,//+1
};
//�����塪�������塪�������ڴ�
int main()
{
	union
	{
		short k;//2���ֽ�
		char i[2];//2���ֽ�
	}*s, a;//����һ���ڴ�2���ֽ�
	s = &a;
	s->i[0] = 0x39;
	s->i[1] = 0x38;
	printf("%x\n", a.k);
	return 0;
}
union Un
{
	short s[7];//short�ֽ���2  VSĬ�϶�����8  ȡ��С2    ��0�ſ�ʼ�洢��ƫ����Ϊ�� �浽1��
	int n;//int�ֽ���4     VSĬ�϶�����8     ȡ��С4     4�������� ���Դ�4��ʼ��7��
};//ȡ��������4�����������ֽ���Ϊ4����������s��7�����ֽ�������n�����ԣ���2*7=14��ʼ��4���������������16��������16���ֽ�
/*
�ṹ����int���룬7��shortһ����14�ֽڣ��������16�ֽڡ�n�ǵ�����4�ֽڣ�������union������n��s���ÿռ䣬
ֻȡ���Ԫ�أ���ռ��16�ֽڡ�
*/
//λ��
struct tagPIM
{
	unsigned char ucPim1;//1���ֽ�
	unsigned char ucData0 : 1;//1λ
	unsigned char ucData1 : 2;//2λ
	unsigned char ucData2 : 3;//3λ
};//�����ܹ�2���ֽ�