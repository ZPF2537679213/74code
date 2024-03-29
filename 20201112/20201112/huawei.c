#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<windows.h>
#define N 32000//总钱数
#define M 60//最大商品数量
/*
王强今天很开心，公司发给N元的年终奖。王强决定把年终奖用于购物，他把想买的物品分为两类：主件与附件，附件是从属于某个主件的，
下表就是一些主件与附件的例子：
主件	附件
电脑	打印机，扫描仪
书柜	图书
书桌	台灯，文具
工作椅	无
如果要买归类为附件的物品，必须先买该附件所属的主件。每个主件可以有 0 个、 1 个或 2 个附件。
附件不再有从属于自己的附件。王强想买的东西很多，为了不超出预算，他把每件物品规定了一个重要度，分为 5 等：
用整数 1 ~ 5 表示，第 5 等最重要。他还从因特网上查到了每件物品的价格（都是 10 元的整数倍）。
他希望在不超过 N 元（可以等于 N 元）的前提下，使每件物品的价格与重要度的乘积的总和最大。
设第 j 件物品的价格为 v[j] ，重要度为 w[j] ，共选中了 k 件物品，编号依次为 j 1 ， j 2 ，……， j k ，则所求的总和为：
v[j 1 ]*w[j 1 ]+v[j 2 ]*w[j 2 ]+ … +v[j k ]*w[j k ] 。（其中 * 为乘号）
请你帮助王强设计一个满足要求的购物单。
*/
int Max(int x,int y){
	return x > y ? x : y;
}
int Money(int n,int m,int v[],int p[],int q[]){
	int map[M][N] = { 0 };
	int max = 0;
	for (int i = 1; i <= m;++i){
		for (int j = 1; j <= n; ++j){
			if (q[i] != 0){
				if (j>v[q[i]]){
					max = Max(map[i - 1][j], map[i - 1][j - v[q[i]]] + v[q[i]] * p[q[i]]);
					if (max == map[i - 1][j - v[q[i]]] + v[q[i]] * p[q[i]]&&j>v[i]){
						map[i][j] = Max(map[i-1][j],map[i-1][j-v[i]]+v[i]*p[i]);
					}
					else{
						map[i][j] = max;
					}
				}
				else{
					map[i][j] = map[i-1][j];
				}
			}
			else{
				while (q[i]==0){
					i++;
				}
			}
		}
		}
	return map[m][n];
}
int main(){
	int n, m;
	int v[M] = { 0 }, p[M] = { 0 }, q[M] = {0};
	scanf("%d%d", &n, &m);
	for (int i = 1; i < m + 1; ++i){
		scanf("%d%d%d", v + i, p + i, q + i);
	}
	printf("%d\n", Money(n,m,v,p,q));
	system("pause");
	return 0;
}