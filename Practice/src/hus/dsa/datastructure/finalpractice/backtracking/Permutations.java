package hus.dsa.datastructure.finalpractice.backtracking;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
    void permutations(List<List<Integer>> result, int[] array, int index) {
        if (index == array.length) {
            result.add(convertToList(array));
            return;
        }

        for (int i = index; i < array.length; i++) {
            swap(array, index, i);

            permutations(result, array, index + 1);

            swap(array, index, i);
        }

    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();

        permutations(list, nums, 0);

        Set<List<Integer>> set = new LinkedHashSet<>();

        for (int i = 0; i < set.size(); i++) {
            set.add(list.get(i));
        }

        List<List<Integer>> lists = new ArrayList<>();

        lists.addAll(set);

        return lists;
    }

    List<Integer> convertToList(int[] array) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            result.add(array[i]);
        }

        return result;
    }

    void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
