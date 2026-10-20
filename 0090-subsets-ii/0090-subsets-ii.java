class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(0,result,new ArrayList<>(),nums);
        return result;
    }
    public void backtrack(int start , List<List<Integer>> result, List<Integer>curr , int[]nums){
        result.add(new ArrayList<>(curr));
        for(int i = start; i<nums.length;i++){
            if(i>start && nums[i]== nums[i-1])continue;
            curr.add(nums[i]);
            backtrack(i+1,result,curr,nums);
            curr.remove(curr.size()-1);
        }
    }
}