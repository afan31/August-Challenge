class Solution {
  public int orangesRotting(int[][] grid) {
      Set<String> fresh = new HashSet<>();
      Set<String> rotten = new HashSet<>();
      for (int i=0; i < grid.length; i++){
          for(int j = 0; j < grid[i].length; j++){
              if (grid[i][j] == 1){
                  fresh.add(""+i+j);
              }
              if (grid[i][j] == 2){
                  rotten.add(""+i+j);
              }
          }
      }
      
      int mins = 0;
      int[][] directions = { {0,-1}, {0,1}, {-1,0}, {1,0} };
      while (fresh.size() > 0){
          Set<String> infected = new HashSet<>();
          for (String s : rotten){
              int i = s.charAt(0) - '0';
              int j = s.charAt(1) - '0';
              for (int[] direction : directions){
                  int nextI =  i + direction[0];
                  int nextJ = j + direction[1];
                  String adjacentCord = ""+nextI + nextJ;
                  if (fresh.contains(adjacentCord)){
                      fresh.remove(adjacentCord);
                      infected.add(adjacentCord);
                  }
              }
          }
          if (infected.size() == 0){
              return -1;
          }
          mins++;
          rotten = infected;
      }
      return mins;
  }
}