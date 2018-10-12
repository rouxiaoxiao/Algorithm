package tencent;

import offer.structure.TreeNode;

import java.util.ArrayList;

public class Tree {
    public static int find(TreeNode root){
        if(root==null){
            return -1;
        }
        ArrayList<TreeNode> list=new ArrayList<TreeNode>();
        while(root.right!=null){
            root=root.right;
            list.add(root);

        }
        if(root.left!=null){
            int a =list.size();
            list.add(root);
            list.set(a-1,root.left);
        }

        list.get(list.size()-3);
        return -1;
    }

}
