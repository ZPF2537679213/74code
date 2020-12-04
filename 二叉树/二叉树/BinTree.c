#define _CRT_SECURE_NO_WARNINGS 1
#include <stdio.h>
#include<stdlib.h>
#include<assert.h>
#include<windows.h>
typedef struct BinaryTree{
	int data;
	struct BinaryTree *left, *right;
}BT;
BT *CreatBT(int *num,int n){
	assert(num!=NULL);
	BT *r=NULL, *p;
	BT *q, *qa;//��ָ������,qa��Զ��q��˫�׽��
	for (int i = 0; i < n;++i){
		p = (BT*)malloc(sizeof(BT));
		p->data = num[i];
		p->left = NULL;
		p->right = NULL;
		if (!r){
			r = p;
		}
		else{
			q =qa= r;
			while (q){
				qa = q;
				if (p->data>q->data){
					q = q->right;
				}
				else{
					q = q->left;
				}
			}
			if (qa->data>p->data){
				qa->left = p;
			}
			else{
				qa->right = p;
			}
		}
	}
	return r;
}
void Show(BT *r){//ǰ�����������
	if (!r){
		return;
	}
	printf("%d->",r->data);
	Show(r->left);
	Show(r->right);
}
int main(void){
	int n;
	printf("���������ݳ��ȣ�");
	scanf("%d",&n);
	int *num;
	num = (int *)malloc(n*sizeof(int));
	printf("���������ݣ�");
	for (int i = 0; i < n;++i){
		scanf("%d",num+i);
	}
	Show(CreatBT(num, n));
	free(num);
	num = NULL;
	system("pause");
	return 0;
}