 class Solution {

    int ans = 0;

    public int averageOfSubtree(TreeNode root) {
        if (root == null) return 0;

        check(root);
        averageOfSubtree(root.left);
        averageOfSubtree(root.right);

        return ans;
    }

    void check(TreeNode root) {
        int s = sum(root);
        int c = count(root);

        if (s / c == root.val)
            ans++;
    }

    int sum(TreeNode root) {
        if (root == null) return 0;
        return root.val + sum(root.left) + sum(root.right);
    }

    int count(TreeNode root) {
        if (root == null) return 0;
        return 1 + count(root.left) + count(root.right);
    }
}