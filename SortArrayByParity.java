class Solution {
  public int[] sortArrayByParity(int[] A) {
      int i = 0;
      int j = A.length -1;
      
      while (i < j){
          if (A[i]%2 > A[j]%2){ // modulus of odd number -> 1, modulus of even number -> 0
              int temp = A[i];
              A[i] = A[j];
              A[j] = temp;
          }
          if (A[i]%2 == 0){ // if element is even, increment the boundary
              i++;
          }
          if (A[j]%2 == 1) {
              j--;
          }
      }
      return A;
  }
}