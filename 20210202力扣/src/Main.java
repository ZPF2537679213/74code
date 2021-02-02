public class Main {

}
//N 辆车沿着一条车道驶向位于 target 英里之外的共同目的地。
//每辆车 i 以恒定的速度 speed[i] （英里/小时），从初始位置 position[i] （英里） 沿车道驶向目的地。
//一辆车永远不会超过前面的另一辆车，但它可以追上去，并与前车以相同的速度紧接着行驶。
//此时，我们会忽略这两辆车之间的距离，也就是说，它们被假定处于相同的位置。
//车队 是一些由行驶在相同位置、具有相同速度的车组成的非空集合。注意，一辆车也可以是一个车队。
//即便一辆车在目的地才赶上了一个车队，它们仍然会被视作是同一个车队。
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if(position==null||position.length==0){
            return 0;
        }
        sort(position,speed,0,position.length-1);
        double[]time=new double[position.length];
        for(int i=0;i<position.length;++i){
            time[i]=(target-position[i])/(double)speed[i];
        }
        double first=0;
        int num=0;
        for(int i=0;i<time.length;++i){
            if(first<time[i]){
                num++;
                first=time[i];
            }
        }
        return num;
    }
    public void sort(int[]position,int []speed,int low,int high){
        if(low>=high){
            return;
        }
        int start=low;
        int end=high;
        int tmp1=position[low];
        int tmp2=speed[low];
        while(low<high){
            while(low<high&&position[high]<tmp1){
                high--;
            }
            position[low]=position[high];
            speed[low]=speed[high];
            while(low<high&&position[low]>tmp1){
                low++;
            }
            position[high]=position[low];
            speed[high]=speed[low];
        }
        position[low]=tmp1;
        speed[low]=tmp2;
        int mid=low;
        sort(position,speed,start,mid-1);
        sort(position,speed,mid+1,end);
    }
}
//给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
//此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
//输入：nums = [2,0,2,1,1,0]
//输出：[0,0,1,1,2,2]
class Solution2 {
    public void sortColors(int[] nums) {
        insert(nums);
    }
    public void insert(int[]num){
        int i,j;
        for(i=1;i<num.length;++i){
            int tmp=num[i];
            for(j=i-1;j>=0;--j){
                if(num[j]>tmp){
                    num[j+1]=num[j];
                }else{
                    break;
                }
            }
            num[j+1]=tmp;
        }
    }
}
