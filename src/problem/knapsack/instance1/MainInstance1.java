package problem.knapsack.instance1;

import algorithm.genetic.GaPopulation;
import algorithm.genetic.GeneticAlgorithm;
import problem.knapsack.Bag;
import problem.knapsack.BagItem;

public class MainInstance1
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws CloneNotSupportedException {
        Bag bag = new Bag(39);

        // Items 1 to 14
        bag.addItem(new BagItem(3, 1));
        bag.addItem(new BagItem(8, 3));
        bag.addItem(new BagItem(12, 1));
        bag.addItem(new BagItem(2, 8));
        bag.addItem(new BagItem(8, 9));
        bag.addItem(new BagItem(4, 3));
        bag.addItem(new BagItem(4, 2));
        bag.addItem(new BagItem(5, 8));
        bag.addItem(new BagItem(1, 5));
        bag.addItem(new BagItem(1, 1));
        bag.addItem(new BagItem(8, 1));
        bag.addItem(new BagItem(6, 6));
        bag.addItem(new BagItem(4, 3));
        bag.addItem(new BagItem(3, 2));

        // Items 15 to 28
        bag.addItem(new BagItem(3, 5));
        bag.addItem(new BagItem(5, 2));
        bag.addItem(new BagItem(7, 3));
        bag.addItem(new BagItem(3, 8));
        bag.addItem(new BagItem(5, 9));
        bag.addItem(new BagItem(7, 3));
        bag.addItem(new BagItem(4, 2));
        bag.addItem(new BagItem(3, 4));
        bag.addItem(new BagItem(7, 5));
        bag.addItem(new BagItem(2, 4));
        bag.addItem(new BagItem(3, 3));
        bag.addItem(new BagItem(5, 1));
        bag.addItem(new BagItem(4, 3));
        bag.addItem(new BagItem(3, 2));

        // Items 29 to 42
        bag.addItem(new BagItem(7, 14));
        bag.addItem(new BagItem(19, 32));
        bag.addItem(new BagItem(20, 20));
        bag.addItem(new BagItem(21, 19));
        bag.addItem(new BagItem(11, 15));
        bag.addItem(new BagItem(24, 37));
        bag.addItem(new BagItem(13, 18));
        bag.addItem(new BagItem(17, 13));
        bag.addItem(new BagItem(18, 19));
        bag.addItem(new BagItem(6, 10));
        bag.addItem(new BagItem(15, 15));
        bag.addItem(new BagItem(25, 40));
        bag.addItem(new BagItem(12, 17));
        bag.addItem(new BagItem(19, 39));

        GaPopulation pop = new GaPopulation();
        pop.getElements().add(bag.clone());
        pop.getElements().add(bag.clone());
        pop.getElements().add(bag.clone());
        pop.getElements().add(bag.clone());
        pop.getElements().add(bag.clone());
        pop.getElements().add(bag.clone());
        pop.getElements().add(bag.clone());
        pop.getElements().add(bag.clone());

        GeneticAlgorithm algo = new GeneticAlgorithm(pop);
        algo.setMaxGen(1000);
        algo.run();
    }

}
