package algorithm.genetic;

import algorithm.base.Population;

import java.util.Collections;

public class GaPopulation extends Population<Chromosome>
{



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
