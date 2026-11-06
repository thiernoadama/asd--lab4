public class TreeNode {
    private final int value;
    private final MyList<TreeNode> children = new MyList<>();

    public TreeNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public MyList<TreeNode> getChildren() {
        return children;
    }

    public void addChild(TreeNode child) {
        children.add(child);
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    public boolean isBranching() {
        return children.size() >= 2;
    }
}
