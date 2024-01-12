package array;

/**
 * @author enyi.lr
 * @version $Id: Array.java, v 0.1 2019‐05‐15 12:02 PM enyi.lr Exp $$
 */
public class Array<E> {
    private E[] data;
    private int size;

    /**
     * constructor method
     *
     * @param capacity the capacity of the array
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    /**
     * time complexity O(n)
     * @param arr
     */
    public Array(E[] arr) {
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        size = arr.length;
    }

    /**
     * get the capacity of the array
     *
     * @return the capacity of the array
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * get the size of the array
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * add an element e to the location where it's index is index
     * time complexity O(n)
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        if (size == data.length) {
            resize(size * 2);
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;

    }

    public void addLast(E e) {
        add(size, e);
    }

    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * get the element which index is index
     * O(1)
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    /**
     * set the value which index is index to e
     *
     * @param index
     * @param e
     */
    public void set(int index, E e) {
        if (index < 0 || index >= size) { throw new IllegalArgumentException("Set failed. Index is illegal."); }
        data[index] = e;
    }

    /**
     * check weather the array contains element e
     * time complexity O(n)
     * @param e
     * @return
     */
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) { return true; }
        }
        return false;
    }

    /**
     * find the index of the element which value is
     * time complexity O(n)
     * @param e
     * @return
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) { return i; }
        }
        return -1;
    }

    /**
     * removed the element which index is index
     * time complexity O(n)
     * @param index
     * @return the value of the deleted element
     */
    public E remove(int index) {
        if (index < 0 || index >= size) { throw new IllegalArgumentException("Remove failed. Index is illegal."); }

        E ret = data[index];
        for (int i = index + 1; i < size; i++) { data[i - 1] = data[i]; }
        size--;
        data[size] = null; // loitering objects != memory leak

        if (size == data.length / 4 && data.length / 2 != 0) { resize(data.length / 2); }
        return ret;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    public E getLast() {
        return get(size - 1);
    }

    public E getFirst() {
        return get(0);
    }

    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("");
        }
        E temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) { res.append(", "); }
        }
        res.append(']');
        return res.toString();
    }

}