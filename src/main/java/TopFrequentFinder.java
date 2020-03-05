import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Дан список целых чисел, надо найти k самых часто встречающихся элементов
// и отсортировать их по убыванию количества вхождений в массив.
//5 5 5 5 5 1 1 1 3 3, 2
//5 1
//
//5 5 4 4 5 5
//
//5 5 4 4 1 1, 2
//5 4, 1 4

//CPU
//O(n*log(n))
//
//RAM
//O(n)

public class TopFrequentFinder {

    public List<Integer> topKFrequent(List<Integer> nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (Integer key : nums) {
            Integer val = map.get(key);
            val = val != null ? val : 0;
            map.put(key, val + 1);
        }

        List<Pair<Integer, Integer>> list = new ArrayList<>();

        map.forEach((key, value) ->  list.add(new Pair<>(key, value)) );
        list.sort((a, b) -> b.getKey() - a.getValue());

        List<Integer> retList = new ArrayList<>();

        for (Pair<Integer, Integer> pair : list) {
            retList.add(pair.getKey());
        }

        return retList.subList(0, k);
    }
}
