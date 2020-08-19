class Solution {
  public String toGoatLatin(String S) {
      String[] ab = S.split(" ");
      String res  = "";
      int count = 1;
      String suffix = "ma";
      String ans = "";
      for (String s : ab){
          res = "";
          char first = Character.toLowerCase(s.charAt(0));
          if (first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u'){
              res = res.concat(s).concat(suffix);
              res = appendAdditionalSuffix(res, count);
          }else {
              res = s.substring(1).concat(String.valueOf(s.charAt(0))).concat(suffix);
              res = appendAdditionalSuffix(res, count);
          }
          count++;
          ans = ans.concat(res).concat(" ");
      }
      ans= ans.substring(0, ans.length() - 1);
      return ans;
  }

  private String appendAdditionalSuffix(String res, int count) {
      for (int i = 0; i < count; i++){
        res = res.concat("a");
      }
      return res;
  }
}