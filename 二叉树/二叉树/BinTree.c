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
void Show1(BT *r){//递归前序遍历二叉树
	if (!r){
		return;
	}
	printf("%d->",r->data);
	Show1(r->left);
	Show1(r->right);
}
void fShow1(BT *r){//非递归前序遍历二叉树
	assert(r!=NULL);
	BT* statck[1024],*node;
	int top = -1;
	statck[++top] = r;
	while (top>-1){
		node = statck[top--];
		printf("%d->",node->data);
		if (node->right!=NULL){
			statck[++top] = node->right;
		}
		if (node->left!=NULL){
			statck[++top] = node->left;
		}
	}
	printf("\n");
}
void Show2(BT*r){//中序递归
	if (r==NULL){
		return;
	}
	else{
		Show2(r->left);
		printf("%d->",r->data);
		Show2(r->right);
	}
}
void fShow2(BT*r){//中序非递归
	assert(r!=NULL);
	BT*statck[1024],*node;
	int top = -1;
	node = r;
	while (top>-1||node!=NULL){
		while(node!=NULL){
			statck[++top] = node;
			node = node->left;
		}
		node = statck[top--];
		printf("%d->",node->data);
			node = node->right;
	}
	printf("\n");
}
void Show3(BT*r){//后序遍历递归
	if (r==NULL){
		return;
	}
	else{
		Show3(r->left);
		Show3(r->right);
		printf("%d->",r->data);
	}
}
void fShow3(BT*r){//后序遍历非递归
	assert(r!=NULL);
	BT*statck[1024], *node;
	int top = -1;
	node = r;
	while (top > -1||node!=NULL){
		while (node!=NULL){
			statck[++top] = node;
			node = node->right;
		}
		node = statck[top--];
		printf("%d->",node->data);
		node = node->left;
	}
	printf("\n");
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
	printf("前序递归：");
	Show1(CreatBT(num, n));
	printf("\n");
	printf("前序非递归：");
	fShow1(CreatBT(num, n));
	printf("中序递归：");
	Show2(CreatBT(num, n));
	printf("\n");
	printf("中序非递归：");
	fShow2(CreatBT(num, n));
	printf("后序递归：");
	Show3(CreatBT(num, n));
	printf("\n");
	printf("后序非递归：");
	fShow3(CreatBT(num, n));
	free(num);
	num = NULL;
	system("pause");
	return 0;
}