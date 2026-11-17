public class Node {

    private int  value;
    private Node left;
    private Node right;
    private int npl;

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node left, Node right,  int npl) {
        this.value = value;
        this.left = left;
        this.right = right;
        this.npl = npl;
    }

    public int getValue() { return value; }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public int getNpl() {
        return npl;
    }

}
