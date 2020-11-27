/*
实现一个通讯录；
通讯录可以用来存储1000个人的信息，每个人的信息包括：姓名、性别、年龄、电话、住址
提供方法：
添加联系人信息
删除指定联系人信息
查找指定联系人信息
修改指定联系人信息
显示所有联系人信息
清空所有联系人
以名字排序所有联系人
*/
#include "fun.h"
//通讯录菜单
void menu(){
	printf("**********************************通讯录***********************************\n");
	printf("******************************1.添加联系人.1*******************************\n");
	printf("******************************2.删除联系人.2*******************************\n");
	printf("******************************3.查找联系人.3*******************************\n");
	printf("******************************4.修改联系人.4*******************************\n");
	printf("******************************5.显示联系人.5*******************************\n");
	printf("******************************6.清空联系人.6*******************************\n");
	printf("******************************7.排序联系人.7*******************************\n");
	printf("*********************************0.退出.0**********************************\n");
}
//初始化
void PerAgain(TXL *P){
	assert(P != NULL);
	P->Person= (Information *)malloc(sizeof(Information)*MAX_SIZE);
	memset(P->Person,0,sizeof(P->Person));
	P->number = 0;
}
//添加联系人
void AddPer(TXL *P){
	assert(P!=NULL);
	if (P->number<=MAX_SIZE){
		printf("请输入用户姓名：");
		scanf("%s",P->Person[P->number].name);
		printf("请输入用户性别：");
		scanf("%s", P->Person[P->number].sex);
		printf("请输入用户年龄：");
		scanf("%d", &(P->Person[P->number].age));
		printf("请输入用户电话：");
		scanf("%s", P->Person[P->number].num);
		printf("请输入用户家庭住址：");
		scanf("%s", P->Person[P->number].addr);
		printf("添加成功\n");
		P->number++;
	}
	else{
		printf("人员已满，添加失败\n");
	}
}
//查找联系人
int PSer(TXL *P){
	assert(P != NULL);
	char use[10];
	printf("请输入要查找的人物姓名：");
	scanf("%s", use);
	for (int i = 0; i < P->number; ++i){
		if (strcmp(P->Person[i].name, use) == 0){
			printf("找到你要找的人了\n");
			return i;
		}
	}
	printf("没找到你要找的人\n");
	return -1;
}
//删除联系人
void Deleted(TXL *P){
	assert(P!=NULL);
	for (int i = PSer(P); i < (P->number - 1)&&i>=0; ++i){
		P->Person[i] = P->Person[i + 1];
	}
	P->number--;
	printf("删除成功\n");
}
//修改联系人
void Exchange(TXL *P){
	assert(P != NULL);
	char use[10];
	int i;
	printf("请输入要修改的人物姓名：");
	scanf("%s", use);
	for (i = 0; i < P->number; ++i){
		if (strcmp(P->Person[i].name, use) == 0){
			break;
		}
	}
	printf("你要全部修改还是修改一项，全部请输入5，一个请输入1：");
	int input,in;
	scanf("%d",&input);
	switch(input){
	case 5:
		printf("请输入用户姓名：");
		scanf("%s", P->Person[i].name);
		printf("请输入用户性别：");
		scanf("%s", P->Person[i].sex);
		printf("请输入用户年龄：");
		scanf("%d", &(P->Person[i].age));
		printf("请输入用户电话：");
		scanf("%s", P->Person[i].num);
		printf("请输入用户家庭住址：");
		scanf("%s", P->Person[i].addr);
		printf("修改成功\n");
		break;
	case 1:
		printf("请输入你要修改哪一项，姓名0，性别1，年龄2，电话3，地址4：");
		scanf("%d",&in);
		switch (in){
		case 0:
			printf("请输入用户姓名：");
			scanf("%s", P->Person[i].name);
			break;
		case 1:
			printf("请输入用户性别：");
			scanf("%s", P->Person[i].sex);
			break;
		case 2:
			printf("请输入用户年龄：");
			scanf("%d", &(P->Person[i].age));
			break;
		case 3:
			printf("请输入用户电话：");
			scanf("%s", P->Person[i].num);
			break;
		case 4:
			printf("请输入用户家庭住址：");
			scanf("%s", P->Person[i].addr);
			break;
		}
		printf("修改成功\n");
		break;
	default:
		printf("格式错误\n");
		break;
	}
}
//显示联系人
void Show(TXL *P){
	assert(P!=NULL);
	printf("%-10s %-10s %-10s %-10s %-10s \n","姓名","性别","年龄","电话","家庭住址");
	for (int i = 0; i < P->number;++i){
		printf("%-10s %-10s %-10d %-10s %-10s \n", P->Person[i].name, P->Person[i].sex, P->Person[i].age, P->Person[i].num, P->Person[i].addr);
	}
}
//清空联系人
void Clock(TXL *P){
	assert(P != NULL);
	P->number = 0;
}
//排序联系人
int MyCmp(void*str1, void *str2){
	return *((char*)str1) - *((char*)str2);
}
void Sort(TXL *P){
	assert(P != NULL);
	qsort(P->Person, P->number, sizeof(Information),MyCmp);
	printf("排序完成\n");
}
//打开通讯录
void STXL(){
	TXL P;
	PerAgain(&P);
	int inp = 0;
	do{
		menu();
		printf("请输入你的操作：");
		scanf("%d",&inp);
		switch (inp){
		case 1:
			AddPer(&P);
			break;
		case 2:
			Deleted(&P);
			break;
		case 3:
			PSer(&P);
			break;
		case 4:
			Exchange(&P);
			break;
		case 5:
			Show(&P);
			break;
		case 6:
			Clock(&P);
			break;
		case 7:
			Sort(&P);
			break;
		case 0:
			printf("退出成功\n");
			break;
		default:
			printf("格式错误\n");
			break;
		}
	} while (inp);
}