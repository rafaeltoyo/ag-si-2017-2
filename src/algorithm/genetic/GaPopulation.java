package algorithm.genetic;

import algorithm.base.Population;
import service.fitnessComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    public void eval()
    {
        for (Chromosome chromosome : this.elements) {
            chromosome.calcFitness();
        }
    }

    /**
     * todo Gerar uma copia de N elementos a partir dos elementos atuais utilizando o método da roleta simples
     *
     * Provisório: pega os N melhores
     *
     */
    public GaPopulation children(int N) throws CloneNotSupportedException {
        this.eval();
        Collections.sort(this.elements, Collections.reverseOrder(new fitnessComparator()));

        GaPopulation children = this.clone();
        children.elements = new ArrayList<>(children.elements.subList(0, Math.min(children.elements.size(), N)));

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
