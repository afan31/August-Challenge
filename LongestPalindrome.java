class Solution {
  public int longestPalindrome(String s) {
      
      int[] arr = new int[59];
      
      for (char c: s.toCharArray()){
          int index = c - 'A';
          arr[index]++;
      }
      
      int length = 0;
      boolean isSingle = false;
      for (int i : arr){
          if(i%2==0){
              length += i;
          }else {
              length += (i-1);
              isSingle = true;
          }
      }
      return isSingle ? length+1 : length; 
  }
}