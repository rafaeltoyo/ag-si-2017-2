package algorithm.genetic;

import algorithm.base.Particle;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa um cromossomo (conjunto de genes) do AG
 *
 */
abstract public class Chromosome implements Particle, Cloneable, Comparable<Chromosome>
{

    protected final List<Gene> genes = new ArrayList<>();

    public Chromosome clone() throws CloneNotSupportedException { return (Chromosome) super.clone(); }

    protected void addGene(Gene gene) { this.genes.add(gene); }

    @Override
    public float fitness() {
        float value = 0;
        for (Gene gene : this.genes) {
            if (gene.isActive()) {
                value += gene.getValue();
            }
        }
        return value;
    }

    @Override
    public int compareTo(Chromosome o) {
        return (int) (this.fitness() - o.fitness());
    }
}
