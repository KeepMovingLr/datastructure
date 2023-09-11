package maxheap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 索引堆：将数据和索引分开存储，表示堆的数组由索引表示，堆中的元素都是存储的index，进行siftUp 和 siftDown比较的时候都用data[index]去比较
 * when comparing, compare array data's value. but when swap, swap array indexes's value
 */
public class IndexMaxHeap<E extends Comparable<E>> {

    private ArrayList<E> data;
    private ArrayList<Integer> indexes;

    Map<Integer, Integer> reverseIndex = new HashMap<>();

    int capacity;
    int count = 0;

    public IndexMaxHeap(int capacity) {
        data = new ArrayList<>(capacity);
        indexes = new ArrayList<>(capacity);
        this.capacity = capacity;
    }


    /**
     * add an element to the heap and make sure it is still a heap
     * index: add to a place
     *
     * @param e
     */
    public void add(E e, int index) {
        data.set(index, e);
        indexes.add(index); // add to the end
        reverseIndex.put(index, indexes.size() - 1);
        count++;
        siftUp(indexes.size() - 1);
    }

    /**
     * get the max element from the heap
     *
     * @return
     */
    public E extractMax() {
        E ret = findMax();
        swap(indexes.get(0), indexes.get(indexes.size() - 1));
        data.remove(indexes.get(indexes.size() - 1));
        siftDown(0);
        return ret;
    }

    /**
     * @param index
     */
    public E getItem(int index) {
        return data.get(indexes.get(index));
    }

    public void change(int index, E element) {
        data.set(index, element);
        int indexInIndexes = reverseIndex.get(index);
        siftUp(indexInIndexes);
        siftDown(indexInIndexes);
    }

    // very important
    private void siftUp(int index) {
        while (index > 0 && data.get(index).compareTo(data.get(parent(index))) > 0) {
            swap(index, parent(index));
            index = parent(index);
        }

    }


    /**
     * notice, we can only swap index, no need to swap the real data.
     *
     * @param i
     * @param j
     */
    public void swap(int i, int j) {
        if (i < 0 || i >= capacity || j < 0 || j >= capacity) {
            throw new IllegalArgumentException("");
        }
        Integer temp1 = indexes.get(i);
        Integer temp2 = indexes.get(j);
        indexes.set(i, temp2);
        indexes.set(j, temp1);
        reverseIndex.put(temp2, i);
        reverseIndex.put(temp1, j);
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


    public E findMax() {
        if (data.isEmpty()) {
            throw new RuntimeException("heap is empty");
        }
        return data.get(indexes.get(0));
    }

    // very important
    private void siftDown(int index) {
        while (leftChild(index) < indexes.size()) {
            // get the index of the larger children
            int j = leftChild(index);
            if (j + 1 < indexes.size() && data.get(indexes.get(j)).compareTo(data.get(indexes.get(j + 1))) < 0) {
                j = rightChild(index);
            }
            if (data.get(indexes.get(index)).compareTo(data.get(indexes.get(j))) < 0) {
                swap(indexes.get(index), indexes.get(j));
                index = j;
            } else {
                break;
            }
        }
    }

}