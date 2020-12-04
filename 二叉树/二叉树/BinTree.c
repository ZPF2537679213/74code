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
	BT *q, *qa;//两指针联动,qa永远在q的双亲结点
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
void Show(BT *r){//前序遍历二叉树
	if (!r){
		return;
	}
	printf("%d->",r->data);
	Show(r->left);
	Show(r->right);
}
int main(void){
	int n;
	printf("请输入数据长度：");
	scanf("%d",&n);
	int *num;
	num = (int *)malloc(n*sizeof(int));
	printf("请输入数据：");
	for (int i = 0; i < n;++i){
		scanf("%d",num+i);
	}
	Show(CreatBT(num, n));
	free(num);
	num = NULL;
	system("pause");
	return 0;
}