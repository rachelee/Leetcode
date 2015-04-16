
public class Solution147 {
	//my solution
	public ListNode insertionSortList(ListNode head) {
        if(head == null)
            return null;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = head;
        
        while(cur != null)
        {
            ListNode next = cur.next;
            if(next != null && (next.val < cur.val))
            {
                ListNode helper = pre.next;
                ListNode trailHelper = pre;
                while(helper != null)
                {
                    if(helper.val > next.val)
                    {
                    	cur.next = next.next;
                        trailHelper.next = next;
                        next.next = helper;
                        break;
                    }
                    
                    helper = helper.next;
                    trailHelper = trailHelper.next;
                }
            }
            else
            	cur = cur.next;
        
        }
        
        return pre.next;
    }
	
	//I don't understand this solution
	public ListNode insertionSortList2(ListNode head) {
	    if(head == null)
	        return null;
	    ListNode helper = new ListNode(0);
	    ListNode pre = helper;
	    ListNode cur = head;
	    while(cur!=null)
	    {
	        ListNode next = cur.next;
	        pre = helper;
	        while(pre.next!=null && pre.next.val<=cur.val)
	        {
	            pre = pre.next;
	        }
	        cur.next = pre.next;
	        pre.next = cur;
	        cur = next;
	    }
	    return helper.next;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		Solution147 ans = new Solution147();
		head = ans.insertionSortList2(head);
		ListNode cur = head;
		while(cur != null)
		{
			System.out.println(cur.val);
			cur = cur.next;
		}
		
	}

}
