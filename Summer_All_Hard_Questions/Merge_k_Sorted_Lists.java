package Summer_All_Hard_Questions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Merge_k_Sorted_Lists {
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length < 1) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>(){
			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				return o1.val - o2.val;
			}
        });
        for(ListNode n: lists) {
        		if(n != null) pq.offer(n);
        }
        ListNode head = new ListNode(-999);
        ListNode cur = head;
        while(!pq.isEmpty()){
        		cur.next = pq.poll();
        		ListNode tmp = cur.next.next;
        		if(tmp != null) pq.offer(tmp);
        		cur = cur.next;
        }
        return head.next;
    }
}
