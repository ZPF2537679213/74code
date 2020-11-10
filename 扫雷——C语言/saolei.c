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
//�˵�
void menu(){
	printf("***************************************************************\n");
	printf("********************         ɨ��         *********************\n");
	printf("********************        1��ʼ1        *********************\n");
	printf("********************        2����2        *********************\n");
	printf("********************        0�˳�0        *********************\n");
	printf("***************************************************************\n");
}
//��ʼ��
void Clean(char Board[][10],int cow,int col){
	for (int i = 0; i < cow;++i){
		for (int j = 0; j < col;++j){
			Board[i][j] = ' ';
		}
	}
}
//����10������
void CreatLei(char Board[][10], int cow, int col){
	int x=0, y=0;
	for (int i = 1; i < 11;++i){
		x = rand() % 10;
		y = rand() % 10;
		Board[x][y] = '*';
	}
}
//��ʾ����
void Show(char Board[][10], int cow, int col){
	for (int i = 0; i <= cow;++i){
		for (int j = 0; j <= col;++j){
			if (j<col){
				printf("����");
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
//��Ҳ���
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
		printf("*************�����ѡ����������1-10*************\n");
		scanf("%d%d", &x, &y);
		printf("******�Ƿ��Ǹ�����㣿����1��������0******\n");
		scanf("%d",&flag);
		if (flag==0){
			if (arr[x - 1][y - 1] == '*'){
				printf("***************��ȵ������ˣ�*****************\n");
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
			printf("*************��ϲ�㣬���Ѿ��ų����е��ף�************\n");
			break;
		}
	}
}
//��Ϸ��ʼ
void Start(char Board[][10]){
	printf("******************��Ϸ��ʼ**********************");
	Clean(Board, 10, 10);
	CreatLei(Board, 10,10);
	User(Board,10,10);
}
//��Ϸ����
void Help(){
	printf("********************************************************************************\n");
	printf("*����������λ�ã�Ȼ��Ҫ��ǣ�������1����������0����Ǻ��λ��Ϊһ����������ʶ��*\n");
	printf("*ͼ�Σ����Ŀ�����ų������ף����㲻ѡ����ʱ������ʾ���Ե�ǰ����Ϊ���ģ���Χ��*\n");
	printf("********************λ�����м������ף�ǰ���ǣ��㲻�ܲ���!***********************\n");
	printf("********************************************************************************\n");
}
int main(){
	int input = 0;
	char Board[10][10];
	srand(time(NULL));
	menu();
	printf("������������1���鿴��������2���˳�����0:");
	scanf("%d", &input);
	do{
		menu();
		switch (input){
		case 1:	Start(Board); break;
		case 2: Help(); break;
		case 0:printf("******************�˳������˵�******************\n"); break;
		default:printf("*******************��ʽ����********************\n"); break;
		}
		printf("�㻹����������1���鿴��������2���˳�����0:");
		scanf("%d", &input);
	} while (input);
	system("pause");
	return 0;
}