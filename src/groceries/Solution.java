package groceries;

public class Solution {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1==null||pHead2==null){
            return null;
        }
        ListNode cur1=pHead1;
        ListNode cur2=pHead2;
        int length1=0,length2=0;
        while(cur1!=null){
            length1++;
            cur1=cur1.next;
        }
        while(cur2!=null){
            length2++;
            cur2=cur2.next;
        }
        int k = length1-length2;
        if(k==0){
            while(pHead1!=pHead2){
                pHead1=pHead1.next;
                pHead2=pHead2.next;
            }
            return pHead1;
        }else if(k>0){
            while(k>0){
                pHead1=pHead1.next;
                k--;
            }
            while(pHead1!=pHead2){
                pHead1=pHead1.next;
                pHead2=pHead2.next;
            }
            return pHead1;
        }else{
            while(k<0){
                pHead2=pHead2.next;
                k++;
            }
            while(pHead1!=pHead2){
                pHead1=pHead1.next;
                pHead2=pHead2.next;
            }
            return pHead1;
        }
    }
}