import java.util.List;

/**
 * @author:飞哥
 * @date: 2021/4/13 16:28
 */
/*未知 整数数组 arr 由 n 个非负整数组成。
经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1] 。例如，arr = [1,0,2,1] 经编码后得到 encoded = [1,2,3] 。
给你编码后的数组 encoded 和原数组 arr 的第一个元素 first（arr[0]）。
请解码返回原数组 arr 。可以证明答案存在并且是唯一的。
示例 1：
输入：encoded = [1,2,3], first = 1
输出：[1,0,2,1]
解释：若 arr = [1,0,2,1] ，那么 first = 1 且 encoded = [1 XOR 0, 0 XOR 2, 2 XOR 1] = [1,2,3]
示例 2：
输入：encoded = [6,2,7,3], first = 4
输出：[4,2,0,7,4]
链接：https://leetcode-cn.com/problems/decode-xored-array
* */
class Solution {
    public int[] decode(int[] encoded, int first) {
        int[]arr=new int[encoded.length+1];
        arr[0]=first;
        for(int i=0;i<encoded.length;++i){
            arr[i+1]=encoded[i]^arr[i];
        }
        return arr;
    }
}
/*
* 小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，小A 每次也从 1, 2, 3 中选择一个猜。他们一共进行三次这个游戏，请返回 小A 猜对了几次？
输入的guess数组为 小A 每次的猜测，answer数组为 小B 每次的选择。guess和answer的长度都等于3。
示例 1：
输入：guess = [1,2,3], answer = [1,2,3]
输出：3
解释：小A 每次都猜对了。
示例 2：
输入：guess = [2,2,3], answer = [3,2,1]
输出：1
解释：小A 只猜对了第二次。
链接：https://leetcode-cn.com/problems/guess-numbers
* */
class Solution2 {
    public int game(int[] guess, int[] answer) {
        int count=0;
        for(int i=0;i<3;++i){
            if(guess[i]==answer[i]){
                count++;
            }
        }
        return count;
    }
}
/*
* 给你一个数组 items ，其中 items[i] = [typei, colori, namei] ，描述第 i 件物品的类型、颜色以及名称。
另给你一条由两个字符串 ruleKey 和 ruleValue 表示的检索规则。
如果第 i 件物品能满足下述条件之一，则认为该物品与给定的检索规则 匹配 ：
ruleKey == "type" 且 ruleValue == typei 。
ruleKey == "color" 且 ruleValue == colori 。
ruleKey == "name" 且 ruleValue == namei 。
统计并返回 匹配检索规则的物品数量 。
示例 1：
输入：items = [["phone","blue","pixel"],["computer","silver","lenovo"],["phone","gold","iphone"]], ruleKey = "color", ruleValue = "silver"
输出：1
解释：只有一件物品匹配检索规则，这件物品是 ["computer","silver","lenovo"] 。
示例 2：
输入：items = [["phone","blue","pixel"],["computer","silver","phone"],["phone","gold","iphone"]], ruleKey = "type", ruleValue = "phone"
输出：2
解释：只有两件物品匹配检索规则，这两件物品分别是 ["phone","blue","pixel"] 和 ["phone","gold","iphone"] 。注意，["computer","silver","phone"] 未匹配检索规则。
链接：https://leetcode-cn.com/problems/count-items-matching-a-rul
* */
class Solution3 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int count=0;
        for(int i=0;i<items.size();++i){
            if(ruleKey.equals("type")){
                count=(ruleValue.equals(items.get(i).get(0)))?count+1:count;
            }else if(ruleKey.equals("color")){
                count=(ruleValue.equals(items.get(i).get(1)))?count+1:count;
            }else{
                count=(ruleValue.equals(items.get(i).get(2)))?count+1:count;
            }
        }
        return count;
    }
}
/*
* 给你两个整数，n 和 start 。
数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
请返回 nums 中所有元素按位异或（XOR）后得到的结果。
示例 1：
输入：n = 5, start = 0
输出：8
解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
     "^" 为按位异或 XOR 运算符。
示例 2：
输入：n = 4, start = 3
输出：8
解释：数组 nums 为 [3, 5, 7, 9]，其中 (3 ^ 5 ^ 7 ^ 9) = 8.
链接：https://leetcode-cn.com/problems/xor-operation-in-an-array
*/
class Solution4 {
    public int xorOperation(int n, int start) {
        int i=0;
        int end=0;
        while(n>=1){
            end^=(start+2*i);
            n--;
            i++;
        }
        return end;
    }
}
/*
* 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
示例 1：
输入：address = "1.1.1.1"
输出："1[.]1[.]1[.]1"
示例 2：
输入：address = "255.100.50.0"
输出："255[.]100[.]50[.]0"
链接：https://leetcode-cn.com/problems/defanging-an-ip-address
* */
class Solution5 {
    public String defangIPaddr(String address) {
        StringBuilder addr=new StringBuilder();
        for(int i=0;i<address.length();++i){
            if(address.charAt(i)=='.'){
                addr.append("[.]");
            }else{
                addr.append(address.charAt(i));
            }
        }
        return addr.toString();
    }
}
public class Main {
    public static void main(String[] args) {

    }
}
