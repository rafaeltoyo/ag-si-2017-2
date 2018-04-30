package algorithm.genetic;

/**
 * Classe que representa um Gene do AG
 *
 */
abstract public class Gene implements Cloneable
{

    protected boolean alelo;

    public Gene() {
        this.alelo = false;
    }

    public Gene clone() throws CloneNotSupportedException { return (Gene) super.clone(); }

    public boolean isActive() { return alelo; }

    abstract protected float getValue();
}
