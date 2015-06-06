
import java.util.*;


//Definition for singly-linked list.

public class MergeKLists {
	public static ListNode mergeKLists(List<ListNode> lists) {
        if(lists.isEmpty())
            return null;
        PriorityQueue<Integer> newQueue = new PriorityQueue<Integer>();
        
        for(ListNode node:lists)
        {
            while(node != null)
            {
                newQueue.add(node.val);
                node = node.next;
            }
        }
        
        if(newQueue.size() == 0)
            return null;
        ListNode newList = new ListNode(newQueue.poll());
        ListNode current = newList;
        while(newQueue.size() != 0)
        {    
            current.next = new ListNode(newQueue.poll());
            current = current.next;
        }
        
        return newList;
        
        
    }
	public static void main(String[] args) {
		List<ListNode> mylist = new ArrayList<ListNode>();
		ListNode node1 = new ListNode(0);
		node1.next = new ListNode(2);
		node1.next.next = new ListNode(5);
		mylist.add(node1);
		ListNode result = mergeKLists(mylist);
		while(result != null)
		{
			System.out.println(result.val);
			result = result.next;
		}
		
	}

}
