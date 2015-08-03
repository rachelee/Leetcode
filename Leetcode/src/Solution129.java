
public class Solution129 {
	public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        return recSum(root, 0);
    }
    private int recSum(TreeNode root, int sum){
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null)
            return sum*10+root.val;
        return recSum(root.left, sum*10+root.val)+recSum(root.right, sum*10+root.val);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(0);
		Solution129 test = new Solution129();
		System.out.println(test.sumNumbers(root));
	}

}
