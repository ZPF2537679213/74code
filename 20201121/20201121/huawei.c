#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>
/*
����������������Sudoku����һ�����ϲ���������߼���Ϸ�������Ҫ����9X9�����ϵ���֪���֣����������ʣ��ո�����֣���������ÿ
һ�С�ÿһ�С�ÿһ�����߹��ڵ����־���1-9�����Ҳ��ظ���
���룺
������֪���ֵ�9X9��������[��ȱλ������0��ʾ]
�����
������9X9��������
��������:
������֪���ֵ�9X9��������[��ȱλ������0��ʾ]
�������:
������9X9��������
ʾ��1
����
0 9 2 4 8 1 7 6 3
4 1 3 7 6 2 9 8 5
8 6 7 3 5 9 4 1 2
6 2 4 1 9 5 3 7 8
7 5 9 8 4 3 1 2 6
1 3 8 6 2 7 5 9 4
2 7 1 5 3 8 6 4 9
3 8 6 9 1 4 2 5 7
0 4 5 2 7 6 8 3 1
���
5 9 2 4 8 1 7 6 3
4 1 3 7 6 2 9 8 5
8 6 7 3 5 9 4 1 2
6 2 4 1 9 5 3 7 8
7 5 9 8 4 3 1 2 6
1 3 8 6 2 7 5 9 4
2 7 1 5 3 8 6 4 9
3 8 6 9 1 4 2 5 7
9 4 5 2 7 6 8 3 1
*/
void NineXNine(){
	int flag;
	int num[9][9];
	for (int i = 0; i < 9; ++i){
		for (int j = 0; j < 9; ++j){
			scanf("%d", &num[i][j]);
		}
	}
	do{
		flag = 0;
		for (int i = 0; i < 9; ++i){
			int anl = 0;
			int number = 0;
			int flag1, flag2;
			for (int j = 0; j < 9; ++j){
				if (num[i][j] != 0){
					anl = anl + num[i][j];
				}
				else{
					number++;
					flag1 = i;
					flag2 = j;
				}
			}
			if (number == 1){
				num[flag1][flag2] = 45 - anl;
				flag = 1;
			}
		}
		for (int i = 0; i < 9; ++i){
			int anl = 0;
			int number = 0;
			int flag1, flag2;
			for (int j = 0; j < 9; ++j){
				if (num[j][i] != 0){
					anl = anl + num[j][i];
				}
				else{
					number++;
					flag1 = j;
					flag2 = i;
				}
			}
			if (number == 1){
				num[flag1][flag2] = 45 - anl;
				flag = 1;
			}
		}
	} while (flag);
	for (int i = 0; i < 9;++i){
		for (int j = 0; j < 9;++j){
			printf("%d ",num[i][j]);
		}
		printf("\n");
	}
}
int main(){
	NineXNine();
	system("pause");
	return 0;
}