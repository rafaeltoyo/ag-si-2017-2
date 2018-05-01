package algorithm.genetic;

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
        // População 'D'
        GaPopulation children;

        // Calcula Fitness
        this.population.eval();

        do {

            // Seleciona para reprodução
            children = this.population.children((int) (this.population.getElements().size() * 0.8));

            // Reprodução: Cruzamento (crossover simples) e mutação uniforme
            (new Crossover(children)).exec();

            // Calcula Fitness
            children.eval();

            // Nova População = melhores entre pais e filhos
            this.population.evolve(children);

            // Incrementa Geração
            this.generation++;

            // PRINT @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
            System.out.println("Generation: " + this.generation);
            this.population.print();
            System.out.println("");

            // Atingiu condição de Parada?
        } while (!this.stop());

        // Retorna melhor cromossomo
        return this.population.getBest().clone();
    }

    /**
     * todo indicar se a execução do algoritmo deverá parar
     * @return Stop condition
     */
    protected boolean stop()
    {
        return (this.getMaxGen() >= 0 && this.getMaxGen() <= this.getGeneration());
    }

    public int getGeneration() { return generation; }

    public int getMaxGen() { return maxGen; }

    public void setMaxGen(int maxGen) { this.maxGen = maxGen; }
}
