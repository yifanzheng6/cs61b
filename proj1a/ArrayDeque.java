/** LinkedListDeque for proj1 cs61b.
 * @author Yifan
 * 9/13/2020
 **/
public class ArrayDeque<T> {

    /** initial array with length 8. */
    private T[] items = (T []) new Object[8];
    /** initial size is 0. */
    private int size = 0;
    /** randomly pick a next First as 4. */
    private int nextFirst = 4, nextLast = 5;
    /** empty array. */
    public ArrayDeque() {
    }

    /**
     * @param item add item to the nextFirst.
     */
    public void addFirst(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        size += 1;
        if (nextFirst == 0) {
            nextFirst = items.length - 1;
        } else {
            nextFirst -= 1;
        }
    }

    /**
     * @param item add item to the nextLast.
     */
    public void addLast(T item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[nextLast] = item;
        size += 1;
        if (nextLast == items.length - 1) {
            nextLast = 0;
        } else {
            nextLast += 1;
        }

    }

    /**
     * @return if list is empty.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return list size
     */
    public int size() {
        return size;
    }

    /**
     * remove the first item.
     * @return the first item
     */
    public T removeFirst() {
        size -= 1;
        T returnItem;
        if (nextFirst == items.length - 1) {
            returnItem = items[0];
            nextFirst = 0;
        } else {
            returnItem = items[nextFirst + 1];
            nextFirst += 1;
        }
        double f = (double) size / items.length;
        if (size > 16 && f < 0.25) {
            shrink();
        }
        return returnItem;
    }

    /**
     * remove the last item.
     * @return the last item.
     */
    public T removeLast() {
        size -= 1;
        T returnItem;
        if (nextLast == 0) {
            returnItem = items[items.length - 1];
            nextLast = items.length - 1;
        } else {
            returnItem = items[nextLast - 1];
            nextLast -= 1;
        }
        double f = (double) size / items.length;
        if (size > 16 && f < 0.25) {
            shrink();
        }
        return returnItem;
    }

    /**
     * @param index given index
     * @return item given index
     */
    public T get(int index) {
        int temp = index + nextFirst + 1;
        if (temp >= items.length) {
            return items[temp - items.length];
        } else {
            return items[temp];
        }
    }

    /**
     * resize if size is not big enough.
     * @param capacity resize to capacity.
     */
    private void resize(int capacity) {
        T[] newitems = (T []) new Object[capacity];
        if (nextLast == 0) {
            System.arraycopy(items, 0, newitems, 0, size);
            nextFirst = newitems.length - 1;
            nextLast = size;
        } else {
            System.arraycopy(items, 0, newitems, 0, nextLast);
            System.arraycopy(items, nextFirst + 1,
                    newitems, capacity - items.length + nextLast,
                    items.length - nextLast);
            nextFirst = nextFirst + newitems.length - items.length;
        }
        items = newitems;
    }

    /** if usage rate is less than 25%, shrink to 50%. */
    private void shrink() {
        T[] newitems = (T []) new Object[2 * size];
        if (nextFirst == items.length - 1) {
            System.arraycopy(items, 0, newitems, 0, size);
            nextFirst = newitems.length - 1;
        } else {
            System.arraycopy(items, 0, newitems, 0, nextLast);
            System.arraycopy(items, nextFirst + 1,
                    newitems, size + nextLast,
                    items.length - nextFirst - 1);
            nextFirst = size + nextLast - 1;
        }
    }

    /** Print the items in the deque from first to last. */
    public void printDeque() {
        int i;
        if (nextFirst == items.length - 1) {
            i = 0;
        } else {
            i = nextFirst + 1;
        }
        int j = 0;
        while (j < size && i < items.length) {
            System.out.print(get(j) + " ");
            i += 1;
            j += 1;
        }
        if (j < size) {
            int k = j;
            int h = 0;
            while (j < size) {
                System.out.print(get(h + k) + " ");
                h += 1;
                j += 1;
            }
        }
        System.out.println();
    }
}
