class HashNode {
  int val;
  HashNode next;
  public HashNode(int val){
     this.val = val;
     this.next = next;
  }
}

class MyHashSet {

  List<HashNode> array;
  int size;  

  public MyHashSet() {
    this.array = new ArrayList<>();
    this.size = 0;
    for(int i = 0; i< 10000; i++){
      this.array.add(null);
    }
  }

  public int getIndex(int key){
    return key % this.array.size();
  } 

  public void add(int key) {
    if (!contains(key)){
      HashNode newNode = new HashNode(key);
      int hash = getIndex(key);
      newNode.next = this.array.get(hash);
      this.array.set(hash, newNode);
      this.size++;
    }
  }

  public void remove(int key) {
    if(contains(key)){
      int hash = getIndex(key);
      HashNode prev = null;
      HashNode curr = this.array.get(hash);
      while (curr.val != key){
        prev = curr;
        curr = curr.next;
      }
      if (prev == null){
        this.array.set(hash,curr.next);
      } else{
        prev.next = curr.next;
      }
      this.size--;
    }
  }

  /** Returns true if this set contains the specified element */
  public boolean contains(int key) {
    int hash = getIndex(key);
    HashNode curr = this.array.get(hash);
    while (curr != null && curr.val != key){
      curr = curr.next;
    }
    return curr != null;
  }
}