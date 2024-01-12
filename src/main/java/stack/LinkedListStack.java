package stack;

import linkedlist.LinkedList;

/**
 * @author enyi.lr
 * @version $Id: LinkedListStack.java, v 0.1 2019‐05‐18 10:28 PM enyi.lr Exp $$
 * summary：对于链表，如果增删都在头部，时间复杂度为O(1)，所以利用了这个性质，Stack的链表实现，增删都在头部操作
 */
public class LinkedListStack<E> implements Stack<E> {
    LinkedList<E> list;

    public LinkedListStack() {
        this.list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    /**
     * Adding or removing data at the beginning of the list is much more faster than doing them at the end of the list
     * @return
     */
    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(list);
        return res.toString();
    }

    public static void main(String[] args) {

        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }

}