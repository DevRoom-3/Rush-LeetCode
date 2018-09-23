import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        List<Integer> input = new ArrayList<>();
        for(int i=0; i<4; i++) {
            input.add(in.nextInt());
        }
        int target = input.remove(input.size() - 1);
        int[] array = new int[3];
        int index = 0;
        for(int i : input) {
            array[index] = i;
            index++;
        }
        System.out.println(combinationSum(array, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> queue = new ArrayList<>();
        int result = 0;
        for(int i=0; i<candidates.length; i++) {
            queue.clear();
            result = 0;
            for (int j=i; j<candidates.length; j++) {
                while (result <= target) {
                    queue.add(candidates[j]);
                    result += candidates[j];
                    if (result == target) {
                        ret.add(new ArrayList<>(queue));
                        int removed = queue.remove(queue.size() - 1);
                        int removed2 = queue.remove(queue.size() - 1);
                        result -= removed;
                        result -= removed2;
                        if(removed == removed2) {
                            break;
                        }
                    } else if (result > target) {
                        int removed = queue.remove(queue.size() - 1);
                        int removed2 = -1;
                        result -= removed;
                        if (!queue.isEmpty()) {
                            removed2 = queue.remove(queue.size() - 1);
                            result -= removed2;
                        }
                        if(removed == removed2) {
                            if (queue.size() > 2) {
                                int removed3 = queue.remove(queue.size() - 1);
                                result -= removed3;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return ret;
    }
}
