/**
  Implement a list of integer elements, including
  both data and operations.
 */

public class List_inArraySlots {

    // declare fields here

    private int[] array;
    private int capacity;

    /**
      Construct an empty list with a small initial capacity.
     */
    public List_inArraySlots() {
        array = new int[8];
        capacity = 0;
    }

    //not part of hw, but a useful convinience constructor
    //copies list

    public List_inArraySlots(List_inArraySlots copy) {
        capacity = copy.capacity;
        array = copyArray(copy.array, copy.array.length);
    }


    /**
      @return the number of elements in this list
     */
    public int size() {
        return capacity;
    }


     /**
       @return a string representation of this list,
       in [a,b,c,] format
      */
    public String toString() {
        String temp = "[";
        int i;
        //prints all but last element of list so no trailing comma is shown
        for (i = 0; i < capacity - 1; i++) {
            temp += array[i] + ", ";
        }
        //prints last element, if the container isn't empty
        if(capacity > 0) {
            temp += array[i];
        }
        temp += "]";
        return temp;
    }


    /**
      Appends @value to the end of this list.

      @return true, in keeping with conventions yet to be discussed
     */
     public boolean add( int value) {
         if (capacity >= array.length) {
             expand();
         }
         array[capacity++] = value;
         return true;
     }

     /**
      accessor
      @return element @index from this list
      precondition: @index is within the bounds of the array.
          (Having warned the user about this precondition,
           you should NOT complicate your code to check
           whether user violated the condition.)
     */
    public int get(int index) {
        return array[index];
    }


    /**
      Set value at @index to @newValue
      @return old value at @index
      @precondition: @index is within the bounds of this list.
     */
    public int set(int index, int newValue) {
        int old = get(index);
        array[index] = newValue;
        return old;
    }


    /**
      Insert @value at position @index in this list.
      Shift the element currently at that position (if any)
      and any subsequent elements to the right
      (that is, increase the index associated with each).
     */
     public void add(int index, int value) {
        if( capacity >= array.length) {
            expand();
        }
        int previousValue = get(index);
        int nextValue;
        for (int setIndex = index; setIndex < capacity; setIndex++) {
            nextValue = array[setIndex + 1];
            array[setIndex + 1] = previousValue;
            previousValue = nextValue;
        }
        array[index] = value;
        capacity++;
     }


    /**
      Remove the element at position @index in this list.
      Shift any subsequent elements to the left (that is,
      decrease the index associated with each).
      @return the value that was removed from the list
     */
     public int remove( int index) {
         int old = get(index);
        for (int setIndex = index; setIndex < capacity - 1; setIndex++) {
            array[setIndex] = array[setIndex + 1];
        }
        capacity--;
        return old;
     }


    /**
      Double the capacity of the List_inArraySlots,
      preserving existing data
     */
     private void expand() {
        //System.out.println( "expand... (for debugging)");

        array = copyArray(array, array.length * 2);

           /* S.O.P. rules for debugging:
              Working methods should be silent. But during
              development, the programmer must verify that
              this method is called when that is appropriate.
              So test using the println(), then comment it out.
              */
     }

     

     //copies an array into another with specified length
     //copyLength MUST be greater than or equal to the length of the copy array!
     private static int[] copyArray(int[] copy, int copyLength) {
        int[] array = new int[copyLength];
        for (int i = 0; i < copy.length; i++) {
            array[i] = copy[i];
        }
        return array;
     }
}
