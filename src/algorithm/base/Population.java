package algorithm.base;

import java.util.ArrayList;
import java.util.List;

public class Population<T> implements Cloneable
{

    protected final List<T> elements = new ArrayList<>();

    public Population() {
    }

    @Override
    public Population<T> clone() throws CloneNotSupportedException { return (Population<T>) super.clone(); }

    public List<T> getElements() { return elements; }

}
