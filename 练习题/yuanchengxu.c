输入一个十六进制的数值字符串。(进制转换)
#include<stdio.h>
#include<string.h>
#include<math.h>
int Ox_D(char ch[]){
	int ten = 0;
	for (int i = strlen(ch) - 1,j=0;ch[i]!='x';--i,++j){
		if (ch[i] >= '0'&&ch[i] <= '9'){
			ten = ten + (ch[i] - 48)*(int)pow(16, j);//字符型数字和十进制数差值为48
		}
		else if (ch[i]=='A'||ch[i]=='a'){
			ten = ten + 10*(int)pow(16, j);
		}
		else if (ch[i] == 'B' || ch[i] == 'b'){
			ten = ten + 11 * (int)pow(16, j);
		}
		else if (ch[i] == 'C' || ch[i] == 'c'){
			ten = ten + 12 * (int)pow(16, j);
		}
		else if (ch[i] == 'D' || ch[i] == 'd'){
			ten = ten + 13 * (int)pow(16, j);
		}
		else if (ch[i] == 'E' || ch[i] == 'e'){
			ten = ten + 14 * (int)pow(16, j);
		}
		else {
			ten = ten + 15 * (int)pow(16, j);
		}
	}
	return ten;
}
int main(){
		char ch[5000];
		while (scanf("%s", ch) != EOF){
			printf("%d\n", Ox_D(ch));
		}
	return 0;
}