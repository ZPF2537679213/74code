开发一个坐标计算工具， A表示向左移动，D表示向右移动，W表示向上移动，S表示向下移动。从（0,0）点开始移动，从输入字符串里面读取一些坐标，并将最终输入结果输出到输出文件里面。

输入：

合法坐标为A(或者D或者W或者S) + 数字（两位以内）

坐标之间以;分隔。

非法坐标点需要进行丢弃。如AA10;  A1A;  $%$;  YAD; 等。

下面是一个简单的例子 如：

A10;S20;W10;D30;X;A1A;B10A11;;A10;

处理过程：

起点（0,0）

+   A10   =  （-10,0）

+   S20   =  (-10,-20)

+   W10  =  (-10,-10)

+   D30  =  (20,-10)

+   x    =  无效

+   A1A   =  无效

+   B10A11   =  无效

+  一个空 不影响

+   A10  =  (10,-10)

结果 （10， -10）

#include<stdio.h>
int main(){
	int x = 0, y = 0;
	char ch[5000];
	scanf("%s",ch);
	for (int i = 0; ch[i] != '\0'; ++i){
		if (ch[i] == 'A'){
			if ((ch[i + 1] >= 0 && ch[i + 1] <= '9') && (ch[i + 2] >= 0 && ch[i + 2] <= '9')){
				x = x - (ch[i + 1] - 48) * 10 - (ch[i + 2] - 48);
				if (ch[i+3] != ';'){
					x = x + (ch[i + 1] - 48) * 10 + (ch[i + 2] - 48);
				}
				i = i + 3;
			}
			else if (ch[i + 1] >= 0 && ch[i + 1] <= '9'){
				x = x - (ch[i + 1] - 48);
				if (ch[i+2] != ';'){
					x = x + (ch[i + 1] - 48);
				}
				i = i + 2;
			}
			else {
				while (ch[i] != ';'){

					i++;
				}
			}
		}
		else if (ch[i] == 'D'){
			if ((ch[i + 1] >= 0 && ch[i + 1] <= '9') && (ch[i + 2] >= 0 && ch[i + 2] <= '9')){
				x = x + (ch[i + 1] - 48) * 10 + (ch[i + 2] - 48);
				if (ch[i+3] != ';'){
					x = x - (ch[i + 1] - 48) * 10 - (ch[i + 2] - 48);
				}
				i = i + 3;
			}
			else if (ch[i + 1] >= 0 && ch[i + 1] <= '9'){
				x = x + (ch[i + 1] - 48);
				if (ch[i+2] != ';'){
					x = x - (ch[i + 1] - 48);
				}
				i = i + 2;
			}
			else {
				while (ch[i] != ';'){
					i++;
				}
			}
		}
		else if (ch[i] == 'W'){
			if ((ch[i + 1] >= 0 && ch[i + 1] <= '9') && (ch[i + 2] >= 0 && ch[i + 2] <= '9')){
				y = y + (ch[i + 1] - 48) * 10 + (ch[i + 2] - 48);
				if (ch[i+3] != ';'){
					y = y - (ch[i + 1] - 48) * 10 - (ch[i + 2] - 48);
				}
				i = i + 3;
			}
			else if (ch[i + 1] >= 0 && ch[i + 1] <= '9'){
				y = y + (ch[i + 1] - 48);
				if (ch[i+2] != ';'){
					y = y - (ch[i + 1] - 48);
				}
				i = i + 2;
			}
			else {
				while (ch[i] != ';'){
					i++;
				}
			}
		}
		else if (ch[i] == 'S'){
			if ((ch[i + 1] >= 0 && ch[i + 1] <= '9') && (ch[i + 2] >= 0 && ch[i + 2] <= '9')){
				y = y - (ch[i + 1] - 48) * 10 - (ch[i + 2] - 48);
				if (ch[i+3] != ';'){
					y = y + (ch[i + 1] - 48) * 10 + (ch[i + 2] - 48);
				}
				i = i + 3;
			}
			else if (ch[i + 1] >= 0 && ch[i + 1] <= '9'){
				y = y - (ch[i + 1] - 48);
				if (ch[i+2] != ';'){
					y = y + (ch[i + 1] - 48);
				}
				i = i + 2;
			}
			else {
				while (ch[i] != ';'){
					i++;
				}
			}
		}
		else{
			while (ch[i] != ';'){
				i++;
			}
		}
	}
	printf("%d,%d\n",x,y);
	return 0;
}