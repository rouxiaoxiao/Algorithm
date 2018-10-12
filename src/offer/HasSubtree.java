package offer;

import offer.structure.TreeNode;

/**
 * @author liangxiao
 * @date 2017/12/3 18:44
 * 判断树B是不是树A的子结构
 */
public class HasSubtree {
    private static boolean hasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.val == root2.val) {
                result =doesTree1HaveTree(root1, root2);
                if (!result) {
                    result = hasSubtree(root1.left, root2);
                }
                if (!result) {
                    result = hasSubtree(root1.right, root2);
                }
            }
        }
        return result;
    }


    private static boolean doesTree1HaveTree(TreeNode root1,TreeNode root2){
        if (root2==null){
            return true;
        }
        else if (root1==null){
            return false;
        }
        if (root1.val!=root2.val){
            return false;
        }
        return doesTree1HaveTree(root1.left,root2.left)&&
                doesTree1HaveTree(root1.right,root2.right);

    }

    public static void main(String[] args) {

        //tree1
        TreeNode root1=new TreeNode(8);
        TreeNode node1=new TreeNode(8);
        TreeNode node2=new TreeNode(7);
        TreeNode node3=new TreeNode(9);
        TreeNode node4=new TreeNode(2);
        TreeNode node5=new TreeNode(4);
        TreeNode node6=new TreeNode(7);
        root1.left=node1;
        root1.right=node2;
        node1.left=node3;
        node1.right=node4;
        node4.left=node5;
        node4.right=node6;

        //tree2
        TreeNode root2=new TreeNode(8);
        TreeNode node21=new TreeNode(9);
        TreeNode node22=new TreeNode(2);
        root2.left=node21;
        root2.right=node22;

        System.out.println(hasSubtree(root1,root2));

    }
}
