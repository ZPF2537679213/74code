#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<string.h>
#include<windows.h>
/*
Catcher��MCA�����鱨Ա��������ʱ���ֵй�����һЩ�ԳƵ��������ͨ�ţ���������ЩABBA��ABA��A��123321������������ʱ���ڿ�ʼ��
����ʱ����һЩ�޹ص��ַ��Է�ֹ����ƽ⡣����������б仯 ABBA->12ABBA,ABA->ABAKK,123321->51233214������Ϊ�ػ�Ĵ�̫���ˣ�
���Ҵ��ڶ��ֿ��ܵ������abaaab�ɿ�����aba,��baaab�ļ�����ʽ��.���⺬�ж����������롣
��������:
����һ���ַ���
�������:
������Ч���봮����󳤶�
����
ABBA
���
4
*/
int StrPassWord(char *p,int len){
	int pass = 0;
	int i, j;
	for (i = 0; i < len;++i){
		for (j = i + 1; j < len&&*(p+i)!=*(p+j);++j){}
		int start = i+1;
		int end = j-1;
		int flag = 1;
		while (end>start&&flag!=0){
			if (*(p+start)!=*(p+end)){
				flag = 0;
			}
			end--;
			start++;
		}
		if (j == len&&*(p + i) != *(p + j)){}
		else{
			if (flag==1&&pass < j - i + 1){
				pass = j - i + 1;
			}
		}
	}
	return pass;
}
int main(){
	char str[50000];
	scanf("%s",str);
	printf("%d\n",StrPassWord(str,strlen(str)));
	system("pause");
	return 0;
}
//���룺
/*
dsuehgfqxzrnkmtmiwytshrerjfybxirufrsobkjeghiunftxyqqcyoreevvktxgvjjqzvcujsynsrlgllebyukyxgugrvkesovfhzdznstvtbblmjcngwsdrmf
czsihiblqhkfvhzylwopepfmnixeesvugyifdxvpcknpqunolpgjehoxgylnzoggqpbdkhrngchidhfdktblrifjvppttemmplzrsbjhltvwprhkigkvfkxcxfs
gyiyuuziqurgcmddqshenindtrfzlrqpfpekfosmugpwjgydtbwexcwrvdedposftffjrfeojsqpxtoguroojsgrwpyiyhurprcfsgnnykjtrjjzdswfqfwuohp
cssgjzyikruvomeggqzyslmfurgnmhyvnksktvdcidvutrrxzixbxiypbvozgnmopfjiljggqrronwkfqvlpdwhtzfpsokfbvftyxdinknsrjlxbzyfmsinegpr
bnuezqlikgsbbixfdjtsjxojqwxdrvwfflrwjsnpcxqvfpmbidyvvlcnvvvvbglhhmkpuzhosfitgzclicpzsvozsbtvtlmjffqieosliqysgyxmceytmezfbtk
cprfomftlkyortyfmykslfdmxzfeetmzxbuvoorpwmkerujcjcuuyvmpqidrrksrtmxhqoqdyvjgvcftbhywmbdfoixecfgorpxoxbqlhbnynwflbodsdqvwwoi
zdfyczefvonoczocvtbixehcvpmimyxgzddvomklofuthtytqougojqwmxvhzpmvtfsjwrgmxuoeizmnfptssolqbmnrhfjitoqxizflyoddgjlxknumclfmpmr
zpomrqqogvmwgclpquhuqbkriyjkwcusetkyxozomcrsuyfmsddwubkiyyjoeqlzjsfnwkhdpgxkeicbivlwbdvcbvdqbyxuwdolmtxzgpogtzctlcjemoxdrbr
mmtkuuidtiebckmqluiszgichpmgbsxdiurxdgkvvufyihcjejgwwepswxmjducltnxngtylgiqcvxldeebykysdgwokcupxmjnbiqlzovnocuesodotqivceqh
imuhtromxxullejgzhzevzvtdhbfhcwbdivgslkfmudzofbmeeqixuprbsyrelcgvvkbtkgckezrrisnnkwwchcfwlqdoucccqinjplgwlqcylqojstlvdjmcj
yqjsqwrvxjmujcuzirinocnnwszxjnyszncytltbusmcsxustpxeuxgmwlixnjnigsxnollfbpqrwohbshbohhnpsvenvgreqfwqypkkibenvgjcwmumwcgeheh
iyediindvppefciihjkcnzvelorusllpbexivekbflpyqpefpjlumctorwejnefenhrlfugnkywvwuvrdrxsxjksgowxholmpjfyjcksmhwpcpjcodwzmolzgkc
jxmiqxdpewlyjilcbbwyxmxhqvsxkepiwdvmfxdceiswscupzpmhvmyciyosxuwnmjxnkdhhnquxsmekmcwgcklxzhhqxkebqcvxpsqzuoxikverbskrwvewome
mysgcmrdnzgufysnoxuerrqcufevwwumrvbowvvkjuediygphwgwgdrpbgreytkmgcmzonbyxwkolywjcigvyqqhwsjmtkvvhbtuhctcigvfnkkffvsjrjiumlo
wlwvsbuopmsfcqrxlpprtmswlkdmkoxewhtfkzzoohdbutqccmzsscjdozeeecdqmugcrqqfjingovwfmvnltdfcmrofcftnoozquguyyzdxqqgwbdpotbquhok
orykpurvwbvcwdnmzgimuzjipikdtvhstsgeykmunxvbszjmbgwhiymumfmlhennthtjwspxvqrelkhwqxjrzbkqbobfetlejvdhzpmwreqfhnupgovixdemmng
zorgfooiruhjbjmvwgmzrvjgrwouxugmysbrdtdujjeffomribgqkhjohitgonqevcweedmleexqjgtywpwbwmoltxbdkiyvgrykhbesgckhvecyvcjryqbhstw
rcloqmoivrmkkimzwbywumxfrzyterxmwpqcullcvebkflwmbbexqifohjrrgsnbsqhlxkwkuhwocmjfrhyfkqpqlbvxokbvbufqffclzlnlszcimzucrsrohld
xeohdiktubdrvkzvgvhnrkeenmhcvujlxlpcyhohumnuxmswwfwyhuyqhurvcrvmnkgsyygunrvpbvdmpetuixhwtnswhmgtuunzybkyosezpzttrzcdukbtmxx
eschlkjgqgrnhvixqbcusimvwdceedhhbbbrxefvztdcfdtzglhmzfthlmc
*/
//�����7