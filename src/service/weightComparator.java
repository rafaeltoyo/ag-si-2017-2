package service;

import problem.knapsack.BagItem;

import java.util.Comparator;

public class weightComparator implements Comparator<BagItem>
{
    @Override
    public int compare(BagItem o1, BagItem o2) {
        if (o1.getWeight() > o2.getWeight()) {
            return 1;
        } else {
            if (o1.getWeight() == o2.getWeight()) {
                return 0;
            }
            return -1;
        }
    }
}
