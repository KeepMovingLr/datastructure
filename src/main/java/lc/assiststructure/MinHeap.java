package lc.assiststructure;

import java.util.ArrayList;

/**
 * @author enyi.lr
 * @version $Id: MinHeap.java, v 0.1 2019‐05‐17 12:53 AM enyi.lr Exp $$
 */
public class MinHeap {
    private ArrayList<Integer> data;

    public MinHeap() {
        data = new ArrayList<Integer>();
    }

    private int parentIndex(int index) {
        if (index == 0) {
            throw new RuntimeException();
        }
        return (index - 1) / 2;
    }

    private int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int righthildIndex(int index) {
        return index * 2 + 2;
    }

    public void add(int e) {
        data.add(e);
        if (data.size() > 1) {
            int parent = parentIndex(data.size() - 1);
            if (data.get(parent) > e) {
                data.add(data.size()-1,data.get(parent));
                data.add(parent,e);
            }
        }

    }

    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<Integer>();
        data.add(11);
        data.add(22);
        data.remove(0);
        data.add(0,1);
        System.out.println(data);
    }

}