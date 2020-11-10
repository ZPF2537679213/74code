#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#include<windows.h>
void menu();
void Clean(char Board[][10], int cow, int col);
void Show(char Board[][10], int cow, int col);
void CreatLei(char Board[][10], int cow, int col);
void User(char Board[][10], int cow, int col);
void Start(char Board[][10]);
void Help();
//菜单
void menu(){
	printf("***************************************************************\n");
	printf("********************         扫雷         *********************\n");
	printf("********************        1开始1        *********************\n");
	printf("********************        2帮助2        *********************\n");
	printf("********************        0退出0        *********************\n");
	printf("***************************************************************\n");
}
//初始化
void Clean(char Board[][10],int cow,int col){
	for (int i = 0; i < cow;++i){
		for (int j = 0; j < col;++j){
			Board[i][j] = ' ';
		}
	}
}
//生成10个地雷
void CreatLei(char Board[][10], int cow, int col){
	int x=0, y=0;
	for (int i = 1; i < 11;++i){
		x = rand() % 10;
		y = rand() % 10;
		Board[x][y] = '*';
	}
}
//显示背景
void Show(char Board[][10], int cow, int col){
	for (int i = 0; i <= cow;++i){
		for (int j = 0; j <= col;++j){
			if (j<col){
				printf("——");
			}
		}
		printf("\n");
		if (i<cow){
			for (int j = 0; j <= col; ++j){
				printf("|");
				if (j < col){
					if (Board[i][j]=='*'){
						printf("   ");
					}
					else {
						printf(" %c ",Board[i][j]);
					}
				}
			}
		}
		printf("\n");
	}
}
//玩家操作
void User(char Board[][10], int cow, int col){
	int x, y,flag,n=0;
	char arr[10][10] = {' '};
	for (int i = 0; i < cow;++i){
		for (int j = 0; j < col;++j){
			if (Board[i][j]=='*'){
				arr[i][j] = '*';
			}
		}
	}
	while (1){
		char num = '0';
		Show(Board, 10, 10);
		printf("*************请玩家选定排雷坐标1-10*************\n");
		scanf("%d%d", &x, &y);
		printf("******是否标记该坐标点？是输1，不是输0******\n");
		scanf("%d",&flag);
		if (flag==0){
			if (arr[x - 1][y - 1] == '*'){
				printf("***************你踩到地雷了！*****************\n");
				break;
			}
			else{
				for (int i = x - 2; i <= x; ++i){
					for (int j = y - 2; j <= y; ++j){
						if (arr[i][j] == '*'){
							num++;
						}
					}
				}
					Board[x - 1][y - 1] = num;
			}
		}
		else{
			Board[x - 1][y - 1] = '?';
			if (arr[x-1][y-1]=='*'){
				n++;
			}
		}
		if (n==10){
			printf("*************恭喜你，你已经排除所有地雷！************\n");
			break;
		}
	}
}
//游戏开始
void Start(char Board[][10]){
	printf("******************游戏开始**********************");
	Clean(Board, 10, 10);
	CreatLei(Board, 10,10);
	User(Board,10,10);
}
//游戏帮助
void Help(){
	printf("********************************************************************************\n");
	printf("*先输入坐标位置，然后要标记，则输入1，否则输入0，标记后的位置为一个‘？’标识的*\n");
	printf("*图形，你的目标是排除所有雷，当你不选择标记时，会提示你以当前坐标为中心，周围八*\n");
	printf("********************位置中有几个地雷，前提是，你不能踩上!***********************\n");
	printf("********************************************************************************\n");
}
int main(){
	int input = 0;
	char Board[10][10];
	srand(time(NULL));
	menu();
	printf("你玩吗？玩输入1，查看帮助输入2，退出输入0:");
	scanf("%d", &input);
	do{
		menu();
		switch (input){
		case 1:	Start(Board); break;
		case 2: Help(); break;
		case 0:printf("******************退出到主菜单******************\n"); break;
		default:printf("*******************格式错误********************\n"); break;
		}
		printf("你还玩吗？玩输入1，查看帮助输入2，退出输入0:");
		scanf("%d", &input);
	} while (input);
	system("pause");
	return 0;
}