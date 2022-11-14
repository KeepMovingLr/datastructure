package lc.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: S_93_RestoreIPAddresses.java, v 0.1 2019‐12‐09 1:15 PM enyi.lr Exp $$
 */
public class S_93_RestoreIPAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> stringResult = new ArrayList<>();
        if (s.length() > 12) {
            return stringResult;
        }
        List<List<String>> result = restoreIpAddressesHelper(s, 5);
        for (List<String> list : result) {
            Collections.reverse(list);
            StringBuilder stringBuilder = new StringBuilder();
            for (String s1 : list) {
                stringBuilder.append(s1).append(".");
            }
            stringResult.add(stringBuilder.toString().substring(0, stringBuilder.length() - 1));
        }
        return stringResult;
    }

    public List<List<String>> restoreIpAddressesHelper(String s, int count) {
        List<List<String>> result = new ArrayList<>();
        count--;
        if (count == 1) {
            if (!isValidIp(s)) {
                return result;
            } else {
                List<String> oneAnswer = new ArrayList<>();
                oneAnswer.add(s);
                result.add(oneAnswer);
                return result;
            }
        }
        for (int i = 1; i < 4 && i < s.length(); i++) {
            String lengthOne = s.substring(0, i);
            if (isValidIp(lengthOne)) {
                List<List<String>> oneResult = restoreIpAddressesHelper(s.substring(i), count);
                for (List<String> list : oneResult) {
                    list.add(lengthOne);
                }
                result.addAll(oneResult);
            }
        }
        return result;
    }

    // each part of a valid ip is between [0,255]
    public boolean isValidIp(String needCheckedIp) {
        if (needCheckedIp.length() != 1) {
            if (needCheckedIp.startsWith("0")) {
                return false;
            }
        }
        long ip = Long.parseLong(needCheckedIp);
        return ip >= 0 && ip <= 255;
    }

    public static void main(String[] args) {
        S_93_RestoreIPAddresses s_93_restoreIPAddresses = new S_93_RestoreIPAddresses();
        List<String> list = s_93_restoreIPAddresses.restoreIpAddresses("0279245587303");
        //List<String> list2 = s_93_restoreIPAddresses.restoreIpAddresses("0000");
        System.out.println(list);

    }

}