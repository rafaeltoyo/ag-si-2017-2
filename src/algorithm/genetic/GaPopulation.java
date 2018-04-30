package algorithm.genetic;

import algorithm.base.Population;
import service.fitnessComparator;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class GaPopulation extends Population<Chromosome>
{

    public static final float MUTATION_FACT = 0.05f;

    public GaPopulation() {
        super();
    }

    @Override
    public GaPopulation clone() throws CloneNotSupportedException { return (GaPopulation) super.clone(); }

    /**
     * todo Avaliar os fitness da população
     *
     */
    public void evaluation()
    {

    }

    /**
     * todo Preparar a população para reprodução
     *
     */
    public void prepareToEvolve()
    {

    }

    /**
     * todo Evoluir populacao
     *
     */
    public void crossover()
    {
        // Ordenar
        Collections.sort(this.elements);
        // Eliminar os piores

        // Reordenar

        // Permutar genes em pares de cromossomos
    }

    /**
     * todo Realizar a mutação na população
     *
     */
    public void mutation()
    {

    }

    /**
     * todo Finalizar o processo de reprodução
     *
     */
    public void evolve()
    {

    }

    /**
     * todo Retornar melhor elemento
     *
     */
    public Chromosome getBest()
    {
        return this.elements.get(0);
    }

}
