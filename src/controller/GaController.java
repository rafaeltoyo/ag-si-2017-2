package controller;

import problem.knapsack.Bag;
import problem.knapsack.BagItem;

import java.util.Random;

public class GaController
{

    // 1 = Reparar // 2 = Penalizar //
    public int mode = 1;

    private Random rnd;

    private static GaController ourInstance = new GaController();

    public static GaController getInstance() {
        return ourInstance;
    }

    private GaController() {
        rnd = new Random();
    }

    public Random getRnd() {
        return rnd;
    }

    // sorteia um numero no intervalo [inf, sup]
    public int sortearItem(int inf, int sup) {
        int n = sup - inf + 1;
        if (n > 0) {
            return rnd.nextInt(n) + inf;
        } else {  // range not representable as int
            return Math.abs(inf);
        }
    }

    public static void printBag(Bag bag)
    {
        int id = 0;


        OutputController.getInstance().print("------------------------------------------------------------");
        OutputController.getInstance().print("| Item list:                                               |");
        OutputController.getInstance().print("------------------------------------------------------------");

        //System.out.println("------------------------------------------------------------");
        //System.out.println("| Item list:                                               |");
        //System.out.println("------------------------------------------------------------");

        for (BagItem item : bag.getItems()) {
            OutputController.getInstance().print("| id:  ", false);
            OutputController.getInstance().print("" + (++id), false);
            OutputController.getInstance().print("\t | value:  ", false);
            OutputController.getInstance().print("" + item.getValue(), false);
            OutputController.getInstance().print("\t | weight:  ", false);
            OutputController.getInstance().print("" + item.getWeight(), false);
            OutputController.getInstance().print("\t | picked?  ", false);
            OutputController.getInstance().print(item.isActive() ? "Yes |" : " No |");

            //System.out.print("| id:  ");
            //System.out.print(++id);
            //System.out.print("\t | value: ");
            //System.out.print(item.getValue());
            //System.out.print("\t | weight: ");
            //System.out.print(item.getWeight());
            //System.out.print("\t | picked? ");
            //System.out.println(item.isActive() ? "Yes |" : " No |");
        }

        OutputController.getInstance().print("------------------------------------------------------------");
        //System.out.println("------------------------------------------------------------");


    }

}
