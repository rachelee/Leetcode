
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


public class MergeTwoList {
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while(true)
        {
            if(l1 == null)
            {
                cur.next = l2;
                break;
            }
            
            if(l2 == null)
            {
                cur.next = l1;
                break;
            }
            
            if(l1.val >= l2.val)
            {
                cur.next = l2;
                l2 = l2.next;
            }
            else
            {
                cur.next = l1;
                l1 = l1.next;
            }
            
            cur = cur.next;
            
        }
        return head.next;
    }
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null||headB==null)
            return null;
        
        ListNode curA = headA, curB = headB;
        ListNode tailA = null, tailB = null;
        while(true)
        {
            if(curA == null)
                curA = headB;
            if(curB == null)
                curB = headA;
            if(curA.next == null)
                tailA = curA;
            if(curB.next == null)
                tailB = curB;
            if(tailA != null&&tailB != null&&tailA!=tailB)
                return null;
            if(curA == curB)
                return curA;
                
            curA = curA.next;
            curB = curB.next;
        }
    }
	
	
	    public static ListNode deleteDuplicates(ListNode head) {
	        if(head == null)
	            return null;
	        ListNode cur1 = head;
	        ListNode cur2 = head;
	        while(cur2 != null)
	        {
	            if(cur1.val == cur2.val)
	                cur2 = cur2.next;
	            else
	            {
	                cur1.next = cur2;
	                cur1 = cur1.next;
	                cur2 = cur2.next;
	            }
	        }
	        cur1.next = null;
	        return head;
	    }
	    
	   
        public static ListNode sortList(ListNode head) {
            if(head == null)
                return null;
            if(head.next == null)
                return head;
            ListNode otherHead = divide(head);
            head = sortList(head);
            otherHead = sortList(otherHead);
            head = mergeTwoLists(head, otherHead);
            return head;
        }
        
        private static ListNode divide(ListNode head)
        {
            ListNode cur1 = head, cur2 = head.next;
            while(cur2.next != null)
            {
                cur1 = cur1.next;
                cur2 = cur2.next;
                if(cur2.next != null)
                    cur2 = cur2.next;
                
            }
            ListNode head2 = cur1.next;
            cur1.next = null;
            
            return head2;
        }
        
        public static ListNode rotateRight(ListNode head, int n) {
            if(head == null)
                return null;
            int lenOfList = 0;
            ListNode cur = head;
            while(cur != null)
            {
                cur = cur.next;
                lenOfList++;
            }
            int count = 0;
            ListNode fast = head, slow = head;
            while(count < (n%lenOfList))
            {
                fast = fast.next;
                count++;
            }
            
            while(fast.next != null)
            {
                slow = slow.next;
                fast = fast.next;
            }
            
            ListNode head2 = slow.next;
            slow.next = null;
            fast.next = head;
            
            return head2;
        }
        
        public static TreeNode sortedListToBST(ListNode head) {
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
        
        private static ListNode findMid(ListNode head)
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
		/*ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(3);
		ListNode result = mergeTwoLists(node1, node2);
		while(result != null)
		{
			System.out.println(result.val);
			result = result.next;
		}*/
		
		/*ListNode headA = new ListNode(1);
		headA.next = new ListNode(1);
		ListNode res = deleteDuplicates(headA);
		ListNode cur = res;
		while(cur != null)
		{
			System.out.println(cur.val);
			cur = cur.next;
		}*/
		
		ListNode head = new ListNode(1);
		ListNode cur = head;
		cur.next = new ListNode(3);
		sortedListToBST(head);
		//head = rotateRight(head, 1);
		//head = sortList(head);
		//ListNode res = getIntersectionNode(headA, headB);
		//System.out.println(res.val);
	}

}
