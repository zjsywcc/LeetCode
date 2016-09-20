public class Main {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public class pathEnum {
        int singlePath;
        int maxPath;

        public pathEnum(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public int maxPathSum(TreeNode root) {
        return reverse(root).maxPath;
    }

    public pathEnum reverse(TreeNode root) {
        if(root == null) {
            return new pathEnum(0, Integer.MIN_VALUE);
        }
        pathEnum leftPE = reverse(root.left);
        pathEnum rightPE = reverse(root.right);
        int singlePath = Math.max(leftPE.singlePath, rightPE.singlePath) + root.val;
        singlePath = Math.max(singlePath, 0);

        int maxPath = Math.max(leftPE.maxPath, rightPE.maxPath);
        maxPath = Math.max(maxPath, leftPE.singlePath + rightPE.singlePath + root.val);
        return new pathEnum(singlePath, maxPath);
    }


}
