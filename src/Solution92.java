

public class Solution92 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode trailStart = dummy;
        ListNode start = head;
        ListNode cur = head;
        
        int count = 1;
        while(count < m)
        {
            trailStart = trailStart.next;
            start = start.next;
            cur = cur.next;
            count++;
        }
        
        while(count < n)
        {
            trailStart.next = cur.next;
            cur.next = cur.next.next;
            trailStart.next.next = start;
            start = trailStart.next;
            count++;
        }
        
        return dummy.next;
    }
}
