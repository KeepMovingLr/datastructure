package interview;

/**
 * @author enyi.lr
 * @version $Id: Microsoft.java, v 0.1 2019‐12‐06 12:16 PM enyi.lr Exp $$ 如何判断一个字符串在任意位置(包括最前面和最后面)插入一个字符后能不能构成一个回文串？如何判断一个字符串在任意位置
 * (包括最前面和最后面)插入一个字符后能不能构成一个回文串？
 */
public class Microsoft {

    public static void main(String[] args) {
        Microsoft microsoft = new Microsoft();
        System.out.println(microsoft.isHuiWen("abcddecba"));
        System.out.println(microsoft.isHuiWen("ababc"));
        System.out.println(microsoft.isHuiWen("aa"));
    }

    public boolean isHuiWen(String needCheck) {
        if (needCheck == null) {
            return false;
        }
        if ("".equals(needCheck)) {
            return true;
        }
        // 本身是回文
        if (checkIsHuiWen(needCheck)) {
            return true;
        } else {
            // 判断在哪里加
            int[] index = checkNeedAddIndex(needCheck);
            // judge whether subString is true
            boolean leftResult = checkIsHuiWen(needCheck.substring(index[0] + 1, index[1] + 1));
            boolean rightResult = checkIsHuiWen(needCheck.substring(index[0], index[1]));
            return leftResult || rightResult;
        }
    }

    public int[] checkNeedAddIndex(String needCheckString) {
        int[] index = new int[2];
        char[] chars = needCheckString.toCharArray();
        int begin = 0;
        int end = chars.length - 1;
        while (begin <= end) {
            if (chars[begin] == chars[end]) {
                begin++;
                end--;
            } else {
                index[0] = begin;
                index[1] = end;
                return index;
            }
        }
        return index;
    }

    public boolean checkIsHuiWen(String needCheck) {
        char[] chars = needCheck.toCharArray();
        int begin = 0;
        int end = chars.length - 1;
        while (begin <= end) {
            if (chars[begin] == chars[end]) {
                begin++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }

}