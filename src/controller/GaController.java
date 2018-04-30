package controller;

import problem.knapsack.Bag;
import problem.knapsack.BagItem;

public class GaController
{

    private static GaController ourInstance = new GaController();

    public static GaController getInstance() {
        return ourInstance;
    }

    private GaController() {

    }

    public static void printBag(Bag bag)
    {
        int id = 0;

        System.out.print("--------------------------------------------------");
        System.out.print("Item list: ");

        for (BagItem item : bag.getItems()) {
            System.out.print("| id: ");
            System.out.print(++id);
            System.out.print("\t | value: ");
            System.out.print(item.getValue());
            System.out.print("\t | weight: ");
            System.out.print(item.getWeight());
            System.out.print("\t | picked? ");
            System.out.print(item.isActive() ? "Yes |" : " No |");
        }

        System.out.print("--------------------------------------------------");


    }

}
