package two;

/**
 *  最后 K 个数的乘积
 *
 *  1. add(int num)
 *
 * 将数字 num 添加到当前数字列表的最后面。
 * 2. getProduct(int k)
 *
 * 返回当前数字列表中，最后 k 个数字的乘积。
 * 你可以假设当前列表中始终 至少 包含 k 个数字。
 * 题目数据保证：任何时候，任一连续数字序列的乘积都在 32-bit 整数范围内，不会溢出。
 *
 * 输入：
 * ["ProductOfNumbers","add","add","add","add","add","getProduct","getProduct","getProduct","add","getProduct"]
 * [[],[3],[0],[2],[5],[4],[2],[3],[4],[8],[2]]
 *
 * 输出：
 * [null,null,null,null,null,null,20,40,0,null,32]
 *
 * 解释：
 * ProductOfNumbers productOfNumbers = new ProductOfNumbers();
 * productOfNumbers.add(3);        // [3]
 * productOfNumbers.add(0);        // [3,0]
 * productOfNumbers.add(2);        // [3,0,2]
 * productOfNumbers.add(5);        // [3,0,2,5]
 * productOfNumbers.add(4);        // [3,0,2,5,4]
 * productOfNumbers.getProduct(2); // 返回 20 。最后 2 个数字的乘积是 5 * 4 = 20
 * productOfNumbers.getProduct(3); // 返回 40 。最后 3 个数字的乘积是 2 * 5 * 4 = 40
 * productOfNumbers.getProduct(4); // 返回  0 。最后 4 个数字的乘积是 0 * 2 * 5 * 4 = 0
 * productOfNumbers.add(8);        // [3,0,2,5,4,8]
 * productOfNumbers.getProduct(2); // 返回 32 。最后 2 个数字的乘积是 4 * 8 = 32
 */

import java.util.ArrayList;

class ProductOfNumbers {

    private ArrayList<Integer> list = new ArrayList<>();
    public ProductOfNumbers() {

    }

    public void add(int num) {
        list.add(num);
    }

    public int getProduct(int k) {
        int res = 1;
        int n = list.size();
        for (int i = n-1; i >= n-k; i--){
            res *= list.get(i);
        }
        return res;
    }
}


/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */

/*
class ProductOfNumbers {

    long[] prod = new long[40020];
    int idx = 0;
    int zero = -1;
    public ProductOfNumbers() {
        prod[0] = 1;
        idx++;
    }

    public void add(int num) {
        if(num == 0) {
            zero = idx;
            prod[idx] = 1;
        }
        else prod[idx] = prod[idx - 1] * num;
        idx++;
    }

    public int getProduct(int k) {
        if(idx - k <= zero) return 0;
        return (int)(prod[idx - 1] / prod[idx - k - 1]);
    }
}
 */