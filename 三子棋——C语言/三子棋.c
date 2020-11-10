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
//*************************菜单*****************************
void menu(){
	printf("*******************************************************************\n");
	printf("*****                       三子棋                            *****\n");
	printf("*****                      1.开始                             *****\n");
	printf("*****                      2.玩法                             *****\n");
	printf("*****                      0.退出                             *****\n");
	printf("*******************************************************************\n");
}
//背景
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
//初始化
void Clean(char Word[][3], int cow, int col){
	for (int i = 0; i < cow;++i){
		for (int j = 0; j < col;++j){
			Word[i][j] = ' ';
		}
	}
}
//玩家操作
void User(char Word[][3],int cow,int col){
	printf("*********************玩家操作***********************\n");
	printf("****************请输入玩家操作位置1-3***************");
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
			printf("输入格式错误\n");
		}
	}
}
//电脑操作
void Computer(char Word[][3], int cow, int col){
	printf("******************电脑操作******************\n");
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
//判赢
char Win(char Word[][3], int cow, int col){
	//行相同
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
//游戏开始
void Start(char Word[][3]){
	Show(Word, 3, 3);
	while (1){
		User(Word,3,3);
		Show(Word, 3, 3);
		Computer(Word, 3, 3);
		Show(Word, 3, 3);
		if (Win(Word, 3, 3)=='X'){
			printf("***************玩家赢了，电脑你不行*******************\n");
			break;
		}
		else if (Win(Word, 3, 3) == 'O'){
			printf("***************电脑赢了，你比人机还人机***************\n");
			break;
		}
		else if (Win(Word, 3, 3) == 'Q'){
			printf("*********************凑合吧***************************\n");
			break;
		}
		else {
			printf("*************************继续*************************\n");
		}
	}
}
//游戏说明
void PlayWay(){
	printf("******开始游戏后，玩家可以输入相应位坐标，坐标范围为1-3，玩家为X，电脑为O******\n");
}
int main(){
	srand(time(NULL));
	char Word[3][3];
	Clean(Word, 3, 3);
	int input = 0;
	do{
		menu();
		printf("********输入1开始游戏，输入2查看玩法，输入0退出游戏********\n");
		printf("********请输入你的操作:");
		scanf("%d",&input);
		switch (input){
		case 1:
			printf("*************开始游戏***************\n");
			Start(Word);
			break;
		case 2:
			PlayWay();
			break;
		case 0:
			printf("**************退回主菜单*************\n");
			break;
		}
	} while (input);
	system("pause");
	return 0;
}