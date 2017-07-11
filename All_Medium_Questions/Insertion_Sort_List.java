package All_Medium_Questions;

public class Insertion_Sort_List {
	public static void main(String[] args){
		Insertion_Sort_List sol = new Insertion_Sort_List();
		ListNode head = new ListNode(3);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		sol.insertionSortList(head);
	}
	
	public ListNode insertionSortList(ListNode head) {
		if (head == null) return head;
		ListNode pre = new ListNode(-999);
		ListNode cur = head;
		while (cur != null) {
			ListNode tmp = cur.next;
			ListNode p = pre;
			boolean isSet = false;
			while (p.next != null) {
				if (p.val < cur.val && p.next.val >= cur.val) {
					ListNode t = p.next;
					p.next = cur;
					cur.next = t;
					isSet = true;
					break;
				}
				p = p.next;
			}
			if (!isSet) {
				p.next = cur;
				cur.next = null;
			}
			cur = tmp;
		}
		return pre.next;
	}
}
