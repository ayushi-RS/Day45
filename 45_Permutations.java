class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        permute(nums,0,result);
        return result;
    }
    
    private void permute(int[] nums,int i,List<List<Integer>> result){
        if(i==nums.length){
            List<Integer> curr = new ArrayList<>();
            for(int j: nums) curr.add(j);
            result.add(curr);
            return ;
        }
        for(int j=i;j<nums.length;j++){
            swap(nums,i,j);
            permute(nums,i+1,result);
            swap(nums,j,i);
        }
    }
    
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}