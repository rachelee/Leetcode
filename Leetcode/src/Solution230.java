import java.util.Stack;
public class Solution230 {
	public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode cur = root;
        while(!s.isEmpty()||cur != null)
        {
            if(cur != null)
            {
                s.push(cur);
                cur = cur.left;
            }
            else
            {
                cur = s.pop();
                k--;
                if(k == 0)
                    return cur.val;
                cur = cur.right;
            }
        }
        return -1;
    }
}
