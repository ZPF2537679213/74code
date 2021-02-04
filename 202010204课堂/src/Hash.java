import java.util.*;

public class Hash {
    /**
     * 找出10W个数据当中，第一个重复的数据
     * 思路：遍历list 拿到每个元素之后 存到set 注意，存储之前，需要看set中是否
     * 有这个数据？有 就说明找到了第一个重复的数据
     * @return
     */
    public static int findFirstRepeatNumber() {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10_0000; i++) {
            list.add(random.nextInt(1_0000));
        }

        HashSet<Integer> set = new HashSet<>();
        //contatins
        int i;
       for(i=0;i<10_0000;++i){
           if(!set.contains(list.get(i))){
               set.add(list.get(i));
           }else{
               break;
           }
       }
        return list.get(i);
    }
    /**
     * 把10W个数据当中的重复的数据 去重
     * 思路：只需要把10W个数据放到集合当中
     * @return
     */
    public static Set<Integer> deputil() {
        Random random = new Random();
        ArrayList<Integer> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        int i;
         for(i=0;i<10_0000;++i) {
            list.add(random.nextInt(1_0000));
        }
        for(i=0;i<10_0000;++i){
                set.add(list.get(i));
        }
        return set;
    }
}
//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
//说明：
//
//你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
//
//示例 1:
//
//输入: [2,2,1]
//输出: 1
//示例 2:
//
//输入: [4,1,2,1,2]
//输出: 4
class Solution {
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
       
        for(int i=0;i<nums.length;++i){
            if(map.get(nums[i])==null){
                map.put(nums[i],1);
            }else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        for(int x:nums){
            if(map.get(x)==1){
                return x;
            }
        }
        return -1;
    }
}
