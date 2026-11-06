public class BranchFinder {
    private int maxBranchings = -1;
    private final MyList<MyList<Integer>> bestBranches = new MyList<>();

    public void find(TreeNode root) {
        maxBranchings = -1;
        bestBranches.clear();
        if (root != null) {
            search(root, new MyList<>(), 0);
        }
    }

    private void search(TreeNode node, MyList<Integer> path, int branchings) {
        path.add(node.getValue());
        if (node.isBranching()) {
            branchings++;
        }

        if (node.isLeaf()) {
            if (branchings > maxBranchings) {
                maxBranchings = branchings;
                bestBranches.clear();
                bestBranches.add(path.copy());
            } else if (branchings == maxBranchings) {
                bestBranches.add(path.copy());
            }
        } else {
            MyList<TreeNode> children = node.getChildren();
            for (int i = 0; i < children.size(); i++) {
                search(children.get(i), path, branchings);
            }
        }

        path.removeLast();
    }

    public int getMaxBranchings() {
        return maxBranchings;
    }

    public MyList<MyList<Integer>> getBestBranches() {
        return bestBranches;
    }
}
