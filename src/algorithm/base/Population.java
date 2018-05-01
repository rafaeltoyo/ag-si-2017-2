package algorithm.base;

import java.util.ArrayList;

public class Population<T> implements Cloneable
{

    protected ArrayList<T> elements = new ArrayList<>();

    public Population() {
    }

    @Override
    public Population<T> clone() throws CloneNotSupportedException {
        Population<T> clone = (Population<T>) super.clone();
        return clone;
    }

    public ArrayList<T> getElements() { return elements; }

}
