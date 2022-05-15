package lesson10;

import java.util.*;

public class MyArrayListTrain<T> extends AbstractList<T> implements List<T> {
    private int capacity;
    private Object[] array;
    private int size;
    private static final int CAPACITY = 10;
    private static final double EXTENSION = 1.5;
    private int modCount = 0;

    private String brand;


    public MyArrayListTrain(String brand) {
        this.brand = brand;
    }

    public MyArrayListTrain() {
        capacity = CAPACITY;
        array = new Object[capacity];
    }

    public MyArrayListTrain(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    private void ensureCapacity(int tempSize) {
        if (size + tempSize >= capacity) {
            capacity *= EXTENSION;
            ensureCapacity(tempSize);
        } else {
            Object[] newArray = new Object[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
    }

    private void indexCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index might be less than size and bigger than 0. Size: " + size + ".");
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(Object value) {
        ensureCapacity(1);
        array[size++] = value;
        modCount++;
        return true;
    }

    @Override
    public void add(int index, Object o) {
        indexCheck(index);
        ensureCapacity(1);
        int toAdd = size - index;
        System.arraycopy(array, index, array, index + 1, toAdd);
        array[index] = (T) o;
        size++;
        modCount++;
    }


    @Override
    public boolean addAll(Collection c) {
        Object[] tempArray = c.toArray();
        ensureCapacity(tempArray.length);
        System.arraycopy(tempArray, 0, array, size, tempArray.length);
        return true;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        Object[] tempArray = c.toArray();
        ensureCapacity(tempArray.length - index + 1);
        System.arraycopy(tempArray, index, array, size, tempArray.length);
        return true;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }


    @Override
    public T get(int index) {
        indexCheck(index);
        return (T) array[index];

    }

    @Override
    public Object set(int index, Object element) {
        indexCheck(index);
        array[index] = (T) element;
        modCount++;
        return (T) array[index];
    }


    @Override
    public boolean remove(Object value) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                remove(i);
            }
        }
        return true;
    }

    @Override
    public T remove(int index) {
        indexCheck(index);
        T returnValue = (T) array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[--size] = null;
        modCount++;
        return returnValue;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }


    public ListIterator listIterator() {
        return new ListIterator<T>() {
            int index = 0;
            int modCount = MyArrayListTrain.this.modCount;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return (T) array[index++];
            }

            @Override
            public boolean hasPrevious() {
                return index > 0;
            }


            @Override
            public T previous() {
                return (T) array[--index];
            }


            @Override
            public int nextIndex() {
                return index + 1;
            }

            @Override
            public int previousIndex() {
                return index - 1;
            }


            @Override
            public void remove() {
                MyArrayListTrain.this.remove(index--);
            }


            @Override
            public void set(T t) {
                MyArrayListTrain.this.set(index, t);
                modCount++;
            }


            @Override
            public void add(T t) {
                MyArrayListTrain.this.add(index, t);
                modCount++;
            }

            private void checkMods() {
                if (modCount != MyArrayListTrain.this.modCount) {
                    throw new ConcurrentModificationException();
                }
            }
        };
    }

    @Override
    public String toString() {
        return "MyArrayListTrain{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
