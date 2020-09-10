class Solution1 {

    public static void main(String[] args) {
        String s = "aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga";
        validPalindrome(s);
    }

    // 2. 双指针
    public static boolean validPalindrome(String s) {
        StringBuffer temp = new StringBuffer(s);
        int l = 0;
        int r = s.length()-1;
        int cnt = 0;  //计数

        while(l<=r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
                continue;
            }

            if(s.charAt(l+1) == s.charAt(r)){ // left进一步
                if (++cnt > 1) {
                    return false;
                }
                l++;
            }else if(s.charAt(r-1) == s.charAt(l)){ // right进一步
                if (++cnt > 1) {
                    return false;
                }
                r--;
            } else {
                System.out.println("cnt: " + cnt);
                System.out.println("l: "+s.charAt(l)+"--r: "+s.charAt(r));
                System.out.println("(l+1): " + s.charAt(l+1) + "----(r-1): " + s.charAt(r-1));
                System.out.println("l index: "+l+"\t r index: "+r);
                return false;
            }
        }
        return true;
    }


    // 1. 暴力法
    public boolean validPalindrome_1(String s) {
        StringBuffer temp = new StringBuffer(s);
        for(int i=0; i<s.length(); i++){
            StringBuffer a = new StringBuffer(temp).deleteCharAt(i);
            if(a.toString().equals(a.reverse().toString())) return true;
        }
        return false;
    }
}