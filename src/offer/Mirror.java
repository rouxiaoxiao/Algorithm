package offer;

import offer.structure.TreeNode;

/**
 * @author liangxiao
 * @date 2017/12/4 10:06
 * 二叉树镜像
 */
public class Mirror {
    private static void mirror(TreeNode root) {
        if (root==null){
            return;
        }
        exch(root);
        if (root.left != null) {
            mirror(root.left);
        }
        if (root.right != null) {
            mirror(root.right);
        }

    }

    private static void exch(TreeNode root) {
        TreeNode tem = null;
        if (root.left == null && root.right == null) {
            return;
        } else {
            tem = root.left;
            root.left = root.right;
            root.right = tem;
        }
    }

    static void printTree(TreeNode root) {
        if (root.left != null) {
            printTree(root.left);
        }
        System.out.print(root.val + " ");
        if (root.right != null) {
            printTree(root.right);
        }

    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(8);
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        root1.left = node1;
        root1.right = node2;
        node1.left = node3;
        node1.right = node4;
        node4.left = node5;
        node4.right = node6;

        TreeNode root2=null;

        mirror(root2);


//        System.out.println(root1.val);
        System.out.println("原二叉树：");
        printTree(root1);
        mirror(root1);
        System.out.println("镜像后：");
        printTree(root1);
    }
}
