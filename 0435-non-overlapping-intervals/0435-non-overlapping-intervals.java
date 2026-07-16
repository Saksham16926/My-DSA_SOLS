class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
       
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int oe = intervals[0][1];
        int count = 0;

        for(int[] interval : intervals){
            if(interval[0] < oe || interval[1] <= oe){
                count ++;
            }else{
            oe = interval[1];
            }
        }
        return count - 1;
    }
}