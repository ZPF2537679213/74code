import java.util.Arrays;

/**
 * @author:飞哥
 * @date: 2021/4/16 15:53
 */
public class Main {
    public static void main(String[] args) {

    }
}
class Test {

    public int aMethod(){
       int i = 0;
        i++;
        return i;
    }
    public static void main(String args[]){
        Test test = new Test();
        test.aMethod();
        int j = test.aMethod();
        System.out.println(j);
    }
}
/*
* 小力将 N 个零件的报价存于数组 nums。小力预算为 target，假定小力仅购买两个零件，要求购买零件的花费不超过预算，请问他有多少种采购方案。
注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
示例 1：
输入：nums = [2,5,3,5], target = 6
输出：1
解释：预算内仅能购买 nums[0] 与 nums[2]。
示例 2：
输入：nums = [2,2,1,9], target = 10
输出：4
解释：符合预算的采购方案如下：
nums[0] + nums[1] = 4
nums[0] + nums[2] = 3
nums[1] + nums[2] = 3
nums[2] + nums[3] = 10
来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/4xy4Wx
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
class Solution {
    public int purchasePlans(int[] nums, int target) {
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        int count=0;
        while(i<j){
            while(j>i&&nums[i]+nums[j]>target){
                j--;
            }
            if(j>i){
                count+=(j-i);
                count%=1000000007;
            }
            i++;
        }
        return count;
    }
}
/*
* 某乐团的演出场地可视作 num * num 的二维矩阵 grid（左上角坐标为 [0,0])，每个位置站有一位成员。乐团共有 9 种乐器，乐器编号为 1~9，每位成员持有 1 个乐器。

为保证声乐混合效果，成员站位规则为：自 grid 左上角开始顺时针螺旋形向内循环以 1，2，...，9 循环重复排列。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/SNJvJP
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
/*
public:
    using Long = long;
    int orchestraLayout(int num, int xPos, int yPos) {
        Long n = (Long)num;
        Long x = (Long) xPos;
        Long y = (Long) yPos;
        if (x <= y)
        {
            Long k = min(x, n-1-y);
            return (4*k*(n-k) + (x-k + y-k+1) - 1) % 9 + 1;
        }
        else
        {
            // 这里其实是k+1
            Long k = min(y, n-1-x) + 1;
            return (4*k*(n-k) - (x-(k-1)+y-(k-1)-1) -1) % 9 +1;
        }

    }
};
*/


class Solution2 {
    public int orchestraLayout(int num, int xPos, int yPos) {
        long n=(long)num;
        long x=(long)xPos;
        long y=(long)yPos;
        if(x<=y){
            long k=Math.min(x,n-1-y);
            return (int)((4*k*(n-k)+(x-k+y-k+1)-1)%9+1);
        }else{
            long k=Math.min(y,n-1-x)+1;
            return (int)((4*k*(n-k)-(x-(k-1)+y-(k-1)-1)-1)%9+1);
        }
    }
}
