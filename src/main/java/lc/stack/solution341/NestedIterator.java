package lc.stack.solution341;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author enyi.lr
 * @version $Id: NestedIterator.java, v 0.1 2019‐10‐14 7:20 PM enyi.lr Exp $$ 341. Flatten Nested List Iterator use recursive method to
 * solve the problem. Recursive method will use stack.
 * v2
 */
public class NestedIterator implements Iterator<Integer> {
    List<NestedInteger> nestedList;
    List<Integer>       result;
    int                 position = 0;

    Stack<Integer> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        result = getList(nestedList);
    }

    public List<Integer> getList(List<NestedInteger> nestedList) {
        List<Integer> result = new ArrayList<>();
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                result.add(nestedInteger.getInteger());
            } else {
                List<Integer> list = getList(nestedInteger.getList());
                result.addAll(list);
            }
        }
        return result;
    }

    @Override
    public Integer next() {
        Integer next = result.get(position);
        position++;
        return next;
    }

    @Override
    public boolean hasNext() {
        return position < result.size();
    }

}