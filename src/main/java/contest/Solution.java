package contest;

class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx == fx && sy == fy) {
            return t != 1;
        }
        int xdis = Math.abs(fx - sx);
        int ydis = Math.abs(fy - sy);
        int needtime = xdis > ydis ? xdis : ydis;
        return needtime <= t;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isReachableAtTime(1,1,1,2,0));
    }
}
