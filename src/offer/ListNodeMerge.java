package offer;

import offer.structure.ListNode;

/**
 * @author liangxiao
 * @date 2017/12/3 17:59
 * 从小到大合并两个链表
 */
public class ListNodeMerge {
    private static ListNode listnodeMerge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = listnodeMerge(list1.next, list2);
            return list1;
        } else {
            list2.next = listnodeMerge(list1, list2.next);
            return list2;
        }
    }


    private static void printListnode(ListNode list) {
        while (list != null) {
            System.out.println(list.val);
            list = list.next;
        }
    }

    public static void main(String[] args) {
        //list1
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        //list2
        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(2);
        ListNode node23 = new ListNode(3);
        node21.next = node22;
        node22.next = node23;

        printListnode(node1);


        printListnode(listnodeMerge(node1, node21));
    }
}
