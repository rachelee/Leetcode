/**
 * 
 */

/**
 * @author rachel
 *
 */
public class Solution62 {
	//1d dynamic programming
	public int uniquePaths(int m, int n) {
        if(m < 0 || n < 0)
            return 0;
        
        if(m == 0 || n == 0)
            return 1;
            
        int[] arr = new int[n];
        arr[0] = 1;
        for(int i = 0; i < m; i++)
        {
            for (int j = 1; j < n; j++)
            {
                arr[j] = arr[j-1] + arr[j];
            }
        }
        
        return arr[n-1];
        
    }
	
	//2d dynamic programming
	public int uniquePaths2(int m, int n) {
        if(m < 0 || n < 0)
            return 0;
        if(m == 0 || n == 0)
            return 1;
            
        int[][] matrix = new int[m][n];
        
        //set the first column to 1
        for(int i = 0; i < m; i++)
            matrix[i][0] = 1;
            
        //set the first row to 1
        for(int j = 0; j < n; j++)
            matrix[0][j] = 1;
            
        for(int i = 1; i < m; i++)
        {
            for(int j = 1; j < n; j++)
            {
                matrix[i][j] = matrix[i-1][j] + matrix[i][j-1];
            }
        }
        
        return matrix[m-1][n-1];
    }
}
