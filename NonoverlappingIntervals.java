class Solution {
  public int eraseOverlapIntervals(int[][] intervals) {
      
      if (intervals.length == 0){
          return 0;
      }
      // sort the array using a custom iterator  
      Arrays.sort(intervals, new Comparator<int[]>(){
         public int compare(int[] a, int[] b){
             return a[0] - b[0]; // eg. a= [1,2] ,b = [1,3]
         } 
      });
      
      int returnCount = 0;
      int end = intervals[0][1];
      for (int i = 1; i < intervals.length; i++){
          if (intervals[i][0] < end){ //over lapping condition
              returnCount++;
              end = Math.min(end, intervals[i][1]);
          }else {
              end = intervals[i][1];
          }
      }
      return returnCount;
  }
}