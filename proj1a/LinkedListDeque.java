/** LinkedListDeque for proj1 cs61b.
 * @author Yifan
 * 9/13/2020
 **/
public class LinkedListDeque<T> {

    /**
     * TNode: with prev, item, next.
     * */
    private class TNode {
        /** prev, next nodes of a TNode. */
        protected TNode prev, next;
        /** item is a TNode value. */
        protected T item;
        /**
         * construct a new TNode.
         * @param p prev.
         * @param i item.
         * @param n next.
         * */
        public TNode(TNode p, T i, TNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    /** sentinel for watching. */
    private TNode sentinel = new TNode(null, null, null);
     /** xnode for temp. */
    private TNode xnode;
    /** original size is 0. */
    private int size = 0;
    /** an empty Deque. */
    public LinkedListDeque() {
    }

    /**
     * a Deque with only one item.
     * @param x first item in list.


    public LinkedListDeque(T x) {
        xnode = new TNode(null, x, null);
        xnode.prev = xnode;
        xnode.next = xnode;
        sentinel.next = xnode;
        size += 1;
    } */

    /**
     * @param x add x to the front of list
     */
    public void addFirst(T x) {
        xnode = new TNode(null, x, null);
        if (size == 0) {
            sentinel.next = xnode;
            xnode.next = xnode;
            xnode.prev = xnode;

        } else {
            xnode.prev = sentinel.next.prev;
            xnode.next = sentinel.next;
            sentinel.next.prev.next = xnode;
            sentinel.next.prev = xnode;
            sentinel.next = xnode;
            xnode = null;

        }
        size += 1;
    }

    /** getFirst: returns the first item in the list.
    public T getFirst() {
        if (sentinel.next == null){
            return null;
        } else {
            return sentinel.next.item;
        }
    } */

    /** @param x adds x to the end of the list. */
    public void addLast(T x) {
        xnode = new TNode(null, x, null);
        if (size == 0) {
            sentinel.next = xnode;
            xnode.next = xnode;
            xnode.prev = xnode;
        } else {
            xnode.next = sentinel.next;
            xnode.prev = sentinel.next.prev;
            sentinel.next.prev.next = xnode;
            sentinel.next.prev = xnode;
            xnode = null;
        }
        size += 1;
    }

    /** size: returns the size of the list. */
    public int size() {
        return size;
    }

    /** returns true if deque is empty, false otherwise. */
    public boolean isEmpty() {
        return sentinel.next == null;
    }

    /** Print the items in the deque from first to last. */
    public void printDeque() {
        TNode temp = sentinel.next;
        while (temp.next != sentinel.next) {
            System.out.print(temp.item + " ");
            temp = temp.next;
        }
        System.out.println(temp.item);
    }

    /** removes and return the item at the front of the deque, or null. */
    public T removeFirst() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            T x = sentinel.next.item;
            sentinel.next = null;
            size -= 1;
            return x;
        } else {
            T x = sentinel.next.item;
            sentinel.next.next.prev = sentinel.next.prev;
            sentinel.next.prev.next = sentinel.next.next;
            sentinel.next = sentinel.next.next;
            size -= 1;
            return x;
        }
    }

    /** remove and returns the item at the back, or null. */
    public T removeLast() {
        if (size == 0) {
            return null;
        } else if (size == 1) {
            T x = sentinel.next.item;
            sentinel.next = null;
            size -= 1;
            return x;
        } else {
            T x = sentinel.next.prev.item;
            sentinel.next.prev = sentinel.next.prev.prev;
            sentinel.next.prev.next = sentinel.next;
            size -= 1;
            return x;
        }
    }

    /**
     * @param index gavin index.
     * @return gets the item at the given index.
     */
    public T get(int index) {
        int i = index;
        TNode t = sentinel;
        while (i != 0) {
            t = t.next;
            i -= 1;
        }
        return t.next.item;
    }

    /**
     * @param index gavin index.
     * @return recursively gets the item at the given index.
     */
    public T getRecursive(int index) {
        if (index == 0) {
            return sentinel.next.item;
        } else {
            LinkedListDeque<T> temp = new LinkedListDeque<>();
            temp.sentinel.next = this.sentinel.next.next;
            return temp.getRecursive(index - 1);
        }
    }

    /** public static void main (String[] args){
        LinkedListDeque<Integer> L = new LinkedListDeque();
        int i = 0;
        int temp = 0;
        while (i<10) {
            L.addFirst(i*11);
            temp = L.getRecursive(i);
            i += 1;
        }
    } */
}
