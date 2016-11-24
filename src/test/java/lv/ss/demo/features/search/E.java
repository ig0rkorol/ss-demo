package lv.ss.demo.features.search;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;
import lv.ss.demo.model.Languages;
import lv.ss.demo.model.SearchOptions;
import lv.ss.demo.model.SubHeading;
import lv.ss.demo.utils.RandomGenerator;

import java.util.*;

/**
 * Created by WWW on 22.11.2016.
 */
public class E {
    public static void main(String[] args) {
       // System.out.println("/kkk/".replaceAll("\\/",""));
       // System.out.println(Languages.valueOf("Russian"));
//        System.out.println(SubHeading.BUY.ordinal());
//        SearchOptions so = new SearchOptions.Builder().word("qwe").priceMin("100").build();
//        System.out.println(so.getMinPrice());
//        System.out.println(so.getWord());
//        int minimum = 1;
//        int maximum = 10;
//        Random rn = new Random();
//        int range = maximum - minimum + 1;
//
//
//        for (int i=1;i<5;i++){
//            int randomNum =  rn.nextInt(range) + minimum;
//            System.out.println(">>" +randomNum);
//        }
        Set<Integer> set = ContiguousSet.create(Range.closed(0, 99), DiscreteDomain.integers());
        List list  = new ArrayList<>(set);
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);

        int totalRowsCount = 10;

        List<Integer> randomRange = RandomGenerator.getRandomNumberInRange(0, totalRowsCount);
        for (int i=0;i<3;i++){
            int rowNumber = randomRange.get(i).intValue();
            System.out.println(rowNumber);
        }
    }
}
