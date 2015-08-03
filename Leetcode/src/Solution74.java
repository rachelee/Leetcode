

public class Solution74 {
	
	//Binary search
	public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        
        int row = matrix.length, column = matrix[0].length;
        int length = row*column;
        
        int start = 0, end = length-1;
        
        while(start <= end)
        {
            int mid = (start+end)/2;
            int x = mid/column;
            int y = mid%column;
            if(matrix[x][y] == target)
                return true;
            else if(matrix[x][y] < target)
                start = mid+1;
            else
                end = mid-1;
        }
        
        return false;
    }
    
    //Naive solution
    public boolean navSearchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0)
            return false;
        for(int i = 0; i < matrix.length; i++)
        {
            for(int j = 0; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == target)
                    return true;
            }
        }
        
        return false;
    }
    
    public boolean searchMatrix2(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        int up = 0;
        int down = matrix.length-1;
        int mid;
        while(up < down)
        {
        	mid = (up+down)/2;
            int num = matrix[mid][0];
            if( num == target)
                return true;
            else if(num > target)
                down = mid;
            else
                up = mid+1;
            if(up == down-1)
            	break;
        }
        
        int l = 0;
        int r = matrix[0].length-1;
        while(l <= r)
        {
            mid = (l+r)/2;
            int num = matrix[up][mid];
            if(num  == target)
                return true;
            else if(num > target)
            {
                r = mid-1;
            }
            else 
                l = mid+1;
        }
        return false;
    }
    public static void main(String[] args) {
		// TODO Auto-generated method stub
    	Solution74 test = new Solution74();
    	int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
    	int target = 3;
    	System.out.println(test.searchMatrix2(matrix, target));
	}
}
