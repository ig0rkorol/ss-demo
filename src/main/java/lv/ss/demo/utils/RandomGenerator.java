package lv.ss.demo.utils;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;

import java.util.*;

/**
 * Created by ikorol on 24.11.2016.
 */
public class RandomGenerator {
    public static List<Integer> getRandomNumberInRange(int min, int max) {
        Set<Integer> set = ContiguousSet.create(Range.closed(min, max), DiscreteDomain.integers());
        List list = new ArrayList<Integer>(set);
        Collections.shuffle(list);
        return list;
    }
}
