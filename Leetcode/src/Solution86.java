

public class Solution86 {
	public ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode(0),
                 head2 = new ListNode(0);
        ListNode cur1 = head1, cur2 = head2;
        while(head != null)
        {
            if(head.val < x)
            {
                cur1.next = head;
                cur1 = cur1.next;
            }
            else
            {
                cur2.next = head;
                cur2 = cur2.next;
            }
            
            head = head.next;
        }
        cur2.next = null;
        cur1.next = head2.next;
        return head1.next;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
