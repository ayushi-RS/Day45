class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combos = combinationSum(candidates, target, new HashMap<>());
        return removeDuplicateLists(combos);
    }

    private List<List<Integer>> combinationSum(int[] candidates, int target, Map<Integer, List<List<Integer>>> memo) {
        if (memo.containsKey(target)) {
            return memo.get(target);
        }
        if (target == 0) {
            return new ArrayList<>(Arrays.asList(new ArrayList<>())); // [[]]
        }
        if (target < 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int num : candidates) {
            int newTarget = target - num;
            List<List<Integer>> subWays = combinationSum(candidates, newTarget, memo);

            List<List<Integer>> finalWays = new ArrayList<>();
            // add yourself to the returning ways of children
            for (List<Integer> way : subWays) {
                List<Integer> temp = new ArrayList<>(way);
                temp.add(num);
                finalWays.add(temp);
            }

            result.addAll(finalWays);
        }
        memo.put(target, result);
        return memo.get(target);
    }

    private List<List<Integer>> removeDuplicateLists(List<List<Integer>> lst) {
        for (List<Integer> l : lst) {
            Collections.sort(l);
        }
        return new ArrayList<>(new HashSet<>(lst));
    }
}