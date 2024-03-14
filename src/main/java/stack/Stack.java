package stack;

/**
 * @author enyi.lr
 * @version $Id: Stack.java, v 0.1 2019‐05‐16 11:20 PM enyi.lr Exp $$
 * Stack is widely used - undo operation in editor, system call stack ,Compiler bracket matching
 */
public interface Stack<E> {
    int getSize();

    boolean isEmpty();

    E pop();

    E peek();

    void push(E e);

}