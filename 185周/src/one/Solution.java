package one;

/**
 * 5388. 重新格式化字符串 显示英文描述
 * 通过的用户数2
 * 尝试过的用户数4
 * 用户总通过次数2
 * 用户总提交次数5
 * 题目难度Easy
 * 给你一个混合了数字和字母的字符串 s，其中的字母均为小写英文字母。
 *
 * 请你将该字符串重新格式化，使得任意两个相邻字符的类型都不同。也就是说，
 * 字母后面应该跟着数字，而数字后面应该跟着字母。
 *
 * 请你返回 重新格式化后 的字符串；如果无法按要求重新格式化，则返回一个 空字符串 。
 *
 *输入：s = "a0b1c2"
 * 输出："0a1b2c"
 * 解释："0a1b2c" 中任意两个相邻字符的类型都不同。
 * "a0b1c2", "0a1b2c", "0c2a1b" 也是满足题目要求的答案。
 */
class Solution {
    public String reformat(String s) {

        char[] chars = s.toCharArray();
        char[] numArray = new char[s.length()];
        char[] charArray = new char[s.length()];
        int numIndex=0, charIndex=0;
        for (char aChar : chars) {
            if (aChar >= 'a' && aChar <= 'z')
                charArray[charIndex++] = aChar;
            else if (aChar >= '0' && aChar <= '9')
                numArray[numIndex++] = aChar;
            else return "";
        }
        if (Math.abs(numIndex-charIndex) > 1) return "";
        StringBuilder sb = new StringBuilder();
        if (numIndex > charIndex){
            for (int i = 0; i < charIndex; i++){
                sb.append(numArray[i]);
                sb.append(charArray[i]);
            }
            if (numIndex > charIndex){
                sb.append(numArray[numIndex-1]);
            }
        }else {
            for (int i = 0; i < numIndex; i++){
                sb.append(charArray[i]);
                sb.append(numArray[i]);
            }
            if (numIndex < charIndex){
                sb.append(charArray[charIndex-1]);
            }
        }

        return sb.toString();
    }
}