package service;

import problem.knapsack.BagItem;

import java.util.Comparator;

public class weightComparator implements Comparator<BagItem>
{
    @Override
    public int compare(BagItem o1, BagItem o2) {
        return (o1.getWeight() - o2.getWeight());
    }
}
