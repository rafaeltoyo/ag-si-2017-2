package service;

import problem.knapsack.BagItem;

import java.util.Comparator;

public class valueComparator implements Comparator<BagItem>
{
    @Override
    public int compare(BagItem o1, BagItem o2) {
        return (int) (o1.getValue() - o2.getValue());
    }
}
