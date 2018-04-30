package problem.knapsack.instance1;

import problem.knapsack.Bag;
import problem.knapsack.BagItem;

public class Bag1 extends Bag
{

    public Bag1() {
        super(39);

        // Items 1 to 14
        this.addItem(new BagItem(3, 1));
        this.addItem(new BagItem(8, 3));
        this.addItem(new BagItem(12, 1));
        this.addItem(new BagItem(2, 8));
        this.addItem(new BagItem(8, 9));
        this.addItem(new BagItem(4, 3));
        this.addItem(new BagItem(4, 2));
        this.addItem(new BagItem(5, 8));
        this.addItem(new BagItem(1, 5));
        this.addItem(new BagItem(1, 1));
        this.addItem(new BagItem(8, 1));
        this.addItem(new BagItem(6, 6));
        this.addItem(new BagItem(4, 3));
        this.addItem(new BagItem(3, 2));

        // Items 15 to 28
        this.addItem(new BagItem(3, 5));
        this.addItem(new BagItem(5, 2));
        this.addItem(new BagItem(7, 3));
        this.addItem(new BagItem(3, 8));
        this.addItem(new BagItem(5, 9));
        this.addItem(new BagItem(7, 3));
        this.addItem(new BagItem(4, 2));
        this.addItem(new BagItem(3, 4));
        this.addItem(new BagItem(7, 5));
        this.addItem(new BagItem(2, 4));
        this.addItem(new BagItem(3, 3));
        this.addItem(new BagItem(5, 1));
        this.addItem(new BagItem(4, 3));
        this.addItem(new BagItem(3, 2));

        // Items 29 to 42
        this.addItem(new BagItem(7, 14));
        this.addItem(new BagItem(19, 32));
        this.addItem(new BagItem(20, 20));
        this.addItem(new BagItem(21, 19));
        this.addItem(new BagItem(11, 15));
        this.addItem(new BagItem(24, 37));
        this.addItem(new BagItem(13, 18));
        this.addItem(new BagItem(17, 13));
        this.addItem(new BagItem(18, 19));
        this.addItem(new BagItem(6, 10));
        this.addItem(new BagItem(15, 15));
        this.addItem(new BagItem(25, 40));
        this.addItem(new BagItem(12, 17));
        this.addItem(new BagItem(19, 39));
    }
}
