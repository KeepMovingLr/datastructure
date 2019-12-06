package interview;

/**
 * @author enyi.lr
 * @version $Id: Microsoft.java, v 0.1 2019‐12‐06 12:16 PM enyi.lr Exp $$ 如何判断一个字符串在任意位置(包括最前面和最后面)插入一个字符后能不能构成一个回文串?
 * https://www.cnblogs.com/xiaoxi666/p/7443797.html
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

    /**
     * 1.常规方法，先判断整体是否回文，若整体回文，可以在中间加一个数，直接返回YES。如果整体不是回文，依次去掉一个字符后判断剩下的字符串是否为回文串，时间复杂度O(n^2)。如abcddecba：1.去掉a，判断bcddecba；2
     * .去掉b，判断acddecba；3.去掉c，判断abddecba；等等。一直进行下去，若发现回文即可停止返回YES，反之如果一直没发现回文串，返回NO。
     *
     * 2.创意解法，先找到不匹配的位置，然后提取出中间不匹配的的字符串，分别判断其去掉头和去掉尾的两个字符串是否为回文，其中一个为回文即可。时间复杂度O(n)。如abcddecba，取出dde，然后判断dd和de，发现其中有一个满足回文，即返回YES。反之返回NO。
     *
     * 3.扩展解法，先把原字符串逆序，然后计算两字符串的最长公共子序列长度，最后diff=字符串长度-最长公共子序列长度，diff即为如果可以形成回文串，原字符串需要添加的字符个数。用到这个题目里，如果diff<=1，即可。时间复杂度O(n^2)
     * 。可以看到，这种解法可以解决一类问题：添加几个字符可以构成回文串？
     *
     */

}