
public class LinkedList {
	private ListNode root;
	public void printList()
	{
		ListNode cur = root;
		while(cur != null)
		{
			if(cur.next == null)
				System.out.println(cur.val);
			else
				System.out.print(cur.val+"->");
			cur = cur.next;
		}
	}
	public ListNode arrToLinkedList(int[] arr){
		if(arr != null|| arr.length != 0)
		{
			root = new ListNode(arr[0]);
			ListNode cur = root;
			if(arr.length > 1)
			{
				for(int i = 1; i < arr.length; i++)
				{
					cur.next = new ListNode(arr[i]);
					cur = cur.next;	
				}
			}
			return root;
		}
		else 
			return null;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
