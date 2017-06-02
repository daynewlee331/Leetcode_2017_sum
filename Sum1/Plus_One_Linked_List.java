package Sum1;

public class Plus_One_Linked_List {
	int carryOn = 0;
	public ListNode plusOne(ListNode head) {
		add(head);
		if(carryOn == 0) return head;
		else {
			ListNode newNode = new ListNode(carryOn);
			newNode.next = head;
			return newNode;
		}
    }
	
	public void add(ListNode node){
		if(node == null) return;
		add(node.next);
		int sum = node.val + carryOn;
		if(node.next == null){
			sum += 1;
		}
		node.val = sum % 10;
		carryOn = sum / 10;
	}
}
