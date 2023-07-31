package Practica1;

import java.util.Arrays;
import java.util.Comparator;

public class Node<T extends Comparable<T>> {
    private T[] keys;
    private int keysSize;
    private Node<T>[] children;
    private int childrenSize;
    private Comparator <Node<T>> comparator = (Node<T> arg0, Node<T> arg1) -> arg0.getKey(0).compareTo(arg1.getKey(0));
    protected Node<T> parent;

    public Node(Node<T> parent, int maxKeySize, int maxChildrenSize) {
        this.parent = parent;
        this.keys = (T[]) new Comparable[maxKeySize + 1];
        this.keysSize = 0;
        this.children = new Node[maxChildrenSize + 1];
        this.childrenSize = 0;
    }

    public T getKey(int index) {
        return keys[index];
    }

    public int indexOf(T value) {
        for (int i = 0; i < keysSize; i++) {
            if (keys[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public void insertKey(T value) {
        keys[keysSize++] = value;
        Arrays.sort(keys, 0, keysSize);
    }

    public T removeKey(T value) {
        T removed = null;
        boolean found = false;
        if (keysSize == 0) {
            return null;
        }
        for (int i = 0; i < keysSize; i++) {
            if (keys[i].equals(value)) {
                found = true;
                removed = keys[i];
            } else if (found) {
                keys[i - 1] = keys[i];
            }
        }
        if (found) {
            keysSize--;
            keys[keysSize] = null;
        }
        return removed;
    }

    public T removeKey(int index) {
        if (index >= keysSize) {
            return null;
        }
        T value = keys[index];
        for (int i = index + 1; i < keysSize; i++) {
            keys[i - 1] = keys[i];
        }
        keysSize--;
        keys[keysSize] = null;
        return value;
    }

    public int numberOfKeys() {
        return keysSize;
    }

    public Node<T> getChild(int index) {
        if (index >= childrenSize) {
            return null;
        }
        return children[index];
    }

    public int indexOf(Node<T> child) {
        for (int i = 0; i < childrenSize; i++) {
            if (children[i].equals(child)) {
                return i;
            }
        }
        return -1;
    }

    public boolean insertChild(Node<T> child) {
        child.parent = this;
        children[childrenSize++] = child;
        Arrays.sort(children, 0, childrenSize, comparator);
        return true;
    }

    public boolean removeChild(Node<T> child) {
        boolean found = false;
        if (childrenSize == 0) {
            return found;
        }
        for (int i = 0; i < childrenSize; i++) {
            if (children[i].equals(child)) {
                found = true;
            } else if (found) {
                children[i - 1] = children[i];
            }
        }
        if (found) {
            childrenSize--;
            children[childrenSize] = null;
        }
        return found;
    }

    public Node<T> removeChild(int index) {
        if (index >= childrenSize) {
            return null;
        }
        Node<T> value = children[index];
        children[index] = null;
        for (int i = index + 1; i < childrenSize; i++) {
            children[i - 1] = children[i];
        }
        childrenSize--;
        children[childrenSize] = null;
        return value;
    }

    public int numberOfChildren() {
        return childrenSize;
    }

    public int getKeysSize() {
        return keysSize;
    }

    public int getChildrenSize() {
        return childrenSize;
    }
}
