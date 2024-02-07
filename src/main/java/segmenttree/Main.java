package segmenttree;

/**
 * @author enyi.lr
 * @version $Id: Main.java, v 0.1 2019‐06‐01 1:56 PM enyi.lr Exp $$
 */
public class Main {
    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);
        System.out.println(segmentTree);

        System.out.println(segmentTree.query(0, 2));
        segmentTree.set(5 , 2);
        System.out.println(segmentTree.query(2, 5));
        System.out.println(segmentTree.query(0, 5));
        MySegmentTree<Integer> mySegmentTree = new MySegmentTree<>(nums, (a, b) -> a + b);
        System.out.println(mySegmentTree.query(0, 2));
        mySegmentTree.update(5 , 2);
        System.out.println(mySegmentTree.query(2, 5));
        System.out.println(mySegmentTree.query(0, 5));
    }

}