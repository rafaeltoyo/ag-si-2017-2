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

    private float fitness;

    public Chromosome clone() throws CloneNotSupportedException { return (Chromosome) super.clone(); }

    protected void addGene(Gene gene) { this.genes.add(gene); }

    public List<Gene> getGenes() { return genes; }

    public float calcFitness() {
        this.fitness = 0;
        for (Gene gene : this.genes) {
            if (gene.isActive()) {
                this.fitness += gene.getValue();
            }
        }
        return this.fitness;
    }

    @Override
    public float fitness() {
        if (fitness == 0) {
            return calcFitness();
        }
        return fitness;
    }

    @Override
    public int compareTo(Chromosome o) {
        return (int) (this.fitness() - o.fitness());
    }
}
