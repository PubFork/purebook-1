package com.purebook.backend.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomList {

    //随机取出指定个数元素
    public static <E> List<E> getRandomList(List<E> paramList, int count) {
        if (paramList.size() < count) {
            return paramList;
        }
        Random random = new Random();
        List<Integer> tempList = new ArrayList<>();
        List<E> newList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            int temp = random.nextInt(paramList.size());
            if (!tempList.contains(temp)) {
                tempList.add(temp);
                newList.add(paramList.get(temp));
            } else {
                i--;
            }
        }
        return newList;
    }
}
