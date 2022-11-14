package lc.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: MinStack155.java, v 0.1 2019‐05‐17 12:10 AM enyi.lr Exp $$
 */
public class MinStack155 {
    List<Integer> list;

    Integer       min;

    /**
     * initialize your data structure here.
     */
    public MinStack155() {
        list = new ArrayList<Integer>();
    }

    public void push(int x) {
        /*if (list.size() == 0) {
            min = x;
        } else {
            if (x < min) {
                min = x;
            }
        }*/
        list.add(x);
    }

    public void pop() {
        /*if (list.size() == 0) {
            throw new RuntimeException();
        }
        if (top() == min) {

        } else {

        }*/
        list.remove(list.size() - 1);
    }

    public int top() {
        if (list.size() == 0) {
            throw new RuntimeException();
        }
        return list.get(list.size() - 1);
    }

    public int getMin() {
        if (list.size() == 0) {
            throw new RuntimeException();
        }
        int min = list.get(0);
        for (Integer e : list) {
            if (e < min){
                min = e;
            }
        }
        return min;
    }

}