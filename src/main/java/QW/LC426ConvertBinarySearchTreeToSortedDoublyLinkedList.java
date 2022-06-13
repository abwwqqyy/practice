package QW;
class Node1 {
    public int val;
    public Node1 left;
    public Node1 right;

    public Node1() {}

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val,Node1 _left,Node1 _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
public class LC426ConvertBinarySearchTreeToSortedDoublyLinkedList {
    private Node1 first = null;
    private Node1 last = null;
    public Node1 treeToDoublyList(Node1 root) {
        if (root == null) return null;
        inorder(root);
        first.left = last;
        last.right = first;
        return first;
    }
    private void inorder(Node1 root){
        if(root == null){
            return;
        }
        inorder(root.left);
        if(last == null){
            first = root;
        }else{
            last.right = root;
            root.left = last;
        }
        last = root;
        inorder(root.right);
    }
}
