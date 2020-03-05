// Написать множество, хранящее целые числа, поддерживающее следующие операции:

// 1. добавление значения в множество
// 2. проверка есть ли значение в множестве
// 3. удаление значения из множества
// 4. получение случайного значения из множества.

// Все операции должны работать за  O(1) в среднем.

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class RandomSet {

    Map<Integer, Integer> map = new HashMap<>();


    public RandomSet() {

    }

    public void add(Integer val){
        map.putIfAbsent(val, null);
    }

    public Boolean contains(Integer val){
        return map.containsKey(val);
    }

    public void remove(Integer val){
        map.remove(val);
    }

    public Integer getRandom(){
        Integer size = map.size();
        Set<Integer> keys = map.keySet();

        return map.keySet().iterator().next();
    }

}
