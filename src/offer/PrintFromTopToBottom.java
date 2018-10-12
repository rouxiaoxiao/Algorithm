package offer;

import offer.structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liangxiao
 * @date 2017/12/5 11:31
 * 层序遍历二叉树
 */
public class PrintFromTopToBottom {
   public ArrayList<Integer> printFromTopToBottom(TreeNode root){
       ArrayList<Integer> list=new ArrayList<Integer>();
       if (root==null){
           return list;
       }
       Queue<TreeNode> queue=new LinkedList<TreeNode>();
       queue.offer(root);
       while (!queue.isEmpty()){
           TreeNode treeNode=queue.poll();
           if (treeNode.left!=null){
               queue.offer(treeNode.left);
           }
           if (treeNode.right!=null){
               queue.offer(treeNode.right);
           }
           list.add(treeNode.val);
       }

       return list;

   }

    public static void main(String[] args) {
        PrintFromTopToBottom printFromTopToBottom=new PrintFromTopToBottom();
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

        System.out.println(printFromTopToBottom.printFromTopToBottom(root1));
    }

}
