/** deque interface for proj1 cs61b.
 * @author Yifan
 * 9/17/2020
 **/
public interface Deque<T> {
    /**
     * check if deque if empty.
     * @return true if it is empty
     */
    default boolean isEmpty() {
        return size() == 0;
    };

    /**
     * add element to the front.
     * @param item added item to the front
     */
    void addFirst(T item);

    /**
     * add element to the last.
     * @param item added item to the last
     */
    void addLast(T item);

    /**
     * print the deque.
     */
    void printDeque();

    /**
     * @return size of deque
     */
    int size();

    /**
     * remove the first element.
     * @return the first element
     */
    T removeFirst();

    /**
     * remove the last element.
     * @return the last element
     */
    T removeLast();

    /**
     * get the value by index.
     * @param index target index
     * @return target value
     */
    T get(int index);
}
