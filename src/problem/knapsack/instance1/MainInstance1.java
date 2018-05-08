package problem.knapsack.instance1;

import algorithm.genetic.Chromosome;
import algorithm.genetic.GaPopulation;
import algorithm.genetic.GeneticAlgorithm;
import controller.GaController;
import controller.OutputController;
import problem.knapsack.Bag;
import problem.knapsack.BagItem;

public class MainInstance1
{

    public static void main(String[] args) throws CloneNotSupportedException {
        OutputController.getInstance().initFile("teste.txt");
        kPopLoopSarado();
        OutputController.getInstance().close();
    }

    public static void mainSucesso(String[] args) throws CloneNotSupportedException {
        OutputController.getInstance().initFile("teste.txt");

        int ct = 0;
        while (++ct < 100) {
            Chromosome chr = kPopLoopSarado();

            // Print taxa sucesso
            OutputController.getInstance().print(ct + "\t" + Float.toString(chr.fitness()));
        }

        OutputController.getInstance().close();
    }

    public static Chromosome kPopLoopSarado() throws CloneNotSupportedException {


        Bag bag = new Bag(113);

        // Items 1 to 14
        bag.addItem(new BagItem(3, 1));     // 1
        bag.addItem(new BagItem(8, 3));     // 2
        bag.addItem(new BagItem(12, 1));    // 3
        bag.addItem(new BagItem(2, 8));     // 4
        bag.addItem(new BagItem(8, 9));     // 5
        bag.addItem(new BagItem(4, 3));     // 6
        bag.addItem(new BagItem(4, 2));     // 7
        bag.addItem(new BagItem(5, 8));     // 8
        bag.addItem(new BagItem(1, 5));     // 9
        bag.addItem(new BagItem(1, 1));     // 10
        bag.addItem(new BagItem(8, 1));     // 11
        bag.addItem(new BagItem(6, 6));     // 12
        bag.addItem(new BagItem(4, 3));     // 13
        bag.addItem(new BagItem(3, 2));     // 14

        // Items 15 to 28
        bag.addItem(new BagItem(3, 5));     // 15
        bag.addItem(new BagItem(5, 2));     // 16
        bag.addItem(new BagItem(7, 3));     // 17
        bag.addItem(new BagItem(3, 8));     // 18
        bag.addItem(new BagItem(5, 9));     // 19
        bag.addItem(new BagItem(7, 3));     // 20
        bag.addItem(new BagItem(4, 2));     // 21
        bag.addItem(new BagItem(3, 4));     // 22
        bag.addItem(new BagItem(7, 5));     // 23
        bag.addItem(new BagItem(2, 4));     // 24
        bag.addItem(new BagItem(3, 3));     // 25
        bag.addItem(new BagItem(5, 1));     // 26
        bag.addItem(new BagItem(4, 3));     // 27
        bag.addItem(new BagItem(3, 2));     // 28

        // Items 29 to 42
        bag.addItem(new BagItem(7, 14));    // 29
        bag.addItem(new BagItem(19, 32));   // 30
        bag.addItem(new BagItem(20, 20));   // 31
        bag.addItem(new BagItem(21, 19));   // 32
        bag.addItem(new BagItem(11, 15));   // 33
        bag.addItem(new BagItem(24, 37));   // 34
        bag.addItem(new BagItem(13, 18));   // 35
        bag.addItem(new BagItem(17, 13));   // 36
        bag.addItem(new BagItem(18, 19));   // 37
        bag.addItem(new BagItem(6, 10));    // 38
        bag.addItem(new BagItem(15, 15));   // 39
        bag.addItem(new BagItem(25, 40));   // 40
        bag.addItem(new BagItem(12, 17));   // 41
        bag.addItem(new BagItem(19, 39));   // 42

        if (OutputController.getInstance().useControle())
            GaController.printBag(bag);

        GaPopulation pop = new GaPopulation();
        for (int i = 0; i < 200; i++) {
            pop.getElements().add(bag.rndClone());
        }


        System.out.println("Initial Population:");
        pop.eval();
        if (OutputController.getInstance().useControle())
            pop.print();
        System.out.println("");

        GeneticAlgorithm algo = new GeneticAlgorithm(pop);
        algo.setMaxGen(500);
        return algo.run();
    }

}
