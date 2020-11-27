#pragma once
#define _CRT_SECURE_NO_WARNINGS 1
#define MAX_SIZE 1000
#include<stdio.h>
#include<windows.h>
#include<string.h>
#include<assert.h>
#include<stdlib.h>
typedef struct Information{
	char name[10];
	char sex[3];
	short age;
	char num[12];
	char addr[20];
}Information;
typedef struct TXL{
	Information *Person;
	short number;
}TXL;
void menu();
void PerAgain(TXL *P);
void AddPer(TXL *P);
int PSer(TXL *P);
void Deleted(TXL *P);
void Exchange(TXL *P);
void Show(TXL *P);
void Clock(TXL *P);
int MyCmp(void*str1, void *str2);
void Sort(TXL *P);
void STXL();