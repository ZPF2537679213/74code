#include<stdio.h>
void print(char pos1,char pos2){
	printf("%c->%c ",pos1,pos2);
}
void HanNuo(int p,char pos1,char pos2,char pos3){
	if (p==1){
		print(pos1,pos3);
	}
	else{
		HanNuo(p-1,pos1,pos3,pos2);
		print(pos1,pos3);
		HanNuo(p-1,pos2,pos1,pos3);
	}
}
int main(){
	char pos1 = 'A', pos2 = 'B', pos3 = 'C';
	HanNuo(3,pos1,pos2,pos3);//Ҫ���ٸ������Լ�������������3������������Խ����Խ�Ӵ�
	return 0;
}
�����������ӵ����н��Ϊ��A->C A->B C->B A->C B->A B->C A->C