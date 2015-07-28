import java.util.Stack;
public class Solution173 {
	Stack<TreeNode> s = new Stack<>();
    
    public Solution173(TreeNode root) {
        while(root != null)
        {
            s.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if(!s.isEmpty())
            return true;
        else
            return false;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode cur = s.pop();
        int res = cur.val;
        if(cur.right != null)
        {
            cur = cur.right;
            s.push(cur);
            while(cur.left != null)
            {
                cur = cur.left;
                s.push(cur);
            }
        }
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		TreeNode root = new TreeNode(1);
		Solution173 test = new Solution173(root);
		System.out.println("Start to print:");
		while(test.hasNext())
			System.out.println(test.next());
	}

}
