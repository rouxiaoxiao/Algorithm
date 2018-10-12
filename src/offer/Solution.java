package offer;

import offer.structure.TreeLinkNode;

/**
 * @author liangxiao
 * @date 2017/12/26 11:50
 */
public class Solution {
    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode==null){
            return null;
        }
        if(pNode.right!=null){
            TreeLinkNode curNode=pNode.right;
            if(curNode.left!=null){
                while(curNode.left!=null){
                    curNode=curNode.left;
                }
                return curNode;
            }else{
                return curNode;
            }
        }
        while(pNode.next!=null){
            if(pNode.next.left==pNode){
                return pNode.next;
            }
            pNode=pNode.next;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeLinkNode a=new TreeLinkNode(1);
        TreeLinkNode b=new TreeLinkNode(2);
        TreeLinkNode c=new TreeLinkNode(3);
        TreeLinkNode d=new TreeLinkNode(4);
        TreeLinkNode e=new TreeLinkNode(5);
        TreeLinkNode f=new TreeLinkNode(6);
        TreeLinkNode g=new TreeLinkNode(7);
        TreeLinkNode h=new TreeLinkNode(8);
        TreeLinkNode i=new TreeLinkNode(9);
        a.left=b;
        a.right=c;
        b.left=d;
        b.right=e;
        b.next=a;
        c.left=f;
        c.right=g;
        d.next=b;
        e.left=h;
        e.right=i;
        e.next=b;
        f.next=c;
        g.next=c;
        h.next=e;
        i.next=e;
        Solution solution=new Solution();
        System.out.println(solution.GetNext(g).val);

    }
}