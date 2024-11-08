package queue;

/**
 * @author enyi.lr
 * @version $Id: LoopQueue.java, v 0.1 2019‐05‐18 4:30 PM enyi.lr Exp $$
 * no need to move data in queue when we implement queue by using an array
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;

    // tail always point to the next element location to be added
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        // as we need waste one element to check if the queue is full
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if (isFull()) {
            // 扩容
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        size++;
        tail = (tail + 1) % data.length;
    }

    /**
     * time complexity is O(1) average, much better than previous implementation which is O(n)
     * @return
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("can not dequeue from an empty queue.");
        }
        E frontE = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (needReduceCapacity() && (getCapacity() / 2) != 0) {
            resize(getCapacity() / 2);
        }
        return frontE;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new RuntimeException("can not dequeue from an empty queue.");
        }
        return data[front];
    }

    public boolean isFull() {
        return (tail + 1) % data.length == front;
    }

    public boolean needReduceCapacity() {
        if (size == getCapacity() / 4) {
            return true;
        } else {
            return false;
        }
    }

    public int getCapacity() {
        return data.length - 1;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + i) % data.length];
        }

        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", size, getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail) { res.append(", "); }
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);
            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }

}