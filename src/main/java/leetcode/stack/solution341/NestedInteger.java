/**
 * Alipay.com Inc. Copyright (c) 2004‐2019 All Rights Reserved.
 */
package leetcode.stack.solution341;

import java.util.List;

/**
 * @author enyi.lr
 * @version $Id: NestedInteger.java, v 0.1 2019‐10‐14 7:21 PM enyi.lr Exp $$
 */
public interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}