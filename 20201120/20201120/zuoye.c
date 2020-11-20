#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>
//在屏幕上打印杨辉三角。
/*void Yhsj(int n){
	int num[100][100];
	for (int i = 0; i < n;++i){
		for (int j = 0; j <= i;++j){
			if (j==0||i==j){
				num[i][j] = 1;
			}
			else{
				num[i][j] = num[i - 1][j] + num[i - 1][j - 1];
			}
			printf("%d ",num[i][j]);
		}
		printf("\n");
	}
}
int main(){
	int n;
	scanf("%d",&n);
	Yhsj(n);
	system("pause");
	return 0;
}*/
/*
日本某地发生了一件谋杀案，警察通过排查确定杀人凶手必为4个嫌疑犯的一个。
以下为4个嫌疑犯的供词:
A说：不是我。
B说：是C。
C说：是D。
D说：C在胡说
已知3个人说了真话，1个人说的是假话。
现在请根据这些信息，写一个程序来确定到底谁是凶手。
*/
/*int main(){
	char XS = 'A';//先默认凶手是A
	for (;XS<='D';XS++){
		if ((XS!='A')+(XS=='C')+(XS=='D')+(XS!='D')==3){//即所有条件都满足时即为凶手
			break;
		}
	}
	printf("凶手是%c\n",XS);
	system("pause");
	return 0;
}*/

/*
5位运动员参加了10米台跳水比赛，有人让他们预测比赛结果：
A选手说：B第二，我第三；
B选手说：我第二，E第四；
C选手说：我第一，D第二；
D选手说：C最后，我第三；
E选手说：我第四，A第一；
比赛结束后，每位选手都说对了一半，请编程确定比赛的名次。
*/
/*int main(){
	for (int A = 1; A <= 5; ++A){
		for (int B = 1; B <= 5;++B){
			for (int C = 1;C<= 5;++C){
				for (int D = 1; D <= 5; ++D){
					for (int E = 1;E <= 5; ++E){
						if (((B==2)+(A==3)==1)&&((B==2)+(E==4)==1)&&((C==1)+(D==2)==1)&&((C==5)+(D==3)==1)&&((E==4)+(A==1)==1)&&A*B*C*D*E==120){
							printf("A=%d B=%d C=%d D=%d E=%d\n",A,B,C,D,E);
							break;
						}
					}
				}
			}
		}
	}
	system("pause");
	return 0;
}*/
int main(){
	/*int a = 0x12345678;
	char *p = (char*)&a;
	printf("%x\n", *p);*/
	float a = 10.5f;
	system("pause");
	return 0;
}