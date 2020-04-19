package three;

import java.util.Arrays;

/** 5390
 * 题目难度Medium
 * 给你一个字符串 croakOfFrogs，它表示不同青蛙发出的蛙鸣声（字符串 "croak" ）的组合。由于同一时间可以有多只青蛙呱呱作响，所以 croakOfFrogs 中会混合多个 “croak” 。请你返回模拟字符串中所有蛙鸣所需不同青蛙的最少数目。
 *
 * 注意：要想发出蛙鸣 "croak"，青蛙必须 依序 输出 ‘c’, ’r’, ’o’, ’a’, ’k’ 这 5 个字母。如果没有输出全部五个字母，那么它就不会发出声音。
 *
 * 如果字符串 croakOfFrogs 不是由若干有效的 "croak" 字符混合而成，请返回 -1 。
 *
 * 输入：croakOfFrogs = "croakcroak"
 * 输出：1
 * 解释：一只青蛙 “呱呱” 两次
 *
 * 输入：croakOfFrogs = "crcoakroak"
 * 输出：2
 * 解释：最少需要两只青蛙，“呱呱” 声用黑体标注
 * 第一只青蛙 "crcoakroak"
 * 第二只青蛙 "crcoakroak"
 */

class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        int len=croakOfFrogs.length();
        if(len%5!=0||croakOfFrogs.charAt(0)!='c'||croakOfFrogs.charAt(len-1)!='k')
            return -1;
        char[] ha=new char[]{'c','r','o','a','k'};
        char[] ch=croakOfFrogs.toCharArray();
        int n=len/5;
        int[] num=new int[127];
        int count=1;
        for(char c:ch){
            num[c]++;
            if(!(num['c']>=num['r']&&num['r']>=num['o']
                    &&num['o']>=num['a']&&num['a']>=num['k'])) return -1;
            count=Math.max(count,num['c']-num['k']);
        }
        return count;
    }
}

class Solution2 {
    public int minNumberOfFrogs(String cc) {
        char[] ck = {'c','r','o','a','k'};
        int[] d =new int[256];

        for(char c:cc.toCharArray()){
            d[c]++;
        }
        int w = -1;
        for(char me:ck){
            if(w==-1){
                w = d[me];
            }else if(w!=d[me]){
                return -1;
            }
        }
        d = new int[256];
        int mx = 0;
        for(char c:cc.toCharArray()){
            if(c=='c'){
                d[c]++;

            }else if(c=='r'){
                d['r']++;
                if(d['r']<=d['c']){

                }else{
                    return -1;
                }
            }else if(c=='o'){
                d['o']++;
                if(d['o']<=d['r']){

                }else{
                    return -1;
                }
            }else if(c=='a'){
                d['a']++;
                if(d['a']<=d['o']){

                }else{
                    return -1;
                }
            } else if(c=='k'){
                d['k']++;
                if(d['k']<=d['a']){
                    d['c']--;
                    d['r']--;
                    d['o']--;
                    d['a']--;
                    d['k']--;
                }else{
                    return -1;
                }
            }
            mx = Math.max(mx,d['c']);
            //  System.out.println(mx);
        }
        // System.out.println(w);

        return mx;
    }
}

/*class Solution {

    boolean[] memo;

    public int minNumberOfFrogs(String croakOfFrogs) {

        if (croakOfFrogs.length() % 5 != 0 || croakOfFrogs.charAt(0) != 'c') return -1;
        memo = new boolean[croakOfFrogs.length()];

        int res = 0;
        char[] frogs = croakOfFrogs.toCharArray();
        String forg = "croak";
        char[] forgChars = forg.toCharArray();
        int index = 0;
        int[] tmpMemo = new int[5];

        while (croakOfFrogs.length() > 0){
            int i = croakOfFrogs.indexOf(forgChars[index]);
            if (i == -1) return -1;
            else croakOfFrogs = croakOfFrogs.substring(0,i) + croakOfFrogs.substring(i+1);
            index++;
            if (index == 5) {
                index = 0;
                if (croakOfFrogs.charAt(0) != 'c')
                    return -1;
            }
        }
        index = 0;
        while (isTrue()) {
            for (int i = 0; i < frogs.length; i++) {
                if (frogs[i] == forgChars[index] && !memo[i]) {
                    tmpMemo[index] = i;
                    index++;
                }
                if (index == forg.length()) {
                    index = 0;
                    for (int j : tmpMemo) {
                        memo[j] = true;
                    }
                }
            }
            res++;
        }

        return res != 0 ? res : -1;
    }

    private boolean isTrue(){
        for (boolean b : memo) {
            if (!b)
                return true;
        }
        return false;
    }
}*/



















