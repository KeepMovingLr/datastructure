package lc.array;

/**
 * @author enyi.lr
 * @version $Id: S_5_LongestPalindromicSubstring.java, v 0.1 2019‐12‐14 5:02 PM enyi.lr Exp $$
 */
public class S_5_LongestPalindromicSubstring {

    // Time Limit Exceeded
    public String longestPalindrome(String s) {
        String result = "";
        int currentLength = 0;
        if(s == null || s.length() == 0){
            return "";
        }
        for(int i = 0; i <= s.length() ; i++){
            for(int j=i; j<= s.length() ; j++){
                if(isPalindrome(s.substring(i,j))){
                    if(j-i > currentLength){
                        currentLength = j-i;
                        result = s.substring(i,j);
                    }
                }

            }
        }
        return result;
    }


    public boolean isPalindrome(String s){
        if(s == null){
            return false;
        }
        if(s.length() == 0){
            return true;
        }
        if(s.length() == 1){
            return true;
        }
        char[] chars = s.toCharArray();
        int front = 0;
        int end = chars.length-1;
        while(front < end){
            if(chars[front] == chars[end]){
                front ++;
                end --;
            } else{
                return false;
            }
        }
        return true;
    }
}