��˵��һֻ���ܣ������������̨�ף�����n��̨�ף��ж���������
#include<stdio.h>
int TaiJie(int T){
	if (T==1){
		return 1;
	}
	else{
		return 2 * TaiJie(T-1);
	}
}
int main(){
	printf("%d\n",TaiJie(3));//����̨��
	return 0;
}