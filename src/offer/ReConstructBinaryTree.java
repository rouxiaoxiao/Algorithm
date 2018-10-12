package offer;

import offer.structure.TreeNode;

/**
 * @Author liangxiao
 * @Date 2017/10/25 16:52
 *
 * 重建二叉树
 */
public class ReConstructBinaryTree {
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        return reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
    }
    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree(int [] pre,int startPre,int endPre,int [] in,int startIn,int endIn) {

        if(startPre>endPre||startIn>endIn) {
            return null;
        }
        TreeNode root=new TreeNode(pre[startPre]);

        for(int i=startIn;i<=endIn;i++) {
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
            }
        }

        return root;
    }


    public static void main(String[] args) {
        int[] preSort={1,2,4,7,3,5,6,8};
        int[] inSort={4,7,2,1,5,3,8,6};
        ReConstructBinaryTree reConstructBinaryTree=new ReConstructBinaryTree();
        TreeNode root=reConstructBinaryTree.reConstructBinaryTree(preSort,inSort);
        System.out.println(root.val);
    }
}
