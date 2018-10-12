package offer.Chapter2;

import offer.structure.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: liangxiao
 * @Date: Created in 21:10 2018/8/26
 * 面试题6：从尾到头打印链表
 */
public class PrintListFromTailToHead {

    private static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        System.out.println(printListFromTailToHead1(node1));
    }

    private static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        helper1(listNode);
        return list;
    }

    private static void helper1(ListNode listNode) {
        if (listNode!=null){
            helper1(listNode.next);
            list.add(listNode.val);
        }
    }
}
