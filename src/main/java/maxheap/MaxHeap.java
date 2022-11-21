package maxheap;

import array.Array;

import java.util.Random;

/**
 * @author enyi.lr
 * @version $Id: MaxHeap.java, v 0.1 2019‐05‐25 1:59 PM enyi.lr Exp $$
 * When the store element from index 0
 * parent(i) = (i - 1) / 2;
 * left child(i) = 2*i + 1;
 * right child(i) = 2*i + 2;
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(E[] array) {
        data = new Array(array);
        heapify(data);
    }

    /**
     * the size of the heap
     *
     * @return
     */
    public int size() {
        return data.getSize();
    }

    /**
     * if the heap is empty
     *
     * @return
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * return the parent index
     *
     * @param index
     * @return
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index 0 do not have parent");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * add an element to the heap and make sure it is still a heap
     *
     * @param e
     */
    public void add(E e) {
        data.addLast(e);
        int index = data.getSize() - 1;
        siftUp(index);
    }

    /**
     * get the max element from the heap
     *
     * @return
     */
    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    public E findMax() {
        if (data.isEmpty()) {
            throw new RuntimeException("heap is empty");
        }
        return data.get(0);
    }

    // very important
    private void siftUp(int index) {
        while (index > 0 && data.get(index).compareTo(data.get(parent(index))) > 0) {
            data.swap(index, parent(index));
            index = parent(index);
        }

    }

    // very important
    private void siftDown(int index) {
        while (leftChild(index) < data.getSize()) {
            // get the index of the larger children
            int j = leftChild(index);
            if (j + 1 < data.getSize() && data.get(j).compareTo(data.get(j + 1)) < 0) {
                j = rightChild(index);
            }
            if (data.get(index).compareTo(data.get(j)) < 0) {
                data.swap(index, j);
                index = j;
            } else {
                break;
            }
        }
    }

    public E replace(E newElement) {
        E max = findMax();
        data.set(0, newElement);
        siftDown(0);
        return max;
    }

    public void heapify(Array array) {
        int size = array.getSize();
        // get the last non leaf node
        int parent = parent(size - 1);
        for (int i = parent; i <= 0; i--) {
            siftDown(i);
        }
    }

    public static void main(String[] args) {
        int n = 1000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new RuntimeException();
            }
        }
        System.out.println("complete");




    }

}