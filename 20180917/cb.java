import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> results = new Solution().combinationSum(candidates, target);
        System.out.println(results);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results = new ArrayList<>();
        int[] newCandidates = Arrays.copyOf(candidates, candidates.length);
        Arrays.sort(newCandidates);

        List<Integer> result = new ArrayList<>();
        setCombinationSum(newCandidates, target, results, result, 0);

        return results;
    }

    private void setCombinationSum(int[] newCandidates, int target, List<List<Integer>> results, List<Integer> result, int seq) {
        if (target == 0) {
            results.add(new ArrayList<>(result));
            return;
        }

        for (int i = seq; i < newCandidates.length; i++) {
            if (target < newCandidates[i]) {
                break;
            }

            result.add(newCandidates[i]);
            setCombinationSum(newCandidates, target - newCandidates[i], results, result, i);
            result.remove(result.size() - 1);
        }
    }
}