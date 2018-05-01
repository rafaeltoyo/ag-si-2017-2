package algorithm.genetic;

import algorithm.base.Population;
import controller.GaController;
import service.fitnessComparator;

import java.util.ArrayList;
import java.util.Collections;

public class GaPopulation extends Population<Chromosome>
{

    public GaPopulation() {
        super();
    }

    @Override
    public GaPopulation clone() throws CloneNotSupportedException {
        GaPopulation clone = (GaPopulation) super.clone();
        clone.elements = new ArrayList<>();
        for (Chromosome chromosome : this.elements) {
            clone.elements.add(chromosome.clone());
        }
        return clone;
    }

    /**
     * Atualização forçada dos fitness dos cromossos
     */
    public float eval()
    {
        float total = 0;
        for (Chromosome chromosome : this.elements) {
            total += chromosome.calcFitness();
        }
        return total;
    }

    /**
     * Gerar uma copia de N elementos a partir dos elementos atuais utilizando o método da roleta simples
     *
     */
    public GaPopulation children(int N) throws CloneNotSupportedException {
        // Soma total de todos fitness
        double total = this.eval();

        // Ordenar (?)
        Collections.sort(this.elements, Collections.reverseOrder(new fitnessComparator()));

        // Criar a população de filhos
        GaPopulation children = new GaPopulation();

        // Criar N elementos filhos
        N = Math.min(this.elements.size(), N);
        for (int i = 0; i < N; i++) {

            // Sorteio no formato da roleta
            double rouletteTarget = GaController.getInstance().getRnd().nextDouble();
            double rouletteCurrent = 0;

            // Percorrer os elementos para encontrar o sorteado
            for (Chromosome chromosome : this.elements) {
                rouletteCurrent += (chromosome.fitness() / total);
                if (rouletteCurrent > rouletteTarget) {
                    children.getElements().add(chromosome.clone());
                    break;
                }
            }
        }
        return children;
    }

    /**
     * Finalizar o processo de reprodução juntando os filhos com os pais e selecionando os melhores apenas.
     * O Tamanho da população não será alterado.
     *
     */
    public void evolve(GaPopulation children)
    {
        // Salvar o tamanho N da população
        int originalSize = this.elements.size();
        // Juntar os filhos
        this.elements.addAll(0, children.elements);
        // Avaliar todos elementos
        this.eval();
        // Ordenar decrescente
        Collections.sort(this.elements, Collections.reverseOrder(new fitnessComparator()));
        // Pegar os N melhores indivíduos para constituir a nova população
        this.elements = new ArrayList<>(this.elements.subList(0, originalSize));
    }

    /**
     * todo Retornar melhor elemento
     *
     */
    public Chromosome getBest()
    {
        return this.elements.get(0);
    }

    public void print()
    {
        int ct = 0;
        System.out.println("population[size = " + this.elements.size() + "] : ");
        for (Chromosome chromosome : this.elements) {
            System.out.print("Chromosome " + ++ct + ": \t");
            chromosome.print();
            System.out.println("");
        }
    }

}
