/**
 * Implement a list of diverse types, including integers, double-precision
 * floating point numbers, and Strings.
 */

public class List_inArraySlots {

    private int[] intElements;
    private double[] doubleElements;
    private String[] stringElements;
    private int filledElements; // the number of elements in this list

    /*
     * type identifier for each element That is, typeOfElements[i] == 0 means
     * element i is an integer; 1 means element i is a double; 2 means element i is
     * a String. Optional extra education in programming (not comp sci): replace
     * these "magic numbers" with an "enumerated type".
     */
    private int[] typeOfElements;

    private static final int INITIAL_CAPACITY = 10;

    private static final int INT_TYPE = 0;
    private static final int DOUBLE_TYPE = 1;
    private static final int STRING_TYPE = 2;

    /**
     * Construct an empty list with a small initial capacity.
     */
    public List_inArraySlots() {
        intElements = new int[INITIAL_CAPACITY];
        doubleElements = new double[INITIAL_CAPACITY];
        stringElements = new String[INITIAL_CAPACITY];

        typeOfElements = new int[INITIAL_CAPACITY];
    }

    /**
     * @return the number of elements in this list
     */
    public int size() {
        return filledElements;
    }

    /**
     * @return a string representation of this list, in [a,b,c,] format
     */
    public String toString() {
        String temp = "[";
        for (int i = 0; i < filledElements - 1; i++) {
            temp += representationAtIndex(i) + ", ";
        }
        if (filledElements > 0) {
            temp += representationAtIndex(filledElements - 1);
        }
        temp += "]";
        return temp;
    }

    private String representationAtIndex(int i) {
        switch (typeOfElements[i]) {
        case INT_TYPE:
            // "" for conversion to String
            return "" + intElements[i];
        case DOUBLE_TYPE:
            return "" + doubleElements[i];
        case STRING_TYPE:
            return "\"" + stringElements[i] + "\"";
        default:
            return "!!!INTERNAL LOGIC ERROR!!!";
        }
    }

    /**
     * Appends @value to the end of this list.
     * 
     * @return true, in keeping with conventions yet to be discussed
     */
    public boolean add(int type, int intValue, double doubleValue, String stringValue) {
        if(filledElements >= intElements.length) {
            expand();
        }
        typeOfElements[filledElements] = type;
        switch (type) {
            case INT_TYPE:
            intElements[filledElements] = intValue;
            break;
            case DOUBLE_TYPE:
            doubleElements[filledElements] = doubleValue;
            break;
            case STRING_TYPE:
            stringElements[filledElements] = stringValue;
            break;
        }
        filledElements++;
        return true;
    }

    public GetValue get(int i) {
        GetValue value = new GetValue();
        value.type = typeOfElements[i];
        value.intValue = intElements[i];
        value.doubleValue = doubleElements[i];
        value.stringValue = stringElements[i];
        return value;
    }

    private void expand() {
        //System.out.println( "expand... (for debugging)");

        intElements = copyIntArray(intElements, intElements.length * 2);
        doubleElements = copyDoubleArray(doubleElements, doubleElements.length * 2);
        stringElements = copyStringArray(stringElements, stringElements.length * 2);
        typeOfElements = copyIntArray(typeOfElements, typeOfElements.length * 2);
     }

     private static int[] copyIntArray(int[] copy, int copyLength) {
        int[] array = new int[copyLength];
        for (int i = 0; i < copy.length; i++) {
            array[i] = copy[i];
        }
        return array;
     }

     private static double[] copyDoubleArray(double[] copy, int copyLength) {
        double[] array = new double[copyLength];
        for (int i = 0; i < copy.length; i++) {
            array[i] = copy[i];
        }
        return array;
     }

     private static String[] copyStringArray(String[] copy, int copyLength) {
        String[] array = new String[copyLength];
        for (int i = 0; i < copy.length; i++) {
            array[i] = copy[i];
        }
        return array;
     }
}