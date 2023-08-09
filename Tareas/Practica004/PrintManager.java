package Practica004;

import java.util.LinkedList;
import java.util.Queue;

public class PrintManager {

    public String print(Node root) {
        if (root == null) {
            return "BTree is empty.";
        }

        StringBuilder sb = new StringBuilder();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            appendLevelToString(sb, queue, levelSize);
        }

        return sb.toString();
    }

    private void appendLevelToString(StringBuilder sb, Queue<Node> queue, int levelSize) {
        for (int i = 0; i < levelSize; i++) {
            Node currentNode = queue.poll();
            appendNodeToString(sb, currentNode);

            if (currentNode.numberOfChildren() > 0) {
                addChildrenToQueue(queue, currentNode);
            }

            if (!queue.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append("\n");
    }

    private void appendNodeToString(StringBuilder sb, Node node) {
        sb.append("[");
        for (int j = 0; j < node.numberOfKeys(); j++) {
            sb.append(node.getKey(j));
            if (j != node.numberOfKeys() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
    }

    private void addChildrenToQueue(Queue<Node> queue, Node node) {
        for (int j = 0; j <= node.numberOfChildren(); j++) {
            Node child = node.getChild(j);
            if (child != null) {
                queue.offer(child);
            }
        }
    }
}
