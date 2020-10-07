package tree;

public class Node<T>{
    private T info;
    private Node<T> left, right;

    public Node(T inf){
        info = inf;
        left = right = null;
    }

    public Node(){
        info = null;
        left = right = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> link){
        this.left = link;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> link){
        this.right = link;
    }

    public int getChildCount(){
        int count = 0;
        if (getRight() != null) count++;
        if (getLeft() != null) count++;
        return count;
    }

}