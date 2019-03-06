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
        for (int i = 0; i < capacity; i++) {
            temp += array[i] + (i == capacity - 1 ? "" : ", ");
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
      Double the capacity of the List_inArraySlots,
      preserving existing data
     */
     private void expand() {
        System.out.println( "expand... (for debugging)");

        int[] oldArray = array;
        array = new int[oldArray.length * 2];

        for (int i = 0; i < oldArray.length; i++) {
            array[i] = oldArray[i];
        }

           /* S.O.P. rules for debugging:
              Working methods should be silent. But during
              development, the programmer must verify that
              this method is called when that is appropriate.
              So test using the println(), then comment it out.
              */
     }
}
