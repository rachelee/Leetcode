

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
}
