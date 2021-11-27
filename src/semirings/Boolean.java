package semirings;

public class Boolean extends AbstractSemiring {

    @Override
    public float zero() {
        return 0;
    }

    @Override
    public float one() {
        return 1;
    }

    @Override
    public float add(float a, float b) {
        return Math.max(a, b);
    }

    @Override
    public float star(float a) {
        return 0;
    }

    @Override
    public float times(float a, float b) {
        return Math.min(a, b);
    }
}
