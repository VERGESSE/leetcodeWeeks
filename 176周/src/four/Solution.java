package four;

/**
 * 多次求和构造目标数组
 *
 * 给你一个整数数组 target 。一开始，你有一个数组 A ，它的所有元素均为 1 ，你可以执行以下操作：
 *
 * 令 x 为你数组里所有元素的和
 * 选择满足 0 <= i < target.size 的任意下标 i ，并让 A 数组里下标为 i 处的值为 x 。
 * 你可以重复该过程任意次
 * 如果能从 A 开始构造出目标数组 target ，请你返回 True ，否则返回 False 。
 *
 * 输入：target = [9,3,5]
 * 输出：true
 * 解释：从 [1, 1, 1] 开始
 * [1, 1, 1], 和为 3 ，选择下标 1
 * [1, 3, 1], 和为 5， 选择下标 2
 * [1, 3, 5], 和为 9， 选择下标 0
 * [9, 3, 5] 完成
 *
 * 输入：target = [1,1,1,2]
 * 输出：false
 * 解释：不可能从 [1,1,1,1] 出发构造目标数组。
 */

class Solution {
    public boolean isPossible(int[] target) {
        int idx = 0;
        for(;idx<target.length;idx++){
            if(target[idx] == 1) continue;
            else break;
        }

        if(idx == target.length) return true;

        long lSum = 0;
        for(int i=0;i<target.length;i++)
            lSum += target[i];

        if(lSum > Integer.MAX_VALUE)
            return false;

        int sum = (int)lSum;
        boolean flag = false;

        // 逆向思维：现在结果=之前的和+dix位置的上一次的数
        // 上一次的数=现在结果*2-现在的和(之前的和+上一次dix位置上的数)
        // 如果能使target回到111...就返回true
        for(int i=0;i<target.length;i++){
            if(target[i]*2 - sum > 0){
                target[i] = target[i]*2 - sum;
                flag = isPossible(target);
                if(flag) return true;
            }
        }

        return flag;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {29799,253,1,4016,1007,1,1,1,14936,7528};
        System.out.println(solution.isPossible(ints));
    }
}

/*  我自己的超时代码
import java.util.Arrays;

class Solution {

    int[] a;

    public boolean isPossible(int[] target) {

        a = new int[target.length];
        Arrays.fill(a,1);

        return ispossible(target);
    }

    private boolean ispossible(int[] target){

        boolean flag = false;
        int sum = sumArray(a);
        for (int i = 0; i < target.length; i++){
            if (isFlag(target,sum,i) && !flag){
                int tmp = a[i];
                a[i] = sum;
                ispossible(target);
                int n = target.length;
                for (int j = 0; j < target.length; j++ ){
                    if (target[j] == a[j]){
                        n--;
                    }else break;
                }
                if (n == 0) flag = true;
                if (flag == false)
                    a[i] = tmp;
            }
        }
//        for (int i = 0; i < a.length; i++){
//            System.out.print(a[i] + " ");
//        }
//        System.out.println();
        return flag;
    }

    private boolean isFlag(int[] target, int k,int i){

        if (target[i] - k >= 0){
            return true;
        }
        return false;
    }

    private int sumArray(int[] a){
        int sum = 0;
        for (int i = 0; i < a.length; i++){
            sum += a[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {29799,253,1,4016,1007,1,1,1,14936,7528};
        System.out.println(solution.isPossible(ints));
    }
}
 */