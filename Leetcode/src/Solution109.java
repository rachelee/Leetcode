
public class Solution109 {
	//My method
	public TreeNode sortedListToBST1(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
        {
            TreeNode res = new TreeNode(head.val);
            return res;
        }
        ListNode head2 = findMid(head);
        TreeNode left = sortedListToBST1(head);
        TreeNode right = sortedListToBST1(head2.next);
            
        TreeNode res = new TreeNode(head2.val);
        res.left = left;
        res.right = right;
        return res;
    }
    
	private ListNode findMid(ListNode head)
	{
	    ListNode dummy = new ListNode(0);
	    dummy.next = head;
	    ListNode slow = dummy, fast = head.next;
	    while(fast!= null)
	    {
	        slow = slow.next;
	        fast = fast.next;
	        if(fast!= null)
	            fast = fast.next;
	    }
	    ListNode head2 = slow.next;
	    slow.next = null;
	    return head2;
	    
	}
	
	//Good method, from bottom
	static ListNode h;
	 
	public TreeNode sortedListToBST2(ListNode head) {
		if (head == null)
			return null;
 
		h = head;
		int len = getLength(head);
		return sortedListToBST(0, len - 1);
	}
 
	// get list length
	public int getLength(ListNode head) {
		int len = 0;
		ListNode p = head;
 
		while (p != null) {
			len++;
			p = p.next;
		}
		return len;
	}
 
	// build tree bottom-up
	public TreeNode sortedListToBST(int start, int end) {
		if (start > end)
			return null;
 
		// mid
		int mid = (start + end) / 2;
 
		TreeNode left = sortedListToBST(start, mid - 1);
		TreeNode root = new TreeNode(h.val);
		h = h.next;
		TreeNode right = sortedListToBST(mid + 1, end);
 
		root.left = left;
		root.right = right;
 
		return root;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode cur = head;
		cur.next = new ListNode(2);
		cur.next.next = new ListNode(3);
		Solution109 answer = new Solution109();
		TreeNode res = answer.sortedListToBST2(head);
		System.out.println(res);
	}

}
