package demo;

import java.util.Arrays;

class BinaryTree {
    private class Node {
        private Comparable data;

        private Node left;
        private Node right;

        public Node(Comparable data) {
            this.data = data;
        }

        public void addNode(Node node) {
            if (this.data.compareTo(node.data) < 0) {
                if (this.right == null) {
                    this.right = node;
                } else {
                    this.right.addNode(node);
                }
            } else {
                if (this.left == null) {
                    this.left = node;
                } else {
                    this.left.addNode(node);
                }
            }
        }

        public void toArrayNode() {
            if (this.left != null) {
                this.left.toArrayNode();
            }

            BinaryTree.this.list[BinaryTree.this.foot++] = this.data;

            if (this.right != null) {
                this.right.toArrayNode();
            }
        }
    }

    // 根节点
    private Node root;

    // 统计个数
    private int count;

    private Comparable[] list;

    private int foot;

    public void add(Comparable data) {
        Node node = new Node(data);
        // 没有根节点
        if (this.root == null) {
            this.root = node;
        }
        // 交给Node处理，需要比较大小
        else {
            this.root.addNode(node);
        }
        this.count++;

    }

    public Comparable[] toArray() {
        if (this.root == null) return null;

        this.foot = 0;
        this.list = new Comparable[this.count];
        this.root.toArrayNode();
        return this.list;
    }
}

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add("A");
        tree.add("C");
        tree.add("E");
        tree.add("D");
        tree.add("B");

        System.out.println(Arrays.toString(tree.toArray()));
        // [A, B, C, D, E]
    }
}