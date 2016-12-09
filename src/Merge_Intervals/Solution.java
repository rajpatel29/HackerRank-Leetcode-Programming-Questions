//Given a collection of intervals, merge all overlapping intervals.
//
//For example,
//Given [1,3],[2,6],[8,10],[15,18],
//return [1,6],[8,10],[15,18].

package Merge_Intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution 
{
    public List<Interval> merge(List<Interval> intervals) 
    {
        List<Interval> result = new ArrayList<>();
        
        if(intervals == null || intervals.size() <= 1)
            return intervals;
        
        Collections.sort(intervals, new Comparator<Interval>()
        {
            public int compare(Interval o1 , Interval o2)
            {
                return o1.start - o2.start;
            }
         });
        
        Interval previous = intervals.get(0);
        
        for(int i = 1; i < intervals.size(); i++ )
        {
            Interval current = intervals.get(i);
            if(previous.end >= current.start)
            {
                if(previous.end >= current.end)
                {
                    
                }
                else
                {
                   previous.end = current.end; 
                }
            }
            else
            {
                result.add(previous);
                previous = current;
            }
        }
        result.add(previous);
       
        return result;
    }
    
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}
