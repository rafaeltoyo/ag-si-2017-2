package service;

import problem.knapsack.BagItem;

import java.util.Comparator;

public class valueComparator implements Comparator<BagItem>
{
    @Override
    public int compare(BagItem o1, BagItem o2) {
        if (o1.getValue() > o2.getValue()) {
            return 1;
        } else {
            if (o1.getValue() == o2.getValue()) {
                return 0;
            }
            return -1;
        }
    }
}
