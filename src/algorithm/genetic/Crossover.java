package algorithm.genetic;

import algorithm.base.Operator;
import controller.GaController;

public class Crossover implements Operator
{

    public static final float MUTATION_FACT = 0.05f;

    protected GaPopulation population;

    public Crossover(GaPopulation population) {
        this.population = population;
    }

    @Override
    public void exec() {

        for (int i = 0; i < this.population.getElements().size() - 1; i+=2) {

            Chromosome father = this.population.getElements().get(i);
            Chromosome mother = this.population.getElements().get(i + 1);

            int limit = GaController.getInstance().sortearItem(1, father.getGenes().size());

            for (int j = 0; j < father.getGenes().size(); j++) {

                // Mutação do pai
                if (GaController.getInstance().getRnd().nextFloat() < MUTATION_FACT) {
                    father.getGenes().get(j).toggle();
                }

                // Mutação da mãe
                if (GaController.getInstance().getRnd().nextFloat() < MUTATION_FACT) {
                    mother.getGenes().get(j).toggle();
                }

                // Limite do crossover
                if (i >= limit) {
                    continue;
                }

                // Crossover
                father.getGenes().get(j).swap(mother.getGenes().get(j));
            }

        }

    }
}
