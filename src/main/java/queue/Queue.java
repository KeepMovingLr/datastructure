package queue;

/**
 * @author enyi.lr
 * @version $Id: Queue.java, v 0.1 2019‐05‐18 4:17 PM enyi.lr Exp $$
 */
public interface Queue<E> {
    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}