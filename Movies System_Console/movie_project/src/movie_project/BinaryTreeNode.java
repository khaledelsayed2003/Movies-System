package movie_project;

public class BinaryTreeNode {
    private Showing showing;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(Showing showing) {
        this.showing = showing;
        this.left = null;
        this.right = null;
    }

    public Showing getShowing() {
        return showing;
    }

    public void setShowing(Showing showing) {
        this.showing = showing;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }
}
