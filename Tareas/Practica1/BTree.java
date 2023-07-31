package Practica1;

import java.util.LinkedList;
import java.util.Queue;

public class BTree<T extends Comparable<T>> {
    private int minKeySize;
    private int maxKeySize;
    private int maxChildrenSize;
    private int minChildrenSize;
    private Node<T> root = null;

    public BTree(int order) {
        this.minKeySize = order / 2;
        this.minChildrenSize = (order - 1) / 2;
        this.maxKeySize = order - 1;
        this.maxChildrenSize = order;
    }

    public boolean add(T value) {
        if (searchNode(value) != null) {
            return false;
        }
        if (root == null) {
            root = new Node<T>(null, maxKeySize, maxChildrenSize);

            root.insertKey(value);
        } else {
            Node<T> node = root;
            while (node != null) {
                if (node.numberOfChildren() == 0) {
                    node.insertKey(value);
                    if (node.numberOfKeys() <= maxKeySize) {
                        break;
                    }
                    split(node);
                    break;
                }

                T lesser = node.getKey(0);
                if (value.compareTo(lesser) <= 0) {
                    node = node.getChild(0);
                    continue;
                }

                int numberOfKeys = node.numberOfKeys();
                int last = numberOfKeys - 1;
                T greater = node.getKey(last);
                if (value.compareTo(greater) > 0) {
                    node = node.getChild(numberOfKeys);
                    continue;
                }

                for (int i = 1; i < node.numberOfKeys(); i++) {
                    T prev = node.getKey(i - 1);
                    T next = node.getKey(i);
                    if (value.compareTo(prev) > 0 && value.compareTo(next) <= 0) {
                        node = node.getChild(i);
                        break;
                    }
                }
            }
        }
        return true;
    }

    private void split(Node<T> nodeToSplit) {
        Node<T> node = nodeToSplit;
        int numberOfKeys = node.numberOfKeys();
        int midIndex = numberOfKeys / 2;

        if (numberOfKeys % 2 == 0) {
            midIndex--;
        }

        T medianValue = node.getKey(midIndex);

        Node<T> left = new Node<T>(null, maxKeySize, maxChildrenSize);
        for (int i = 0; i < midIndex; i++) {
            left.insertKey(node.getKey(i));
        }
        if (node.numberOfChildren() > 0) {
            for (int j = 0; j <= midIndex; j++) {
                Node<T> c = node.getChild(j);
                left.insertChild(c);
            }
        }

        Node<T> right = new Node<T>(null, maxKeySize, maxChildrenSize);
        for (int i = midIndex + 1; i < numberOfKeys; i++) {
            right.insertKey(node.getKey(i));
        }
        if (node.numberOfChildren() > 0) {
            for (int j = midIndex + 1; j < node.numberOfChildren(); j++) {
                Node<T> c = node.getChild(j);
                right.insertChild(c);
            }
        }

        if (node.parent == null) {
            Node<T> newRoot = new Node<T>(null, maxKeySize, maxChildrenSize);
            newRoot.insertKey(medianValue);
            node.parent = newRoot;
            root = newRoot;
            node = root;
            node.insertChild(left);
            node.insertChild(right);
        } else {
            Node<T> parent = node.parent;
            parent.insertKey(medianValue);
            parent.removeChild(node);
            parent.insertChild(left);
            parent.insertChild(right);

            if (parent.numberOfKeys() > maxKeySize) {
                split(parent);
            }
        }
    }

    private Node<T> searchNode(T value) {
        Node<T> node = root;
        while (node != null) {
            T lesser = node.getKey(0);
            if (value.compareTo(lesser) < 0) {
                if (node.numberOfChildren() > 0) {
                    node = node.getChild(0);
                } else {
                    node = null;
                }
                continue;
            }

            int numberOfKeys = node.numberOfKeys();
            int last = numberOfKeys - 1;
            T greater = node.getKey(last);
            if (value.compareTo(greater) > 0) {
                if (node.numberOfChildren() > numberOfKeys) {
                    node = node.getChild(numberOfKeys);
                } else {
                    node = null;
                }
                continue;
            }

            for (int i = 0; i < numberOfKeys; i++) {
                T currentValue = node.getKey(i);
                if (currentValue.compareTo(value) == 0) {
                    return node;
                }

                int next = i + 1;
                if (next <= last) {
                    T nextValue = node.getKey(next);
                    if (currentValue.compareTo(value) < 0 && nextValue.compareTo(value) > 0) {
                        if (next < node.numberOfChildren()) {
                            node = node.getChild(next);
                            break;
                        }
                        return null;
                    }
                }
            }
        }
        return null;
    }

    private int getIndexOfNextValue(Node<T> node, T value) {
        for (int i = 0; i < node.numberOfKeys(); i++) {
            T t = node.getKey(i);
            if (t.compareTo(value) >= 0) {
                return i;
            }
        }
        return node.numberOfKeys() - 1;
    }

    private int getIndexOfPreviousValue(Node<T> node, T value) {
        for (int i = 1; i < node.numberOfKeys(); i++) {
            T t = node.getKey(i);
            if (t.compareTo(value) >= 0) {
                return i - 1;
            }
        }
        return node.numberOfKeys() - 1;
    }

    private boolean combined(Node<T> node) {
        Node<T> parent = node.parent;
        int index = parent.indexOf(node);
        int indexOfLeftNeighbor = index - 1;
        int indexOfRightNeighbor = index + 1;

        Node<T> rightNeighbor = null;
        int rightNeighborSize = -minChildrenSize;
        if (indexOfRightNeighbor < parent.numberOfChildren()) {
            rightNeighbor = parent.getChild(indexOfRightNeighbor);
            rightNeighborSize = rightNeighbor.numberOfKeys();
        }

        if (rightNeighbor != null && rightNeighborSize > minKeySize) {
            T removeValue = rightNeighbor.getKey(0);
            int prev = getIndexOfPreviousValue(parent, removeValue);
            T parentValue = parent.removeKey(prev);
            T neighborValue = rightNeighbor.removeKey(0);
            node.insertKey(parentValue);
            parent.insertKey(neighborValue);
            if (rightNeighbor.numberOfChildren() > 0) {
                node.insertChild(rightNeighbor.removeChild(0));
            }
        } else {
            Node<T> leftNeighbor = null;
            int leftNeighborSize = -minChildrenSize;
            if (indexOfLeftNeighbor >= 0) {
                leftNeighbor = parent.getChild(indexOfLeftNeighbor);
                leftNeighborSize = leftNeighbor.numberOfKeys();
            }

            if (leftNeighbor != null && leftNeighborSize > minKeySize) {
                T removeValue = leftNeighbor.getKey(leftNeighbor.numberOfKeys() - 1);
                int prev = getIndexOfNextValue(parent, removeValue);
                T parentValue = parent.removeKey(prev);
                T neighborValue = leftNeighbor.removeKey(leftNeighbor.numberOfKeys() - 1);
                node.insertKey(parentValue);
                parent.insertKey(neighborValue);
                if (leftNeighbor.numberOfChildren() > 0) {
                    node.insertChild(leftNeighbor.removeChild(leftNeighbor.numberOfChildren() - 1));
                }
            } else if (rightNeighbor != null && parent.numberOfKeys() > 0) {
                T removeValue = rightNeighbor.getKey(0);
                int prev = getIndexOfPreviousValue(parent, removeValue);
                T parentValue = parent.removeKey(prev);
                parent.removeChild(rightNeighbor);
                node.insertKey(parentValue);
                for (int i = 0; i < rightNeighbor.getKeysSize(); i++) {
                    T v = rightNeighbor.getKey(i);
                    node.insertKey(v);
                }
                for (int i = 0; i < rightNeighbor.getChildrenSize(); i++) {
                    Node<T> c = rightNeighbor.getChild(i);
                    node.insertChild(c);
                }

                if (parent.parent != null && parent.numberOfKeys() < minKeySize) {
                    this.combined(parent);
                } else if (parent.numberOfKeys() == 0) {
                    node.parent = null;
                    root = node;
                }
            } else if (leftNeighbor != null && parent.numberOfKeys() > 0) {
                T removeValue = leftNeighbor.getKey(leftNeighbor.numberOfKeys() - 1);
                int prev = getIndexOfNextValue(parent, removeValue);
                T parentValue = parent.removeKey(prev);
                parent.removeChild(leftNeighbor);
                node.insertKey(parentValue);
                for (int i = 0; i < leftNeighbor.getKeysSize(); i++) {
                    T v = leftNeighbor.getKey(i);
                    node.insertKey(v);
                }
                for (int i = 0; i < leftNeighbor.getChildrenSize(); i++) {
                    Node<T> c = leftNeighbor.getChild(i);
                    node.insertChild(c);
                }

                if (parent.parent != null && parent.numberOfKeys() < minKeySize) {
                    this.combined(parent);
                } else if (parent.numberOfKeys() == 0) {
                    node.parent = null;
                    root = node;
                }
            }
        }

        return true;
    }

    private Node<T> getGreatestNode(Node<T> nodeToGet) {
        Node<T> node = nodeToGet;
        while (node.numberOfChildren() > 0) {
            node = node.getChild(node.numberOfChildren() - 1);
        }
        return node;
    }

    private T removeGreatestValue(Node<T> node) {
        T value = null;
        if (node.numberOfKeys() > 0) {
            value = node.removeKey(node.numberOfKeys() - 1);
        }
        return value;
    }

    public T remove(T value) {
        T removed = null;
        Node<T> node = this.searchNode(value);
        removed = remove(value, node);
        return removed;
    }

    private T remove(T value, Node<T> node) {
        if (node == null) {
            return null;
        }

        T removed;
        int index = node.indexOf(value);
        removed = node.removeKey(value);
        if (node.numberOfChildren() == 0) {
            if (node.parent != null && node.numberOfKeys() < minKeySize) {
                this.combined(node);
            } else if (node.parent == null && node.numberOfKeys() == 0) {
                root = null;
            }
        } else {
            Node<T> lesser = node.getChild(index);
            Node<T> greatest = this.getGreatestNode(lesser);
            T replaceValue = this.removeGreatestValue(greatest);
            node.insertKey(replaceValue);
            if (greatest.parent != null && greatest.numberOfKeys() < minKeySize) {
                this.combined(greatest);
            }
            if (greatest.numberOfChildren() > maxChildrenSize) {
                this.split(greatest);
            }
        }
        return removed;
    }

    public String toString() {
        if (root == null) {
            return "BTree is empty.";
        }

        StringBuilder sb = new StringBuilder();
        Queue<Node<T>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                Node<T> currentNode = queue.poll();
                sb.append("[");
                for (int j = 0; j < currentNode.numberOfKeys(); j++) {
                    sb.append(currentNode.getKey(j));
                    if (j != currentNode.numberOfKeys() - 1) {
                        sb.append(", ");
                    }
                }
                sb.append("]");

                if (currentNode.numberOfChildren() > 0) {
                    for (int j = 0; j <= currentNode.numberOfChildren(); j++) {
                        Node<T> child = currentNode.getChild(j);
                        if (child != null) {
                            queue.offer(child);
                        }
                    }
                }

                if (!queue.isEmpty()) {
                    sb.append(", ");
                }
            }

            sb.append("\n");
        }

        return sb.toString();
    }
}
