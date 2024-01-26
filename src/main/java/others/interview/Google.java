package others.interview;

import java.util.Arrays;

/**
 * 问题：
 * 你正在浏览照片，album中包含所有的照片。其中有一部分是你最喜欢的，为favourite图集。请你实现方法getPhoto和sortPhoto。sortPhoto返回一个列表，将album中favourite的照片放在前面，其余照片顺序不变。而调用getPhoto方法，会弹出来一张图片供欣赏，请先弹出favourite中的图片，再按序弹出album中不在favourite的图片。 当浏览完所有的图片后，再调用这个方法会弹出-1。
 * 注意，favourite和album都是sorted的。
 * 例子1：
 * album = [1, 2, 2, 3, 4, 5]
 * favourite = [1, 2, 2, 5]
 * 调用sortPhoto后的输出： [1, 2, 2, 5, 3, 4]
 * 调用getPhoto 10次后的输出为：1 2 2 5 3 4 -1 -1 -1
 * <p>
 * follow up：
 * 这次不实现sortPhoto方法，只实现getPhoto方法。要求时间复杂度O(n)，空间复杂度O(1)。
 * 完整题目：
 * 你正在浏览照片，album中包含所有的照片。其中有一部分是你最喜欢的，为favourite图集。请你实现一个方法getPhoto。每次调用这个方法，弹出来一张图片供欣赏，请先弹出favourite中的图片，再弹出album中不在favourite的图片。 当浏览完所有的图片后，你可以弹出-1。
 * 注意，favourite和album都是sorted的。
 * <p>
 * 例子1：
 * album = [1, 2, 2, 3, 4, 5]
 * favourite = [1, 2, 2, 5]
 * 调用getPhoto 10次后的输出为：1 2 2 5 3 4 -1 -1 -1
 * <p>
 * 例子2：
 * album = []
 * favourite = []
 * 调用getPhoto 3次后的输出为: -1 -1 -1
 * <p>
 * 作者：长城上跑步
 * 链接：https://leetcode.cn/circle/discuss/YqC4Gz/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Google {

    int[] album;
    int[] favourite;
    int i, j, k;
    int max = 0;
    int size = 0;

    public int[] getPhoto(int[] album, int[] favourite, int times) {
        this.album = album;
        this.favourite = favourite;
        max = album[album.length - 1] + 1;

        int[] ans = new int[times];
        Arrays.fill(ans, -1);
        if (favourite.length == 0) {
            for (int i = 0; i < album.length && i < times; i++) {
                ans[i] = album[i];
            }
            return ans;
        }
        this.i = 0;
        this.j = 0;
        this.k = -1;
        for (int l = 0; l < times; l++) {
            ans[l] = getNextPhoto();
        }
        return ans;
    }

    public int getNextPhoto() {
        size++;
        if (j == favourite.length) {
            if (size > album.length) {
                return -1;
            }
            if(k == -1) {
                int res = album[i];
                i++;
                return res;
            }

            // get from k
            while (k < album.length) {
                int res = album[k];
                k++;
                while (k < album.length && album[k] > max) {
                    k++;
                }
                return res;
            }
        }
        // get a favorite one
        if (album[i] == favourite[j]) {
            int res = album[i];
            album[i] = album[i] + max;
            i++;
            j++;
            return res;
        }
        while (album[i] != favourite[j]) {
            if (k == -1) {
                k = i;
            }
            i++;
        }
        int res = album[i];
        album[i] = album[i] + max;
        i++;
        j++;
        return res;
    }

    public static void main(String[] args) {
        Google google = new Google();
        int[] album = {1, 2, 2, 3, 4, 5};
        int[] favorite = {1, 5};
        int[] photo = google.getPhoto(album, favorite, 3);
        for (int i : photo) {
            System.out.println(i);
        }
    }
}
