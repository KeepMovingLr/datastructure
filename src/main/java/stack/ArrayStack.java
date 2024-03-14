package stack;

import array.Array;

/**
 * @author enyi.lr
 * @version $Id: ArrayStack.java, v 0.1 2019‐05‐16 11:21 PM enyi.lr Exp $$
 */
public class ArrayStack<E> implements Stack<E> {
    private Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }

    // time complexity O(1)
    @Override
    public int getSize() {
        return array.getSize();
    }

    // time complexity O(1)
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * time complexity O(1) 均摊复杂度
     */
    @Override
    public E pop() {
        return array.removeLast();
    }
    /**
     * time complexity O(1)
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    /**
     * time complexity O(1) 均摊复杂度
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if (i != array.getSize() - 1) { res.append(", "); }
        }
        res.append("] top");
        return res.toString();
    }

}