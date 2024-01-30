package others.interview;


import java.util.*;

/**
 * # One day, we want to have an all-company meeting.
 * # A group of people submit their available time shown as an interval:
 * # input: [[1,4], [2,5], [4,6], [2,3], [16,24], [1000,2000]] - time range is any positive int.
 * <p>
 * #  Goal: Find any 1-hour time period that most people are available.
 * # Return the maximum number of people (and preferably the best time).
 * # answer: 3 people, the hour 2-3
 * [[1,4], [2,5], [4,6], [2,3], [16,24], [1000,2000]]
 * [1,4] [2,3] [2,5] [4,6] [16,24] [1000,2000]
 */

/**
 * https://zhuanlan.zhihu.com/p/401865066
 */

public class Datavisor {

    // time complexity O(n), n is the length of intervals
    class Operation {
        Boolean add;
        int count;

        public Operation(Boolean add, int count) {
            this.add = add;
            this.count = count;
        }
    }


    public int getBestHour(int[][] intervals) {
        TreeMap<Integer, Operation> map = new TreeMap<>();
        for (int[] interval : intervals) {
            if (map.get(interval[0]) == null) {
                Operation operation = new Operation(true, 1);
                map.put(interval[0], operation);
            } else {
                Operation operation = map.get(interval[0]);
                if (operation.add) {
                    operation.count++;
                } else {
                    operation.count--;
                    if (operation.count == 0)
                        map.remove(interval[0]);
                }
            }
            if (map.get(interval[1]) == null) {
                Operation operation = new Operation(false, 1);
                map.put(interval[1], operation);
            } else {
                Operation operation = map.get(interval[1]);
                if (!operation.add) {
                    operation.count++;
                } else {
                    operation.count--;
                    if (operation.count == 0)
                        map.remove(interval[1]);
                }
            }
        }
        int maxHour = 0;
        int curMaxHour = 0;
        int maxKey = -1;
        for (Map.Entry<Integer, Operation> entry : map.entrySet()) {
            if (entry.getValue().add) {
                // add
                curMaxHour = curMaxHour + entry.getValue().count;
                if (curMaxHour > maxHour) {
                    maxKey = entry.getKey();
                    maxHour = curMaxHour;
                }
            } else {
                // remove
                curMaxHour = curMaxHour - entry.getValue().count;
            }
        }
        return maxKey;
    }

    // time complexity n - intervals.length  , N average length
    // O(n*N)
    public int getMostHour2(int[][] intervals) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] interval : intervals) {
            for (int i = interval[0]; i <= interval[1]; i++) {
                int count = map.getOrDefault(i, 0);
                count++;
                map.put(i, count);
            }
        }
        // find out the max value , max key first
        int max = -1;
        int maxKey = -1;
        for (int key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                maxKey = key;
            }
        }
        return maxKey;
    }

    // time complexity O(nlogn) n is the length of interval, because I used a sorted tree
    // space complexity is O(n)
    public int getMostHour(int[][] intervals) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int[] interval : intervals) {
            int count = map.getOrDefault(interval[0], 0);
            map.put(interval[0], count + 1);
            count = map.getOrDefault(interval[1], 0);
            map.put(interval[1], count - 1);
        }
        int max = 0;
        int maxKey = -1;
        int curMax = 0;
        for (int key : map.keySet()) {
            curMax += map.get(key);
            if (curMax > max) {
                max = curMax;
                maxKey = key;
            }
        }
        return maxKey;
    }


    public static void main(String[] args) {
        Datavisor datavisor = new Datavisor();
        int[][] intervals = {{1, 4}, {2, 3}, {2, 5}, {4, 6}, {16, 24}, {1000, 2000}};

//        int[][] intervals = {{2025, 2041}, {1988, 2007}, {2003, 2046}, {2045, 2049}, {2025, 2027}, {2014, 2040}, {2014, 2027}, {2011, 2027}, {1972, 2019}};
        int bestHour = datavisor.getBestHour(intervals);
        int mostHour2 = datavisor.getMostHour2(intervals);
        int mostHour3 = datavisor.getMostHour(intervals);
        System.out.println(bestHour);
        System.out.println(mostHour2);
        System.out.println(mostHour3);
    }

}
