#include<stdio.h>
#include<stdlib.h>
#include<windows.h>
#include<time.h>
void Show(char Word[][3], int cow, int col);
void menu();
void Clean(char Word[][3], int cow, int col);
void User(char Word[][3], int cow, int col);
void Computer(char Word[][3], int cow, int col);
char Win(char Word[][3], int cow, int col);
void Start(char Word[][3]);
void PlayWay();
//*************************�˵�*****************************
void menu(){
	printf("*******************************************************************\n");
	printf("*****                       ������                            *****\n");
	printf("*****                      1.��ʼ                             *****\n");
	printf("*****                      2.�淨                             *****\n");
	printf("*****                      0.�˳�                             *****\n");
	printf("*******************************************************************\n");
}
//����
void Show(char Word[][3], int cow, int col){
	for (int i = 0; i < cow;++i){
		for (int j = 0; j < col;++j){
			printf(" %c ",Word[i][j]);
			if (j<col-1){
				printf("|");
			}
		}
		printf("\n");
		if (i<cow-1){
			for (int j = 0; j < col; ++j){
				printf("---");
				if (j < col - 1){
					printf("|");
				}
			}
			printf("\n");
		}
	}
	printf("\n");
}
//��ʼ��
void Clean(char Word[][3], int cow, int col){
	for (int i = 0; i < cow;++i){
		for (int j = 0; j < col;++j){
			Word[i][j] = ' ';
		}
	}
}
//��Ҳ���
void User(char Word[][3],int cow,int col){
	printf("*********************��Ҳ���***********************\n");
	printf("****************��������Ҳ���λ��1-3***************");
	int x = 0, y = 0;
	while (1){
		scanf("%d%d",&x,&y);
		if (x<=3&&y<=3&&x>=0&&y>=0){
			if (Word[x - 1][y - 1] == ' '){
				Word[x - 1][y - 1] = 'X';
				break;
			}
		}
		else{
			printf("�����ʽ����\n");
		}
	}
}
//���Բ���
void Computer(char Word[][3], int cow, int col){
	printf("******************���Բ���******************\n");
	Sleep(2000);
	int x = 0, y = 0;
	while (1){
		x = rand() % 3;
		y = rand() % 3;
		if (Word[x][y] == ' '){
			Word[x][y] = 'O';
			break;
		}
	}
}
//��Ӯ
char Win(char Word[][3], int cow, int col){
	//����ͬ
	int flag = 0;
	for (int i = 0; i < cow;++i){
		if (Word[i][0] == Word[i][1] && Word[i][1] == Word[i][2] && Word[i][0] != ' '){
			return Word[i][0];
		}
	}
	for (int j = 0; j < col;++j){
		if (Word[0][j] == Word[1][j] && Word[1][j] == Word[2][j] && Word[0][j] != ' '){
			return Word[0][j];
		}
	}
	if (Word[0][0] == Word[1][1] && Word[1][1] == Word[2][2] && Word[0][0] != ' '){
		return Word[0][0];
	}
    if (Word[0][2] == Word[1][1] && Word[1][1] == Word[2][0] && Word[0][2] != ' '){
		return Word[0][2];
	}
	for (int i = 0; i < cow;++i){
		for (int j = 0; j < col;++j){
			if (Word[i][j]==' '){
				flag++;
			}
		}
	}
	if (flag==0){
		return 'Q';
	}
	else {
		return '0';
	}
}
//��Ϸ��ʼ
void Start(char Word[][3]){
	Show(Word, 3, 3);
	while (1){
		User(Word,3,3);
		Show(Word, 3, 3);
		Computer(Word, 3, 3);
		Show(Word, 3, 3);
		if (Win(Word, 3, 3)=='X'){
			printf("***************���Ӯ�ˣ������㲻��*******************\n");
			break;
		}
		else if (Win(Word, 3, 3) == 'O'){
			printf("***************����Ӯ�ˣ�����˻����˻�***************\n");
			break;
		}
		else if (Win(Word, 3, 3) == 'Q'){
			printf("*********************�պϰ�***************************\n");
			break;
		}
		else {
			printf("*************************����*************************\n");
		}
	}
}
//��Ϸ˵��
void PlayWay(){
	printf("******��ʼ��Ϸ����ҿ���������Ӧλ���꣬���귶ΧΪ1-3�����ΪX������ΪO******\n");
}
int main(){
	srand(time(NULL));
	char Word[3][3];
	Clean(Word, 3, 3);
	int input = 0;
	do{
		menu();
		printf("********����1��ʼ��Ϸ������2�鿴�淨������0�˳���Ϸ********\n");
		printf("********��������Ĳ���:");
		scanf("%d",&input);
		switch (input){
		case 1:
			printf("*************��ʼ��Ϸ***************\n");
			Start(Word);
			break;
		case 2:
			PlayWay();
			break;
		case 0:
			printf("**************�˻����˵�*************\n");
			break;
		}
	} while (input);
	system("pause");
	return 0;
}