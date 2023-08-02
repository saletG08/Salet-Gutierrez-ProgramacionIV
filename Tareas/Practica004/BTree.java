package Practica004;

public class BTree<T extends Comparable<T>> {
    private int minKeySize, maxKeySize, maxChildrenSize, sizeNode;
    private Node<T> root = null;

    private PrintManager printManager;

    public BTree(int order) {
        this.minKeySize = order / 2;
        this.maxKeySize = order - 1;
        this.maxChildrenSize = order;
        this.printManager = new PrintManager();
    }

    public boolean add(T value) {
        // Check if the value already exists in the tree
        if (searchNode(value) != null) {
            return false;
        }
        // If the root is null, create a new root node and insert the value
        if (root == null) {
            root = new Node<>(null, maxKeySize, maxChildrenSize);
            root.insertKey(value);
        } else {
            // Traverse the tree to find the appropriate node to insert the value
            Node<T> node = root;
            while (node != null) {
                if (node.numberOfChildren() == 0) {
                    // Insert the value into the current node and handle splitting if needed
                    node.insertKey(value);
                    if (node.numberOfKeys() <= maxKeySize) {
                        break;
                    }
                    split(node);
                    break;
                }
                // Find the child node to traverse based on the value
                int index = findChildIndex(node, value);
                node = node.getChild(index);
            }
        }
        sizeNode++;
        return true;
    }

    private int findChildIndex(Node<T> node, T value) {
        int numberOfKeys = node.numberOfKeys();
        int last = numberOfKeys - 1;
        T lesser = node.getKey(0);
        T greater = node.getKey(last);

        if (value.compareTo(lesser) <= 0) {
            return 0;
        }

        if (value.compareTo(greater) > 0) {
            return numberOfKeys;
        }

        for (int i = 1; i < numberOfKeys; i++) {
            T prev = node.getKey(i - 1);
            T next = node.getKey(i);
            if (value.compareTo(prev) > 0 && value.compareTo(next) <= 0) {
                return i;
            }
        }
        return -1;
    }

    private void split(Node<T> nodeToSplit) {
        Node<T> node = nodeToSplit;
        int numberOfKeys = node.numberOfKeys();
        int midIndex = numberOfKeys / 2;

        if (numberOfKeys % 2 == 0) {
            midIndex--;
        }

        T medianValue = node.getKey(midIndex);

        Node<T> left = createLeftNode(node, midIndex);
        Node<T> right = createRightNode(node, midIndex);

        if (node.parent == null) {
            createNewRoot(node, medianValue, left, right);
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

    private Node<T> createLeftNode(Node<T> node, int midIndex) {
        Node<T> left = new Node<>(null, maxKeySize, maxChildrenSize);
        for (int i = 0; i < midIndex; i++) {
            left.insertKey(node.getKey(i));
            if (node.numberOfChildren() > 0) {
                left.insertChild(node.getChild(i));
            }
        }
        return left;
    }

    private Node<T> createRightNode(Node<T> node, int midIndex) {
        Node<T> right = new Node<>(null, maxKeySize, maxChildrenSize);
        int numberOfKeys = node.numberOfKeys();
        for (int i = midIndex + 1; i < numberOfKeys; i++) {
            right.insertKey(node.getKey(i));
            if (node.numberOfChildren() > 0) {
                right.insertChild(node.getChild(i));
            }
        }
        return right;
    }

    private void createNewRoot(Node<T> node, T medianValue, Node<T> left, Node<T> right) {
        Node<T> newRoot = new Node<>(null, maxKeySize, maxChildrenSize);
        newRoot.insertKey(medianValue);
        node.parent = newRoot;
        root = newRoot;
        node = root;
        node.insertChild(left);
        node.insertChild(right);
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

        Node<T> rightNeighbor = getRightNeighbor(parent, indexOfRightNeighbor);
        Node<T> leftNeighbor = getLeftNeighbor(parent, indexOfLeftNeighbor);

        if (rightNeighbor != null && rightNeighbor.numberOfKeys() > minKeySize) {
            combineWithRightNeighbor(parent, node, rightNeighbor);
        } else if (leftNeighbor != null && leftNeighbor.numberOfKeys() > minKeySize) {
            combineWithLeftNeighbor(parent, node, leftNeighbor);
        } else if (rightNeighbor != null && parent.numberOfKeys() > 0) {
            combineWithRightNeighborAndParent(parent, node, rightNeighbor);
        } else if (leftNeighbor != null && parent.numberOfKeys() > 0) {
            combineWithLeftNeighborAndParent(parent, node, leftNeighbor);
        }

        return true;
    }

    private Node<T> getRightNeighbor(Node<T> parent, int indexOfRightNeighbor) {
        if (indexOfRightNeighbor < parent.numberOfChildren()) {
            return parent.getChild(indexOfRightNeighbor);
        }
        return null;
    }

    private Node<T> getLeftNeighbor(Node<T> parent, int indexOfLeftNeighbor) {
        if (indexOfLeftNeighbor >= 0) {
            return parent.getChild(indexOfLeftNeighbor);
        }
        return null;
    }

    private void combineWithRightNeighbor(Node<T> parent, Node<T> node, Node<T> rightNeighbor) {
        T removeValue = rightNeighbor.getKey(0);
        int prev = getIndexOfPreviousValue(parent, removeValue);
        T parentValue = parent.removeKey(prev);
        T neighborValue = rightNeighbor.removeKey(0);
        node.insertKey(parentValue);
        parent.insertKey(neighborValue);
        if (rightNeighbor.numberOfChildren() > 0) {
            node.insertChild(rightNeighbor.removeAndShiftChildren(0));
        }
    }

    private void combineWithLeftNeighbor(Node<T> parent, Node<T> node, Node<T> leftNeighbor) {
        T removeValue = leftNeighbor.getKey(leftNeighbor.numberOfKeys() - 1);
        int prev = getIndexOfNextValue(parent, removeValue);
        T parentValue = parent.removeKey(prev);
        T neighborValue = leftNeighbor.removeKey(leftNeighbor.numberOfKeys() - 1);
        node.insertKey(parentValue);
        parent.insertKey(neighborValue);
        if (leftNeighbor.numberOfChildren() > 0) {
            node.insertChild(leftNeighbor.removeAndShiftChildren(leftNeighbor.numberOfChildren() - 1));
        }
    }

    private void combineWithRightNeighborAndParent(Node<T> parent, Node<T> node, Node<T> rightNeighbor) {
        T removeValue = rightNeighbor.getKey(0);
        int prev = getIndexOfPreviousValue(parent, removeValue);
        T parentValue = parent.removeKey(prev);
        parent.removeChild(rightNeighbor);
        node.insertKey(parentValue);
        moveKeysAndChildren(node, rightNeighbor);
        handleParentAfterCombine(parent);
    }

    private void combineWithLeftNeighborAndParent(Node<T> parent, Node<T> node, Node<T> leftNeighbor) {
        T removeValue = leftNeighbor.getKey(leftNeighbor.numberOfKeys() - 1);
        int prev = getIndexOfNextValue(parent, removeValue);
        T parentValue = parent.removeKey(prev);
        parent.removeChild(leftNeighbor);
        node.insertKey(parentValue);
        moveKeysAndChildren(node, leftNeighbor);
        handleParentAfterCombine(parent);
    }

    private void moveKeysAndChildren(Node<T> node, Node<T> neighbor) {
        for (int i = 0; i < neighbor.getKeysSize(); i++) {
            T v = neighbor.getKey(i);
            node.insertKey(v);
        }
        for (int i = 0; i < neighbor.getChildrenSize(); i++) {
            Node<T> c = neighbor.getChild(i);
            node.insertChild(c);
        }
    }

    private void handleParentAfterCombine(Node<T> parent) {
        if (parent.parent != null && parent.numberOfKeys() < minKeySize) {
            combined(parent);
        } else if (parent.numberOfKeys() == 0) {
            parent.parent = null;
            root = parent;
        }
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
        if (node != null) {
            removed = removeValueFromNode(value, node);
        }
        return removed;
    }

    private T removeValueFromNode(T value, Node<T> node) {
        T removed;
        int index = node.findKeyIndex(value);
        removed = node.removeAndShiftChildren(value);

        if (node.numberOfChildren() == 0) {
            handleLeafNodeRemoval(node);
        } else {
            Node<T> lesser = node.getChild(index);
            Node<T> greatest = getGreatestNode(lesser);
            T replaceValue = removeGreatestValue(greatest);
            node.insertKey(replaceValue);
            handleChildNodeRemoval(greatest);
        }
        sizeNode--;
        return removed;
    }

    private void handleLeafNodeRemoval(Node<T> node) {
        if (node.parent != null && node.numberOfKeys() < minKeySize) {
            combined(node);
        } else if (node.parent == null && node.numberOfKeys() == 0) {
            root = null;
        }
    }

    private void handleChildNodeRemoval(Node<T> node) {
        if (node.parent != null && node.numberOfKeys() < minKeySize) {
            combined(node);
        }
        if (node.numberOfChildren() > maxChildrenSize) {
            split(node);
        }
    }

    public int getSizeNode() {
        return sizeNode;
    }

    public void setSizeNode(int sizeNode) {
        this.sizeNode = sizeNode;
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

    public void printTree() {
        System.out.println(printManager.print(root));
    }
}
