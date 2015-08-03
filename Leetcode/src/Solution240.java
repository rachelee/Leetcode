
public class Solution240 {
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int vCur = 0;
        int hCur = matrix[0].length-1;
        while(vCur < matrix.length && hCur >= 0)
        {
            int num = matrix[vCur][hCur];
            if(num == target)
                return true;
            else if(target > num)
                vCur++;
            else
                hCur--;
        }
        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
