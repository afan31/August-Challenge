class Solution {
  public boolean isPalindrome(String s) {
    s = s.replaceAll("[^a-zA-Z0-9]", "");
    int i = 0;
    int j = s.length() -1;
    while (i < j){
      if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
}