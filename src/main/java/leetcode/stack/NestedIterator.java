package leetcode.stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * @author enyi.lr
 * @version $Id: NestedIterator.java, v 0.1 2019‐10‐14 7:20 PM enyi.lr Exp $$
 */
public class NestedIterator implements Iterator<Integer> {
    List<NestedInteger> nestedList;
    List<Integer>       result = new ArrayList<>();

    Stack<Integer> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                result.add(nestedInteger.getInteger());
            } else {

            }
        }
    }

    @Override
    public Integer next() {

    }

    @Override
    public boolean hasNext() {

    }
}