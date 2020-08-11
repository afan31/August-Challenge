class Solution {
  public int arrangeCoins(int n) {
      int count = 0;
      int rem = n;
      for(int i = 0; i < n; i++){
          count++;
          rem = rem - count;; 
          if (rem < count+1){
              break;
          }
      }
      return count;
  }
}