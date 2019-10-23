package com.law.kg.comm;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class RandomUtil {
    public static Random ran = new Random();
    public static SortedSet<Integer> set = new TreeSet();
    public static void randomSet(int n, int m,int bound,int begin) {
        if (begin == 1) {
            set.clear();
            begin = 0;
        }
        for (int i = 0; i < n; i++) {
            set.add(ran.nextInt(bound) + 1);
        }
        if (set.size() < m) {
            randomSet(m - set.size(), m,bound,begin);
        }
    }
}
