package lesson10;


import java.util.*;

public class MyLinkedList implements List {

    private Node<String> first;
    private Node<String> last;

    private int size = 0;

    public MyLinkedList() {

    }



    public MyLinkedList(Collection<String> list) {
        this();
        addAll(list);
    }

    private static class Node<E> {
        E element;
        Node<E> prev;
        Node<E> next;


        Node(E element, Node<E> prev, Node<E> next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }


    private Node<String> getNodeByIndex(int index) {
        Node<String> node;

        if (index < (this.size >> 1)) {
            node = this.first;

            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = this.last;

            for (int i = this.size - 1; i > index; i--) {
                node = node.prev;
            }
        }

        return node;
    }

    private boolean ifPossibleIndex(int index) {
        return index >= 0 && index <= this.size;
    }

    private void addNext(Object o) {
        if (!(o instanceof String s)) {
            return;
        }

        final var last = this.last;
        final var newNode = new Node<>(s, last, null);
        this.last = newNode;

        if (null == last) {
            this.first = newNode;
        } else {
            last.next = newNode;
        }

        this.size++;
    }


    private void addByIndex(Object o, Node<String> nextNode) {
        if (!(o instanceof String s)) {
            return;
        }

        final var prevNode = nextNode.prev;
        final var newNode = new Node<>(s, prevNode, nextNode);
        nextNode.prev = newNode;

        if (null == prevNode) {
            this.first = newNode;
        } else {
            prevNode.next = newNode;
        }

        this.size++;
    }

    //____________________________________________Method-1______________________________________________________________
    @Override
    public boolean add(Object o) {
        addNext(o);

        return true;
    }

    //____________________________________________Method-2______________________________________________________________
    @Override
    public void add(int index, Object o) {
        if (!ifPossibleIndex(index)) {
            return;
        }

        if (this.size != index) {
            addByIndex(o, getNodeByIndex(index));

            return;
        }

        addNext(o);
    }

    //____________________________________________Method-3______________________________________________________________
    @Override
    public boolean addAll(Collection c) {
        return addAll(this.size, c);
    }

    //____________________________________________Method-4______________________________________________________________
    @Override
    public boolean addAll(int index, Collection c) {
        Object[] list = c.toArray();
        int count = list.length;

        if (!ifPossibleIndex(index) || count == 0) {
            return false;
        }

        Node<String> prevNode;
        Node<String> nextNode;

        if (index == this.size) {
            nextNode = null;
            prevNode = this.last;
        } else {
            nextNode = getNodeByIndex(index);
            prevNode = nextNode.prev;
        }

        for (Object o : list) {
            if (o instanceof String s) {
                var next = new Node<>(s, prevNode, null);

                if (null == prevNode) {
                    this.first = next;
                } else {
                    prevNode.next = next;
                }

                prevNode = next;
            }
        }

        if (null == nextNode) {
            this.last = prevNode;
        } else {
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

        this.size += count;

        return true;
    }

    //____________________________________________Method-5______________________________________________________________
    @Override
    public void clear() {
        for (Node<String> node = this.first; null != node; ) {
            var next = node.next;
            node.element = null;
            node.prev = null;
            node.next = null;

            node = next;
        }

        this.first = null;
        this.last = null;
        this.size = 0;
    }

    //____________________________________________Method-6______________________________________________________________
    @Override
    public boolean contains(Object o) {
        if (null != o) {
            for (Node<String> node = this.first; null != node; node = node.next) {
                if (o.equals(node.element)) {
                    return true;
                }
            }
        } else {
            for (Node<String> node = this.first; null != node; node = node.next) {
                if (null == node.element) {
                    return true;
                }
            }
        }

        return false;
    }

    //____________________________________________Method-7______________________________________________________________
    @Override
    public String get(int index) {
        return getNodeByIndex(index).element;
    }


    //____________________________________________Method-8______________________________________________________________
    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    //____________________________________________Method-9______________________________________________________________
    @Override
    public String remove(int index) {
        final var item = getNodeByIndex(index);

        final String element = item.element;
        final Node<String> next = item.next;
        final Node<String> prev = item.prev;

        if (null == prev) {
            this.first = next;
        } else {
            prev.next = next;
            item.prev = null;
        }

        if (null == next) {
            this.last = prev;
        } else {
            next.prev = prev;
            item.next = null;
        }

        item.element = null;
        this.size--;

        return element;
    }

    //____________________________________________Method-10_____________________________________________________________
    @Override
    public boolean remove(Object o) {
        int index = 0;

        if (null != o) {
            for (Node<String> node = this.first; null != node; node = node.next) {
                if (o.equals(node.element)) {
                    remove(index);

                    return true;
                }

                index++;
            }
        } else {
            for (Node<String> node = this.first; null != node; node = node.next) {
                if (null == node.element) {
                    remove(index);

                    return true;
                }

                index++;
            }
        }

        return false;
    }

    //____________________________________________Method-11_____________________________________________________________
    @Override
    public String set(int index, Object o) {
        if (!ifPossibleIndex(index) || !(o instanceof String s)) {
            return null;
        }

        Node<String> node = getNodeByIndex(index);
        String old = node.element;
        node.element = s;

        return old;
    }

    //____________________________________________Method-12_____________________________________________________________
    @Override
    public int size() {
        return this.size;
    }

    //____________________________________________Method-13_____________________________________________________________
    @Override
    public Object[] toArray() {
        Object[] list = new Object[this.size];
        int index = 0;

        for (Node<String> node = this.first; null != node; node = node.next) {
            list[index++] = node.element;
        }

        return list;
    }

    //____________________________________________Method-14_____________________________________________________________
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');

        Object[] list = toArray();

        for (int i = 0; i < list.length; i++) {
            sb.append(list[i]);

            if (i != list.length - 1) {
                sb.append(',').append(' ');
            }
        }

        return sb.append(']').toString();
    }






    @Override
    public Iterator iterator() {
        return null;
    }



    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }
}

