import java.util.Stack;
public class Solution114 {
	//solution by myself
	public void flatten(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        TreeNode trailCur = root;

        while(!s.isEmpty() || cur != null)
        {
            if(cur != null)
            {
                if(cur.right != null)
                {
                    s.push(cur.right);
                }
                cur.right = cur.left;
                cur.left = null;
                trailCur = cur;
                cur = cur.right;
            }
            else
            {
                cur = s.pop();
                trailCur.right = cur;
            }
        }
    }
	//other similar solution
	public void flatten2(TreeNode root) {
	        Stack<TreeNode> s = new Stack<>();
	        TreeNode cur = root;
	        
	        while(!s.isEmpty() || cur != null)
	        {
	            if(cur.right != null)
	            {
	                s.push(cur.right);
	            }
	            if(cur.left != null)
	            {
	                cur.right = cur.left;
	                cur.left = null;
	            }
	            else if(!s.isEmpty())
	            {
	                TreeNode temp = s.pop();
	                cur.right = temp;
	            }
	            cur = cur.right;
	        }
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
