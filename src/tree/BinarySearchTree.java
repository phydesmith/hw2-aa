package tree;

import java.util.Comparator;

public class BinarySearchTree<T extends Comparable<T>> {
    protected Node<T> root;
    protected Comparator<T> comp;
    protected int size;

    public BinarySearchTree(){
        root = null;
        this.comp = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return ((Comparable)o1).compareTo(o2);
            }
        };
        size = 0;
    }
    public BinarySearchTree(Comparator<T> comp){
        root = null;
        this.comp = comp;
        size = 0;
    }

    public void add(T item){
        Node<T> newNode = new Node<T>(item);
        if (root == null){
            root = newNode;
            size++;
            return;
        }
        Node<T> cursor = root, precursor = null;
        while(cursor != null){
            precursor = cursor;
            if (comp.compare(cursor.getInfo(), item) < 0){
                cursor = cursor.getRight();
            } else {
                cursor = cursor.getLeft();
            }
        }
        //  do the connection
        if(comp.compare(precursor.getInfo(), item) < 0){
            precursor.setRight(newNode);
        } else {
            precursor.setLeft(newNode);
        }
        size++;
        return;
    }

    public Node<T> getRoot(){
        return this.root;
    }

    public void insert(T item){
        root = recAdd(item, root);
        size++;
    }
    private Node<T> recAdd(T item, Node<T> node){
        if(node == null ) {
            Node<T> newNode = new Node<T>(item);
            return newNode;
        } else {
            if (comp.compare(node.getInfo(), item) < 0){
                node.setRight(recAdd(item, node.getRight()));
            } else {
                node.setLeft(recAdd(item, node.getLeft()));
            }
            return node;
        }
    }

    public int leafCount(){
        return recLeafCount(this.root);
    }
    private int recLeafCount(Node<T> node){
        if (node == null ) return 0;
        if ((node.getRight() == null) && (node.getLeft() == null)) return 1;
        else {
            return recLeafCount(node.getRight()) + recLeafCount(node.getLeft());
        }
    }

    public int oneChild() { return recOneChild(this.root);}
    private int recOneChild(Node<T> node){
        if (node == null) return 0;
        if (node.getChildCount() == 1) {
            if (node.getRight() == null){
                return 1 + recOneChild(node.getLeft());
            } else {
                return 1 + recOneChild(node.getRight());
            }
        } else {
            return recOneChild(node.getRight()) + recOneChild(node.getLeft());
        }
    }

    public int getLevels(){ return recGetLevels(this.root, 0);}
    protected int recGetLevels(Node<T> node, int count) {
        if (node == null) return 0;
        if (node.getChildCount() == 0 ) return count+1;
        else {
            int leftCount = recGetLevels(node.getLeft(), count+1);
            int rightCount = recGetLevels(node.getRight(), count+1);
            if (leftCount > rightCount) {return leftCount;} else return rightCount;
        }
    }

    public String toString(){
        return recToString1(root, 0);
    }
    private String recToString1(Node<T> node, int depth){
        if (node == null) return "";
        else {
            return recToString1(node.getRight(), depth+1)  + "\n" + getSpaces(depth) + node.getInfo().toString()
                    + recToString1(node.getLeft(), depth+1);
        }
    }
    private String getSpaces(int depth){
        String str = "";
        for (int i = 0; i < 3*depth; i++){
            str += " ";
        }
        return str;
    }


    private String recToString(Node<T> node){
        if (node == null) return "";
        else {
            return node.getInfo().toString() + " " +  recToString(node.getLeft()) + " " +  recToString(node.getRight());
        }
    }


    // exam questions
    // q3
    public void removeMax(){
        recRemoveMax(this.root);
    }
    private void recRemoveMax(Node<T> root){
        if (root == null ) return;
        if (this.root.getRight() == null){
            this.root = this.root.getLeft();
        } else {
            if (root.getRight().getRight() == null) {
                if (root.getRight().getChildCount() == 0) {
                    root.setRight(null);
                } else {
                    root.setRight(root.getRight().getLeft());
                }
            } else {
                recRemoveMax(root.getRight());
            }
        }
    }

    // q4
    public int countGreaterThan(T item){
        return recCountGreaterThan(root, item);
    }
    private int recCountGreaterThan(Node<T> root, T item){
        int count = 0;
        if (root == null || item == null) return 0;
        if (comp.compare(root.getInfo(), item) > 0 && root.getChildCount() == 0){
            return 1;
        } else {
            if (comp.compare(root.getInfo(), item) > 0){count++;}
            count += recCountGreaterThan(root.getRight(), item);
            count += recCountGreaterThan(root.getLeft(), item);
            return count;
        }
    }

}
