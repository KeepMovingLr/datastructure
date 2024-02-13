package segmenttree.usage;

class MyCalendarTwo {

    class Node {
        int l, r, m; //[l , r)
        int meetings;
        int lazyVal;
        int lazyLeft, lazyRight;
        Node leftChild;
        Node rightChild;

        public Node(int l, int r) {
            this.l = l;
            this.r = r;
            this.m = l + (r - l) / 2;
        }
    }

    Node root = null;

    public MyCalendarTwo() {
        root = new Node(0, (int) 1e9);
    }

    public boolean book(int start, int end) {
        if (available(root, start, end)) {
            book(root, start, end);
        }
        return false;
    }

    // book [start , end)
    public void book(Node root, int start, int end) {
        if (root.lazyVal != 0) {
            root.meetings += root.lazyVal;
            root.lazyLeft += root.lazyVal;
            root.lazyRight += root.lazyVal;
            root.lazyVal = 0;
        }
        if (root.l == start && end == root.r) {
            root.meetings++;
            return;
        }
        if (end <= root.m) {
            if (root.leftChild == null) {
                root.leftChild = new Node(root.l, root.m);
                root.leftChild.lazyVal = root.lazyLeft;
                root.lazyLeft = 0;
            }
            book(root.leftChild, start, end);
            return;
        }
        if (start >= root.m) {
            if (root.rightChild == null) {
                root.rightChild = new Node(root.m, root.r);
                root.rightChild.lazyVal = root.lazyRight;
                root.lazyRight = 0;
            }
            book(root.rightChild, start, end);
            return;
        }
        if (root.leftChild == null) {
            root.leftChild = new Node(root.l, root.m);
            root.leftChild.lazyVal = root.lazyLeft;
            root.lazyLeft = 0;
        }
        book(root.leftChild, start, root.m);
        if (root.rightChild == null) {
            root.rightChild = new Node(root.m, root.r);
            root.rightChild.lazyVal = root.lazyRight;
            root.lazyRight = 0;
        }
        book(root.rightChild, root.m, end);
    }

    public boolean available(Node root, int start, int end) {
        if (root.lazyVal != 0) {
            root.meetings += root.lazyVal;
            root.lazyLeft += root.lazyVal;
            root.lazyRight += root.lazyVal;
            root.lazyVal = 0;
        }
        if (start <= root.l && end >= root.r) {
            return root.meetings < 2;
        }

        if (end <= root.m) {
            if (root.leftChild == null) {
                root.leftChild = new Node(root.l, root.m);
                root.leftChild.lazyVal = root.lazyLeft;
                root.lazyLeft = 0;
            }
            return available(root.leftChild, start, end);
        }
        if (start >= root.m) {
            if (root.rightChild == null) {
                root.rightChild = new Node(root.m, root.r);
                root.rightChild.lazyVal = root.lazyRight;
                root.lazyRight = 0;
            }
            return available(root.rightChild, start, end);
        }
        if (root.leftChild == null) {
            root.leftChild = new Node(root.l, root.m);
            root.leftChild.lazyVal = root.lazyLeft;
            root.lazyLeft = 0;
        }
        if (root.rightChild == null) {
            root.rightChild = new Node(root.m, root.l);
            root.rightChild.lazyVal = root.lazyRight;
            root.lazyRight = 0;
        }
        return available(root.leftChild, start, root.m) && available(root.rightChild, root.m, end);
    }

    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        myCalendarTwo.book(10, 20);
        myCalendarTwo.book(50, 60);
        myCalendarTwo.book(10, 40);
        myCalendarTwo.book(5, 15);
        myCalendarTwo.book(5, 10);
        myCalendarTwo.book(25, 55);
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */