
public class Solution143 {
	public void reorderList(ListNode head) {
        if(head == null||head.next == null)
            return ;
        ListNode head2 = divide(head);
        head2 = reverse(head2);
        //merge two list
        ListNode head1 = head;
        head = new ListNode(0);
        ListNode cur = head;
        while(head1 != null)
        {
            cur.next = head1;
            head1 = head1.next;
            cur = cur.next;
            cur.next = head2;
            cur = cur.next;
            if(head2 != null)
                head2 = head2.next;
        }
        
        head = head.next;
    }
    
    private ListNode divide(ListNode head)
    {
        
        ListNode fast = head.next;
        ListNode slow = head;
        if(fast!=null)
            fast = fast.next;
        while(fast != null)
        {
            slow = slow.next;
            fast = fast.next;
            if(fast != null)
                fast = fast.next;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        return head2;
    }
    
    private ListNode reverse(ListNode head)
    {
        ListNode cur = head;
        head = head.next;
        cur.next = null;
        while(head != null)
        {
            ListNode last = cur;
            cur = head;
            head = head.next;
            cur.next = last;
        }
        head = cur;
        return head;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		Solution143 ans = new Solution143();
		ans.reorderList(head);
	}

}
