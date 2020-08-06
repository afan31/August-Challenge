class WordDictionary {

  /** Initialize your data structure here. */
  class TrieNode {
    TrieNode[] child;
    boolean isEnd;
    //public final int R = 26;

    public TrieNode(){
      child = new TrieNode[26];
    }
  }

  TrieNode root;

  public WordDictionary() {
    root = new TrieNode();
  }
  
  /** Adds a word into the data structure. */
  public void addWord(String word) {
    TrieNode curr = root;
    for (int i = 0; i < word.length(); i++){
      char c = word.charAt(i);
      int index = c - 'a';
      if (curr.child[index] == null){
        TrieNode temp = new TrieNode();
        curr.child[index] = temp;
        curr = temp;
      }else{
        curr = curr.child[index];
      }
    }
    curr.isEnd = true;
  }
  
  /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */

public boolean search(String word) {
  return searchWord(word, 0, root);
}

public boolean searchWord(String word, int index, TrieNode node){
  if (index == word.length()){
    return node.isEnd;
  }
  char c = word.charAt(index);
  if (c == '.'){
    for (TrieNode ch : node.child){
      if (ch != null && searchWord(word, index+1, ch)){
        return true;
      }
    }
    return false;
  } else {
    int idx = c-'a';
    TrieNode ch = node.child[idx];
    if (ch == null){
      return false;
    }
    return searchWord(word, index+1, ch);
  }
}
}


/**
* Your WordDictionary object will be instantiated and called as such:
* WordDictionary obj = new WordDictionary();
* obj.addWord(word);
* boolean param_2 = obj.search(word);
*/