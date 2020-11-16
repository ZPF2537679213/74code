#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
#include<windows.h>
//密码要求:
//1.长度超过8位
//2.包括大小写字母.数字.其它符号, 以上四种至少三种
//3.不能有相同长度大于2的子串重复
/*
输入描述:
一组或多组长度超过2的子符串。每组占一行
输出描述:
如果符合要求输出：OK，否则输出NG
*/
/*int main(){
	char pw[1000][100];
	int num[1000] = { 0 };
	int i = 0;
	while (scanf("%s", pw[i]) != EOF){
		int n = 0;
		int w = 0;
		int W = 0;
		int It = 0;
		for (int j = 0; pw[i][j] != '\0'; ++j){
			if (pw[i][j] >= '0'&&pw[i][j] <= '9'){
				n++;
			}
			else if (pw[i][j] >= 'a'&&pw[i][j] <= 'z'){
				w++;
			}
			else if (pw[i][j] >= 'A'&&pw[i][j] <= 'Z'){
				W++;
			}
			else{
				It++;
			}
		}
		if (strlen(pw[i])>8 && ((n == 0 && w != 0 && W != 0 && It != 0) || (w == 0 && n != 0 && W != 0 && It != 0) || (W == 0 && w != 0 && n != 0 && It != 0) || (It == 0 && w != 0 && W != 0 && n != 0) || (n != 0 && w != 0 && W != 0 && It != 0))){
			num[i] = 1;
		}
		i++;
	}
	for (int j = 0; j < i; ++j){
		if (num[j] == 0){
			printf("NG\n");
		}
		else{
			if (j!=0){
			for (int k = 0; k < j; ++k){
				for (int g = 0; pw[k][g] != '\0'&&num[j] != 0; ++g){
					if (pw[k][g] == pw[j][g] && pw[k][g + 1] == pw[j][g + 1] && pw[k][g + 2] == pw[j][g + 2]){
						num[j] = 0;
					}
				}
				if (num[j] == 0){
					printf("NG\n");
				}
				else{
					printf("OK\n");
				}
				break;
			}
			}
			else{
				if (num[j] == 0){
					printf("NG\n");
				}
				else{
					printf("OK\n");
				}
			}
		}
	}
	system("pause");
	return 0;
}*/
/*
有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。
小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”答案是5瓶，
方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。
然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。如果小张手上有n个空汽水瓶，
最多可以换多少瓶汽水喝？
输入描述:
输入文件最多包含10组测试数据，每个数据占一行，仅包含一个正整数n（1<=n<=100），表示小张手上的空汽水瓶数。
n=0表示输入结束，你的程序不应当处理这一行。
输出描述:
对于每组测试数据，输出一行，表示最多可以喝的汽水瓶数。如果一瓶也喝不到，输出0。
*/
/*int PZ(int n){
	int p = 0;
	while (n!=1){
		p =p+n / 3;
		n = n/3 + n % 3;
		if (n==2){
			p++;
			break;
		}
	}
	return p;
}
int main(){
	int n,i=0;
	int num[10];
	while (1){
		scanf("%d",&n);
		if (n!=0){
			num[i] = PZ(n);
			i++;
		}
		else{
			break;
		}
	}
	for (int j = 0; j < i;++j){
		printf("%d\n",num[j]);
	}
	system("pause");
	return 0;
}*/
/*
题目描述
密码是我们生活中非常重要的东东，我们的那么一点不能说的秘密就全靠它了。哇哈哈. 
接下来渊子要在密码之上再加一套密码，虽然简单但也安全。
假设渊子原来一个BBS上的密码为zvbo9441987,为了方便记忆，他通过一种算法把这个密码变换成YUANzhi1987，
这个密码是他的名字和出生年份，怎么忘都忘不了，而且可以明目张胆地放在显眼的地方而不被别人知道真正的密码。
他是这么变换的，大家都知道手机上的字母：
1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0,
就这么简单，渊子把密码中出现的小写字母都变成对应的数字，数字和其他的符号都不做变换，
声明：密码中没有空格，而密码中出现的大写字母则变成小写之后往后移一位，
如：X，先变成小写，再往后移一位，不就是y了嘛，简单吧。记住，z往后移是a哦。
输入描述:
输入包括多个测试数据。输入是一个明文，密码长度不超过100个字符，输入直到文件结尾
输出描述:
输出渊子真正的密文
示例1
输入
YUANzhi1987
输出
zvbo9441987
*/
void IPassWord(char *p,int len){
	char pw[100];
	for (int i = 0; i <= len;++i){
		if (*(p + i) >= 'A'&&*(p + i) <= 'Y'){
			pw[i] = *(p + i) + 32 + 1;
		}
		else if (*(p + i) == 'Z'){
			pw[i] = 'a';
		}
		else if (*(p + i) == 'a' || *(p + i) == 'b' || *(p + i) =='c' ){
			pw[i] = '2';
		}
		else if (*(p + i) == 'd' || *(p + i) == 'e' || *(p + i) == 'f'){
			pw[i] = '3';
		}
		else if (*(p + i) == 'g' || *(p + i) == 'h' || *(p + i) == 'i'){
			pw[i] = '4';
		}
		else if (*(p + i) == 'j' || *(p + i) == 'k' || *(p + i) == 'l'){
			pw[i] = '5';
		}
		else if (*(p + i) == 'm' || *(p + i) == 'n' || *(p + i) == 'o'){
			pw[i] = '6';
		}
		else if (*(p + i) == 'p' || *(p + i) == 'q' || *(p + i) == 'r' || *(p + i) == 's'){
			pw[i] = '7';
		}
		else if (*(p + i) == 't' || *(p + i) == 'u' || *(p + i) == 'v'){
			pw[i] = '8';
		}
		else if (*(p + i) == 'w' || *(p + i) == 'x' || *(p + i) == 'y' || *(p + i) == 'z'){
			pw[i] = '9';
		}
		else{
			pw[i] = *(p+i);
		}
	}
	printf("%s\n",pw);
}
int main(){
	char P[100];
	scanf("%s",P);
	IPassWord(P,strlen(P));
	system("pause");
	return 0;
}