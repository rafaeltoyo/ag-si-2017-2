package problem.knapsack;

import algorithm.genetic.Gene;

public class BagItem extends Gene
{

    private int weight;

    private int value;

    /**
     * Classe que representa um item da mochila
     *
     * @param weight Peso do item
     * @param value Valor do item
     */
    public BagItem(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }

    public int getWeight() { return weight; }

    public float getValue() { return (float) value; }

    public void pick() { this.alelo = true; }

    public void drop() { this.alelo = false; }

    public void toggle() { this.alelo = !this.alelo; }

}
