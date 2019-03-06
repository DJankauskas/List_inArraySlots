# List_inArraySlots
[AP CS] An implementation of a resizeable array in Java.

Contributors: Darius Jankauskas and Greg Zborovsky

# Class Fields, Constructor, and Methods

private Object[] array;
private int listLength;

public MyList();

public MyList(Object[] array);

public MyList(MyList list); //Used to make a copy

public void add(int index);

public void add(int index, Object obj);

public Object remove(int index);

public Object get(int index);

public void set(int index, Object obj);

public int length();

public void map(Function func);

public MyList subList(int start);

public MyList subList(int start, end);

public int find(Object object);

public int count(Object object);

public String toString();

public boolean equals(Object obj);


# Features

* Add an element to a specific position
* Remove an element from a specific position
* Access and change the value of an element at a specific position
* Length of the list
* Extra features
  - Apply a function to every element
  - Concatenate and split the list
  - Find the index of a certain element
  - Support null values
  - Make a copy of a list
  - Count the number of times a certain element appears in a list
