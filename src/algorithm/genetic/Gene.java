package algorithm.genetic;

import controller.GaController;

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

    public Gene clone() throws CloneNotSupportedException {
        return (Gene) super.clone();
    }

    public Gene rndClone() throws CloneNotSupportedException {
        Gene clone = (Gene) super.clone();
        clone.alelo = GaController.getInstance().getRnd().nextFloat() > 0.5;
        return clone;
    }

    public boolean isActive() { return alelo; }

    public void pick() { this.alelo = true; }

    public void drop() { this.alelo = false; }

    public void toggle() { this.alelo = !this.alelo; }

    public void swap(Gene target) {
        if (this.isActive() != target.isActive()) {
            this.toggle();
            target.toggle();
        }
    }

    abstract protected float getValue();
}
