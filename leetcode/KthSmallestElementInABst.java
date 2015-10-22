class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Test {
    public int[] helper(TreeNode node, int count) {
        int[] result = new int[2];
        if (node == null) {
            result[0] = 0;
            result[0] = 0;
        }
        int total = 0;
        int[] l = helper(node.left, count);
        if (l[0] == 0) {
            total += l[1];
        }
        else {
            return l;
        }
        if (total == count) {
            result[0] = 1;
            result[1] = node.val;
            return result;
        }
        int[] r = helper(node.right, count);
        if (r[0] == 0) {
            total += r[1];
        }
        else {
            return r;
        }

        result[1] = total;
        return result;
    }

    public int kthSmallest(TreeNode root, int k) {
        // recursive solution, have helpers
        // return number of numbers found
        int[] result = helper(root, k);
        return result[1];
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(40);
        TreeNode n_1_1 = new TreeNode(20);
        TreeNode n_1_2 = new TreeNode(60);
        root.left = n_1_1;
        root.right = n_1_2;
        TreeNode n_2_1 = new TreeNode(10);
        TreeNode n_2_2 = new TreeNode(25);
        TreeNode n_2_3 = new TreeNode(50);
        TreeNode n_2_4 = new TreeNode(70);
        n_1_1.left = n_2_1;
        n_1_1.right = n_2_2;
        n_1_2.left = n_2_3;
        n_1_2.right = n_2_4;
        TreeNode n_3_1 = new TreeNode(7);
        TreeNode n_3_2 = new TreeNode(12);
        n_2_1.left = n_3_1;
        n_2_1.right = n_3_2;
        Test k = new Test();
        int x = k.kthSmallest(root, 1);
        System.out.println(x);
    }
}