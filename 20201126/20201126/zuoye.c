#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>
#define MAX_SIZE 2+3//宏
struct _Record_Struct
{
	unsigned char Env_Alarm_ID : 4;
	unsigned char Para1 : 2;//Env_Alarm_ID 和Para1公用一个字节
	unsigned char state;//一个字节
	unsigned char avail : 1;//独占一个字节
};
int main(){
	struct _Record_Struct *pointer = (struct _Record_Struct*)malloc(sizeof(struct _Record_Struct) * MAX_SIZE);//注意！实际上是3*A+B
	printf("%d\n", sizeof(struct _Record_Struct) * MAX_SIZE);
	system("pause");
	return 0;
}
//枚举
enum ENUM_A
{
	X1,//默认从0开始
	Y1,//+1
	Z1 = 255,
	A1,//+1
	B1,//+1
};
//联合体——共用体——公用内存
int main()
{
	union
	{
		short k;//2个字节
		char i[2];//2个字节
	}*s, a;//公用一个内存2个字节
	s = &a;
	s->i[0] = 0x39;
	s->i[1] = 0x38;
	printf("%x\n", a.k);
	return 0;
}
union Un
{
	short s[7];//short字节数2  VS默认对齐数8  取最小2    从0号开始存储，偏移量为零 存到1号
	int n;//int字节数4     VS默认对齐数8     取最小4     4的整数倍 所以从4开始到7号
};//取最大对齐数4个，所以总字节数为4的整数倍，s【7】的字节数大于n的所以，从2*7=14开始离4的整数倍最近的是16，所以是16个字节
/*
结构体向int对齐，7个short一共是14字节，对齐后是16字节。n是单独的4字节，由于是union，所以n与s共用空间，
只取最长的元素，故占用16字节。
*/
//位段
struct tagPIM
{
	unsigned char ucPim1;//1个字节
	unsigned char ucData0 : 1;//1位
	unsigned char ucData1 : 2;//2位
	unsigned char ucData2 : 3;//3位
};//所以总共2个字节