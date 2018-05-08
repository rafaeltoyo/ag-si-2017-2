package problem.knapsack;

import algorithm.genetic.Chromosome;
import algorithm.genetic.Gene;
import controller.GaController;
import controller.OutputController;
import service.valueComparator;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;

public class Bag extends Chromosome
{

    private int capacity;

    private int weight = 0;

    public Bag(int capacity) {
        this.capacity = capacity;
    }

    public Bag rndClone() throws CloneNotSupportedException {
        Bag clone = (Bag) super.rndClone();
        clone.fixBag();
        return clone;
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
            if (GaController.getInstance().mode == 1) {
                // Reparar
                fixBag();
            } else {
                // Penalizar
                this.fitness /= 6;
            }
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
        OutputController.getInstance().print(this.fitness + ", " + this.weight + " - |", false);
        //System.out.print(this.fitness + " - |");
        for (Gene gene : this.genes) {
            OutputController.getInstance().print(gene.isActive() ? "1|" : "0|", false);
            //System.out.print(gene.isActive() ? "1|" : "0|");
        }
    }

    public void fixBag() {
        fixBagRandom();
    }

    /**
     * Retirar itens aleatórios
     */
    protected void fixBagRandom() {
        // Calcular o peso da mochila
        Random randomNumber = new Random();
        int randomPosition = randomNumber.nextInt(this.getItems().size());
        // Se ultrapassar o limite ...
        while ( calcWeight() > this.capacity) {
            // Ordenar por valor os itens (crescente)
            while(!(this.getItems().get(randomPosition).isActive()))
                randomPosition = randomNumber.nextInt(this.getItems().size());
            this.getItems().get(randomPosition).drop();
            this.fitness -= this.getItems().get(randomPosition).getValue();
        }
    }

    /**
     * Retirar os itens de menor valor - introduz vies
     */
    protected void fixBagLeastValuable() {
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
                    this.fitness -= item.getValue();
                }
                // Peso já está correto?
                if (weight <= this.capacity) {
                    break;
                }
            }
        }
    }
}
