
public class Solution109 {
	public TreeNode sortedListToBST(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
        {
            TreeNode res = new TreeNode(head.val);
            return res;
        }
        ListNode head2 = findMid(head);
        TreeNode left = sortedListToBST(head);
        TreeNode right = sortedListToBST(head2.next);
            
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
