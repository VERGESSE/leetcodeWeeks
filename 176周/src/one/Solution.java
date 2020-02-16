package one;

/** 统计有序矩阵中的负数
 *
 * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
 * 请你统计并返回 grid 中 负数 的数目。
 *
 * 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * 输出：8
 * 解释：矩阵中共有 8 个负数。
 */


class Solution {
    public int countNegatives(int[][] grid) {
        
        if(grid.length < 1)
            return 0;
        
        int res = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] < 0)
                    res++;
            }
        }
        
        return res;
    }
}

/*
class Solution {
    public int countNegatives(int[][] grid) {
        int r = 0;
        for(int[] g : grid)
        {
            for(int k : g)
            {
                if(k < 0) r++;
            }
        }
        return r;
    }
}
 */