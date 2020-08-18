class Solution {
  public int[] distributeCandies(int candies, int num_people) {
      
      int[] res = new int[num_people];
      for (int index = 0; candies > 0; index++){
          res[index%num_people] += Math.min(index+1, candies);
          candies -= index+1;
      }
      return res;
  }
  
  //tc - O(candies)
  // sc - O(1)
}