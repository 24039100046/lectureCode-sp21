/** Array based list.
 *  @author Josh Hug
 */

public class AList {
    private int[] list;
    private int size;
    /** Creates an empty list. */
    public AList() {
        list = new int[1];
        size = 0;
    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if (size == list.length) {
            resizeList(list.length * 2);
        }
        list[size] = x;
        size++;
    }

    /**
     * Resizes the list.
     */
    private void resizeList(int n) {
        int[] newList = new int[n];
        System.arraycopy(list, 0, newList, 0, size);
        list = newList;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        if (size != 0) {
            return list[size - 1];
        }
        return 0;
    }

    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return list[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
      * returns deleted item. */
    public int removeLast() {
        //int temp = list[size];
        int temp = getLast();
        //data abstraction
        list[size] = 0;
        //There is no need to destroy it when it is basic type.
        //While it is good to destroy it when it is reference type.
        size--;
        if (size < list.length / 4) {
            //usage ratio 25%
            resizeList(list.length / 2);
        }
        return temp;
    }
} 