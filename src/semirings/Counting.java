package semirings;

public class Counting extends AbstractSemiring {

    @Override
    public float zero() {
        return Float.POSITIVE_INFINITY;
    }

    @Override
    public float one() {
        return 0;
    }

    @Override
    public float add(float a, float b) {
        return Math.min(a, b);
    }

    @Override
    public float star(float a) {
        return 0;
    }

    @Override
    public float times(float a, float b) {
        return Math.max(a, b);
    }
}
