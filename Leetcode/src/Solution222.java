
public class Solution222 {
	public int countNodes(TreeNode root) {
        if(root == null)
            return 0;
        int lHeight = getLeftHeight(root.left)+1;
        int rHeight = getRightHeight(root.right)+1;
        if(lHeight == rHeight)
            return (2<<lHeight-1)-1;
        else
            return countNodes(root.left) + countNodes(root.right) + 1;
        
    }
    private int getLeftHeight(TreeNode cur){
        int height = 0;
        while(cur != null)
        {
            cur = cur.left;
            height++;
        }
        return height;
    }
    private int getRightHeight(TreeNode cur){
        int height = 0;
        while(cur != null)
        {
            cur = cur.right;
            height++;
        }
        return height;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
