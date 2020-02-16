package three;

/**
 * 最多可以参加的会议数目
 *
 * 给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，表示会议 i 开始于 startDayi ，结束于 endDayi 。
 * 你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。注意，一天只能参加一个会议。
 * 请你返回你可以参加的 最大 会议数目。
 *
 *输入：events = [[1,2],[2,3],[3,4]]
 * 输出：3
 * 解释：你可以参加所有的三个会议。
 * 安排会议的一种方案如上图。
 * 第 1 天参加第一个会议。
 * 第 2 天参加第二个会议。
 * 第 3 天参加第三个会议。
 *
 * 输入：events= [[1,2],[2,3],[3,4],[1,2]]
 * 输出：4
 *
 * 输入：events = [[1,1],[1,2],[1,3],[1,4],[1,5],[1,6],[1,7]]
 * 输出：7
 */

import java.util.Arrays;

class Solution {
    public int maxEvents(int[][] events) {

        if (events.length < 1)
            return 0;
        
        Arrays.sort(events,(a, b) -> {
            if (a[1] != b[1])
                return a[1] - b[1];
            return a[0] - b[0];
        });
        
        int[] memo = new int[events[events.length-1][1]+1];
        
        int res = 0;
        for (int i = 0; i < events.length; i++){
            for(int j = events[i][0]; j <= events[i][1]; j++){
                if(memo[j] == 0){
                    memo[j] = 1;
                    res++;
                    break;
                }
            }
        }
        return res;
    }
}

/*
class Solution {
    public int maxEvents(int[][] events) {
        Queue<int[]> q = new PriorityQueue<>((a, b)->(a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]));
        int maxi = 1;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int[] e : events) {
            maxi = Math.max(maxi, e[1]);
            int e0 = e[0];
            if(!map.containsKey(e0)) map.put(e0, new ArrayList<>());
            map.get(e0).add(e);
        }

        int re = 0;

        for(int i = 1; i <= maxi; i++)
        {
            if(map.containsKey(i))
            {
                for(int[] next : map.get(i)) q.offer(next);
            }
            while(!q.isEmpty())
            {
                int[] p = q.poll();

                int from = p[0], to = p[1];
                if(from <= i && i <= to)
                {
                    re++;
                    break;
                }
            }

        }
        return re;
    }
}
 */