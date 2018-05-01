package problem.knapsack;

import algorithm.genetic.Chromosome;
import algorithm.genetic.Gene;

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

    @Override
    public float calcFitness() {
        this.fitness = 0;
        for (BagItem item : this.getItems()) {
            if (item.isActive()) {
                this.fitness += item.getValue();
            }
        }
        while(getCurrentBagWeight() > capacity) {
            togglesMaxBagItem();
            this.fitness/= 2;
        }
        // Penaliza
        //if(getCurrentBagWeight() > capacity)
            //this.fitness = 0;
        // corrige

        return this.fitness;
    }

    private void togglesMaxBagItem() {
        // Finds max and its index
        int maxIndex = 0, maxWeight = 0, currentIndex = 0;
        for(BagItem item : this.getItems()){
            if(item.isActive()) {
                if (item.getWeight() >= maxWeight) {
                    maxWeight = item.getWeight();
                    maxIndex = currentIndex;
                }
            }
            currentIndex++;
        }
        getItems().get(maxIndex).toggle();
    }

    private int getCurrentBagWeight() {
        int weight = 0;
        for(BagItem item : this.getItems()){
            if(item.isActive()) {
                weight += item.getWeight();
            }
        }
        return weight;
    }
}
