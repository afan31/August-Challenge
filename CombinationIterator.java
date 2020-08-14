class CombinationIterator {

  List<String> memory = new ArrayList<>();
  String characters;
  public CombinationIterator(String characters, int combinationLength) {
      this.characters = characters;
      helper(combinationLength, new StringBuilder());
  }
  
  private void helper(int len, StringBuilder sb){
      if (len == 0){
          memory.add(sb.toString());
          return;
      }
      for (char ch : characters.toCharArray()){
          if (sb.length() == 0 || sb.charAt(sb.length()-1) < ch){
              StringBuilder temp = new StringBuilder(sb);
              temp.append(ch);
              helper(len-1, temp);
          }
      }
  }
  
  public String next() {
      String res = "";
      if (memory.size() > 0){
         res = memory.get(0);
         memory.remove(0);
      }
      return res;
  }
  
  public boolean hasNext() {
      return memory.size() > 0;
  }
}

/**
* Your CombinationIterator object will be instantiated and called as such:
* CombinationIterator obj = new CombinationIterator(characters, combinationLength);
* String param_1 = obj.next();
* boolean param_2 = obj.hasNext();
*/