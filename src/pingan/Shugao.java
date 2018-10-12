package pingan;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class Shugao{
    public static int getTreeHigh(TreeNode root) {
        if(root == null)return 0;
        return Math.max(getTreeHigh(root.left), getTreeHigh(root.right))+1;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<Integer, TreeNode> mapTree = new HashMap<>();
        int count = 0;
        int rootVal = 0;
        while(input.hasNextLine()) {
            String guanxi = input.nextLine();
            String[] fuAndZi = guanxi.split(" ");
            int fatherNum = Integer.parseInt(fuAndZi[0]);
            if(count == 0)rootVal = fatherNum;//根节点
            int sun = Integer.parseInt(fuAndZi[1]);
            TreeNode father = null;
            if(mapTree.containsKey(fatherNum)) {
                father = mapTree.get(fatherNum);
            }else {
                father = new TreeNode(fatherNum);
                mapTree.put(fatherNum, father);
            }
            if(father.left != null) {
                if(mapTree.get(sun) != null) {
                    father.right = mapTree.get(sun);
                }else {
                    father.right = new TreeNode(sun);
                    mapTree.put(sun, father.right);
                }
            }else {
                if(mapTree.get(sun) != null) {
                    father.left = mapTree.get(sun);
                }else {
                    father.left = new TreeNode(sun);
                    mapTree.put(sun, father.left);
                }
            }
            count++;
        }
        System.out.println(getTreeHigh(mapTree.get(rootVal)));
    }
}
