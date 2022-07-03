import javax.naming.InterruptedNamingException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class BinaryTree {
    private Node root;
    private class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
        }
        
        public Node getNode(int newValue){
            if (newValue <= this.value)
                return left;
            else
                return right;
        }
        
        public void addNode(int newValue){
            if (newValue <= this.value)
                left = new Node(newValue);
            else
                right = new Node(newValue);
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }

    public void insert(int value){
        if (root == null) {
            root = new Node(value);
            return;
        }

        Node parentNode = root;
        Node currentNode = root;
        while (currentNode != null){
            parentNode = currentNode;
            currentNode = currentNode.getNode(value);
        }

        parentNode.addNode(value);
    }

    public boolean find(int findValue){
        if (root == null)
            return false;

        if (root.value == findValue)
            return true;

        Node currentNode = root;
        int value = currentNode.value;
        while (true) {
            currentNode = currentNode.getNode(findValue);
            if (currentNode == null)
                return false;
            if (currentNode.value == findValue)
                return true;
        }
    }

    public void traverseTree(int method){
        switch (method) {
            case 1:
                traversePreOrder(root);
                break;
            case 2:
                traverseInOrderLR(root);
                break;
            case 3:
                traversePostOrder(root);
                break;
        }
    }

    public int height(){
        if (root == null)
            return -1;

        int h = height(root);
        return h;
    }

    public int min(){
        if (root == null)
            throw new IllegalArgumentException();
        int m = min(root);
        System.out.println(m);
        return m;
    }

    public boolean equals(BinaryTree tree){
        if (tree == null)
            return false;
        return equalNodes(root, tree.root);
    }

    private void traversePreOrder(Node root){
        if (root == null)
            return;
        System.out.println(root);
        traversePreOrder(root.left);
        traversePreOrder(root.right);
    }

    private void traverseInOrderLR(Node root){
        if (root == null)
            return;
        traverseInOrderLR(root.left);
        System.out.println(root);
        traverseInOrderLR(root.right);
    }

    private void traversePostOrder(Node root){
        if (root == null)
            return;
        traversePostOrder(root.left);
        traversePostOrder(root.right);
        System.out.println(root);
    }

    private int height(Node root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private int min(Node root){
        if (root.left == null && root.right == null)
            return root.value;
        return Math.min(Math.min(root.value, min(root.left)), min(root.right));
    }

    private boolean equalNodes(Node first, Node second){
        if (first == null && second == null)
            return true;
        if ((first == null && second != null) || (first != null && second == null))
            return false;
        return first.value == second.value && equalNodes(first.left, second.left) && equalNodes(first.right, second.right);
    }

    public boolean validateBinarySearchTree(){
        return validateBinarySearchTree(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    private boolean validateBinarySearchTree(Node root, double min, double max){
        if (root == null)
            return true;
        if (root.value < min || root.value > max)
            return false;
        return validateBinarySearchTree(root.left, min, Math.min(root.value,max)) && validateBinarySearchTree(root.right, Math.max(root.value,min), max);
    }

    public ArrayList getNodesAtDistance(int distance){
        ArrayList<Integer> list = new ArrayList<>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node root, int distance, ArrayList list){
        if (root == null)
            return;
        if (distance == 0) {
            list.add(root.value);
            return;
        }
        getNodesAtDistance(root.left, distance-1, list);
        getNodesAtDistance(root.right, distance-1, list);
    }

    public void breadthFirstTraversal(){
        for (int i = 0; i <= height(); i++){
            System.out.println(getNodesAtDistance(i));
        }
    }


    public int size(){
        return size(root, 0);
    }

    private int size(Node root, Integer treeSize){
        if (root == null)
            return 0;
        return 1 + size(root.left, treeSize) + size(root.right, treeSize);
    }

    public int countLeaves(){
        return countLeaves(root);
    }

    private int countLeaves(Node root){
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return countLeaves(root.left) + countLeaves(root.right);
    }

    public boolean contains(int num){
        return contains(root, num);
    }

    private boolean contains(Node root, int num){
        if (root == null)
            return false;
        if (root.value == num)
            return true;
        return contains(root.left, num) || contains(root.right, num);
    }

    public boolean areSiblings(int siblingA, int siblingB){
        return areSiblings(root, siblingA, siblingB);
    }

    private boolean areSiblings(Node root, int siblingA, int siblingB){
        if (root == null)
            return false;
        if (root.left == null)
            return false;
        if (root.right == null)
            return false;
        if ((root.left.value == siblingA && root.right.value == siblingB)
                || (root.left.value == siblingB && root.right.value == siblingA))
            return true;
        return areSiblings(root.left, siblingA, siblingB) || areSiblings(root.right, siblingA, siblingB);
    }

    public ArrayList getAncestors(int value){
        ArrayList<Integer> list = new ArrayList<>();
        isTarget(root, value, list);
        return list;
    }

    private boolean isTarget(Node root, int value, ArrayList list){
        if (root == null)
            return false;
        if (root.value == value)
            return true;
        boolean isAncestor = isTarget(root.left, value, list) || isTarget(root.right, value, list);
        if (isAncestor) {
            list.add(root.value);
        }
        return isAncestor;
    }
}
