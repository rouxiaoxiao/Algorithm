package offer;

import offer.structure.ListNode;

/**
 * @author liangxiao
 * @date 2017/12/3 17:10
 * <p>
 * 输出链表中倒数第k个节点
 */

/*
代码思路如下：两个指针，先让第一个指针和第二个指针都指向头结点，然后再让第一个指正走(k-1)步，到达第k个节点。
然后两个指针同时往后移动，当第一个结点到达末尾的时候，第二个结点所在位置就是倒数第k个节点了。
 */

public class FindKthToTail {
    static ListNode findKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode pre = head;
        ListNode last = head;
        for (int i = 1; i < k; i++) {
            if (pre.next != null) {
                pre = pre.next;
            } else {
                return null;
            }
        }
        while (pre.next != null) {
            pre = pre.next;
            last = last.next;
        }
        return last;
    }
    public static void main(String[] args) {
        //链表结构的创建（找了好多地方都没写java的main函数T_T）
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        System.out.println(findKthToTail(node1,3).val);
        //若要k的长度超过链表长度，则在第一个指针移动过程中就会返回null，不会报错，但是若要输出null.val就会报空指针异常
        System.out.println(findKthToTail(node1,4));
    }
}
