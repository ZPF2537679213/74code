#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>
//����Ļ�ϴ�ӡ������ǡ�
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
�ձ�ĳ�ط�����һ��ıɱ��������ͨ���Ų�ȷ��ɱ�����ֱ�Ϊ4�����ɷ���һ����
����Ϊ4�����ɷ��Ĺ���:
A˵�������ҡ�
B˵����C��
C˵����D��
D˵��C�ں�˵
��֪3����˵���滰��1����˵���Ǽٻ���
�����������Щ��Ϣ��дһ��������ȷ������˭�����֡�
*/
/*int main(){
	char XS = 'A';//��Ĭ��������A
	for (;XS<='D';XS++){
		if ((XS!='A')+(XS=='C')+(XS=='D')+(XS!='D')==3){//����������������ʱ��Ϊ����
			break;
		}
	}
	printf("������%c\n",XS);
	system("pause");
	return 0;
}*/

/*
5λ�˶�Ա�μ���10��̨��ˮ����������������Ԥ����������
Aѡ��˵��B�ڶ����ҵ�����
Bѡ��˵���ҵڶ���E���ģ�
Cѡ��˵���ҵ�һ��D�ڶ���
Dѡ��˵��C����ҵ�����
Eѡ��˵���ҵ��ģ�A��һ��
����������ÿλѡ�ֶ�˵����һ�룬����ȷ�����������Ρ�
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