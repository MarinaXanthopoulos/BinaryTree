import java.util.ArrayList;

/**
 * An Integer Binary Search Tree
 * @author: Your Name Here
 * @version: Date
 */

public class BST {
    // Instance Variable
    private BSTNode root;

    // Getters & setters
    public BSTNode getRoot() {
        return this.root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * Sets up a binary search tree
     * with some default values
     */
    // constructor
    public void setupTestData() {
        this.root = new BSTNode(10);
        this.root.setLeft(new BSTNode(5));
        this.root.setRight(new BSTNode((15)));
        this.root.getLeft().setLeft(new BSTNode(3));
        this.root.getLeft().setRight(new BSTNode(9));
    }

    /**
     * Prints the provided ArrayList of nodes
     * in the form node1-node2-node3
     * @param nodes ArrayList of BSTNodes
     */
    public static void printNodes(ArrayList<BSTNode> nodes) {
        for(int i=0; i<nodes.size()-1; i++) {
            System.out.print(nodes.get(i) + "-");
        }
        System.out.println(nodes.get(nodes.size()-1));
    }

    /**
     * A function that searches for a value in the tree
     * @param val integer value to search for
     * @return true if val is in the tree, false otherwise
     */
    public boolean search(int val) {
        // Start search at the root
        BSTNode current = root;
        return searchRecursion(current, val);
    }

    private boolean searchRecursion(BSTNode current, int val) {
        // Base case is if the current node = val
        if (current.getVal() == val){
            return true;
        }
        // If current is greater than the value, set current to the left node child
        else if (current.getVal() > val && current.getLeft() != null){
            current = current.getLeft();
        }
        // Otherwise it's less than the value set current to the right node child
        else if (current.getVal() < val && current.getRight() != null) {
            current = current.getRight();
        }
        else {
            return false;
        }
        return searchRecursion(current, val);
    }

    /**
     * @return ArrayList of BSTNodes in inorder
     */
    public ArrayList<BSTNode> getInorder() {
        // Make ArrayList for the roots
        ArrayList<BSTNode> ordered = new ArrayList<BSTNode>();
        BSTNode current = root;
        inOrderRecursion(current, ordered);
        return ordered;
    }

    public void inOrderRecursion(BSTNode current, ArrayList<BSTNode> ordered) {
        // Base case if current is empty
        if (current == null){
            return;
        }
        // Go through all left branches
        inOrderRecursion(current.getLeft(), ordered);
        // Then add them to the array list
        ordered.add(current);
        // Then go through all the right ones
        inOrderRecursion(current.getRight(), ordered);
    }

    /**
     * @return ArrayList of BSTNodes in preorder
     */
    public ArrayList<BSTNode> getPreorder() {
        ArrayList<BSTNode> ordered = new ArrayList<BSTNode>();
        BSTNode current = root;
        preorderRecursion(current, ordered);
        return ordered;
    }

    public void preorderRecursion(BSTNode current, ArrayList<BSTNode> ordered) {
        // Base case if current is empty
        if (current == null){
            return;
        }
        // Add current to the array list
        ordered.add(current);

        // Then do all the left roots then right
        preorderRecursion(current.getLeft(), ordered);
        preorderRecursion(current.getRight(), ordered);
    }

    /**
     * @return ArrayList of BSTNodes in postorder
     */
    public ArrayList<BSTNode> getPostorder() {
        ArrayList<BSTNode> ordered = new ArrayList<BSTNode>();
        BSTNode current = root;
        postorderRecursion(current, ordered);
        return ordered;
    }

    public void postorderRecursion(BSTNode current, ArrayList<BSTNode> ordered) {
        // Base case if current is empty
        if (current == null){
            return;
        }

        // Then do all the left roots then right
        postorderRecursion(current.getLeft(), ordered);
        postorderRecursion(current.getRight(), ordered);

        // Add current to the array list
        ordered.add(current);
    }

    /**
     * Inserts the given integer value to the tree
     * if it does not already exist. Modifies the
     * root instance variable to be the root of the new modified tree.
     * @param val The value ot insert
     */
    public void insert(int val) {
        root = insertRecursion(val, root);
    }

    public BSTNode insertRecursion(int val, BSTNode current) {
        // Base case if the left and right children are null
        if (current != null && val == current.getVal()){
            return root;
        }
        // If there'es a position where a child doesn't exist, insert val here
        if (current == null){
            current = new BSTNode(val);
            return current;
        }
        // Get left val if root is greater than val
        if (val < current.getVal()){
            current.setLeft(insertRecursion(val, current.getLeft()));
        }
        // Otherwise it's less than val so go right
        else if (val > current.getVal()){
            current.setRight(insertRecursion(val, current.getRight()));
        }
        return current;
    }

    /**
     * Determines if the current BST is
     * a valid BST.
     * @return true if valid false otherwise
     */
    public boolean isValidBST() {
        // TODO: Optional Challenge!
        return false;
    }

    public static void main(String[] args) {
        // Tree to help you test your code
        BST tree = new BST();
        tree.setupTestData();

        System.out.println("\nSearching for 15 in the tree");
        System.out.println(tree.search(15));

        System.out.println("\nSearching for 22 in the tree");
        System.out.println(tree.search(22));

        System.out.println("\nPreorder traversal of binary tree is");
        ArrayList<BSTNode> sol = tree.getPreorder();
        printNodes(sol);

        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);

        System.out.println("\nPostorder traversal of binary tree is");
        sol = tree.getPostorder();
        printNodes(sol);

        tree.insert(8);
        System.out.println("\nInorder traversal of binary tree is");
        sol = tree.getInorder();
        printNodes(sol);
    }
}
