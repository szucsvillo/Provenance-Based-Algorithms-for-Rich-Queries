package semirings;

public abstract class AbstractSemiring {
    abstract public float zero();
    abstract public float one();
    abstract public float add(float a, float b);
    //star operation is known as the closure operation.
    abstract public float star(float a);
    abstract public float times(float a, float b);
}
