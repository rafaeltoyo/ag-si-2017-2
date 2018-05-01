package problem.knapsack;

import algorithm.genetic.Chromosome;
import algorithm.genetic.Gene;
import service.fitnessComparator;
import service.valueComparator;
import service.weightComparator;

import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Bag extends Chromosome
{

    private int capacity;

    private int weight = 0;

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
        if (calcWeight() > capacity) {
            this.fitness /= 6;
        }

        return this.fitness;
    }

    public float weight() {
        if (weight == 0) {
            return calcWeight();
        }
        return weight;
    }

    public float calcWeight() {
        weight = 0;
        for (BagItem item : this.getItems()) {
            if (item.isActive()) {
                weight += item.getWeight();
            }
        }
        return weight;
    }

    @Override
    public void print() {
        System.out.print(this.fitness + " - |");
        for (Gene gene : this.genes) {
            System.out.print(gene.isActive() ? "1|" : "0|");
        }
    }

    public void fixBag() {
        // Calcular o peso da mochila
        float weight = calcWeight();
        // Se ultrapassar o limite ...
        if (weight > this.capacity) {
            // Ordenar por valor os itens (crescente)
            PriorityQueue<BagItem> rank = new PriorityQueue<>(new valueComparator());
            rank.addAll(this.getItems());

            // Retirar os itens menos valiosos até a mochila estar de acordo com sua capacidade
            for (BagItem item : rank) {
                // Item tem que estar na mochila
                if (item.isActive()) {
                    // Retirar o item
                    item.drop();
                    // Atualizar o peso
                    weight -= item.getWeight();
                }
                // Peso já está correto?
                if (weight <= this.capacity) {
                    break;
                }
            }
        }
    }
}
