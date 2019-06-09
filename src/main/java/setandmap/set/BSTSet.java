package setandmap.set;

import tree.BSTRecursion;

/**
 * @author enyi.lr
 * @version $Id: BSTSet.java, v 0.1 2019‐06‐09 6:54 PM enyi.lr Exp $$
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {
    private BSTRecursion<E> bst;

    public BSTSet() {
        this.bst = new BSTRecursion<>();
    }

    @Override
    public void add(E e) {
        bst.add_1(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}