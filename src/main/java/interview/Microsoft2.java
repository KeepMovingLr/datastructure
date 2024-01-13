package interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 给定一个基本数字假设3 ，6，9 还有一个target 数组比如 6472，找到一个由基本数组组成的，小于等于target最大的
public class Microsoft2 {

    public static void main(String[] args) {
        Microsoft2 microsoft2 = new Microsoft2();
        int[] nums = {3, 6, 9, 4};
        for (int i = 0; i < 10000; i++) {
            System.out.println("test " + i);
            if (microsoft2.getTarget(i, nums) != microsoft2.getTargetForce(i, nums)) {
                System.out.println("different" + i);
                System.out.println("different greedy " + microsoft2.getTarget(i, nums));
                System.out.println("different force " + microsoft2.getTargetForce(i, nums));

            }
        }
    }

    public int getTarget(int target, int[] nums) {
        Arrays.sort(nums);
        int needSelect = (target + "").length();
        String[] strings = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strings[i] = nums[i] + "";
        }
        String ans = select(target + "", strings, needSelect, true);
        if ("NA".equals(ans)) return -1;
        return Integer.parseInt(ans);
    }

    public String select(String target, String[] nums, int needSelectCount, boolean canIgnoreOne) {
        int numCount = target.length();
        if (numCount == 0)
            return "";
        if (numCount > needSelectCount) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < needSelectCount; i++)
                sb.append(nums[nums.length - 1]);
            return sb.toString();
        }
        int highest = Integer.parseInt(target.charAt(0) + "");
        for (int i = nums.length - 1; i >= 0; i--) {
            int cur = Integer.parseInt(nums[i]);
            String subRes = "NA";
            if (cur == highest) { // select
                subRes = select(target.substring(1), nums, needSelectCount - 1, false);
            } else if (cur < highest) {
                subRes = select(1 + target.substring(1), nums, needSelectCount - 1, false);
            }
            if (!"NA".equals(subRes)) return cur + subRes;
            if (i == 0 && canIgnoreOne) {
                if (target.length() > 1) {
                    subRes = select(target, nums, needSelectCount - 1, true);
                    if (!"NA".equals(subRes)) return subRes;
                }
            }
        }

        return "NA";
    }

    public int getTargetForce(int target, int[] nums) {
        Set<Character> baseSet = new HashSet<>();
        for (int num : nums) {
            baseSet.add(Character.forDigit(num, 10));
        }
        for (int i = target; i >= 0; i--) {
            if (isValid(i + "", baseSet))
                return i;
        }
        return -1;
    }

    public boolean isValid(String target, Set<Character> base) {
        char[] chars = target.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!base.contains(chars[i]))
                return false;
        }
        return true;
    }

}
