package offer;

import offer.structure.TreeNode;

import java.util.ArrayList;

/**
 * @author： xiaoxiao
 * @date: 2017/12/5 23:28
 * 二叉树中和为指定值的路径
 */
public class FindPath {
    ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        if (root == null) {
            return listAll;
        }
        list.add(root.val);
        target = target - root.val;
        if (target == 0 && root.left == null && root.right == null) {
            listAll.add(new ArrayList<Integer>(list));
        }
        findPath(root.left, target);
        findPath(root.right, target);
        list.remove(list.size() - 1);
        return listAll;
    }

    public static void main(String[] args) {
        FindPath findPath = new FindPath();
        //tree1
        TreeNode root1 = new TreeNode(10);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(12);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(7);

        root1.left = node1;
        root1.right = node2;
        node1.left = node3;
        node1.right = node4;

        System.out.println(findPath.findPath(root1, 22));


    }
}
