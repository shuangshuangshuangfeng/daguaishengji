/*
 * @lc app=leetcode.cn id=557 lang=java
 *
 * [557] 反转字符串中的单词 III
 */

 

// @lc code=start
class Solution {

   private char[] words ;

    /**
     * 双指针
     * 时间复杂度O(N)
     * 空间复杂度O(1)
     * @param s
     * @return
     */
    public  String reverseWords(String s) {
        char[] e = s.toCharArray();
        words = e; 
        int start = 0; //翻转起始点
        int end = 0; //翻转结束点
        while(end < words.length){
            // end结尾，一个单词结束
            if(end == words.length-1){
                reverse_word(start, end);
                break;
            }
            if(words[end] != ' '){
                end ++;
            }else if(words[end] == ' '){ // 遇到空格，一个单词结束
                reverse_word(start, end-1);
                start = end+1;
                end ++;
            }
            

        }

        return String.valueOf(words);
    }

    /**
     * 翻转字符刺， 前闭后闭
     * @param words
     * @param start
     * @param end
     */
    private  void reverse_word(int start, int end){
        while(start < end){
            char temp = words[start];
            words[start] = words[end];
            words[end] = temp;
            start ++;
            end --;
        }
    }


    /**
     * 使用java内置函数
     * 时间复杂度O(N)
     * 空间复杂度O(N)
     * @param s
     * @return
     */
    public String reverseWords_1(String s) {
        String[] words = s.split(" ");
        StringBuffer sb = new StringBuffer();
        for(String word : words){
            StringBuffer temp = new StringBuffer(word);
            sb.append(temp.reverse()+" ");
        }

        return sb.toString().substring(0, sb.length()-1);
    }


}
// @lc code=end

