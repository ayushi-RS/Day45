class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] arr, int target) {

    
        res = new ArrayList<>();
        Arrays.sort(arr);
        backtrack(0, arr, target, 0, new ArrayList<>());
        return res;
    }
    public void backtrack(int sum, int[] arr, int target, int i, List<Integer> list){
        if(sum>target)return;
    
        if(sum==target){
    
             res.add(new ArrayList<>(list));
        
          return;
        }
        for(int j = i;j<arr.length;j++){
             if( j> i && arr[j] == arr[j-1] ) {
                continue;
             }
              list.add(arr[j]);
         
          
              backtrack(sum+arr[j], arr, target, j+1, list);
            
              list.remove(list.size()-1);

            }
         
        }
       
  }