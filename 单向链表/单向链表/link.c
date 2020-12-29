#define _CRT_SECURE_NO_WARNING 1
#include<stdio.h>
#include<stdlib.h>
#include<assert.h>
#include<windows.h>
typedef struct Link{
	int data;
	struct Link *next;
}Link;
//以头插创建一个无表头的单项链表，特点：倒序
Link * createLink(int num[],int n){
	Link *h=NULL,*p;
	for (int i = 0; i < n;++i){
		p = (Link *)malloc(sizeof(Link));
		p->data = num[i];
		p->next = h;
		h = p;
	}
	return h;
}
//打印一个单向链表
void showLink(Link *h){
	assert(h != NULL);
	for (Link *p = h; p; p = p->next){
		printf("%d->",p->data);
	}
	printf("\n");
}
//返回中间的元素
int posLink(Link *h){
	Link *one, *two;
	int num = 0;
	for (one = two = h; two->next && two->next->next; one = one->next, two = two->next->next);
	return one->data;
}
//删除值为key的结点
Link* deleted(Link*h,int key){
	Link *p,*t;
	if (h->data==key){
		h = h->next;
	}
	else{
		for (t=p = h; p&&p->data != key; t=p,p = p->next);
		t->next = p->next;
		free(p);
		p = NULL;
	}
	return h;
}
int main(){
	int num[] = {1,2,3,4,5,6,7,8,9,10};
	Link *h = createLink(num,10);
	showLink(h);
	printf("%d\n",posLink(h));
	h = deleted(h,10);
	showLink(h);
	system("pause");
	return 0;
}