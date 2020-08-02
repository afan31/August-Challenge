class Solution {
  public boolean detectCapitalUse(String word) {
      if (word == null || word == ""){
          return false;
      }
      char[] wordArray = word.toCharArray();
      boolean firstCap = checkForUppercase(wordArray[0]);
      int wordLength = word.length();
      int count = 0;
      for(int i = 1; i < wordLength; i++){
          char a = wordArray[i];
          boolean isUppercase = checkForUppercase(a);
          if (isUppercase){
              count++;
          }
      }
      if (count == 0 || (count == wordLength-1 && firstCap)){
          return true;
      }else if (firstCap && count == 0){ 
          return true;
      }
      return false;
  }
  
  boolean checkForUppercase(char a){
    int asciiVal = (int)a;
    // check for ascii range of capital characters
    if (asciiVal >= 65 && asciiVal <= 90){
      return true;
    }
    return false;
  }
}