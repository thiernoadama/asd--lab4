public class NTree {
    private TreeNode root;

    public NTree(int rootValue) {
        this.root = new TreeNode(rootValue);
    }

    public TreeNode getRoot() {
        return root;
    }

    public TreeNode find(int value) {
        return find(root, value);
    }

    private TreeNode find(TreeNode node, int value) {
        if (node == null) {
            return null;
        }
        if (node.getValue() == value) {
            return node;
        }
        MyList<TreeNode> children = node.getChildren();
        for (int i = 0; i < children.size(); i++) {
            TreeNode found = find(children.get(i), value);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    public boolean addChild(int parentValue, int childValue) {
        TreeNode parent = find(parentValue);
        if (parent == null || find(childValue) != null) {
            return false;
        }
        parent.addChild(new TreeNode(childValue));
        return true;
    }

    public void print() {
        print(root, 0);
    }

    private void print(TreeNode node, int depth) {
        System.out.println("  ".repeat(depth) + "- " + node.getValue());
        MyList<TreeNode> children = node.getChildren();
        for (int i = 0; i < children.size(); i++) {
            print(children.get(i), depth + 1);
        }
    }
}
