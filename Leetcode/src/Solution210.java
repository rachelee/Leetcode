import java.util.*;
import java.util.LinkedList;
public class Solution210 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        if(prerequisites == null)
            return null;
        int len = prerequisites.length;
        if(len == 0)
        {
            int[] specialRes = new int[numCourses];
            for(int i = 0; i < numCourses; i++)
            {
                specialRes[i] = i;
            }
            return specialRes;
        }
        int[] pCount = new int[numCourses];
        for(int i = 0; i < len; i++)
        {
            pCount[prerequisites[i][0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        int idx = 0;
        for(int i = 0; i < pCount.length; i++)
        {
            if(pCount[i] == 0)
            {
                q.add(i);
                res[idx] = i;
                idx++;
            }
        }
        int numNoPre = q.size();
        while(!q.isEmpty())
        {
            int num = q.remove();
            for(int i = 0; i < len; i++)
            {
                if(prerequisites[i][1] == num)
                {
                    pCount[prerequisites[i][0]]--;
                    if(pCount[prerequisites[i][0]] == 0)
                    {
                        numNoPre++;
                        q.add(prerequisites[i][0]);
                        res[idx] = prerequisites[i][0];
                        idx++;
                    }
                }
            }
        }
        if(numNoPre != numCourses)
        {
            int[] emptyRes = new int[0];
            return emptyRes;
        }
        else
            return res;
        
    }
}
