package service;

import algorithm.base.Particle;

import java.util.Comparator;

public class fitnessComparator implements Comparator<Particle>
{
    @Override
    public int compare(Particle o1, Particle o2) {
        if (o1.fitness() > o2.fitness()) {
            return 1;
        } else {
            if (o1.fitness() == o2.fitness()) {
                return 0;
            }
            return -1;
        }
    }
}
