
public class Solution63 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length == 0 || obstacleGrid[0].length == 0)
            return 0;
        int[] arr = new int [obstacleGrid[0].length];
            
        arr[0] = 1;
        
        for(int i = 0; i < obstacleGrid.length; i++)
        {
            if(obstacleGrid[i][0] == 1)
                arr[0] = 0;
            for(int j = 1; j < obstacleGrid[0].length; j++)
            {
                if(obstacleGrid[i][j] == 1)
                {
                    arr[j] = 0;
                    continue;
                }
                arr[j] = arr[j-1] + arr[j];
            }
        }
        return arr[obstacleGrid[0].length-1];
    }
}
