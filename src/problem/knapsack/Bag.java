package problem.knapsack;

import algorithm.genetic.Chromosome;

import java.util.List;

public class Bag extends Chromosome
{

    private int capacity;

    public Bag(int capacity) {
        this.capacity = capacity;
    }

    public void addItem(BagItem bagItem)
    {
        this.addGene(bagItem);
    }

    public List<BagItem> getItems() { return (List<BagItem>)(List<?>) this.genes; }

    public int getCapacity() { return capacity; }

}
