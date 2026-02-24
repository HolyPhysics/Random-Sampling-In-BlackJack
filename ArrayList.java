/**
* Author: Chididebere Okafor 
* 
* Purpose of the class: A basic implementation of an ArrayList.
* that provides basic operations
* for adding and removing elements at the end of the ArrayList
* as well as getting and setting elements at a specified index.
*
* @param <T> the type of elements stored in the list
*/
public class ArrayList<T> {

    /** The underlying array of objects of type T */
    private T[] arr;

    /** The int number of elements in the ArrayList */
    private int size;

    /** 
     * The default constructor for the ArrayList
     */
    public ArrayList(){
        // TODO
       initializeArray(1);
       size = 0;

    }

    /** 
     * The constructor for the ArrayList with initialCapacity specified
     * 
     * @param initialCapacity the initial capacity of the ArrayList
     */
    public ArrayList(int initialCapacity){
        initializeArray(initialCapacity);
        size = 0;
    }


    /**
     * Returns the size of the Array List
     * 
     * @return the number of elements in the list
     */
    public int size() {
        return size;
    }

    /**
     * Adds an item to the end of the list.
     *
     * @param item the item to add to the list
     */
    public void add(T item) {
        //TODO

        int newCapacity = 0;

        if (size < arr.length){
            arr[size] = item;
        } else if (size == arr.length ){
            newCapacity = 2*size;
            changeCapacity(newCapacity);
        }

        // changeCapacity(newCapacity);

        // T[] newArr = (T[]) new Object[newCapacity];

        // for (int i = 0; i < size; i++){
        //     newArr[i] = arr[i];
        // }

        arr[size] = item;
        size +=1; // this updates the size to the right number
        // arr = newArr;
    }

    /**
     * Retrieves the element at the specified position in the list.
     *
     * @param index the position of the element to retrieve
     * @return the element at the specified position in the list
     */

    public T get(int index) {
        //TODO
        return arr[index];
    }

    /**
     * Sets the element at the specified position in the list to item.
     *
     * @param item the item to set the list element to
     * @param index the position of the list element to set
     */
    public void set(int index, T item) {
        //TODO
        arr[index] = item;
    }

    /**
     * Removes and returns the element at index
     *
     * @return the removed element of the list
     */
    public T remove(int index) {
        T out = arr[index];

        //Move all of the elements after index back one
        //to account for the removed item
        for (int i = index+1; i < size; i++) {
            arr[i-1] = arr[i];
        }
        size -- ;
        arr[size] = null; // resets the element at index == size to null

        return out;
    }

    /**
     * Resizes the underlying array to have size newCapacity
     *
     * @param newCapacity the new capacity of the ArrayList
     */
    private void changeCapacity(int newCapacity) {
        T[] oldArr = arr;
        initializeArray(newCapacity);

        for (int i = 0; i < size; i++) {
            arr[i] = oldArr[i];
        }
    }

    /**
     * Creates an underlying Array of size capacity 
     *
     * @param capacity the capacity of the ArrayList
     */
    @SuppressWarnings("unchecked")
    private void initializeArray(int capacity) {
        arr = (T[]) new Object[capacity];
    } 

    /**
     * Overrides the build in toString method to meaningfully print the ArrayList
     *
     * @return the String representation of the ArrayList
     */
    @Override 
    public String toString() {
         String output = "[" ;
         for (int i = 0; i < size; i++) {
            output += arr[ i ] ; 
            if ( i < ( size - 1 ) ) {
                output += ", " ;
            }
        }
        output += "]" ;
        return output ;
    }

}