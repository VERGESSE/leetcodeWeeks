package four;

/*
5391. 生成数组
 */
class Solution {
    public int numOfArrays(int n, int m, int k) {

        long dp[][][] = new long[n + 1][m + 1][k + 1];

        for (int i = 1; i <= m; ++i) {
            dp[1][i][1] = 1;
        }

        long mod = 1000000007L;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                for (int y = 1; y <= k; ++y) {
                    for (int s = 1; s < j; ++s) {
                        dp[i][j][y] += dp[i - 1][s][y - 1];
                        dp[i][j][y] %= mod;
                    }
                    dp[i][j][y] += dp[i - 1][j][y] * j;
                    dp[i][j][y] %= mod;
                }
            }
        }
        long tot = 0;
        for (int l = 1; l <= m; ++l) {
            tot += dp[n][l][k];
            tot %= mod;
        }
        return (int) tot;
    }
}
