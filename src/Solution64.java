
public class Solution64 {
	
	//2d dynamic programming space O(m*n)
	public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
            
        int[][] matrix = new int[grid.length][grid[0].length];
        
        matrix[0][0] = grid[0][0];
        
        for(int i = 1; i < grid.length; i++)
            matrix[i][0] = matrix[i-1][0] + grid[i][0];
            
        for(int j = 1; j < grid[0].length; j++)
            matrix[0][j] = matrix[0][j-1] + grid[0][j];
            
        for(int i = 1; i < grid.length; i++)
        {
            for(int j = 1; j < grid[0].length; j++)
            {
                matrix[i][j] = Math.min(matrix[i-1][j], matrix[i][j-1]) + grid[i][j];
            }
        }
        
        return matrix[grid.length-1][grid[0].length-1];
        
    }
	
	//1d dynamic programming space O(n)
	public int minPathSum2(int[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int[] arr = new int[grid[0].length];
        
        for(int j = 0; j < grid[0].length; j++)
            arr[j] = Integer.MAX_VALUE;
        
        arr[0] = 0;
        
        for(int i = 0; i < grid.length; i++)
        {
            arr[0] = arr[0] + grid[i][0];
            for(int j = 1; j < grid[0].length; j++)
            {
                arr[j] = Math.min(arr[j-1], arr[j]) + grid[i][j];
            }
        }
        
        return arr[grid[0].length-1];
    }
}
