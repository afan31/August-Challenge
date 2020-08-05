class Solution {
  public boolean isPowerOfFour(int num) {
    if (num == 0){
      return false;
    }
    while ((num & 3) == 0){
      num >>= 2;
    }
    return (num == 1);
  }
}