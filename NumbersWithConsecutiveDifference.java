class Solution {
    
  List<Integer> al = new ArrayList<Integer>();
  
  public int[] numsSameConsecDiff(int N, int K) {
      if (N == 0){
          return new int[0];
      }
      if (N == 1){
          al.add(0);
      }
      dfs(N,K,0);
      
      return al.stream().mapToInt(i->i).toArray();
  }
  
  private void dfs(int n, int k, int number){
      
      if (n == 0){
          al.add(number);
          return;
      }
      
      for (int i = 0; i < 10; i++){
          if (number == 0 && i == 0){
              continue; // ignore leading zeros
          }else if (number == 0 && i != 0){
              dfs(n-1, k, i); // first digit
          }else if (Math.abs((number%10)- i) == k){
              dfs(n-1, k, (number*10 )+ i);
          }
      } 
  }
}