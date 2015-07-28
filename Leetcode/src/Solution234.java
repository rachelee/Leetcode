import java.util.Stack;
public class Solution234 {
	//reverse second half of the linkedlist
	public boolean isPalindrome2(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode slow;
        ListNode fast;
        slow = head;
        fast = head.next;
        while(fast.next != null)
        {
            slow = slow.next;
            fast = fast.next;
            if(fast.next != null)
            {
                fast = fast.next;
            }
            
        }
        slow = slow.next;
        //reverse the second half of the 
        ListNode cur = slow;
        slow = slow.next;
        cur.next = null;
        ListNode trailCur = slow;
        
        while(trailCur != null)
        {
        	slow = slow.next;
            trailCur.next = cur;
            cur = trailCur;
            trailCur = slow;
        }
        
        ListNode firstCur = head;
        while(cur != null)
        {
            if(firstCur.val != cur.val)
                return false;
            cur = cur.next;
            firstCur = firstCur.next;
        }
        return true;
    }
	//use a stack to save the second half of the linkedlist
	public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode slow;
        ListNode fast;
        slow = head;
        fast = head.next;
        Stack<Integer> stack = new Stack<>();
        boolean odd = false;
        while(fast.next != null)
        {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next;
            if(fast.next != null)
            {
                fast = fast.next;
            }
            else
            	odd = true;
            
        }
        if(odd == false)
        {
            stack.push(slow.val);
        }
        slow = slow.next;
        while(!stack.isEmpty()){
            if(slow.val != stack.pop())
                return false;
            slow = slow.next;
        }
        return true;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution234 test = new Solution234();
		LinkedList a = new LinkedList();
		int[] arr = {1,2,2,1};
		ListNode root = a.arrToLinkedList(arr);
		a.printList();
		System.out.println(test.isPalindrome2(root));
		
	}

}
