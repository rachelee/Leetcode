
public class Solution235 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        while(cur != null)
        {
            if(cur.val > p.val && cur.val < q.val || (cur.val < p.val && cur.val > q.val))
                return cur;
            else if(cur.val > p.val && cur.val > q.val)
                cur = cur.left;
            else if(cur.val < p.val && cur.val < q.val)
                cur = cur.right;
            else if (cur.val == p.val)
                return p;
            else if(cur.val == q.val)
                return q;
        }
        return cur;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
