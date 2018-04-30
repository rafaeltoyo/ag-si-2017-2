package algorithm.genetic;

import algorithm.base.Population;

public class GeneticAlgorithm
{

    private GaPopulation population;

    private int generation = 0;

    private int maxGen = -1;

    public GeneticAlgorithm(GaPopulation population) {
        this.population = population;
    }

    public GeneticAlgorithm(GaPopulation population, int maxGen) {
        this(population);
        this.maxGen = maxGen;
    }

    public Chromosome run() throws CloneNotSupportedException
    {
        GaPopulation population;

        // Inicializa População
        population = this.population.clone();

        // Calcula Fitness
        population.evaluation();

        do {

            // Seleciona para reprodução
            population.prepareToEvolve();

            // Reprodução: Cruzamento (crossover simples) e mutação uniforme
            population.crossover();
            population.mutation();

            // Calcula Fitness
            population.evaluation();

            // Nova População = melhores entre pais e filhos
            population.evolve();

            // Incrementa Geração
            this.generation++;

            System.out.println("Generation: " + this.generation);

            // Atingiu condição de Parada?
        } while (!this.stop());

        // Retorna melhor cromossomo
        return population.getBest();
    }

    /**
     * todo indicar se a execução do algoritmo deverá parar
     * @return Stop condition
     */
    protected boolean stop()
    {
        return (this.getMaxGen() >= 0 && this.getMaxGen() <= this.getGeneration());
    }

    public int getGeneration() {
        return generation;
    }

    public int getMaxGen() {
        return maxGen;
    }

    public void setMaxGen(int maxGen) {
        this.maxGen = maxGen;
    }
}
