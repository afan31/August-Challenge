class Solution {
  public List<Integer> findDuplicates(int[] nums) {
      // [4,3,2,7,8,2,3,1]
    int n = nums.length;
    List<Integer> res = new ArrayList<Integer>();
    for (int i = 0; i < n; i++){
      int pos = Math.abs(nums[i]);
      int num = nums[pos-1];
      if (num < 0){
        res.add(pos);
      } else {
        nums[pos-1] = -num;
      }
    }
    return res;
  }
}