package Sum1;

public class Merge_Two_Sorted_Lists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode p1 = l1, p2 = l2;
        if(l1.val > l2.val) {
        		p2 = l1;
        		p1 = l2;
        }
        ListNode head = p1;
        while(p1.next != null && p2 != null){
        		if(p2.val >= p1.val && p2.val < p1.next.val){
        			ListNode tmp = p2.next;
        			ListNode next = p1.next;
        			p1.next = p2;
        			p2.next = next;
        			p2 = tmp;
        		}
        		p1 = p1.next;
        }
        if(p2 != null) p1.next = p2;
        return head;
    }
}
