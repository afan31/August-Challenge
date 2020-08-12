class Solution {
  public int hIndex(int[] citations) {
      if (citations.length == 0){
          return 0;
      }
      int buckets_length = citations.length + 1;
      int[] buckets = new int[buckets_length];
      
      // fill in the buckets with indexes as number of citations, each value in the array represents a count of papers, with the corresponding index as the number of citations
      for (int i = 0; i < citations.length; i++){
          int num = citations[i];
          if (num > (buckets_length-1)){
              int index = buckets_length-1;
              buckets[index] += 1;
          }else {
             buckets[num] += 1; 
          }
          
      }
      
      int papers_count = 0;
      for (int i = buckets.length-1; i >= 0; i--){
          papers_count += buckets[i];
          if (papers_count >= i){
              return i;
          }  
      }
      return 0;
  }
}