/*
ʵ��һ��ͨѶ¼��
ͨѶ¼���������洢1000���˵���Ϣ��ÿ���˵���Ϣ�������������Ա����䡢�绰��סַ
�ṩ������
�����ϵ����Ϣ
ɾ��ָ����ϵ����Ϣ
����ָ����ϵ����Ϣ
�޸�ָ����ϵ����Ϣ
��ʾ������ϵ����Ϣ
���������ϵ��
����������������ϵ��
*/
#include "fun.h"
//ͨѶ¼�˵�
void menu(){
	printf("**********************************ͨѶ¼***********************************\n");
	printf("******************************1.�����ϵ��.1*******************************\n");
	printf("******************************2.ɾ����ϵ��.2*******************************\n");
	printf("******************************3.������ϵ��.3*******************************\n");
	printf("******************************4.�޸���ϵ��.4*******************************\n");
	printf("******************************5.��ʾ��ϵ��.5*******************************\n");
	printf("******************************6.�����ϵ��.6*******************************\n");
	printf("******************************7.������ϵ��.7*******************************\n");
	printf("*********************************0.�˳�.0**********************************\n");
}
//��ʼ��
void PerAgain(TXL *P){
	assert(P != NULL);
	P->Person= (Information *)malloc(sizeof(Information)*MAX_SIZE);
	memset(P->Person,0,sizeof(P->Person));
	P->number = 0;
}
//�����ϵ��
void AddPer(TXL *P){
	assert(P!=NULL);
	if (P->number<=MAX_SIZE){
		printf("�������û�������");
		scanf("%s",P->Person[P->number].name);
		printf("�������û��Ա�");
		scanf("%s", P->Person[P->number].sex);
		printf("�������û����䣺");
		scanf("%d", &(P->Person[P->number].age));
		printf("�������û��绰��");
		scanf("%s", P->Person[P->number].num);
		printf("�������û���ͥסַ��");
		scanf("%s", P->Person[P->number].addr);
		printf("��ӳɹ�\n");
		P->number++;
	}
	else{
		printf("��Ա���������ʧ��\n");
	}
}
//������ϵ��
int PSer(TXL *P){
	assert(P != NULL);
	char use[10];
	printf("������Ҫ���ҵ�����������");
	scanf("%s", use);
	for (int i = 0; i < P->number; ++i){
		if (strcmp(P->Person[i].name, use) == 0){
			printf("�ҵ���Ҫ�ҵ�����\n");
			return i;
		}
	}
	printf("û�ҵ���Ҫ�ҵ���\n");
	return -1;
}
//ɾ����ϵ��
void Deleted(TXL *P){
	assert(P!=NULL);
	for (int i = PSer(P); i < (P->number - 1)&&i>=0; ++i){
		P->Person[i] = P->Person[i + 1];
	}
	P->number--;
	printf("ɾ���ɹ�\n");
}
//�޸���ϵ��
void Exchange(TXL *P){
	assert(P != NULL);
	char use[10];
	int i;
	printf("������Ҫ�޸ĵ�����������");
	scanf("%s", use);
	for (i = 0; i < P->number; ++i){
		if (strcmp(P->Person[i].name, use) == 0){
			break;
		}
	}
	printf("��Ҫȫ���޸Ļ����޸�һ�ȫ��������5��һ��������1��");
	int input,in;
	scanf("%d",&input);
	switch(input){
	case 5:
		printf("�������û�������");
		scanf("%s", P->Person[i].name);
		printf("�������û��Ա�");
		scanf("%s", P->Person[i].sex);
		printf("�������û����䣺");
		scanf("%d", &(P->Person[i].age));
		printf("�������û��绰��");
		scanf("%s", P->Person[i].num);
		printf("�������û���ͥסַ��");
		scanf("%s", P->Person[i].addr);
		printf("�޸ĳɹ�\n");
		break;
	case 1:
		printf("��������Ҫ�޸���һ�����0���Ա�1������2���绰3����ַ4��");
		scanf("%d",&in);
		switch (in){
		case 0:
			printf("�������û�������");
			scanf("%s", P->Person[i].name);
			break;
		case 1:
			printf("�������û��Ա�");
			scanf("%s", P->Person[i].sex);
			break;
		case 2:
			printf("�������û����䣺");
			scanf("%d", &(P->Person[i].age));
			break;
		case 3:
			printf("�������û��绰��");
			scanf("%s", P->Person[i].num);
			break;
		case 4:
			printf("�������û���ͥסַ��");
			scanf("%s", P->Person[i].addr);
			break;
		}
		printf("�޸ĳɹ�\n");
		break;
	default:
		printf("��ʽ����\n");
		break;
	}
}
//��ʾ��ϵ��
void Show(TXL *P){
	assert(P!=NULL);
	printf("%-10s %-10s %-10s %-10s %-10s \n","����","�Ա�","����","�绰","��ͥסַ");
	for (int i = 0; i < P->number;++i){
		printf("%-10s %-10s %-10d %-10s %-10s \n", P->Person[i].name, P->Person[i].sex, P->Person[i].age, P->Person[i].num, P->Person[i].addr);
	}
}
//�����ϵ��
void Clock(TXL *P){
	assert(P != NULL);
	P->number = 0;
}
//������ϵ��
int MyCmp(void*str1, void *str2){
	return *((char*)str1) - *((char*)str2);
}
void Sort(TXL *P){
	assert(P != NULL);
	qsort(P->Person, P->number, sizeof(Information),MyCmp);
	printf("�������\n");
}
//��ͨѶ¼
void STXL(){
	TXL P;
	PerAgain(&P);
	int inp = 0;
	do{
		menu();
		printf("��������Ĳ�����");
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
			printf("�˳��ɹ�\n");
			break;
		default:
			printf("��ʽ����\n");
			break;
		}
	} while (inp);
}