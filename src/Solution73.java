

public class Solution73 {
	public void setZeroes(int[][] matrix) {
        
        boolean firstColumnZero = false, firstRowZero = false;
        
        //check if first column should be set to 0
        for(int i = 0; i < matrix.length; i++)
        {
            if(matrix[i][0] == 0)
            {
                firstColumnZero = true;
                break;
            }
        }
        
        //check if first column should be set to 0
        for(int i = 0; i < matrix[0].length; i++)
        {
            if(matrix[0][i] == 0)
            {
                firstRowZero = true;
                break;
            }
        }
        
        //use first row and column to mark zero
        for(int i = 1; i < matrix.length; i++)
        {
            for (int j = 1; j < matrix[0].length; j++)
            {
                if(matrix[i][j] == 0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        //mark the zeros by first row and column
        for(int i = 1; i < matrix.length; i++)
        {
            for (int j = 1; j < matrix[0].length; j++)
            {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                {
                   matrix[i][j] = 0;
                }
            }
        }
        
        //set first column
        if(firstColumnZero == true)
        {
            for(int i = 0; i < matrix.length; i++)
            {
                matrix[i][0] = 0;
            }
        }
        
        //set first row
        if(firstRowZero == true)
        {
            for(int i = 0; i < matrix[0].length; i++)
            {
                matrix[0][i] = 0;
            }
        }
    }
}
