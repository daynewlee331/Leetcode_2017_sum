package All_Medium_Questions;

public class Remove_Nth_Node_From_End_of_List {
	public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;
        ListNode fast = head;
        for(int i = 0; i < n + 1; i ++){
        	fast = fast.next;
        }
        ListNode slow = head;
        while(fast.next != null) {
        	slow = slow.next;
        	fast = fast.next;
        }
        ListNode tmp = slow.next;
        slow.next = tmp;
        return head;
    }
}
